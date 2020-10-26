// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3.internal.cache;

import okio.Source;
import okhttp3.internal.platform.Platform;
import javax.annotation.Nullable;
import okio.BufferedSource;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileNotFoundException;
import okio.Sink;
import okio.Okio;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.internal.Util;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import okio.BufferedSink;
import okhttp3.internal.io.FileSystem;
import java.util.concurrent.Executor;
import java.io.File;
import java.util.regex.Pattern;
import java.io.Flushable;
import java.io.Closeable;

public final class DiskLruCache implements Closeable, Flushable
{
    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable;
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, DiskLruCache.DiskLruCache$Entry> lruEntries;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    int redundantOpCount;
    private long size;
    final int valueCount;
    
    static {
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    }
    
    DiskLruCache(final FileSystem fileSystem, final File file, final int appVersion, final int valueCount, final long maxSize, final Executor executor) {
        this.size = 0L;
        this.lruEntries = new LinkedHashMap<String, DiskLruCache.DiskLruCache$Entry>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.cleanupRunnable = (Runnable)new DiskLruCache$1(this);
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = appVersion;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = valueCount;
        this.maxSize = maxSize;
        this.executor = executor;
    }
    
    private void checkNotClosed() {
        synchronized (this) {
            if (this.isClosed()) {
                throw new IllegalStateException("cache is closed");
            }
        }
    }
    // monitorexit(this)
    
