// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.iid;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzef;
import android.os.Message;
import android.os.IBinder;
import com.google.android.gms.internal.zzed;

public final class zzc extends zzed implements zzb
{
    zzc(final IBinder binder) {
        super(binder, "com.google.android.gms.iid.IMessengerCompat");
    }
    
    @Override
    public final void send(final Message message) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzef.zza(zzZ, (Parcelable)message);
        this.zzc(1, zzZ);
    }
}
