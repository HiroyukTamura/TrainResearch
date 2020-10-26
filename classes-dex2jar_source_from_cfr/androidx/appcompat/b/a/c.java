/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 */
package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c
extends Drawable
implements Drawable.Callback {
    private Drawable a;

    public c(Drawable drawable2) {
        this.a(drawable2);
    }

    public Drawable a() {
        return this.a;
    }

    public void a(Drawable drawable2) {
        if (this.a != null) {
            this.a.setCallback(null);
        }
        this.a = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
        }
    }

    public void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.a.getPadding(rect);
    }

    public int[] getState() {
        return this.a.getState();
    }

    public Region getTransparentRegion() {
        return this.a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable2) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.b(this.a);
    }

    public boolean isStateful() {
        return this.a.isStateful();
    }

    public void jumpToCurrentState() {
        a.a(this.a);
    }

    protected void onBoundsChange(Rect rect) {
        this.a.setBounds(rect);
    }

    protected boolean onLevelChange(int n2) {
        return this.a.setLevel(n2);
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l2) {
        this.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        this.a.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl2) {
        a.a(this.a, bl2);
    }

    public void setChangingConfigurations(int n2) {
        this.a.setChangingConfigurations(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl2) {
        this.a.setDither(bl2);
    }

    public void setFilterBitmap(boolean bl2) {
        this.a.setFilterBitmap(bl2);
    }

    public void setHotspot(float f2, float f3) {
        a.a(this.a, f2, f3);
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        a.a(this.a, n2, n3, n4, n5);
    }

    public boolean setState(int[] arrn) {
        return this.a.setState(arrn);
    }

    public void setTint(int n2) {
        a.a(this.a, n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a(this.a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.a(this.a, mode);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        return super.setVisible(bl2, bl3) || this.a.setVisible(bl2, bl3);
        {
        }
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

