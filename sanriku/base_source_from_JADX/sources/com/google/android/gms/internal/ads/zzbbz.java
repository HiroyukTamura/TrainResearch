package com.google.android.gms.internal.ads;

final class zzbbz implements Runnable {
    private boolean zzbqh = false;
    private zzbbk zzecf;

    zzbbz(zzbbk zzbbk) {
        this.zzecf = zzbbk;
    }

    private final void zzzo() {
        zzaxa.zzdwf.removeCallbacks(this);
        zzaxa.zzdwf.postDelayed(this, 250);
    }

    public final void pause() {
        this.zzbqh = true;
        this.zzecf.zzyx();
    }

    public final void resume() {
        this.zzbqh = false;
        zzzo();
    }

    public final void run() {
        if (!this.zzbqh) {
            this.zzecf.zzyx();
            zzzo();
        }
    }
}
