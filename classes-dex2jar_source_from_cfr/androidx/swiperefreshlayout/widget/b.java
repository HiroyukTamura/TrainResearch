/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 */
package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.g.e;

public class b
extends Drawable
implements Animatable {
    private static final Interpolator c = new LinearInterpolator();
    private static final Interpolator d = new androidx.g.a.a.b();
    private static final int[] e = new int[]{-16777216};
    float a;
    boolean b;
    private final a f;
    private float g;
    private Resources h;
    private Animator i;

    public b(Context context) {
        this.h = e.a(context).getResources();
        this.f = new a();
        this.f.a(e);
        this.a(2.5f);
        this.a();
    }

    private int a(float f2, int n2, int n3) {
        int n4 = n2 >> 24 & 255;
        int n5 = n2 >> 16 & 255;
        int n6 = n2 >> 8 & 255;
        return n4 + (int)((float)((n3 >> 24 & 255) - n4) * f2) << 24 | n5 + (int)((float)((n3 >> 16 & 255) - n5) * f2) << 16 | n6 + (int)((float)((n3 >> 8 & 255) - n6) * f2) << 8 | (n2 &= 255) + (int)(f2 * (float)((n3 & 255) - n2));
    }

    private void a() {
        final a a2 = this.f;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                b.this.a(f2, a2);
                b.this.a(f2, a2, false);
                b.this.invalidateSelf();
            }
        });
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator((TimeInterpolator)c);
        valueAnimator.addListener(new Animator.AnimatorListener(){

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                b.this.a(1.0f, a2, true);
                a2.k();
                a2.c();
                if (b.this.b) {
                    b.this.b = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    a2.a(false);
                    return;
                }
                b.this.a += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                b.this.a = 0.0f;
            }
        });
        this.i = valueAnimator;
    }

    private void a(float f2, float f3, float f4, float f5) {
        a a2 = this.f;
        float f6 = this.h.getDisplayMetrics().density;
        a2.a(f3 * f6);
        a2.e(f2 * f6);
        a2.b(0);
        a2.a(f4 * f6, f5 * f6);
    }

    private void b(float f2, a a2) {
        this.a(f2, a2);
        float f3 = (float)(Math.floor(a2.j() / 0.8f) + 1.0);
        a2.b(a2.f() + (a2.g() - 0.01f - a2.f()) * f2);
        a2.c(a2.g());
        a2.d(a2.j() + (f3 - a2.j()) * f2);
    }

    private void d(float f2) {
        this.g = f2;
    }

    public void a(float f2) {
        this.f.a(f2);
        this.invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.f.b(f2);
        this.f.c(f3);
        this.invalidateSelf();
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(float f2, a a2) {
        int n2 = f2 > 0.75f ? this.a((f2 - 0.75f) / 0.25f, a2.h(), a2.a()) : a2.h();
        a2.a(n2);
    }

    void a(float f2, a a2, boolean bl2) {
        if (this.b) {
            this.b(f2, a2);
            return;
        }
        if (f2 != 1.0f || bl2) {
            float f3;
            float f4;
            float f5 = a2.j();
            if (f2 < 0.5f) {
                f4 = f2 / 0.5f;
                f3 = a2.f();
                f4 = d.getInterpolation(f4) * 0.79f + 0.01f + f3;
            } else {
                f3 = (f2 - 0.5f) / 0.5f;
                f4 = a2.f() + 0.79f;
                f3 = f4 - ((1.0f - d.getInterpolation(f3)) * 0.79f + 0.01f);
            }
            float f6 = this.a;
            a2.b(f3);
            a2.c(f4);
            a2.d(f5 + 0.20999998f * f2);
            this.d((f2 + f6) * 216.0f);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n2) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (n2 == 0) {
            f3 = 11.0f;
            f5 = 3.0f;
            f2 = 12.0f;
            f4 = 6.0f;
        } else {
            f3 = 7.5f;
            f5 = 2.5f;
            f2 = 10.0f;
            f4 = 5.0f;
        }
        this.a(f3, f5, f2, f4);
        this.invalidateSelf();
    }

    public void a(boolean bl2) {
        this.f.a(bl2);
        this.invalidateSelf();
    }

    public /* varargs */ void a(int ... arrn) {
        this.f.a(arrn);
        this.f.b(0);
        this.invalidateSelf();
    }

    public void b(float f2) {
        this.f.f(f2);
        this.invalidateSelf();
    }

    public void c(float f2) {
        this.f.d(f2);
        this.invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect rect = this.getBounds();
        canvas.save();
        canvas.rotate(this.g, rect.exactCenterX(), rect.exactCenterY());
        this.f.a(canvas, rect);
        canvas.restore();
    }

    public int getAlpha() {
        return this.f.d();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.i.isRunning();
    }

    public void setAlpha(int n2) {
        this.f.c(n2);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.a(colorFilter);
        this.invalidateSelf();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void start() {
        long l2;
        Animator animator;
        this.i.cancel();
        this.f.k();
        if (this.f.i() != this.f.e()) {
            this.b = true;
            animator = this.i;
            l2 = 666L;
        } else {
            this.f.b(0);
            this.f.l();
            animator = this.i;
            l2 = 1332L;
        }
        animator.setDuration(l2);
        this.i.start();
    }

    public void stop() {
        this.i.cancel();
        this.d(0.0f);
        this.f.a(false);
        this.f.b(0);
        this.f.l();
        this.invalidateSelf();
    }

    private static class a {
        final RectF a = new RectF();
        final Paint b = new Paint();
        final Paint c = new Paint();
        final Paint d = new Paint();
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 5.0f;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p = 1.0f;
        float q;
        int r;
        int s;
        int t = 255;
        int u;

        a() {
            this.b.setStrokeCap(Paint.Cap.SQUARE);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
            this.d.setColor(0);
        }

        int a() {
            return this.i[this.b()];
        }

        void a(float f2) {
            this.h = f2;
            this.b.setStrokeWidth(f2);
        }

        void a(float f2, float f3) {
            this.r = (int)f2;
            this.s = (int)f3;
        }

        void a(int n2) {
            this.u = n2;
        }

        void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                if (this.o == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.o.reset();
                }
                float f4 = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f5 = (float)this.r * this.p / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo((float)this.r * this.p, 0.0f);
                this.o.lineTo((float)this.r * this.p / 2.0f, (float)this.s * this.p);
                this.o.offset(f4 + rectF.centerX() - f5, rectF.centerY() + this.h / 2.0f);
                this.o.close();
                this.c.setColor(this.u);
                this.c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.c);
                canvas.restore();
            }
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            float f2 = this.q + this.h / 2.0f;
            if (this.q <= 0.0f) {
                f2 = (float)Math.min(rect.width(), rect.height()) / 2.0f - Math.max((float)this.r * this.p / 2.0f, this.h / 2.0f);
            }
            rectF.set((float)rect.centerX() - f2, (float)rect.centerY() - f2, (float)rect.centerX() + f2, (float)rect.centerY() + f2);
            f2 = (this.e + this.g) * 360.0f;
            float f3 = (this.f + this.g) * 360.0f - f2;
            this.b.setColor(this.u);
            this.b.setAlpha(this.t);
            float f4 = this.h / 2.0f;
            rectF.inset(f4, f4);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
            f4 = -f4;
            rectF.inset(f4, f4);
            canvas.drawArc(rectF, f2, f3, false, this.b);
            this.a(canvas, f2, f3, rectF);
        }

        void a(ColorFilter colorFilter) {
            this.b.setColorFilter(colorFilter);
        }

        void a(boolean bl2) {
            if (this.n != bl2) {
                this.n = bl2;
            }
        }

        void a(int[] arrn) {
            this.i = arrn;
            this.b(0);
        }

        int b() {
            return (this.j + 1) % this.i.length;
        }

        void b(float f2) {
            this.e = f2;
        }

        void b(int n2) {
            this.j = n2;
            this.u = this.i[this.j];
        }

        void c() {
            this.b(this.b());
        }

        void c(float f2) {
            this.f = f2;
        }

        void c(int n2) {
            this.t = n2;
        }

        int d() {
            return this.t;
        }

        void d(float f2) {
            this.g = f2;
        }

        float e() {
            return this.e;
        }

        void e(float f2) {
            this.q = f2;
        }

        float f() {
            return this.k;
        }

        void f(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }

        float g() {
            return this.l;
        }

        int h() {
            return this.i[this.j];
        }

        float i() {
            return this.f;
        }

        float j() {
            return this.m;
        }

        void k() {
            this.k = this.e;
            this.l = this.f;
            this.m = this.g;
        }

        void l() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.b(0.0f);
            this.c(0.0f);
            this.d(0.0f);
        }
    }

}

