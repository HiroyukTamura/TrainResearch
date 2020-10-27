package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzbyy implements zzaga<Object> {
    private WeakReference<zzbyx> zzfqq;

    private zzbyy(zzbyx zzbyx) {
        this.zzfqq = new WeakReference<>(zzbyx);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzbyx zzbyx = (zzbyx) this.zzfqq.get();
        if (zzbyx != null) {
            zzbyx.zzfqc.onAdImpression();
        }
    }
}
