package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

final /* synthetic */ class zzaud implements Runnable {
    private final zzaue zzdrm;
    private final Bitmap zzdrn;

    zzaud(zzaue zzaue, Bitmap bitmap) {
        this.zzdrm = zzaue;
        this.zzdrn = bitmap;
    }

    public final void run() {
        this.zzdrm.zza(this.zzdrn);
    }
}
