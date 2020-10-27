package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;

public final class zzbqe implements zzegz<zzbqc> {
    private final zzehm<zzawt> zzeqm;
    private final zzehm<zzdaj<Bundle>> zzeti;
    private final zzehm<zzazz> zzfib;
    private final zzehm<zzdku> zzfju;
    private final zzehm<ApplicationInfo> zzfmn;
    private final zzehm<String> zzfmo;
    private final zzehm<List<String>> zzfmp;
    private final zzehm<PackageInfo> zzfmq;
    private final zzehm<zzdri<String>> zzfmr;
    private final zzehm<String> zzfms;

    private zzbqe(zzehm<zzdku> zzehm, zzehm<zzazz> zzehm2, zzehm<ApplicationInfo> zzehm3, zzehm<String> zzehm4, zzehm<List<String>> zzehm5, zzehm<PackageInfo> zzehm6, zzehm<zzdri<String>> zzehm7, zzehm<zzawt> zzehm8, zzehm<String> zzehm9, zzehm<zzdaj<Bundle>> zzehm10) {
        this.zzfju = zzehm;
        this.zzfib = zzehm2;
        this.zzfmn = zzehm3;
        this.zzfmo = zzehm4;
        this.zzfmp = zzehm5;
        this.zzfmq = zzehm6;
        this.zzfmr = zzehm7;
        this.zzeqm = zzehm8;
        this.zzfms = zzehm9;
        this.zzeti = zzehm10;
    }

    public static zzbqe zza(zzehm<zzdku> zzehm, zzehm<zzazz> zzehm2, zzehm<ApplicationInfo> zzehm3, zzehm<String> zzehm4, zzehm<List<String>> zzehm5, zzehm<PackageInfo> zzehm6, zzehm<zzdri<String>> zzehm7, zzehm<zzawt> zzehm8, zzehm<String> zzehm9, zzehm<zzdaj<Bundle>> zzehm10) {
        return new zzbqe(zzehm, zzehm2, zzehm3, zzehm4, zzehm5, zzehm6, zzehm7, zzehm8, zzehm9, zzehm10);
    }

    public final /* synthetic */ Object get() {
        return new zzbqc(this.zzfju.get(), this.zzfib.get(), this.zzfmn.get(), this.zzfmo.get(), this.zzfmp.get(), this.zzfmq.get(), zzeha.zzas(this.zzfmr), this.zzeqm.get(), this.zzfms.get(), this.zzeti.get());
    }
}
