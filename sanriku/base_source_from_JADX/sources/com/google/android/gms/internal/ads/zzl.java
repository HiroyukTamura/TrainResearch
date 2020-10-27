package com.google.android.gms.internal.ads;

final class zzl implements Runnable {
    private final zzq zzw;
    private final zzz zzx;
    private final Runnable zzy;

    public zzl(zzq zzq, zzz zzz, Runnable runnable) {
        this.zzw = zzq;
        this.zzx = zzz;
        this.zzy = runnable;
    }

    public final void run() {
        this.zzw.isCanceled();
        if (this.zzx.zzbi == null) {
            this.zzw.zza(this.zzx.result);
        } else {
            this.zzw.zzb(this.zzx.zzbi);
        }
        if (this.zzx.zzbj) {
            this.zzw.zzb("intermediate-response");
        } else {
            this.zzw.zzc("done");
        }
        Runnable runnable = this.zzy;
        if (runnable != null) {
            runnable.run();
        }
    }
}
