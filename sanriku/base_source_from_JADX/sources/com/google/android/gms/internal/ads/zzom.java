package com.google.android.gms.internal.ads;

import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzom {
    private int size;
    private long[] zzbhe;

    public zzom() {
        this(32);
    }

    private zzom(int i) {
        this.zzbhe = new long[32];
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.zzbhe;
        if (i == jArr.length) {
            this.zzbhe = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.zzbhe;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzbhe[i];
        }
        throw new IndexOutOfBoundsException(C0681a.m311a(46, "Invalid index ", i, ", size is ", this.size));
    }

    public final int size() {
        return this.size;
    }
}
