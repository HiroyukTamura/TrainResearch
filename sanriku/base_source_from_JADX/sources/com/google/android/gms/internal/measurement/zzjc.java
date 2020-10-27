package com.google.android.gms.internal.measurement;

final class zzjc implements zzjk {
    private zzjk[] zza;

    zzjc(zzjk... zzjkArr) {
        this.zza = zzjkArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzjk zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzjh zzb(Class<?> cls) {
        for (zzjk zzjk : this.zza) {
            if (zzjk.zza(cls)) {
                return zzjk.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
