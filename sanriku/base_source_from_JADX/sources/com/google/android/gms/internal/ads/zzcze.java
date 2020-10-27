package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcze implements zzegz<zzczc> {
    private final zzehm<zzdrh> zzenm;
    private final zzehm<Bundle> zzgno;

    private zzcze(zzehm<zzdrh> zzehm, zzehm<Bundle> zzehm2) {
        this.zzenm = zzehm;
        this.zzgno = zzehm2;
    }

    public static zzcze zzay(zzehm<zzdrh> zzehm, zzehm<Bundle> zzehm2) {
        return new zzcze(zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return new zzczc(this.zzenm.get(), this.zzgno.get());
    }
}
