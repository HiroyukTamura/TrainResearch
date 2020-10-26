// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Iterator;
import java.io.Reader;

class MultiReader extends Reader
{
    private Reader current;
    private final Iterator<? extends CharSource> it;
    
    MultiReader(final Iterator<? extends CharSource> it) throws IOException {
        this.it = it;
        this.advance();
    }
    
    private void advance() throws IOException {
        this.close();
        if (this.it.hasNext()) {
            this.current = ((CharSource)this.it.next()).openStream();
        }
    }
    
    @Override
    public void close() throws IOException {
        if (this.current == null) {
            return;
        }
        try {
            this.current.close();
        }
        finally {
            this.current = null;
        }
    }
    
    @Override
    public int read(@Nullable final char[] array, final int n, final int n2) throws IOException {
        int read;
        if (this.current == null) {
            read = -1;
        }
        else if ((read = this.current.read(array, n, n2)) == -1) {
            this.advance();
            return this.read(array, n, n2);
        }
        return read;
    }
    
    @Override
    public boolean ready() throws IOException {
        return this.current != null && this.current.ready();
    }
    
    @Override
    public long skip(final long n) throws IOException {
        Preconditions.checkArgument(n >= 0L, (Object)"n is negative");
        if (n > 0L) {
            while (this.current != null) {
                final long skip = this.current.skip(n);
                if (skip > 0L) {
                    return skip;
                }
                this.advance();
            }
        }
        return 0L;
    }
}
