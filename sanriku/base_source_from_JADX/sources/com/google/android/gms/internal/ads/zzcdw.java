package com.google.android.gms.internal.ads;

final class zzcdw implements zzdqx<zzbek> {
    private final /* synthetic */ String zzeio;
    private final /* synthetic */ zzaga zzfwj;

    zzcdw(zzcdt zzcdt, String str, zzaga zzaga) {
        this.zzeio = str;
        this.zzfwj = zzaga;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbek) obj).zzb(this.zzeio, this.zzfwj);
    }

    public final void zzb(Throwable th) {
    }
}
