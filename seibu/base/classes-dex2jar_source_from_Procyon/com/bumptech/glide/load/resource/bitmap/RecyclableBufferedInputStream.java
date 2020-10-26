// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import android.util.Log;
import java.io.InputStream;
import java.io.FilterInputStream;

public class RecyclableBufferedInputStream extends FilterInputStream
{
    private static final String TAG = "BufferedIs";
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;
    
    public RecyclableBufferedInputStream(final InputStream in, final byte[] buf) {
        super(in);
        this.markpos = -1;
        if (buf == null || buf.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.buf = buf;
    }
    
    private int fillbuf(final InputStream inputStream, final byte[] b) throws IOException {
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            final int read = inputStream.read(b);
            if (read > 0) {
                this.markpos = -1;
                this.pos = 0;
                this.count = read;
            }
            return read;
        }
        byte[] array;
        if (this.markpos == 0 && this.marklimit > b.length && this.count == b.length) {
            int marklimit;
            if ((marklimit = b.length * 2) > this.marklimit) {
                marklimit = this.marklimit;
            }
            if (Log.isLoggable("BufferedIs", 3)) {
                Log.d("BufferedIs", "allocate buffer of length: " + marklimit);
            }
            array = new byte[marklimit];
            System.arraycopy(b, 0, array, 0, b.length);
            this.buf = array;
        }
        else {
            array = b;
            if (this.markpos > 0) {
                System.arraycopy(b, this.markpos, b, 0, b.length - this.markpos);
                array = b;
            }
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        final int read2 = inputStream.read(array, this.pos, array.length - this.pos);
        int pos;
        if (read2 <= 0) {
            pos = this.pos;
        }
        else {
            pos = this.pos + read2;
        }
        this.count = pos;
        return read2;
    }
    
    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }
    
    @Override
    public int available() throws IOException {
        synchronized (this) {
            final InputStream in = this.in;
            if (this.buf == null || in == null) {
                throw streamClosed();
            }
        }
        final int count = this.count;
        final int pos = this.pos;
        final InputStream inputStream;
        final int available = inputStream.available();
        // monitorexit(this)
        return count - pos + available;
    }
    
    @Override
    public void close() throws IOException {
        this.buf = null;
        final InputStream in = this.in;
        this.in = null;
        if (in != null) {
            in.close();
        }
    }
    
    public void fixMarkLimit() {
        synchronized (this) {
            this.marklimit = this.buf.length;
        }
    }
    
    @Override
    public void mark(final int b) {
        synchronized (this) {
            this.marklimit = Math.max(this.marklimit, b);
            this.markpos = this.pos;
        }
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public int read() throws IOException {
        int n = -1;
        final byte[] buf;
        synchronized (this) {
            buf = this.buf;
            final InputStream in = this.in;
            if (buf == null || in == null) {
                throw streamClosed();
            }
        }
        final InputStream inputStream;
        if (this.pos < this.count || this.fillbuf(inputStream, buf) != -1) {
            byte[] buf2;
            if ((buf2 = buf) != this.buf && (buf2 = this.buf) == null) {
                throw streamClosed();
            }
            if (this.count - this.pos > 0) {
                n = (buf2[this.pos++] & 0xFF);
            }
        }
        // monitorexit(this)
        return n;
    }
    
    @Override
    public int read(final byte[] array, int off, final int n) throws IOException {
        final int n2 = -1;
        byte[] buf;
        synchronized (this) {
            buf = this.buf;
            if (buf == null) {
                throw streamClosed();
            }
        }
        Label_0031: {
            if (n == 0) {
                off = 0;
            }
            else {
                final InputStream in = this.in;
                if (in == null) {
                    throw streamClosed();
                }
                Label_0132: {
                    if (this.pos >= this.count) {
                        final int i = n;
                        break Label_0132;
                    }
                    int n3;
                    if (this.count - this.pos >= n) {
                        n3 = n;
                    }
                    else {
                        n3 = this.count - this.pos;
                    }
                    final byte[] b;
                    System.arraycopy(buf, this.pos, b, off, n3);
                    this.pos += n3;
                    if (n3 != n && in.available() != 0) {
                        off += n3;
                        final int i = n - n3;
                        break Label_0132;
                    }
                    off = n3;
                    break Label_0031;
                    int i = 0;
                    do {
                        if (in.available() == 0) {
                            off = n - i;
                            break Label_0031;
                        }
                        int n4 = 0;
                        off += n4;
                        byte[] buf2 = null;
                        buf = buf2;
                        if (this.markpos == -1 && i >= buf.length) {
                            final int read = in.read(b, off, i);
                            buf2 = buf;
                            if ((n4 = read) == -1) {
                                off = n2;
                                if (i != n) {
                                    off = n - i;
                                }
                                break Label_0031;
                            }
                        }
                        else if (this.fillbuf(in, buf) == -1) {
                            off = n2;
                            if (i != n) {
                                off = n - i;
                            }
                            break Label_0031;
                        }
                        else {
                            if ((buf2 = buf) != this.buf && (buf2 = this.buf) == null) {
                                throw streamClosed();
                            }
                            if (this.count - this.pos >= i) {
                                n4 = i;
                            }
                            else {
                                n4 = this.count - this.pos;
                            }
                            System.arraycopy(buf2, this.pos, b, off, n4);
                            this.pos += n4;
                        }
                        i -= n4;
                    } while (i != 0);
                }
                off = n;
            }
        }
        // monitorexit(this)
        return off;
    }
    
    @Override
    public void reset() throws IOException {
        synchronized (this) {
            if (this.buf == null) {
                throw new IOException("Stream is closed");
            }
        }
        if (-1 == this.markpos) {
            throw new InvalidMarkException("Mark has been invalidated");
        }
        this.pos = this.markpos;
    }
    // monitorexit(this)
    
    @Override
    public long skip(long skip) throws IOException {
        final InputStream in;
        synchronized (this) {
            final byte[] buf = this.buf;
            in = this.in;
            if (buf == null) {
                throw streamClosed();
            }
        }
        if (skip < 1L) {
            skip = 0L;
        }
        else {
            if (in == null) {
                throw streamClosed();
            }
            if (this.count - this.pos >= skip) {
                this.pos += (int)skip;
            }
            else {
                final long n = this.count - this.pos;
                this.pos = this.count;
                if (this.markpos != -1 && skip <= this.marklimit) {
                    final byte[] array;
                    if (this.fillbuf(in, array) == -1) {
                        skip = n;
                    }
                    else if (this.count - this.pos >= skip - n) {
                        this.pos += (int)(skip - n);
                    }
                    else {
                        skip = this.count;
                        final long n2 = this.pos;
                        this.pos = this.count;
                        skip = skip + n - n2;
                    }
                }
                else {
                    skip = in.skip(skip - n);
                    skip += n;
                }
            }
        }
        // monitorexit(this)
        return skip;
    }
    
    public static class InvalidMarkException extends RuntimeException
    {
        private static final long serialVersionUID = -4338378848813561757L;
        
        public InvalidMarkException(final String message) {
            super(message);
        }
    }
}
