package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdts extends zzdsm<zzdwe> {
    zzdts() {
        super(zzdwe.class, new zzdtv(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdwf, zzdwe> zzaxb() {
        return new zzdtu(this, zzdwf.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdwe zzdwe = (zzdwe) zzedo;
        zzdzy.zzy(zzdwe.getVersion(), 0);
        if (zzdwe.zzaxn().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdwe.zzl(zzeaq, zzebq.zzbec());
    }
}
