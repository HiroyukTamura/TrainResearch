package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzdty implements zzdsb {
    private static final byte[] zzhkn = new byte[0];
    private final zzdxl zzhko;
    private final zzdsb zzhkp;

    public zzdty(zzdxl zzdxl, zzdsb zzdsb) {
        this.zzhko = zzdxl;
        this.zzhkp = zzdsb;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdsx.zzb(this.zzhko).toByteArray();
        byte[] zzc = this.zzhkp.zzc(byteArray, zzhkn);
        byte[] zzc2 = ((zzdsb) zzdsx.zza(this.zzhko.zzbad(), byteArray, zzdsb.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
