/*
 * Decompiled with CFR 0.139.
 */
package com.google.android.material.g;

public final class a {
    public static float a(float f2, float f3, float f4) {
        return (1.0f - f4) * f2 + f4 * f3;
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return (float)Math.hypot(f4 - f2, f5 - f3);
    }

    public static float a(float f2, float f3, float f4, float f5, float f6, float f7) {
        return a.b(a.a(f2, f3, f4, f5), a.a(f2, f3, f6, f5), a.a(f2, f3, f6, f7), a.a(f2, f3, f4, f7));
    }

    private static float b(float f2, float f3, float f4, float f5) {
        if (f2 > f3 && f2 > f4 && f2 > f5) {
            return f2;
        }
        if (f3 > f4 && f3 > f5) {
            return f3;
        }
        if (f4 > f5) {
            return f4;
        }
        return f5;
    }

    public static boolean b(float f2, float f3, float f4) {
        return f2 + f4 >= f3;
    }
}

