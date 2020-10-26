/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.google.android.material.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.a.a.a;

public class b {
    public static ColorStateList a(Context context, TypedArray typedArray, int n2) {
        int n3;
        if (typedArray.hasValue(n2) && (n3 = typedArray.getResourceId(n2, 0)) != 0 && (context = a.a(context, n3)) != null) {
            return context;
        }
        if (Build.VERSION.SDK_INT <= 15 && (n3 = typedArray.getColor(n2, -1)) != -1) {
            return ColorStateList.valueOf((int)n3);
        }
        return typedArray.getColorStateList(n2);
    }

    public static Drawable b(Context context, TypedArray typedArray, int n2) {
        int n3;
        if (typedArray.hasValue(n2) && (n3 = typedArray.getResourceId(n2, 0)) != 0 && (context = a.b(context, n3)) != null) {
            return context;
        }
        return typedArray.getDrawable(n2);
    }
}

