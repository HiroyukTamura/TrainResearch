package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzdst<P> {
    private final P zzhjd;
    private final byte[] zzhje;
    private final zzdxj zzhjf;
    private final zzdyb zzhjg;
    private final int zzhjh;

    zzdst(P p, byte[] bArr, zzdxj zzdxj, zzdyb zzdyb, int i) {
        this.zzhjd = p;
        this.zzhje = Arrays.copyOf(bArr, bArr.length);
        this.zzhjf = zzdxj;
        this.zzhjg = zzdyb;
        this.zzhjh = i;
    }

    public final P zzaxd() {
        return this.zzhjd;
    }

    public final zzdxj zzaxe() {
        return this.zzhjf;
    }

    public final zzdyb zzaxf() {
        return this.zzhjg;
    }

    public final byte[] zzaxg() {
        byte[] bArr = this.zzhje;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
