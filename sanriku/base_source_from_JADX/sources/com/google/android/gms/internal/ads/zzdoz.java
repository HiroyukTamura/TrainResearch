package com.google.android.gms.internal.ads;

final class zzdoz extends zzdou<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdou zzhfl;

    zzdoz(zzdou zzdou, int i, int i2) {
        this.zzhfl = zzdou;
        this.offset = i;
        this.length = i2;
    }

    public final E get(int i) {
        zzdoj.zzs(i, this.length);
        return this.zzhfl.get(i + this.offset);
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzavt() {
        return this.zzhfl.zzavt();
    }

    /* access modifiers changed from: package-private */
    public final int zzavu() {
        return this.zzhfl.zzavu() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzavv() {
        return this.zzhfl.zzavu() + this.offset + this.length;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzavx() {
        return true;
    }

    /* renamed from: zzu */
    public final zzdou<E> subList(int i, int i2) {
        zzdoj.zzf(i, i2, this.length);
        zzdou zzdou = this.zzhfl;
        int i3 = this.offset;
        return (zzdou) zzdou.subList(i + i3, i2 + i3);
    }
}
