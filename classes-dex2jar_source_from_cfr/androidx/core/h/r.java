/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 */
package androidx.core.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface r {
    public ColorStateList getSupportBackgroundTintList();

    public PorterDuff.Mode getSupportBackgroundTintMode();

    public void setSupportBackgroundTintList(ColorStateList var1);

    public void setSupportBackgroundTintMode(PorterDuff.Mode var1);
}

