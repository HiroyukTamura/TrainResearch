// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.utils;

import android.util.TypedValue;
import android.content.res.Resources;

public class DensityUtils
{
    public static int dpToPx(final int n) {
        return (int)TypedValue.applyDimension(1, (float)n, Resources.getSystem().getDisplayMetrics());
    }
    
    public static int pxToDp(final float n) {
        return (int)TypedValue.applyDimension(0, n, Resources.getSystem().getDisplayMetrics());
    }
}
