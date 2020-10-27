package com.google.android.gms.internal.measurement;

import p009e.p010a.p011a.p012a.C0681a;

final class zzec {
    static void zza(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            throw new NullPointerException(C0681a.m312a(valueOf.length() + 24, "null key in entry: null=", valueOf));
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException(C0681a.m313a(valueOf2.length() + 26, "null value in entry: ", valueOf2, "=null"));
        }
    }
}
