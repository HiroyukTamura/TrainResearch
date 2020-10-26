/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.a.i;
import com.google.android.material.internal.h;
import java.util.ArrayList;
import java.util.Iterator;

class a {
    static final TimeInterpolator a = com.google.android.material.a.a.c;
    static final int[] p = new int[]{16842919, 16842910};
    static final int[] q = new int[]{16843623, 16842908, 16842910};
    static final int[] r = new int[]{16842908, 16842910};
    static final int[] s = new int[]{16843623, 16842910};
    static final int[] t = new int[]{16842910};
    static final int[] u = new int[0];
    private float A;
    private ArrayList<Animator.AnimatorListener> B;
    private ArrayList<Animator.AnimatorListener> C;
    private ArrayList<d> D;
    private final Rect E = new Rect();
    private final RectF F = new RectF();
    private final RectF G = new RectF();
    private final Matrix H = new Matrix();
    private ViewTreeObserver.OnPreDrawListener I;
    int b = 0;
    Animator c;
    com.google.android.material.a.h d;
    com.google.android.material.a.h e;
    com.google.android.material.k.a f;
    Drawable g;
    Drawable h;
    com.google.android.material.internal.a i;
    Drawable j;
    float k;
    float l;
    float m;
    int n;
    float o = 1.0f;
    final h v;
    final com.google.android.material.k.c w;
    private com.google.android.material.a.h x;
    private com.google.android.material.a.h y;
    private final com.google.android.material.internal.e z;

    a(h h2, com.google.android.material.k.c c2) {
        this.v = h2;
        this.w = c2;
        this.z = new com.google.android.material.internal.e();
        this.z.a(p, this.a(new c()));
        this.z.a(q, this.a(new b()));
        this.z.a(r, this.a(new b()));
        this.z.a(s, this.a(new b()));
        this.z.a(t, this.a(new f()));
        this.z.a(u, this.a(new a()));
        this.A = this.v.getRotation();
    }

