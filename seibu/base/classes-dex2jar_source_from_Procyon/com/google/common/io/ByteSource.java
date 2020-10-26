// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.common.annotations.Beta;
import java.io.BufferedInputStream;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.io.OutputStream;
import java.util.Arrays;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.InputStream;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public abstract class ByteSource
{
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer;
    
    static {
        countBuffer = new byte[4096];
    }
    
    protected ByteSource() {
    }
    
    public static ByteSource concat(final Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }
    
    public static ByteSource concat(final Iterator<? extends ByteSource> iterator) {
        return concat((Iterable<? extends ByteSource>)ImmutableList.copyOf((Iterator<?>)iterator));
    }
    
    public static ByteSource concat(final ByteSource... array) {
        return concat(ImmutableList.copyOf(array));
    }
    
    private long countByReading(final InputStream inputStream) throws IOException {
        long n = 0L;
        while (true) {
            final long n2 = inputStream.read(ByteSource.countBuffer);
            if (n2 == -1L) {
                break;
            }
            n += n2;
        }
        return n;
    }
    
    private long countBySkipping(final InputStream inputStream) throws IOException {
        long n = 0L;
        while (true) {
            final long skip = inputStream.skip(Math.min(inputStream.available(), Integer.MAX_VALUE));
            if (skip <= 0L) {
                if (inputStream.read() == -1) {
                    return n;
                }
                if (n == 0L && inputStream.available() == 0) {
                    throw new IOException();
                }
                ++n;
            }
            else {
                n += skip;
            }
        }
    }
    
    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }
    
    public static ByteSource wrap(final byte[] array) {
        return new ByteArrayByteSource(array);
    }
    
    public CharSource asCharSource(final Charset charset) {
        return new AsCharSource(charset);
    }
    
    public boolean contentEquals(final ByteSource byteSource) throws IOException {
        Preconditions.checkNotNull(byteSource);
        final byte[] a = new byte[4096];
        final byte[] a2 = new byte[4096];
        final Closer create = Closer.create();
        try {
            final InputStream inputStream = create.register(this.openStream());
            final InputStream inputStream2 = create.register(byteSource.openStream());
            int i;
            do {
                i = ByteStreams.read(inputStream, a, 0, 4096);
                if (i != ByteStreams.read(inputStream2, a2, 0, 4096) || !Arrays.equals(a, a2)) {
                    return false;
                }
            } while (i == 4096);
            return true;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long copyTo(final ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        final Closer create = Closer.create();
        try {
            return ByteStreams.copy(create.register(this.openStream()), create.register(byteSink.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long copyTo(final OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        final Closer create = Closer.create();
        try {
            return ByteStreams.copy(create.register(this.openStream()), outputStream);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public HashCode hash(final HashFunction hashFunction) throws IOException {
        final Hasher hasher = hashFunction.newHasher();
        this.copyTo(Funnels.asOutputStream(hasher));
        return hasher.hash();
    }
    
    public boolean isEmpty() throws IOException {
        final Closer create = Closer.create();
        try {
            return create.register(this.openStream()).read() == -1;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public InputStream openBufferedStream() throws IOException {
        final InputStream openStream = this.openStream();
        if (openStream instanceof BufferedInputStream) {
            return openStream;
        }
        return new BufferedInputStream(openStream);
    }
    
    public abstract InputStream openStream() throws IOException;
    
    @Beta
    public <T> T read(final ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        final Closer create = Closer.create();
        try {
            return ByteStreams.readBytes(create.register(this.openStream()), byteProcessor);
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public byte[] read() throws IOException {
        final Closer create = Closer.create();
        try {
            return ByteStreams.toByteArray(create.register(this.openStream()));
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long size() throws IOException {
        Closer closer = Closer.create();
        try {
            return this.countBySkipping(closer.register(this.openStream()));
        }
        catch (IOException ex) {
            closer.close();
            closer = Closer.create();
            final ByteSource byteSource = this;
            final Closer closer2 = closer;
            final ByteSource byteSource2 = this;
            final InputStream inputStream = byteSource2.openStream();
            final InputStream inputStream2 = closer2.register(inputStream);
            final InputStream inputStream3 = inputStream2;
            final long countByReading = byteSource.countByReading(inputStream3);
            return countByReading;
        }
        finally {
            closer.close();
        }
        try {
            final ByteSource byteSource = this;
            final Closer closer2 = closer;
            final ByteSource byteSource2 = this;
            final InputStream inputStream = byteSource2.openStream();
            final InputStream inputStream2 = closer2.register(inputStream);
            final InputStream inputStream3 = inputStream2;
            final long countByReading2;
            final long countByReading = countByReading2 = byteSource.countByReading(inputStream3);
            return countByReading2;
        }
        catch (Throwable t) {
            throw closer.rethrow(t);
        }
        finally {
            closer.close();
        }
    }
    
    public ByteSource slice(final long n, final long n2) {
        return new SlicedByteSource(n, n2);
    }
    
    private final class AsCharSource extends CharSource
    {
        private final Charset charset;
        
        private AsCharSource(final Charset charset) {
            this.charset = Preconditions.checkNotNull(charset);
        }
        
        @Override
        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(ByteSource.this.toString()));
            final String value2 = String.valueOf(String.valueOf(this.charset));
            return new StringBuilder(value.length() + 15 + value2.length()).append(value).append(".asCharSource(").append(value2).append(")").toString();
        }
    }
    
    private static class ByteArrayByteSource extends ByteSource
    {
        protected final byte[] bytes;
        
        protected ByteArrayByteSource(final byte[] array) {
            this.bytes = Preconditions.checkNotNull(array);
        }
        
        @Override
        public long copyTo(final OutputStream outputStream) throws IOException {
            outputStream.write(this.bytes);
            return this.bytes.length;
        }
        
        @Override
        public HashCode hash(final HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes);
        }
        
        @Override
        public boolean isEmpty() {
            return this.bytes.length == 0;
        }
        
        @Override
        public InputStream openBufferedStream() throws IOException {
            return this.openStream();
        }
        
        @Override
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes);
        }
        
        @Override
        public <T> T read(final ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.bytes, 0, this.bytes.length);
            return byteProcessor.getResult();
        }
        
        @Override
        public byte[] read() {
            return this.bytes.clone();
        }
        
        @Override
        public long size() {
            return this.bytes.length;
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(Ascii.truncate(BaseEncoding.base16().encode(this.bytes), 30, "...")));
            return new StringBuilder(value.length() + 17).append("ByteSource.wrap(").append(value).append(")").toString();
        }
    }
    
    private static final class ConcatenatedByteSource extends ByteSource
    {
        private final Iterable<? extends ByteSource> sources;
        
        ConcatenatedByteSource(final Iterable<? extends ByteSource> iterable) {
            this.sources = Preconditions.checkNotNull(iterable);
        }
        
        @Override
        public boolean isEmpty() throws IOException {
            final Iterator<? extends ByteSource> iterator = this.sources.iterator();
            while (iterator.hasNext()) {
                if (!((ByteSource)iterator.next()).isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }
        
        @Override
        public long size() throws IOException {
            long n = 0L;
            final Iterator<? extends ByteSource> iterator = this.sources.iterator();
            while (iterator.hasNext()) {
                n += ((ByteSource)iterator.next()).size();
            }
            return n;
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(this.sources));
            return new StringBuilder(value.length() + 19).append("ByteSource.concat(").append(value).append(")").toString();
        }
    }
    
    private static final class EmptyByteSource extends ByteArrayByteSource
    {
        private static final EmptyByteSource INSTANCE;
        
        static {
            INSTANCE = new EmptyByteSource();
        }
        
        private EmptyByteSource() {
            super(new byte[0]);
        }
        
        @Override
        public CharSource asCharSource(final Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }
        
        @Override
        public byte[] read() {
            return this.bytes;
        }
        
        @Override
        public String toString() {
            return "ByteSource.empty()";
        }
    }
    
    private final class SlicedByteSource extends ByteSource
    {
        private final long length;
        private final long offset;
        
        private SlicedByteSource(final long n, final long n2) {
            Preconditions.checkArgument(n >= 0L, "offset (%s) may not be negative", n);
            Preconditions.checkArgument(n2 >= 0L, "length (%s) may not be negative", n2);
            this.offset = n;
            this.length = n2;
        }
        
        private InputStream sliceStream(final InputStream inputStream) throws IOException {
            Label_0017: {
                if (this.offset <= 0L) {
                    break Label_0017;
                }
                try {
                    ByteStreams.skipFully(inputStream, this.offset);
                    return ByteStreams.limit(inputStream, this.length);
                }
                catch (Throwable t) {
                    final Closer create = Closer.create();
                    create.register(inputStream);
                    try {
                        throw create.rethrow(t);
                    }
                    finally {
                        create.close();
                    }
                }
            }
        }
        
        @Override
        public boolean isEmpty() throws IOException {
            return this.length == 0L || super.isEmpty();
        }
        
        @Override
        public InputStream openBufferedStream() throws IOException {
            return this.sliceStream(ByteSource.this.openBufferedStream());
        }
        
        @Override
        public InputStream openStream() throws IOException {
            return this.sliceStream(ByteSource.this.openStream());
        }
        
        @Override
        public ByteSource slice(final long l, final long n) {
            Preconditions.checkArgument(l >= 0L, "offset (%s) may not be negative", l);
            Preconditions.checkArgument(n >= 0L, "length (%s) may not be negative", n);
            return ByteSource.this.slice(this.offset + l, Math.min(n, this.length - l));
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(ByteSource.this.toString()));
            return new StringBuilder(value.length() + 50).append(value).append(".slice(").append(this.offset).append(", ").append(this.length).append(")").toString();
        }
    }
}
