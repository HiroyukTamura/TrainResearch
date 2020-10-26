// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import com.google.common.base.Predicate;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.io.OutputStream;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.io.File;
import com.google.common.collect.TreeTraverser;
import com.google.common.annotations.Beta;

@Beta
public final class Files
{
    private static final TreeTraverser<File> FILE_TREE_TRAVERSER;
    private static final int TEMP_DIR_ATTEMPTS = 10000;
    
    static {
        FILE_TREE_TRAVERSER = new TreeTraverser<File>() {
            @Override
            public Iterable<File> children(final File file) {
                if (file.isDirectory()) {
                    final File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        return (Iterable<File>)Collections.unmodifiableList((List<?>)Arrays.asList((T[])listFiles));
                    }
                }
                return (Iterable<File>)Collections.emptyList();
            }
            
            @Override
            public String toString() {
                return "Files.fileTreeTraverser()";
            }
        };
    }
    
    private Files() {
    }
    
    public static void append(final CharSequence charSequence, final File file, final Charset charset) throws IOException {
        write(charSequence, file, charset, true);
    }
    
    public static ByteSink asByteSink(final File file, final FileWriteMode... array) {
        return new FileByteSink(file, array);
    }
    
    public static ByteSource asByteSource(final File file) {
        return new FileByteSource(file);
    }
    
    public static CharSink asCharSink(final File file, final Charset charset, final FileWriteMode... array) {
        return asByteSink(file, array).asCharSink(charset);
    }
    
    public static CharSource asCharSource(final File file, final Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }
    
    public static void copy(final File file, final File obj) throws IOException {
        Preconditions.checkArgument(!file.equals(obj), "Source %s and destination %s must be different", file, obj);
        asByteSource(file).copyTo(asByteSink(obj, new FileWriteMode[0]));
    }
    
    public static void copy(final File file, final OutputStream outputStream) throws IOException {
        asByteSource(file).copyTo(outputStream);
    }
    
    public static void copy(final File file, final Charset charset, final Appendable appendable) throws IOException {
        asCharSource(file, charset).copyTo(appendable);
    }
    
    public static void createParentDirs(final File obj) throws IOException {
        Preconditions.checkNotNull(obj);
        final File parentFile = obj.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                final String value = String.valueOf(String.valueOf(obj));
                throw new IOException(new StringBuilder(value.length() + 39).append("Unable to create parent directories of ").append(value).toString());
            }
        }
    }
    
    public static File createTempDir() {
        final File parent = new File(System.getProperty("java.io.tmpdir"));
        final String string = new StringBuilder(21).append(System.currentTimeMillis()).append("-").toString();
        for (int i = 0; i < 10000; ++i) {
            final String value = String.valueOf(String.valueOf(string));
            final File file = new File(parent, new StringBuilder(value.length() + 11).append(value).append(i).toString());
            if (file.mkdir()) {
                return file;
            }
        }
        final String value2 = String.valueOf(String.valueOf("Failed to create directory within 10000 attempts (tried "));
        final String value3 = String.valueOf(String.valueOf(string));
        final String value4 = String.valueOf(String.valueOf(string));
        throw new IllegalStateException(new StringBuilder(value2.length() + 17 + value3.length() + value4.length()).append(value2).append(value3).append("0 to ").append(value4).append(9999).append(")").toString());
    }
    
    public static boolean equal(final File file, final File obj) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(obj);
        if (file == obj || file.equals(obj)) {
            return true;
        }
        final long length = file.length();
        final long length2 = obj.length();
        return (length == 0L || length2 == 0L || length == length2) && asByteSource(file).contentEquals(asByteSource(obj));
    }
    
    public static TreeTraverser<File> fileTreeTraverser() {
        return Files.FILE_TREE_TRAVERSER;
    }
    
    public static String getFileExtension(String name) {
        Preconditions.checkNotNull(name);
        name = new File(name).getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex == -1) {
            return "";
        }
        return name.substring(lastIndex + 1);
    }
    
    public static String getNameWithoutExtension(String name) {
        Preconditions.checkNotNull(name);
        name = new File(name).getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex == -1) {
            return name;
        }
        return name.substring(0, lastIndex);
    }
    
    public static HashCode hash(final File file, final HashFunction hashFunction) throws IOException {
        return asByteSource(file).hash(hashFunction);
    }
    
    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }
    
    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }
    
    public static MappedByteBuffer map(final File file) throws IOException {
        Preconditions.checkNotNull(file);
        return map(file, FileChannel.MapMode.READ_ONLY);
    }
    
    public static MappedByteBuffer map(final File file, final FileChannel.MapMode mapMode) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        return map(file, mapMode, file.length());
    }
    
    public static MappedByteBuffer map(final File file, final FileChannel.MapMode mapMode, final long n) throws FileNotFoundException, IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        final Closer create = Closer.create();
        try {
            String mode;
            if (mapMode == FileChannel.MapMode.READ_ONLY) {
                mode = "r";
            }
            else {
                mode = "rw";
            }
            return map(create.register(new RandomAccessFile(file, mode)), mapMode, n);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    private static MappedByteBuffer map(final RandomAccessFile randomAccessFile, final FileChannel.MapMode mapMode, final long n) throws IOException {
        final Closer create = Closer.create();
        try {
            return create.register(randomAccessFile.getChannel()).map(mapMode, 0L, n);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    private static FileWriteMode[] modes(final boolean b) {
        if (b) {
            return new FileWriteMode[] { FileWriteMode.APPEND };
        }
        return new FileWriteMode[0];
    }
    
    public static void move(final File obj, final File obj2) throws IOException {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        Preconditions.checkArgument(!obj.equals(obj2), "Source %s and destination %s must be different", obj, obj2);
        if (!obj.renameTo(obj2)) {
            copy(obj, obj2);
            if (!obj.delete()) {
                if (!obj2.delete()) {
                    final String value = String.valueOf(String.valueOf(obj2));
                    throw new IOException(new StringBuilder(value.length() + 17).append("Unable to delete ").append(value).toString());
                }
                final String value2 = String.valueOf(String.valueOf(obj));
                throw new IOException(new StringBuilder(value2.length() + 17).append("Unable to delete ").append(value2).toString());
            }
        }
    }
    
    public static BufferedReader newReader(final File file, final Charset cs) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(cs);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), cs));
    }
    
    public static BufferedWriter newWriter(final File file, final Charset cs) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(cs);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), cs));
    }
    
    public static <T> T readBytes(final File file, final ByteProcessor<T> byteProcessor) throws IOException {
        return asByteSource(file).read(byteProcessor);
    }
    
    static byte[] readFile(final InputStream inputStream, final long lng) throws IOException {
        if (lng > 2147483647L) {
            throw new OutOfMemoryError(new StringBuilder(68).append("file is too large to fit in a byte array: ").append(lng).append(" bytes").toString());
        }
        if (lng == 0L) {
            return ByteStreams.toByteArray(inputStream);
        }
        return ByteStreams.toByteArray(inputStream, (int)lng);
    }
    
    public static String readFirstLine(final File file, final Charset charset) throws IOException {
        return asCharSource(file, charset).readFirstLine();
    }
    
    public static <T> T readLines(final File file, final Charset charset, final LineProcessor<T> lineProcessor) throws IOException {
        return asCharSource(file, charset).readLines(lineProcessor);
    }
    
    public static List<String> readLines(final File file, final Charset charset) throws IOException {
        return readLines(file, charset, (LineProcessor<List<String>>)new LineProcessor<List<String>>() {
            final List<String> result = Lists.newArrayList();
            
            @Override
            public List<String> getResult() {
                return this.result;
            }
            
            @Override
            public boolean processLine(final String s) {
                this.result.add(s);
                return true;
            }
        });
    }
    
    public static String simplifyPath(String value) {
        Preconditions.checkNotNull(value);
        if (((String)value).length() == 0) {
            value = ".";
        }
        else {
            final Iterable<String> split = Splitter.on('/').omitEmptyStrings().split((CharSequence)value);
            final ArrayList<String> list = new ArrayList<String>();
            for (final String s : split) {
                if (!s.equals(".")) {
                    if (s.equals("..")) {
                        if (list.size() > 0 && !((String)list.get(list.size() - 1)).equals("..")) {
                            list.remove(list.size() - 1);
                        }
                        else {
                            list.add("..");
                        }
                    }
                    else {
                        list.add(s);
                    }
                }
            }
            String anObject;
            final String obj = anObject = Joiner.on((char)47).join(list);
            if (((String)value).charAt(0) == '/') {
                value = String.valueOf(obj);
                if (((String)value).length() != 0) {
                    anObject = "/".concat((String)value);
                }
                else {
                    anObject = new String("/");
                }
            }
            while (anObject.startsWith("/../")) {
                anObject = anObject.substring(3);
            }
            if (anObject.equals("/..")) {
                return "/";
            }
            value = anObject;
            if ("".equals(anObject)) {
                return ".";
            }
        }
        return (String)value;
    }
    
    public static byte[] toByteArray(final File file) throws IOException {
        return asByteSource(file).read();
    }
    
    public static String toString(final File file, final Charset charset) throws IOException {
        return asCharSource(file, charset).read();
    }
    
    public static void touch(final File obj) throws IOException {
        Preconditions.checkNotNull(obj);
        if (!obj.createNewFile() && !obj.setLastModified(System.currentTimeMillis())) {
            final String value = String.valueOf(String.valueOf(obj));
            throw new IOException(new StringBuilder(value.length() + 38).append("Unable to update modification time of ").append(value).toString());
        }
    }
    
    public static void write(final CharSequence charSequence, final File file, final Charset charset) throws IOException {
        asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }
    
    private static void write(final CharSequence charSequence, final File file, final Charset charset, final boolean b) throws IOException {
        asCharSink(file, charset, modes(b)).write(charSequence);
    }
    
    public static void write(final byte[] array, final File file) throws IOException {
        asByteSink(file, new FileWriteMode[0]).write(array);
    }
    
    private static final class FileByteSink extends ByteSink
    {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;
        
        private FileByteSink(final File file, final FileWriteMode... array) {
            this.file = Preconditions.checkNotNull(file);
            this.modes = ImmutableSet.copyOf(array);
        }
        
        @Override
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.file));
            final String value2 = String.valueOf(String.valueOf(this.modes));
            return new StringBuilder(value.length() + 20 + value2.length()).append("Files.asByteSink(").append(value).append(", ").append(value2).append(")").toString();
        }
    }
    
    private static final class FileByteSource extends ByteSource
    {
        private final File file;
        
        private FileByteSource(final File file) {
            this.file = Preconditions.checkNotNull(file);
        }
        
        @Override
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(this.file);
        }
        
        @Override
        public byte[] read() throws IOException {
            final Closer create = Closer.create();
            try {
                final FileInputStream fileInputStream = create.register(this.openStream());
                return Files.readFile(fileInputStream, fileInputStream.getChannel().size());
            }
            catch (Throwable t) {
                throw create.rethrow(t);
            }
            finally {
                create.close();
            }
        }
        
        @Override
        public long size() throws IOException {
            if (!this.file.isFile()) {
                throw new FileNotFoundException(this.file.toString());
            }
            return this.file.length();
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.file));
            return new StringBuilder(value.length() + 20).append("Files.asByteSource(").append(value).append(")").toString();
        }
    }
    
    private enum FilePredicate implements Predicate<File>
    {
        IS_DIRECTORY {
            @Override
            public boolean apply(final File file) {
                return file.isDirectory();
            }
            
            @Override
            public String toString() {
                return "Files.isDirectory()";
            }
        }, 
        IS_FILE {
            @Override
            public boolean apply(final File file) {
                return file.isFile();
            }
            
            @Override
            public String toString() {
                return "Files.isFile()";
            }
        };
    }
}
