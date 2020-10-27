package com.google.android.gms.internal.ads;

final class zzdrv extends zzdre<zzdri<V>> {
    private final zzdqh<V> zzhiq;
    private final /* synthetic */ zzdrw zzhir;

    zzdrv(zzdrw zzdrw, zzdqh<V> zzdqh) {
        this.zzhir = zzdrw;
        this.zzhiq = (zzdqh) zzdoj.checkNotNull(zzdqh);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzhir.isDone();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzawn() throws Exception {
        return (zzdri) zzdoj.zza(this.zzhiq.zzaql(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzhiq);
    }

    /* access modifiers changed from: package-private */
    public final String zzawo() {
        return this.zzhiq.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzdri zzdri = (zzdri) obj;
        if (th == null) {
            this.zzhir.setFuture(zzdri);
        } else {
            this.zzhir.setException(th);
        }
    }
}
