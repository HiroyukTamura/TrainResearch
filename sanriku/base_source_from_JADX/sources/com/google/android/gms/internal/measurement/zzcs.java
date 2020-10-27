package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

public final class zzcs {
    private final Map<String, Map<String, String>> zza;

    zzcs(Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map map = this.zza.get(str);
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str3);
            str3 = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        return (String) map.get(str3);
    }
}
