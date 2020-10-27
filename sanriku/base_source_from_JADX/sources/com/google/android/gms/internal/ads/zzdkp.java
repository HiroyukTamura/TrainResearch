package com.google.android.gms.internal.ads;

final class zzdkp implements zzdqx<O> {
    private final /* synthetic */ zzdkd zzgzk;
    private final /* synthetic */ zzdkm zzgzl;

    zzdkp(zzdkm zzdkm, zzdkd zzdkd) {
        this.zzgzl = zzdkm;
        this.zzgzk = zzdkd;
    }

    public final void onSuccess(O o) {
        this.zzgzl.zzgzf.zzgzd.zzc(this.zzgzk);
    }

    public final void zzb(Throwable th) {
        this.zzgzl.zzgzf.zzgzd.zza(this.zzgzk, th);
    }
}
