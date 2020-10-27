package com.google.android.gms.internal.ads;

final class zzbog implements zzdqx<zzbny> {
    private final /* synthetic */ zzdqx zzfld;
    private final /* synthetic */ zzbod zzfle;

    zzbog(zzbod zzbod, zzdqx zzdqx) {
        this.zzfle = zzbod;
        this.zzfld = zzdqx;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfle.zza(((zzbny) obj).zzfkv, this.zzfld);
    }

    public final void zzb(Throwable th) {
        this.zzfld.zzb(th);
        this.zzfle.zzaic();
    }
}
