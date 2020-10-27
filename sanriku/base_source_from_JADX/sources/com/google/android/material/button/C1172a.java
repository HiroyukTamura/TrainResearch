package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@TargetApi(21)
/* renamed from: com.google.android.material.button.a */
class C1172a extends RippleDrawable {
    C1172a(@NonNull ColorStateList colorStateList, @Nullable InsetDrawable insetDrawable, @Nullable Drawable drawable) {
        super(colorStateList, insetDrawable, drawable);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (getDrawable(0) != null) {
            ((GradientDrawable) ((LayerDrawable) ((InsetDrawable) getDrawable(0)).getDrawable()).getDrawable(0)).setColorFilter(colorFilter);
        }
    }
}
