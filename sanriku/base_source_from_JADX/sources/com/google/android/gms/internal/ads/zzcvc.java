package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcvc implements zzdqj<zzarj, zzcvd> {
    private Executor executor;
    private zzckv zzglf;

    public zzcvc(Executor executor2, zzckv zzckv) {
        this.executor = executor2;
        this.zzglf = zzckv;
    }

    public final /* synthetic */ zzdri zzf(Object obj) throws Exception {
        zzarj zzarj = (zzarj) obj;
        return zzdqw.zzb(this.zzglf.zzh(zzarj), new zzcvb(zzarj), this.executor);
    }
}
