/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.view.MotionEvent
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.h.t;
import androidx.recyclerview.widget.RecyclerView;

class e
extends RecyclerView.h
implements RecyclerView.m {
    private static final int[] k = new int[]{16842919};
    private static final int[] l = new int[0];
    private int A = 0;
    private final int[] B = new int[2];
    private final int[] C = new int[2];
    private final Runnable D = new Runnable(){

        @Override
        public void run() {
            e.this.b(500);
        }
    };
    private final RecyclerView.n E = new RecyclerView.n(){

        @Override
        public void a(RecyclerView recyclerView, int n2, int n3) {
            e.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };
    final StateListDrawable a;
    final Drawable b;
    int c;
    int d;
    float e;
    int f;
    int g;
    float h;
    final ValueAnimator i = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
    int j = 0;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final StateListDrawable q;
    private final Drawable r;
    private final int s;
    private final int t;
    private int u = 0;
    private int v = 0;
    private RecyclerView w;
    private boolean x = false;
    private boolean y = false;
    private int z = 0;

    e(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable2, StateListDrawable stateListDrawable2, Drawable drawable3, int n2, int n3, int n4) {
        this.a = stateListDrawable;
        this.b = drawable2;
        this.q = stateListDrawable2;
        this.r = drawable3;
        this.o = Math.max(n2, stateListDrawable.getIntrinsicWidth());
        this.p = Math.max(n2, drawable2.getIntrinsicWidth());
        this.s = Math.max(n2, stateListDrawable2.getIntrinsicWidth());
        this.t = Math.max(n2, drawable3.getIntrinsicWidth());
        this.m = n3;
        this.n = n4;
        this.a.setAlpha(255);
        this.b.setAlpha(255);
        this.i.addListener((Animator.AnimatorListener)new a());
        this.i.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b());
        this.a(recyclerView);
    }

    private int a(float f2, float f3, int[] arrn, int n2, int n3, int n4) {
        int n5 = arrn[1] - arrn[0];
        if (n5 == 0) {
            return 0;
        }
        if ((n3 += (n4 = (int)((f2 = (f3 - f2) / (float)n5) * (float)(n2 -= n4)))) < n2 && n3 >= 0) {
            return n4;
        }
        return 0;
    }

    private void a(float f2) {
        int[] arrn = this.g();
        f2 = Math.max((float)arrn[0], Math.min((float)arrn[1], f2));
        if (Math.abs((float)this.d - f2) < 2.0f) {
            return;
        }
        int n2 = this.a(this.e, f2, arrn, this.w.computeVerticalScrollRange(), this.w.computeVerticalScrollOffset(), this.v);
        if (n2 != 0) {
            this.w.scrollBy(0, n2);
        }
        this.e = f2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Canvas canvas) {
        int n2 = this.u - this.o;
        int n3 = this.d - this.c / 2;
        this.a.setBounds(0, 0, this.o, this.c);
        this.b.setBounds(0, 0, this.p, this.v);
        if (this.e()) {
            this.b.draw(canvas);
            canvas.translate((float)this.o, (float)n3);
            canvas.scale(-1.0f, 1.0f);
            this.a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            n2 = this.o;
        } else {
            canvas.translate((float)n2, 0.0f);
            this.b.draw(canvas);
            canvas.translate(0.0f, (float)n3);
            this.a.draw(canvas);
        }
        canvas.translate((float)(-n2), (float)(-n3));
    }

    private void b(float f2) {
        int[] arrn = this.h();
        f2 = Math.max((float)arrn[0], Math.min((float)arrn[1], f2));
        if (Math.abs((float)this.g - f2) < 2.0f) {
            return;
        }
        int n2 = this.a(this.h, f2, arrn, this.w.computeHorizontalScrollRange(), this.w.computeHorizontalScrollOffset(), this.u);
        if (n2 != 0) {
            this.w.scrollBy(n2, 0);
        }
        this.h = f2;
    }

    private void b(Canvas canvas) {
        int n2 = this.v - this.s;
        int n3 = this.g - this.f / 2;
        this.q.setBounds(0, 0, this.f, this.s);
        this.r.setBounds(0, 0, this.u, this.t);
        canvas.translate(0.0f, (float)n2);
        this.r.draw(canvas);
        canvas.translate((float)n3, 0.0f);
        this.q.draw(canvas);
        canvas.translate((float)(-n3), (float)(-n2));
    }

    private void c() {
        this.w.a(this);
        this.w.a(this);
        this.w.a(this.E);
    }

    private void c(int n2) {
        this.f();
        this.w.postDelayed(this.D, (long)n2);
    }

    private void d() {
        this.w.b(this);
        this.w.b(this);
        this.w.b(this.E);
        this.f();
    }

    private boolean e() {
        return t.f((View)this.w) == 1;
    }

    private void f() {
        this.w.removeCallbacks(this.D);
    }

    private int[] g() {
        this.B[0] = this.n;
        this.B[1] = this.v - this.n;
        return this.B;
    }

    private int[] h() {
        this.C[0] = this.n;
        this.C[1] = this.u - this.n;
        return this.C;
    }

    void a() {
        this.w.invalidate();
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(int n2) {
        block8 : {
            int n3;
            block7 : {
                block6 : {
                    if (n2 == 2 && this.z != 2) {
                        this.a.setState(k);
                        this.f();
                    }
                    if (n2 == 0) {
                        this.a();
                    } else {
                        this.b();
                    }
                    if (this.z != 2 || n2 == 2) break block6;
                    this.a.setState(l);
                    n3 = 1200;
                    break block7;
                }
                if (n2 != 1) break block8;
                n3 = 1500;
            }
            this.c(n3);
        }
        this.z = n2;
    }

    void a(int n2, int n3) {
        float f2;
        float f3;
        int n4;
        int n5 = this.w.computeVerticalScrollRange();
        boolean bl2 = n5 - (n4 = this.v) > 0 && this.v >= this.m;
        this.x = bl2;
        int n6 = this.w.computeHorizontalScrollRange();
        int n7 = this.u;
        bl2 = n6 - n7 > 0 && this.u >= this.m;
        this.y = bl2;
        if (!this.x && !this.y) {
            if (this.z != 0) {
                this.a(0);
            }
            return;
        }
        if (this.x) {
            f3 = n3;
            f2 = n4;
            this.d = (int)(f2 * (f3 + f2 / 2.0f) / (float)n5);
            this.c = Math.min(n4, n4 * n4 / n5);
        }
        if (this.y) {
            f3 = n2;
            f2 = n7;
            this.g = (int)(f2 * (f3 + f2 / 2.0f) / (float)n6);
            this.f = Math.min(n7, n7 * n7 / n6);
        }
        if (this.z == 0 || this.z == 1) {
            this.a(1);
        }
    }

    public void a(RecyclerView recyclerView) {
        if (this.w == recyclerView) {
            return;
        }
        if (this.w != null) {
            this.d();
        }
        this.w = recyclerView;
        if (this.w != null) {
            this.c();
        }
    }

    @Override
    public void a(boolean bl2) {
    }

    boolean a(float f2, float f3) {
        return (this.e() ? f2 <= (float)(this.o / 2) : f2 >= (float)(this.u - this.o)) && f3 >= (float)(this.d - this.c / 2) && f3 <= (float)(this.d + this.c / 2);
    }

    @Override
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        boolean bl2;
        block7 : {
            block9 : {
                boolean bl3;
                block6 : {
                    boolean bl4;
                    boolean bl5;
                    block8 : {
                        int n2 = this.z;
                        bl3 = false;
                        if (n2 != 1) break block6;
                        bl5 = this.a(motionEvent.getX(), motionEvent.getY());
                        bl4 = this.b(motionEvent.getX(), motionEvent.getY());
                        bl2 = bl3;
                        if (motionEvent.getAction() != 0) break block7;
                        if (bl5) break block8;
                        bl2 = bl3;
                        if (!bl4) break block7;
                    }
                    if (bl4) {
                        this.A = 1;
                        this.h = (int)motionEvent.getX();
                    } else if (bl5) {
                        this.A = 2;
                        this.e = (int)motionEvent.getY();
                    }
                    this.a(2);
                    break block9;
                }
                bl2 = bl3;
                if (this.z != 2) break block7;
            }
            bl2 = true;
        }
        return bl2;
    }

    public void b() {
        int n2 = this.j;
        if (n2 != 0) {
            if (n2 != 3) {
                return;
            }
            this.i.cancel();
        }
        this.j = 1;
        this.i.setFloatValues(new float[]{((Float)this.i.getAnimatedValue()).floatValue(), 1.0f});
        this.i.setDuration(500L);
        this.i.setStartDelay(0L);
        this.i.start();
    }

    void b(int n2) {
        switch (this.j) {
            default: {
                return;
            }
            case 1: {
                this.i.cancel();
            }
            case 2: 
        }
        this.j = 3;
        this.i.setFloatValues(new float[]{((Float)this.i.getAnimatedValue()).floatValue(), 0.0f});
        this.i.setDuration((long)n2);
        this.i.start();
    }

    @Override
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.u u2) {
        if (this.u == this.w.getWidth() && this.v == this.w.getHeight()) {
            if (this.j != 0) {
                if (this.x) {
                    this.a(canvas);
                }
                if (this.y) {
                    this.b(canvas);
                }
            }
            return;
        }
        this.u = this.w.getWidth();
        this.v = this.w.getHeight();
        this.a(0);
    }

    @Override
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.z == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean bl2 = this.a(motionEvent.getX(), motionEvent.getY());
            boolean bl3 = this.b(motionEvent.getX(), motionEvent.getY());
            if (bl2 || bl3) {
                if (bl3) {
                    this.A = 1;
                    this.h = (int)motionEvent.getX();
                } else if (bl2) {
                    this.A = 2;
                    this.e = (int)motionEvent.getY();
                }
                this.a(2);
                return;
            }
        } else {
            if (motionEvent.getAction() == 1 && this.z == 2) {
                this.e = 0.0f;
                this.h = 0.0f;
                this.a(1);
                this.A = 0;
                return;
            }
            if (motionEvent.getAction() == 2 && this.z == 2) {
                this.b();
                if (this.A == 1) {
                    this.b(motionEvent.getX());
                }
                if (this.A == 2) {
                    this.a(motionEvent.getY());
                }
            }
        }
    }

    boolean b(float f2, float f3) {
        return f3 >= (float)(this.v - this.s) && f2 >= (float)(this.g - this.f / 2) && f2 <= (float)(this.g + this.f / 2);
    }

    private class a
    extends AnimatorListenerAdapter {
        private boolean b = false;

        a() {
        }

        public void onAnimationCancel(Animator animator) {
            this.b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.b) {
                this.b = false;
                return;
            }
            if (((Float)e.this.i.getAnimatedValue()).floatValue() == 0.0f) {
                e.this.j = 0;
                e.this.a(0);
                return;
            }
            e.this.j = 2;
            e.this.a();
        }
    }

    private class b
    implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int n2 = (int)(((Float)valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            e.this.a.setAlpha(n2);
            e.this.b.setAlpha(n2);
            e.this.a();
        }
    }

}

