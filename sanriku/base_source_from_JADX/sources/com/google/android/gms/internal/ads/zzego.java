package com.google.android.gms.internal.ads;

import android.util.Log;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzego extends zzegr {
    private String name;

    public zzego(String str) {
        this.name = str;
    }

    public final void zzig(String str) {
        String str2 = this.name;
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, C0681a.m336b(str2, 1)));
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
