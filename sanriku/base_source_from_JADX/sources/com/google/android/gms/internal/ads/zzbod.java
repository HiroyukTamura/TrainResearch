package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzbod {
    private final Executor executor;
    private volatile boolean zzaef = true;
    private final ScheduledExecutorService zzfky;
    private final zzdri<zzbny> zzfkz;

    public zzbod(Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdri<zzbny> zzdri) {
        this.executor = executor2;
        this.zzfky = scheduledExecutorService;
        this.zzfkz = zzdri;
    }

    /* access modifiers changed from: private */
    public final void zza(List<? extends zzdri<? extends zzbns>> list, zzdqx<zzbns> zzdqx) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new zzboc(zzdqx));
            return;
        }
        zzdri<O> zzag = zzdqw.zzag(null);
        for (zzdri zzboe : list) {
            zzag = zzdqw.zzb(zzdqw.zzb(zzag, Throwable.class, new zzbof(zzdqx), this.executor), new zzboe(this, zzdqx, zzboe), this.executor);
        }
        zzdqw.zza(zzag, new zzboj(this, zzdqx), this.executor);
    }

    /* access modifiers changed from: private */
    public final void zzaic() {
        zzbab.zzdzv.execute(new zzboh(this));
    }

    public final boolean isLoading() {
        return this.zzaef;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdqx zzdqx, zzdri zzdri, zzbns zzbns) throws Exception {
        if (zzbns != null) {
            zzdqx.onSuccess(zzbns);
        }
        return zzdqw.zza(zzdri, zzabx.zzcxy.get().longValue(), TimeUnit.MILLISECONDS, this.zzfky);
    }

    public final void zza(zzdqx<zzbns> zzdqx) {
        zzdqw.zza(this.zzfkz, new zzbog(this, zzdqx), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaid() {
        this.zzaef = false;
    }
}
