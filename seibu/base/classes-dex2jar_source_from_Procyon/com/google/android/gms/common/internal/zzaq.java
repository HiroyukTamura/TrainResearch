// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzaq extends zzed implements zzao
{
    zzaq(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.ICancelToken");
    }
    
    @Override
    public final void cancel() throws RemoteException {
        this.zzc(2, this.zzZ());
    }
}
