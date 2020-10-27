package com.google.android.gms.internal.gtm;

public abstract class zzan extends zzam {
    private boolean zzwd;

    protected zzan(zzap zzap) {
        super(zzap);
    }

    public final boolean isInitialized() {
        return this.zzwd;
    }

    public final void zzag() {
        zzaw();
        this.zzwd = true;
    }

    /* access modifiers changed from: protected */
    public abstract void zzaw();

    /* access modifiers changed from: protected */
    public final void zzdb() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
