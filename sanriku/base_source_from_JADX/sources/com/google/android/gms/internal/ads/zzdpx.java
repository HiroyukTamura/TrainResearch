package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdpx<V, X extends Throwable> extends zzdpv<V, X, zzdnx<? super X, ? extends V>, V> {
    zzdpx(zzdri<? extends V> zzdri, Class<X> cls, zzdnx<? super X, ? extends V> zzdnx) {
        super(zzdri, cls, zzdnx);
    }

    /* access modifiers changed from: package-private */
    public final void setResult(@NullableDecl V v) {
        set(v);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        return ((zzdnx) obj).apply(th);
    }
}
