package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzjw {
    public final int zzaok = 1;
    public final byte[] zzaol;

    public zzjw(int i, byte[] bArr) {
        this.zzaol = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzjw.class == obj.getClass()) {
            zzjw zzjw = (zzjw) obj;
            return this.zzaok == zzjw.zzaok && Arrays.equals(this.zzaol, zzjw.zzaol);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzaol) + (this.zzaok * 31);
    }
}