    public static DiskLruCache create(final FileSystem fileSystem, final File file, final int n, final int n2, final long n3) {
        if (n3 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new DiskLruCache(fileSystem, file, n, n2, n3, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory("OkHttp DiskLruCache", true)));
    }
    
    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink)new DiskLruCache$2(this, this.fileSystem.appendingSink(this.journalFile)));
    }
    
    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        final Iterator<DiskLruCache.DiskLruCache$Entry> iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            final DiskLruCache.DiskLruCache$Entry diskLruCache$Entry = iterator.next();
            if (diskLruCache$Entry.currentEditor == null) {
                for (int i = 0; i < this.valueCount; ++i) {
                    this.size += diskLruCache$Entry.lengths[i];
                }
            }
            else {
                diskLruCache$Entry.currentEditor = null;
                for (int j = 0; j < this.valueCount; ++j) {
                    this.fileSystem.delete(diskLruCache$Entry.cleanFiles[j]);
                    this.fileSystem.delete(diskLruCache$Entry.dirtyFiles[j]);
                }
                iterator.remove();
            }
        }
    }
    
    private void readJournal() throws IOException {
        final BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            final String utf8LineStrict = buffer.readUtf8LineStrict();
            final String utf8LineStrict2 = buffer.readUtf8LineStrict();
            final String utf8LineStrict3 = buffer.readUtf8LineStrict();
            final String utf8LineStrict4 = buffer.readUtf8LineStrict();
            final String utf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Integer.toString(this.appVersion).equals(utf8LineStrict3) || !Integer.toString(this.valueCount).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
        }
        finally {
            Util.closeQuietly((Closeable)buffer);
        }
        int n = 0;
        try {
            while (true) {
                this.readJournalLine(buffer.readUtf8LineStrict());
                ++n;
            }
        }
        catch (EOFException ex) {
            this.redundantOpCount = n - this.lruEntries.size();
            if (!buffer.exhausted()) {
                this.rebuildJournal();
            }
            else {
                this.journalWriter = this.newJournalWriter();
            }
            Util.closeQuietly((Closeable)buffer);
        }
    }
    
    private void readJournalLine(final String s) throws IOException {
        final int index = s.indexOf(32);
        if (index == -1) {
            throw new IOException("unexpected journal line: " + s);
        }
        final int beginIndex = index + 1;
        final int index2 = s.indexOf(32, beginIndex);
        String s2 = null;
        Label_0112: {
            if (index2 != -1) {
                s2 = s.substring(beginIndex, index2);
                break Label_0112;
            }
            final String key = s2 = s.substring(beginIndex);
            if (index != "REMOVE".length()) {
                break Label_0112;
            }
            s2 = key;
            if (!s.startsWith("REMOVE")) {
                break Label_0112;
            }
            this.lruEntries.remove(key);
            return;
        }
        DiskLruCache.DiskLruCache$Entry value;
        if ((value = this.lruEntries.get(s2)) == null) {
            value = new DiskLruCache.DiskLruCache$Entry(this, s2);
            this.lruEntries.put(s2, value);
        }
        if (index2 != -1 && index == "CLEAN".length() && s.startsWith("CLEAN")) {
            final String[] split = s.substring(index2 + 1).split(" ");
            value.readable = true;
            value.currentEditor = null;
            value.setLengths(split);
            return;
        }
        if (index2 == -1 && index == "DIRTY".length() && s.startsWith("DIRTY")) {
            value.currentEditor = new DiskLruCache$Editor(this, value);
            return;
        }
        if (index2 != -1 || index != "READ".length() || !s.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + s);
        }
    }
    
    private void validateKey(final String s) {
        if (!DiskLruCache.LEGAL_KEY_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + s + "\"");
        }
    }
    
    @Override
    public void close() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        okhttp3/internal/cache/DiskLruCache.initialized:Z
        //     6: ifeq            16
        //     9: aload_0        
        //    10: getfield        okhttp3/internal/cache/DiskLruCache.closed:Z
        //    13: ifeq            24
        //    16: aload_0        
        //    17: iconst_1       
        //    18: putfield        okhttp3/internal/cache/DiskLruCache.closed:Z
        //    21: aload_0        
        //    22: monitorexit    
        //    23: return         
        //    24: aload_0        
        //    25: getfield        okhttp3/internal/cache/DiskLruCache.lruEntries:Ljava/util/LinkedHashMap;
        //    28: invokevirtual   java/util/LinkedHashMap.values:()Ljava/util/Collection;
        //    31: aload_0        
        //    32: getfield        okhttp3/internal/cache/DiskLruCache.lruEntries:Ljava/util/LinkedHashMap;
        //    35: invokevirtual   java/util/LinkedHashMap.size:()I
        //    38: anewarray       Lokhttp3/internal/cache/DiskLruCache$Entry;
        //    41: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //    46: checkcast       [Lokhttp3/internal/cache/DiskLruCache$Entry;
        //    49: astore_3       
        //    50: aload_3        
        //    51: arraylength    
        //    52: istore_2       
        //    53: iconst_0       
        //    54: istore_1       
        //    55: iload_1        
        //    56: iload_2        
        //    57: if_icmpge       84
        //    60: aload_3        
        //    61: iload_1        
        //    62: aaload         
        //    63: astore          4
        //    65: aload           4
        //    67: getfield        okhttp3/internal/cache/DiskLruCache$Entry.currentEditor:Lokhttp3/internal/cache/DiskLruCache$Editor;
        //    70: ifnull          115
        //    73: aload           4
        //    75: getfield        okhttp3/internal/cache/DiskLruCache$Entry.currentEditor:Lokhttp3/internal/cache/DiskLruCache$Editor;
        //    78: invokevirtual   okhttp3/internal/cache/DiskLruCache$Editor.abort:()V
        //    81: goto            115
        //    84: aload_0        
        //    85: invokevirtual   okhttp3/internal/cache/DiskLruCache.trimToSize:()V
        //    88: aload_0        
        //    89: getfield        okhttp3/internal/cache/DiskLruCache.journalWriter:Lokio/BufferedSink;
        //    92: invokeinterface okio/BufferedSink.close:()V
        //    97: aload_0        
        //    98: aconst_null    
        //    99: putfield        okhttp3/internal/cache/DiskLruCache.journalWriter:Lokio/BufferedSink;
        //   102: aload_0        
        //   103: iconst_1       
        //   104: putfield        okhttp3/internal/cache/DiskLruCache.closed:Z
        //   107: goto            21
        //   110: astore_3       
        //   111: aload_0        
        //   112: monitorexit    
        //   113: aload_3        
        //   114: athrow         
        //   115: iload_1        
        //   116: iconst_1       
        //   117: iadd           
        //   118: istore_1       
        //   119: goto            55
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      16     110    115    Any
        //  16     21     110    115    Any
        //  24     53     110    115    Any
        //  65     81     110    115    Any
        //  84     107    110    115    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    void completeEdit(final DiskLruCache$Editor diskLruCache$Editor, final boolean b) throws IOException {
        final DiskLruCache.DiskLruCache$Entry entry;
        synchronized (this) {
            entry = diskLruCache$Editor.entry;
            if (entry.currentEditor != diskLruCache$Editor) {
                throw new IllegalStateException();
            }
        }
    Label_0116:
        while (true) {
            if (b && !entry.readable) {
                for (int i = 0; i < this.valueCount; ++i) {
                    final DiskLruCache$Editor diskLruCache$Editor2;
                    if (!diskLruCache$Editor2.written[i]) {
                        diskLruCache$Editor2.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                        diskLruCache$Editor2.abort();
                        break Label_0116;
                    }
                }
            }
            Label_0126: {
                break Label_0126;
                return;
            }
            for (int j = 0; j < this.valueCount; ++j) {
                final File file = entry.dirtyFiles[j];
                if (b) {
                    if (this.fileSystem.exists(file)) {
                        final File file2 = entry.cleanFiles[j];
                        this.fileSystem.rename(file, file2);
                        final long n = entry.lengths[j];
                        final long size = this.fileSystem.size(file2);
                        entry.lengths[j] = size;
                        this.size = this.size - n + size;
                    }
                }
                else {
                    this.fileSystem.delete(file);
                }
            }
            ++this.redundantOpCount;
            entry.currentEditor = null;
            if (entry.readable | b) {
                entry.readable = true;
                this.journalWriter.writeUtf8("CLEAN").writeByte(32);
                this.journalWriter.writeUtf8(entry.key);
                entry.writeLengths(this.journalWriter);
                this.journalWriter.writeByte(10);
                if (b) {
                    final long nextSequenceNumber = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1L + nextSequenceNumber;
                    entry.sequenceNumber = nextSequenceNumber;
                }
            }
            else {
                this.lruEntries.remove(entry.key);
                this.journalWriter.writeUtf8("REMOVE").writeByte(32);
                this.journalWriter.writeUtf8(entry.key);
                this.journalWriter.writeByte(10);
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || this.journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            continue Label_0116;
        }
    }
    // monitorexit(this)
    
    public void delete() throws IOException {
        this.close();
        this.fileSystem.deleteContents(this.directory);
    }
    
    @Nullable
    public DiskLruCache$Editor edit(final String s) throws IOException {
        return this.edit(s, -1L);
    }
    
    DiskLruCache$Editor edit(final String key, final long n) throws IOException {
        while (true) {
            final DiskLruCache$Editor diskLruCache$Editor = null;
            final DiskLruCache.DiskLruCache$Entry diskLruCache$Entry;
            synchronized (this) {
                this.initialize();
                this.checkNotClosed();
                this.validateKey(key);
                diskLruCache$Entry = this.lruEntries.get(key);
                Label_0071: {
                    if (n == -1L) {
                        break Label_0071;
                    }
                    DiskLruCache$Editor diskLruCache$Editor2 = diskLruCache$Editor;
                    if (diskLruCache$Entry != null) {
                        if (diskLruCache$Entry.sequenceNumber == n) {
                            break Label_0071;
                        }
                        diskLruCache$Editor2 = diskLruCache$Editor;
                    }
                    return diskLruCache$Editor2;
                }
                if (diskLruCache$Entry != null) {
                    final DiskLruCache$Editor diskLruCache$Editor2 = diskLruCache$Editor;
                    if (diskLruCache$Entry.currentEditor != null) {
                        return diskLruCache$Editor2;
                    }
                }
                if (this.mostRecentTrimFailed || this.mostRecentRebuildFailed) {
                    this.executor.execute(this.cleanupRunnable);
                    return diskLruCache$Editor;
                }
            }
            final String key2;
            this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(key2).writeByte(10);
            this.journalWriter.flush();
            DiskLruCache$Editor diskLruCache$Editor2 = diskLruCache$Editor;
            if (!this.hasJournalErrors) {
                DiskLruCache.DiskLruCache$Entry value;
                if ((value = diskLruCache$Entry) == null) {
                    value = new DiskLruCache.DiskLruCache$Entry(this, key2);
                    this.lruEntries.put(key2, value);
                }
                final DiskLruCache$Editor currentEditor = new DiskLruCache$Editor(this, value);
                value.currentEditor = currentEditor;
                diskLruCache$Editor2 = currentEditor;
                return diskLruCache$Editor2;
            }
            return diskLruCache$Editor2;
        }
    }
    
    public void evictAll() throws IOException {
        int i = 0;
        synchronized (this) {
            this.initialize();
            for (DiskLruCache.DiskLruCache$Entry[] array = this.lruEntries.values().toArray(new DiskLruCache.DiskLruCache$Entry[this.lruEntries.size()]); i < array.length; ++i) {
                this.removeEntry(array[i]);
            }
            this.mostRecentTrimFailed = false;
        }
    }
    
    @Override
    public void flush() throws IOException {
        synchronized (this) {
            if (this.initialized) {
                this.checkNotClosed();
                this.trimToSize();
                this.journalWriter.flush();
            }
        }
    }
    
    public Snapshot get(final String key) throws IOException {
        synchronized (this) {
            this.initialize();
            this.checkNotClosed();
            this.validateKey(key);
            final DiskLruCache.DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(key);
            Snapshot snapshot;
            if (diskLruCache$Entry == null || !diskLruCache$Entry.readable) {
                snapshot = null;
            }
            else {
                final Snapshot snapshot2 = diskLruCache$Entry.snapshot();
                if (snapshot2 == null) {
                    snapshot = null;
                }
                else {
                    ++this.redundantOpCount;
                    this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(key).writeByte(10);
                    snapshot = snapshot2;
                    if (this.journalRebuildRequired()) {
                        this.executor.execute(this.cleanupRunnable);
                        snapshot = snapshot2;
                    }
                }
            }
            return snapshot;
        }
    }
    
    public File getDirectory() {
        return this.directory;
    }
    
    public long getMaxSize() {
        synchronized (this) {
            return this.maxSize;
        }
    }
    
    public void initialize() throws IOException {
        synchronized (this) {
            assert Thread.holdsLock(this);
        }
        Label_0037: {
            if (!this.initialized) {
                Label_0191: {
                    if (this.fileSystem.exists(this.journalFileBackup)) {
                        if (!this.fileSystem.exists(this.journalFile)) {
                            break Label_0191;
                        }
                        this.fileSystem.delete(this.journalFileBackup);
                    }
                    Label_0179: {
                        if (!this.fileSystem.exists(this.journalFile)) {
                            break Label_0179;
                        }
                        try {
                            this.readJournal();
                            this.processJournal();
                            this.initialized = true;
                        }
                        catch (IOException ex) {
                            Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + ex.getMessage() + ", removing", (Throwable)ex);
                            try {
                                this.delete();
                                this.closed = false;
                                this.rebuildJournal();
                                this.initialized = true;
                                break Label_0037;
                                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                            }
                            finally {
                                this.closed = false;
                            }
                        }
                    }
                }
            }
        }
    }
    // monitorexit(this)
    
    public boolean isClosed() {
        synchronized (this) {
            return this.closed;
        }
    }
    
    boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }
    
    void rebuildJournal() throws IOException {
        BufferedSink buffer;
        while (true) {
            while (true) {
                DiskLruCache.DiskLruCache$Entry diskLruCache$Entry = null;
                synchronized (this) {
                    if (this.journalWriter != null) {
                        this.journalWriter.close();
                    }
                    buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
                    try {
                        buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                        buffer.writeUtf8("1").writeByte(10);
                        buffer.writeDecimalLong((long)this.appVersion).writeByte(10);
                        buffer.writeDecimalLong((long)this.valueCount).writeByte(10);
                        buffer.writeByte(10);
                        final Iterator<DiskLruCache.DiskLruCache$Entry> iterator = this.lruEntries.values().iterator();
                        while (iterator.hasNext()) {
                            diskLruCache$Entry = iterator.next();
                            if (diskLruCache$Entry.currentEditor == null) {
                                break;
                            }
                            buffer.writeUtf8("DIRTY").writeByte(32);
                            buffer.writeUtf8(diskLruCache$Entry.key);
                            buffer.writeByte(10);
                        }
                    }
                    finally {
                        buffer.close();
                    }
                }
                buffer.writeUtf8("CLEAN").writeByte(32);
                buffer.writeUtf8(diskLruCache$Entry.key);
                diskLruCache$Entry.writeLengths(buffer);
                buffer.writeByte(10);
                continue;
            }
        }
        buffer.close();
        if (this.fileSystem.exists(this.journalFile)) {
            this.fileSystem.rename(this.journalFile, this.journalFileBackup);
        }
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);
        this.fileSystem.delete(this.journalFileBackup);
        this.journalWriter = this.newJournalWriter();
        this.hasJournalErrors = false;
        this.mostRecentRebuildFailed = false;
    }
    // monitorexit(this)
    
    public boolean remove(final String key) throws IOException {
        boolean b = false;
        synchronized (this) {
            this.initialize();
            this.checkNotClosed();
            this.validateKey(key);
            final DiskLruCache.DiskLruCache$Entry diskLruCache$Entry = this.lruEntries.get(key);
            if (diskLruCache$Entry != null) {
                final boolean removeEntry = this.removeEntry(diskLruCache$Entry);
                if (b = removeEntry) {
                    b = removeEntry;
                    if (this.size <= this.maxSize) {
                        this.mostRecentTrimFailed = false;
                        b = removeEntry;
                    }
                }
            }
            return b;
        }
    }
    
    boolean removeEntry(final DiskLruCache.DiskLruCache$Entry diskLruCache$Entry) throws IOException {
        if (diskLruCache$Entry.currentEditor != null) {
            diskLruCache$Entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; ++i) {
            this.fileSystem.delete(diskLruCache$Entry.cleanFiles[i]);
            this.size -= diskLruCache$Entry.lengths[i];
            diskLruCache$Entry.lengths[i] = 0L;
        }
        ++this.redundantOpCount;
        this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(diskLruCache$Entry.key).writeByte(10);
        this.lruEntries.remove(diskLruCache$Entry.key);
        if (this.journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }
    
    public void setMaxSize(final long maxSize) {
        synchronized (this) {
            this.maxSize = maxSize;
            if (this.initialized) {
                this.executor.execute(this.cleanupRunnable);
            }
        }
    }
    
    public long size() throws IOException {
        synchronized (this) {
            this.initialize();
            return this.size;
        }
    }
    
    public Iterator<Snapshot> snapshots() throws IOException {
        synchronized (this) {
            this.initialize();
            return (Iterator<Snapshot>)new DiskLruCache$3(this);
        }
    }
    
    void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            this.removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }
    
    public final class Snapshot implements Closeable
    {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;
        
        Snapshot(final String key, final long sequenceNumber, final Source[] sources, final long[] lengths) {
            this.key = key;
            this.sequenceNumber = sequenceNumber;
            this.sources = sources;
            this.lengths = lengths;
        }
        
        @Override
        public void close() {
            final Source[] sources = this.sources;
            for (int length = sources.length, i = 0; i < length; ++i) {
                Util.closeQuietly((Closeable)sources[i]);
            }
        }
        
        @Nullable
        public DiskLruCache$Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }
        
        public long getLength(final int n) {
            return this.lengths[n];
        }
        
        public Source getSource(final int n) {
            return this.sources[n];
        }
        
        public String key() {
            return this.key;
        }
    }
}
