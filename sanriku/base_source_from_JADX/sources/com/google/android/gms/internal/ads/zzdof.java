package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdof {
    private static final Logger logger = Logger.getLogger(zzdof.class.getName());
    private static final zzdog zzhdv = new zza();

    static final class zza {
        private zza() {
        }
    }

    private zzdof() {
    }

    static String emptyToNull(@NullableDecl String str) {
        if (zzhd(str)) {
            return null;
        }
        return str;
    }

    static boolean zzhd(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String zzhe(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}
