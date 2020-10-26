// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import java.util.NoSuchElementException;
import com.google.android.gms.common.internal.zzbo;
import java.util.Iterator;

public class zzb<T> implements Iterator<T>
{
    protected final DataBuffer<T> zzaFu;
    protected int zzaFv;
    
    public zzb(final DataBuffer<T> dataBuffer) {
        this.zzaFu = zzbo.zzu(dataBuffer);
        this.zzaFv = -1;
    }
    
    @Override
    public boolean hasNext() {
        return this.zzaFv < this.zzaFu.getCount() - 1;
    }
    
    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.zzaFv).toString());
        }
        final DataBuffer<T> zzaFu = this.zzaFu;
        final int zzaFv = this.zzaFv + 1;
        this.zzaFv = zzaFv;
        return zzaFu.get(zzaFv);
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
