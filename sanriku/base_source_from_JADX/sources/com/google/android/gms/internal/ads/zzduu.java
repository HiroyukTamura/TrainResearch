package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzduu extends zzdsm<zzdvd> {
    zzduu() {
        super(zzdvd.class, new zzdut(zzdss.class));
    }

    /* access modifiers changed from: private */
    public static void zza(zzdvh zzdvh) throws GeneralSecurityException {
        if (zzdvh.zzaxs() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzdvh.zzaxs() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzek(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdvg, zzdvd> zzaxb() {
        return new zzduw(this, zzdvg.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdvd zzdvd = (zzdvd) zzedo;
        zzdzy.zzy(zzdvd.getVersion(), 0);
        zzek(zzdvd.zzaxn().size());
        zza(zzdvd.zzaxo());
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdvd.zzb(zzeaq, zzebq.zzbec());
    }
}
