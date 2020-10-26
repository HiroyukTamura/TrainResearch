// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zzbft extends zzbfn
{
    private final zzbaz<Status> zzaIz;
    
    public zzbft(final zzbaz<Status> zzaIz) {
        this.zzaIz = zzaIz;
    }
    
    @Override
    public final void zzaC(final int n) throws RemoteException {
        this.zzaIz.setResult(new Status(n));
    }
}
