package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

public final class zzaeh extends zzgi implements zzaee {
    zzaeh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
    }

    public final void zzsj() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }
}
