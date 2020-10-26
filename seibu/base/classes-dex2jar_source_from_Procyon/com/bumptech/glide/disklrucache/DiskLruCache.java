// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.disklrucache;

import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.io.EOFException;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.io.Writer;
import java.util.concurrent.ThreadPoolExecutor;
import java.io.File;
import java.util.concurrent.Callable;
import java.io.Closeable;

public final class DiskLruCache implements Closeable
{
    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    
    private DiskLruCache(final File file, final int appVersion, final int valueCount, final long maxSize) {
        this.size = 0L;
        this.lruEntries = new LinkedHashMap<String, Entry>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        this.cleanupCallable = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.journalWriter == null) {
                        return null;
                    }
                    DiskLruCache.this.trimToSize();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                    return null;
                }
            }
        };
        this.directory = file;
        this.appVersion = appVersion;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = valueCount;
        this.maxSize = maxSize;
    }
    
    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
    
    private void completeEdit(final Editor editor, final boolean b) throws IOException {
        final Entry access$1400;
        synchronized (this) {
            access$1400 = editor.entry;
            if (access$1400.currentEditor != editor) {
                throw new IllegalStateException();
            }
        }
    Label_0108:
        while (true) {
            if (b && !access$1400.readable) {
                for (int i = 0; i < this.valueCount; ++i) {
                    final Editor editor2;
                    if (!editor2.written[i]) {
                        editor2.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!access$1400.getDirtyFile(i).exists()) {
                        editor2.abort();
                        break Label_0108;
                    }
                }
            }
            Label_0118: {
                break Label_0118;
                return;
            }
            for (int j = 0; j < this.valueCount; ++j) {
                final File dirtyFile = access$1400.getDirtyFile(j);
                if (b) {
                    if (dirtyFile.exists()) {
                        final File cleanFile = access$1400.getCleanFile(j);
                        dirtyFile.renameTo(cleanFile);
                        final long n = access$1400.lengths[j];
                        final long length = cleanFile.length();
                        access$1400.lengths[j] = length;
                        this.size = this.size - n + length;
                    }
                }
                else {
                    deleteIfExists(dirtyFile);
                }
            }
            ++this.redundantOpCount;
            access$1400.currentEditor = null;
            if (access$1400.readable | b) {
                access$1400.readable = true;
                this.journalWriter.append((CharSequence)"CLEAN");
                this.journalWriter.append(' ');
                this.journalWriter.append((CharSequence)access$1400.key);
                this.journalWriter.append((CharSequence)access$1400.getLengths());
                this.journalWriter.append('\n');
                if (b) {
                    final long nextSequenceNumber = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1L + nextSequenceNumber;
                    access$1400.sequenceNumber = nextSequenceNumber;
                }
            }
            else {
                this.lruEntries.remove(access$1400.key);
                this.journalWriter.append((CharSequence)"REMOVE");
                this.journalWriter.append(' ');
                this.journalWriter.append((CharSequence)access$1400.key);
                this.journalWriter.append('\n');
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || this.journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            continue Label_0108;
        }
    }
    // monitorexit(this)
    
    private static void deleteIfExists(final File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }
    
    private Editor edit(final String csq, final long n) throws IOException {
        while (true) {
            Editor editor = null;
            while (true) {
                final Entry entry;
                synchronized (this) {
                    this.checkNotClosed();
                    entry = this.lruEntries.get(csq);
                    Label_0062: {
                        if (n == -1L) {
                            break Label_0062;
                        }
                        Editor editor2 = editor;
                        if (entry != null) {
                            if (entry.sequenceNumber == n) {
                                break Label_0062;
                            }
                            editor2 = editor;
                        }
                        return editor2;
                    }
                    if (entry == null) {
                        final Entry value = new Entry(csq);
                        this.lruEntries.put(csq, value);
                        editor = new Editor(value);
                        value.currentEditor = editor;
                        this.journalWriter.append((CharSequence)"DIRTY");
                        this.journalWriter.append(' ');
                        this.journalWriter.append((CharSequence)csq);
                        this.journalWriter.append('\n');
                        this.journalWriter.flush();
                        return editor;
                    }
                }
                final Editor access$700 = entry.currentEditor;
                final Entry value = entry;
                if (access$700 != null) {
                    return editor;
                }
                continue;
            }
        }
    }
    
    private static String inputStreamToString(final InputStream in) throws IOException {
        return Util.readFully(new InputStreamReader(in, Util.UTF_8));
    }
    
    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }
    
    public static DiskLruCache open(final File obj, final int n, final int n2, final long n3) throws IOException {
        if (n3 <= 0L) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        Object o = new File(obj, "journal.bkp");
        Label_0115: {
            if (((File)o).exists()) {
                final File file = new File(obj, "journal");
                if (!file.exists()) {
                    break Label_0115;
                }
                ((File)o).delete();
            }
            while (true) {
                o = new DiskLruCache(obj, n, n2, n3);
                if (!((DiskLruCache)o).journalFile.exists()) {
                    break Label_0115;
                }
                try {
                    ((DiskLruCache)o).readJournal();
                    ((DiskLruCache)o).processJournal();
                    return (DiskLruCache)o;
                    final File file;
                    renameTo((File)o, file, false);
                    continue;
                }
                catch (IOException ex) {
                    System.out.println("DiskLruCache " + obj + " is corrupt: " + ex.getMessage() + ", removing");
                    ((DiskLruCache)o).delete();
                }
                break;
            }
        }
        obj.mkdirs();
        final DiskLruCache diskLruCache = new DiskLruCache(obj, n, n2, n3);
        diskLruCache.rebuildJournal();
        return diskLruCache;
    }
    
    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        final Iterator<Entry> iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            final Entry entry = iterator.next();
            if (entry.currentEditor == null) {
                for (int i = 0; i < this.valueCount; ++i) {
                    this.size += entry.lengths[i];
                }
            }
            else {
                entry.currentEditor = null;
                for (int j = 0; j < this.valueCount; ++j) {
                    deleteIfExists(entry.getCleanFile(j));
                    deleteIfExists(entry.getDirtyFile(j));
                }
                iterator.remove();
            }
        }
    }
    
    private void readJournal() throws IOException {
        final StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            final String line = strictLineReader.readLine();
            final String line2 = strictLineReader.readLine();
            final String line3 = strictLineReader.readLine();
            final String line4 = strictLineReader.readLine();
            final String line5 = strictLineReader.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.appVersion).equals(line3) || !Integer.toString(this.valueCount).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
        }
        finally {
            Util.closeQuietly(strictLineReader);
        }
        int n = 0;
        try {
            while (true) {
                this.readJournalLine(strictLineReader.readLine());
                ++n;
            }
        }
        catch (EOFException ex) {
            this.redundantOpCount = n - this.lruEntries.size();
            if (strictLineReader.hasUnterminatedLine()) {
                this.rebuildJournal();
            }
            else {
                this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
            }
            Util.closeQuietly(strictLineReader);
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
        Entry value;
        if ((value = this.lruEntries.get(s2)) == null) {
            value = new Entry(s2);
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
            value.currentEditor = new Editor(value);
            return;
        }
        if (index2 != -1 || index != "READ".length() || !s.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + s);
        }
    }
    
    private void rebuildJournal() throws IOException {
        BufferedWriter bufferedWriter;
        while (true) {
            while (true) {
                Entry entry = null;
                synchronized (this) {
                    if (this.journalWriter != null) {
                        this.journalWriter.close();
                    }
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
                    try {
                        bufferedWriter.write("libcore.io.DiskLruCache");
                        bufferedWriter.write("\n");
                        bufferedWriter.write("1");
                        bufferedWriter.write("\n");
                        bufferedWriter.write(Integer.toString(this.appVersion));
                        bufferedWriter.write("\n");
                        bufferedWriter.write(Integer.toString(this.valueCount));
                        bufferedWriter.write("\n");
                        bufferedWriter.write("\n");
                        final Iterator<Entry> iterator = this.lruEntries.values().iterator();
                        while (iterator.hasNext()) {
                            entry = iterator.next();
                            if (entry.currentEditor == null) {
                                break;
                            }
                            bufferedWriter.write("DIRTY " + entry.key + '\n');
                        }
                    }
                    finally {
                        bufferedWriter.close();
                    }
                }
                bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                continue;
            }
        }
        bufferedWriter.close();
        if (this.journalFile.exists()) {
            renameTo(this.journalFile, this.journalFileBackup, true);
        }
        renameTo(this.journalFileTmp, this.journalFile, false);
        this.journalFileBackup.delete();
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
    }
    // monitorexit(this)
    
    private static void renameTo(final File file, final File dest, final boolean b) throws IOException {
        if (b) {
            deleteIfExists(dest);
        }
        if (!file.renameTo(dest)) {
            throw new IOException();
        }
    }
    
    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            this.remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }
    
    @Override
    public void close() throws IOException {
        while (true) {
            synchronized (this) {
                if (this.journalWriter == null) {
                    return;
                }
                for (final Entry entry : new ArrayList<Entry>(this.lruEntries.values())) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
            }
            this.trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }
    
    public void delete() throws IOException {
        this.close();
        Util.deleteContents(this.directory);
    }
    
    public Editor edit(final String s) throws IOException {
        return this.edit(s, -1L);
    }
    
    public void flush() throws IOException {
        synchronized (this) {
            this.checkNotClosed();
            this.trimToSize();
            this.journalWriter.flush();
        }
    }
    
    public Value get(final String s) throws IOException {
        final Value value = null;
        synchronized (this) {
            this.checkNotClosed();
            final Entry entry = this.lruEntries.get(s);
            Value value2;
            if (entry == null) {
                value2 = value;
            }
            else {
                value2 = value;
                if (entry.readable) {
                    final File[] cleanFiles = entry.cleanFiles;
                    for (int length = cleanFiles.length, i = 0; i < length; ++i) {
                        value2 = value;
                        if (!cleanFiles[i].exists()) {
                            return value2;
                        }
                    }
                    ++this.redundantOpCount;
                    this.journalWriter.append((CharSequence)"READ");
                    this.journalWriter.append(' ');
                    this.journalWriter.append((CharSequence)s);
                    this.journalWriter.append('\n');
                    if (this.journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    value2 = new Value(s, entry.sequenceNumber, entry.cleanFiles, entry.lengths);
                }
            }
            return value2;
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
    
    public boolean isClosed() {
        synchronized (this) {
            return this.journalWriter == null;
        }
    }
    
    public boolean remove(final String key) throws IOException {
        while (true) {
        Label_0141:
            while (true) {
                final Entry entry;
                int n;
                synchronized (this) {
                    this.checkNotClosed();
                    entry = this.lruEntries.get(key);
                    if (entry == null || entry.currentEditor != null) {
                        return false;
                    }
                    n = 0;
                    if (n >= this.valueCount) {
                        break Label_0141;
                    }
                    final File cleanFile = entry.getCleanFile(n);
                    if (cleanFile.exists() && !cleanFile.delete()) {
                        throw new IOException("failed to delete " + cleanFile);
                    }
                }
                this.size -= entry.lengths[n];
                entry.lengths[n] = 0L;
                ++n;
                continue;
            }
            ++this.redundantOpCount;
            this.journalWriter.append((CharSequence)"REMOVE");
            this.journalWriter.append(' ');
            final CharSequence charSequence;
            this.journalWriter.append(charSequence);
            this.journalWriter.append('\n');
            this.lruEntries.remove(charSequence);
            if (this.journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return true;
        }
    }
    
    public void setMaxSize(final long maxSize) {
        synchronized (this) {
            this.maxSize = maxSize;
            this.executorService.submit(this.cleanupCallable);
        }
    }
    
    public long size() {
        synchronized (this) {
            return this.size;
        }
    }
    
    public final class Editor
    {
        private boolean committed;
        private final Entry entry;
        private final boolean[] written;
        
        private Editor(final Entry entry) {
            this.entry = entry;
            boolean[] written;
            if (entry.readable) {
                written = null;
            }
            else {
                written = new boolean[DiskLruCache.this.valueCount];
            }
            this.written = written;
        }
        
        private InputStream newInputStream(final int n) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
            }
            if (!this.entry.readable) {
                // monitorexit(diskLruCache)
                return null;
            }
            try {
                // monitorexit(diskLruCache)
                return new FileInputStream(this.entry.getCleanFile(n));
            }
            catch (FileNotFoundException ex) {
                // monitorexit(diskLruCache)
                return null;
            }
        }
        
        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }
        
        public void abortUnlessCommitted() {
            if (this.committed) {
                return;
            }
            try {
                this.abort();
            }
            catch (IOException ex) {}
        }
        
        public void commit() throws IOException {
            DiskLruCache.this.completeEdit(this, true);
            this.committed = true;
        }
        
        public File getFile(final int n) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
            }
            if (!this.entry.readable) {
                this.written[n] = true;
            }
            final File dirtyFile = this.entry.getDirtyFile(n);
            if (!DiskLruCache.this.directory.exists()) {
                DiskLruCache.this.directory.mkdirs();
            }
            // monitorexit(diskLruCache)
            return dirtyFile;
        }
        
        public String getString(final int n) throws IOException {
            final InputStream inputStream = this.newInputStream(n);
            if (inputStream != null) {
                return inputStreamToString(inputStream);
            }
            return null;
        }
        
        public void set(final int n, final String s) throws IOException {
            final Closeable closeable = null;
            OutputStreamWriter outputStreamWriter;
            try {
                final OutputStreamWriter outputStreamWriter2;
                outputStreamWriter = (outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(this.getFile(n)), Util.UTF_8));
                final String s2 = s;
                outputStreamWriter2.write(s2);
                final OutputStreamWriter outputStreamWriter3 = outputStreamWriter;
                Util.closeQuietly(outputStreamWriter3);
                return;
            }
            finally {
                final OutputStreamWriter outputStreamWriter4;
                outputStreamWriter = outputStreamWriter4;
                final Closeable closeable2 = closeable;
            }
            while (true) {
                try {
                    final OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
                    final String s2 = s;
                    outputStreamWriter2.write(s2);
                    final OutputStreamWriter outputStreamWriter3 = outputStreamWriter;
                    Util.closeQuietly(outputStreamWriter3);
                    return;
                    final Closeable closeable2;
                    Util.closeQuietly(closeable2);
                    throw outputStreamWriter;
                }
                finally {
                    final Closeable closeable2 = outputStreamWriter;
                    final OutputStreamWriter outputStreamWriter5;
                    outputStreamWriter = outputStreamWriter5;
                    continue;
                }
                break;
            }
        }
    }
    
    private final class Entry
    {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        
        private Entry(final String s) {
            this.key = s;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            final StringBuilder append = new StringBuilder(s).append('.');
            final int length = append.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; ++i) {
                append.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, append.toString());
                append.setLength(length);
            }
        }
        
        private IOException invalidLengths(final String[] a) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(a));
        }
        
        private void setLengths(final String[] array) throws IOException {
            if (array.length != DiskLruCache.this.valueCount) {
                throw this.invalidLengths(array);
            }
            int i = 0;
            try {
                while (i < array.length) {
                    this.lengths[i] = Long.parseLong(array[i]);
                    ++i;
                }
            }
            catch (NumberFormatException ex) {
                throw this.invalidLengths(array);
            }
        }
        
        public File getCleanFile(final int n) {
            return this.cleanFiles[n];
        }
        
        public File getDirtyFile(final int n) {
            return this.dirtyFiles[n];
        }
        
        public String getLengths() throws IOException {
            final StringBuilder sb = new StringBuilder();
            final long[] lengths = this.lengths;
            for (int length = lengths.length, i = 0; i < length; ++i) {
                sb.append(' ').append(lengths[i]);
            }
            return sb.toString();
        }
    }
    
    public final class Value
    {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        
        private Value(final String key, final long sequenceNumber, final File[] files, final long[] lengths) {
            this.key = key;
            this.sequenceNumber = sequenceNumber;
            this.files = files;
            this.lengths = lengths;
        }
        
        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }
        
        public File getFile(final int n) {
            return this.files[n];
        }
        
        public long getLength(final int n) {
            return this.lengths[n];
        }
        
        public String getString(final int n) throws IOException {
            return inputStreamToString(new FileInputStream(this.files[n]));
        }
    }
}
