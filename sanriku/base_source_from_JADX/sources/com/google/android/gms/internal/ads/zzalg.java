package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzalg implements Runnable {
    private final Context zzchn;
    private final zzalh zzdeo;
    private final String zzdep;

    zzalg(zzalh zzalh, Context context, String str) {
        this.zzdeo = zzalh;
        this.zzchn = context;
        this.zzdep = str;
    }

    public final void run() {
        zzalh.zzd(this.zzchn, this.zzdep);
    }
}
