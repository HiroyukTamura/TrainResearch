/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.c;

class d
extends Drawable
implements Drawable.Callback,
androidx.core.graphics.drawable.b,
c {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    a b;
    Drawable c;
    private int d;
    private PorterDuff.Mode e;
    private boolean f;
    private boolean g;

    d(Drawable drawable2) {
        this.b = this.b();
        this.a(drawable2);
    }

    d(a a2, Resources resources) {
        this.b = a2;
        this.a(resources);
    }

    private void a(Resources resources) {
        if (this.b != null && this.b.b != null) {
            this.a(this.b.b.newDrawable(resources));
        }
    }

    private boolean a(int[] arrn) {
        if (!this.c()) {
            return false;
        }
        ColorStateList colorStateList = this.b.c;
        PorterDuff.Mode mode = this.b.d;
        if (colorStateList != null && mode != null) {
            int n2 = colorStateList.getColorForState(arrn, colorStateList.getDefaultColor());
            if (!this.f || n2 != this.d || mode != this.e) {
                this.setColorFilter(n2, mode);
                this.d = n2;
                this.e = mode;
                this.f = true;
                return true;
            }
        } else {
            this.f = false;
            this.clearColorFilter();
        }
        return false;
    }

    @Override
    public final Drawable a() {
        return this.c;
    }

    @Override
    public final void a(Drawable drawable2) {
        if (this.c != null) {
            this.c.setCallback(null);
        }
        this.c = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            this.setVisible(drawable2.isVisible(), true);
            this.setState(drawable2.getState());
            this.setLevel(drawable2.getLevel());
            this.setBounds(drawable2.getBounds());
            if (this.b != null) {
                this.b.b = drawable2.getConstantState();
            }
        }
        this.invalidateSelf();
    }

    a b() {
        return new b(this.b, null);
    }

    protected boolean c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.c.draw(canvas);
    }

    public int getChangingConfigurations() {
        int n2 = super.getChangingConfigurations();
        int n3 = this.b != null ? this.b.getChangingConfigurations() : 0;
        return n2 | n3 | this.c.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.b != null && this.b.a()) {
            this.b.a = this.getChangingConfigurations();
            return this.b;
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.c.getPadding(rect);
    }

    public int[] getState() {
        return this.c.getState();
    }

    public Region getTransparentRegion() {
        return this.c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable2) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.c() && this.b != null ? this.b.c : null;
        return colorStateList != null && colorStateList.isStateful() || this.c.isStateful();
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.b = this.b();
            if (this.c != null) {
                this.c.mutate();
            }
            if (this.b != null) {
                a a2 = this.b;
                Drawable.ConstantState constantState = this.c != null ? this.c.getConstantState() : null;
                a2.b = constantState;
            }
            this.g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int n2) {
        return this.c.setLevel(n2);
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l2) {
        this.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        this.c.setAlpha(n2);
    }

    public void setAutoMirrored(boolean bl2) {
        this.c.setAutoMirrored(bl2);
    }

    public void setChangingConfigurations(int n2) {
        this.c.setChangingConfigurations(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl2) {
        this.c.setDither(bl2);
    }

    public void setFilterBitmap(boolean bl2) {
        this.c.setFilterBitmap(bl2);
    }

    public boolean setState(int[] arrn) {
        boolean bl2 = this.c.setState(arrn);
        return this.a(arrn) || bl2;
        {
        }
    }

    @Override
    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        this.b.c = colorStateList;
        this.a(this.getState());
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        this.b.d = mode;
        this.a(this.getState());
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        return super.setVisible(bl2, bl3) || this.c.setVisible(bl2, bl3);
        {
        }
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }

    protected static abstract class a
    extends Drawable.ConstantState {
        int a;
        Drawable.ConstantState b;
        ColorStateList c = null;
        PorterDuff.Mode d = d.a;

        a(a a2, Resources resources) {
            if (a2 != null) {
                this.a = a2.a;
                this.b = a2.b;
                this.c = a2.c;
                this.d = a2.d;
            }
        }

        boolean a() {
            return this.b != null;
        }

        public int getChangingConfigurations() {
            int n2 = this.a;
            int n3 = this.b != null ? this.b.getChangingConfigurations() : 0;
            return n2 | n3;
        }

        public Drawable newDrawable() {
            return this.newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources var1);
    }

    private static class b
    extends a {
        b(a a2, Resources resources) {
            super(a2, resources);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

}

