package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdtx extends zzdsm<zzdxt> {
    zzdtx() {
        super(zzdxt.class, new zzdtw(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.REMOTE;
    }

    public final zzdsl<zzdxu, zzdxt> zzaxb() {
        return new zzdtz(this, zzdxu.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdzy.zzy(((zzdxt) zzedo).getVersion(), 0);
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdxt.zzs(zzeaq, zzebq.zzbec());
    }
}
