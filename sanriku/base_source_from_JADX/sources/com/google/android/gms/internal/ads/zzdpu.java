package com.google.android.gms.internal.ads;

import java.lang.Throwable;

final class zzdpu<V, X extends Throwable> extends zzdpv<V, X, zzdqj<? super X, ? extends V>, zzdri<? extends V>> {
    zzdpu(zzdri<? extends V> zzdri, Class<X> cls, zzdqj<? super X, ? extends V> zzdqj) {
        super(zzdri, cls, zzdqj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdri) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        zzdqj zzdqj = (zzdqj) obj;
        zzdri zzf = zzdqj.zzf(th);
        zzdoj.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdqj);
        return zzf;
    }
}
