package com.google.android.gms.internal.ads;

final class zzajr implements zzbal {
    private final /* synthetic */ zzajf zzdcy;
    private final /* synthetic */ zzajw zzddc;

    zzajr(zzajf zzajf, zzajw zzajw) {
        this.zzdcy = zzajf;
        this.zzddc = zzajw;
    }

    public final void run() {
        synchronized (this.zzdcy.lock) {
            int unused = this.zzdcy.status = 1;
            zzawr.zzeg("Failed loading new engine. Marking new engine destroyable.");
            this.zzddc.zzsz();
        }
    }
}
