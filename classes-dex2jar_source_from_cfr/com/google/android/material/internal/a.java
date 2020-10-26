/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class a
extends Drawable {
    final Paint a;
    final Rect b;
    final RectF c;
    final a d;
    float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private boolean l;
    private float m;

    private Shader a() {
        Rect rect = this.b;
        this.copyBounds(rect);
        float f2 = this.e / (float)rect.height();
        int n2 = androidx.core.graphics.a.a(this.f, this.k);
        int n3 = androidx.core.graphics.a.a(this.g, this.k);
        int n4 = androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.g, 0), this.k);
        int n5 = androidx.core.graphics.a.a(androidx.core.graphics.a.b(this.i, 0), this.k);
        int n6 = androidx.core.graphics.a.a(this.i, this.k);
        int n7 = androidx.core.graphics.a.a(this.h, this.k);
        float f3 = rect.top;
        float f4 = rect.bottom;
        rect = Shader.TileMode.CLAMP;
        return new LinearGradient(0.0f, f3, 0.0f, f4, new int[]{n2, n3, n4, n5, n6, n7}, new float[]{0.0f, f2, 0.5f, 0.5f, 1.0f - f2, 1.0f}, (Shader.TileMode)rect);
    }

    public final void a(float f2) {
        if (f2 != this.m) {
            this.m = f2;
            this.invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(this.getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        this.invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (this.l) {
            this.a.setShader(this.a());
            this.l = false;
        }
        float f2 = this.a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        this.copyBounds(this.b);
        rectF.set(this.b);
        rectF.left += f2;
        rectF.top += f2;
        rectF.right -= f2;
        rectF.bottom -= f2;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.a);
        canvas.restore();
    }

    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    public int getOpacity() {
        if (this.e > 0.0f) {
            return -3;
        }
        return -2;
    }

    public boolean getPadding(Rect rect) {
        int n2 = Math.round(this.e);
        rect.set(n2, n2, n2, n2);
        return true;
    }

    public boolean isStateful() {
        return this.j != null && this.j.isStateful() || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.l = true;
    }

    protected boolean onStateChange(int[] arrn) {
        int n2;
        if (this.j != null && (n2 = this.j.getColorForState(arrn, this.k)) != this.k) {
            this.l = true;
            this.k = n2;
        }
        if (this.l) {
            this.invalidateSelf();
        }
        return this.l;
    }

    public void setAlpha(int n2) {
        this.a.setAlpha(n2);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    private class a
    extends Drawable.ConstantState {
        final /* synthetic */ a a;

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return this.a;
        }
    }

}

