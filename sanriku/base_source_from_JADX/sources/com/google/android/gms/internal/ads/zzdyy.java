package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzdyy implements zzdsf {
    private static final byte[] zzhkn = new byte[0];
    private final String zzhqv;
    private final byte[] zzhqw;
    private final zzdzg zzhqx;
    private final zzdyv zzhqy;
    private final ECPrivateKey zzhqz;
    private final zzdza zzhra;

    public zzdyy(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdzg zzdzg, zzdyv zzdyv) throws GeneralSecurityException {
        this.zzhqz = eCPrivateKey;
        this.zzhra = new zzdza(eCPrivateKey);
        this.zzhqw = bArr;
        this.zzhqv = str;
        this.zzhqx = zzdzg;
        this.zzhqy = zzdyv;
    }
}
