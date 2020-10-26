// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.nio.CharBuffer;
import java.io.IOException;
import com.google.common.base.Preconditions;
import java.io.Reader;

final class CharSequenceReader extends Reader
{
    private int mark;
    private int pos;
    private CharSequence seq;
    
    public CharSequenceReader(final CharSequence charSequence) {
        this.seq = Preconditions.checkNotNull(charSequence);
    }
    
    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }
    
    private boolean hasRemaining() {
        return this.remaining() > 0;
    }
    
    private int remaining() {
        return this.seq.length() - this.pos;
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this) {
            this.seq = null;
        }
    }
    
    @Override
    public void mark(final int i) throws IOException {
        boolean b = true;
        // monitorenter(this)
        Label_0040: {
            if (i < 0) {
                break Label_0040;
            }
            try {
                while (true) {
                    Preconditions.checkArgument(b, "readAheadLimit (%s) may not be negative", i);
                    this.checkOpen();
                    this.mark = this.pos;
                    return;
                    b = false;
                    continue;
                }
            }
            finally {
            }
            // monitorexit(this)
        }
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public int read() throws IOException {
        synchronized (this) {
            this.checkOpen();
            int char1;
            if (this.hasRemaining()) {
                char1 = this.seq.charAt(this.pos++);
            }
            else {
                char1 = -1;
            }
            return char1;
        }
    }
    
    @Override
    public int read(final CharBuffer charBuffer) throws IOException {
        synchronized (this) {
            Preconditions.checkNotNull(charBuffer);
            this.checkOpen();
            int n;
            if (!this.hasRemaining()) {
                n = -1;
            }
            else {
                final int min = Math.min(charBuffer.remaining(), this.remaining());
                int n2 = 0;
                while (true) {
                    n = min;
                    if (n2 >= min) {
                        break;
                    }
                    charBuffer.put(this.seq.charAt(this.pos++));
                    ++n2;
                }
            }
            return n;
        }
    }
    
    @Override
    public int read(final char[] array, final int n, int a) throws IOException {
        synchronized (this) {
            Preconditions.checkPositionIndexes(n, n + a, array.length);
            this.checkOpen();
            int n2;
            if (!this.hasRemaining()) {
                n2 = -1;
            }
            else {
                final int min = Math.min(a, this.remaining());
                a = 0;
                while (true) {
                    n2 = min;
                    if (a >= min) {
                        break;
                    }
                    array[n + a] = this.seq.charAt(this.pos++);
                    ++a;
                }
            }
            return n2;
        }
    }
    
    @Override
    public boolean ready() throws IOException {
        synchronized (this) {
            this.checkOpen();
            return true;
        }
    }
    
    @Override
    public void reset() throws IOException {
        synchronized (this) {
            this.checkOpen();
            this.pos = this.mark;
        }
    }
    
    @Override
    public long skip(long n) throws IOException {
        boolean b = true;
        // monitorenter(this)
        Label_0061: {
            if (n < 0L) {
                break Label_0061;
            }
            try {
                while (true) {
                    Preconditions.checkArgument(b, "n (%s) may not be negative", n);
                    this.checkOpen();
                    final int n2 = (int)Math.min(this.remaining(), n);
                    this.pos += n2;
                    n = n2;
                    return n;
                    b = false;
                    continue;
                }
            }
            finally {
            }
            // monitorexit(this)
        }
    }
}
