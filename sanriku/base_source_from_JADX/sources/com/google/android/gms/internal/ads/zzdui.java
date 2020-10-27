package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

final class zzdui extends zzdsm<zzdws> {
    public zzdui() {
        super(zzdws.class, new zzdul(zzdsi.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.ASYMMETRIC_PUBLIC;
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdws zzdws = (zzdws) zzedo;
        zzdzy.zzy(zzdws.getVersion(), 0);
        zzdup.zza(zzdws.zzaza());
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdws.zzp(zzeaq, zzebq.zzbec());
    }
}
