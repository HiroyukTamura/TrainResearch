// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import android.os.RemoteException;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;

public final class zzbaq<TResult> extends zzbam
{
    private final zzbeq<Api.zzb, TResult> zzaBw;
    private final zzbem zzaBx;
    private final TaskCompletionSource<TResult> zzalE;
    
    public zzbaq(final int n, final zzbeq<Api.zzb, TResult> zzaBw, final TaskCompletionSource<TResult> zzalE, final zzbem zzaBx) {
        super(n);
        this.zzalE = zzalE;
        this.zzaBw = zzaBw;
        this.zzaBx = zzaBx;
    }
    
    @Override
    public final void zza(@NonNull final zzbbt zzbbt, final boolean b) {
        zzbbt.zza(this.zzalE, b);
    }
    
    @Override
    public final void zza(final zzbdd<?> zzbdd) throws DeadObjectException {
        try {
            this.zzaBw.zza(zzbdd.zzpJ(), this.zzalE);
        }
        catch (DeadObjectException ex) {
            throw ex;
        }
        catch (RemoteException ex2) {
            this.zzp(zza(ex2));
        }
    }
    
    @Override
    public final void zzp(@NonNull final Status status) {
        this.zzalE.trySetException(this.zzaBx.zzq(status));
    }
}
