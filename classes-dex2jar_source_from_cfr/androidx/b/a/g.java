/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 */
package androidx.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.b.a.h;

class g
extends Drawable {
    private float a;
    private final Paint b;
    private final RectF c;
    private final Rect d;
    private float e;
    private boolean f;
    private boolean g;
    private ColorStateList h;
    private PorterDuffColorFilter i;
    private ColorStateList j;
    private PorterDuff.Mode k;

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    private void a(Rect rect) {
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = this.getBounds();
        }
        this.c.set((float)rect2.left, (float)rect2.top, (float)rect2.right, (float)rect2.bottom);
        this.d.set(rect2);
        if (this.f) {
            float f2 = h.a(this.e, this.a, this.g);
            float f3 = h.b(this.e, this.a, this.g);
            this.d.inset((int)Math.ceil(f3), (int)Math.ceil(f2));
            this.c.set(this.d);
        }
    }

    private void b(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList == null) {
            colorStateList2 = ColorStateList.valueOf((int)0);
        }
        this.h = colorStateList2;
        this.b.setColor(this.h.getColorForState(this.getState(), this.h.getDefaultColor()));
    }

    float a() {
        return this.e;
    }

    void a(float f2) {
        if (f2 == this.a) {
            return;
        }
        this.a = f2;
        this.a((Rect)null);
        this.invalidateSelf();
    }

    void a(float f2, boolean bl2, boolean bl3) {
        if (f2 == this.e && this.f == bl2 && this.g == bl3) {
            return;
        }
        this.e = f2;
        this.f = bl2;
        this.g = bl3;
        this.a((Rect)null);
        this.invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        this.b(colorStateList);
        this.invalidateSelf();
    }

    public float b() {
        return this.a;
    }

    public ColorStateList c() {
        return this.h;
    }

    public void draw(Canvas canvas) {
        boolean bl2;
        Paint paint = this.b;
        if (this.i != null && paint.getColorFilter() == null) {
            paint.setColorFilter((ColorFilter)this.i);
            bl2 = true;
        } else {
            bl2 = false;
        }
        canvas.drawRoundRect(this.c, this.a, this.a, paint);
        if (bl2) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }

    public boolean isStateful() {
        return this.j != null && this.j.isStateful() || this.h != null && this.h.isStateful() || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a(rect);
    }

    protected boolean onStateChange(int[] arrn) {
        int n2 = this.h.getColorForState(arrn, this.h.getDefaultColor());
        boolean bl2 = n2 != this.b.getColor();
        if (bl2) {
            this.b.setColor(n2);
        }
        if (this.j != null && this.k != null) {
            this.i = this.a(this.j, this.k);
            return true;
        }
        return bl2;
    }

    public void setAlpha(int n2) {
        this.b.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = this.a(this.j, this.k);
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = this.a(this.j, this.k);
        this.invalidateSelf();
    }
}

