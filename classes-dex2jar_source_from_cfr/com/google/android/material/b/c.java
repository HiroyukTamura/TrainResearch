/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.google.android.material.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.b.a;
import com.google.android.material.b.b;
import com.google.android.material.internal.g;

class c {
    private static final boolean a;
    private final a b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private boolean w = false;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 21;
        a = bl2;
    }

    public c(a a2) {
        this.b = a2;
    }

    private InsetDrawable a(Drawable drawable2) {
        return new InsetDrawable(drawable2, this.c, this.e, this.d, this.f);
    }

    private Drawable i() {
        this.p = new GradientDrawable();
        this.p.setCornerRadius((float)this.g + 1.0E-5f);
        this.p.setColor(-1);
        this.q = androidx.core.graphics.drawable.a.g((Drawable)this.p);
        androidx.core.graphics.drawable.a.a(this.q, this.j);
        if (this.i != null) {
            androidx.core.graphics.drawable.a.a(this.q, this.i);
        }
        this.r = new GradientDrawable();
        this.r.setCornerRadius((float)this.g + 1.0E-5f);
        this.r.setColor(-1);
        this.s = androidx.core.graphics.drawable.a.g((Drawable)this.r);
        androidx.core.graphics.drawable.a.a(this.s, com.google.android.material.j.a.a(this.l));
        return this.a((Drawable)new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    private void j() {
        if (this.t != null) {
            androidx.core.graphics.drawable.a.a((Drawable)this.t, this.j);
            if (this.i != null) {
                androidx.core.graphics.drawable.a.a((Drawable)this.t, this.i);
            }
        }
    }

    @TargetApi(value=21)
    private Drawable k() {
        this.t = new GradientDrawable();
        this.t.setCornerRadius((float)this.g + 1.0E-5f);
        this.t.setColor(-1);
        this.j();
        this.u = new GradientDrawable();
        this.u.setCornerRadius((float)this.g + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.h, this.k);
        InsetDrawable insetDrawable = this.a((Drawable)new LayerDrawable(new Drawable[]{this.t, this.u}));
        this.v = new GradientDrawable();
        this.v.setCornerRadius((float)this.g + 1.0E-5f);
        this.v.setColor(-1);
        return new b(com.google.android.material.j.a.a(this.l), insetDrawable, (Drawable)this.v);
    }

    private void l() {
        if (a && this.u != null) {
            this.b.setInternalBackground(this.k());
            return;
        }
        if (!a) {
            this.b.invalidate();
        }
    }

    private GradientDrawable m() {
        if (a && this.b.getBackground() != null) {
            return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
        }
        return null;
    }

    private GradientDrawable n() {
        if (a && this.b.getBackground() != null) {
            return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
        }
        return null;
    }

    void a() {
        this.w = true;
        this.b.setSupportBackgroundTintList(this.j);
        this.b.setSupportBackgroundTintMode(this.i);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(int n2) {
        block4 : {
            GradientDrawable gradientDrawable;
            block3 : {
                block2 : {
                    if (!a || this.t == null) break block2;
                    gradientDrawable = this.t;
                    break block3;
                }
                if (a || this.p == null) break block4;
                gradientDrawable = this.p;
            }
            gradientDrawable.setColor(n2);
            return;
        }
    }

    void a(int n2, int n3) {
        if (this.v != null) {
            this.v.setBounds(this.c, this.e, n3 - this.d, n2 - this.f);
        }
    }

    void a(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (a) {
                this.j();
                return;
            }
            if (this.q != null) {
                androidx.core.graphics.drawable.a.a(this.q, this.j);
            }
        }
    }

    public void a(TypedArray typedArray) {
        int n2 = a.i.MaterialButton_android_insetLeft;
        int n3 = 0;
        this.c = typedArray.getDimensionPixelOffset(n2, 0);
        this.d = typedArray.getDimensionPixelOffset(a.i.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(a.i.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(a.i.MaterialButton_android_insetBottom, 0);
        this.g = typedArray.getDimensionPixelSize(a.i.MaterialButton_cornerRadius, 0);
        this.h = typedArray.getDimensionPixelSize(a.i.MaterialButton_strokeWidth, 0);
        this.i = g.a(typedArray.getInt(a.i.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = com.google.android.material.i.b.a(this.b.getContext(), typedArray, a.i.MaterialButton_backgroundTint);
        this.k = com.google.android.material.i.b.a(this.b.getContext(), typedArray, a.i.MaterialButton_strokeColor);
        this.l = com.google.android.material.i.b.a(this.b.getContext(), typedArray, a.i.MaterialButton_rippleColor);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth((float)this.h);
        typedArray = this.m;
        if (this.k != null) {
            n3 = this.k.getColorForState(this.b.getDrawableState(), 0);
        }
        typedArray.setColor(n3);
        n3 = t.g((View)this.b);
        n2 = this.b.getPaddingTop();
        int n4 = t.h((View)this.b);
        int n5 = this.b.getPaddingBottom();
        a a2 = this.b;
        typedArray = a ? this.k() : this.i();
        a2.setInternalBackground((Drawable)typedArray);
        t.a((View)this.b, n3 + this.c, n2 + this.e, n4 + this.d, n5 + this.f);
    }

    void a(Canvas canvas) {
        if (canvas != null && this.k != null && this.h > 0) {
            this.n.set(this.b.getBackground().getBounds());
            this.o.set((float)this.n.left + (float)this.h / 2.0f + (float)this.c, (float)this.n.top + (float)this.h / 2.0f + (float)this.e, (float)this.n.right - (float)this.h / 2.0f - (float)this.d, (float)this.n.bottom - (float)this.h / 2.0f - (float)this.f);
            float f2 = (float)this.g - (float)this.h / 2.0f;
            canvas.drawRoundRect(this.o, f2, f2, this.m);
        }
    }

    void a(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (a) {
                this.j();
                return;
            }
            if (this.q != null && this.i != null) {
                androidx.core.graphics.drawable.a.a(this.q, this.i);
            }
        }
    }

    void b(int n2) {
        if (this.h != n2) {
            this.h = n2;
            this.m.setStrokeWidth((float)n2);
            this.l();
        }
    }

    void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (a && this.b.getBackground() instanceof RippleDrawable) {
                ((RippleDrawable)this.b.getBackground()).setColor(com.google.android.material.j.a.a(colorStateList));
                return;
            }
            if (!a && this.s != null) {
                androidx.core.graphics.drawable.a.a(this.s, com.google.android.material.j.a.a(colorStateList));
            }
        }
    }

    boolean b() {
        return this.w;
    }

    ColorStateList c() {
        return this.j;
    }

    void c(int n2) {
        if (this.g != n2) {
            this.g = n2;
            if (a && this.t != null && this.u != null && this.v != null) {
                GradientDrawable gradientDrawable;
                float f2;
                if (Build.VERSION.SDK_INT == 21) {
                    gradientDrawable = this.n();
                    f2 = (float)n2 + 1.0E-5f;
                    gradientDrawable.setCornerRadius(f2);
                    this.m().setCornerRadius(f2);
                }
                gradientDrawable = this.t;
                f2 = (float)n2 + 1.0E-5f;
                gradientDrawable.setCornerRadius(f2);
                this.u.setCornerRadius(f2);
                this.v.setCornerRadius(f2);
                return;
            }
            if (!a && this.p != null && this.r != null) {
                GradientDrawable gradientDrawable = this.p;
                float f3 = (float)n2 + 1.0E-5f;
                gradientDrawable.setCornerRadius(f3);
                this.r.setCornerRadius(f3);
                this.b.invalidate();
            }
        }
    }

    void c(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            Paint paint = this.m;
            int n2 = 0;
            if (colorStateList != null) {
                n2 = colorStateList.getColorForState(this.b.getDrawableState(), 0);
            }
            paint.setColor(n2);
            this.l();
        }
    }

    PorterDuff.Mode d() {
        return this.i;
    }

    ColorStateList e() {
        return this.l;
    }

    ColorStateList f() {
        return this.k;
    }

    int g() {
        return this.h;
    }

    int h() {
        return this.g;
    }
}

