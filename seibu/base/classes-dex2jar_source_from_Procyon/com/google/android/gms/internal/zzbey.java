// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;

public abstract class zzbey<A extends Api.zzb, L>
{
    private final zzbdy<L> zzaEN;
    
    protected zzbey(final zzbdy<L> zzaEN) {
        this.zzaEN = zzaEN;
    }
    
    protected abstract void zzc(final A p0, final TaskCompletionSource<Void> p1) throws RemoteException;
    
    public final zzbdy<L> zzqG() {
        return this.zzaEN;
    }
}
