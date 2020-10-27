package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdto extends zzdsl<zzdvw, zzdvt> {
    private final /* synthetic */ zzdtm zzhkk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdto(zzdtm zzdtm, Class cls) {
        super(cls);
        this.zzhkk = zzdtm;
    }

    public final /* synthetic */ void zzc(zzedo zzedo) throws GeneralSecurityException {
        zzdvw zzdvw = (zzdvw) zzedo;
        zzdzy.zzfj(zzdvw.getKeySize());
        if (zzdvw.zzayl().zzayi() != 12 && zzdvw.zzayl().zzayi() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* synthetic */ Object zzd(zzedo zzedo) throws GeneralSecurityException {
        zzdvw zzdvw = (zzdvw) zzedo;
        return (zzdvt) ((zzecd) zzdvt.zzaym().zzv(zzeaq.zzu(zzdzt.zzfi(zzdvw.getKeySize()))).zzb(zzdvw.zzayl()).zzep(0).zzbet());
    }

    public final /* synthetic */ zzedo zzq(zzeaq zzeaq) throws zzeco {
        return zzdvw.zzi(zzeaq, zzebq.zzbec());
    }
}
