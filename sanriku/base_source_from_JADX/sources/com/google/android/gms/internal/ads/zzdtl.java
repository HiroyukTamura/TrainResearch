package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdtl extends zzdsm<zzdvo> {
    zzdtl() {
        super(zzdvo.class, new zzdtk(zzdzs.class));
    }

    /* access modifiers changed from: private */
    public static void zza(zzdvs zzdvs) throws GeneralSecurityException {
        if (zzdvs.zzayi() < 12 || zzdvs.zzayi() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdvp, zzdvo> zzaxb() {
        return new zzdtn(this, zzdvp.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdvo zzdvo = (zzdvo) zzedo;
        zzdzy.zzy(zzdvo.getVersion(), 0);
        zzdzy.zzfj(zzdvo.zzaxn().size());
        zza(zzdvo.zzayc());
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdvo.zzf(zzeaq, zzebq.zzbec());
    }
}
