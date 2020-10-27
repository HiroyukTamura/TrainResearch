package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

public final class zzajw extends zzbaq<zzais> {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzayf<zzais> zzdcr;
    private boolean zzddi;
    private int zzddj;

    public zzajw(zzayf<zzais> zzayf) {
        this.zzdcr = zzayf;
        this.zzddi = false;
        this.zzddj = 0;
    }

    private final void zzta() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzddj >= 0);
            if (!this.zzddi || this.zzddj != 0) {
                zzawr.zzeg("There are still references to the engine. Not destroying.");
            } else {
                zzawr.zzeg("No reference is left (including root). Cleaning up engine.");
                zza(new zzakb(this), new zzbao());
            }
        }
    }

    public final zzajs zzsx() {
        zzajs zzajs = new zzajs(this);
        synchronized (this.lock) {
            zza(new zzajz(this, zzajs), new zzajy(this, zzajs));
            Preconditions.checkState(this.zzddj >= 0);
            this.zzddj++;
        }
        return zzajs;
    }

    /* access modifiers changed from: protected */
    public final void zzsy() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzddj > 0);
            zzawr.zzeg("Releasing 1 reference for JS Engine");
            this.zzddj--;
            zzta();
        }
    }

    public final void zzsz() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzddj >= 0);
            zzawr.zzeg("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzddi = true;
            zzta();
        }
    }
}
