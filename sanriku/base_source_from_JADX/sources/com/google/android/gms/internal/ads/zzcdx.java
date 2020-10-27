package com.google.android.gms.internal.ads;

final class zzcdx implements zzdqx<zzbek> {
    private final /* synthetic */ String zzeio;
    private final /* synthetic */ zzaga zzfwj;

    zzcdx(zzcdt zzcdt, String str, zzaga zzaga) {
        this.zzeio = str;
        this.zzfwj = zzaga;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbek) obj).zza(this.zzeio, (zzaga<? super zzbek>) this.zzfwj);
    }

    public final void zzb(Throwable th) {
    }
}
