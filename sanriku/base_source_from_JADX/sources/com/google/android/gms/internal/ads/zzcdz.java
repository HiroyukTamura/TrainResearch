package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzcdz implements zzdqx<zzbek> {
    private final /* synthetic */ String zzfwk;
    private final /* synthetic */ Map zzfwl;

    zzcdz(zzcdt zzcdt, String str, Map map) {
        this.zzfwk = str;
        this.zzfwl = map;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbek) obj).zza(this.zzfwk, this.zzfwl);
    }

    public final void zzb(Throwable th) {
    }
}
