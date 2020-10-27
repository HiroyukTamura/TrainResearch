package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdoi<T> extends zzdod<T> {
    private final T zzdcc;

    zzdoi(T t) {
        this.zzdcc = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdoi) {
            return this.zzdcc.equals(((zzdoi) obj).zzdcc);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzdcc.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdcc);
        return C0681a.m313a(valueOf.length() + 13, "Optional.of(", valueOf, ")");
    }

    public final T zzavo() {
        return this.zzdcc;
    }
}
