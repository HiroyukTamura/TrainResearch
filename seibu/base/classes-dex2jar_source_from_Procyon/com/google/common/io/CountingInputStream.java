// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.IOException;
import javax.annotation.Nullable;
import java.io.InputStream;
import com.google.common.annotations.Beta;
import java.io.FilterInputStream;

@Beta
public final class CountingInputStream extends FilterInputStream
{
    private long count;
    private long mark;
    
    public CountingInputStream(@Nullable final InputStream in) {
        super(in);
        this.mark = -1L;
    }
    
    public long getCount() {
        return this.count;
    }
    
    @Override
    public void mark(final int readlimit) {
        synchronized (this) {
            this.in.mark(readlimit);
            this.mark = this.count;
        }
    }
    
    @Override
    public int read() throws IOException {
        final int read = this.in.read();
        if (read != -1) {
            ++this.count;
        }
        return read;
    }
    
    @Override
    public int read(final byte[] b, int read, final int len) throws IOException {
        read = this.in.read(b, read, len);
        if (read != -1) {
            this.count += read;
        }
        return read;
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
        this.count = this.mark;
    }
    // monitorexit(this)
    
    @Override
    public long skip(long skip) throws IOException {
        skip = this.in.skip(skip);
        this.count += skip;
        return skip;
    }
}
