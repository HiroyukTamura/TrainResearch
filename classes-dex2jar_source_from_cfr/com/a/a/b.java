/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Interpolator
 */
package com.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.h.i;
import androidx.core.h.s;
import androidx.core.h.t;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.a.a.c;
import com.a.a.d;
import java.util.ArrayList;
import java.util.List;

public class b
extends RecyclerView.h
implements RecyclerView.k {
    private int A = -1;
    private androidx.core.h.c B;
    private final RecyclerView.m C = new RecyclerView.m(){
        boolean a = false;
        float b = 0.0f;

        @Override
        public void a(boolean bl2) {
            if (!bl2) {
                return;
            }
            b.this.a(null, 0);
        }

        @Override
        public boolean a(RecyclerView object, MotionEvent motionEvent) {
            b.this.B.a(motionEvent);
            int n2 = i.a(motionEvent);
            boolean bl2 = false;
            if (n2 == 0) {
                b.this.l = i.b(motionEvent, 0);
                b.this.d = motionEvent.getX();
                b.this.e = motionEvent.getY();
                this.a = true;
                this.b = motionEvent.getX();
                b.this.i();
                if (b.this.b == null && (object = b.this.c(motionEvent)) != null) {
                    b b2 = b.this;
                    b2.d -= ((c)object).k;
                    b2 = b.this;
                    b2.e -= ((c)object).l;
                    b.this.a(((c)object).h, true);
                    if (b.this.a.remove((Object)object.h.a)) {
                        b.this.m.c(b.this.t, ((c)object).h);
                    }
                    b.this.a(((c)object).h, ((c)object).i);
                    b.this.a(motionEvent, b.this.o, 0);
                }
            } else if (n2 != 3 && n2 != 1) {
                int n3;
                if (b.this.l != -1 && (n3 = i.a(motionEvent, b.this.l)) >= 0) {
                    b.this.a(n2, motionEvent, n3);
                }
            } else {
                b.this.l = -1;
                if (this.a && n2 == 1) {
                    b.this.a(motionEvent.getRawX(), motionEvent.getRawY());
                }
                b.this.a(null, 0);
            }
            if (b.this.v != null) {
                b.this.v.addMovement(motionEvent);
            }
            if (b.this.b != null) {
                bl2 = true;
            }
            return bl2;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public void b(RecyclerView object, MotionEvent motionEvent) {
            b.this.B.a(motionEvent);
            if (b.this.v != null) {
                b.this.v.addMovement(motionEvent);
            }
            if (b.this.l == -1) {
                return;
            }
            int n2 = i.a(motionEvent);
            int n3 = i.a(motionEvent, b.this.l);
            if (n3 >= 0) {
                b.this.a(n2, motionEvent, n3);
            }
            if ((object = b.this.b) == null) {
                return;
            }
            int n4 = 0;
            if (n2 != 6) {
                switch (n2) {
                    default: {
                        this.a = false;
                        return;
                    }
                    case 3: {
                        if (b.this.v == null) break;
                        b.this.v.clear();
                        break;
                    }
                    case 2: {
                        if (n3 < 0) return;
                        b.this.a(motionEvent, b.this.o, n3);
                        if (Math.abs(motionEvent.getX() - this.b) > (float)b.this.s) {
                            this.a = false;
                        }
                        this.b = motionEvent.getX();
                        b.this.b((RecyclerView.x)object);
                        b.this.t.removeCallbacks(b.this.u);
                        b.this.u.run();
                        b.this.t.invalidate();
                        return;
                    }
                    case 1: 
                }
                if (this.a) {
                    b.this.a(motionEvent.getRawX(), motionEvent.getRawY());
                }
                this.a = false;
                b.this.a(null, 0);
                b.this.l = -1;
                return;
            }
            this.a = false;
            n2 = i.b(motionEvent);
            if (i.b(motionEvent, n2) != b.this.l) return;
            if (n2 == 0) {
                n4 = 1;
            }
            b.this.l = i.b(motionEvent, n4);
            b.this.a(motionEvent, b.this.o, n2);
        }
    };
    private Rect D;
    private long E;
    final List<View> a = new ArrayList<View>();
    RecyclerView.x b = null;
    RecyclerView.x c = null;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    int l = -1;
    a m;
    int n = 0;
    int o;
    List<c> p = new ArrayList<c>();
    private boolean q = true;
    private final float[] r = new float[2];
    private int s;
    private RecyclerView t;
    private final Runnable u = new Runnable(){

        @Override
        public void run() {
            if (b.this.b != null && b.this.h()) {
                if (b.this.b != null) {
                    b.this.b(b.this.b);
                }
                b.this.t.removeCallbacks(b.this.u);
                t.a((View)b.this.t, this);
            }
        }
    };
    private VelocityTracker v;
    private List<RecyclerView.x> w;
    private List<Integer> x;
    private RecyclerView.d y = null;
    private View z = null;

    public b(a a2) {
        this.m = a2;
    }

    private int a(RecyclerView.x x2, boolean bl2) {
        for (int i2 = this.p.size() - 1; i2 >= 0; --i2) {
            c c2 = this.p.get(i2);
            if (c2.h != x2) continue;
            c2.m |= bl2;
            if (!c2.c) {
                c2.b();
            }
            this.p.remove(i2);
            return c2.b;
        }
        return 0;
    }

    private View a(ViewGroup viewGroup, float f2, float f3) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
            View view = viewGroup.getChildAt(i2);
            if (!(view instanceof ViewGroup && view.getVisibility() == 0 ? (view = this.a((ViewGroup)view, f2, f3)) != null : this.a((int)f2, (int)f3, view))) continue;
            return view;
        }
        if (this.a((int)f2, (int)f3, (View)viewGroup)) {
            return viewGroup;
        }
        return null;
    }

    private RecyclerView.x a(MotionEvent motionEvent) {
        RecyclerView.i i2 = this.t.getLayoutManager();
        if (this.l == -1) {
            return null;
        }
        int n2 = i.a(motionEvent, this.l);
        float f2 = i.c(motionEvent, n2);
        float f3 = this.d;
        float f4 = i.d(motionEvent, n2);
        float f5 = this.e;
        f2 = Math.abs(f2 - f3);
        f4 = Math.abs(f4 - f5);
        if (f2 < (float)this.s && f4 < (float)this.s) {
            return null;
        }
        if (f2 > f4 && i2.e()) {
            return null;
        }
        if (f4 > f2 && i2.f()) {
            return null;
        }
        if ((motionEvent = this.b(motionEvent)) == null) {
            return null;
        }
        return this.t.b((View)motionEvent);
    }

    private List<RecyclerView.x> a(RecyclerView.x x2) {
        Object object = x2;
        if (this.w == null) {
            this.w = new ArrayList<RecyclerView.x>();
            this.x = new ArrayList<Integer>();
        } else {
            this.w.clear();
            this.x.clear();
        }
        int n2 = this.m.c();
        int n3 = Math.round(this.j + this.h) - n2;
        int n4 = Math.round(this.k + this.i) - n2;
        int n5 = ((RecyclerView.x)object).a.getWidth();
        int n6 = n5 + n3 + (n2 *= 2);
        int n7 = ((RecyclerView.x)object).a.getHeight() + n4 + n2;
        int n8 = (n3 + n6) / 2;
        int n9 = (n4 + n7) / 2;
        object = this.t.getLayoutManager();
        int n10 = ((RecyclerView.i)object).v();
        for (n5 = 0; n5 < n10; ++n5) {
            RecyclerView.x x3;
            View view = ((RecyclerView.i)object).i(n5);
            if (view == x2.a || view.getBottom() < n4 || view.getTop() > n7 || view.getRight() < n3 || view.getLeft() > n6 || !this.m.a(this.t, this.b, x3 = this.t.b(view))) continue;
            n2 = Math.abs(n8 - (view.getLeft() + view.getRight()) / 2);
            int n11 = Math.abs(n9 - (view.getTop() + view.getBottom()) / 2);
            int n12 = n2 * n2 + n11 * n11;
            int n13 = this.w.size();
            n11 = 0;
            for (n2 = 0; n2 < n13 && n12 > this.x.get(n2); ++n2) {
                ++n11;
            }
            this.w.add(n11, x3);
            this.x.add(n11, n12);
        }
        return this.w;
    }

    private void a(float f2, float f3) {
        View view;
        if (this.b == null) {
            return;
        }
        View view2 = view = this.b.a;
        if (view instanceof ViewGroup) {
            view2 = this.a((ViewGroup)view, f2, f3);
        }
        if (view2 != null) {
            view2.performClick();
        }
    }

    private void a(MotionEvent motionEvent, int n2, int n3) {
        float f2 = motionEvent.getX(n3);
        float f3 = motionEvent.getY(n3);
        this.h = f2 - this.d;
        this.i = f3 - this.e;
        if ((n2 & 4) == 0) {
            this.h = Math.max(0.0f, this.h);
        }
        if ((n2 & 8) == 0) {
            this.h = Math.min(0.0f, this.h);
        }
        if ((n2 & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((n2 & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(RecyclerView.x var1_1, int var2_2) {
        block16 : {
            block10 : {
                block15 : {
                    block11 : {
                        block14 : {
                            block13 : {
                                block12 : {
                                    if (var1_1 == this.b && var2_2 == this.n) {
                                        return;
                                    }
                                    this.E = Long.MIN_VALUE;
                                    var9_3 = this.n;
                                    this.a(var1_1, true);
                                    this.n = var2_2;
                                    if (var2_2 == 2) {
                                        this.z = var1_1.a;
                                        this.k();
                                    }
                                    if (this.b == null) break block10;
                                    var11_4 = this.b;
                                    if (var11_4.a.getParent() == null) break block11;
                                    var8_5 = var9_3 == 2 ? 0 : this.c((RecyclerView.x)var11_4);
                                    this.j();
                                    if (var8_5 == 4 || var8_5 == 8 || var8_5 == 16 || var8_5 == 32) break block12;
                                    switch (var8_5) {
                                        default: {
                                            var3_6 = 0.0f;
                                            break block13;
                                        }
                                        case 1: 
                                        case 2: {
                                            var4_7 = Math.signum(this.i) * (float)this.t.getHeight();
                                            var3_6 = 0.0f;
                                            break;
                                        }
                                    }
                                    break block14;
                                }
                                var3_6 = Math.signum(this.h) * this.f();
                            }
                            var4_7 = 0.0f;
                            ** break;
                        }
                        var7_8 = var9_3 == 2 ? 8 : (var8_5 > 0 ? 2 : 4);
                        this.a(this.r);
                        var5_9 = this.r[0];
                        var6_10 = this.r[1];
                        var11_4 = new c((RecyclerView.x)var11_4, var7_8, var9_3, var5_9, var6_10, var3_6, var4_7, (RecyclerView.x)var11_4){
                            final /* synthetic */ RecyclerView.x b;
                            {
                                this.b = x3;
                                super(x2, n2, n3, f2, f3, f4, f5);
                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.m) {
                                    return;
                                }
                                if (var8_5 <= 0) {
                                    b.this.m.c(b.this.t, this.b);
                                } else {
                                    b.this.a.add(this.b.a);
                                    b.this.c = this.b;
                                    this.j = true;
                                    if (var8_5 > 0) {
                                        b.this.a(this, var8_5);
                                    }
                                }
                                if (b.this.z == this.b.a) {
                                    b.this.c(this.b.a);
                                }
                            }
                        };
                        var11_4.a(this.m.a(this.t, var7_8, var3_6 - var5_9, var4_7 - var6_10));
                        this.p.add((c)var11_4);
                        var11_4.a();
                        var7_8 = 1;
                        break block15;
                    }
                    this.c(var11_4.a);
                    this.m.c(this.t, (RecyclerView.x)var11_4);
                    var7_8 = 0;
                }
                this.b = null;
                break block16;
            }
            var7_8 = 0;
        }
        if (var1_1 != null) {
            this.o = (this.m.b(this.t, var1_1) & (1 << var2_2 * 8 + 8) - 1) >> this.n * 8;
            this.j = var1_1.a.getLeft();
            this.k = var1_1.a.getTop();
            this.b = var1_1;
            if (var2_2 == 2) {
                this.b.a.performHapticFeedback(0);
            }
        }
        var10_11 = false;
        var1_1 = this.t.getParent();
        if (var1_1 != null) {
            if (this.b != null) {
                var10_11 = true;
            }
            var1_1.requestDisallowInterceptTouchEvent(var10_11);
        }
        if (var7_8 == 0) {
            this.t.getLayoutManager().I();
        }
        this.m.b(this.b, this.n);
        this.t.invalidate();
    }

    private void a(final c c2, final int n2) {
        this.t.post(new Runnable(){

            @Override
            public void run() {
                if (b.this.t != null && b.this.t.isAttachedToWindow() && !c2.m && c2.h.e() != -1) {
                    RecyclerView.f f2 = b.this.t.getItemAnimator();
                    if (!(f2 != null && f2.a((RecyclerView.f.a)null) || b.this.g())) {
                        b.this.m.a(c2.h, n2);
                        return;
                    }
                    b.this.t.post((Runnable)this);
                }
            }
        });
    }

    private void a(float[] arrf) {
        arrf[0] = (this.o & 12) != 0 ? this.j + this.h - (float)this.b.a.getLeft() : t.i(this.b.a);
        if ((this.o & 3) != 0) {
            arrf[1] = this.k + this.i - (float)this.b.a.getTop();
            return;
        }
        arrf[1] = t.j(this.b.a);
    }

    private boolean a(int n2, int n3, View view) {
        int[] arrn = new int[2];
        view.getLocationOnScreen(arrn);
        return new Rect(arrn[0], arrn[1], arrn[0] + view.getWidth(), arrn[1] + view.getHeight()).contains(n2, n3) && t.C(view) && view.getVisibility() == 0;
    }

    private boolean a(int n2, MotionEvent motionEvent, int n3) {
        if (this.b == null && n2 == 2 && this.n != 2) {
            if (!this.m.b()) {
                return false;
            }
            if (this.t.getScrollState() == 1) {
                return false;
            }
            RecyclerView.x x2 = this.a(motionEvent);
            if (x2 == null) {
                return false;
            }
            n2 = (this.m.b(this.t, x2) & 65280) >> 8;
            if (n2 == 0) {
                return false;
            }
            float f2 = i.c(motionEvent, n3);
            float f3 = i.d(motionEvent, n3);
            float f4 = Math.abs(f2 -= this.d);
            float f5 = Math.abs(f3 -= this.e);
            if (f4 < (float)this.s && f5 < (float)this.s) {
                return false;
            }
            if (f4 > f5) {
                if (f2 < 0.0f && (n2 & 4) == 0) {
                    return false;
                }
                if (f2 > 0.0f && (n2 & 8) == 0) {
                    return false;
                }
            } else {
                if (f3 < 0.0f && (n2 & 1) == 0) {
                    return false;
                }
                if (f3 > 0.0f && (n2 & 2) == 0) {
                    return false;
                }
            }
            this.i = 0.0f;
            this.h = 0.0f;
            this.l = i.b(motionEvent, 0);
            this.a(x2, 1);
            if (this.c != null && this.c != x2 && x2 != null) {
                this.b();
            }
            return true;
        }
        return false;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + (float)view.getWidth() && f3 >= f5 && f3 <= f5 + (float)view.getHeight();
    }

    private int b(RecyclerView.x x2, int n2) {
        if ((n2 & 12) != 0) {
            float f2;
            float f3 = this.h;
            int n3 = 4;
            int n4 = f3 > 0.0f ? 8 : 4;
            if (this.v != null && this.l > -1) {
                this.v.computeCurrentVelocity(1000, this.m.b(this.g));
                f2 = s.a(this.v, this.l);
                f3 = s.b(this.v, this.l);
                if (f2 > 0.0f) {
                    n3 = 8;
                }
                f2 = Math.abs(f2);
                if ((n3 & n2) != 0 && n4 == n3 && f2 >= this.m.a(this.f) && f2 > Math.abs(f3)) {
                    return n3;
                }
            }
            f3 = this.f();
            f2 = this.m.a(x2);
            if ((n2 & n4) != 0 && Math.abs(this.h) > f3 * f2) {
                return n4;
            }
        }
        return 0;
    }

    private View b(MotionEvent object) {
        float f2 = object.getX();
        float f3 = object.getY();
        if (this.b != null && b.a((View)(object = this.b.a), f2, f3, this.j + this.h, this.k + this.i)) {
            return object;
        }
        for (int i2 = this.p.size() - 1; i2 >= 0; --i2) {
            View view = object.h.a;
            object = this.p.get(i2);
            if (!b.a(view, f2, f3, ((c)object).d(), ((c)object).e())) continue;
            return view;
        }
        return this.t.a(f2, f3);
    }

    private void b() {
        View view = this.m.c(this.c);
        if (this.c != null) {
            if (view == null) {
                return;
            }
            view = ObjectAnimator.ofFloat((Object)view, (String)"translationX", (float[])new float[]{view.getTranslationX(), 0.0f});
            view.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    b.this.p.clear();
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (b.this.c != null) {
                        b.this.m.c(b.this.t, b.this.c);
                    }
                    if (b.this.c != null) {
                        b.this.a.remove((Object)b.this.c.a);
                    }
                    b.this.a(b.this.c, true);
                    b.this.c = b.this.b;
                }
            });
            view.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
            view.start();
        }
    }

    private void b(RecyclerView.x x2) {
        if (this.t.isLayoutRequested()) {
            return;
        }
        if (this.n != 2) {
            return;
        }
        float f2 = this.m.b(x2);
        int n2 = (int)(this.j + this.h);
        int n3 = (int)(this.k + this.i);
        if ((float)Math.abs(n3 - x2.a.getTop()) < (float)x2.a.getHeight() * f2 && (float)Math.abs(n2 - x2.a.getLeft()) < (float)x2.a.getWidth() * f2) {
            return;
        }
        List<RecyclerView.x> list = this.a(x2);
        if (list.size() == 0) {
            return;
        }
        if ((list = this.m.a(x2, list, n2, n3)) == null) {
            this.w.clear();
            this.x.clear();
            return;
        }
        int n4 = ((RecyclerView.x)((Object)list)).e();
        int n5 = x2.e();
        if (this.m.b(this.t, x2, (RecyclerView.x)((Object)list))) {
            this.m.a(this.t, x2, n5, (RecyclerView.x)((Object)list), n4, n2, n3);
        }
    }

    private int c(RecyclerView.x x2) {
        if (this.n == 2) {
            return 0;
        }
        int n2 = this.m.a(this.t, x2);
        int n3 = (this.m.d(n2, t.f((View)this.t)) & 65280) >> 8;
        if (n3 == 0) {
            return 0;
        }
        int n4 = (n2 & 65280) >> 8;
        if (Math.abs(this.h) > Math.abs(this.i)) {
            n2 = this.b(x2, n3);
            if (n2 > 0) {
                if ((n4 & n2) == 0) {
                    return a.a(n2, t.f((View)this.t));
                }
                return n2;
            }
            if ((n3 = this.c(x2, n3)) > 0) {
                return n3;
            }
        } else {
            n2 = this.c(x2, n3);
            if (n2 > 0) {
                return n2;
            }
            n2 = this.b(x2, n3);
            if (n2 > 0) {
                n3 = n2;
                if ((n4 & n2) == 0) {
                    n3 = a.a(n2, t.f((View)this.t));
                }
                return n3;
            }
        }
        return 0;
    }

    private int c(RecyclerView.x x2, int n2) {
        if ((n2 & 3) != 0) {
            float f2;
            float f3 = this.i;
            int n3 = 1;
            int n4 = f3 > 0.0f ? 2 : 1;
            if (this.v != null && this.l > -1) {
                this.v.computeCurrentVelocity(1000, this.m.b(this.g));
                f3 = s.a(this.v, this.l);
                f2 = s.b(this.v, this.l);
                if (f2 > 0.0f) {
                    n3 = 2;
                }
                f2 = Math.abs(f2);
                if ((n3 & n2) != 0 && n3 == n4 && f2 >= this.m.a(this.f) && f2 > Math.abs(f3)) {
                    return n3;
                }
            }
            f3 = this.t.getHeight();
            f2 = this.m.a(x2);
            if ((n2 & n4) != 0 && Math.abs(this.i) > f3 * f2) {
                return n4;
            }
        }
        return 0;
    }

    private c c(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        motionEvent = this.b(motionEvent);
        for (int i2 = this.p.size() - 1; i2 >= 0; --i2) {
            c c2 = this.p.get(i2);
            if (c2.h.a != motionEvent) continue;
            return c2;
        }
        return null;
    }

    private void c() {
        this.s = ViewConfiguration.get((Context)this.t.getContext()).getScaledTouchSlop();
        this.t.a(this);
        this.t.a(this.C);
        this.t.a(this);
        this.e();
    }

    private void c(View view) {
        if (view == this.z) {
            this.z = null;
            if (this.y != null) {
                this.t.setChildDrawingOrderCallback(null);
            }
        }
    }

    private void d() {
        this.t.b(this);
        this.t.b(this.C);
        this.t.b(this);
        for (int i2 = this.p.size() - 1; i2 >= 0; --i2) {
            c c2 = this.p.get(0);
            this.m.c(this.t, c2.h);
        }
        this.p.clear();
        this.z = null;
        this.A = -1;
        this.j();
    }

    private void e() {
        if (this.B != null) {
            return;
        }
        this.B = new androidx.core.h.c(this.t.getContext(), (GestureDetector.OnGestureListener)new b());
    }

    private float f() {
        if (this.b instanceof com.a.a.a) {
            return ((com.a.a.a)((Object)this.b)).a();
        }
        return this.t.getWidth();
    }

    private boolean g() {
        int n2 = this.p.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.p.get(i2).c) continue;
            return true;
        }
        return false;
    }

    private boolean h() {
        long l2;
        int n2;
        int n3;
        int n4;
        long l3;
        block15 : {
            block14 : {
                RecyclerView.i i2;
                block13 : {
                    block12 : {
                        if (this.b == null) {
                            this.E = Long.MIN_VALUE;
                            return false;
                        }
                        l3 = System.currentTimeMillis();
                        l2 = this.E == Long.MIN_VALUE ? 0L : l3 - this.E;
                        i2 = this.t.getLayoutManager();
                        if (this.D == null) {
                            this.D = new Rect();
                        }
                        i2.b(this.b.a, this.D);
                        if (!i2.e()) break block12;
                        n3 = (int)(this.j + this.h);
                        n4 = n3 - this.D.left - this.t.getPaddingLeft();
                        if (this.h < 0.0f && n4 < 0 || this.h > 0.0f && (n4 = n3 + this.b.a.getWidth() + this.D.right - (this.t.getWidth() - this.t.getPaddingRight())) > 0) break block13;
                    }
                    n4 = 0;
                }
                if (!i2.f()) break block14;
                n2 = (int)(this.k + this.i);
                n3 = n2 - this.D.top - this.t.getPaddingTop();
                if (this.i < 0.0f && n3 < 0 || this.i > 0.0f && (n3 = n2 + this.b.a.getHeight() + this.D.bottom - (this.t.getHeight() - this.t.getPaddingBottom())) > 0) break block15;
            }
            n3 = 0;
        }
        n2 = n4;
        if (n4 != 0) {
            n2 = this.m.a(this.t, this.b.a.getWidth(), n4, this.t.getWidth(), l2);
        }
        if (n3 != 0) {
            n3 = this.m.a(this.t, this.b.a.getHeight(), n3, this.t.getHeight(), l2);
        }
        if (n2 == 0 && n3 == 0) {
            this.E = Long.MIN_VALUE;
            return false;
        }
        if (this.E == Long.MIN_VALUE) {
            this.E = l3;
        }
        this.t.scrollBy(n2, n3);
        return true;
    }

    private void i() {
        if (this.v != null) {
            this.v.recycle();
        }
        this.v = VelocityTracker.obtain();
    }

    private void j() {
        if (this.v != null) {
            this.v.recycle();
            this.v = null;
        }
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.y == null) {
            this.y = new RecyclerView.d(){

                @Override
                public int a(int n2, int n3) {
                    int n4;
                    if (b.this.z == null) {
                        return n3;
                    }
                    int n5 = n4 = b.this.A;
                    if (n4 == -1) {
                        n5 = b.this.t.indexOfChild(b.this.z);
                        b.this.A = n5;
                    }
                    if (n3 == n2 - 1) {
                        return n5;
                    }
                    if (n3 < n5) {
                        return n3;
                    }
                    return n3 + 1;
                }
            };
        }
        this.t.setChildDrawingOrderCallback(this.y);
    }

    public void a() {
        this.b();
    }

    @Override
    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.u u2) {
        float f2;
        float f3;
        this.A = -1;
        if (this.b != null) {
            this.a(this.r);
            f2 = this.r[0];
            f3 = this.r[1];
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.a(canvas, recyclerView, this.b, this.p, this.n, f2, f3);
    }

    @Override
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u u2) {
        rect.setEmpty();
    }

    @Override
    public void a(View view) {
    }

    public void a(RecyclerView recyclerView) {
        if (this.t == recyclerView) {
            return;
        }
        if (this.t != null) {
            this.d();
        }
        this.t = recyclerView;
        if (this.t != null) {
            recyclerView = recyclerView.getResources();
            this.f = recyclerView.getDimension(d.a.item_touch_helper_swipe_escape_velocity);
            this.g = recyclerView.getDimension(d.a.item_touch_helper_swipe_escape_max_velocity);
            this.c();
            this.t.a(new RecyclerView.n(){

                @Override
                public void a(RecyclerView recyclerView, int n2) {
                    super.a(recyclerView, n2);
                    if (n2 == 1 && b.this.c != null) {
                        b.this.b();
                    }
                }
            });
        }
    }

    @Override
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.u u2) {
        float f2;
        float f3;
        if (this.b != null) {
            this.a(this.r);
            f2 = this.r[0];
            f3 = this.r[1];
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.b(canvas, recyclerView, this.b, this.p, this.n, f2, f3);
    }

    @Override
    public void b(View object) {
        this.c((View)object);
        object = this.t.b((View)object);
        if (object == null) {
            return;
        }
        if (this.b != null && object == this.b) {
            this.a((RecyclerView.x)null, 0);
            return;
        }
        this.a((RecyclerView.x)object, false);
        if (this.a.remove((Object)object.a)) {
            this.m.c(this.t, (RecyclerView.x)object);
        }
    }

    public static abstract class a {
        private static final g a;
        private static final Interpolator b;
        private static final Interpolator c;
        private int d = -1;

        /*
         * Enabled aggressive block sorting
         */
        static {
            void var0_1;
            b = new Interpolator(){

                public float getInterpolation(float f2) {
                    return f2 * f2 * f2 * f2 * f2;
                }
            };
            c = new Interpolator(){

                public float getInterpolation(float f2) {
                    return (f2 -= 1.0f) * f2 * f2 * f2 * f2 + 1.0f;
                }
            };
            if (Build.VERSION.SDK_INT >= 21) {
                c.c c2 = new c.c();
            } else if (Build.VERSION.SDK_INT >= 11) {
                c.b b2 = new c.b();
            } else {
                c.a a2 = new c.a();
            }
            a = var0_1;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public static int a(int n2, int n3) {
            int n4 = n2 & 789516;
            if (n4 == 0) {
                return n2;
            }
            n2 &= n4;
            if (n3 == 0) {
                n3 = n4 << 2;
                do {
                    return n2 | n3;
                    break;
                } while (true);
            }
            n3 = n4 << 1;
            n2 |= -789517 & n3;
            n3 = (n3 & 789516) << 2;
            return n2 | n3;
        }

        private int a(RecyclerView recyclerView) {
            if (this.d == -1) {
                this.d = recyclerView.getResources().getDimensionPixelSize(d.a.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.d;
        }

        private void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.x x2, List<c> list, int n2, float f2, float f3) {
            int n3;
            int n4 = list.size();
            for (n3 = 0; n3 < n4; ++n3) {
                c c2 = list.get(n3);
                c2.c();
                int n5 = canvas.save();
                this.a(canvas, recyclerView, c2.h, c2.k, c2.l, c2.i, false);
                canvas.restoreToCount(n5);
            }
            if (x2 != null) {
                n3 = canvas.save();
                this.a(canvas, recyclerView, x2, f2, f3, n2, true);
                canvas.restoreToCount(n3);
            }
        }

        public static int b(int n2, int n3) {
            int n4 = a.c(0, n3 | n2);
            n3 = a.c(1, n3);
            return a.c(2, n2) | (n3 | n4);
        }

        private void b(Canvas object, RecyclerView recyclerView, RecyclerView.x x2, List<c> list, int n2, float f2, float f3) {
            int n3;
            int n4 = list.size();
            int n5 = 0;
            for (n3 = 0; n3 < n4; ++n3) {
                c c2 = list.get(n3);
                int n6 = object.save();
                this.b((Canvas)object, recyclerView, c2.h, c2.k, c2.l, c2.i, false);
                object.restoreToCount(n6);
            }
            if (x2 != null) {
                n3 = object.save();
                this.b((Canvas)object, recyclerView, x2, f2, f3, n2, true);
                object.restoreToCount(n3);
            }
            n3 = n5;
            for (n2 = n4 - 1; n2 >= 0; --n2) {
                object = list.get(n2);
                if (((c)object).c && !object.j) {
                    list.remove(n2);
                    continue;
                }
                if (((c)object).c) continue;
                n3 = 1;
            }
            if (n3 != 0) {
                recyclerView.invalidate();
            }
        }

        public static int c(int n2, int n3) {
            return n3 << n2 * 8;
        }

        private boolean d(RecyclerView recyclerView, RecyclerView.x x2) {
            return (this.b(recyclerView, x2) & 16711680) != 0;
        }

        public float a(float f2) {
            return f2;
        }

        public float a(RecyclerView.x x2) {
            return 0.5f;
        }

        public int a(RecyclerView recyclerView, int n2, int n3, int n4, long l2) {
            n4 = this.a(recyclerView);
            int n5 = Math.abs(n3);
            int n6 = (int)Math.signum(n3);
            float f2 = n5;
            float f3 = 1.0f;
            f2 = Math.min(1.0f, f2 * 1.0f / (float)n2);
            n2 = (int)((float)(n6 * n4) * c.getInterpolation(f2));
            if (l2 <= 2000L) {
                f3 = (float)l2 / 2000.0f;
            }
            n2 = n4 = (int)((float)n2 * b.getInterpolation(f3));
            if (n4 == 0) {
                if (n3 > 0) {
                    return 1;
                }
                n2 = -1;
            }
            return n2;
        }

        public abstract int a(RecyclerView var1, RecyclerView.x var2);

        public long a(RecyclerView object, int n2, float f2, float f3) {
            if ((object = ((RecyclerView)object).getItemAnimator()) == null) {
                if (n2 == 8) {
                    return 200L;
                }
                return 250L;
            }
            if (n2 == 8) {
                return ((RecyclerView.f)object).e();
            }
            return ((RecyclerView.f)object).g();
        }

        public RecyclerView.x a(RecyclerView.x x2, List<RecyclerView.x> list, int n2, int n3) {
            int n4 = x2.a.getWidth();
            int n5 = x2.a.getHeight();
            int n6 = n2 - x2.a.getLeft();
            int n7 = n3 - x2.a.getTop();
            int n8 = list.size();
            RecyclerView.x x3 = null;
            int n9 = -1;
            for (int i2 = 0; i2 < n8; ++i2) {
                int n10;
                int n11;
                RecyclerView.x x4 = list.get(i2);
                if (n6 > 0 && (n10 = x4.a.getRight() - (n2 + n4)) < 0 && x4.a.getRight() > x2.a.getRight() && (n10 = Math.abs(n10)) > n9) {
                    x3 = x4;
                } else {
                    n10 = n9;
                }
                RecyclerView.x x5 = x3;
                n9 = n10;
                if (n6 < 0) {
                    n11 = x4.a.getLeft() - n2;
                    x5 = x3;
                    n9 = n10;
                    if (n11 > 0) {
                        x5 = x3;
                        n9 = n10;
                        if (x4.a.getLeft() < x2.a.getLeft()) {
                            n11 = Math.abs(n11);
                            x5 = x3;
                            n9 = n10;
                            if (n11 > n10) {
                                n9 = n11;
                                x5 = x4;
                            }
                        }
                    }
                }
                x3 = x5;
                n10 = n9;
                if (n7 < 0) {
                    n11 = x4.a.getTop() - n3;
                    x3 = x5;
                    n10 = n9;
                    if (n11 > 0) {
                        x3 = x5;
                        n10 = n9;
                        if (x4.a.getTop() < x2.a.getTop()) {
                            n11 = Math.abs(n11);
                            x3 = x5;
                            n10 = n9;
                            if (n11 > n9) {
                                n10 = n11;
                                x3 = x4;
                            }
                        }
                    }
                }
                if (n7 > 0 && (n9 = x4.a.getBottom() - (n3 + n5)) < 0 && x4.a.getBottom() > x2.a.getBottom() && (n9 = Math.abs(n9)) > n10) {
                    x3 = x4;
                    continue;
                }
                n9 = n10;
            }
            return x3;
        }

        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.x x2, float f2, float f3, int n2, boolean bl2) {
            a.a(canvas, recyclerView, x2.a, f2, f3, n2, bl2);
        }

        public abstract void a(RecyclerView.x var1, int var2);

        public void a(RecyclerView recyclerView, RecyclerView.x x2, int n2, RecyclerView.x x3, int n3, int n4, int n5) {
            RecyclerView.i i2 = recyclerView.getLayoutManager();
            if (i2 instanceof e) {
                ((e)((Object)i2)).a(x2.a, x3.a, n4, n5);
                return;
            }
            if (i2.e()) {
                if (i2.h(x3.a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.b(n3);
                }
                if (i2.j(x3.a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.b(n3);
                }
            }
            if (i2.f()) {
                if (i2.i(x3.a) <= recyclerView.getPaddingTop()) {
                    recyclerView.b(n3);
                }
                if (i2.k(x3.a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.b(n3);
                }
            }
        }

        public boolean a() {
            return true;
        }

        public boolean a(RecyclerView recyclerView, RecyclerView.x x2, RecyclerView.x x3) {
            return true;
        }

        public float b(float f2) {
            return f2;
        }

        public float b(RecyclerView.x x2) {
            return 0.5f;
        }

        final int b(RecyclerView recyclerView, RecyclerView.x x2) {
            return this.d(this.a(recyclerView, x2), t.f((View)recyclerView));
        }

        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.x x2, float f2, float f3, int n2, boolean bl2) {
            a.b(canvas, recyclerView, x2.a, f2, f3, n2, bl2);
        }

        public void b(RecyclerView.x x2, int n2) {
            if (x2 != null) {
                a.b(x2.a);
            }
        }

        public boolean b() {
            return true;
        }

        public abstract boolean b(RecyclerView var1, RecyclerView.x var2, RecyclerView.x var3);

        public int c() {
            return 0;
        }

        public View c(RecyclerView.x x2) {
            if (x2 == null) {
                return null;
            }
            if (x2.a instanceof ViewGroup && ((ViewGroup)x2.a).getChildCount() > 1) {
                x2 = (ViewGroup)x2.a;
                return x2.getChildAt(x2.getChildCount() - 1);
            }
            return x2.a;
        }

        public void c(RecyclerView recyclerView, RecyclerView.x x2) {
            a.a(x2.a);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int d(int n2, int n3) {
            int n4 = n2 & 3158064;
            if (n4 == 0) {
                return n2;
            }
            n2 &= n4;
            if (n3 == 0) {
                n3 = n4 >> 2;
                do {
                    return n2 | n3;
                    break;
                } while (true);
            }
            n3 = n4 >> 1;
            n2 |= -3158065 & n3;
            n3 = (n3 & 3158064) >> 2;
            return n2 | n3;
        }

    }

    private class b
    extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        public boolean onContextClick(MotionEvent motionEvent) {
            return super.onContextClick(motionEvent);
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent object) {
            Object object2 = b.this.b(object);
            if (object2 != null && (object2 = b.this.t.b((View)object2)) != null) {
                if (!b.this.m.d(b.this.t, (RecyclerView.x)object2)) {
                    return;
                }
                if (i.b(object, 0) == b.this.l) {
                    int n2 = i.a(object, b.this.l);
                    float f2 = i.c(object, n2);
                    float f3 = i.d(object, n2);
                    b.this.d = f2;
                    b.this.e = f3;
                    object = b.this;
                    b.this.i = 0.0f;
                    object.h = 0.0f;
                    if (b.this.m.a()) {
                        b.this.a((RecyclerView.x)object2, 2);
                    }
                }
            }
        }
    }

    private class c
    implements Animator.AnimatorListener {
        private final ValueAnimator a;
        private final int b;
        private boolean c = false;
        final float d;
        final float e;
        final float f;
        final float g;
        final RecyclerView.x h;
        final int i;
        public boolean j;
        float k;
        float l;
        boolean m = false;
        private float o;

        public c(RecyclerView.x x2, int n2, int n3, float f2, float f3, float f4, float f5) {
            this.i = n3;
            this.b = n2;
            this.h = x2;
            this.d = f2;
            this.e = f3;
            this.f = f4;
            this.g = f5;
            this.a = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
            this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.a(valueAnimator.getAnimatedFraction());
                }
            });
            this.a.setTarget((Object)x2.a);
            this.a.addListener((Animator.AnimatorListener)this);
            this.a(0.0f);
        }

        public void a() {
            this.h.a(false);
            this.a.start();
        }

        public void a(float f2) {
            this.o = f2;
        }

        public void a(long l2) {
            this.a.setDuration(l2);
        }

        public void b() {
            this.a.cancel();
        }

        /*
         * Enabled aggressive block sorting
         */
        public void c() {
            this.k = this.d + this.o * (this.f - this.d);
            float f2 = this.e == this.g ? t.j(this.h.a) : this.e + this.o * (this.g - this.e);
            this.l = f2;
        }

        public float d() {
            return this.k;
        }

        public float e() {
            return this.h.a.getY() + this.l;
        }

        public void onAnimationCancel(Animator animator) {
            this.a(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.c) {
                this.h.a(true);
            }
            this.c = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

    }

    public static abstract class d
    extends a {
        private int a;
        private int b;

        public d(int n2, int n3) {
            this.a = n3;
            this.b = n2;
        }

        @Override
        public int a(RecyclerView recyclerView, RecyclerView.x x2) {
            return d.b(this.e(recyclerView, x2), this.d(recyclerView, x2));
        }

        public void a(int n2) {
            this.b = n2;
        }

        public int d(RecyclerView recyclerView, RecyclerView.x x2) {
            return this.a;
        }

        public int e(RecyclerView recyclerView, RecyclerView.x x2) {
            return this.b;
        }
    }

    public static interface e {
        public void a(View var1, View var2, int var3, int var4);
    }

}

