package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zznl {
    public final int length;
    private int zzahb;
    private final zznj[] zzbfe;

    public zznl(zznj... zznjArr) {
        this.zzbfe = zznjArr;
        this.length = zznjArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zznl.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbfe, ((zznl) obj).zzbfe);
    }

    public final int hashCode() {
        if (this.zzahb == 0) {
            this.zzahb = Arrays.hashCode(this.zzbfe) + 527;
        }
        return this.zzahb;
    }

    public final zznj zzba(int i) {
        return this.zzbfe[i];
    }

    public final zznj[] zzil() {
        return (zznj[]) this.zzbfe.clone();
    }
}
