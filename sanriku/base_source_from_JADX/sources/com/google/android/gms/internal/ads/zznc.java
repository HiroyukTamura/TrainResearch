package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zznc implements zznj {
    private final int length;
    private int zzahb;
    private final zzhf[] zzbda;
    private final zzmx zzbeg;
    private final int[] zzbeh;
    private final long[] zzbei;

    public zznc(zzmx zzmx, int... iArr) {
        int i = 0;
        zzoh.checkState(iArr.length > 0);
        this.zzbeg = (zzmx) zzoh.checkNotNull(zzmx);
        int length2 = iArr.length;
        this.length = length2;
        this.zzbda = new zzhf[length2];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbda[i2] = zzmx.zzax(iArr[i2]);
        }
        Arrays.sort(this.zzbda, new zzne());
        this.zzbeh = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbeh[i] = zzmx.zzh(this.zzbda[i]);
                i++;
            } else {
                this.zzbei = new long[i3];
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznc zznc = (zznc) obj;
            return this.zzbeg == zznc.zzbeg && Arrays.equals(this.zzbeh, zznc.zzbeh);
        }
    }

    public int hashCode() {
        if (this.zzahb == 0) {
            this.zzahb = Arrays.hashCode(this.zzbeh) + (System.identityHashCode(this.zzbeg) * 31);
        }
        return this.zzahb;
    }

    public final int length() {
        return this.zzbeh.length;
    }

    public final zzhf zzax(int i) {
        return this.zzbda[i];
    }

    public final int zzaz(int i) {
        return this.zzbeh[0];
    }

    public final zzmx zzik() {
        return this.zzbeg;
    }
}
