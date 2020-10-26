/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.StateSet
 */
package com.google.android.material.j;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

public class a {
    public static final boolean a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 21;
        a = bl2;
        b = new int[]{16842919};
        c = new int[]{16843623, 16842908};
        d = new int[]{16842908};
        e = new int[]{16843623};
        f = new int[]{16842913, 16842919};
        g = new int[]{16842913, 16843623, 16842908};
        h = new int[]{16842913, 16842908};
        i = new int[]{16842913, 16843623};
        j = new int[]{16842913};
    }

    @TargetApi(value=21)
    private static int a(int n2) {
        return androidx.core.graphics.a.b(n2, Math.min(Color.alpha((int)n2) * 2, 255));
    }

    private static int a(ColorStateList colorStateList, int[] arrn) {
        int n2 = colorStateList != null ? colorStateList.getColorForState(arrn, colorStateList.getDefaultColor()) : 0;
        int n3 = n2;
        if (a) {
            n3 = a.a(n2);
        }
        return n3;
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (a) {
            int[] arrn = j;
            int n2 = a.a(colorStateList, f);
            int[] arrn2 = StateSet.NOTHING;
            int n3 = a.a(colorStateList, b);
            return new ColorStateList((int[][])new int[][]{arrn, arrn2}, new int[]{n2, n3});
        }
        int[] arrn = f;
        int n4 = a.a(colorStateList, f);
        int[] arrn3 = g;
        int n5 = a.a(colorStateList, g);
        int[] arrn4 = h;
        int n6 = a.a(colorStateList, h);
        int[] arrn5 = i;
        int n7 = a.a(colorStateList, i);
        int[] arrn6 = j;
        int[] arrn7 = b;
        int n8 = a.a(colorStateList, b);
        int[] arrn8 = c;
        int n9 = a.a(colorStateList, c);
        int[] arrn9 = d;
        int n10 = a.a(colorStateList, d);
        int[] arrn10 = e;
        int n11 = a.a(colorStateList, e);
        return new ColorStateList((int[][])new int[][]{arrn, arrn3, arrn4, arrn5, arrn6, arrn7, arrn8, arrn9, arrn10, StateSet.NOTHING}, new int[]{n4, n5, n6, n7, 0, n8, n9, n10, n11, 0});
    }
}

