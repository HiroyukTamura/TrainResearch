/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.d;
import java.lang.reflect.Method;

class e
extends d {
    private static Method d;

    e(Drawable drawable2) {
        super(drawable2);
        this.d();
    }

    e(d.a a2, Resources resources) {
        super(a2, resources);
        this.d();
    }

    private void d() {
        if (d == null) {
            try {
                d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
                return;
            }
            catch (Exception exception) {
                Log.w((String)"WrappedDrawableApi21", (String)"Failed to retrieve Drawable#isProjected() method", (Throwable)exception);
            }
        }
    }

    @Override
    d.a b() {
        return new a(this.b, null);
    }

    @Override
    protected boolean c() {
        boolean bl2;
        block2 : {
            block3 : {
                boolean bl3;
                int n2 = Build.VERSION.SDK_INT;
                bl2 = bl3 = false;
                if (n2 != 21) break block2;
                Drawable drawable2 = this.c;
                if (drawable2 instanceof GradientDrawable || drawable2 instanceof DrawableContainer || drawable2 instanceof InsetDrawable) break block3;
                bl2 = bl3;
                if (!(drawable2 instanceof RippleDrawable)) break block2;
            }
            bl2 = true;
        }
        return bl2;
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public void setHotspot(float f2, float f3) {
        this.c.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        this.c.setHotspotBounds(n2, n3, n4, n5);
    }

    @Override
    public boolean setState(int[] arrn) {
        if (super.setState(arrn)) {
            this.invalidateSelf();
            return true;
        }
        return false;
    }

    @Override
    public void setTint(int n2) {
        if (this.c()) {
            super.setTint(n2);
            return;
        }
        this.c.setTint(n2);
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.c()) {
            super.setTintList(colorStateList);
            return;
        }
        this.c.setTintList(colorStateList);
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.c()) {
            super.setTintMode(mode);
            return;
        }
        this.c.setTintMode(mode);
    }

    private static class a
    extends d.a {
        a(d.a a2, Resources resources) {
            super(a2, resources);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

}

