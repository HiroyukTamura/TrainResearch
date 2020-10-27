package com.google.android.gms.internal.ads;

import p009e.p010a.p011a.p012a.C0681a;

final class zzdoo {
    static void zzb(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            throw new NullPointerException(C0681a.m312a(valueOf.length() + 24, "null key in entry: null=", valueOf));
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException(C0681a.m313a(valueOf2.length() + 26, "null value in entry: ", valueOf2, "=null"));
        }
    }

    static int zzj(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 40));
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
