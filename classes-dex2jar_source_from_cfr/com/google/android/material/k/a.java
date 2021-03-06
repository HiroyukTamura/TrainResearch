/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RadialGradient
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.k;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.b.a.c;

public class a
extends c {
    static final double a = Math.cos(Math.toRadians(45.0));
    final Paint b;
    final Paint c;
    final RectF d;
    float e;
    Path f;
    float g;
    float h;
    float i;
    float j;
    private boolean k;
    private final int l;
    private final int m;
    private final int n;
    private boolean o;
    private float p;
    private boolean q;

    public static float a(float f2, float f3, boolean bl2) {
        if (bl2) {
            return (float)((double)(f2 * 1.5f) + (1.0 - a) * (double)f3);
        }
        return f2 * 1.5f;
    }

    private void a(Canvas canvas) {
        int n2 = canvas.save();
        canvas.rotate(this.p, this.d.centerX(), this.d.centerY());
        float f2 = -this.e - this.i;
        float f3 = this.e;
        float f4 = this.d.width();
        float f5 = f3 * 2.0f;
        int n3 = f4 - f5 > 0.0f ? 1 : 0;
        boolean bl2 = this.d.height() - f5 > 0.0f;
        float f6 = this.j;
        float f7 = this.j;
        float f8 = this.j;
        float f9 = this.j;
        f4 = this.j;
        float f10 = this.j;
        f8 = f3 / (f8 - f9 * 0.5f + f3);
        f6 = f3 / (f6 - f7 * 0.25f + f3);
        f4 = f3 / (f4 - f10 * 1.0f + f3);
        int n4 = canvas.save();
        canvas.translate(this.d.left + f3, this.d.top + f3);
        canvas.scale(f8, f6);
        canvas.drawPath(this.f, this.b);
        if (n3 != 0) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.width() - f5, -this.e, this.c);
        }
        canvas.restoreToCount(n4);
        n4 = canvas.save();
        canvas.translate(this.d.right - f3, this.d.bottom - f3);
        canvas.scale(f8, f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f, this.b);
        if (n3 != 0) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.width() - f5, -this.e + this.i, this.c);
        }
        canvas.restoreToCount(n4);
        n3 = canvas.save();
        canvas.translate(this.d.left + f3, this.d.bottom - f3);
        canvas.scale(f8, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f, this.b);
        if (bl2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.height() - f5, -this.e, this.c);
        }
        canvas.restoreToCount(n3);
        n3 = canvas.save();
        canvas.translate(this.d.right - f3, this.d.top + f3);
        canvas.scale(f8, f6);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f, this.b);
        if (bl2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f2, this.d.height() - f5, -this.e, this.c);
        }
        canvas.restoreToCount(n3);
        canvas.restoreToCount(n2);
    }

    private void a(Rect rect) {
        float f2 = this.h * 1.5f;
        this.d.set((float)rect.left + this.h, (float)rect.top + f2, (float)rect.right - this.h, (float)rect.bottom - f2);
        this.a().setBounds((int)this.d.left, (int)this.d.top, (int)this.d.right, (int)this.d.bottom);
        this.c();
    }

    public static float b(float f2, float f3, boolean bl2) {
        float f4 = f2;
        if (bl2) {
            f4 = (float)((double)f2 + (1.0 - a) * (double)f3);
        }
        return f4;
    }

    private static int c(float f2) {
        int n2;
        int n3 = n2 = Math.round(f2);
        if (n2 % 2 == 1) {
            n3 = n2 - 1;
        }
        return n3;
    }

    private void c() {
        int n2;
        Paint paint;
        int n3;
        int n4;
        float f2;
        RectF rectF = new RectF(-this.e, -this.e, this.e, this.e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.i, -this.i);
        if (this.f == null) {
            this.f = new Path();
        } else {
            this.f.reset();
        }
        this.f.setFillType(Path.FillType.EVEN_ODD);
        this.f.moveTo(-this.e, 0.0f);
        this.f.rLineTo(-this.i, 0.0f);
        this.f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f.close();
        float f3 = -rectF2.top;
        if (f3 > 0.0f) {
            f2 = this.e / f3;
            float f4 = (1.0f - f2) / 2.0f;
            paint = this.b;
            n4 = this.l;
            n2 = this.m;
            n3 = this.n;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader((Shader)new RadialGradient(0.0f, 0.0f, f3, new int[]{0, n4, n2, n3}, new float[]{0.0f, f2, f4 + f2, 1.0f}, tileMode));
        }
        paint = this.c;
        f3 = rectF.top;
        f2 = rectF2.top;
        n4 = this.l;
        n2 = this.m;
        n3 = this.n;
        rectF = Shader.TileMode.CLAMP;
        paint.setShader((Shader)new LinearGradient(0.0f, f3, 0.0f, f2, new int[]{n4, n2, n3}, new float[]{0.0f, 0.5f, 1.0f}, (Shader.TileMode)rectF));
        this.c.setAntiAlias(false);
    }

    public void a(float f2) {
        this.a(f2, this.h);
    }

    public void a(float f2, float f3) {
        if (!(f2 < 0.0f) && !(f3 < 0.0f)) {
            float f4 = a.c(f2);
            f3 = a.c(f3);
            f2 = f4;
            if (f4 > f3) {
                if (!this.q) {
                    this.q = true;
                }
                f2 = f3;
            }
            if (this.j == f2 && this.h == f3) {
                return;
            }
            this.j = f2;
            this.h = f3;
            this.i = Math.round(f2 * 1.5f);
            this.g = f3;
            this.k = true;
            this.invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public float b() {
        return this.j;
    }

    public final void b(float f2) {
        if (this.p != f2) {
            this.p = f2;
            this.invalidateSelf();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.k) {
            this.a(this.getBounds());
            this.k = false;
        }
        this.a(canvas);
        super.draw(canvas);
    }

    @Override
    public int getOpacity() {
        return -3;
    }

    @Override
    public boolean getPadding(Rect rect) {
        int n2 = (int)Math.ceil(a.a(this.h, this.e, this.o));
        int n3 = (int)Math.ceil(a.b(this.h, this.e, this.o));
        rect.set(n3, n2, n3, n2);
        return true;
    }

    @Override
    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    @Override
    public void setAlpha(int n2) {
        super.setAlpha(n2);
        this.b.setAlpha(n2);
        this.c.setAlpha(n2);
    }
}

