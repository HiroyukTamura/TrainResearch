package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzawb {
    private long zzdti = -1;
    private long zzdtj = -1;
    private final /* synthetic */ zzawc zzdtk;

    public zzawb(zzawc zzawc) {
        this.zzdtk = zzawc;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzdti);
        bundle.putLong("tclose", this.zzdtj);
        return bundle;
    }

    public final long zzvo() {
        return this.zzdtj;
    }

    public final void zzvp() {
        this.zzdtj = this.zzdtk.zzbnt.elapsedRealtime();
    }

    public final void zzvq() {
        this.zzdti = this.zzdtk.zzbnt.elapsedRealtime();
    }
}
