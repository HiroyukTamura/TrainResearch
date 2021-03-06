package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import p009e.p010a.p011a.p012a.C0681a;

public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        String str2 = zza(bool) ? "https" : "http";
        return C0681a.m313a(C0681a.m336b(str, str2.length() + 3), str2, "://", str);
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('=');
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (zza(bool)) {
            sb.append(";HttpOnly");
        }
        if (zza(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l != null && l.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l);
        }
        return sb.toString();
    }

    private static boolean zza(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
