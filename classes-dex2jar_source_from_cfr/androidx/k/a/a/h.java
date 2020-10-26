/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 */
package androidx.k.a.a;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.b;

abstract class h
extends Drawable
implements b {
    Drawable c;

    h() {
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.c != null) {
            a.a(this.c, theme);
        }
    }

    public void clearColorFilter() {
        if (this.c != null) {
            this.c.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    public ColorFilter getColorFilter() {
        if (this.c != null) {
            return a.e(this.c);
        }
        return null;
    }

    public Drawable getCurrent() {
        if (this.c != null) {
            return this.c.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumHeight() {
        if (this.c != null) {
            return this.c.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        if (this.c != null) {
            return this.c.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        if (this.c != null) {
            return this.c.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.c != null) {
            return this.c.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.c != null) {
            return this.c.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        if (this.c != null) {
            a.a(this.c);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
            return;
        }
        super.onBoundsChange(rect);
    }

    protected boolean onLevelChange(int n2) {
        if (this.c != null) {
            return this.c.setLevel(n2);
        }
        return super.onLevelChange(n2);
    }

    public void setChangingConfigurations(int n2) {
        if (this.c != null) {
            this.c.setChangingConfigurations(n2);
            return;
        }
        super.setChangingConfigurations(n2);
    }

    public void setColorFilter(int n2, PorterDuff.Mode mode) {
        if (this.c != null) {
            this.c.setColorFilter(n2, mode);
            return;
        }
        super.setColorFilter(n2, mode);
    }

    public void setFilterBitmap(boolean bl2) {
        if (this.c != null) {
            this.c.setFilterBitmap(bl2);
        }
    }

    public void setHotspot(float f2, float f3) {
        if (this.c != null) {
            a.a(this.c, f2, f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        if (this.c != null) {
            a.a(this.c, n2, n3, n4, n5);
        }
    }

    public boolean setState(int[] arrn) {
        if (this.c != null) {
            return this.c.setState(arrn);
        }
        return super.setState(arrn);
    }
}

