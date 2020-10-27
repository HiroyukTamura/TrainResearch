package com.google.android.gms.internal.ads;

public final class zzoo {
    public static boolean zzbd(String str) {
        return "audio".equals(zzbf(str));
    }

    public static boolean zzbe(String str) {
        return "video".equals(zzbf(str));
    }

    private static String zzbf(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException(str.length() != 0 ? "Invalid mime type: ".concat(str) : new String("Invalid mime type: "));
    }
}
