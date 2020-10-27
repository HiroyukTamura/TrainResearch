package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbro extends zzbui<zzbrp> {
    private boolean zzfnh = false;

    public zzbro(Set<zzbvt<zzbrp>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfnh) {
            zza(zzbrn.zzfnf);
            this.zzfnh = true;
        }
    }
}
