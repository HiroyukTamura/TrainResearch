package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

final class zzduj extends zzdsl<zzdwl, zzdwp> {
    private final /* synthetic */ zzduh zzhkt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzduj(zzduh zzduh, Class cls) {
        super(cls);
        this.zzhkt = zzduh;
    }

    public final /* synthetic */ void zzc(zzedo zzedo) throws GeneralSecurityException {
        zzdup.zza(((zzdwl) zzedo).zzaza());
    }

    public final /* synthetic */ Object zzd(zzedo zzedo) throws GeneralSecurityException {
        zzdwl zzdwl = (zzdwl) zzedo;
        KeyPair zza = zzdzb.zza(zzdzb.zza(zzdup.zza(zzdwl.zzaza().zzazc().zzazp())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzdwp) ((zzecd) zzdwp.zzazi().zzet(0).zzb((zzdws) ((zzecd) zzdws.zzazm().zzeu(0).zzc(zzdwl.zzaza()).zzab(zzeaq.zzu(w.getAffineX().toByteArray())).zzac(zzeaq.zzu(w.getAffineY().toByteArray())).zzbet())).zzy(zzeaq.zzu(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbet());
    }

    public final /* synthetic */ zzedo zzq(zzeaq zzeaq) throws zzeco {
        return zzdwl.zzn(zzeaq, zzebq.zzbec());
    }
}
