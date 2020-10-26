// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzban extends zzbam
{
    protected final TaskCompletionSource<Void> zzalE;
    
    public zzban(final int n, final TaskCompletionSource<Void> zzalE) {
        super(n);
        this.zzalE = zzalE;
    }
    
    @Override
    public void zza(@NonNull final zzbbt zzbbt, final boolean b) {
    }
    
    @Override
    public final void zza(final zzbdd<?> zzbdd) throws DeadObjectException {
        try {
            this.zzb(zzbdd);
        }
        catch (DeadObjectException ex) {
            this.zzp(zza((RemoteException)ex));
            throw ex;
        }
        catch (RemoteException ex2) {
            this.zzp(zza(ex2));
        }
    }
    
    protected abstract void zzb(final zzbdd<?> p0) throws RemoteException;
    
    @Override
    public void zzp(@NonNull final Status status) {
        this.zzalE.trySetException(new ApiException(status));
    }
}
