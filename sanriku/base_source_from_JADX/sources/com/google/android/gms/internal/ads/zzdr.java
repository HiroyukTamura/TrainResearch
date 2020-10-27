package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

final class zzdr implements Runnable {
    private final /* synthetic */ int zzxe;
    private final /* synthetic */ int zzxf;
    private final /* synthetic */ int zzxg;

    zzdr(zzdl zzdl, int i, int i2, int i3) {
        this.zzxe = i;
        this.zzxf = i2;
        this.zzxg = i3;
    }

    public final void run() {
        try {
            zzdl.zzvw.zza(MotionEvent.obtain(0, (long) this.zzxe, 0, (float) this.zzxf, (float) this.zzxg, 0));
        } catch (Exception e) {
            zzdl.zzvy.zza(2022, -1, e);
        }
    }
}
