/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.SystemClock
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 */
package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.h.t;

public abstract class a
implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();
    final a a = new a();
    final View b;
    boolean c;
    boolean d;
    boolean e;
    private final Interpolator f = new AccelerateInterpolator();
    private Runnable g;
    private float[] h = new float[]{0.0f, 0.0f};
    private float[] i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int j;
    private int k;
    private float[] l = new float[]{0.0f, 0.0f};
    private float[] m = new float[]{0.0f, 0.0f};
    private float[] n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean o;
    private boolean p;
    private boolean q;

    public a(View view) {
        this.b = view;
        view = Resources.getSystem().getDisplayMetrics();
        int n2 = (int)(view.density * 1575.0f + 0.5f);
        int n3 = (int)(view.density * 315.0f + 0.5f);
        float f2 = n2;
        this.a(f2, f2);
        f2 = n3;
        this.b(f2, f2);
        this.a(1);
        this.e(Float.MAX_VALUE, Float.MAX_VALUE);
        this.d(0.2f, 0.2f);
        this.c(1.0f, 1.0f);
        this.b(r);
        this.c(500);
        this.d(500);
    }

    static float a(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        if (f2 < f3) {
            return f3;
        }
        return f2;
    }

    private float a(float f2, float f3, float f4, float f5) {
        block4 : {
            block3 : {
                block2 : {
                    f2 = a.a(f2 * f3, 0.0f, f4);
                    f4 = this.f(f5, f2);
                    if (!((f2 = this.f(f3 - f5, f2) - f4) < 0.0f)) break block2;
                    f2 = -this.f.getInterpolation(-f2);
                    break block3;
                }
                if (!(f2 > 0.0f)) break block4;
                f2 = this.f.getInterpolation(f2);
            }
            return a.a(f2, -1.0f, 1.0f);
        }
        return 0.0f;
    }

    private float a(int n2, float f2, float f3, float f4) {
        float f5 = f2 = this.a(this.h[n2], f3, this.i[n2], f2) FCMPL 0.0f;
        if (f5 == false) {
            return 0.0f;
        }
        float f6 = this.l[n2];
        f3 = this.m[n2];
        float f7 = this.n[n2];
        f4 = f6 * f4;
        if (f5 > 0) {
            return a.a(f2 * f4, f3, f7);
        }
        return -a.a(-f2 * f4, f3, f7);
    }

    static int a(int n2, int n3, int n4) {
        if (n2 > n4) {
            return n4;
        }
        if (n2 < n3) {
            return n3;
        }
        return n2;
    }

    private void c() {
        if (this.g == null) {
            this.g = new b();
        }
        this.e = true;
        this.c = true;
        if (!this.o && this.k > 0) {
            t.a(this.b, this.g, (long)this.k);
        } else {
            this.g.run();
        }
        this.o = true;
    }

    private void d() {
        if (this.c) {
            this.e = false;
            return;
        }
        this.a.b();
    }

    private float f(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        switch (this.j) {
            default: {
                return 0.0f;
            }
            case 2: {
                if (!(f2 < 0.0f)) break;
                return f2 / -f3;
            }
            case 0: 
            case 1: {
                if (!(f2 < f3)) break;
                if (f2 >= 0.0f) {
                    return 1.0f - f2 / f3;
                }
                if (!this.e || this.j != 1) break;
                return 1.0f;
            }
        }
        return 0.0f;
    }

    public a a(float f2, float f3) {
        this.n[0] = f2 / 1000.0f;
        this.n[1] = f3 / 1000.0f;
        return this;
    }

    public a a(int n2) {
        this.j = n2;
        return this;
    }

    public a a(boolean bl2) {
        if (this.p && !bl2) {
            this.d();
        }
        this.p = bl2;
        return this;
    }

    public abstract void a(int var1, int var2);

    boolean a() {
        a a2 = this.a;
        int n2 = a2.f();
        int n3 = a2.e();
        return n2 != 0 && this.f(n2) || n3 != 0 && this.e(n3);
    }

    public a b(float f2, float f3) {
        this.m[0] = f2 / 1000.0f;
        this.m[1] = f3 / 1000.0f;
        return this;
    }

    public a b(int n2) {
        this.k = n2;
        return this;
    }

    void b() {
        long l2 = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
        this.b.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }

    public a c(float f2, float f3) {
        this.l[0] = f2 / 1000.0f;
        this.l[1] = f3 / 1000.0f;
        return this;
    }

    public a c(int n2) {
        this.a.a(n2);
        return this;
    }

    public a d(float f2, float f3) {
        this.h[0] = f2;
        this.h[1] = f3;
        return this;
    }

    public a d(int n2) {
        this.a.b(n2);
        return this;
    }

    public a e(float f2, float f3) {
        this.i[0] = f2;
        this.i[1] = f3;
        return this;
    }

    public abstract boolean e(int var1);

    public abstract boolean f(int var1);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl2 = this.p;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            default: {
                break;
            }
            case 1: 
            case 3: {
                this.d();
                break;
            }
            case 0: {
                this.d = true;
                this.o = false;
            }
            case 2: {
                float f2 = this.a(0, motionEvent.getX(), (float)view.getWidth(), (float)this.b.getWidth());
                float f3 = this.a(1, motionEvent.getY(), (float)view.getHeight(), (float)this.b.getHeight());
                this.a.a(f2, f3);
                if (this.e || !this.a()) break;
                this.c();
            }
        }
        bl2 = bl3;
        if (this.q) {
            bl2 = bl3;
            if (this.e) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private static class a {
        private int a;
        private int b;
        private float c;
        private float d;
        private long e = Long.MIN_VALUE;
        private long f = 0L;
        private int g = 0;
        private int h = 0;
        private long i = -1L;
        private float j;
        private int k;

        a() {
        }

        private float a(float f2) {
            return -4.0f * f2 * f2 + f2 * 4.0f;
        }

        private float a(long l2) {
            if (l2 < this.e) {
                return 0.0f;
            }
            if (this.i >= 0L && l2 >= this.i) {
                long l3 = this.i;
                return 1.0f - this.j + this.j * a.a((float)(l2 - l3) / (float)this.k, 0.0f, 1.0f);
            }
            return a.a((float)(l2 - this.e) / (float)this.a, 0.0f, 1.0f) * 0.5f;
        }

        public void a() {
            this.e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f = this.e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void a(float f2, float f3) {
            this.c = f2;
            this.d = f3;
        }

        public void a(int n2) {
            this.a = n2;
        }

        public void b() {
            long l2 = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int)(l2 - this.e), 0, this.b);
            this.j = this.a(l2);
            this.i = l2;
        }

        public void b(int n2) {
            this.b = n2;
        }

        public boolean c() {
            return this.i > 0L && AnimationUtils.currentAnimationTimeMillis() > this.i + (long)this.k;
        }

        public void d() {
            if (this.f != 0L) {
                long l2 = AnimationUtils.currentAnimationTimeMillis();
                float f2 = this.a(this.a(l2));
                long l3 = this.f;
                this.f = l2;
                f2 = (float)(l2 - l3) * f2;
                this.g = (int)(this.c * f2);
                this.h = (int)(f2 * this.d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int e() {
            return (int)(this.c / Math.abs(this.c));
        }

        public int f() {
            return (int)(this.d / Math.abs(this.d));
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }
    }

    private class b
    implements Runnable {
        b() {
        }

        @Override
        public void run() {
            a a2;
            if (!a.this.e) {
                return;
            }
            if (a.this.c) {
                a.this.c = false;
                a.this.a.a();
            }
            if (!(a2 = a.this.a).c() && a.this.a()) {
                if (a.this.d) {
                    a.this.d = false;
                    a.this.b();
                }
                a2.d();
                int n2 = a2.g();
                int n3 = a2.h();
                a.this.a(n2, n3);
                t.a(a.this.b, this);
                return;
            }
            a.this.e = false;
        }
    }

}

