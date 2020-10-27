package com.google.android.gms.internal.ads;

public final class zzczf implements zzegz<zzczg> {
    private final zzehm<String> zzfyk;

    private zzczf(zzehm<String> zzehm) {
        this.zzfyk = zzehm;
    }

    public static zzczf zzao(zzehm<String> zzehm) {
        return new zzczf(zzehm);
    }

    public final /* synthetic */ Object get() {
        return new zzczg(this.zzfyk.get());
    }
}
