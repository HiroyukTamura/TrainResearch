package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdth extends zzdsm<zzdvk> {
    zzdth() {
        super(zzdvk.class, new zzdtj(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdvl, zzdvk> zzaxb() {
        return new zzdti(this, zzdvl.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdzy.zzy(((zzdvk) zzedo).getVersion(), 0);
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdvk.zzd(zzeaq, zzebq.zzbec());
    }
}
