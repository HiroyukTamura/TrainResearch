// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;

public final class zzbap extends zzban
{
    private zzbee<Api.zzb, ?> zzaBu;
    private zzbey<Api.zzb, ?> zzaBv;
    
    public zzbap(final zzbef zzbef, final TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zzaBu = zzbef.zzaBu;
        this.zzaBv = zzbef.zzaBv;
    }
    
    public final void zzb(final zzbdd<?> zzbdd) throws RemoteException {
        this.zzaBu.zzb(zzbdd.zzpJ(), this.zzalE);
        if (this.zzaBu.zzqG() != null) {
            zzbdd.zzqs().put(this.zzaBu.zzqG(), new zzbef(this.zzaBu, this.zzaBv));
        }
    }
}
