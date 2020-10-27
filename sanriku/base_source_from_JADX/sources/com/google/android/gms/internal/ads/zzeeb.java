package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

final class zzeeb implements zzedm {
    private final int flags;
    private final String info;
    private final Object[] zziae;
    private final zzedo zziah;

    zzeeb(zzedo zzedo, String str, Object[] objArr) {
        this.zziah = zzedo;
        this.info = str;
        this.zziae = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    public final int zzbge() {
        return (this.flags & 1) == 1 ? zzecd.zzf.zzhyj : zzecd.zzf.zzhyk;
    }

    public final boolean zzbgf() {
        return (this.flags & 2) == 2;
    }

    public final zzedo zzbgg() {
        return this.zziah;
    }

    /* access modifiers changed from: package-private */
    public final String zzbgl() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbgm() {
        return this.zziae;
    }
}
