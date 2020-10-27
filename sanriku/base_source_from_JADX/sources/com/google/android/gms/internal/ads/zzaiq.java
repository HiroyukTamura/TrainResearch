package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class zzaiq implements Runnable {
    private final zzair zzdby;
    private final zzaga zzdbz;
    private final Map zzdca;

    zzaiq(zzair zzair, zzaga zzaga, Map map) {
        this.zzdby = zzair;
        this.zzdbz = zzaga;
        this.zzdca = map;
    }

    public final void run() {
        this.zzdby.zza(this.zzdbz, this.zzdca);
    }
}
