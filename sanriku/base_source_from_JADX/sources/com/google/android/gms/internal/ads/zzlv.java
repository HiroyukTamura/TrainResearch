package com.google.android.gms.internal.ads;

import kotlin.jvm.internal.LongCompanionObject;

public final class zzlv implements zzmw {
    private final zzmw[] zzbat;

    public zzlv(zzmw[] zzmwArr) {
        this.zzbat = zzmwArr;
    }

    public final boolean zzee(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhm = zzhm();
            if (zzhm == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzmw zzmw : this.zzbat) {
                if (zzmw.zzhm() == zzhm) {
                    z |= zzmw.zzee(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final long zzhm() {
        long j = Long.MAX_VALUE;
        for (zzmw zzhm : this.zzbat) {
            long zzhm2 = zzhm.zzhm();
            if (zzhm2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhm2);
            }
        }
        if (j == LongCompanionObject.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
