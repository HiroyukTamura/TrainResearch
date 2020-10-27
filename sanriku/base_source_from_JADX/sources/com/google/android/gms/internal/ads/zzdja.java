package com.google.android.gms.internal.ads;

public final class zzdja implements zzdiy {
    private final String zzcc;

    public zzdja(String str) {
        this.zzcc = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdja)) {
            return false;
        }
        return this.zzcc.equals(((zzdja) obj).zzcc);
    }

    public final int hashCode() {
        return this.zzcc.hashCode();
    }

    public final String toString() {
        return this.zzcc;
    }
}
