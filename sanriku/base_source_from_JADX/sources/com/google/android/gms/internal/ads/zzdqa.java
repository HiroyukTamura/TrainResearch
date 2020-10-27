package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdqa<I, O> extends zzdpy<I, O, zzdnx<? super I, ? extends O>, O> {
    zzdqa(zzdri<? extends I> zzdri, zzdnx<? super I, ? extends O> zzdnx) {
        super(zzdri, zzdnx);
    }

    /* access modifiers changed from: package-private */
    public final void setResult(@NullableDecl O o) {
        set(o);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* synthetic */ Object zzc(Object obj, @NullableDecl Object obj2) throws Exception {
        return ((zzdnx) obj).apply(obj2);
    }
}
