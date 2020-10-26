// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T>
{
    protected final DataHolder zzaCX;
    
    protected AbstractDataBuffer(final DataHolder zzaCX) {
        this.zzaCX = zzaCX;
    }
    
    @Deprecated
    @Override
    public final void close() {
        this.release();
    }
    
    @Override
    public abstract T get(final int p0);
    
    @Override
    public int getCount() {
        if (this.zzaCX == null) {
            return 0;
        }
        return this.zzaCX.zzaFG;
    }
    
    @Deprecated
    @Override
    public boolean isClosed() {
        return this.zzaCX == null || this.zzaCX.isClosed();
    }
    
    @Override
    public Iterator<T> iterator() {
        return new zzb<T>(this);
    }
    
    @Override
    public void release() {
        if (this.zzaCX != null) {
            this.zzaCX.close();
        }
    }
    
    @Override
    public Iterator<T> singleRefIterator() {
        return new zzh<T>(this);
    }
    
    @Override
    public final Bundle zzqN() {
        return this.zzaCX.zzqN();
    }
}
