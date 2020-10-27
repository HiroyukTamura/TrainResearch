package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqd;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdqk<V> extends zzdqd<Object, V> {
    /* access modifiers changed from: private */
    public zzdqm<?> zzhhp;

    zzdqk(zzdot<? extends zzdri<?>> zzdot, boolean z, Executor executor, Callable<V> callable) {
        super(zzdot, z, false);
        this.zzhhp = new zzdqn(this, callable, executor);
        zzawi();
    }

    /* access modifiers changed from: protected */
    public final void interruptTask() {
        zzdqm<?> zzdqm = this.zzhhp;
        if (zzdqm != null) {
            zzdqm.interruptTask();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdqd.zza zza) {
        super.zza(zza);
        if (zza == zzdqd.zza.OUTPUT_FUTURE_DONE) {
            this.zzhhp = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzawj() {
        zzdqm<?> zzdqm = this.zzhhp;
        if (zzdqm != null) {
            zzdqm.execute();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, @NullableDecl Object obj) {
    }
}
