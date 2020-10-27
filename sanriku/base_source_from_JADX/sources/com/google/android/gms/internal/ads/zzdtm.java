package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdtm extends zzdsm<zzdvt> {
    zzdtm() {
        super(zzdvt.class, new zzdtp(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdvw, zzdvt> zzaxb() {
        return new zzdto(this, zzdvw.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdvt zzdvt = (zzdvt) zzedo;
        zzdzy.zzy(zzdvt.getVersion(), 0);
        zzdzy.zzfj(zzdvt.zzaxn().size());
        if (zzdvt.zzayl().zzayi() != 12 && zzdvt.zzayl().zzayi() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdvt.zzh(zzeaq, zzebq.zzbec());
    }
}
