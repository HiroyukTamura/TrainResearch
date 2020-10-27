package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class zzdry extends zzdre<V> {
    private final Callable<V> zzhht;
    private final /* synthetic */ zzdrw zzhir;

    zzdry(zzdrw zzdrw, Callable<V> callable) {
        this.zzhir = zzdrw;
        this.zzhht = (Callable) zzdoj.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzhir.isDone();
    }

    /* access modifiers changed from: package-private */
    public final V zzawn() throws Exception {
        return this.zzhht.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzawo() {
        return this.zzhht.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzhir.set(v);
        } else {
            this.zzhir.setException(th);
        }
    }
}
