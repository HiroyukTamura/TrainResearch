package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.regex.Pattern;

public final class zzaab {
    public static boolean zzcr(String str) {
        return zzf((String) zzvj.zzpv().zzd(zzzz.zzcrh), str);
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzq.zzla().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
