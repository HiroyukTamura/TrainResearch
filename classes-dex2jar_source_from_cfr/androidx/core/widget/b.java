/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.core.widget;

import android.os.Build;

public interface b {
    public static final boolean d;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 27;
        d = bl2;
    }
}