    private AnimatorSet a(com.google.android.material.a.h h2, float f2, float f3, float f4) {
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this.v), (Property)View.ALPHA, (float[])new float[]{f2});
        h2.b("opacity").a((Animator)objectAnimator);
        arrayList.add((Animator)objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this.v), (Property)View.SCALE_X, (float[])new float[]{f3});
        h2.b("scale").a((Animator)objectAnimator);
        arrayList.add((Animator)objectAnimator);
        objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this.v), (Property)View.SCALE_Y, (float[])new float[]{f3});
        h2.b("scale").a((Animator)objectAnimator);
        arrayList.add((Animator)objectAnimator);
        this.a(f4, this.H);
        objectAnimator = ObjectAnimator.ofObject((Object)((Object)this.v), (Property)new com.google.android.material.a.f(), (TypeEvaluator)new com.google.android.material.a.g(){

            @Override
            public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
                a.this.o = f2;
                return super.a(f2, matrix, matrix2);
            }

            @Override
            public /* synthetic */ Object evaluate(float f2, Object object, Object object2) {
                return this.a(f2, (Matrix)object, (Matrix)object2);
            }
        }, (Object[])new Matrix[]{new Matrix(this.H)});
        h2.b("iconScale").a((Animator)objectAnimator);
        arrayList.add((Animator)objectAnimator);
        h2 = new AnimatorSet();
        com.google.android.material.a.b.a((AnimatorSet)h2, arrayList);
        return h2;
    }

    private ValueAnimator a(g g2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener((Animator.AnimatorListener)g2);
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)g2);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable2 = this.v.getDrawable();
        if (drawable2 != null && this.n != 0) {
            RectF rectF = this.F;
            RectF rectF2 = this.G;
            rectF.set(0.0f, 0.0f, (float)drawable2.getIntrinsicWidth(), (float)drawable2.getIntrinsicHeight());
            rectF2.set(0.0f, 0.0f, (float)this.n, (float)this.n);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            matrix.postScale(f2, f2, (float)this.n / 2.0f, (float)this.n / 2.0f);
        }
    }

    private com.google.android.material.a.h s() {
        if (this.x == null) {
            this.x = com.google.android.material.a.h.a(this.v.getContext(), a.a.design_fab_show_motion_spec);
        }
        return this.x;
    }

    private com.google.android.material.a.h t() {
        if (this.y == null) {
            this.y = com.google.android.material.a.h.a(this.v.getContext(), a.a.design_fab_hide_motion_spec);
        }
        return this.y;
    }

    private void u() {
        if (this.I == null) {
            this.I = new ViewTreeObserver.OnPreDrawListener(){

                public boolean onPreDraw() {
                    a.this.p();
                    return true;
                }
            };
        }
    }

    private boolean v() {
        return t.y((View)this.v) && !this.v.isInEditMode();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void w() {
        block5 : {
            int n2;
            h h2;
            block7 : {
                block6 : {
                    if (Build.VERSION.SDK_INT != 19) break block5;
                    if (this.A % 90.0f == 0.0f) break block6;
                    int n3 = this.v.getLayerType();
                    n2 = 1;
                    if (n3 == 1) break block5;
                    h2 = this.v;
                    break block7;
                }
                if (this.v.getLayerType() == 0) break block5;
                h2 = this.v;
                n2 = 0;
            }
            h2.setLayerType(n2, null);
        }
        if (this.f != null) {
            this.f.b(-this.A);
        }
        if (this.i != null) {
            this.i.a(-this.A);
        }
    }

    float a() {
        return this.k;
    }

    final void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            this.a(this.k, this.l, this.m);
        }
    }

    void a(float f2, float f3, float f4) {
        if (this.f != null) {
            this.f.a(f2, this.m + f2);
            this.l();
        }
    }

    void a(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.add(animatorListener);
    }

    void a(ColorStateList colorStateList) {
        if (this.g != null) {
            androidx.core.graphics.drawable.a.a(this.g, colorStateList);
        }
        if (this.i != null) {
            this.i.a(colorStateList);
        }
    }

    void a(PorterDuff.Mode mode) {
        if (this.g != null) {
            androidx.core.graphics.drawable.a.a(this.g, mode);
        }
    }

    void a(Rect rect) {
        this.f.getPadding(rect);
    }

    final void a(com.google.android.material.a.h h2) {
        this.d = h2;
    }

    void a(d d2) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(d2);
    }

    void a(e object, final boolean bl2) {
        if (this.r()) {
            return;
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.v()) {
            com.google.android.material.a.h h2 = this.e != null ? this.e : this.t();
            h2 = this.a(h2, 0.0f, 0.0f, 0.0f);
            h2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter((e)object){
                final /* synthetic */ e b;
                private boolean d;
                {
                    this.b = e2;
                }

                public void onAnimationCancel(Animator animator) {
                    this.d = true;
                }

                public void onAnimationEnd(Animator object) {
                    a.this.b = 0;
                    a.this.c = null;
                    if (!this.d) {
                        object = a.this.v;
                        int n2 = bl2 ? 8 : 4;
                        ((h)((Object)object)).a(n2, bl2);
                        if (this.b != null) {
                            this.b.b();
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    a.this.v.a(0, bl2);
                    a.this.b = 1;
                    a.this.c = animator;
                    this.d = false;
                }
            });
            if (this.C != null) {
                object = this.C.iterator();
                while (object.hasNext()) {
                    h2.addListener((Animator.AnimatorListener)object.next());
                }
            }
            h2.start();
            return;
        }
        h h3 = this.v;
        int n2 = bl2 ? 8 : 4;
        h3.a(n2, bl2);
        if (object != null) {
            object.b();
        }
    }

    void a(int[] arrn) {
        this.z.a(arrn);
    }

    float b() {
        return this.l;
    }

    final void b(float f2) {
        if (this.l != f2) {
            this.l = f2;
            this.a(this.k, this.l, this.m);
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(animatorListener);
    }

    void b(ColorStateList colorStateList) {
        if (this.h != null) {
            androidx.core.graphics.drawable.a.a(this.h, com.google.android.material.j.a.a(colorStateList));
        }
    }

    void b(Rect rect) {
    }

    final void b(com.google.android.material.a.h h2) {
        this.e = h2;
    }

    void b(e object, final boolean bl2) {
        if (this.q()) {
            return;
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.v()) {
            if (this.v.getVisibility() != 0) {
                this.v.setAlpha(0.0f);
                this.v.setScaleY(0.0f);
                this.v.setScaleX(0.0f);
                this.d(0.0f);
            }
            com.google.android.material.a.h h2 = this.d != null ? this.d : this.s();
            h2 = this.a(h2, 1.0f, 1.0f, 1.0f);
            h2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter((e)object){
                final /* synthetic */ e b;
                {
                    this.b = e2;
                }

                public void onAnimationEnd(Animator animator) {
                    a.this.b = 0;
                    a.this.c = null;
                    if (this.b != null) {
                        this.b.a();
                    }
                }

                public void onAnimationStart(Animator animator) {
                    a.this.v.a(0, bl2);
                    a.this.b = 2;
                    a.this.c = animator;
                }
            });
            if (this.B != null) {
                object = this.B.iterator();
                while (object.hasNext()) {
                    h2.addListener((Animator.AnimatorListener)object.next());
                }
            }
            h2.start();
            return;
        }
        this.v.a(0, bl2);
        this.v.setAlpha(1.0f);
        this.v.setScaleY(1.0f);
        this.v.setScaleX(1.0f);
        this.d(1.0f);
        if (object != null) {
            object.a();
        }
    }

    float c() {
        return this.m;
    }

    final void c(float f2) {
        if (this.m != f2) {
            this.m = f2;
            this.a(this.k, this.l, this.m);
        }
    }

    final void d() {
        this.d(this.o);
    }

    final void d(float f2) {
        this.o = f2;
        Matrix matrix = this.H;
        this.a(f2, matrix);
        this.v.setImageMatrix(matrix);
    }

    final com.google.android.material.a.h e() {
        return this.d;
    }

    final com.google.android.material.a.h f() {
        return this.e;
    }

    void g() {
        this.z.a();
    }

    void h() {
        if (this.D != null) {
            Iterator<d> iterator = this.D.iterator();
            while (iterator.hasNext()) {
                iterator.next().a();
            }
        }
    }

    void i() {
        if (this.D != null) {
            Iterator<d> iterator = this.D.iterator();
            while (iterator.hasNext()) {
                iterator.next().b();
            }
        }
    }

    final Drawable j() {
        return this.j;
    }

    void k() {
    }

    final void l() {
        Rect rect = this.E;
        this.a(rect);
        this.b(rect);
        this.w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m() {
        if (this.o()) {
            this.u();
            this.v.getViewTreeObserver().addOnPreDrawListener(this.I);
        }
    }

    void n() {
        if (this.I != null) {
            this.v.getViewTreeObserver().removeOnPreDrawListener(this.I);
            this.I = null;
        }
    }

    boolean o() {
        return true;
    }

    void p() {
        float f2 = this.v.getRotation();
        if (this.A != f2) {
            this.A = f2;
            this.w();
        }
    }

    boolean q() {
        int n2 = this.v.getVisibility();
        boolean bl2 = false;
        boolean bl3 = false;
        if (n2 != 0) {
            if (this.b == 2) {
                bl3 = true;
            }
            return bl3;
        }
        bl3 = bl2;
        if (this.b != 1) {
            bl3 = true;
        }
        return bl3;
    }

    boolean r() {
        int n2 = this.v.getVisibility();
        boolean bl2 = false;
        boolean bl3 = false;
        if (n2 == 0) {
            if (this.b == 1) {
                bl3 = true;
            }
            return bl3;
        }
        bl3 = bl2;
        if (this.b != 2) {
            bl3 = true;
        }
        return bl3;
    }

    private class a
    extends g {
        a() {
            super();
        }

        @Override
        protected float a() {
            return 0.0f;
        }
    }

    private class b
    extends g {
        b() {
            super();
        }

        @Override
        protected float a() {
            return a.this.k + a.this.l;
        }
    }

    private class c
    extends g {
        c() {
            super();
        }

        @Override
        protected float a() {
            return a.this.k + a.this.m;
        }
    }

    static interface d {
        public void a();

        public void b();
    }

    static interface e {
        public void a();

        public void b();
    }

    private class f
    extends g {
        f() {
            super();
        }

        @Override
        protected float a() {
            return a.this.k;
        }
    }

    private abstract class g
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float c;
        private float d;

        private g() {
        }

        protected abstract float a();

        public void onAnimationEnd(Animator animator) {
            a.this.f.a(this.d);
            this.a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                this.c = a.this.f.b();
                this.d = this.a();
                this.a = true;
            }
            a.this.f.a(this.c + (this.d - this.c) * valueAnimator.getAnimatedFraction());
        }
    }

}

