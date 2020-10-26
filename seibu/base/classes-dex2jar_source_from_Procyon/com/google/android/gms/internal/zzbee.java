// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;

public abstract class zzbee<A extends Api.zzb, L>
{
    private final zzbdw<L> zzaEU;
    
    protected zzbee(final zzbdw<L> zzaEU) {
        this.zzaEU = zzaEU;
    }
    
    protected abstract void zzb(final A p0, final TaskCompletionSource<Void> p1) throws RemoteException;
    
    public final zzbdy<L> zzqG() {
        return this.zzaEU.zzqG();
    }
    
    public final void zzqH() {
        this.zzaEU.clear();
    }
}
