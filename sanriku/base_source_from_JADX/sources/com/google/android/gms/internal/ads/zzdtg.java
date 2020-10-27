package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

public class zzdtg implements zzdsw<zzdsb> {
    private static final Logger logger = Logger.getLogger(zzdtg.class.getName());

    static class zza implements zzdsb {
        private final zzdsu<zzdsb> zzhkh;

        private zza(zzdsu<zzdsb> zzdsu) {
            this.zzhkh = zzdsu;
        }

        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzdys.zza(this.zzhkh.zzaxh().zzaxg(), this.zzhkh.zzaxh().zzaxd().zzc(bArr, bArr2));
        }
    }

    zzdtg() {
    }

    public final /* synthetic */ Object zza(zzdsu zzdsu) throws GeneralSecurityException {
        return new zza(zzdsu);
    }

    public final Class<zzdsb> zzawu() {
        return zzdsb.class;
    }
}
