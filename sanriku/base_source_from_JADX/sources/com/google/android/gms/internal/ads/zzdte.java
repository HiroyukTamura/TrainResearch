package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import com.google.android.gms.internal.ads.zzdxp;
import com.google.android.gms.internal.ads.zzdxq;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class zzdte {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzdxq zzb(zzdxp zzdxp) {
        zzdxq.zza zzfb = zzdxq.zzbay().zzfb(zzdxp.zzbaq());
        for (zzdxp.zza next : zzdxp.zzbar()) {
            zzfb.zzb((zzdxq.zzb) ((zzecd) zzdxq.zzb.zzbba().zzhn(next.zzbav().zzbad()).zza(next.zzaxe()).zza(next.zzaxf()).zzfc(next.zzbaw()).zzbet()));
        }
        return (zzdxq) ((zzecd) zzfb.zzbet());
    }

    public static void zzc(zzdxp zzdxp) throws GeneralSecurityException {
        int zzbaq = zzdxp.zzbaq();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzdxp.zza next : zzdxp.zzbar()) {
            if (next.zzaxe() == zzdxj.ENABLED) {
                if (!next.zzbau()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzbaw())}));
                } else if (next.zzaxf() == zzdyb.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzbaw())}));
                } else if (next.zzaxe() != zzdxj.UNKNOWN_STATUS) {
                    if (next.zzbaw() == zzbaq) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzbav().zzbaf() != zzdxf.zzb.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzbaw())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
