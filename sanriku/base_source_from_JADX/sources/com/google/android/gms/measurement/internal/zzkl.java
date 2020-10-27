package com.google.android.gms.measurement.internal;

abstract class zzkl extends zzki {
    private boolean zzb;

    zzkl(zzkk zzkk) {
        super(zzkk);
        this.zza.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaj() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (!this.zzb) {
            zze();
            this.zza.zzp();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public abstract boolean zze();
}
