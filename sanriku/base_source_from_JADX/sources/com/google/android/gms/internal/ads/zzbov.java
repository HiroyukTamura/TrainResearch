package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzbov implements zzdqx<Void> {
    private final /* synthetic */ zzboq zzflt;

    zzbov(zzboq zzboq) {
        this.zzflt = zzboq;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        this.zzflt.zzflp.zzbh(true);
    }

    public final void zzb(Throwable th) {
        this.zzflt.zzflp.zzbh(false);
    }
}
