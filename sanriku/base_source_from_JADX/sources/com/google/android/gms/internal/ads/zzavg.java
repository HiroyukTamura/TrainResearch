package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzavg implements Callable {
    private final Context zzchn;
    private final zzauu zzdtd;

    zzavg(zzauu zzauu, Context context) {
        this.zzdtd = zzauu;
        this.zzchn = context;
    }

    public final Object call() {
        return this.zzdtd.zzaj(this.zzchn);
    }
}
