package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdbr implements Callable {
    private final zzdbs zzgpn;

    zzdbr(zzdbs zzdbs) {
        this.zzgpn = zzdbs;
    }

    public final Object call() {
        zzdbs zzdbs = this.zzgpn;
        return new zzdbp(zzdbs.zzgpo.zzf(zzdbs.zzvf));
    }
}
