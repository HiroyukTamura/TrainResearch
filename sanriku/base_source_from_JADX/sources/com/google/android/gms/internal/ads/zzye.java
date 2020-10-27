package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzye extends zzwz {
    private final String description;
    private final String zzchq;

    public zzye(String str, String str2) {
        this.description = str;
        this.zzchq = str2;
    }

    public final String getDescription() throws RemoteException {
        return this.description;
    }

    public final String zzqe() throws RemoteException {
        return this.zzchq;
    }
}
