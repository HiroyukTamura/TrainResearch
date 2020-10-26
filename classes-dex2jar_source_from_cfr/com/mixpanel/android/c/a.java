/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.view.View
 */
package com.mixpanel.android.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import com.mixpanel.android.c.f;

public class a {
    public static int a(int n2) {
        float[] arrf = new float[3];
        Color.colorToHSV((int)n2, (float[])arrf);
        arrf[2] = 0.3f;
        return Color.HSVToColor((int)242, (float[])arrf);
    }

    public static int a(Activity activity) {
        int n2 = (activity = a.a(activity, 1, 1, false)) != null ? activity.getPixel(0, 0) : -16777216;
        return a.a(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap a(Activity activity, int n2, int n3, boolean bl2) {
        boolean bl3;
        View view;
        block6 : {
            view = activity.findViewById(16908290).getRootView();
            bl3 = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache(true);
            activity = view.getDrawingCache();
            if (activity != null && activity.getWidth() > 0 && activity.getHeight() > 0) {
                int n4 = n2;
                int n5 = n3;
                if (bl2) {
                    n4 = activity.getWidth() / n2;
                    n5 = activity.getHeight() / n3;
                }
                if (n4 > 0 && n5 > 0) {
                    try {
                        activity = Bitmap.createScaledBitmap((Bitmap)activity, (int)n4, (int)n5, (boolean)false);
                        break block6;
                    }
                    catch (OutOfMemoryError outOfMemoryError) {}
                    f.c("MixpanelAPI.ActImgUtils", "Not enough memory to produce scaled image, returning a null screenshot");
                }
            }
            activity = null;
        }
        if (!bl3) {
            view.setDrawingCacheEnabled(false);
        }
        return activity;
    }
}

