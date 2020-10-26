/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.util.DisplayMetrics
 */
package com.mixpanel.android.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;

public class j {
    public static float a(float f2, Context context) {
        return f2 * ((float)context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static int a(int n2, int n3) {
        float f2 = Color.red((int)n2) / 2 + Color.red((int)n3) / 2;
        float f3 = Color.green((int)n2) / 2 + Color.green((int)n3) / 2;
        float f4 = Color.blue((int)n2) / 2 + Color.blue((int)n3) / 2;
        return Color.rgb((int)((int)f2), (int)((int)f3), (int)((int)f4));
    }
}

