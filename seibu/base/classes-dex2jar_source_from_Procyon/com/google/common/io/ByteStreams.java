// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.FilterInputStream;
import java.io.DataOutputStream;
import java.io.DataOutput;
import java.io.DataInputStream;
import java.io.DataInput;
import java.util.Arrays;
import java.io.EOFException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.io.IOException;
import java.io.InputStream;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import com.google.common.annotations.Beta;

@Beta
public final class ByteStreams
{
    private static final int BUF_SIZE = 4096;
    private static final OutputStream NULL_OUTPUT_STREAM;
    
    static {
        NULL_OUTPUT_STREAM = new OutputStream() {
            @Override
            public String toString() {
                return "ByteStreams.nullOutputStream()";
            }
            
            @Override
            public void write(final int n) {
            }
            
            @Override
            public void write(final byte[] array) {
                Preconditions.checkNotNull(array);
            }
            
            @Override
            public void write(final byte[] array, final int n, final int n2) {
                Preconditions.checkNotNull(array);
            }
        };
    }
    
    private ByteStreams() {
    }
    
    public static long copy(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        final byte[] array = new byte[4096];
        long n = 0L;
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
            n += read;
        }
        return n;
    }
    
    public static long copy(final ReadableByteChannel readableByteChannel, final WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        final ByteBuffer allocate = ByteBuffer.allocate(4096);
        long n = 0L;
        while (readableByteChannel.read(allocate) != -1) {
            allocate.flip();
            while (allocate.hasRemaining()) {
                n += writableByteChannel.write(allocate);
            }
            allocate.clear();
        }
        return n;
    }
    
    public static InputStream limit(final InputStream inputStream, final long n) {
        return new LimitedInputStream(inputStream, n);
    }
    
    public static ByteArrayDataInput newDataInput(final ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream(Preconditions.checkNotNull(byteArrayInputStream));
    }
    
    public static ByteArrayDataInput newDataInput(final byte[] buf) {
        return newDataInput(new ByteArrayInputStream(buf));
    }
    
    public static ByteArrayDataInput newDataInput(final byte[] buf, final int offset) {
        Preconditions.checkPositionIndex(offset, buf.length);
        return newDataInput(new ByteArrayInputStream(buf, offset, buf.length - offset));
    }
    
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }
    
    public static ByteArrayDataOutput newDataOutput(final int n) {
        Preconditions.checkArgument(n >= 0, "Invalid size: %s", n);
        return newDataOutput(new ByteArrayOutputStream(n));
    }
    
    public static ByteArrayDataOutput newDataOutput(final ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream(Preconditions.checkNotNull(byteArrayOutputStream));
    }
    
    public static OutputStream nullOutputStream() {
        return ByteStreams.NULL_OUTPUT_STREAM;
    }
    
    public static int read(final InputStream inputStream, final byte[] b, final int n, final int n2) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(b);
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i;
        int read;
        for (i = 0; i < n2; i += read) {
            read = inputStream.read(b, n + i, n2 - i);
            if (read == -1) {
                break;
            }
        }
        return i;
    }
    
    public static <T> T readBytes(final InputStream inputStream, final ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        final byte[] b = new byte[4096];
        int read;
        do {
            read = inputStream.read(b);
        } while (read != -1 && byteProcessor.processBytes(b, 0, read));
        return byteProcessor.getResult();
    }
    
    public static void readFully(final InputStream inputStream, final byte[] array) throws IOException {
        readFully(inputStream, array, 0, array.length);
    }
    
    public static void readFully(final InputStream inputStream, final byte[] array, int read, final int i) throws IOException {
        read = read(inputStream, array, read, i);
        if (read != i) {
            throw new EOFException(new StringBuilder(81).append("reached end of stream after reading ").append(read).append(" bytes; ").append(i).append(" bytes expected").toString());
        }
    }
    
    public static void skipFully(final InputStream inputStream, final long lng) throws IOException {
        long n = lng;
        while (n > 0L) {
            final long skip = inputStream.skip(n);
            if (skip == 0L) {
                if (inputStream.read() == -1) {
                    throw new EOFException(new StringBuilder(100).append("reached end of stream after skipping ").append(lng - n).append(" bytes; ").append(lng).append(" bytes expected").toString());
                }
                --n;
            }
            else {
                n -= skip;
            }
        }
    }
    
    public static byte[] toByteArray(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
    static byte[] toByteArray(final InputStream inputStream, int read) throws IOException {
        final byte[] array = new byte[read];
        int read2;
        for (int i = read; i > 0; i -= read2) {
            final int n = read - i;
            read2 = inputStream.read(array, n, i);
            if (read2 == -1) {
                return Arrays.copyOf(array, n);
            }
        }
        read = inputStream.read();
        final byte[] copy = array;
        if (read != -1) {
            final FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
            fastByteArrayOutputStream.write(read);
            copy(inputStream, fastByteArrayOutputStream);
            final byte[] array2 = new byte[array.length + fastByteArrayOutputStream.size()];
            System.arraycopy(array, 0, array2, 0, array.length);
            fastByteArrayOutputStream.writeTo(array2, array.length);
            return array2;
        }
        return copy;
    }
    
    private static class ByteArrayDataInputStream implements ByteArrayDataInput
    {
        final DataInput input;
        
        ByteArrayDataInputStream(final ByteArrayInputStream in) {
            this.input = new DataInputStream(in);
        }
        
        @Override
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public byte readByte() {
            try {
                return this.input.readByte();
            }
            catch (EOFException cause) {
                throw new IllegalStateException(cause);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public char readChar() {
            try {
                return this.input.readChar();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public double readDouble() {
            try {
                return this.input.readDouble();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public float readFloat() {
            try {
                return this.input.readFloat();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public void readFully(final byte[] array) {
            try {
                this.input.readFully(array);
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public void readFully(final byte[] array, final int n, final int n2) {
            try {
                this.input.readFully(array, n, n2);
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public int readInt() {
            try {
                return this.input.readInt();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public String readLine() {
            try {
                return this.input.readLine();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public long readLong() {
            try {
                return this.input.readLong();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public short readShort() {
            try {
                return this.input.readShort();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public String readUTF() {
            try {
                return this.input.readUTF();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
        
        @Override
        public int skipBytes(int skipBytes) {
            try {
                skipBytes = this.input.skipBytes(skipBytes);
                return skipBytes;
            }
            catch (IOException cause) {
                throw new IllegalStateException(cause);
            }
        }
    }
    
    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput
    {
        final ByteArrayOutputStream byteArrayOutputSteam;
        final DataOutput output;
        
        ByteArrayDataOutputStream(final ByteArrayOutputStream byteArrayOutputStream) {
            this.byteArrayOutputSteam = byteArrayOutputStream;
            this.output = new DataOutputStream(byteArrayOutputStream);
        }
        
        @Override
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }
        
        @Override
        public void write(final int n) {
            try {
                this.output.write(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void write(final byte[] array) {
            try {
                this.output.write(array);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void write(final byte[] array, final int n, final int n2) {
            try {
                this.output.write(array, n, n2);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeBoolean(final boolean b) {
            try {
                this.output.writeBoolean(b);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeByte(final int n) {
            try {
                this.output.writeByte(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeBytes(final String s) {
            try {
                this.output.writeBytes(s);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeChar(final int n) {
            try {
                this.output.writeChar(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeChars(final String s) {
            try {
                this.output.writeChars(s);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeDouble(final double n) {
            try {
                this.output.writeDouble(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeFloat(final float n) {
            try {
                this.output.writeFloat(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeInt(final int n) {
            try {
                this.output.writeInt(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeLong(final long n) {
            try {
                this.output.writeLong(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeShort(final int n) {
            try {
                this.output.writeShort(n);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
        
        @Override
        public void writeUTF(final String s) {
            try {
                this.output.writeUTF(s);
            }
            catch (IOException detailMessage) {
                throw new AssertionError((Object)detailMessage);
            }
        }
    }
    
    private static final class FastByteArrayOutputStream extends ByteArrayOutputStream
    {
        void writeTo(final byte[] array, final int n) {
            System.arraycopy(this.buf, 0, array, n, this.count);
        }
    }
    
    private static final class LimitedInputStream extends FilterInputStream
    {
        private long left;
        private long mark;
        
        LimitedInputStream(final InputStream in, final long left) {
            super(in);
            this.mark = -1L;
            Preconditions.checkNotNull(in);
            Preconditions.checkArgument(left >= 0L, (Object)"limit must be non-negative");
            this.left = left;
        }
        
        @Override
        public int available() throws IOException {
            return (int)Math.min(this.in.available(), this.left);
        }
        
        @Override
        public void mark(final int readlimit) {
            synchronized (this) {
                this.in.mark(readlimit);
                this.mark = this.left;
            }
        }
        
        @Override
        public int read() throws IOException {
            int n;
            if (this.left == 0L) {
                n = -1;
            }
            else {
                final int read = this.in.read();
                if ((n = read) != -1) {
                    --this.left;
                    return read;
                }
            }
            return n;
        }
        
        @Override
        public int read(final byte[] b, int off, int read) throws IOException {
            if (this.left == 0L) {
                off = -1;
            }
            else {
                read = (int)Math.min(read, this.left);
                read = this.in.read(b, off, read);
                if ((off = read) != -1) {
                    this.left -= read;
                    return read;
                }
            }
            return off;
        }
        
        @Override
        public void reset() throws IOException {
            synchronized (this) {
                if (!this.in.markSupported()) {
                    throw new IOException("Mark not supported");
                }
            }
            if (this.mark == -1L) {
                throw new IOException("Mark not set");
            }
            this.in.reset();
            this.left = this.mark;
        }
        // monitorexit(this)
        
        @Override
        public long skip(long n) throws IOException {
            n = Math.min(n, this.left);
            n = this.in.skip(n);
            this.left -= n;
            return n;
        }
    }
}
