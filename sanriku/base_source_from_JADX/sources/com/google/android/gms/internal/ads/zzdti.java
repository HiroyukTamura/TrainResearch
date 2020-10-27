package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdti extends zzdsl<zzdvl, zzdvk> {
    private final /* synthetic */ zzdth zzhki;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdti(zzdth zzdth, Class cls) {
        super(cls);
        this.zzhki = zzdth;
    }

    public final /* synthetic */ void zzc(zzedo zzedo) throws GeneralSecurityException {
        zzdvl zzdvl = (zzdvl) zzedo;
        new zzdtl().zzaxb().zzc(zzdvl.zzaxz());
        new zzduv().zzaxb().zzc(zzdvl.zzaya());
        zzdzy.zzfj(zzdvl.zzaxz().getKeySize());
    }

    public final /* synthetic */ Object zzd(zzedo zzedo) throws GeneralSecurityException {
        zzdvl zzdvl = (zzdvl) zzedo;
        return (zzdvk) ((zzecd) zzdvk.zzaxx().zzb(new zzdtl().zzaxb().zzd(zzdvl.zzaxz())).zzb(new zzduv().zzaxb().zzd(zzdvl.zzaya())).zzen(0).zzbet());
    }

    public final /* synthetic */ zzedo zzq(zzeaq zzeaq) throws zzeco {
        return zzdvl.zze(zzeaq, zzebq.zzbec());
    }
}
