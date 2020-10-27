package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzalj implements Runnable {
    private final Context zzchn;
    private final zzalh zzdeo;

    zzalj(zzalh zzalh, Context context) {
        this.zzdeo = zzalh;
        this.zzchn = context;
    }

    public final void run() {
        zzalh.zzn(this.zzchn);
    }
}
