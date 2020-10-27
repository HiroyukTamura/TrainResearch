package com.google.android.gms.internal.ads;

public final class zzajs extends zzbaq<zzakd> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final zzajw zzddf;
    private boolean zzddg;

    public zzajs(zzajw zzajw) {
        this.zzddf = zzajw;
    }

    public final void release() {
        synchronized (this.lock) {
            if (!this.zzddg) {
                this.zzddg = true;
                zza(new zzajv(this), new zzbao());
                zza(new zzaju(this), new zzajx(this));
            }
        }
    }
}
