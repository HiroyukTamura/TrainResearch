package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

public final class zzdyx implements zzdsi {
    private static final byte[] zzhkn = new byte[0];
    private final zzdyz zzhqu;
    private final String zzhqv;
    private final byte[] zzhqw;
    private final zzdzg zzhqx;
    private final zzdyv zzhqy;

    public zzdyx(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdzg zzdzg, zzdyv zzdyv) throws GeneralSecurityException {
        zzdzb.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzhqu = new zzdyz(eCPublicKey);
        this.zzhqw = bArr;
        this.zzhqv = str;
        this.zzhqx = zzdzg;
        this.zzhqy = zzdyv;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdzc zza = this.zzhqu.zza(this.zzhqv, this.zzhqw, bArr2, this.zzhqy.zzaxm(), this.zzhqx);
        byte[] zzc = this.zzhqy.zzn(zza.zzbbz()).zzc(bArr, zzhkn);
        byte[] zzbby = zza.zzbby();
        return ByteBuffer.allocate(zzbby.length + zzc.length).put(zzbby).put(zzc).array();
    }
}
