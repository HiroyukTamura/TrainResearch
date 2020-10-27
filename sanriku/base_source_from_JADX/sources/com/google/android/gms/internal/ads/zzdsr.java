package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import com.google.android.gms.internal.ads.zzdxp;
import java.security.GeneralSecurityException;

@Deprecated
public final class zzdsr {
    @Deprecated
    public static final zzdsn zzl(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdxp zzc = zzdxp.zzc(bArr, zzebq.zzbec());
            for (zzdxp.zza next : zzc.zzbar()) {
                if (next.zzbav().zzbaf() == zzdxf.zzb.UNKNOWN_KEYMATERIAL || next.zzbav().zzbaf() == zzdxf.zzb.SYMMETRIC || next.zzbav().zzbaf() == zzdxf.zzb.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzdsn.zza(zzc);
        } catch (zzeco unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
