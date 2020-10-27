package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;

public final class zzcsx {
    private final zzcfz zzgac;
    private final ConcurrentHashMap<String, zzanv> zzgiq = new ConcurrentHashMap<>();

    public zzcsx(zzcfz zzcfz) {
        this.zzgac = zzcfz;
    }

    public final void zzgm(String str) {
        try {
            this.zzgiq.put(str, this.zzgac.zzdk(str));
        } catch (RemoteException e) {
            zzazw.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    public final zzanv zzgn(String str) {
        if (this.zzgiq.containsKey(str)) {
            return this.zzgiq.get(str);
        }
        return null;
    }
}
