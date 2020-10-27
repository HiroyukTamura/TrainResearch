package com.google.android.gms.internal.ads;

final class zzajo implements zzban<zzais> {
    private final /* synthetic */ zzajf zzdcy;
    private final /* synthetic */ zzajw zzddc;

    zzajo(zzajf zzajf, zzajw zzajw) {
        this.zzdcy = zzajf;
        this.zzddc = zzajw;
    }

    public final /* synthetic */ void zzh(Object obj) {
        zzais zzais = (zzais) obj;
        synchronized (this.zzdcy.lock) {
            int unused = this.zzdcy.status = 0;
            if (!(this.zzdcy.zzdcs == null || this.zzddc == this.zzdcy.zzdcs)) {
                zzawr.zzeg("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdcy.zzdcs.zzsz();
            }
            zzajw unused2 = this.zzdcy.zzdcs = this.zzddc;
        }
    }
}
