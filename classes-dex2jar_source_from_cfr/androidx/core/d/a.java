/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Trace
 */
package androidx.core.d;

import android.os.Build;
import android.os.Trace;

public final class a {
    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void a(String string2) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection((String)string2);
        }
    }
}

