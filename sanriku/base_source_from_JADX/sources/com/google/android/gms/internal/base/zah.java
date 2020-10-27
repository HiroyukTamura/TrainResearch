package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

final class zah extends Drawable.ConstantState {
    int mChangingConfigurations;
    int zaoa;

    zah(zah zah) {
        if (zah != null) {
            this.mChangingConfigurations = zah.mChangingConfigurations;
            this.zaoa = zah.zaoa;
        }
    }

    public final int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public final Drawable newDrawable() {
        return new zae(this);
    }
}
