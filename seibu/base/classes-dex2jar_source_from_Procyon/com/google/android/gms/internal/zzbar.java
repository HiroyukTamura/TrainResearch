// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import android.util.Log;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbar extends zzban
{
    private zzbdy<?> zzaBy;
    
    public zzbar(final zzbdy<?> zzaBy, final TaskCompletionSource<Void> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zzaBy = zzaBy;
    }
    
    public final void zzb(final zzbdd<?> zzbdd) throws RemoteException {
        final zzbef zzbef = (zzbef)zzbdd.zzqs().remove(this.zzaBy);
        if (zzbef != null) {
            zzbef.zzaBv.zzc(zzbdd.zzpJ(), this.zzalE);
            zzbef.zzaBu.zzqH();
            return;
        }
        Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", (Throwable)new Exception());
        this.zzalE.trySetException(new ApiException(Status.zzaBo));
    }
}
