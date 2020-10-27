package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzrd {
    final long value;
    final int zzbrj;
    final String zzbrq;

    zzrd(long j, String str, int i) {
        this.value = j;
        this.zzbrq = str;
        this.zzbrj = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzrd)) {
            zzrd zzrd = (zzrd) obj;
            return zzrd.value == this.value && zzrd.zzbrj == this.zzbrj;
        }
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
