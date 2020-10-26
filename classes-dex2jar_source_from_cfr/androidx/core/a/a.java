/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.TypedValue
 */
package androidx.core.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;

public class a {
    private static final Object a = new Object();
    private static TypedValue b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Drawable a(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(n2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(n2);
        }
        Object object = a;
        synchronized (object) {
            if (b == null) {
                b = new TypedValue();
            }
            context.getResources().getValue(n2, b, true);
            n2 = a.b.resourceId;
            return context.getResources().getDrawable(n2);
        }
    }

    public static boolean a(Context context, Intent[] arrintent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(arrintent, bundle);
        } else {
            context.startActivities(arrintent);
        }
        return true;
    }

    public static ColorStateList b(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(n2);
        }
        return context.getResources().getColorStateList(n2);
    }

    public static int c(Context context, int n2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(n2);
        }
        return context.getResources().getColor(n2);
    }
}

