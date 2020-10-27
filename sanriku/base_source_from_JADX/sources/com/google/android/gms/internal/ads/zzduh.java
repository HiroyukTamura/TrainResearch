package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzduh extends zzdsy<zzdwp, zzdws> {
    zzduh() {
        super(zzdwp.class, zzdws.class, new zzdug(zzdsf.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.ASYMMETRIC_PRIVATE;
    }

    public final zzdsl<zzdwl, zzdwp> zzaxb() {
        return new zzduj(this, zzdwl.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdwp zzdwp = (zzdwp) zzedo;
        if (!zzdwp.zzaxn().isEmpty()) {
            zzdzy.zzy(zzdwp.getVersion(), 0);
            zzdup.zza(zzdwp.zzazh().zzaza());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdwp.zzo(zzeaq, zzebq.zzbec());
    }
}
