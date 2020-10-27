package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

final /* synthetic */ class zzk implements Runnable {
    private final zzl zzdkp;
    private final Drawable zzdkq;

    zzk(zzl zzl, Drawable drawable) {
        this.zzdkp = zzl;
        this.zzdkq = drawable;
    }

    public final void run() {
        zzl zzl = this.zzdkp;
        zzl.zzdkr.zzaad.getWindow().setBackgroundDrawable(this.zzdkq);
    }
}
