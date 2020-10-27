package com.google.android.gms.internal.ads;

final class zzdji implements zzdqx<zzdiv<AdT>> {
    private final /* synthetic */ zzdjd zzgyk;

    zzdji(zzdjd zzdjd) {
        this.zzgyk = zzdjd;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdiv zzdiv = (zzdiv) obj;
        synchronized (this.zzgyk) {
            this.zzgyk.zzgye.zza(zzdiv);
            if (this.zzgyk.zzgyd != zzdit.zzgxm) {
                this.zzgyk.zzgrx.zza(this.zzgyk.zzgya.zzarl(), zzdiv);
            }
            if (this.zzgyk.zzgyd == zzdit.zzgxl) {
                this.zzgyk.zzd(this.zzgyk.zzgya);
            }
            int unused = this.zzgyk.zzgyd = zzdit.zzgxl;
            this.zzgyk.zzgyb.set(zzdiv);
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgyk) {
            this.zzgyk.zzgye.zzb(th);
            this.zzgyk.zzgyb.setException(th);
        }
    }
}
