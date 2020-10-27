package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxf;
import java.security.GeneralSecurityException;

public final class zzdtr extends zzdsm<zzdwa> {
    zzdtr() {
        super(zzdwa.class, new zzdtq(zzdsb.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzdxf.zzb zzawy() {
        return zzdxf.zzb.SYMMETRIC;
    }

    public final zzdsl<zzdwb, zzdwa> zzaxb() {
        return new zzdtt(this, zzdwb.class);
    }

    public final /* synthetic */ void zze(zzedo zzedo) throws GeneralSecurityException {
        zzdwa zzdwa = (zzdwa) zzedo;
        zzdzy.zzy(zzdwa.getVersion(), 0);
        zzdzy.zzfj(zzdwa.zzaxn().size());
    }

    public final /* synthetic */ zzedo zzr(zzeaq zzeaq) throws zzeco {
        return zzdwa.zzj(zzeaq, zzebq.zzbec());
    }
}
