package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
@VisibleForTesting
public class NumberUtils {
    private NumberUtils() {
    }

    @KeepForSdk
    public static long parseHexLong(String str) {
        if (str.length() > 16) {
            throw new NumberFormatException(C0681a.m313a(str.length() + 37, "Invalid input: ", str, " exceeds 16 characters"));
        } else if (str.length() != 16) {
            return Long.parseLong(str, 16);
        } else {
            return (Long.parseLong(str.substring(0, 8), 16) << 32) | Long.parseLong(str.substring(8), 16);
        }
    }
}
