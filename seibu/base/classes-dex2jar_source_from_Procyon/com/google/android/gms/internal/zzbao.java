// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;

public final class zzbao<A extends zzbay<? extends Result, Api.zzb>> extends zzbam
{
    private A zzaBt;
    
    public zzbao(final int n, final A zzaBt) {
        super(n);
        this.zzaBt = zzaBt;
    }
    
    @Override
    public final void zza(@NonNull final zzbbt zzbbt, final boolean b) {
        zzbbt.zza(this.zzaBt, b);
    }
    
    @Override
    public final void zza(final zzbdd<?> zzbdd) throws DeadObjectException {
        ((zzbay<R, Api.zze>)this.zzaBt).zzb(zzbdd.zzpJ());
    }
    
    @Override
    public final void zzp(@NonNull final Status status) {
        this.zzaBt.zzr(status);
    }
}
