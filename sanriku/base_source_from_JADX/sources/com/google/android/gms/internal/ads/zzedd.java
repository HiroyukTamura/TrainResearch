package com.google.android.gms.internal.ads;

final class zzedd implements zzedl {
    private zzedl[] zzhzv;

    zzedd(zzedl... zzedlArr) {
        this.zzhzv = zzedlArr;
    }

    public final boolean zzc(Class<?> cls) {
        for (zzedl zzc : this.zzhzv) {
            if (zzc.zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzedm zzd(Class<?> cls) {
        for (zzedl zzedl : this.zzhzv) {
            if (zzedl.zzc(cls)) {
                return zzedl.zzd(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
