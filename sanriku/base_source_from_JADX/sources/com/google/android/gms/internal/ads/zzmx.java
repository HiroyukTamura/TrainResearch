package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzmx {
    public final int length;
    private int zzahb;
    private final zzhf[] zzbda;

    public zzmx(zzhf... zzhfArr) {
        zzoh.checkState(zzhfArr.length > 0);
        this.zzbda = zzhfArr;
        this.length = zzhfArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmx.class == obj.getClass()) {
            zzmx zzmx = (zzmx) obj;
            return this.length == zzmx.length && Arrays.equals(this.zzbda, zzmx.zzbda);
        }
    }

    public final int hashCode() {
        if (this.zzahb == 0) {
            this.zzahb = Arrays.hashCode(this.zzbda) + 527;
        }
        return this.zzahb;
    }

    public final zzhf zzax(int i) {
        return this.zzbda[i];
    }

    public final int zzh(zzhf zzhf) {
        int i = 0;
        while (true) {
            zzhf[] zzhfArr = this.zzbda;
            if (i >= zzhfArr.length) {
                return -1;
            }
            if (zzhf == zzhfArr[i]) {
                return i;
            }
            i++;
        }
    }
}
