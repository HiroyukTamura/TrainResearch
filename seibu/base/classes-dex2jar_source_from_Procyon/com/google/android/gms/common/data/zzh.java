// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public final class zzh<T> extends zzb<T>
{
    private T zzaFQ;
    
    public zzh(final DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }
    
    @Override
    public final T next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.zzaFv).toString());
        }
        ++this.zzaFv;
        if (this.zzaFv == 0) {
            this.zzaFQ = this.zzaFu.get(0);
            if (!(this.zzaFQ instanceof zzc)) {
                final String value = String.valueOf(this.zzaFQ.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(value).length() + 44).append("DataBuffer reference of type ").append(value).append(" is not movable").toString());
            }
        }
        else {
            ((zzc)this.zzaFQ).zzar(this.zzaFv);
        }
        return this.zzaFQ;
    }
}
