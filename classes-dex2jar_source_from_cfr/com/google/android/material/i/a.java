/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.util.TypedValue
 *  android.view.View
 */
package com.google.android.material.i;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

public class a {
    public static TypedValue a(Context context, int n2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(n2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static TypedValue a(View view, int n2) {
        Context context = view.getContext();
        TypedValue typedValue = a.a(context, n2);
        if (typedValue != null) {
            return typedValue;
        }
        throw new IllegalArgumentException(String.format("The %1$s view requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", view.getClass().getCanonicalName(), context.getResources().getResourceName(n2)));
    }
}

