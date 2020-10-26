// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.content.res.TypedArray;
import android.content.Context;
import android.support.v7.appcompat.R;

class ThemeUtils
{
    private static final int[] APPCOMPAT_CHECK_ATTRS;
    
    static {
        APPCOMPAT_CHECK_ATTRS = new int[] { R.attr.colorPrimary };
    }
    
    static void checkAppCompatTheme(final Context context) {
        boolean b = false;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ThemeUtils.APPCOMPAT_CHECK_ATTRS);
        if (!obtainStyledAttributes.hasValue(0)) {
            b = true;
        }
        obtainStyledAttributes.recycle();
        if (b) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
