/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.ColorStateList
 *  android.graphics.ColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 */
package com.google.android.material.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

@TargetApi(value=21)
class b
extends RippleDrawable {
    b(ColorStateList colorStateList, InsetDrawable insetDrawable, Drawable drawable2) {
        super(colorStateList, (Drawable)insetDrawable, drawable2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.getDrawable(0) != null) {
            ((GradientDrawable)((LayerDrawable)((InsetDrawable)this.getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(colorFilter);
        }
    }
}

