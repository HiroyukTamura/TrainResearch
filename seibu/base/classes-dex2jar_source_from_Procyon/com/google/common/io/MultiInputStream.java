// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import javax.annotation.Nullable;
import java.io.IOException;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.io.InputStream;

final class MultiInputStream extends InputStream
{
    private InputStream in;
    private Iterator<? extends ByteSource> it;
    
    public MultiInputStream(final Iterator<? extends ByteSource> iterator) throws IOException {
        this.it = Preconditions.checkNotNull(iterator);
        this.advance();
    }
    
    private void advance() throws IOException {
        this.close();
        if (this.it.hasNext()) {
            this.in = ((ByteSource)this.it.next()).openStream();
        }
    }
    
    @Override
    public int available() throws IOException {
        if (this.in == null) {
            return 0;
        }
        return this.in.available();
    }
    
    @Override
    public void close() throws IOException {
        if (this.in == null) {
            return;
        }
        try {
            this.in.close();
        }
        finally {
            this.in = null;
        }
    }
    
    @Override
    public boolean markSupported() {
        return false;
    }
    
    @Override
    public int read() throws IOException {
        int read;
        if (this.in == null) {
            read = -1;
        }
        else if ((read = this.in.read()) == -1) {
            this.advance();
            return this.read();
        }
        return read;
    }
    
    @Override
    public int read(@Nullable final byte[] b, final int off, final int len) throws IOException {
        int read;
        if (this.in == null) {
            read = -1;
        }
        else if ((read = this.in.read(b, off, len)) == -1) {
            this.advance();
            return this.read(b, off, len);
        }
        return read;
    }
    
    @Override
    public long skip(final long n) throws IOException {
        long skip;
        if (this.in == null || n <= 0L) {
            skip = 0L;
        }
        else if ((skip = this.in.skip(n)) == 0L) {
            if (this.read() == -1) {
                return 0L;
            }
            return 1L + this.in.skip(n - 1L);
        }
        return skip;
    }
}
