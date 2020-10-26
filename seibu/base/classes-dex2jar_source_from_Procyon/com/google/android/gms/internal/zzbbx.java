// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzbbx<L> implements zzbdz<L>
{
    private final DataHolder zzaCX;
    
    protected zzbbx(final DataHolder zzaCX) {
        this.zzaCX = zzaCX;
    }
    
    protected abstract void zza(final L p0, final DataHolder p1);
    
    @Override
    public final void zzpT() {
        if (this.zzaCX != null) {
            this.zzaCX.close();
        }
    }
    
    @Override
    public final void zzq(final L l) {
        this.zza(l, this.zzaCX);
    }
}
