package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzduc extends zzdsm<zzdye> {
    zzduc() {
        super(zzdye.class, new zzduf(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdyh, zzdye> zzaxb() {
        return new zzdue(this, zzdyh.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdye zzdye = (zzdye) zzedo;
        zzdzy.zzy(zzdye.getVersion(), 0);
        if (zzdye.zzaxn().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdye.zzw(zzeaq, zzebq.zzbec());
    }
}
