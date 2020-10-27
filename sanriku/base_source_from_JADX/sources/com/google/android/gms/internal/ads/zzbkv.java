package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

public final class zzbkv implements zzegz<zzpu> {
    private final zzehm<JSONObject> zzeza;
    private final zzehm<zzdgo> zzfia;
    private final zzehm<zzazz> zzfib;
    private final zzehm<String> zzfic;

    private zzbkv(zzehm<zzdgo> zzehm, zzehm<zzazz> zzehm2, zzehm<JSONObject> zzehm3, zzehm<String> zzehm4) {
        this.zzfia = zzehm;
        this.zzfib = zzehm2;
        this.zzeza = zzehm3;
        this.zzfic = zzehm4;
    }

    public static zzbkv zza(zzehm<zzdgo> zzehm, zzehm<zzazz> zzehm2, zzehm<JSONObject> zzehm3, zzehm<String> zzehm4) {
        return new zzbkv(zzehm, zzehm2, zzehm3, zzehm4);
    }

    public final /* synthetic */ Object get() {
        zzdgo zzdgo = this.zzfia.get();
        String str = this.zzfic.get();
        boolean equals = "native".equals(str);
        zzq.zzkw();
        return (zzpu) zzehf.zza(new zzpu(zzaxa.zzxg(), this.zzfib.get(), str, this.zzeza.get(), false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
