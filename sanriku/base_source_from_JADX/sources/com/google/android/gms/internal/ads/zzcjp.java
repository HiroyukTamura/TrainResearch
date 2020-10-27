package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzcjp implements zzdqj {
    static final zzdqj zzbly = new zzcjp();

    private zzcjp() {
    }

    public final zzdri zzf(Object obj) {
        return zzdqw.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
