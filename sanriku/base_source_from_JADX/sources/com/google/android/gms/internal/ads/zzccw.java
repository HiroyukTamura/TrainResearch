package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzccw {
    private final Executor zzfhi;
    private final zzbvs zzfqg;
    private final zzbky zzfvv;

    zzccw(Executor executor, zzbky zzbky, zzbvs zzbvs) {
        this.zzfhi = executor;
        this.zzfqg = zzbvs;
        this.zzfvv = zzbky;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbek zzbek, Map map) {
        this.zzfvv.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbek zzbek, Map map) {
        this.zzfvv.enable();
    }

    public final void zzl(zzbek zzbek) {
        if (zzbek != null) {
            this.zzfqg.zzu(zzbek.getView());
            this.zzfqg.zza(new zzccz(zzbek), this.zzfhi);
            this.zzfqg.zza(new zzccy(zzbek), this.zzfhi);
            this.zzfqg.zza(this.zzfvv, this.zzfhi);
            this.zzfvv.zzg(zzbek);
            zzbek.zza("/trackActiveViewUnit", (zzaga<? super zzbek>) new zzcdb(this));
            zzbek.zza("/untrackActiveViewUnit", (zzaga<? super zzbek>) new zzcda(this));
        }
    }
}
