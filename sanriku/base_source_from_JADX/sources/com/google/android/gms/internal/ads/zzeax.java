package com.google.android.gms.internal.ads;

final class zzeax extends zzeba {
    private final int zzhtj;
    private final int zzhtk;

    zzeax(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeaq.zzi(i, i + i2, bArr.length);
        this.zzhtj = i;
        this.zzhtk = i2;
    }

    public final int size() {
        return this.zzhtk;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhtm, zzbcv() + i, bArr, i2, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzbcv() {
        return this.zzhtj;
    }

    public final byte zzfo(int i) {
        zzeaq.zzaa(i, size());
        return this.zzhtm[this.zzhtj + i];
    }

    /* access modifiers changed from: package-private */
    public final byte zzfp(int i) {
        return this.zzhtm[this.zzhtj + i];
    }
}
