package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;

public final class zzbqc {
    private final String packageName;
    private final zzazz zzbml;
    private final PackageInfo zzdly;
    private final List<String> zzdmi;
    private final String zzdpg;
    private final zzawt zzduw;
    private final zzdku zzflm;
    private final ApplicationInfo zzfmj;
    private final zzegt<zzdri<String>> zzfmk;
    private final zzdaj<Bundle> zzfml;

    public zzbqc(zzdku zzdku, zzazz zzazz, ApplicationInfo applicationInfo, String str, List<String> list, @Nullable PackageInfo packageInfo, zzegt<zzdri<String>> zzegt, zzawt zzawt, String str2, zzdaj<Bundle> zzdaj) {
        this.zzflm = zzdku;
        this.zzbml = zzazz;
        this.zzfmj = applicationInfo;
        this.packageName = str;
        this.zzdmi = list;
        this.zzdly = packageInfo;
        this.zzfmk = zzegt;
        this.zzduw = zzawt;
        this.zzdpg = str2;
        this.zzfml = zzdaj;
    }

    public final zzdri<Bundle> zzaik() {
        return this.zzflm.zzu(zzdkr.SIGNALS).zze(this.zzfml.zzt(new Bundle())).zzaud();
    }

    public final zzdri<zzarj> zzail() {
        zzdri<Bundle> zzaik = zzaik();
        return this.zzflm.zza(zzdkr.REQUEST_PARCEL, (zzdri<?>[]) new zzdri[]{zzaik, this.zzfmk.get()}).zzb(new zzbqf(this, zzaik)).zzaud();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzarj zzc(zzdri zzdri) throws Exception {
        return new zzarj((Bundle) zzdri.get(), this.zzbml, this.zzfmj, this.packageName, this.zzdmi, this.zzdly, (String) this.zzfmk.get().get(), this.zzduw.zzwu(), this.zzdpg, (zzdir) null, (String) null);
    }
}
