package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzduv extends zzdsm<zzdxa> {
    public zzduv() {
        super(zzdxa.class, new zzduy(zzdss.class));
    }

    /* access modifiers changed from: private */
    public static void zza(zzdxe zzdxe) throws GeneralSecurityException {
        if (zzdxe.zzaxs() >= 10) {
            int i = zzdva.zzhlc[zzdxe.zzbaa().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzdxe.zzaxs() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzdxe.zzaxs() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzdxe.zzaxs() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdxb, zzdxa> zzaxb() {
        return new zzdux(this, zzdxb.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdxa zzdxa = (zzdxa) zzedo;
        zzdzy.zzy(zzdxa.getVersion(), 0);
        if (zzdxa.zzaxn().size() >= 16) {
            zza(zzdxa.zzazu());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdxa.zzq(zzeaq, zzebq.zzbec());
    }
}
