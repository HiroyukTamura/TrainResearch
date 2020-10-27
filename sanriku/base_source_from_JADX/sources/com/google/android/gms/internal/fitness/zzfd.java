package com.google.android.gms.internal.fitness;

final class zzfd {
    private static final Class<?> zzrf = zzk("libcore.io.Memory");
    private static final boolean zzrg = (zzk("org.robolectric.Robolectric") != null);

    static boolean zzan() {
        return zzrf != null && !zzrg;
    }

    static Class<?> zzao() {
        return zzrf;
    }

    private static <T> Class<T> zzk(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
