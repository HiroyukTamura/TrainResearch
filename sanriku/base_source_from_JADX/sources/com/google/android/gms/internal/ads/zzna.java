package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzna {
    public static final zzna zzbee = new zzna(new zzmx[0]);
    public final int length;
    private int zzahb;
    private final zzmx[] zzbef;

    public zzna(zzmx... zzmxArr) {
        this.zzbef = zzmxArr;
        this.length = zzmxArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzna.class == obj.getClass()) {
            zzna zzna = (zzna) obj;
            return this.length == zzna.length && Arrays.equals(this.zzbef, zzna.zzbef);
        }
    }

    public final int hashCode() {
        if (this.zzahb == 0) {
            this.zzahb = Arrays.hashCode(this.zzbef);
        }
        return this.zzahb;
    }

    public final int zza(zzmx zzmx) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbef[i] == zzmx) {
                return i;
            }
        }
        return -1;
    }

    public final zzmx zzay(int i) {
        return this.zzbef[i];
    }
}
