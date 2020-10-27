package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzcle implements zzdqj {
    static final zzdqj zzbly = new zzcle();

    private zzcle() {
    }

    public final zzdri zzf(Object obj) {
        return zzdqw.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
