package p009e.p028d.p030b.p054b.p060h;

import androidx.appcompat.graphics.drawable.DrawableWrapper;

/* renamed from: e.d.b.b.h.a */
public class C1556a extends DrawableWrapper {

    /* renamed from: a */
    static final double f1809a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a */
    public static float m2175a(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = (double) f;
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (((1.0d - f1809a) * d2) + d);
    }

    /* renamed from: b */
    public static float m2176b(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        if (!z) {
            return f3;
        }
        double d = (double) f3;
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (((1.0d - f1809a) * d2) + d);
    }
}
