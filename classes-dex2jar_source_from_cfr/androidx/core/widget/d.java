/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.widget.EdgeEffect
 */
package androidx.core.widget;

import android.os.Build;
import android.widget.EdgeEffect;

public final class d {
    public static void a(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
            return;
        }
        edgeEffect.onPull(f2);
    }
}

