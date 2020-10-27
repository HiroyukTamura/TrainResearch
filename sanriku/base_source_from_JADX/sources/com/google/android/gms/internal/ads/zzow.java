package com.google.android.gms.internal.ads;

import android.os.Trace;

public final class zzow {
    public static void beginSection(String str) {
        if (zzov.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzov.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
