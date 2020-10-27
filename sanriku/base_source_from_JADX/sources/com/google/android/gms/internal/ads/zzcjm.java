package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcjm implements Callable {
    private final zzcjn zzgat;
    private final zzarj zzgau;

    zzcjm(zzcjn zzcjn, zzarj zzarj) {
        this.zzgat = zzcjn;
        this.zzgau = zzarj;
    }

    public final Object call() {
        return this.zzgat.zzf(this.zzgau);
    }
}
