package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzdsn {
    private zzdxp zzhjb;

    private zzdsn(zzdxp zzdxp) {
        this.zzhjb = zzdxp;
    }

    static final zzdsn zza(zzdxp zzdxp) throws GeneralSecurityException {
        if (zzdxp != null && zzdxp.zzbas() > 0) {
            return new zzdsn(zzdxp);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzdte.zzb(this.zzhjb).toString();
    }

    /* access modifiers changed from: package-private */
    public final zzdxp zzaxc() {
        return this.zzhjb;
    }
}
