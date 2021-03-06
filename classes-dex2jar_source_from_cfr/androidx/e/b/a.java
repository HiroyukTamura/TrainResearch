/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 */
package androidx.e.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.h.t;
import java.util.Arrays;

public class a {
    private static final Interpolator v = new Interpolator(){

        public float getInterpolation(float f2) {
            return (f2 -= 1.0f) * f2 * f2 * f2 * f2 + 1.0f;
        }
    };
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new Runnable(){

        @Override
        public void run() {
            a.this.b(0);
        }
    };

    private a(Context context, ViewGroup viewGroup, a a2) {
        if (viewGroup != null) {
            if (a2 != null) {
                this.u = viewGroup;
                this.r = a2;
                viewGroup = ViewConfiguration.get((Context)context);
                this.o = (int)(context.getResources().getDisplayMetrics().density * 20.0f + 0.5f);
                this.b = viewGroup.getScaledTouchSlop();
                this.m = viewGroup.getScaledMaximumFlingVelocity();
                this.n = viewGroup.getScaledMinimumFlingVelocity();
                this.q = new OverScroller(context, v);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private float a(float f2) {
        return (float)Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private float a(float f2, float f3, float f4) {
        float f5 = Math.abs(f2);
        if (f5 < f3) {
            return 0.0f;
        }
        if (f5 > f4) {
            if (f2 > 0.0f) {
                return f4;
            }
            return -f4;
        }
        return f2;
    }

    private int a(int n2, int n3, int n4) {
        if (n2 == 0) {
            return 0;
        }
        int n5 = this.u.getWidth();
        int n6 = n5 / 2;
        float f2 = Math.min(1.0f, (float)Math.abs(n2) / (float)n5);
        float f3 = n6;
        f2 = this.a(f2);
        n2 = (n3 = Math.abs(n3)) > 0 ? Math.round(Math.abs((f3 + f2 * f3) / (float)n3) * 1000.0f) * 4 : (int)(((float)Math.abs(n2) / (float)n4 + 1.0f) * 256.0f);
        return Math.min(n2, 600);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(View view, int n2, int n3, int n4, int n5) {
        float f2;
        float f3;
        n4 = this.b(n4, (int)this.n, (int)this.m);
        n5 = this.b(n5, (int)this.n, (int)this.m);
        int n6 = Math.abs(n2);
        int n7 = Math.abs(n3);
        int n8 = Math.abs(n4);
        int n9 = Math.abs(n5);
        int n10 = n8 + n9;
        int n11 = n6 + n7;
        if (n4 != 0) {
            f3 = n8;
            f2 = n10;
        } else {
            f3 = n6;
            f2 = n11;
        }
        float f4 = f3 / f2;
        if (n5 != 0) {
            f3 = n9;
            f2 = n10;
        } else {
            f3 = n7;
            f2 = n11;
        }
        n2 = this.a(n2, n4, this.r.a(view));
        n3 = this.a(n3, n5, this.r.b(view));
        return (int)((float)n2 * f4 + (float)n3 * (f3 /= f2));
    }

    public static a a(ViewGroup object, float f2, a a2) {
        object = a.a(object, a2);
        object.b = (int)((float)object.b * (1.0f / f2));
        return object;
    }

    public static a a(ViewGroup viewGroup, a a2) {
        return new a(viewGroup.getContext(), viewGroup, a2);
    }

    private void a(float f2, float f3) {
        this.t = true;
        this.r.a(this.s, f2, f3);
        this.t = false;
        if (this.a == 1) {
            this.b(0);
        }
    }

    private void a(float f2, float f3, int n2) {
        this.d(n2);
        float[] arrf = this.d;
        this.f[n2] = f2;
        arrf[n2] = f2;
        arrf = this.e;
        this.g[n2] = f3;
        arrf[n2] = f3;
        this.h[n2] = this.d((int)f2, (int)f3);
        this.k |= 1 << n2;
    }

    private boolean a(float f2, float f3, int n2, int n3) {
        boolean bl2;
        f2 = Math.abs(f2);
        f3 = Math.abs(f3);
        int n4 = this.h[n2];
        boolean bl3 = bl2 = false;
        if ((n4 & n3) == n3) {
            bl3 = bl2;
            if ((this.p & n3) != 0) {
                bl3 = bl2;
                if ((this.j[n2] & n3) != n3) {
                    bl3 = bl2;
                    if ((this.i[n2] & n3) != n3) {
                        if (f2 <= (float)this.b && f3 <= (float)this.b) {
                            return false;
                        }
                        if (f2 < f3 * 0.5f && this.r.b(n3)) {
                            int[] arrn = this.j;
                            arrn[n2] = arrn[n2] | n3;
                            return false;
                        }
                        bl3 = bl2;
                        if ((this.i[n2] & n3) == 0) {
                            bl3 = bl2;
                            if (f2 > (float)this.b) {
                                bl3 = true;
                            }
                        }
                    }
                }
            }
        }
        return bl3;
    }

    private boolean a(int n2, int n3, int n4, int n5) {
        int n6 = this.s.getLeft();
        int n7 = this.s.getTop();
        if ((n2 -= n6) == 0 && (n3 -= n7) == 0) {
            this.q.abortAnimation();
            this.b(0);
            return false;
        }
        n4 = this.a(this.s, n2, n3, n4, n5);
        this.q.startScroll(n6, n7, n2, n3, n4);
        this.b(2);
        return true;
    }

    private boolean a(View view, float f2, float f3) {
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        if (view == null) {
            return false;
        }
        boolean bl5 = this.r.a(view) > 0;
        boolean bl6 = this.r.b(view) > 0;
        if (bl5 && bl6) {
            if (f2 * f2 + f3 * f3 > (float)(this.b * this.b)) {
                bl4 = true;
            }
            return bl4;
        }
        if (bl5) {
            bl4 = bl2;
            if (Math.abs(f2) > (float)this.b) {
                bl4 = true;
            }
            return bl4;
        }
        bl4 = bl3;
        if (bl6) {
            bl4 = bl3;
            if (Math.abs(f3) > (float)this.b) {
                bl4 = true;
            }
        }
        return bl4;
    }

    private int b(int n2, int n3, int n4) {
        int n5 = Math.abs(n2);
        if (n5 < n3) {
            return 0;
        }
        if (n5 > n4) {
            if (n2 > 0) {
                return n4;
            }
            return -n4;
        }
        return n2;
    }

    private void b(float f2, float f3, int n2) {
        int n3 = 1;
        if (!this.a(f2, f3, n2, 1)) {
            n3 = 0;
        }
        int n4 = n3;
        if (this.a(f3, f2, n2, 4)) {
            n4 = n3 | 4;
        }
        n3 = n4;
        if (this.a(f2, f3, n2, 2)) {
            n3 = n4 | 2;
        }
        n4 = n3;
        if (this.a(f3, f2, n2, 8)) {
            n4 = n3 | 8;
        }
        if (n4 != 0) {
            int[] arrn = this.i;
            arrn[n2] = arrn[n2] | n4;
            this.r.b(n4, n2);
        }
    }

    private void b(int n2, int n3, int n4, int n5) {
        int n6 = this.s.getLeft();
        int n7 = this.s.getTop();
        int n8 = n2;
        if (n4 != 0) {
            n8 = this.r.a(this.s, n2, n4);
            t.f(this.s, n8 - n6);
        }
        n2 = n3;
        if (n5 != 0) {
            n2 = this.r.b(this.s, n3, n5);
            t.e(this.s, n2 - n7);
        }
        if (n4 != 0 || n5 != 0) {
            this.r.a(this.s, n8, n2, n8 - n6, n2 - n7);
        }
    }

    private void c() {
        if (this.d == null) {
            return;
        }
        Arrays.fill(this.d, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void c(int n2) {
        if (this.d != null) {
            if (!this.a(n2)) {
                return;
            }
            this.d[n2] = 0.0f;
            this.e[n2] = 0.0f;
            this.f[n2] = 0.0f;
            this.g[n2] = 0.0f;
            this.h[n2] = 0;
            this.i[n2] = 0;
            this.j[n2] = 0;
            this.k = 1 << n2 & this.k;
        }
    }

    private void c(MotionEvent motionEvent) {
        int n2 = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = motionEvent.getPointerId(i2);
            if (!this.e(n3)) continue;
            float f2 = motionEvent.getX(i2);
            float f3 = motionEvent.getY(i2);
            this.f[n3] = f2;
            this.g[n3] = f3;
        }
    }

    private int d(int n2, int n3) {
        int n4 = n2 < this.u.getLeft() + this.o ? 1 : 0;
        int n5 = n4;
        if (n3 < this.u.getTop() + this.o) {
            n5 = n4 | 4;
        }
        n4 = n5;
        if (n2 > this.u.getRight() - this.o) {
            n4 = n5 | 2;
        }
        n2 = n4;
        if (n3 > this.u.getBottom() - this.o) {
            n2 = n4 | 8;
        }
        return n2;
    }

    private void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        this.a(this.a(this.l.getXVelocity(this.c), this.n, this.m), this.a(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void d(int n2) {
        if (this.d == null || this.d.length <= n2) {
            float[] arrf = new float[++n2];
            float[] arrf2 = new float[n2];
            float[] arrf3 = new float[n2];
            float[] arrf4 = new float[n2];
            int[] arrn = new int[n2];
            int[] arrn2 = new int[n2];
            int[] arrn3 = new int[n2];
            if (this.d != null) {
                System.arraycopy(this.d, 0, arrf, 0, this.d.length);
                System.arraycopy(this.e, 0, arrf2, 0, this.e.length);
                System.arraycopy(this.f, 0, arrf3, 0, this.f.length);
                System.arraycopy(this.g, 0, arrf4, 0, this.g.length);
                System.arraycopy(this.h, 0, arrn, 0, this.h.length);
                System.arraycopy(this.i, 0, arrn2, 0, this.i.length);
                System.arraycopy(this.j, 0, arrn3, 0, this.j.length);
            }
            this.d = arrf;
            this.e = arrf2;
            this.f = arrf3;
            this.g = arrf4;
            this.h = arrn;
            this.i = arrn2;
            this.j = arrn3;
        }
    }

    private boolean e(int n2) {
        if (!this.a(n2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring pointerId=");
            stringBuilder.append(n2);
            stringBuilder.append(" because ACTION_DOWN was not received ");
            stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
            stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
            Log.e((String)"ViewDragHelper", (String)stringBuilder.toString());
            return false;
        }
        return true;
    }

    public int a() {
        return this.b;
    }

    public void a(View object, int n2) {
        if (object.getParent() == this.u) {
            this.s = object;
            this.c = n2;
            this.r.a((View)object, n2);
            this.b(1);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        ((StringBuilder)object).append((Object)this.u);
        ((StringBuilder)object).append(")");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public boolean a(int n2) {
        return (1 << n2 & this.k) != 0;
    }

    public boolean a(int n2, int n3) {
        if (this.t) {
            return this.a(n2, n3, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean a(MotionEvent var1_1) {
        var7_2 = var1_1.getActionMasked();
        var6_3 = var1_1.getActionIndex();
        if (var7_2 == 0) {
            this.b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(var1_1);
        switch (var7_2) {
            case 6: {
                this.c(var1_1.getPointerId(var6_3));
                ** break;
            }
            case 5: {
                var7_2 = var1_1.getPointerId(var6_3);
                var2_4 = var1_1.getX(var6_3);
                var3_7 = var1_1.getY(var6_3);
                this.a(var2_4, var3_7, var7_2);
                if (this.a == 0) {
                    var6_3 = this.h[var7_2];
                    if ((this.p & var6_3) != 0) {
                        this.r.a(var6_3 & this.p, var7_2);
                        ** break;
                    }
                } else if (this.a == 2 && (var1_1 = this.c((int)var2_4, (int)var3_7)) == this.s) {
                    this.b((View)var1_1, var7_2);
                    ** break;
                }
                ** GOTO lbl-1000
            }
            case 2: {
                ** if (this.d == null) goto lbl-1000
lbl-1000: // 1 sources:
                {
                    if (this.e == null) {
                        ** break;
                    } else {
                        ** GOTO lbl31
                    }
lbl31: // 2 sources:
                    ** GOTO lbl34
                }
            }
lbl-1000: // 4 sources:
            {
                default: {
                    ** break;
                }
            }
lbl34: // 1 sources:
            var8_10 = var1_1.getPointerCount();
            for (var6_3 = 0; var6_3 < var8_10; ++var6_3) {
                var9_13 = var1_1.getPointerId(var6_3);
                if (!this.e(var9_13)) continue;
                var2_5 = var1_1.getX(var6_3);
                var3_8 = var1_1.getY(var6_3);
                var4_11 = var2_5 - this.d[var9_13];
                var5_12 = var3_8 - this.e[var9_13];
                var17_20 = this.c((int)var2_5, (int)var3_8);
                var7_2 = var17_20 != null && this.a(var17_20, var4_11, var5_12) != false ? 1 : 0;
                if (var7_2 != 0) {
                    var10_14 = var17_20.getLeft();
                    var11_15 = (int)var4_11;
                    var11_15 = this.r.a(var17_20, var10_14 + var11_15, var11_15);
                    var12_16 = var17_20.getTop();
                    var13_17 = (int)var5_12;
                    var13_17 = this.r.b(var17_20, var12_16 + var13_17, var13_17);
                    var14_18 = this.r.a(var17_20);
                    var15_19 = this.r.b(var17_20);
                    if ((var14_18 == 0 || var14_18 > 0 && var11_15 == var10_14) && (var15_19 == 0 || var15_19 > 0 && var13_17 == var12_16)) break;
                }
                this.b(var4_11, var5_12, var9_13);
                if (this.a == 1 || var7_2 != 0 && this.b(var17_20, var9_13)) break;
            }
            this.c(var1_1);
            ** break;
            case 1: 
            case 3: {
                this.b();
                ** break;
            }
            case 0: 
        }
        var2_6 = var1_1.getX();
        var3_9 = var1_1.getY();
        var6_3 = var1_1.getPointerId(0);
        this.a(var2_6, var3_9, var6_3);
        var1_1 = this.c((int)var2_6, (int)var3_9);
        if (var1_1 == this.s && this.a == 2) {
            this.b((View)var1_1, var6_3);
        }
        if ((this.p & (var7_2 = this.h[var6_3])) != 0) {
            this.r.a(var7_2 & this.p, var6_3);
        }
lbl72: // 10 sources:
        var16_21 = false;
        if (this.a != 1) return var16_21;
        return true;
    }

    public boolean a(View view, int n2, int n3) {
        this.s = view;
        this.c = -1;
        boolean bl2 = this.a(n2, n3, 0, 0);
        if (!bl2 && this.a == 0 && this.s != null) {
            this.s = null;
        }
        return bl2;
    }

    public boolean a(boolean bl2) {
        int n2 = this.a;
        boolean bl3 = false;
        if (n2 == 2) {
            boolean bl4 = this.q.computeScrollOffset();
            n2 = this.q.getCurrX();
            int n3 = this.q.getCurrY();
            int n4 = n2 - this.s.getLeft();
            int n5 = n3 - this.s.getTop();
            if (n4 != 0) {
                t.f(this.s, n4);
            }
            if (n5 != 0) {
                t.e(this.s, n5);
            }
            if (n4 != 0 || n5 != 0) {
                this.r.a(this.s, n2, n3, n4, n5);
            }
            boolean bl5 = bl4;
            if (bl4) {
                bl5 = bl4;
                if (n2 == this.q.getFinalX()) {
                    bl5 = bl4;
                    if (n3 == this.q.getFinalY()) {
                        this.q.abortAnimation();
                        bl5 = false;
                    }
                }
            }
            if (!bl5) {
                if (bl2) {
                    this.u.post(this.w);
                } else {
                    this.b(0);
                }
            }
        }
        bl2 = bl3;
        if (this.a == 2) {
            bl2 = true;
        }
        return bl2;
    }

    public void b() {
        this.c = -1;
        this.c();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    void b(int n2) {
        this.u.removeCallbacks(this.w);
        if (this.a != n2) {
            this.a = n2;
            this.r.a(n2);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void b(MotionEvent var1_1) {
        block20 : {
            var9_2 = var1_1.getActionMasked();
            var8_3 = var1_1.getActionIndex();
            if (var9_2 == 0) {
                this.b();
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            this.l.addMovement(var1_1);
            var7_4 = 0;
            switch (var9_2) {
                default: {
                    return;
                }
                case 6: {
                    var7_4 = var1_1.getPointerId(var8_3);
                    if (this.a != 1 || var7_4 != this.c) ** GOTO lbl24
                    var8_3 = var1_1.getPointerCount();
                    for (var6_5 = 0; var6_5 < var8_3; ++var6_5) {
                        var9_2 = var1_1.getPointerId(var6_5);
                        if (var9_2 == this.c || this.c((int)(var2_6 = var1_1.getX(var6_5)), (int)(var3_11 = var1_1.getY(var6_5))) != this.s || !this.b(this.s, var9_2)) continue;
                        var6_5 = this.c;
                        ** GOTO lbl22
                    }
                    var6_5 = -1;
lbl22: // 2 sources:
                    if (var6_5 == -1) {
                        this.d();
                    }
lbl24: // 4 sources:
                    this.c(var7_4);
                    return;
                }
                case 5: {
                    var6_5 = var1_1.getPointerId(var8_3);
                    var2_7 = var1_1.getX(var8_3);
                    var3_12 = var1_1.getY(var8_3);
                    this.a(var2_7, var3_12, var6_5);
                    if (this.a == 0) {
                        this.b(this.c((int)var2_7, (int)var3_12), var6_5);
                        var7_4 = this.h[var6_5];
                        if ((this.p & var7_4) == 0) return;
                        this.r.a(var7_4 & this.p, var6_5);
                        return;
                    }
                    if (this.b((int)var2_7, (int)var3_12) == false) return;
                    this.b(this.s, var6_5);
                    return;
                }
                case 3: {
                    if (this.a == 1) {
                        this.a(0.0f, 0.0f);
                    }
                    ** GOTO lbl71
                }
                case 2: {
                    if (this.a == 1) {
                        if (!this.e(this.c)) {
                            return;
                        }
                        var6_5 = var1_1.findPointerIndex(this.c);
                        var2_8 = var1_1.getX(var6_5);
                        var3_13 = var1_1.getY(var6_5);
                        var6_5 = (int)(var2_8 - this.f[this.c]);
                        var7_4 = (int)(var3_13 - this.g[this.c]);
                        this.b(this.s.getLeft() + var6_5, this.s.getTop() + var7_4, var6_5, var7_4);
                    } else {
                        var8_3 = var1_1.getPointerCount();
                        for (var6_5 = var7_4; var6_5 < var8_3; ++var6_5) {
                            var7_4 = var1_1.getPointerId(var6_5);
                            if (!this.e(var7_4)) continue;
                            var2_9 = var1_1.getX(var6_5);
                            var3_14 = var1_1.getY(var6_5);
                            var4_16 = var2_9 - this.d[var7_4];
                            var5_17 = var3_14 - this.e[var7_4];
                            this.b(var4_16, var5_17, var7_4);
                            if (!(this.a == 1 || this.a(var10_18 = this.c((int)var2_9, (int)var3_14), var4_16, var5_17) && this.b(var10_18, var7_4))) {
                                continue;
                            }
                            break block20;
                        }
                    }
                    break block20;
                }
                case 1: {
                    if (this.a == 1) {
                        this.d();
                    }
lbl71: // 4 sources:
                    this.b();
                    return;
                }
                case 0: 
            }
            var2_10 = var1_1.getX();
            var3_15 = var1_1.getY();
            var6_5 = var1_1.getPointerId(0);
            var1_1 = this.c((int)var2_10, (int)var3_15);
            this.a(var2_10, var3_15, var6_5);
            this.b((View)var1_1, var6_5);
            var7_4 = this.h[var6_5];
            if ((this.p & var7_4) == 0) return;
            this.r.a(var7_4 & this.p, var6_5);
            return;
        }
        this.c(var1_1);
    }

    public boolean b(int n2, int n3) {
        return this.b(this.s, n2, n3);
    }

    boolean b(View view, int n2) {
        if (view == this.s && this.c == n2) {
            return true;
        }
        if (view != null && this.r.b(view, n2)) {
            this.c = n2;
            this.a(view, n2);
            return true;
        }
        return false;
    }

    public boolean b(View view, int n2, int n3) {
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        boolean bl3 = bl2;
        if (n2 >= view.getLeft()) {
            bl3 = bl2;
            if (n2 < view.getRight()) {
                bl3 = bl2;
                if (n3 >= view.getTop()) {
                    bl3 = bl2;
                    if (n3 < view.getBottom()) {
                        bl3 = true;
                    }
                }
            }
        }
        return bl3;
    }

    public View c(int n2, int n3) {
        for (int i2 = this.u.getChildCount() - 1; i2 >= 0; --i2) {
            View view = this.u.getChildAt(this.r.c(i2));
            if (n2 < view.getLeft() || n2 >= view.getRight() || n3 < view.getTop() || n3 >= view.getBottom()) continue;
            return view;
        }
        return null;
    }

    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public int a(View view, int n2, int n3) {
            return 0;
        }

        public void a(int n2) {
        }

        public void a(int n2, int n3) {
        }

        public void a(View view, float f2, float f3) {
        }

        public void a(View view, int n2) {
        }

        public void a(View view, int n2, int n3, int n4, int n5) {
        }

        public int b(View view) {
            return 0;
        }

        public int b(View view, int n2, int n3) {
            return 0;
        }

        public void b(int n2, int n3) {
        }

        public boolean b(int n2) {
            return false;
        }

        public abstract boolean b(View var1, int var2);

        public int c(int n2) {
            return n2;
        }
    }

}

