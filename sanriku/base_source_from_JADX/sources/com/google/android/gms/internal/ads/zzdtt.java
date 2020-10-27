package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdtt extends zzdsl<zzdwb, zzdwa> {
    private final /* synthetic */ zzdtr zzhkl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdtt(zzdtr zzdtr, Class cls) {
        super(cls);
        this.zzhkl = zzdtr;
    }

    public final /* synthetic */ void zzc(zzedo zzedo) throws GeneralSecurityException {
        zzdzy.zzfj(((zzdwb) zzedo).getKeySize());
    }

    public final /* synthetic */ Object zzd(zzedo zzedo) throws GeneralSecurityException {
        return (zzdwa) ((zzecd) zzdwa.zzayr().zzw(zzeaq.zzu(zzdzt.zzfi(((zzdwb) zzedo).getKeySize()))).zzeq(0).zzbet());
    }

    public final /* synthetic */ zzedo zzq(zzeaq zzeaq) throws zzeco {
        return zzdwb.zzk(zzeaq, zzebq.zzbec());
    }
}
