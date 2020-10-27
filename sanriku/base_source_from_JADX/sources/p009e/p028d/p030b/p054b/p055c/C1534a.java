package p009e.p028d.p030b.p054b.p055c;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import p009e.p010a.p011a.p012a.C0681a;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: e.d.b.b.c.a */
public class C1534a {

    /* renamed from: a */
    public static final TimeInterpolator f1769a = new FastOutSlowInInterpolator();

    /* renamed from: b */
    public static final TimeInterpolator f1770b = new FastOutLinearInInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator f1771c = new LinearOutSlowInInterpolator();

    /* renamed from: d */
    public static final TimeInterpolator f1772d = new DecelerateInterpolator();

    static {
        new LinearInterpolator();
    }

    /* renamed from: a */
    public static float m2149a(float f, float f2, float f3) {
        return C0681a.m301a(f2, f, f3, f);
    }

    /* renamed from: a */
    public static int m2150a(int i, int i2, float f) {
        return Math.round(f * ((float) (i2 - i))) + i;
    }
}
