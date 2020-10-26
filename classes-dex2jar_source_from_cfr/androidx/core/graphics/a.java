/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package androidx.core.graphics;

import android.graphics.Color;

public final class a {
    private static final ThreadLocal<double[]> a = new ThreadLocal();

    public static int a(int n2, int n3) {
        int n4 = Color.alpha((int)n3);
        int n5 = Color.alpha((int)n2);
        int n6 = a.c(n5, n4);
        return Color.argb((int)n6, (int)a.a(Color.red((int)n2), n5, Color.red((int)n3), n4, n6), (int)a.a(Color.green((int)n2), n5, Color.green((int)n3), n4, n6), (int)a.a(Color.blue((int)n2), n5, Color.blue((int)n3), n4, n6));
    }

    private static int a(int n2, int n3, int n4, int n5, int n6) {
        if (n6 == 0) {
            return 0;
        }
        return (n2 * 255 * n3 + n4 * n5 * (255 - n3)) / (n6 * 255);
    }

    public static int b(int n2, int n3) {
        if (n3 >= 0 && n3 <= 255) {
            return n2 & 16777215 | n3 << 24;
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int c(int n2, int n3) {
        return 255 - (255 - n3) * (255 - n2) / 255;
    }
}

