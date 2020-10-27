package com.google.android.gms.internal.ads;

final class zzean {
    private static final Class<?> zzhsx = zzhp("libcore.io.Memory");
    private static final boolean zzhsy = (zzhp("org.robolectric.Robolectric") != null);

    static boolean zzbcl() {
        return zzhsx != null && !zzhsy;
    }

    static Class<?> zzbcm() {
        return zzhsx;
    }

    private static <T> Class<T> zzhp(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
