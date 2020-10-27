package com.google.android.gms.internal.ads;

public final class zzdbx implements zzdak<zzdby> {
    private String packageName;
    private zzdrh zzfur;
    private zzavv zzgpr;

    public zzdbx(zzavv zzavv, zzdrh zzdrh, String str) {
        this.zzgpr = zzavv;
        this.zzfur = zzdrh;
        this.packageName = str;
    }

    public final zzdri<zzdby> zzaqa() {
        new zzbaj();
        zzdri<String> zzag = zzdqw.zzag(null);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsf)).booleanValue()) {
            zzag = this.zzgpr.zzee(this.packageName);
        }
        zzdri<String> zzef = this.zzgpr.zzef(this.packageName);
        return zzdqw.zzb((zzdri<? extends V>[]) new zzdri[]{zzag, zzef}).zza(new zzdca(zzag, zzef), zzbab.zzdzr);
    }
}
