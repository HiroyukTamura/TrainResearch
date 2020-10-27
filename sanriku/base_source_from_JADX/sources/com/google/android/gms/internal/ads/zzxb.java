package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

public final class zzxb implements MuteThisAdReason {
    private final String description;
    private zzww zzcgk;

    public zzxb(zzww zzww) {
        String str;
        this.zzcgk = zzww;
        try {
            str = zzww.getDescription();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzww zzqf() {
        return this.zzcgk;
    }
}
