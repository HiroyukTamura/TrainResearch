package com.google.android.gms.internal.fitness;

final class zzhd implements zzhl {
    private zzhl[] zzxg;

    zzhd(zzhl... zzhlArr) {
        this.zzxg = zzhlArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzhl zzb : this.zzxg) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzhm zzc(Class<?> cls) {
        for (zzhl zzhl : this.zzxg) {
            if (zzhl.zzb(cls)) {
                return zzhl.zzc(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
