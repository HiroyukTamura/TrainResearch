/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.util.TypedValue
 *  android.view.View
 */
package com.google.android.material.e;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

public class a {
    public static int a(int n2, int n3) {
        return androidx.core.graphics.a.a(n3, n2);
    }

    public static int a(int n2, int n3, float f2) {
        return a.a(n2, androidx.core.graphics.a.b(n3, Math.round((float)Color.alpha((int)n3) * f2)));
    }

    public static int a(View view, int n2) {
        return com.google.android.material.i.a.a((View)view, (int)n2).data;
    }

    public static int a(View view, int n2, int n3, float f2) {
        return a.a(a.a(view, n2), a.a(view, n3), f2);
    }
}

