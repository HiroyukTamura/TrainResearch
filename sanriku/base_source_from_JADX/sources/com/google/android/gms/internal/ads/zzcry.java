package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsf;

public final class zzcry<AdT, AdapterT, ListenerT extends zzbsf> implements zzegz<zzcru<AdT, AdapterT, ListenerT>> {
    private final zzehm<zzcnk<AdapterT, ListenerT>> zzffw;
    private final zzehm<zzdrh> zzfjj;
    private final zzehm<zzdku> zzfju;
    private final zzehm<zzcnm<AdT, AdapterT, ListenerT>> zzght;

    private zzcry(zzehm<zzdku> zzehm, zzehm<zzdrh> zzehm2, zzehm<zzcnk<AdapterT, ListenerT>> zzehm3, zzehm<zzcnm<AdT, AdapterT, ListenerT>> zzehm4) {
        this.zzfju = zzehm;
        this.zzfjj = zzehm2;
        this.zzffw = zzehm3;
        this.zzght = zzehm4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbsf> zzcry<AdT, AdapterT, ListenerT> zzd(zzehm<zzdku> zzehm, zzehm<zzdrh> zzehm2, zzehm<zzcnk<AdapterT, ListenerT>> zzehm3, zzehm<zzcnm<AdT, AdapterT, ListenerT>> zzehm4) {
        return new zzcry<>(zzehm, zzehm2, zzehm3, zzehm4);
    }

    public final /* synthetic */ Object get() {
        return new zzcru(this.zzfju.get(), this.zzfjj.get(), this.zzffw.get(), this.zzght.get());
    }
}
