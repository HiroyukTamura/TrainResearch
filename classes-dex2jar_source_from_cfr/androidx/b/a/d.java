/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 */
package androidx.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.b.a.e;
import androidx.b.a.f;
import androidx.b.a.h;

class d
implements f {
    final RectF a = new RectF();

    d() {
    }

    private h j(e e2) {
        return (h)e2.a();
    }

    @Override
    public float a(e e2) {
        return this.j(e2).c();
    }

    @Override
    public void a() {
        h.a = new h.a(){

            @Override
            public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                float f3 = 2.0f * f2;
                float f4 = rectF.width() - f3 - 1.0f;
                float f5 = rectF.height();
                if (f2 >= 1.0f) {
                    float f6 = f2 + 0.5f;
                    RectF rectF2 = d.this.a;
                    float f7 = -f6;
                    rectF2.set(f7, f7, f6, f6);
                    int n2 = canvas.save();
                    canvas.translate(rectF.left + f6, rectF.top + f6);
                    canvas.drawArc(d.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(f4, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(d.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(f5 - f3 - 1.0f, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(d.this.a, 180.0f, 90.0f, true, paint);
                    canvas.translate(f4, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(d.this.a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(n2);
                    canvas.drawRect(rectF.left + f6 - 1.0f, rectF.top, rectF.right - f6 + 1.0f, rectF.top + f6, paint);
                    canvas.drawRect(rectF.left + f6 - 1.0f, rectF.bottom - f6, rectF.right - f6 + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f2, rectF.right, rectF.bottom - f2, paint);
            }
        };
    }

    @Override
    public void a(e e2, float f2) {
        this.j(e2).a(f2);
        this.f(e2);
    }

    @Override
    public void a(e e2, ColorStateList colorStateList) {
        this.j(e2).a(colorStateList);
    }

    @Override
    public float b(e e2) {
        return this.j(e2).d();
    }

    @Override
    public void b(e e2, float f2) {
        this.j(e2).c(f2);
        this.f(e2);
    }

    @Override
    public float c(e e2) {
        return this.j(e2).e();
    }

    @Override
    public void c(e e2, float f2) {
        this.j(e2).b(f2);
    }

    @Override
    public float d(e e2) {
        return this.j(e2).a();
    }

    @Override
    public float e(e e2) {
        return this.j(e2).b();
    }

    public void f(e e2) {
        Rect rect = new Rect();
        this.j(e2).a(rect);
        e2.a((int)Math.ceil(this.b(e2)), (int)Math.ceil(this.c(e2)));
        e2.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override
    public void g(e e2) {
    }

    @Override
    public void h(e e2) {
        this.j(e2).a(e2.c());
        this.f(e2);
    }

    @Override
    public ColorStateList i(e e2) {
        return this.j(e2).f();
    }

}

