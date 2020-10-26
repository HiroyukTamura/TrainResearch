/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
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
package androidx.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

class h
extends Drawable {
    static a a;
    private static final double b;
    private final int c;
    private Paint d;
    private Paint e;
    private Paint f;
    private final RectF g;
    private float h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private boolean n;
    private final int o;
    private final int p;
    private boolean q;
    private boolean r;

    static {
        b = Math.cos(Math.toRadians(45.0));
    }

    static float a(float f2, float f3, boolean bl2) {
        if (bl2) {
            return (float)((double)(f2 * 1.5f) + (1.0 - b) * (double)f3);
        }
        return f2 * 1.5f;
    }

    private void a(float f2, float f3) {
        if (!(f2 < 0.0f)) {
            if (!(f3 < 0.0f)) {
                float f4 = this.d(f2);
                f3 = this.d(f3);
                f2 = f4;
                if (f4 > f3) {
                    if (!this.r) {
                        this.r = true;
                    }
                    f2 = f3;
                }
                if (this.l == f2 && this.j == f3) {
                    return;
                }
                this.l = f2;
                this.j = f3;
                this.k = (int)(f2 * 1.5f + (float)this.c + 0.5f);
                this.n = true;
                this.invalidateSelf();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid max shadow size ");
            stringBuilder.append(f3);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid shadow size ");
        stringBuilder.append(f2);
        stringBuilder.append(". Must be >= 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void a(Canvas canvas) {
        float f2;
        float f3 = -this.h - this.k;
        float f4 = this.h + (float)this.c + this.l / 2.0f;
        float f5 = this.g.width();
        int n2 = f5 - (f2 = f4 * 2.0f) > 0.0f ? 1 : 0;
        boolean bl2 = this.g.height() - f2 > 0.0f;
        int n3 = canvas.save();
        canvas.translate(this.g.left + f4, this.g.top + f4);
        canvas.drawPath(this.i, this.e);
        if (n2 != 0) {
            canvas.drawRect(0.0f, f3, this.g.width() - f2, -this.h, this.f);
        }
        canvas.restoreToCount(n3);
        n3 = canvas.save();
        canvas.translate(this.g.right - f4, this.g.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (n2 != 0) {
            canvas.drawRect(0.0f, f3, this.g.width() - f2, -this.h + this.k, this.f);
        }
        canvas.restoreToCount(n3);
        n2 = canvas.save();
        canvas.translate(this.g.left + f4, this.g.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (bl2) {
            canvas.drawRect(0.0f, f3, this.g.height() - f2, -this.h, this.f);
        }
        canvas.restoreToCount(n2);
        n2 = canvas.save();
        canvas.translate(this.g.right - f4, this.g.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (bl2) {
            canvas.drawRect(0.0f, f3, this.g.height() - f2, -this.h, this.f);
        }
        canvas.restoreToCount(n2);
    }

    static float b(float f2, float f3, boolean bl2) {
        float f4 = f2;
        if (bl2) {
            f4 = (float)((double)f2 + (1.0 - b) * (double)f3);
        }
        return f4;
    }

    private void b(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList == null) {
            colorStateList2 = ColorStateList.valueOf((int)0);
        }
        this.m = colorStateList2;
        this.d.setColor(this.m.getColorForState(this.getState(), this.m.getDefaultColor()));
    }

    private void b(Rect rect) {
        float f2 = this.j * 1.5f;
        this.g.set((float)rect.left + this.j, (float)rect.top + f2, (float)rect.right - this.j, (float)rect.bottom - f2);
        this.g();
    }

    private int d(float f2) {
        int n2;
        int n3 = n2 = (int)(f2 + 0.5f);
        if (n2 % 2 == 1) {
            n3 = n2 - 1;
        }
        return n3;
    }

    private void g() {
        RectF rectF = new RectF(-this.h, -this.h, this.h, this.h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.k, -this.k);
        if (this.i == null) {
            this.i = new Path();
        } else {
            this.i.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f2 = this.h / (this.h + this.k);
        rectF = this.e;
        float f3 = this.h;
        float f4 = this.k;
        int n2 = this.o;
        int n3 = this.o;
        int n4 = this.p;
        rectF2 = Shader.TileMode.CLAMP;
        rectF.setShader((Shader)new RadialGradient(0.0f, 0.0f, f3 + f4, new int[]{n2, n3, n4}, new float[]{0.0f, f2, 1.0f}, (Shader.TileMode)rectF2));
        rectF = this.f;
        f2 = -this.h;
        f3 = this.k;
        f4 = -this.h;
        float f5 = this.k;
        n2 = this.o;
        n3 = this.o;
        n4 = this.p;
        rectF2 = Shader.TileMode.CLAMP;
        rectF.setShader((Shader)new LinearGradient(0.0f, f2 + f3, 0.0f, f4 - f5, new int[]{n2, n3, n4}, new float[]{0.0f, 0.5f, 1.0f}, (Shader.TileMode)rectF2));
        this.f.setAntiAlias(false);
    }

    float a() {
        return this.h;
    }

    void a(float f2) {
        if (!(f2 < 0.0f)) {
            if (this.h == (f2 = (float)((int)(f2 + 0.5f)))) {
                return;
            }
            this.h = f2;
            this.n = true;
            this.invalidateSelf();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid radius ");
        stringBuilder.append(f2);
        stringBuilder.append(". Must be >= 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void a(ColorStateList colorStateList) {
        this.b(colorStateList);
        this.invalidateSelf();
    }

    void a(Rect rect) {
        this.getPadding(rect);
    }

    void a(boolean bl2) {
        this.q = bl2;
        this.invalidateSelf();
    }

    float b() {
        return this.l;
    }

    void b(float f2) {
        this.a(f2, this.j);
    }

    float c() {
        return this.j;
    }

    void c(float f2) {
        this.a(this.l, f2);
    }

    float d() {
        return Math.max(this.j, this.h + (float)this.c + this.j / 2.0f) * 2.0f + (this.j + (float)this.c) * 2.0f;
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            this.b(this.getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        this.a(canvas);
        canvas.translate(0.0f, -this.l / 2.0f);
        a.a(canvas, this.g, this.h, this.d);
    }

    float e() {
        return Math.max(this.j, this.h + (float)this.c + this.j * 1.5f / 2.0f) * 2.0f + (this.j * 1.5f + (float)this.c) * 2.0f;
    }

    ColorStateList f() {
        return this.m;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int n2 = (int)Math.ceil(h.a(this.j, this.h, this.q));
        int n3 = (int)Math.ceil(h.b(this.j, this.h, this.q));
        rect.set(n3, n2, n3, n2);
        return true;
    }

    public boolean isStateful() {
        return this.m != null && this.m.isStateful() || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    protected boolean onStateChange(int[] arrn) {
        int n2 = this.m.getColorForState(arrn, this.m.getDefaultColor());
        if (this.d.getColor() == n2) {
            return false;
        }
        this.d.setColor(n2);
        this.n = true;
        this.invalidateSelf();
        return true;
    }

    public void setAlpha(int n2) {
        this.d.setAlpha(n2);
        this.e.setAlpha(n2);
        this.f.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    static interface a {
        public void a(Canvas var1, RectF var2, float var3, Paint var4);
    }

}

