package com.google.android.gms.internal.ads;

final class zzdpl extends zzdou<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzhft;

    zzdpl(Object[] objArr, int i, int i2) {
        this.zzhft = objArr;
        this.offset = i;
        this.size = i2;
    }

    public final Object get(int i) {
        zzdoj.zzs(i, this.size);
        return this.zzhft[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzavx() {
        return true;
    }
}
