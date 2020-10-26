/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 */
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.a;

public final class f {
    private static final int[] a = new int[]{a.b.colorPrimary};
    private static final int[] b = new int[]{a.b.colorPrimaryVariant};
    private static final int[] c = new int[]{16842752, a.b.theme};
    private static final int[] d = new int[]{a.b.materialThemeOverlay};

    public static /* varargs */ TypedArray a(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3, int ... arrn2) {
        f.a(context, attributeSet, n2, n3);
        f.b(context, attributeSet, arrn, n2, n3, arrn2);
        return context.obtainStyledAttributes(attributeSet, arrn, n2, n3);
    }

    public static void a(Context context) {
        f.a(context, a, "Theme.AppCompat");
    }

    private static void a(Context context, AttributeSet attributeSet, int n2, int n3) {
        attributeSet = context.obtainStyledAttributes(attributeSet, a.i.ThemeEnforcement, n2, n3);
        boolean bl2 = attributeSet.getBoolean(a.i.ThemeEnforcement_enforceMaterialTheme, false);
        attributeSet.recycle();
        if (bl2) {
            attributeSet = new TypedValue();
            if (!context.getTheme().resolveAttribute(a.b.isMaterialTheme, (TypedValue)attributeSet, true) || attributeSet.type == 18 && attributeSet.data == 0) {
                f.b(context);
            }
        }
        f.a(context);
    }

    private static void a(Context object, int[] arrn, String string2) {
        if (f.a((Context)object, arrn)) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("The style on this component requires your app theme to be ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" (or a descendant).");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    private static boolean a(Context context, int[] arrn) {
        context = context.obtainStyledAttributes(arrn);
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            if (context.hasValue(i2)) continue;
            context.recycle();
            return false;
        }
        context.recycle();
        return true;
    }

    public static void b(Context context) {
        f.a(context, b, "Theme.MaterialComponents");
    }

    private static /* varargs */ void b(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3, int ... arrn2) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, a.i.ThemeEnforcement, n2, n3);
        if (!typedArray.getBoolean(a.i.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArray.recycle();
            return;
        }
        boolean bl2 = arrn2 != null && arrn2.length != 0 ? f.c(context, attributeSet, arrn, n2, n3, arrn2) : typedArray.getResourceId(a.i.ThemeEnforcement_android_textAppearance, -1) != -1;
        typedArray.recycle();
        if (bl2) {
            return;
        }
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    private static /* varargs */ boolean c(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3, int ... arrn2) {
        context = context.obtainStyledAttributes(attributeSet, arrn, n2, n3);
        n3 = arrn2.length;
        for (n2 = 0; n2 < n3; ++n2) {
            if (context.getResourceId(arrn2[n2], -1) != -1) continue;
            context.recycle();
            return false;
        }
        context.recycle();
        return true;
    }
}

