/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Color
 *  android.util.TypedValue
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.appcompat.widget.ao;
import androidx.core.graphics.a;

class aj {
    static final int[] a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    static final int[] h;
    private static final ThreadLocal<TypedValue> i;
    private static final int[] j;

    static {
        i = new ThreadLocal();
        a = new int[]{-16842910};
        b = new int[]{16842908};
        c = new int[]{16843518};
        d = new int[]{16842919};
        e = new int[]{16842912};
        f = new int[]{16842913};
        g = new int[]{-16842919, -16842908};
        h = new int[0];
        j = new int[1];
    }

    public static int a(Context object, int n2) {
        aj.j[0] = n2;
        object = ao.a((Context)object, null, j);
        try {
            n2 = ((ao)object).b(0, 0);
            return n2;
        }
        finally {
            ((ao)object).a();
        }
    }

    static int a(Context context, int n2, float f2) {
        n2 = aj.a(context, n2);
        return a.b(n2, Math.round((float)Color.alpha((int)n2) * f2));
    }

    private static TypedValue a() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = i.get();
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            i.set(typedValue2);
        }
        return typedValue2;
    }

    public static ColorStateList b(Context object, int n2) {
        aj.j[0] = n2;
        object = ao.a((Context)object, null, j);
        try {
            ColorStateList colorStateList = ((ao)object).e(0);
            return colorStateList;
        }
        finally {
            ((ao)object).a();
        }
    }

    public static int c(Context context, int n2) {
        ColorStateList colorStateList = aj.b(context, n2);
        if (colorStateList != null && colorStateList.isStateful()) {
            return colorStateList.getColorForState(a, colorStateList.getDefaultColor());
        }
        colorStateList = aj.a();
        context.getTheme().resolveAttribute(16842803, (TypedValue)colorStateList, true);
        return aj.a(context, n2, colorStateList.getFloat());
    }
}

