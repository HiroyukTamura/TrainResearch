package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzduy extends zzdso<zzdss, zzdxa> {
    zzduy(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) throws GeneralSecurityException {
        zzdxa zzdxa = (zzdxa) obj;
        zzdwy zzbaa = zzdxa.zzazu().zzbaa();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdxa.zzaxn().toByteArray(), "HMAC");
        int zzaxs = zzdxa.zzazu().zzaxs();
        int i = zzdva.zzhlc[zzbaa.ordinal()];
        if (i == 1) {
            return new zzdzr("HMACSHA1", secretKeySpec, zzaxs);
        }
        if (i == 2) {
            return new zzdzr("HMACSHA256", secretKeySpec, zzaxs);
        }
        if (i == 3) {
            return new zzdzr("HMACSHA512", secretKeySpec, zzaxs);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
