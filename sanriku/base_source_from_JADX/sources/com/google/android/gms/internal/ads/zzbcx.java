package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbcx implements zznt {
    private final byte[] zzdpa;
    private final zznt zzegd;

    zzbcx(zznt zznt, byte[] bArr) {
        this.zzegd = zznt;
        this.zzdpa = bArr;
    }

    public final zznu zzio() {
        zznt zznt = this.zzegd;
        byte[] bArr = this.zzdpa;
        return new zzbdb(new zznr(bArr), bArr.length, zznt.zzio());
    }
}
