package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class zzdqn extends zzdqm<V> {
    private final /* synthetic */ zzdqk zzhhs;
    private final Callable<V> zzhht;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdqn(zzdqk zzdqk, Callable<V> callable, Executor executor) {
        super(zzdqk, executor);
        this.zzhhs = zzdqk;
        this.zzhht = (Callable) zzdoj.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    public final void setValue(V v) {
        this.zzhhs.set(v);
    }

    /* access modifiers changed from: package-private */
    public final V zzawn() throws Exception {
        this.zzhhr = false;
        return this.zzhht.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzawo() {
        return this.zzhht.toString();
    }
}
