package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzbos implements zzdqx<zzarj> {
    private final /* synthetic */ zzboq zzflt;

    zzbos(zzboq zzboq) {
        this.zzflt = zzboq;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        zzarj zzarj = (zzarj) obj;
        this.zzflt.zzflp.zzbg(true);
    }

    public final void zzb(Throwable th) {
        this.zzflt.zzflp.zzbg(false);
    }
}
