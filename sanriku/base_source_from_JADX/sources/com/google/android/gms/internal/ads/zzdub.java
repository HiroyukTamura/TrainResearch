package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdub extends zzdsm<zzdxx> {
    zzdub() {
        super(zzdxx.class, new zzdua(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.REMOTE;
    }

    public final zzdsl<zzdxy, zzdxx> zzaxb() {
        return new zzdud(this, zzdxy.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdzy.zzy(((zzdxx) zzedo).getVersion(), 0);
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdxx.zzu(zzeaq, zzebq.zzbec());
    }
}
