package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdtn extends zzdsl<zzdvp, zzdvo> {
    private final /* synthetic */ zzdtl zzhkj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdtn(zzdtl zzdtl, Class cls) {
        super(cls);
        this.zzhkj = zzdtl;
    }

    public final /* synthetic */ void zzc(zzedo zzedo) throws GeneralSecurityException {
        zzdvp zzdvp = (zzdvp) zzedo;
        zzdzy.zzfj(zzdvp.getKeySize());
        zzdtl.zza(zzdvp.zzayc());
    }

    public final /* synthetic */ Object zzd(zzedo zzedo) throws GeneralSecurityException {
        zzdvp zzdvp = (zzdvp) zzedo;
        return (zzdvo) ((zzecd) zzdvo.zzayd().zzc(zzdvp.zzayc()).zzu(zzeaq.zzu(zzdzt.zzfi(zzdvp.getKeySize()))).zzeo(0).zzbet());
    }

    public final /* synthetic */ zzedo zzq(zzeaq zzeaq) throws zzeco {
        return zzdvp.zzg(zzeaq, zzebq.zzbec());
    }
}
