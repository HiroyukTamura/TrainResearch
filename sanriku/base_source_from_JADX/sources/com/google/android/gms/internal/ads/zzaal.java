package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import p009e.p010a.p011a.p012a.C0681a;

final class zzaal extends zzaag {
    zzaal() {
    }

    @Nullable
    private static String zzcu(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    public final String zzg(@Nullable String str, String str2) {
        String zzcu = zzcu(str);
        String zzcu2 = zzcu(str2);
        return TextUtils.isEmpty(zzcu) ? zzcu2 : TextUtils.isEmpty(zzcu2) ? zzcu : C0681a.m313a(C0681a.m336b(zzcu2, C0681a.m336b(zzcu, 1)), zzcu, ",", zzcu2);
    }
}
