package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdqb<I, O> extends zzdpy<I, O, zzdqj<? super I, ? extends O>, zzdri<? extends O>> {
    zzdqb(zzdri<? extends I> zzdri, zzdqj<? super I, ? extends O> zzdqj) {
        super(zzdri, zzdqj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdri) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, @NullableDecl Object obj2) throws Exception {
        zzdqj zzdqj = (zzdqj) obj;
        zzdri zzf = zzdqj.zzf(obj2);
        zzdoj.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdqj);
        return zzf;
    }
}
