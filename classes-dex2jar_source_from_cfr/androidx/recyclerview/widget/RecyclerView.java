/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.database.Observable
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.Display
 *  android.view.FocusFinder
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.OverScroller
 */
package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.h.a.b;
import androidx.recyclerview.a;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.n;
import androidx.recyclerview.widget.o;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
extends ViewGroup
implements androidx.core.h.k {
    static final Interpolator L;
    private static final int[] M;
    private static final int[] N;
    private static final boolean O;
    private static final boolean P;
    private static final Class<?>[] Q;
    static final boolean a;
    static final boolean b;
    static final boolean c;
    static final boolean d;
    final w A;
    androidx.recyclerview.widget.f B;
    f.a C;
    final u D;
    boolean E;
    boolean F;
    boolean G;
    androidx.recyclerview.widget.k H;
    final int[] I;
    final int[] J;
    final List<x> K;
    private final r R = new r();
    private s S;
    private final Rect T = new Rect();
    private final ArrayList<m> U = new ArrayList();
    private m V;
    private int W = 0;
    private List<n> aA;
    private f.b aB;
    private d aC;
    private final int[] aD;
    private androidx.core.h.l aE;
    private final int[] aF;
    private final int[] aG;
    private Runnable aH;
    private final o.b aI;
    private boolean aa;
    private int ab;
    private final AccessibilityManager ac;
    private List<k> ad;
    private int ae = 0;
    private int af = 0;
    private e ag = new e();
    private EdgeEffect ah;
    private EdgeEffect ai;
    private EdgeEffect aj;
    private EdgeEffect ak;
    private int al = 0;
    private int am = -1;
    private VelocityTracker an;
    private int ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private l at;
    private final int au;
    private final int av;
    private float aw = Float.MIN_VALUE;
    private float ax = Float.MIN_VALUE;
    private boolean ay;
    private n az;
    final p e = new p();
    androidx.recyclerview.widget.a f;
    androidx.recyclerview.widget.b g;
    final androidx.recyclerview.widget.o h = new androidx.recyclerview.widget.o();
    boolean i;
    final Runnable j = new Runnable(){

        @Override
        public void run() {
            if (RecyclerView.this.t) {
                if (RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.q) {
                    RecyclerView.this.requestLayout();
                    return;
                }
                if (RecyclerView.this.v) {
                    RecyclerView.this.u = true;
                    return;
                }
                RecyclerView.this.e();
            }
        }
    };
    final Rect k = new Rect();
    final RectF l = new RectF();
    a m;
    i n;
    q o;
    final ArrayList<h> p = new ArrayList();
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x = false;
    boolean y = false;
    f z = new androidx.recyclerview.widget.c();

    static {
        M = new int[]{16843830};
        N = new int[]{16842987};
        boolean bl2 = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        a = bl2;
        bl2 = Build.VERSION.SDK_INT >= 23;
        b = bl2;
        bl2 = Build.VERSION.SDK_INT >= 16;
        c = bl2;
        bl2 = Build.VERSION.SDK_INT >= 21;
        d = bl2;
        bl2 = Build.VERSION.SDK_INT <= 15;
        O = bl2;
        bl2 = Build.VERSION.SDK_INT <= 15;
        P = bl2;
        Q = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        L = new Interpolator(){

            public float getInterpolation(float f2) {
                return (f2 -= 1.0f) * f2 * f2 * f2 * f2 + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        boolean bl2 = true;
        this.ay = true;
        this.A = new w();
        f.a a2 = d ? new f.a() : null;
        this.C = a2;
        this.D = new u();
        this.E = false;
        this.F = false;
        this.aB = new g();
        this.G = false;
        this.aD = new int[2];
        this.aF = new int[2];
        this.I = new int[2];
        this.aG = new int[2];
        this.J = new int[2];
        this.K = new ArrayList<x>();
        this.aH = new Runnable(){

            @Override
            public void run() {
                if (RecyclerView.this.z != null) {
                    RecyclerView.this.z.a();
                }
                RecyclerView.this.G = false;
            }
        };
        this.aI = new o.b(){

            @Override
            public void a(x x2) {
                RecyclerView.this.n.a(x2.a, RecyclerView.this.e);
            }

            @Override
            public void a(x x2, f.c c2, f.c c3) {
                RecyclerView.this.e.c(x2);
                RecyclerView.this.b(x2, c2, c3);
            }

            @Override
            public void b(x x2, f.c c2, f.c c3) {
                RecyclerView.this.a(x2, c2, c3);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void c(x x2, f.c c2, f.c c3) {
                x2.a(false);
                if (RecyclerView.this.x ? RecyclerView.this.z.a(x2, x2, c2, c3) : RecyclerView.this.z.c(x2, c2, c3)) {
                    RecyclerView.this.q();
                    return;
                }
            }
        };
        if (attributeSet != null) {
            a2 = context.obtainStyledAttributes(attributeSet, N, n2, 0);
            this.i = a2.getBoolean(0, true);
            a2.recycle();
        } else {
            this.i = true;
        }
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        a2 = ViewConfiguration.get((Context)context);
        this.as = a2.getScaledTouchSlop();
        this.aw = androidx.core.h.u.a((ViewConfiguration)a2, context);
        this.ax = androidx.core.h.u.b((ViewConfiguration)a2, context);
        this.au = a2.getScaledMinimumFlingVelocity();
        this.av = a2.getScaledMaximumFlingVelocity();
        boolean bl3 = this.getOverScrollMode() == 2;
        this.setWillNotDraw(bl3);
        this.z.a(this.aB);
        this.b();
        this.A();
        this.z();
        if (androidx.core.h.t.e((View)this) == 0) {
            androidx.core.h.t.b((View)this, 1);
        }
        this.ac = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        if (attributeSet != null) {
            a2 = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, n2, 0);
            String string2 = a2.getString(a.b.RecyclerView_layoutManager);
            if (a2.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                this.setDescendantFocusability(262144);
            }
            this.s = a2.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
            if (this.s) {
                this.a((StateListDrawable)a2.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), a2.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)a2.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), a2.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            a2.recycle();
            this.a(context, string2, attributeSet, n2, 0);
            bl3 = bl2;
            if (Build.VERSION.SDK_INT >= 21) {
                context = context.obtainStyledAttributes(attributeSet, M, n2, 0);
                bl3 = context.getBoolean(0, true);
                context.recycle();
            }
        } else {
            this.setDescendantFocusability(262144);
            bl3 = bl2;
        }
        this.setNestedScrollingEnabled(bl3);
    }

    private void A() {
        this.g = new androidx.recyclerview.widget.b(new b.b(){

            @Override
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            @Override
            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override
            public void a(int n2) {
                View view = RecyclerView.this.getChildAt(n2);
                if (view != null) {
                    RecyclerView.this.k(view);
                    view.clearAnimation();
                }
                RecyclerView.this.removeViewAt(n2);
            }

            @Override
            public void a(View view, int n2) {
                RecyclerView.this.addView(view, n2);
                RecyclerView.this.l(view);
            }

            @Override
            public void a(View object, int n2, ViewGroup.LayoutParams layoutParams) {
                x x2 = RecyclerView.e((View)object);
                if (x2 != null) {
                    if (!x2.r() && !x2.c()) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Called attach on a child which is not detached: ");
                        ((StringBuilder)object).append(x2);
                        ((StringBuilder)object).append(RecyclerView.this.a());
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    x2.m();
                }
                RecyclerView.this.attachViewToParent((View)object, n2, layoutParams);
            }

            @Override
            public View b(int n2) {
                return RecyclerView.this.getChildAt(n2);
            }

            @Override
            public x b(View view) {
                return RecyclerView.e(view);
            }

            @Override
            public void b() {
                int n2 = this.a();
                for (int i2 = 0; i2 < n2; ++i2) {
                    View view = this.b(i2);
                    RecyclerView.this.k(view);
                    view.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override
            public void c(int n2) {
                Object object = this.b(n2);
                if (object != null && (object = RecyclerView.e((View)object)) != null) {
                    if (((x)object).r() && !((x)object).c()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("called detach on an already detached child ");
                        stringBuilder.append(object);
                        stringBuilder.append(RecyclerView.this.a());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    ((x)object).b(256);
                }
                RecyclerView.this.detachViewFromParent(n2);
            }

            @Override
            public void c(View object) {
                if ((object = RecyclerView.e((View)object)) != null) {
                    ((x)object).a(RecyclerView.this);
                }
            }

            @Override
            public void d(View object) {
                if ((object = RecyclerView.e((View)object)) != null) {
                    ((x)object).b(RecyclerView.this);
                }
            }
        });
    }

    private boolean B() {
        int n2 = this.g.b();
        for (int i2 = 0; i2 < n2; ++i2) {
            x x2 = RecyclerView.e(this.g.b(i2));
            if (x2 == null || x2.c() || !x2.z()) continue;
            return true;
        }
        return false;
    }

    private void C() {
        this.A.b();
        if (this.n != null) {
            this.n.H();
        }
    }

    private void D() {
        boolean bl2;
        if (this.ah != null) {
            this.ah.onRelease();
            bl2 = this.ah.isFinished();
        } else {
            bl2 = false;
        }
        boolean bl3 = bl2;
        if (this.ai != null) {
            this.ai.onRelease();
            bl3 = bl2 | this.ai.isFinished();
        }
        bl2 = bl3;
        if (this.aj != null) {
            this.aj.onRelease();
            bl2 = bl3 | this.aj.isFinished();
        }
        bl3 = bl2;
        if (this.ak != null) {
            this.ak.onRelease();
            bl3 = bl2 | this.ak.isFinished();
        }
        if (bl3) {
            androidx.core.h.t.d((View)this);
        }
    }

    private void E() {
        if (this.an != null) {
            this.an.clear();
        }
        this.a(0);
        this.D();
    }

    private void F() {
        this.E();
        this.setScrollState(0);
    }

    private void G() {
        int n2 = this.ab;
        this.ab = 0;
        if (n2 != 0 && this.o()) {
            AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
            accessibilityEvent.setEventType(2048);
            androidx.core.h.a.a.a(accessibilityEvent, n2);
            this.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    private boolean H() {
        return this.z != null && this.n.b();
    }

    private void I() {
        if (this.x) {
            this.f.a();
            if (this.y) {
                this.n.a(this);
            }
        }
        if (this.H()) {
            this.f.b();
        } else {
            this.f.e();
        }
        boolean bl2 = this.E;
        boolean bl3 = false;
        boolean bl4 = bl2 || this.F;
        u u2 = this.D;
        bl2 = !(!this.t || this.z == null || !this.x && !bl4 && !this.n.u || this.x && !this.m.b());
        u2.j = bl2;
        u2 = this.D;
        bl2 = bl3;
        if (this.D.j) {
            bl2 = bl3;
            if (bl4) {
                bl2 = bl3;
                if (!this.x) {
                    bl2 = bl3;
                    if (this.H()) {
                        bl2 = true;
                    }
                }
            }
        }
        u2.k = bl2;
    }

    private void J() {
        boolean bl2 = this.ay;
        Object object = null;
        Object object2 = bl2 && this.hasFocus() && this.m != null ? this.getFocusedChild() : null;
        if ((object2 = object2 == null ? object : this.d((View)object2)) == null) {
            this.K();
            return;
        }
        object = this.D;
        long l2 = this.m.b() ? ((x)object2).g() : -1L;
        ((u)object).m = l2;
        object = this.D;
        int n2 = this.x ? -1 : (((x)object2).q() ? ((x)object2).d : ((x)object2).e());
        ((u)object).l = n2;
        this.D.n = this.m(((x)object2).a);
    }

    private void K() {
        this.D.m = -1L;
        this.D.l = -1;
        this.D.n = -1;
    }

    private View L() {
        x x2;
        int n2 = this.D.l != -1 ? this.D.l : 0;
        int n3 = this.D.e();
        for (int i2 = n2; i2 < n3 && (x2 = this.d(i2)) != null; ++i2) {
            if (!x2.a.hasFocusable()) continue;
            return x2.a;
        }
        for (n2 = Math.min((int)n3, (int)n2) - 1; n2 >= 0; --n2) {
            x2 = this.d(n2);
            if (x2 == null) {
                return null;
            }
            if (!x2.a.hasFocusable()) continue;
            return x2.a;
        }
        return null;
    }

    private void M() {
        if (this.ay && this.m != null && this.hasFocus() && this.getDescendantFocusability() != 393216) {
            Object object;
            if (this.getDescendantFocusability() == 131072 && this.isFocused()) {
                return;
            }
            if (!this.isFocused()) {
                object = this.getFocusedChild();
                if (P && (object.getParent() == null || !object.hasFocus())) {
                    if (this.g.b() == 0) {
                        this.requestFocus();
                        return;
                    }
                } else if (!this.g.c((View)object)) {
                    return;
                }
            }
            long l2 = this.D.m;
            View view = null;
            object = l2 != -1L && this.m.b() ? this.a(this.D.m) : null;
            if (object != null && !this.g.c(object.a) && object.a.hasFocusable()) {
                object = object.a;
            } else {
                object = view;
                if (this.g.b() > 0) {
                    object = this.L();
                }
            }
            if (object != null) {
                if ((long)this.D.n != -1L && (view = object.findViewById(this.D.n)) != null && view.isFocusable()) {
                    object = view;
                }
                object.requestFocus();
            }
        }
    }

    private void N() {
        int n2;
        int n3;
        f.c c2;
        Object object = this.D;
        boolean bl2 = true;
        ((u)object).a(1);
        this.a(this.D);
        this.D.i = false;
        this.f();
        this.h.a();
        this.m();
        this.I();
        this.J();
        object = this.D;
        if (!this.D.j || !this.F) {
            bl2 = false;
        }
        ((u)object).h = bl2;
        this.F = false;
        this.E = false;
        this.D.g = this.D.k;
        this.D.e = this.m.a();
        this.a(this.aD);
        if (this.D.j) {
            n3 = this.g.b();
            for (n2 = 0; n2 < n3; ++n2) {
                object = RecyclerView.e(this.g.b(n2));
                if (((x)object).c() || ((x)object).n() && !this.m.b()) continue;
                c2 = this.z.a(this.D, (x)object, f.e((x)object), ((x)object).u());
                this.h.a((x)object, c2);
                if (!this.D.h || !((x)object).z() || ((x)object).q() || ((x)object).c() || ((x)object).n()) continue;
                long l2 = this.a((x)object);
                this.h.a(l2, (x)object);
            }
        }
        if (this.D.k) {
            this.t();
            bl2 = this.D.f;
            this.D.f = false;
            this.n.c(this.e, this.D);
            this.D.f = bl2;
            for (n2 = 0; n2 < this.g.b(); ++n2) {
                object = RecyclerView.e(this.g.b(n2));
                if (((x)object).c() || this.h.d((x)object)) continue;
                int n4 = f.e((x)object);
                bl2 = ((x)object).a(8192);
                n3 = n4;
                if (!bl2) {
                    n3 = n4 | 4096;
                }
                c2 = this.z.a(this.D, (x)object, n3, ((x)object).u());
                if (bl2) {
                    this.a((x)object, c2);
                    continue;
                }
                this.h.b((x)object, c2);
            }
        }
        this.u();
        this.n();
        this.a(false);
        this.D.d = 2;
    }

    private void O() {
        this.f();
        this.m();
        this.D.a(6);
        this.f.e();
        this.D.e = this.m.a();
        this.D.c = 0;
        this.D.g = false;
        this.n.c(this.e, this.D);
        this.D.f = false;
        this.S = null;
        u u2 = this.D;
        boolean bl2 = this.D.j && this.z != null;
        u2.j = bl2;
        this.D.d = 4;
        this.n();
        this.a(false);
    }

    private void P() {
        this.D.a(4);
        this.f();
        this.m();
        this.D.d = 1;
        if (this.D.j) {
            for (int i2 = this.g.b() - 1; i2 >= 0; --i2) {
                x x2 = RecyclerView.e(this.g.b(i2));
                if (x2.c()) continue;
                long l2 = this.a(x2);
                f.c c2 = this.z.a(this.D, x2);
                x x3 = this.h.a(l2);
                if (x3 != null && !x3.c()) {
                    boolean bl2 = this.h.a(x3);
                    boolean bl3 = this.h.a(x2);
                    if (!bl2 || x3 != x2) {
                        f.c c3 = this.h.b(x3);
                        this.h.c(x2, c2);
                        c2 = this.h.c(x2);
                        if (c3 == null) {
                            this.a(l2, x2, x3);
                            continue;
                        }
                        this.a(x3, x2, c3, c2, bl2, bl3);
                        continue;
                    }
                }
                this.h.c(x2, c2);
            }
            this.h.a(this.aI);
        }
        this.n.b(this.e);
        this.D.b = this.D.e;
        this.x = false;
        this.y = false;
        this.D.j = false;
        this.D.k = false;
        this.n.u = false;
        if (this.e.b != null) {
            this.e.b.clear();
        }
        if (this.n.y) {
            this.n.x = 0;
            this.n.y = false;
            this.e.b();
        }
        this.n.a(this.D);
        this.n();
        this.a(false);
        this.h.a();
        if (this.k(this.aD[0], this.aD[1])) {
            this.i(0, 0);
        }
        this.M();
        this.K();
    }

    private String a(Context object, String string2) {
        if (string2.charAt(0) == '.') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object.getPackageName());
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        if (string2.contains(".")) {
            return string2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(RecyclerView.class.getPackage().getName());
        ((StringBuilder)object).append('.');
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(float var1_1, float var2_2, float var3_3, float var4_4) {
        block6 : {
            var8_5 = true;
            if (!(var2_2 < 0.0f)) break block6;
            this.h();
            var9_6 = this.ah;
            var6_7 = -var2_2 / (float)this.getWidth();
            var5_9 = 1.0f - var3_3 / (float)this.getHeight();
            var3_3 = var6_7;
            ** GOTO lbl17
        }
        if (var2_2 > 0.0f) {
            this.i();
            var9_6 = this.aj;
            var5_9 = var2_2 / (float)this.getWidth();
            var6_8 = var3_3 / (float)this.getHeight();
            var3_3 = var5_9;
            var5_9 = var6_8;
lbl17: // 2 sources:
            androidx.core.widget.d.a(var9_6, var3_3, var5_9);
            var7_10 = true;
        } else {
            var7_10 = false;
        }
        if (var4_4 < 0.0f) {
            this.j();
            androidx.core.widget.d.a(this.ai, -var4_4 / (float)this.getHeight(), var1_1 / (float)this.getWidth());
            var7_10 = var8_5;
        } else if (var4_4 > 0.0f) {
            this.k();
            androidx.core.widget.d.a(this.ak, var4_4 / (float)this.getHeight(), 1.0f - var1_1 / (float)this.getWidth());
            var7_10 = var8_5;
        }
        if (!var7_10 && var2_2 == 0.0f) {
            if (var4_4 == 0.0f) return;
        }
        androidx.core.h.t.d((View)this);
    }

    private void a(long l2, x x2, x object) {
        Object object2;
        int n2 = this.g.b();
        for (int i2 = 0; i2 < n2; ++i2) {
            object2 = RecyclerView.e(this.g.b(i2));
            if (object2 == x2 || this.a((x)object2) != l2) continue;
            if (this.m != null && this.m.b()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(" \n View Holder 2:");
                ((StringBuilder)object).append(x2);
                ((StringBuilder)object).append(this.a());
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(" \n View Holder 2:");
            ((StringBuilder)object).append(x2);
            ((StringBuilder)object).append(this.a());
            throw new IllegalStateException(((StringBuilder)object).toString());
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" cannot be found but it is necessary for ");
        ((StringBuilder)object2).append(x2);
        ((StringBuilder)object2).append(this.a());
        Log.e((String)"RecyclerView", (String)((StringBuilder)object2).toString());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private void a(Context arrobject, String object, AttributeSet attributeSet, int n2, int n3) {
        block11 : {
            if (object == null || (object = object.trim()).isEmpty()) break block11;
            string2 = this.a((Context)arrobject, (String)object);
            object = this.isInEditMode() != false ? this.getClass().getClassLoader() : arrobject.getClassLoader();
            class_ = object.loadClass(string2).asSubclass(i.class);
            var6_16 = null;
            object = class_.getConstructor(RecyclerView.Q);
            arrobject = new Object[]{arrobject, attributeSet, n2, n3};
            ** GOTO lbl23
            {
                catch (NoSuchMethodException noSuchMethodException222) {
                    try {
                        try {
                            object = class_.getConstructor(new Class[0]);
                            arrobject = var6_16;
                        }
                        catch (NoSuchMethodException noSuchMethodException3) {
                            noSuchMethodException3.initCause(noSuchMethodException222);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(attributeSet.getPositionDescription());
                            stringBuilder.append(": Error creating LayoutManager ");
                            stringBuilder.append(string2);
                            throw new IllegalStateException(stringBuilder.toString(), noSuchMethodException3);
                        }
lbl23: // 2 sources:
                        object.setAccessible(true);
                        this.setLayoutManager(object.newInstance(arrobject));
                        return;
                    }
                    catch (ClassCastException classCastException) {
                        object = new StringBuilder();
                        object.append(attributeSet.getPositionDescription());
                        object.append(": Class is not a LayoutManager ");
                        object.append(string2);
                        throw new IllegalStateException(object.toString(), classCastException);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        object = new StringBuilder();
                        object.append(attributeSet.getPositionDescription());
                        object.append(": Cannot access non-public constructor ");
                        object.append(string2);
                        throw new IllegalStateException(object.toString(), illegalAccessException);
                    }
                    catch (InstantiationException instantiationException) {
                        object = new StringBuilder();
                        object.append(attributeSet.getPositionDescription());
                        object.append(": Could not instantiate the LayoutManager: ");
                        object.append(string2);
                        throw new IllegalStateException(object.toString(), instantiationException);
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        object = new StringBuilder();
                        object.append(attributeSet.getPositionDescription());
                        object.append(": Could not instantiate the LayoutManager: ");
                        object.append(string2);
                        throw new IllegalStateException(object.toString(), invocationTargetException);
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        object = new StringBuilder();
                        object.append(attributeSet.getPositionDescription());
                        object.append(": Unable to find LayoutManager ");
                        object.append(string2);
                        throw new IllegalStateException(object.toString(), classNotFoundException);
                    }
                }
            }
        }
    }

    private void a(View view, View view2) {
        Rect rect;
        Object object = view2 != null ? view2 : view;
        this.k.set(0, 0, object.getWidth(), object.getHeight());
        object = object.getLayoutParams();
        if (object instanceof j) {
            object = (j)((Object)object);
            if (!((j)object).e) {
                object = ((j)object).d;
                rect = this.k;
                rect.left -= ((Rect)object).left;
                rect = this.k;
                rect.right += ((Rect)object).right;
                rect = this.k;
                rect.top -= ((Rect)object).top;
                rect = this.k;
                rect.bottom += ((Rect)object).bottom;
            }
        }
        if (view2 != null) {
            this.offsetDescendantRectToMyCoords(view2, this.k);
            this.offsetRectIntoDescendantCoords(view, this.k);
        }
        object = this.n;
        rect = this.k;
        boolean bl2 = this.t;
        boolean bl3 = view2 == null;
        ((i)object).a(this, view, rect, bl2 ^ true, bl3);
    }

    private void a(a a2, boolean bl2, boolean bl3) {
        if (this.m != null) {
            this.m.b(this.R);
            this.m.b(this);
        }
        if (!bl2 || bl3) {
            this.c();
        }
        this.f.a();
        a a3 = this.m;
        this.m = a2;
        if (a2 != null) {
            a2.a(this.R);
            a2.a(this);
        }
        if (this.n != null) {
            this.n.a(a3, this.m);
        }
        this.e.a(a3, this.m, bl2);
        this.D.f = true;
    }

    private void a(x x2, x x3, f.c c2, f.c c3, boolean bl2, boolean bl3) {
        x2.a(false);
        if (bl2) {
            this.e(x2);
        }
        if (x2 != x3) {
            if (bl3) {
                this.e(x3);
            }
            x2.h = x3;
            this.e(x2);
            this.e.c(x2);
            x3.a(false);
            x3.i = x2;
        }
        if (this.z.a(x2, x3, c2, c3)) {
            this.q();
        }
    }

    private void a(int[] arrn) {
        int n2 = this.g.b();
        if (n2 == 0) {
            arrn[0] = -1;
            arrn[1] = -1;
            return;
        }
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n5;
            x x2 = RecyclerView.e(this.g.b(i2));
            if (x2.c()) {
                n5 = n4;
            } else {
                int n6 = x2.d();
                int n7 = n3;
                if (n6 < n3) {
                    n7 = n6;
                }
                n3 = n7;
                n5 = n4;
                if (n6 > n4) {
                    n5 = n6;
                    n3 = n7;
                }
            }
            n4 = n5;
        }
        arrn[0] = n3;
        arrn[1] = n4;
    }

    private boolean a(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 == 3 || n2 == 0) {
            this.V = null;
        }
        int n3 = this.U.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            m m2 = this.U.get(i2);
            if (!m2.a(this, motionEvent) || n2 == 3) continue;
            this.V = m2;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(View object, View view, int n2) {
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = bl6;
        if (view == null) return bl8;
        if (view == this) {
            return false;
        }
        if (this.c(view) == null) {
            return false;
        }
        if (object == null) {
            return true;
        }
        if (this.c((View)object) == null) {
            return true;
        }
        this.k.set(0, 0, object.getWidth(), object.getHeight());
        this.T.set(0, 0, view.getWidth(), view.getHeight());
        this.offsetDescendantRectToMyCoords((View)object, this.k);
        this.offsetDescendantRectToMyCoords(view, this.T);
        int n3 = this.n.t();
        int n4 = -1;
        int n5 = n3 == 1 ? -1 : 1;
        n3 = (this.k.left < this.T.left || this.k.right <= this.T.left) && this.k.right < this.T.right ? 1 : ((this.k.right > this.T.right || this.k.left >= this.T.right) && this.k.left > this.T.left ? -1 : 0);
        if ((this.k.top < this.T.top || this.k.bottom <= this.T.top) && this.k.bottom < this.T.bottom) {
            n4 = 1;
        } else if (this.k.bottom <= this.T.bottom && this.k.top < this.T.bottom || this.k.top <= this.T.top) {
            n4 = 0;
        }
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 != 130) {
                        switch (n2) {
                            default: {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Invalid direction: ");
                                ((StringBuilder)object).append(n2);
                                ((StringBuilder)object).append(this.a());
                                throw new IllegalArgumentException(((StringBuilder)object).toString());
                            }
                            case 2: {
                                if (n4 > 0) return true;
                                bl8 = bl7;
                                if (n4 != 0) return bl8;
                                bl8 = bl7;
                                if (n3 * n5 < 0) return bl8;
                                return true;
                            }
                            case 1: 
                        }
                        if (n4 < 0) return true;
                        bl8 = bl2;
                        if (n4 != 0) return bl8;
                        bl8 = bl2;
                        if (n3 * n5 > 0) return bl8;
                        return true;
                    }
                    bl8 = bl3;
                    if (n4 <= 0) return bl8;
                    return true;
                }
                bl8 = bl4;
                if (n3 <= 0) return bl8;
                return true;
            }
            bl8 = bl5;
            if (n4 >= 0) return bl8;
            return true;
        }
        bl8 = bl6;
        if (n3 >= 0) return bl8;
        return true;
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }

    static void b(View view, Rect rect) {
        j j2 = (j)view.getLayoutParams();
        Rect rect2 = j2.d;
        rect.set(view.getLeft() - rect2.left - j2.leftMargin, view.getTop() - rect2.top - j2.topMargin, view.getRight() + rect2.right + j2.rightMargin, view.getBottom() + rect2.bottom + j2.bottomMargin);
    }

    private boolean b(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (this.V != null) {
            if (n2 == 0) {
                this.V = null;
            } else {
                this.V.b(this, motionEvent);
                if (n2 == 3 || n2 == 1) {
                    this.V = null;
                }
                return true;
            }
        }
        if (n2 != 0) {
            int n3 = this.U.size();
            for (n2 = 0; n2 < n3; ++n2) {
                m m2 = this.U.get(n2);
                if (!m2.a(this, motionEvent)) continue;
                this.V = m2;
                return true;
            }
        }
        return false;
    }

    private void c(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n2) == this.am) {
            int n3;
            n2 = n2 == 0 ? 1 : 0;
            this.am = motionEvent.getPointerId(n2);
            this.aq = n3 = (int)(motionEvent.getX(n2) + 0.5f);
            this.ao = n3;
            this.ar = n2 = (int)(motionEvent.getY(n2) + 0.5f);
            this.ap = n2;
        }
    }

    static void c(x x2) {
        if (x2.b != null) {
            Object object = x2.b.get();
            block0 : do {
                object = (View)object;
                while (object != null) {
                    if (object == x2.a) {
                        return;
                    }
                    if ((object = object.getParent()) instanceof View) continue block0;
                    object = null;
                }
                break;
            } while (true);
            x2.b = null;
        }
    }

    static x e(View view) {
        if (view == null) {
            return null;
        }
        return ((j)view.getLayoutParams()).c;
    }

    private void e(x x2) {
        View view = x2.a;
        boolean bl2 = view.getParent() == this;
        this.e.c(this.b(view));
        if (x2.r()) {
            this.g.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!bl2) {
            this.g.a(view, true);
            return;
        }
        this.g.d(view);
    }

    private androidx.core.h.l getScrollingChildHelper() {
        if (this.aE == null) {
            this.aE = new androidx.core.h.l((View)this);
        }
        return this.aE;
    }

    static RecyclerView j(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView)view;
        }
        view = (ViewGroup)view;
        int n2 = view.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            RecyclerView recyclerView = RecyclerView.j(view.getChildAt(i2));
            if (recyclerView == null) continue;
            return recyclerView;
        }
        return null;
    }

    private boolean k(int n2, int n3) {
        this.a(this.aD);
        int[] arrn = this.aD;
        boolean bl2 = false;
        if (arrn[0] != n2 || this.aD[1] != n3) {
            bl2 = true;
        }
        return bl2;
    }

    private int m(View view) {
        int n2;
        block0 : do {
            n2 = view.getId();
            while (!view.isFocused() && view instanceof ViewGroup && view.hasFocus()) {
                View view2;
                view = view2 = ((ViewGroup)view).getFocusedChild();
                if (view2.getId() == -1) continue;
                view = view2;
                continue block0;
            }
            break;
        } while (true);
        return n2;
    }

    @SuppressLint(value={"InlinedApi"})
    private void z() {
        if (androidx.core.h.t.a((View)this) == 0) {
            androidx.core.h.t.a((View)this, 8);
        }
    }

    long a(x x2) {
        if (this.m.b()) {
            return x2.g();
        }
        return x2.c;
    }

    public View a(float f2, float f3) {
        for (int i2 = this.g.b() - 1; i2 >= 0; --i2) {
            View view = this.g.b(i2);
            float f4 = view.getTranslationX();
            float f5 = view.getTranslationY();
            if (!(f2 >= (float)view.getLeft() + f4) || !(f2 <= (float)view.getRight() + f4) || !(f3 >= (float)view.getTop() + f5) || !(f3 <= (float)view.getBottom() + f5)) continue;
            return view;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    x a(int var1_1, boolean var2_2) {
        var4_3 = this.g.c();
        var5_4 = null;
        var3_5 = 0;
        while (var3_5 < var4_3) {
            block3 : {
                block4 : {
                    var7_7 = RecyclerView.e(this.g.d(var3_5));
                    var6_6 = var5_4;
                    if (var7_7 == null) break block3;
                    var6_6 = var5_4;
                    if (var7_7.q()) break block3;
                    if (!var2_2) break block4;
                    if (var7_7.c == var1_1) ** GOTO lbl-1000
                    var6_6 = var5_4;
                    break block3;
                }
                if (var7_7.d() != var1_1) {
                    var6_6 = var5_4;
                } else lbl-1000: // 2 sources:
                {
                    if (this.g.c(var7_7.a) == false) return var7_7;
                    var6_6 = var7_7;
                }
            }
            ++var3_5;
            var5_4 = var6_6;
        }
        return var5_4;
    }

    public x a(long l2) {
        Object object = this.m;
        Object object2 = null;
        Object object3 = null;
        if (object != null) {
            if (!this.m.b()) {
                return null;
            }
            int n2 = this.g.c();
            int n3 = 0;
            do {
                object2 = object3;
                if (n3 >= n2) break;
                object = RecyclerView.e(this.g.d(n3));
                object2 = object3;
                if (object != null) {
                    object2 = object3;
                    if (!((x)object).q()) {
                        object2 = object3;
                        if (((x)object).g() == l2) {
                            if (this.g.c(((x)object).a)) {
                                object2 = object;
                            } else {
                                return object;
                            }
                        }
                    }
                }
                ++n3;
                object3 = object2;
            } while (true);
        }
        return object2;
    }

    String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(super.toString());
        stringBuilder.append(", adapter:");
        stringBuilder.append(this.m);
        stringBuilder.append(", layout:");
        stringBuilder.append(this.n);
        stringBuilder.append(", context:");
        stringBuilder.append((Object)this.getContext());
        return stringBuilder.toString();
    }

    @Override
    public void a(int n2) {
        this.getScrollingChildHelper().c(n2);
    }

    public void a(int n2, int n3) {
        this.a(n2, n3, (Interpolator)null);
    }

    public void a(int n2, int n3, Interpolator interpolator) {
        if (this.n == null) {
            Log.e((String)"RecyclerView", (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.v) {
            return;
        }
        if (!this.n.e()) {
            n2 = 0;
        }
        if (!this.n.f()) {
            n3 = 0;
        }
        if (n2 != 0 || n3 != 0) {
            this.A.a(n2, n3, interpolator);
        }
    }

    void a(int n2, int n3, Object object) {
        int n4 = this.g.c();
        for (int i2 = 0; i2 < n4; ++i2) {
            View view = this.g.d(i2);
            x x2 = RecyclerView.e(view);
            if (x2 == null || x2.c() || x2.c < n2 || x2.c >= n2 + n3) continue;
            x2.b(2);
            x2.a(object);
            ((j)view.getLayoutParams()).e = true;
        }
        this.e.c(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(int n2, int n3, boolean bl2) {
        int n4 = this.g.c();
        int n5 = 0;
        do {
            block5 : {
                block7 : {
                    x x2;
                    block6 : {
                        if (n5 >= n4) {
                            this.e.a(n2, n3, bl2);
                            this.requestLayout();
                            return;
                        }
                        x2 = RecyclerView.e(this.g.d(n5));
                        if (x2 == null || x2.c()) break block5;
                        if (x2.c < n2 + n3) break block6;
                        x2.a(-n3, bl2);
                        break block7;
                    }
                    if (x2.c < n2) break block5;
                    x2.a(n2 - 1, -n3, bl2);
                }
                this.D.f = true;
            }
            ++n5;
        } while (true);
    }

    void a(int n2, int n3, int[] arrn) {
        this.f();
        this.m();
        androidx.core.d.a.a("RV Scroll");
        this.a(this.D);
        n2 = n2 != 0 ? this.n.a(n2, this.e, this.D) : 0;
        n3 = n3 != 0 ? this.n.b(n3, this.e, this.D) : 0;
        androidx.core.d.a.a();
        this.x();
        this.n();
        this.a(false);
        if (arrn != null) {
            arrn[0] = n2;
            arrn[1] = n3;
        }
    }

    void a(StateListDrawable object, Drawable drawable2, StateListDrawable stateListDrawable, Drawable drawable3) {
        if (object != null && drawable2 != null && stateListDrawable != null && drawable3 != null) {
            Resources resources = this.getContext().getResources();
            new androidx.recyclerview.widget.e(this, (StateListDrawable)object, drawable2, stateListDrawable, drawable3, resources.getDimensionPixelSize(a.a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.a.fastscroll_margin));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Trying to set fast scroller without both required drawables.");
        ((StringBuilder)object).append(this.a());
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void a(View view, Rect rect) {
        RecyclerView.b(view, rect);
    }

    public void a(h h2) {
        this.a(h2, -1);
    }

    public void a(h h2, int n2) {
        if (this.n != null) {
            this.n.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            this.setWillNotDraw(false);
        }
        if (n2 < 0) {
            this.p.add(h2);
        } else {
            this.p.add(n2, h2);
        }
        this.s();
        this.requestLayout();
    }

    public void a(k k2) {
        if (this.ad == null) {
            this.ad = new ArrayList<k>();
        }
        this.ad.add(k2);
    }

    public void a(m m2) {
        this.U.add(m2);
    }

    public void a(n n2) {
        if (this.aA == null) {
            this.aA = new ArrayList<n>();
        }
        this.aA.add(n2);
    }

    final void a(u u2) {
        if (this.getScrollState() == 2) {
            OverScroller overScroller = this.A.a;
            u2.o = overScroller.getFinalX() - overScroller.getCurrX();
            u2.p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        u2.o = 0;
        u2.p = 0;
    }

    void a(x x2, f.c c2) {
        x2.a(0, 8192);
        if (this.D.h && x2.z() && !x2.q() && !x2.c()) {
            long l2 = this.a(x2);
            this.h.a(l2, x2);
        }
        this.h.a(x2, c2);
    }

    void a(x x2, f.c c2, f.c c3) {
        x2.a(false);
        if (this.z.b(x2, c2, c3)) {
            this.q();
        }
    }

    void a(String charSequence) {
        if (this.p()) {
            if (charSequence == null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                ((StringBuilder)charSequence).append(this.a());
                throw new IllegalStateException(((StringBuilder)charSequence).toString());
            }
            throw new IllegalStateException((String)charSequence);
        }
        if (this.af > 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("");
            ((StringBuilder)charSequence).append(this.a());
            Log.w((String)"RecyclerView", (String)"Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", (Throwable)new IllegalStateException(((StringBuilder)charSequence).toString()));
        }
    }

    void a(boolean bl2) {
        if (this.W < 1) {
            this.W = 1;
        }
        if (!bl2 && !this.v) {
            this.u = false;
        }
        if (this.W == 1) {
            if (bl2 && this.u && !this.v && this.n != null && this.m != null) {
                this.r();
            }
            if (!this.v) {
                this.u = false;
            }
        }
        --this.W;
    }

    public boolean a(int n2, int n3, int n4, int n5, int[] arrn, int n6) {
        return this.getScrollingChildHelper().a(n2, n3, n4, n5, arrn, n6);
    }

    boolean a(int n2, int n3, MotionEvent arrn) {
        int n4;
        int n5;
        int n6;
        int n7;
        this.e();
        a a2 = this.m;
        boolean bl2 = false;
        if (a2 != null) {
            this.a(n2, n3, this.J);
            n4 = this.J[0];
            n6 = this.J[1];
            n5 = n4;
            n7 = n6;
            n4 = n2 - n4;
            n6 = n3 - n6;
        } else {
            n6 = 0;
            n5 = 0;
            n7 = 0;
            n4 = 0;
        }
        if (!this.p.isEmpty()) {
            this.invalidate();
        }
        if (this.a(n5, n7, n4, n6, this.aF, 0)) {
            this.aq -= this.aF[0];
            this.ar -= this.aF[1];
            if (arrn != null) {
                arrn.offsetLocation((float)this.aF[0], (float)this.aF[1]);
            }
            arrn = this.aG;
            arrn[0] = arrn[0] + this.aF[0];
            arrn = this.aG;
            arrn[1] = arrn[1] + this.aF[1];
        } else if (this.getOverScrollMode() != 2) {
            if (arrn != null && !androidx.core.h.i.e((MotionEvent)arrn, 8194)) {
                this.a(arrn.getX(), n4, arrn.getY(), n6);
            }
            this.c(n2, n3);
        }
        if (n5 != 0 || n7 != 0) {
            this.i(n5, n7);
        }
        if (!this.awakenScrollBars()) {
            this.invalidate();
        }
        if (n5 != 0 || n7 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean a(int n2, int n3, int[] arrn, int[] arrn2, int n4) {
        return this.getScrollingChildHelper().a(n2, n3, arrn, arrn2, n4);
    }

    boolean a(View object) {
        this.f();
        boolean bl2 = this.g.f((View)object);
        if (bl2) {
            object = RecyclerView.e(object);
            this.e.c((x)object);
            this.e.b((x)object);
        }
        this.a(bl2 ^ true);
        return bl2;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (this.p()) {
            int n2 = accessibilityEvent != null ? androidx.core.h.a.a.a(accessibilityEvent) : 0;
            int n3 = n2;
            if (n2 == 0) {
                n3 = 0;
            }
            this.ab = n3 | this.ab;
            return true;
        }
        return false;
    }

    boolean a(x x2, int n2) {
        if (this.p()) {
            x2.o = n2;
            this.K.add(x2);
            return false;
        }
        androidx.core.h.t.b(x2.a, n2);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int n2, int n3) {
        if (this.n == null || !this.n.a(this, arrayList, n2, n3)) {
            super.addFocusables(arrayList, n2, n3);
        }
    }

    public x b(View view) {
        Object object = view.getParent();
        if (object != null && object != this) {
            object = new StringBuilder();
            ((StringBuilder)object).append("View ");
            ((StringBuilder)object).append((Object)view);
            ((StringBuilder)object).append(" is not a direct child of ");
            ((StringBuilder)object).append(this);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        return RecyclerView.e(view);
    }

    void b() {
        this.f = new androidx.recyclerview.widget.a(new a.a(){

            @Override
            public x a(int n2) {
                x x2 = RecyclerView.this.a(n2, true);
                if (x2 == null) {
                    return null;
                }
                if (RecyclerView.this.g.c(x2.a)) {
                    return null;
                }
                return x2;
            }

            @Override
            public void a(int n2, int n3) {
                RecyclerView.this.a(n2, n3, true);
                RecyclerView.this.E = true;
                u u2 = RecyclerView.this.D;
                u2.c += n3;
            }

            @Override
            public void a(int n2, int n3, Object object) {
                RecyclerView.this.a(n2, n3, object);
                RecyclerView.this.F = true;
            }

            @Override
            public void a(a.b b2) {
                this.c(b2);
            }

            @Override
            public void b(int n2, int n3) {
                RecyclerView.this.a(n2, n3, false);
                RecyclerView.this.E = true;
            }

            @Override
            public void b(a.b b2) {
                this.c(b2);
            }

            @Override
            public void c(int n2, int n3) {
                RecyclerView.this.g(n2, n3);
                RecyclerView.this.E = true;
            }

            void c(a.b b2) {
                int n2 = b2.a;
                if (n2 != 4) {
                    if (n2 != 8) {
                        switch (n2) {
                            default: {
                                return;
                            }
                            case 2: {
                                RecyclerView.this.n.b(RecyclerView.this, b2.b, b2.d);
                                return;
                            }
                            case 1: 
                        }
                        RecyclerView.this.n.a(RecyclerView.this, b2.b, b2.d);
                        return;
                    }
                    RecyclerView.this.n.a(RecyclerView.this, b2.b, b2.d, 1);
                    return;
                }
                RecyclerView.this.n.a(RecyclerView.this, b2.b, b2.d, b2.c);
            }

            @Override
            public void d(int n2, int n3) {
                RecyclerView.this.f(n2, n3);
                RecyclerView.this.E = true;
            }
        });
    }

    public void b(int n2) {
        if (this.v) {
            return;
        }
        this.g();
        if (this.n == null) {
            Log.e((String)"RecyclerView", (String)"Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        this.n.e(n2);
        this.awakenScrollBars();
    }

    public void b(h h2) {
        if (this.n != null) {
            this.n.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(h2);
        if (this.p.isEmpty()) {
            boolean bl2 = this.getOverScrollMode() == 2;
            this.setWillNotDraw(bl2);
        }
        this.s();
        this.requestLayout();
    }

    public void b(k k2) {
        if (this.ad == null) {
            return;
        }
        this.ad.remove(k2);
    }

    public void b(m m2) {
        this.U.remove(m2);
        if (this.V == m2) {
            this.V = null;
        }
    }

    public void b(n n2) {
        if (this.aA != null) {
            this.aA.remove(n2);
        }
    }

    void b(x x2, f.c c2, f.c c3) {
        this.e(x2);
        x2.a(false);
        if (this.z.a(x2, c2, c3)) {
            this.q();
        }
    }

    void b(boolean bl2) {
        --this.ae;
        if (this.ae < 1) {
            this.ae = 0;
            if (bl2) {
                this.G();
                this.y();
            }
        }
    }

    public boolean b(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        boolean bl2;
        boolean bl3;
        block17 : {
            block16 : {
                block15 : {
                    block14 : {
                        i i2 = this.n;
                        n5 = 0;
                        if (i2 == null) {
                            Log.e((String)"RecyclerView", (String)"Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                            return false;
                        }
                        if (this.v) {
                            return false;
                        }
                        bl3 = this.n.e();
                        bl2 = this.n.f();
                        if (!bl3) break block14;
                        n4 = n2;
                        if (Math.abs(n2) >= this.au) break block15;
                    }
                    n4 = 0;
                }
                if (!bl2) break block16;
                n6 = n3;
                if (Math.abs(n3) >= this.au) break block17;
            }
            n6 = 0;
        }
        if (n4 == 0 && n6 == 0) {
            return false;
        }
        float f2 = n4;
        float f3 = n6;
        if (!this.dispatchNestedPreFling(f2, f3)) {
            boolean bl4 = bl3 || bl2;
            this.dispatchNestedFling(f2, f3, bl4);
            if (this.at != null && this.at.a(n4, n6)) {
                return true;
            }
            if (bl4) {
                n2 = n5;
                if (bl3) {
                    n2 = 1;
                }
                n3 = n2;
                if (bl2) {
                    n3 = n2 | 2;
                }
                this.j(n3, 1);
                n2 = Math.max(-this.av, Math.min(n4, this.av));
                n3 = Math.max(-this.av, Math.min(n6, this.av));
                this.A.a(n2, n3);
                return true;
            }
        }
        return false;
    }

    boolean b(x x2) {
        return this.z == null || this.z.a(x2, x2.u());
        {
        }
    }

    public View c(View view) {
        ViewParent viewParent;
        while ((viewParent = view.getParent()) != null && viewParent != this && viewParent instanceof View) {
            view = (View)viewParent;
        }
        if (viewParent == this) {
            return view;
        }
        return null;
    }

    void c() {
        if (this.z != null) {
            this.z.d();
        }
        if (this.n != null) {
            this.n.c(this.e);
            this.n.b(this.e);
        }
        this.e.a();
    }

    void c(int n2) {
        if (this.n == null) {
            return;
        }
        this.n.e(n2);
        this.awakenScrollBars();
    }

    void c(int n2, int n3) {
        boolean bl2;
        if (this.ah != null && !this.ah.isFinished() && n2 > 0) {
            this.ah.onRelease();
            bl2 = this.ah.isFinished();
        } else {
            bl2 = false;
        }
        boolean bl3 = bl2;
        if (this.aj != null) {
            bl3 = bl2;
            if (!this.aj.isFinished()) {
                bl3 = bl2;
                if (n2 < 0) {
                    this.aj.onRelease();
                    bl3 = bl2 | this.aj.isFinished();
                }
            }
        }
        bl2 = bl3;
        if (this.ai != null) {
            bl2 = bl3;
            if (!this.ai.isFinished()) {
                bl2 = bl3;
                if (n3 > 0) {
                    this.ai.onRelease();
                    bl2 = bl3 | this.ai.isFinished();
                }
            }
        }
        bl3 = bl2;
        if (this.ak != null) {
            bl3 = bl2;
            if (!this.ak.isFinished()) {
                bl3 = bl2;
                if (n3 < 0) {
                    this.ak.onRelease();
                    bl3 = bl2 | this.ak.isFinished();
                }
            }
        }
        if (bl3) {
            androidx.core.h.t.d((View)this);
        }
    }

    void c(boolean bl2) {
        this.y = bl2 | this.y;
        this.x = true;
        this.v();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j && this.n.a((j)layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        i i2 = this.n;
        int n2 = 0;
        if (i2 == null) {
            return 0;
        }
        if (this.n.e()) {
            n2 = this.n.e(this.D);
        }
        return n2;
    }

    public int computeHorizontalScrollOffset() {
        i i2 = this.n;
        int n2 = 0;
        if (i2 == null) {
            return 0;
        }
        if (this.n.e()) {
            n2 = this.n.c(this.D);
        }
        return n2;
    }

    public int computeHorizontalScrollRange() {
        i i2 = this.n;
        int n2 = 0;
        if (i2 == null) {
            return 0;
        }
        if (this.n.e()) {
            n2 = this.n.g(this.D);
        }
        return n2;
    }

    public int computeVerticalScrollExtent() {
        i i2 = this.n;
        int n2 = 0;
        if (i2 == null) {
            return 0;
        }
        if (this.n.f()) {
            n2 = this.n.f(this.D);
        }
        return n2;
    }

    public int computeVerticalScrollOffset() {
        i i2 = this.n;
        int n2 = 0;
        if (i2 == null) {
            return 0;
        }
        if (this.n.f()) {
            n2 = this.n.d(this.D);
        }
        return n2;
    }

    public int computeVerticalScrollRange() {
        i i2 = this.n;
        int n2 = 0;
        if (i2 == null) {
            return 0;
        }
        if (this.n.f()) {
            n2 = this.n.h(this.D);
        }
        return n2;
    }

    int d(x x2) {
        if (!x2.a(524) && x2.p()) {
            return this.f.c(x2.c);
        }
        return -1;
    }

    public x d(int n2) {
        boolean bl2 = this.x;
        x x2 = null;
        if (bl2) {
            return null;
        }
        int n3 = this.g.c();
        for (int i2 = 0; i2 < n3; ++i2) {
            x x3 = RecyclerView.e(this.g.d(i2));
            x x4 = x2;
            if (x3 != null) {
                x4 = x2;
                if (!x3.q()) {
                    x4 = x2;
                    if (this.d(x3) == n2) {
                        if (this.g.c(x3.a)) {
                            x4 = x3;
                        } else {
                            return x3;
                        }
                    }
                }
            }
            x2 = x4;
        }
        return x2;
    }

    public x d(View view) {
        if ((view = this.c(view)) == null) {
            return null;
        }
        return this.b(view);
    }

    public void d() {
        if (this.aA != null) {
            this.aA.clear();
        }
    }

    void d(int n2, int n3) {
        if (n2 < 0) {
            this.h();
            this.ah.onAbsorb(-n2);
        } else if (n2 > 0) {
            this.i();
            this.aj.onAbsorb(n2);
        }
        if (n3 < 0) {
            this.j();
            this.ai.onAbsorb(-n3);
        } else if (n3 > 0) {
            this.k();
            this.ak.onAbsorb(n3);
        }
        if (n2 != 0 || n3 != 0) {
            androidx.core.h.t.d((View)this);
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean bl2) {
        return this.getScrollingChildHelper().a(f2, f3, bl2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.getScrollingChildHelper().a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.getScrollingChildHelper().a(n2, n3, arrn, arrn2);
    }

    public boolean dispatchNestedScroll(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.getScrollingChildHelper().a(n2, n3, n4, n5, arrn);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void draw(Canvas canvas) {
        int n2;
        int n3;
        super.draw(canvas);
        int n4 = this.p.size();
        int n5 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            this.p.get(n2).b(canvas, this, this.D);
        }
        if (this.ah != null && !this.ah.isFinished()) {
            n3 = canvas.save();
            n2 = this.i ? this.getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float)(-this.getHeight() + n2), 0.0f);
            n4 = this.ah != null && this.ah.draw(canvas) ? 1 : 0;
            canvas.restoreToCount(n3);
        } else {
            n4 = 0;
        }
        n2 = n4;
        if (this.ai != null) {
            n2 = n4;
            if (!this.ai.isFinished()) {
                n3 = canvas.save();
                if (this.i) {
                    canvas.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
                }
                n2 = this.ai != null && this.ai.draw(canvas) ? 1 : 0;
                n2 = n4 | n2;
                canvas.restoreToCount(n3);
            }
        }
        n4 = n2;
        if (this.aj != null) {
            n4 = n2;
            if (!this.aj.isFinished()) {
                n3 = canvas.save();
                int n6 = this.getWidth();
                n4 = this.i ? this.getPaddingTop() : 0;
                canvas.rotate(90.0f);
                canvas.translate((float)(-n4), (float)(-n6));
                n4 = this.aj != null && this.aj.draw(canvas) ? 1 : 0;
                n4 = n2 | n4;
                canvas.restoreToCount(n3);
            }
        }
        if (this.ak != null && !this.ak.isFinished()) {
            float f2;
            n3 = canvas.save();
            canvas.rotate(180.0f);
            if (this.i) {
                f2 = -this.getWidth() + this.getPaddingRight();
                n2 = -this.getHeight() + this.getPaddingBottom();
            } else {
                f2 = -this.getWidth();
                n2 = -this.getHeight();
            }
            canvas.translate(f2, (float)n2);
            n2 = n5;
            if (this.ak != null) {
                n2 = n5;
                if (this.ak.draw(canvas)) {
                    n2 = 1;
                }
            }
            n2 |= n4;
            canvas.restoreToCount(n3);
        } else {
            n2 = n4;
        }
        n4 = n2;
        if (n2 == 0) {
            n4 = n2;
            if (this.z != null) {
                n4 = n2;
                if (this.p.size() > 0) {
                    n4 = n2;
                    if (this.z.b()) {
                        n4 = 1;
                    }
                }
            }
        }
        if (n4 != 0) {
            androidx.core.h.t.d((View)this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l2) {
        return super.drawChild(canvas, view, l2);
    }

    void e() {
        block7 : {
            block10 : {
                block9 : {
                    block8 : {
                        if (!this.t || this.x) break block7;
                        if (!this.f.d()) {
                            return;
                        }
                        if (!this.f.a(4) || this.f.a(11)) break block8;
                        androidx.core.d.a.a("RV PartialInvalidate");
                        this.f();
                        this.m();
                        this.f.b();
                        if (!this.u) {
                            if (this.B()) {
                                this.r();
                            } else {
                                this.f.c();
                            }
                        }
                        this.a(true);
                        this.n();
                        break block9;
                    }
                    if (!this.f.d()) break block10;
                    androidx.core.d.a.a("RV FullInvalidate");
                    this.r();
                }
                androidx.core.d.a.a();
            }
            return;
        }
        androidx.core.d.a.a("RV FullInvalidate");
        this.r();
        androidx.core.d.a.a();
    }

    public void e(int n2) {
        int n3 = this.g.b();
        for (int i2 = 0; i2 < n3; ++i2) {
            this.g.b(i2).offsetTopAndBottom(n2);
        }
    }

    void e(int n2, int n3) {
        this.setMeasuredDimension(i.a(n2, this.getPaddingLeft() + this.getPaddingRight(), androidx.core.h.t.k((View)this)), i.a(n3, this.getPaddingTop() + this.getPaddingBottom(), androidx.core.h.t.l((View)this)));
    }

    public int f(View object) {
        if ((object = RecyclerView.e((View)object)) != null) {
            return ((x)object).d();
        }
        return -1;
    }

    void f() {
        ++this.W;
        if (this.W == 1 && !this.v) {
            this.u = false;
        }
    }

    public void f(int n2) {
        int n3 = this.g.b();
        for (int i2 = 0; i2 < n3; ++i2) {
            this.g.b(i2).offsetLeftAndRight(n2);
        }
    }

    void f(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = this.g.c();
        if (n2 < n3) {
            n5 = n2;
            n4 = n3;
            n6 = -1;
        } else {
            n4 = n2;
            n5 = n3;
            n6 = 1;
        }
        for (int i2 = 0; i2 < n7; ++i2) {
            x x2 = RecyclerView.e(this.g.d(i2));
            if (x2 == null || x2.c < n5 || x2.c > n4) continue;
            if (x2.c == n2) {
                x2.a(n3 - n2, false);
            } else {
                x2.a(n6, false);
            }
            this.D.f = true;
        }
        this.e.a(n2, n3);
        this.requestLayout();
    }

    public View focusSearch(View view, int n2) {
        View view2 = this.n.d(view, n2);
        if (view2 != null) {
            return view2;
        }
        int n3 = this.m != null && this.n != null && !this.p() && !this.v ? 1 : 0;
        view2 = FocusFinder.getInstance();
        if (n3 != 0 && (n2 == 2 || n2 == 1)) {
            int n4;
            int n5;
            if (this.n.f()) {
                n4 = n2 == 2 ? 130 : 33;
                n5 = view2.findNextFocus((ViewGroup)this, view, n4) == null ? 1 : 0;
                n3 = n5;
                if (O) {
                    n2 = n4;
                    n3 = n5;
                }
            } else {
                n3 = 0;
            }
            int n6 = n3;
            n5 = n2;
            if (n3 == 0) {
                n6 = n3;
                n5 = n2;
                if (this.n.e()) {
                    n3 = this.n.t() == 1 ? 1 : 0;
                    n4 = n2 == 2 ? 1 : 0;
                    n3 = (n3 ^ n4) != 0 ? 66 : 17;
                    n4 = view2.findNextFocus((ViewGroup)this, view, n3) == null ? 1 : 0;
                    n6 = n4;
                    n5 = n2;
                    if (O) {
                        n5 = n3;
                        n6 = n4;
                    }
                }
            }
            if (n6 != 0) {
                this.e();
                if (this.c(view) == null) {
                    return null;
                }
                this.f();
                this.n.a(view, n5, this.e, this.D);
                this.a(false);
            }
            view2 = view2.findNextFocus((ViewGroup)this, view, n5);
            n2 = n5;
        } else if ((view2 = view2.findNextFocus((ViewGroup)this, view, n2)) == null && n3 != 0) {
            this.e();
            if (this.c(view) == null) {
                return null;
            }
            this.f();
            view2 = this.n.a(view, n2, this.e, this.D);
            this.a(false);
        }
        if (view2 != null && !view2.hasFocusable()) {
            if (this.getFocusedChild() == null) {
                return super.focusSearch(view, n2);
            }
            this.a(view2, (View)null);
            return view;
        }
        if (this.a(view, view2, n2)) {
            return view2;
        }
        return super.focusSearch(view, n2);
    }

    public void g() {
        this.setScrollState(0);
        this.C();
    }

    public void g(int n2) {
    }

    void g(int n2, int n3) {
        int n4 = this.g.c();
        for (int i2 = 0; i2 < n4; ++i2) {
            x x2 = RecyclerView.e(this.g.d(i2));
            if (x2 == null || x2.c() || x2.c < n2) continue;
            x2.a(n3, false);
            this.D.f = true;
        }
        this.e.b(n2, n3);
        this.requestLayout();
    }

    public void g(View view) {
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.n != null) {
            return this.n.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(this.a());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet object) {
        if (this.n != null) {
            return this.n.a(this.getContext(), (AttributeSet)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("RecyclerView has no LayoutManager");
        ((StringBuilder)object).append(this.a());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        if (this.n != null) {
            return this.n.a((ViewGroup.LayoutParams)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("RecyclerView has no LayoutManager");
        ((StringBuilder)object).append(this.a());
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public a getAdapter() {
        return this.m;
    }

    public int getBaseline() {
        if (this.n != null) {
            return this.n.u();
        }
        return super.getBaseline();
    }

    protected int getChildDrawingOrder(int n2, int n3) {
        if (this.aC == null) {
            return super.getChildDrawingOrder(n2, n3);
        }
        return this.aC.a(n2, n3);
    }

    public boolean getClipToPadding() {
        return this.i;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.H;
    }

    public e getEdgeEffectFactory() {
        return this.ag;
    }

    public f getItemAnimator() {
        return this.z;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public i getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.av;
    }

    public int getMinFlingVelocity() {
        return this.au;
    }

    long getNanoTime() {
        if (d) {
            return System.nanoTime();
        }
        return 0L;
    }

    public l getOnFlingListener() {
        return this.at;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ay;
    }

    public o getRecycledViewPool() {
        return this.e.g();
    }

    public int getScrollState() {
        return this.al;
    }

    /*
     * Enabled aggressive block sorting
     */
    void h() {
        int n2;
        int n3;
        EdgeEffect edgeEffect;
        if (this.ah != null) {
            return;
        }
        this.ah = this.ag.a(this, 0);
        if (this.i) {
            edgeEffect = this.ah;
            n2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
            n3 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
        } else {
            edgeEffect = this.ah;
            n2 = this.getMeasuredHeight();
            n3 = this.getMeasuredWidth();
        }
        edgeEffect.setSize(n2, n3);
    }

    void h(int n2) {
        if (this.n != null) {
            this.n.l(n2);
        }
        this.g(n2);
        if (this.az != null) {
            this.az.a(this, n2);
        }
        if (this.aA != null) {
            for (int i2 = this.aA.size() - 1; i2 >= 0; --i2) {
                this.aA.get(i2).a(this, n2);
            }
        }
    }

    public void h(int n2, int n3) {
    }

    public void h(View view) {
    }

    public boolean hasNestedScrollingParent() {
        return this.getScrollingChildHelper().b();
    }

    Rect i(View view) {
        j j2 = (j)view.getLayoutParams();
        if (!j2.e) {
            return j2.d;
        }
        if (this.D.a() && (j2.e() || j2.c())) {
            return j2.d;
        }
        Rect rect = j2.d;
        rect.set(0, 0, 0, 0);
        int n2 = this.p.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.k.set(0, 0, 0, 0);
            this.p.get(i2).a(this.k, view, this, this.D);
            rect.left += this.k.left;
            rect.top += this.k.top;
            rect.right += this.k.right;
            rect.bottom += this.k.bottom;
        }
        j2.e = false;
        return rect;
    }

    /*
     * Enabled aggressive block sorting
     */
    void i() {
        int n2;
        int n3;
        EdgeEffect edgeEffect;
        if (this.aj != null) {
            return;
        }
        this.aj = this.ag.a(this, 2);
        if (this.i) {
            edgeEffect = this.aj;
            n2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
            n3 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
        } else {
            edgeEffect = this.aj;
            n2 = this.getMeasuredHeight();
            n3 = this.getMeasuredWidth();
        }
        edgeEffect.setSize(n2, n3);
    }

    void i(int n2, int n3) {
        ++this.af;
        int n4 = this.getScrollX();
        int n5 = this.getScrollY();
        this.onScrollChanged(n4, n5, n4, n5);
        this.h(n2, n3);
        if (this.az != null) {
            this.az.a(this, n2, n3);
        }
        if (this.aA != null) {
            for (n4 = this.aA.size() - 1; n4 >= 0; --n4) {
                this.aA.get(n4).a(this, n2, n3);
            }
        }
        --this.af;
    }

    public boolean i(int n2) {
        return this.getScrollingChildHelper().a(n2);
    }

    public boolean isAttachedToWindow() {
        return this.q;
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return this.getScrollingChildHelper().a();
    }

    /*
     * Enabled aggressive block sorting
     */
    void j() {
        int n2;
        int n3;
        EdgeEffect edgeEffect;
        if (this.ai != null) {
            return;
        }
        this.ai = this.ag.a(this, 1);
        if (this.i) {
            edgeEffect = this.ai;
            n2 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
            n3 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        } else {
            edgeEffect = this.ai;
            n2 = this.getMeasuredWidth();
            n3 = this.getMeasuredHeight();
        }
        edgeEffect.setSize(n2, n3);
    }

    public boolean j(int n2, int n3) {
        return this.getScrollingChildHelper().a(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    void k() {
        int n2;
        int n3;
        EdgeEffect edgeEffect;
        if (this.ak != null) {
            return;
        }
        this.ak = this.ag.a(this, 3);
        if (this.i) {
            edgeEffect = this.ak;
            n2 = this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
            n3 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        } else {
            edgeEffect = this.ak;
            n2 = this.getMeasuredWidth();
            n3 = this.getMeasuredHeight();
        }
        edgeEffect.setSize(n2, n3);
    }

    void k(View view) {
        x x2 = RecyclerView.e(view);
        this.h(view);
        if (this.m != null && x2 != null) {
            this.m.d(x2);
        }
        if (this.ad != null) {
            for (int i2 = this.ad.size() - 1; i2 >= 0; --i2) {
                this.ad.get(i2).b(view);
            }
        }
    }

    void l() {
        this.ak = null;
        this.ai = null;
        this.aj = null;
        this.ah = null;
    }

    void l(View view) {
        x x2 = RecyclerView.e(view);
        this.g(view);
        if (this.m != null && x2 != null) {
            this.m.c(x2);
        }
        if (this.ad != null) {
            for (int i2 = this.ad.size() - 1; i2 >= 0; --i2) {
                this.ad.get(i2).a(view);
            }
        }
    }

    void m() {
        ++this.ae;
    }

    void n() {
        this.b(true);
    }

    boolean o() {
        return this.ac != null && this.ac.isEnabled();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ae = 0;
        boolean bl2 = true;
        this.q = true;
        if (!this.t || this.isLayoutRequested()) {
            bl2 = false;
        }
        this.t = bl2;
        if (this.n != null) {
            this.n.c(this);
        }
        this.G = false;
        if (d) {
            this.B = androidx.recyclerview.widget.f.a.get();
            if (this.B == null) {
                float f2;
                this.B = new androidx.recyclerview.widget.f();
                Display display = androidx.core.h.t.D((View)this);
                if (this.isInEditMode() || display == null || !((f2 = display.getRefreshRate()) >= 30.0f)) {
                    f2 = 60.0f;
                }
                this.B.d = (long)(1.0E9f / f2);
                androidx.recyclerview.widget.f.a.set(this.B);
            }
            this.B.a(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.z != null) {
            this.z.d();
        }
        this.g();
        this.q = false;
        if (this.n != null) {
            this.n.b(this, this.e);
        }
        this.K.clear();
        this.removeCallbacks(this.aH);
        this.h.b();
        if (d && this.B != null) {
            this.B.b(this);
            this.B = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n2 = this.p.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.p.get(i2).a(canvas, this, this.D);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onGenericMotionEvent(MotionEvent var1_1) {
        block6 : {
            block7 : {
                block5 : {
                    if (this.n == null) {
                        return false;
                    }
                    if (this.v) {
                        return false;
                    }
                    if (var1_1.getAction() != 8) return false;
                    if ((var1_1.getSource() & 2) == 0) break block5;
                    var3_2 = this.n.f() != false ? -var1_1.getAxisValue(9) : 0.0f;
                    var2_3 = var3_2;
                    if (!this.n.e()) ** GOTO lbl25
                    var4_4 = var1_1.getAxisValue(10);
                    var2_3 = var3_2;
                    var3_2 = var4_4;
                    break block6;
                }
                if ((var1_1.getSource() & 4194304) == 0) ** GOTO lbl-1000
                var3_2 = var1_1.getAxisValue(26);
                if (!this.n.f()) break block7;
                var2_3 = -var3_2;
                ** GOTO lbl25
            }
            if (this.n.e()) {
                var2_3 = 0.0f;
            } else lbl-1000: // 2 sources:
            {
                var2_3 = 0.0f;
lbl25: // 3 sources:
                var3_2 = 0.0f;
            }
        }
        if (var2_3 == 0.0f) {
            if (var3_2 == 0.0f) return false;
        }
        this.a((int)(var3_2 * this.aw), (int)(var2_3 * this.ax), var1_1);
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        boolean bl2 = this.v;
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        if (this.a((MotionEvent)object)) {
            this.F();
            return true;
        }
        if (this.n == null) {
            return false;
        }
        bl2 = this.n.e();
        boolean bl4 = this.n.f();
        if (this.an == null) {
            this.an = VelocityTracker.obtain();
        }
        this.an.addMovement((MotionEvent)object);
        int n2 = object.getActionMasked();
        int n3 = object.getActionIndex();
        switch (n2) {
            default: {
                break;
            }
            case 6: {
                this.c((MotionEvent)object);
                break;
            }
            case 5: {
                this.am = object.getPointerId(n3);
                this.aq = n2 = (int)(object.getX(n3) + 0.5f);
                this.ao = n2;
                this.ar = n3 = (int)(object.getY(n3) + 0.5f);
                this.ap = n3;
                break;
            }
            case 3: {
                this.F();
                break;
            }
            case 2: {
                n2 = object.findPointerIndex(this.am);
                if (n2 < 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Error processing scroll; pointer index for id ");
                    ((StringBuilder)object).append(this.am);
                    ((StringBuilder)object).append(" not found. Did any MotionEvents get skipped?");
                    Log.e((String)"RecyclerView", (String)((StringBuilder)object).toString());
                    return false;
                }
                n3 = (int)(object.getX(n2) + 0.5f);
                int n4 = (int)(object.getY(n2) + 0.5f);
                if (this.al == 1) break;
                n2 = this.ao;
                int n5 = this.ap;
                if (bl2 && Math.abs(n3 - n2) > this.as) {
                    this.aq = n3;
                    n3 = 1;
                } else {
                    n3 = 0;
                }
                n2 = n3;
                if (bl4) {
                    n2 = n3;
                    if (Math.abs(n4 - n5) > this.as) {
                        this.ar = n4;
                        n2 = 1;
                    }
                }
                if (n2 == 0) break;
                this.setScrollState(1);
                break;
            }
            case 1: {
                this.an.clear();
                this.a(0);
                break;
            }
            case 0: {
                if (this.aa) {
                    this.aa = false;
                }
                this.am = object.getPointerId(0);
                this.aq = n3 = (int)(object.getX() + 0.5f);
                this.ao = n3;
                this.ar = n3 = (int)(object.getY() + 0.5f);
                this.ap = n3;
                if (this.al == 2) {
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                    this.setScrollState(1);
                }
                object = this.aG;
                this.aG[1] = 0;
                object[0] = false;
                n3 = bl2 ? 1 : 0;
                n2 = n3;
                if (bl4) {
                    n2 = n3 | 2;
                }
                this.j(n2, 0);
            }
        }
        if (this.al == 1) {
            bl3 = true;
        }
        return bl3;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        androidx.core.d.a.a("RV OnLayout");
        this.r();
        androidx.core.d.a.a();
        this.t = true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void onMeasure(int n2, int n3) {
        if (this.n == null) {
            this.e(n2, n3);
            return;
        }
        boolean bl2 = this.n.c();
        boolean bl3 = false;
        if (bl2) {
            int n4 = View.MeasureSpec.getMode((int)n2);
            int n5 = View.MeasureSpec.getMode((int)n3);
            this.n.a(this.e, this.D, n2, n3);
            boolean bl4 = bl3;
            if (n4 == 1073741824) {
                bl4 = bl3;
                if (n5 == 1073741824) {
                    return;
                }
            }
            if (bl4) return;
            if (this.m == null) {
                return;
            }
            if (this.D.d == 1) {
                this.N();
            }
            this.n.c(n2, n3);
            this.D.i = true;
            this.O();
            this.n.d(n2, n3);
            if (!this.n.l()) return;
            this.n.c(View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)1073741824));
            this.D.i = true;
            this.O();
            this.n.d(n2, n3);
            return;
        }
        if (this.r) {
            this.n.a(this.e, this.D, n2, n3);
            return;
        }
        if (this.w) {
            this.f();
            this.m();
            this.I();
            this.n();
            if (this.D.k) {
                this.D.g = true;
            } else {
                this.f.e();
                this.D.g = false;
            }
            this.w = false;
            this.a(false);
        } else if (this.D.k) {
            this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
            return;
        }
        this.D.e = this.m != null ? this.m.a() : 0;
        this.f();
        this.n.a(this.e, this.D, n2, n3);
        this.a(false);
        this.D.g = false;
    }

    protected boolean onRequestFocusInDescendants(int n2, Rect rect) {
        if (this.p()) {
            return false;
        }
        return super.onRequestFocusInDescendants(n2, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.S = (s)parcelable;
        super.onRestoreInstanceState(this.S.a());
        if (this.n != null && this.S.a != null) {
            this.n.a(this.S.a);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected Parcelable onSaveInstanceState() {
        s s2 = new s(super.onSaveInstanceState());
        if (this.S != null) {
            s2.a(this.S);
            return s2;
        }
        Parcelable parcelable = this.n != null ? this.n.d() : null;
        s2.a = parcelable;
        return s2;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        if (n2 != n4 || n3 != n5) {
            this.l();
        }
    }

    public boolean onTouchEvent(MotionEvent object) {
        boolean bl2 = this.v;
        int n2 = 0;
        if (!bl2) {
            if (this.aa) {
                return false;
            }
            if (this.b((MotionEvent)object)) {
                this.F();
                return true;
            }
            if (this.n == null) {
                return false;
            }
            bl2 = this.n.e();
            boolean bl3 = this.n.f();
            if (this.an == null) {
                this.an = VelocityTracker.obtain();
            }
            MotionEvent motionEvent = MotionEvent.obtain((MotionEvent)object);
            int n3 = object.getActionMasked();
            int n4 = object.getActionIndex();
            if (n3 == 0) {
                int[] arrn = this.aG;
                this.aG[1] = 0;
                arrn[0] = 0;
            }
            motionEvent.offsetLocation((float)this.aG[0], (float)this.aG[1]);
            switch (n3) {
                default: {
                    n4 = n2;
                    break;
                }
                case 6: {
                    this.c((MotionEvent)object);
                    n4 = n2;
                    break;
                }
                case 5: {
                    this.am = object.getPointerId(n4);
                    this.aq = n3 = (int)(object.getX(n4) + 0.5f);
                    this.ao = n3;
                    this.ar = n4 = (int)(object.getY(n4) + 0.5f);
                    this.ap = n4;
                    n4 = n2;
                    break;
                }
                case 3: {
                    this.F();
                    n4 = n2;
                    break;
                }
                case 2: {
                    n4 = object.findPointerIndex(this.am);
                    if (n4 < 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Error processing scroll; pointer index for id ");
                        ((StringBuilder)object).append(this.am);
                        ((StringBuilder)object).append(" not found. Did any MotionEvents get skipped?");
                        Log.e((String)"RecyclerView", (String)((StringBuilder)object).toString());
                        return false;
                    }
                    int n5 = (int)(object.getX(n4) + 0.5f);
                    int n6 = (int)(object.getY(n4) + 0.5f);
                    int n7 = this.aq - n5;
                    int n8 = this.ar - n6;
                    n3 = n7;
                    n4 = n8;
                    if (this.a(n7, n8, this.I, this.aF, 0)) {
                        n3 = n7 - this.I[0];
                        n4 = n8 - this.I[1];
                        motionEvent.offsetLocation((float)this.aF[0], (float)this.aF[1]);
                        object = this.aG;
                        object[0] = object[0] + this.aF[0];
                        object = this.aG;
                        object[1] = object[1] + this.aF[1];
                    }
                    n8 = n3;
                    n7 = n4;
                    if (this.al != 1) {
                        if (bl2 && Math.abs(n3) > this.as) {
                            n3 = n3 > 0 ? (n3 -= this.as) : (n3 += this.as);
                            n8 = 1;
                        } else {
                            n8 = 0;
                        }
                        int n9 = n8;
                        int n10 = n4;
                        if (bl3) {
                            n9 = n8;
                            n10 = n4;
                            if (Math.abs(n4) > this.as) {
                                n10 = n4 > 0 ? n4 - this.as : n4 + this.as;
                                n9 = 1;
                            }
                        }
                        n8 = n3;
                        n7 = n10;
                        if (n9 != 0) {
                            this.setScrollState(1);
                            n7 = n10;
                            n8 = n3;
                        }
                    }
                    n4 = n2;
                    if (this.al != 1) break;
                    this.aq = n5 - this.aF[0];
                    this.ar = n6 - this.aF[1];
                    n4 = bl2 ? n8 : 0;
                    if (this.a(n4, n3 = bl3 ? n7 : 0, motionEvent)) {
                        this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    n4 = n2;
                    if (this.B == null) break;
                    if (n8 == 0) {
                        n4 = n2;
                        if (n7 == 0) break;
                    }
                    this.B.a(this, n8, n7);
                    n4 = n2;
                    break;
                }
                case 1: {
                    this.an.addMovement(motionEvent);
                    this.an.computeCurrentVelocity(1000, (float)this.av);
                    float f2 = bl2 ? -this.an.getXVelocity(this.am) : 0.0f;
                    float f3 = bl3 ? -this.an.getYVelocity(this.am) : 0.0f;
                    if (f2 == 0.0f && f3 == 0.0f || !this.b((int)f2, (int)f3)) {
                        this.setScrollState(0);
                    }
                    this.E();
                    n4 = 1;
                    break;
                }
                case 0: {
                    this.am = object.getPointerId(0);
                    this.aq = n4 = (int)(object.getX() + 0.5f);
                    this.ao = n4;
                    this.ar = n4 = (int)(object.getY() + 0.5f);
                    this.ap = n4;
                    n4 = bl2 ? 1 : 0;
                    n3 = n4;
                    if (bl3) {
                        n3 = n4 | 2;
                    }
                    this.j(n3, 0);
                    n4 = n2;
                }
            }
            if (n4 == 0) {
                this.an.addMovement(motionEvent);
            }
            motionEvent.recycle();
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.ae > 0;
    }

    void q() {
        if (!this.G && this.q) {
            androidx.core.h.t.a((View)this, this.aH);
            this.G = true;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void r() {
        block8 : {
            block7 : {
                block6 : {
                    block5 : {
                        if (this.m != null) break block5;
                        var1_1 = "No adapter attached; skipping layout";
                        break block6;
                    }
                    if (this.n != null) break block7;
                    var1_1 = "No layout manager attached; skipping layout";
                }
                Log.e((String)"RecyclerView", (String)var1_1);
                return;
            }
            this.D.i = false;
            if (this.D.d != 1) break block8;
            this.N();
            ** GOTO lbl-1000
        }
        if (this.f.f() || this.n.y() != this.getWidth() || this.n.z() != this.getHeight()) lbl-1000: // 2 sources:
        {
            this.n.f(this);
            this.O();
        } else {
            this.n.f(this);
        }
        this.P();
    }

    protected void removeDetachedView(View object, boolean bl2) {
        x x2 = RecyclerView.e((View)object);
        if (x2 != null) {
            if (x2.r()) {
                x2.m();
            } else if (!x2.c()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                ((StringBuilder)object).append(x2);
                ((StringBuilder)object).append(this.a());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
        }
        object.clearAnimation();
        this.k((View)object);
        super.removeDetachedView((View)object, bl2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, this.D, view, view2) && view2 != null) {
            this.a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        return this.n.a(this, view, rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        int n2 = this.U.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.U.get(i2).a(bl2);
        }
        super.requestDisallowInterceptTouchEvent(bl2);
    }

    public void requestLayout() {
        if (this.W == 0 && !this.v) {
            super.requestLayout();
            return;
        }
        this.u = true;
    }

    void s() {
        int n2 = this.g.c();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((j)this.g.d((int)i2).getLayoutParams()).e = true;
        }
        this.e.j();
    }

    public void scrollBy(int n2, int n3) {
        if (this.n == null) {
            Log.e((String)"RecyclerView", (String)"Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.v) {
            return;
        }
        boolean bl2 = this.n.e();
        boolean bl3 = this.n.f();
        if (bl2 || bl3) {
            if (!bl2) {
                n2 = 0;
            }
            if (!bl3) {
                n3 = 0;
            }
            this.a(n2, n3, (MotionEvent)null);
        }
    }

    public void scrollTo(int n2, int n3) {
        Log.w((String)"RecyclerView", (String)"RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (this.a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k k2) {
        this.H = k2;
        androidx.core.h.t.a((View)this, this.H);
    }

    public void setAdapter(a a2) {
        this.setLayoutFrozen(false);
        this.a(a2, false, true);
        this.c(false);
        this.requestLayout();
    }

    public void setChildDrawingOrderCallback(d d2) {
        if (d2 == this.aC) {
            return;
        }
        this.aC = d2;
        boolean bl2 = this.aC != null;
        this.setChildrenDrawingOrderEnabled(bl2);
    }

    public void setClipToPadding(boolean bl2) {
        if (bl2 != this.i) {
            this.l();
        }
        this.i = bl2;
        super.setClipToPadding(bl2);
        if (this.t) {
            this.requestLayout();
        }
    }

    public void setEdgeEffectFactory(e e2) {
        androidx.core.g.e.a(e2);
        this.ag = e2;
        this.l();
    }

    public void setHasFixedSize(boolean bl2) {
        this.r = bl2;
    }

    public void setItemAnimator(f f2) {
        if (this.z != null) {
            this.z.d();
            this.z.a((f.b)null);
        }
        this.z = f2;
        if (this.z != null) {
            this.z.a(this.aB);
        }
    }

    public void setItemViewCacheSize(int n2) {
        this.e.a(n2);
    }

    public void setLayoutFrozen(boolean bl2) {
        if (bl2 != this.v) {
            this.a("Do not setLayoutFrozen in layout or scroll");
            if (!bl2) {
                this.v = false;
                if (this.u && this.n != null && this.m != null) {
                    this.requestLayout();
                }
                this.u = false;
                return;
            }
            long l2 = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0));
            this.v = true;
            this.aa = true;
            this.g();
        }
    }

    public void setLayoutManager(i i2) {
        if (i2 == this.n) {
            return;
        }
        this.g();
        if (this.n != null) {
            if (this.z != null) {
                this.z.d();
            }
            this.n.c(this.e);
            this.n.b(this.e);
            this.e.a();
            if (this.q) {
                this.n.b(this, this.e);
            }
            this.n.b((RecyclerView)null);
            this.n = null;
        } else {
            this.e.a();
        }
        this.g.a();
        this.n = i2;
        if (i2 != null) {
            if (i2.q == null) {
                this.n.b(this);
                if (this.q) {
                    this.n.c(this);
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("LayoutManager ");
                stringBuilder.append(i2);
                stringBuilder.append(" is already attached to a RecyclerView:");
                stringBuilder.append(i2.q.a());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        this.e.b();
        this.requestLayout();
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.getScrollingChildHelper().a(bl2);
    }

    public void setOnFlingListener(l l2) {
        this.at = l2;
    }

    @Deprecated
    public void setOnScrollListener(n n2) {
        this.az = n2;
    }

    public void setPreserveFocusAfterLayout(boolean bl2) {
        this.ay = bl2;
    }

    public void setRecycledViewPool(o o2) {
        this.e.a(o2);
    }

    public void setRecyclerListener(q q2) {
        this.o = q2;
    }

    void setScrollState(int n2) {
        if (n2 == this.al) {
            return;
        }
        this.al = n2;
        if (n2 != 2) {
            this.C();
        }
        this.h(n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void setScrollingTouchSlop(int var1_1) {
        var2_2 = ViewConfiguration.get((Context)this.getContext());
        switch (var1_1) {
            default: {
                var3_3 = new StringBuilder();
                var3_3.append("setScrollingTouchSlop(): bad argument constant ");
                var3_3.append(var1_1);
                var3_3.append("; using default value");
                Log.w((String)"RecyclerView", (String)var3_3.toString());
                break;
            }
            case 1: {
                var1_1 = var2_2.getScaledPagingTouchSlop();
                ** break;
            }
            case 0: 
        }
        var1_1 = var2_2.getScaledTouchSlop();
lbl15: // 2 sources:
        this.as = var1_1;
    }

    public void setViewCacheExtension(v v2) {
        this.e.a(v2);
    }

    public boolean startNestedScroll(int n2) {
        return this.getScrollingChildHelper().b(n2);
    }

    @Override
    public void stopNestedScroll() {
        this.getScrollingChildHelper().c();
    }

    void t() {
        int n2 = this.g.c();
        for (int i2 = 0; i2 < n2; ++i2) {
            x x2 = RecyclerView.e(this.g.d(i2));
            if (x2.c()) continue;
            x2.b();
        }
    }

    void u() {
        int n2 = this.g.c();
        for (int i2 = 0; i2 < n2; ++i2) {
            x x2 = RecyclerView.e(this.g.d(i2));
            if (x2.c()) continue;
            x2.a();
        }
        this.e.i();
    }

    void v() {
        int n2 = this.g.c();
        for (int i2 = 0; i2 < n2; ++i2) {
            x x2 = RecyclerView.e(this.g.d(i2));
            if (x2 == null || x2.c()) continue;
            x2.b(6);
        }
        this.s();
        this.e.h();
    }

    public boolean w() {
        return !this.t || this.x || this.f.d();
        {
        }
    }

    void x() {
        int n2 = this.g.b();
        for (int i2 = 0; i2 < n2; ++i2) {
            View view = this.g.b(i2);
            x x2 = this.b(view);
            if (x2 == null || x2.i == null) continue;
            x2 = x2.i.a;
            int n3 = view.getLeft();
            int n4 = view.getTop();
            if (n3 == x2.getLeft() && n4 == x2.getTop()) continue;
            x2.layout(n3, n4, x2.getWidth() + n3, x2.getHeight() + n4);
        }
    }

    void y() {
        for (int i2 = this.K.size() - 1; i2 >= 0; --i2) {
            int n2;
            x x2 = this.K.get(i2);
            if (x2.a.getParent() != this || x2.c() || (n2 = x2.o) == -1) continue;
            androidx.core.h.t.b(x2.a, n2);
            x2.o = -1;
        }
        this.K.clear();
    }

    public static abstract class a<VH extends x> {
        private final b a = new b();
        private boolean b = false;

        public abstract int a();

        public int a(int n2) {
            return 0;
        }

        public abstract VH a(ViewGroup var1, int var2);

        public final void a(int n2, int n3) {
            this.a.a(n2, n3);
        }

        public void a(c c2) {
            this.a.registerObserver((Object)c2);
        }

        public void a(VH VH) {
        }

        public abstract void a(VH var1, int var2);

        public void a(VH VH, int n2, List<Object> list) {
            this.a(VH, n2);
        }

        public void a(RecyclerView recyclerView) {
        }

        public long b(int n2) {
            return -1L;
        }

        public final VH b(ViewGroup object, int n2) {
            try {
                androidx.core.d.a.a("RV CreateView");
                object = this.a((ViewGroup)object, n2);
                if (object.a.getParent() == null) {
                    object.f = n2;
                    return (VH)object;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            finally {
                androidx.core.d.a.a();
            }
        }

        public final void b(int n2, int n3) {
            this.a.b(n2, n3);
        }

        public void b(c c2) {
            this.a.unregisterObserver((Object)c2);
        }

        public final void b(VH object, int n2) {
            ((x)object).c = n2;
            if (this.b()) {
                ((x)object).e = this.b(n2);
            }
            ((x)object).a(1, 519);
            androidx.core.d.a.a("RV OnBindView");
            this.a(object, n2, ((x)object).u());
            ((x)object).t();
            object = ((x)object).a.getLayoutParams();
            if (object instanceof j) {
                ((j)object).e = true;
            }
            androidx.core.d.a.a();
        }

        public void b(RecyclerView recyclerView) {
        }

        public final boolean b() {
            return this.b;
        }

        public boolean b(VH VH) {
            return false;
        }

        public final void c() {
            this.a.a();
        }

        public void c(VH VH) {
        }

        public void d(VH VH) {
        }
    }

    static class b
    extends Observable<c> {
        b() {
        }

        public void a() {
            for (int i2 = this.mObservers.size() - 1; i2 >= 0; --i2) {
                ((c)this.mObservers.get(i2)).a();
            }
        }

        public void a(int n2, int n3) {
            this.a(n2, n3, null);
        }

        public void a(int n2, int n3, Object object) {
            for (int i2 = this.mObservers.size() - 1; i2 >= 0; --i2) {
                ((c)this.mObservers.get(i2)).a(n2, n3, object);
            }
        }

        public void b(int n2, int n3) {
            for (int i2 = this.mObservers.size() - 1; i2 >= 0; --i2) {
                ((c)this.mObservers.get(i2)).a(n2, n3, 1);
            }
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int n2, int n3) {
        }

        public void a(int n2, int n3, int n4) {
        }

        public void a(int n2, int n3, Object object) {
            this.a(n2, n3);
        }
    }

    public static interface d {
        public int a(int var1, int var2);
    }

    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int n2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class f {
        private b a = null;
        private ArrayList<a> b = new ArrayList();
        private long c = 120L;
        private long d = 120L;
        private long e = 250L;
        private long f = 250L;

        static int e(x x2) {
            int n2 = x2.j & 14;
            if (x2.n()) {
                return 4;
            }
            int n3 = n2;
            if ((n2 & 4) == 0) {
                int n4 = x2.f();
                int n5 = x2.e();
                n3 = n2;
                if (n4 != -1) {
                    n3 = n2;
                    if (n5 != -1) {
                        n3 = n2;
                        if (n4 != n5) {
                            n3 = n2 | 2048;
                        }
                    }
                }
            }
            return n3;
        }

        public c a(u u2, x x2) {
            return this.j().a(x2);
        }

        public c a(u u2, x x2, int n2, List<Object> list) {
            return this.j().a(x2);
        }

        public abstract void a();

        void a(b b2) {
            this.a = b2;
        }

        public final boolean a(a a2) {
            boolean bl2 = this.b();
            if (a2 != null) {
                if (!bl2) {
                    a2.a();
                    return bl2;
                }
                this.b.add(a2);
            }
            return bl2;
        }

        public abstract boolean a(x var1, c var2, c var3);

        public abstract boolean a(x var1, x var2, c var3, c var4);

        public boolean a(x x2, List<Object> list) {
            return this.h(x2);
        }

        public abstract boolean b();

        public abstract boolean b(x var1, c var2, c var3);

        public abstract boolean c(x var1, c var2, c var3);

        public abstract void d();

        public abstract void d(x var1);

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public final void f(x x2) {
            this.g(x2);
            if (this.a != null) {
                this.a.a(x2);
            }
        }

        public long g() {
            return this.d;
        }

        public void g(x x2) {
        }

        public long h() {
            return this.f;
        }

        public boolean h(x x2) {
            return true;
        }

        public final void i() {
            int n2 = this.b.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.b.get(i2).a();
            }
            this.b.clear();
        }

        public c j() {
            return new c();
        }

        public static interface a {
            public void a();
        }

        static interface b {
            public void a(x var1);
        }

        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(x x2) {
                return this.a(x2, 0);
            }

            public c a(x x2, int n2) {
                x2 = x2.a;
                this.a = x2.getLeft();
                this.b = x2.getTop();
                this.c = x2.getRight();
                this.d = x2.getBottom();
                return this;
            }
        }

    }

    private class g
    implements f.b {
        g() {
        }

        @Override
        public void a(x x2) {
            x2.a(true);
            if (x2.h != null && x2.i == null) {
                x2.h = null;
            }
            x2.i = null;
            if (!x2.x() && !RecyclerView.this.a(x2.a) && x2.r()) {
                RecyclerView.this.removeDetachedView(x2.a, false);
            }
        }
    }

    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, u u2) {
            this.a(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int n2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, u u2) {
            this.a(rect, ((j)view.getLayoutParams()).f(), recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, u u2) {
            this.b(canvas, recyclerView);
        }
    }

    public static abstract class i {
        private final n.b a = new n.b(){

            @Override
            public int a() {
                return i.this.A();
            }

            @Override
            public int a(View view) {
                j j2 = (j)view.getLayoutParams();
                return i.this.h(view) - j2.leftMargin;
            }

            @Override
            public View a(int n2) {
                return i.this.i(n2);
            }

            @Override
            public int b() {
                return i.this.y() - i.this.C();
            }

            @Override
            public int b(View view) {
                j j2 = (j)view.getLayoutParams();
                return i.this.j(view) + j2.rightMargin;
            }
        };
        private final n.b b = new n.b(){

            @Override
            public int a() {
                return i.this.B();
            }

            @Override
            public int a(View view) {
                j j2 = (j)view.getLayoutParams();
                return i.this.i(view) - j2.topMargin;
            }

            @Override
            public View a(int n2) {
                return i.this.i(n2);
            }

            @Override
            public int b() {
                return i.this.z() - i.this.D();
            }

            @Override
            public int b(View view) {
                j j2 = (j)view.getLayoutParams();
                return i.this.k(view) + j2.bottomMargin;
            }
        };
        private boolean c = true;
        private boolean d = true;
        private int e;
        private int f;
        private int g;
        private int h;
        androidx.recyclerview.widget.b p;
        RecyclerView q;
        androidx.recyclerview.widget.n r = new androidx.recyclerview.widget.n(this.a);
        androidx.recyclerview.widget.n s = new androidx.recyclerview.widget.n(this.b);
        t t;
        boolean u = false;
        boolean v = false;
        boolean w = false;
        int x;
        boolean y;

        public static int a(int n2, int n3, int n4) {
            int n5 = View.MeasureSpec.getMode((int)n2);
            n2 = View.MeasureSpec.getSize((int)n2);
            if (n5 != Integer.MIN_VALUE) {
                if (n5 != 1073741824) {
                    n2 = Math.max(n3, n4);
                }
                return n2;
            }
            return Math.min(n2, Math.max(n3, n4));
        }

        /*
         * Enabled aggressive block sorting
         */
        public static int a(int n2, int n3, int n4, int n5, boolean bl2) {
            int n6;
            block12 : {
                int n7;
                block13 : {
                    block11 : {
                        block10 : {
                            n6 = 0;
                            n7 = Math.max(0, n2 - n4);
                            if (!bl2) break block10;
                            if (n5 >= 0) break block11;
                            if (n5 == -1) {
                                if (n3 != Integer.MIN_VALUE && (n3 == 0 || n3 != 1073741824)) {
                                    n3 = 0;
                                    n2 = 0;
                                } else {
                                    n2 = n7;
                                }
                                n4 = n2;
                                n2 = n3;
                                return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2);
                            }
                            break block12;
                        }
                        if (n5 < 0) break block13;
                    }
                    n4 = n5;
                    n2 = 1073741824;
                    return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2);
                }
                if (n5 == -1) {
                    n2 = n3;
                    n4 = n7;
                    return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2);
                }
                if (n5 == -2) {
                    if (n3 != Integer.MIN_VALUE) {
                        n4 = n7;
                        n2 = n6;
                        if (n3 != 1073741824) return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2);
                    }
                    n2 = Integer.MIN_VALUE;
                    n4 = n7;
                    return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2);
                }
            }
            n4 = 0;
            n2 = n6;
            return View.MeasureSpec.makeMeasureSpec((int)n4, (int)n2);
        }

        public static b a(Context context, AttributeSet attributeSet, int n2, int n3) {
            b b2 = new b();
            context = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, n2, n3);
            b2.a = context.getInt(a.b.RecyclerView_android_orientation, 1);
            b2.b = context.getInt(a.b.RecyclerView_spanCount, 1);
            b2.c = context.getBoolean(a.b.RecyclerView_reverseLayout, false);
            b2.d = context.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            context.recycle();
            return b2;
        }

        private void a(int n2, View view) {
            this.p.e(n2);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(View view, int n2, boolean bl2) {
            Object object = RecyclerView.e(view);
            if (!bl2 && !((x)object).q()) {
                this.q.h.f((x)object);
            } else {
                this.q.h.e((x)object);
            }
            j j2 = (j)view.getLayoutParams();
            if (!((x)object).k() && !((x)object).i()) {
                if (view.getParent() == this.q) {
                    int n3 = this.p.b(view);
                    int n4 = n2;
                    if (n2 == -1) {
                        n4 = this.p.b();
                    }
                    if (n3 == -1) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        ((StringBuilder)object).append(this.q.indexOfChild(view));
                        ((StringBuilder)object).append(this.q.a());
                        throw new IllegalStateException(((StringBuilder)object).toString());
                    }
                    if (n3 != n4) {
                        this.q.n.e(n3, n4);
                    }
                } else {
                    this.p.a(view, n2, false);
                    j2.e = true;
                    if (this.t != null && this.t.d()) {
                        this.t.b(view);
                    }
                }
            } else {
                if (((x)object).i()) {
                    ((x)object).j();
                } else {
                    ((x)object).l();
                }
                this.p.a(view, n2, view.getLayoutParams(), false);
            }
            if (j2.f) {
                ((x)object).a.invalidate();
                j2.f = false;
            }
        }

        private void a(p p2, int n2, View view) {
            x x2 = RecyclerView.e(view);
            if (x2.c()) {
                return;
            }
            if (x2.n() && !x2.q() && !this.q.m.b()) {
                this.g(n2);
                p2.b(x2);
                return;
            }
            this.h(n2);
            p2.c(view);
            this.q.h.h(x2);
        }

        private static boolean b(int n2, int n3, int n4) {
            int n5 = View.MeasureSpec.getMode((int)n3);
            n3 = View.MeasureSpec.getSize((int)n3);
            boolean bl2 = false;
            boolean bl3 = false;
            if (n4 > 0 && n2 != n4) {
                return false;
            }
            if (n5 != Integer.MIN_VALUE) {
                if (n5 != 0) {
                    if (n5 != 1073741824) {
                        return false;
                    }
                    if (n3 == n2) {
                        bl3 = true;
                    }
                    return bl3;
                }
                return true;
            }
            bl3 = bl2;
            if (n3 >= n2) {
                bl3 = true;
            }
            return bl3;
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean bl2) {
            int n2 = this.A();
            int n3 = this.B();
            int n4 = this.y();
            int n5 = this.C();
            int n6 = this.z();
            int n7 = this.D();
            int n8 = view.getLeft() + rect.left - view.getScrollX();
            int n9 = view.getTop() + rect.top - view.getScrollY();
            int n10 = rect.width();
            int n11 = rect.height();
            int n12 = n8 - n2;
            n2 = Math.min(0, n12);
            int n13 = n9 - n3;
            n3 = Math.min(0, n13);
            n5 = n10 + n8 - (n4 - n5);
            n4 = Math.max(0, n5);
            n6 = Math.max(0, n11 + n9 - (n6 - n7));
            if (this.t() == 1) {
                n2 = n4 != 0 ? n4 : Math.max(n2, n5);
            } else if (n2 == 0) {
                n2 = Math.min(n12, n4);
            }
            if (n3 == 0) {
                n3 = Math.min(n13, n6);
            }
            return new int[]{n2, n3};
        }

        private boolean d(RecyclerView recyclerView, int n2, int n3) {
            if ((recyclerView = recyclerView.getFocusedChild()) == null) {
                return false;
            }
            int n4 = this.A();
            int n5 = this.B();
            int n6 = this.y();
            int n7 = this.C();
            int n8 = this.z();
            int n9 = this.D();
            Rect rect = this.q.k;
            this.a((View)recyclerView, rect);
            if (rect.left - n2 < n6 - n7 && rect.right - n2 > n4 && rect.top - n3 < n8 - n9) {
                return rect.bottom - n3 > n5;
            }
            return false;
        }

        public int A() {
            if (this.q != null) {
                return this.q.getPaddingLeft();
            }
            return 0;
        }

        public int B() {
            if (this.q != null) {
                return this.q.getPaddingTop();
            }
            return 0;
        }

        public int C() {
            if (this.q != null) {
                return this.q.getPaddingRight();
            }
            return 0;
        }

        public int D() {
            if (this.q != null) {
                return this.q.getPaddingBottom();
            }
            return 0;
        }

        public View E() {
            if (this.q == null) {
                return null;
            }
            View view = this.q.getFocusedChild();
            if (view != null) {
                if (this.p.c(view)) {
                    return null;
                }
                return view;
            }
            return null;
        }

        public int F() {
            return androidx.core.h.t.k((View)this.q);
        }

        public int G() {
            return androidx.core.h.t.l((View)this.q);
        }

        void H() {
            if (this.t != null) {
                this.t.b();
            }
        }

        public void I() {
            this.u = true;
        }

        boolean J() {
            int n2 = this.v();
            for (int i2 = 0; i2 < n2; ++i2) {
                ViewGroup.LayoutParams layoutParams = this.i(i2).getLayoutParams();
                if (layoutParams.width >= 0 || layoutParams.height >= 0) continue;
                return true;
            }
            return false;
        }

        public int a(int n2, p p2, u u2) {
            return 0;
        }

        public int a(p object, u u2) {
            int n2;
            object = this.q;
            int n3 = n2 = 1;
            if (object != null) {
                if (this.q.m == null) {
                    return 1;
                }
                n3 = n2;
                if (this.f()) {
                    n3 = this.q.m.a();
                }
            }
            return n3;
        }

        public View a(View view, int n2, p p2, u u2) {
            return null;
        }

        public abstract j a();

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public j a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j)layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams)layoutParams);
            }
            return new j(layoutParams);
        }

        public void a(int n2, int n3, u u2, a a2) {
        }

        public void a(int n2, a a2) {
        }

        public void a(int n2, p p2) {
            View view = this.i(n2);
            this.g(n2);
            p2.a(view);
        }

        public void a(Rect rect, int n2, int n3) {
            int n4 = rect.width();
            int n5 = this.A();
            int n6 = this.C();
            int n7 = rect.height();
            int n8 = this.B();
            int n9 = this.D();
            this.f(i.a(n2, n4 + n5 + n6, this.F()), i.a(n3, n7 + n8 + n9, this.G()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(View view) {
            this.a(view, -1);
        }

        public void a(View view, int n2) {
            this.a(view, n2, true);
        }

        public void a(View view, int n2, int n3) {
            j j2 = (j)view.getLayoutParams();
            Rect rect = this.q.i(view);
            int n4 = rect.left;
            int n5 = rect.right;
            int n6 = rect.top;
            int n7 = rect.bottom;
            n2 = i.a(this.y(), this.w(), this.A() + this.C() + j2.leftMargin + j2.rightMargin + (n2 + (n4 + n5)), j2.width, this.e());
            if (this.b(view, n2, n3 = i.a(this.z(), this.x(), this.B() + this.D() + j2.topMargin + j2.bottomMargin + (n3 + (n6 + n7)), j2.height, this.f()), j2)) {
                view.measure(n2, n3);
            }
        }

        public void a(View view, int n2, int n3, int n4, int n5) {
            j j2 = (j)view.getLayoutParams();
            Rect rect = j2.d;
            view.layout(n2 + rect.left + j2.leftMargin, n3 + rect.top + j2.topMargin, n4 - rect.right - j2.rightMargin, n5 - rect.bottom - j2.bottomMargin);
        }

        public void a(View view, int n2, j j2) {
            x x2 = RecyclerView.e(view);
            if (x2.q()) {
                this.q.h.e(x2);
            } else {
                this.q.h.f(x2);
            }
            this.p.a(view, n2, (ViewGroup.LayoutParams)j2, x2.q());
        }

        public void a(View view, Rect rect) {
            RecyclerView.b(view, rect);
        }

        void a(View view, androidx.core.h.a.b b2) {
            x x2 = RecyclerView.e(view);
            if (x2 != null && !x2.q() && !this.p.c(x2.a)) {
                this.a(this.q.e, this.q.D, view, b2);
            }
        }

        public void a(View view, p p2) {
            this.c(view);
            p2.a(view);
        }

        public void a(View view, boolean bl2, Rect rect) {
            Rect rect2;
            if (bl2) {
                rect2 = ((j)view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null && (rect2 = view.getMatrix()) != null && !rect2.isIdentity()) {
                RectF rectF = this.q.l;
                rectF.set(rect);
                rect2.mapRect(rectF);
                rect.set((int)Math.floor(rectF.left), (int)Math.floor(rectF.top), (int)Math.ceil(rectF.right), (int)Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            this.a(this.q.e, this.q.D, accessibilityEvent);
        }

        void a(androidx.core.h.a.b b2) {
            this.a(this.q.e, this.q.D, b2);
        }

        public void a(androidx.recyclerview.widget.RecyclerView$a a2, androidx.recyclerview.widget.RecyclerView$a a3) {
        }

        public void a(p p2) {
            for (int i2 = this.v() - 1; i2 >= 0; --i2) {
                this.a(p2, i2, this.i(i2));
            }
        }

        public void a(p p2, u u2, int n2, int n3) {
            this.q.e(n2, n3);
        }

        public void a(p p2, u u2, View view, androidx.core.h.a.b b2) {
            int n2 = this.f() ? this.d(view) : 0;
            int n3 = this.e() ? this.d(view) : 0;
            b2.b(b.b.a(n2, 1, n3, 1, false, false));
        }

        public void a(p object, u u2, AccessibilityEvent accessibilityEvent) {
            if (this.q != null) {
                boolean bl2;
                if (accessibilityEvent == null) {
                    return;
                }
                object = this.q;
                boolean bl3 = bl2 = true;
                if (!object.canScrollVertically(1)) {
                    bl3 = bl2;
                    if (!this.q.canScrollVertically(-1)) {
                        bl3 = bl2;
                        if (!this.q.canScrollHorizontally(-1)) {
                            bl3 = this.q.canScrollHorizontally(1) ? bl2 : false;
                        }
                    }
                }
                accessibilityEvent.setScrollable(bl3);
                if (this.q.m != null) {
                    accessibilityEvent.setItemCount(this.q.m.a());
                }
            }
        }

        public void a(p p2, u u2, androidx.core.h.a.b b2) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                b2.a(8192);
                b2.c(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                b2.a(4096);
                b2.c(true);
            }
            b2.a(b.a.a(this.a(p2, u2), this.b(p2, u2), this.e(p2, u2), this.d(p2, u2)));
        }

        void a(t t2) {
            if (this.t == t2) {
                this.t = null;
            }
        }

        public void a(u u2) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int n2, int n3) {
        }

        public void a(RecyclerView recyclerView, int n2, int n3, int n4) {
        }

        public void a(RecyclerView recyclerView, int n2, int n3, Object object) {
            this.c(recyclerView, n2, n3);
        }

        public void a(RecyclerView recyclerView, p p2) {
            this.e(recyclerView);
        }

        public void a(String string2) {
            if (this.q != null) {
                this.q.a(string2);
            }
        }

        boolean a(int n2, Bundle bundle) {
            return this.a(this.q.e, this.q.D, n2, bundle);
        }

        boolean a(View view, int n2, int n3, j j2) {
            return !this.c || !i.b(view.getMeasuredWidth(), n2, j2.width) || !i.b(view.getMeasuredHeight(), n3, j2.height);
            {
            }
        }

        boolean a(View view, int n2, Bundle bundle) {
            return this.a(this.q.e, this.q.D, view, n2, bundle);
        }

        public boolean a(View view, boolean bl2, boolean bl3) {
            bl3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            if (bl2) {
                return bl3;
            }
            return bl3 ^ true;
        }

        public boolean a(j j2) {
            return j2 != null;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean a(p var1_1, u var2_2, int var3_3, Bundle var4_4) {
            block6 : {
                block5 : {
                    if (this.q == null) {
                        return false;
                    }
                    if (var3_3 == 4096) break block5;
                    if (var3_3 != 8192) {
                        return false;
                    }
                    var5_6 = this.q.canScrollVertically(-1) != false ? -(this.z() - this.B() - this.D()) : 0;
                    var3_3 = var5_6;
                    if (!this.q.canScrollHorizontally(-1)) ** GOTO lbl-1000
                    var6_5 = -(this.y() - this.A() - this.C());
                    var3_3 = var5_6;
                    break block6;
                }
                var5_7 = this.q.canScrollVertically(1) != false ? this.z() - this.B() - this.D() : 0;
                var3_3 = var5_7;
                if (this.q.canScrollHorizontally(1)) {
                    var6_5 = this.y() - this.A() - this.C();
                    var3_3 = var5_7;
                } else lbl-1000: // 2 sources:
                {
                    var6_5 = 0;
                }
            }
            if (var3_3 == 0 && var6_5 == 0) {
                return false;
            }
            this.q.a(var6_5, var3_3);
            return true;
        }

        public boolean a(p p2, u u2, View view, int n2, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean bl2) {
            return this.a(recyclerView, view, rect, bl2, false);
        }

        public boolean a(RecyclerView recyclerView, View arrn, Rect rect, boolean bl2, boolean bl3) {
            arrn = this.b(recyclerView, (View)arrn, rect, bl2);
            int n2 = arrn[0];
            int n3 = arrn[1];
            if (bl3 && !this.d(recyclerView, n2, n3) || n2 == 0 && n3 == 0) {
                return false;
            }
            if (bl2) {
                recyclerView.scrollBy(n2, n3);
                return true;
            }
            recyclerView.a(n2, n3);
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return this.s() || recyclerView.p();
            {
            }
        }

        public boolean a(RecyclerView recyclerView, u u2, View view, View view2) {
            return this.a(recyclerView, view, view2);
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int n2, int n3) {
            return false;
        }

        public boolean a(Runnable runnable) {
            if (this.q != null) {
                return this.q.removeCallbacks(runnable);
            }
            return false;
        }

        public int b(int n2, p p2, u u2) {
            return 0;
        }

        public int b(p object, u u2) {
            int n2;
            object = this.q;
            int n3 = n2 = 1;
            if (object != null) {
                if (this.q.m == null) {
                    return 1;
                }
                n3 = n2;
                if (this.e()) {
                    n3 = this.q.m.a();
                }
            }
            return n3;
        }

        public void b(View view) {
            this.b(view, -1);
        }

        public void b(View view, int n2) {
            this.a(view, n2, false);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
                return;
            }
            rect.set(this.q.i(view));
        }

        void b(p p2) {
            int n2 = p2.e();
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                View view = p2.e(i2);
                x x2 = RecyclerView.e(view);
                if (x2.c()) continue;
                x2.a(false);
                if (x2.r()) {
                    this.q.removeDetachedView(view, false);
                }
                if (this.q.z != null) {
                    this.q.z.d(x2);
                }
                x2.a(true);
                p2.b(view);
            }
            p2.f();
            if (n2 > 0) {
                this.q.invalidate();
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        void b(RecyclerView recyclerView) {
            int n2;
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                n2 = 0;
                this.g = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.g;
                this.g = recyclerView.getWidth();
                n2 = recyclerView.getHeight();
            }
            this.h = n2;
            this.e = 1073741824;
            this.f = 1073741824;
        }

        public void b(RecyclerView recyclerView, int n2, int n3) {
        }

        void b(RecyclerView recyclerView, p p2) {
            this.v = false;
            this.a(recyclerView, p2);
        }

        public boolean b() {
            return false;
        }

        boolean b(View view, int n2, int n3, j j2) {
            return view.isLayoutRequested() || !this.c || !i.b(view.getWidth(), n2, j2.width) || !i.b(view.getHeight(), n3, j2.height);
            {
            }
        }

        public int c(u u2) {
            return 0;
        }

        public View c(int n2) {
            int n3 = this.v();
            for (int i2 = 0; i2 < n3; ++i2) {
                View view = this.i(i2);
                x x2 = RecyclerView.e(view);
                if (x2 == null || x2.d() != n2 || x2.c() || !this.q.D.a() && x2.q()) continue;
                return view;
            }
            return null;
        }

        void c(int n2, int n3) {
            this.g = View.MeasureSpec.getSize((int)n2);
            this.e = View.MeasureSpec.getMode((int)n2);
            if (this.e == 0 && !RecyclerView.b) {
                this.g = 0;
            }
            this.h = View.MeasureSpec.getSize((int)n3);
            this.f = View.MeasureSpec.getMode((int)n3);
            if (this.f == 0 && !RecyclerView.b) {
                this.h = 0;
            }
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void c(View view, int n2) {
            this.a(view, n2, (j)view.getLayoutParams());
        }

        public void c(p p2) {
            for (int i2 = this.v() - 1; i2 >= 0; --i2) {
                if (RecyclerView.e(this.i(i2)).c()) continue;
                this.a(i2, p2);
            }
        }

        public void c(p p2, u u2) {
            Log.e((String)"RecyclerView", (String)"You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void c(RecyclerView recyclerView) {
            this.v = true;
            this.d(recyclerView);
        }

        public void c(RecyclerView recyclerView, int n2, int n3) {
        }

        public boolean c() {
            return this.w;
        }

        public int d(View view) {
            return ((j)view.getLayoutParams()).f();
        }

        public int d(p p2, u u2) {
            return 0;
        }

        public int d(u u2) {
            return 0;
        }

        public Parcelable d() {
            return null;
        }

        public View d(View view, int n2) {
            return null;
        }

        void d(int n2, int n3) {
            int n4 = this.v();
            if (n4 == 0) {
                this.q.e(n2, n3);
                return;
            }
            int n5 = Integer.MAX_VALUE;
            int n6 = Integer.MAX_VALUE;
            int n7 = Integer.MIN_VALUE;
            int n8 = Integer.MIN_VALUE;
            for (int i2 = 0; i2 < n4; ++i2) {
                View view = this.i(i2);
                Rect rect = this.q.k;
                this.a(view, rect);
                int n9 = n5;
                if (rect.left < n5) {
                    n9 = rect.left;
                }
                int n10 = n7;
                if (rect.right > n7) {
                    n10 = rect.right;
                }
                n7 = n6;
                if (rect.top < n6) {
                    n7 = rect.top;
                }
                int n11 = n8;
                if (rect.bottom > n8) {
                    n11 = rect.bottom;
                }
                n6 = n7;
                n5 = n9;
                n7 = n10;
                n8 = n11;
            }
            this.q.k.set(n5, n6, n7, n8);
            this.a(this.q.k, n2, n3);
        }

        public void d(RecyclerView recyclerView) {
        }

        public int e(u u2) {
            return 0;
        }

        public View e(View view) {
            if (this.q == null) {
                return null;
            }
            if ((view = this.q.c(view)) == null) {
                return null;
            }
            if (this.p.c(view)) {
                return null;
            }
            return view;
        }

        public void e(int n2) {
        }

        public void e(int n2, int n3) {
            Object object = this.i(n2);
            if (object != null) {
                this.h(n2);
                this.c((View)object, n3);
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot move a child from non-existing index:");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(this.q.toString());
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(p p2, u u2) {
            return false;
        }

        public int f(View view) {
            Rect rect = ((j)view.getLayoutParams()).d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int f(u u2) {
            return 0;
        }

        public void f(int n2, int n3) {
            this.q.setMeasuredDimension(n2, n3);
        }

        void f(RecyclerView recyclerView) {
            this.c(View.MeasureSpec.makeMeasureSpec((int)recyclerView.getWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)recyclerView.getHeight(), (int)1073741824));
        }

        public boolean f() {
            return false;
        }

        public int g(View view) {
            Rect rect = ((j)view.getLayoutParams()).d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int g(u u2) {
            return 0;
        }

        public void g(int n2) {
            if (this.i(n2) != null) {
                this.p.a(n2);
            }
        }

        public int h(View view) {
            return view.getLeft() - this.n(view);
        }

        public int h(u u2) {
            return 0;
        }

        public void h(int n2) {
            this.a(n2, this.i(n2));
        }

        public int i(View view) {
            return view.getTop() - this.l(view);
        }

        public View i(int n2) {
            if (this.p != null) {
                return this.p.b(n2);
            }
            return null;
        }

        public int j(View view) {
            return view.getRight() + this.o(view);
        }

        public void j(int n2) {
            if (this.q != null) {
                this.q.f(n2);
            }
        }

        public int k(View view) {
            return view.getBottom() + this.m(view);
        }

        public void k(int n2) {
            if (this.q != null) {
                this.q.e(n2);
            }
        }

        public int l(View view) {
            return ((j)view.getLayoutParams()).d.top;
        }

        public void l(int n2) {
        }

        boolean l() {
            return false;
        }

        public int m(View view) {
            return ((j)view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((j)view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((j)view.getLayoutParams()).d.right;
        }

        public void o() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public final boolean p() {
            return this.d;
        }

        public boolean q() {
            return this.v;
        }

        public boolean r() {
            return this.q != null && this.q.i;
        }

        public boolean s() {
            return this.t != null && this.t.d();
        }

        public int t() {
            return androidx.core.h.t.f((View)this.q);
        }

        public int u() {
            return -1;
        }

        public int v() {
            if (this.p != null) {
                return this.p.b();
            }
            return 0;
        }

        public int w() {
            return this.e;
        }

        public int x() {
            return this.f;
        }

        public int y() {
            return this.g;
        }

        public int z() {
            return this.h;
        }

        public static interface a {
            public void b(int var1, int var2);
        }

        public static class b {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

    }

    public static class j
    extends ViewGroup.MarginLayoutParams {
        x c;
        final Rect d = new Rect();
        boolean e = true;
        boolean f = false;

        public j(int n2, int n3) {
            super(n2, n3);
        }

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public j(j j2) {
            super((ViewGroup.LayoutParams)j2);
        }

        public boolean c() {
            return this.c.n();
        }

        public boolean d() {
            return this.c.q();
        }

        public boolean e() {
            return this.c.z();
        }

        public int f() {
            return this.c.d();
        }
    }

    public static interface k {
        public void a(View var1);

        public void b(View var1);
    }

    public static abstract class l {
        public abstract boolean a(int var1, int var2);
    }

    public static interface m {
        public void a(boolean var1);

        public boolean a(RecyclerView var1, MotionEvent var2);

        public void b(RecyclerView var1, MotionEvent var2);
    }

    public static abstract class n {
        public void a(RecyclerView recyclerView, int n2) {
        }

        public void a(RecyclerView recyclerView, int n2, int n3) {
        }
    }

    public static class o {
        SparseArray<a> a = new SparseArray();
        private int b = 0;

        private a b(int n2) {
            a a2;
            a a3 = a2 = (a)this.a.get(n2);
            if (a2 == null) {
                a3 = new a();
                this.a.put(n2, (Object)a3);
            }
            return a3;
        }

        long a(long l2, long l3) {
            if (l2 == 0L) {
                return l3;
            }
            return l2 / 4L * 3L + l3 / 4L;
        }

        public x a(int n2) {
            Object object = (a)this.a.get(n2);
            if (object != null && !((a)object).a.isEmpty()) {
                object = ((a)object).a;
                return (x)((ArrayList)object).remove(((ArrayList)object).size() - 1);
            }
            return null;
        }

        public void a() {
            for (int i2 = 0; i2 < this.a.size(); ++i2) {
                ((a)this.a.valueAt((int)i2)).a.clear();
            }
        }

        void a(int n2, long l2) {
            a a2 = this.b(n2);
            a2.c = this.a(a2.c, l2);
        }

        void a(androidx.recyclerview.widget.RecyclerView$a a2, androidx.recyclerview.widget.RecyclerView$a a3, boolean bl2) {
            if (a2 != null) {
                this.c();
            }
            if (!bl2 && this.b == 0) {
                this.a();
            }
            if (a3 != null) {
                this.b();
            }
        }

        public void a(x x2) {
            int n2 = x2.h();
            ArrayList<x> arrayList = this.b((int)n2).a;
            if (((a)this.a.get((int)n2)).b <= arrayList.size()) {
                return;
            }
            x2.v();
            arrayList.add(x2);
        }

        boolean a(int n2, long l2, long l3) {
            long l4 = this.b((int)n2).c;
            return l4 == 0L || l2 + l4 < l3;
            {
            }
        }

        void b() {
            ++this.b;
        }

        void b(int n2, long l2) {
            a a2 = this.b(n2);
            a2.d = this.a(a2.d, l2);
        }

        boolean b(int n2, long l2, long l3) {
            long l4 = this.b((int)n2).d;
            return l4 == 0L || l2 + l4 < l3;
            {
            }
        }

        void c() {
            --this.b;
        }

        static class a {
            final ArrayList<x> a = new ArrayList();
            int b = 5;
            long c = 0L;
            long d = 0L;

            a() {
            }
        }

    }

    public final class p {
        final ArrayList<x> a = new ArrayList();
        ArrayList<x> b = null;
        final ArrayList<x> c = new ArrayList();
        int d = 2;
        o e;
        private final List<x> g = Collections.unmodifiableList(this.a);
        private int h = 2;
        private v i;

        private void a(ViewGroup viewGroup, boolean bl2) {
            int n2;
            for (n2 = viewGroup.getChildCount() - 1; n2 >= 0; --n2) {
                View view = viewGroup.getChildAt(n2);
                if (!(view instanceof ViewGroup)) continue;
                this.a((ViewGroup)view, true);
            }
            if (!bl2) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            n2 = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(n2);
        }

        private boolean a(x x2, int n2, int n3, long l2) {
            x2.p = RecyclerView.this;
            int n4 = x2.h();
            long l3 = RecyclerView.this.getNanoTime();
            if (l2 != Long.MAX_VALUE && !this.e.b(n4, l3, l2)) {
                return false;
            }
            RecyclerView.this.m.b(x2, n2);
            l2 = RecyclerView.this.getNanoTime();
            this.e.b(x2.h(), l2 - l3);
            this.e(x2);
            if (RecyclerView.this.D.a()) {
                x2.g = n3;
            }
            return true;
        }

        private void e(x x2) {
            if (RecyclerView.this.o()) {
                View view = x2.a;
                if (androidx.core.h.t.e(view) == 0) {
                    androidx.core.h.t.b(view, 1);
                }
                if (!androidx.core.h.t.b(view)) {
                    x2.b(16384);
                    androidx.core.h.t.a(view, RecyclerView.this.H.c());
                }
            }
        }

        private void f(x x2) {
            if (x2.a instanceof ViewGroup) {
                this.a((ViewGroup)x2.a, false);
            }
        }

        View a(int n2, boolean bl2) {
            return this.a((int)n2, (boolean)bl2, (long)Long.MAX_VALUE).a;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        x a(int var1_1, boolean var2_2, long var3_3) {
            block26 : {
                block34 : {
                    block33 : {
                        block32 : {
                            block30 : {
                                block31 : {
                                    block29 : {
                                        block28 : {
                                            block27 : {
                                                if (var1_1 < 0 || var1_1 >= RecyclerView.this.D.e()) break block26;
                                                var10_4 = RecyclerView.this.D.a();
                                                var9_5 = true;
                                                if (!var10_4) break block27;
                                                var15_7 = var16_6 = this.f(var1_1);
                                                if (var16_6 == null) break block28;
                                                var6_9 = 1;
                                                break block29;
                                            }
                                            var15_7 = null;
                                        }
                                        var6_9 = 0;
                                        var16_6 = var15_7;
                                    }
                                    var15_7 = var16_6;
                                    var5_10 = var6_9;
                                    if (var16_6 == null) {
                                        var15_7 = var16_6 = this.b(var1_1, var2_2);
                                        var5_10 = var6_9;
                                        if (var16_6 != null) {
                                            if (!this.a((x)var16_6)) {
                                                if (!var2_2) {
                                                    var16_6.b(4);
                                                    if (var16_6.i()) {
                                                        RecyclerView.this.removeDetachedView(var16_6.a, false);
                                                        var16_6.j();
                                                    } else if (var16_6.k()) {
                                                        var16_6.l();
                                                    }
                                                    this.b((x)var16_6);
                                                }
                                                var15_7 = null;
                                                var5_10 = var6_9;
                                            } else {
                                                var5_10 = 1;
                                                var15_7 = var16_6;
                                            }
                                        }
                                    }
                                    var16_6 = var15_7;
                                    var7_11 = var5_10;
                                    if (var15_7 != null) break block30;
                                    var7_11 = RecyclerView.this.f.b(var1_1);
                                    if (var7_11 < 0 || var7_11 >= RecyclerView.this.m.a()) break block31;
                                    var8_12 = RecyclerView.this.m.a(var7_11);
                                    var6_9 = var5_10;
                                    if (RecyclerView.this.m.b()) {
                                        var15_7 = var16_6 = this.a(RecyclerView.this.m.b(var7_11), var8_12, var2_2);
                                        var6_9 = var5_10;
                                        if (var16_6 != null) {
                                            var16_6.c = var7_11;
                                            var6_9 = 1;
                                            var15_7 = var16_6;
                                        }
                                    }
                                    var16_6 = var15_7;
                                    if (var15_7 == null) {
                                        var16_6 = var15_7;
                                        if (this.i != null) {
                                            var17_13 = this.i.a(this, var1_1, var8_12);
                                            var16_6 = var15_7;
                                            if (var17_13 != null) {
                                                var16_6 = RecyclerView.this.b(var17_13);
                                                if (var16_6 == null) {
                                                    var15_7 = new StringBuilder();
                                                    var15_7.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                                    var15_7.append(RecyclerView.this.a());
                                                    throw new IllegalArgumentException(var15_7.toString());
                                                }
                                                if (var16_6.c()) {
                                                    var15_7 = new StringBuilder();
                                                    var15_7.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                                    var15_7.append(RecyclerView.this.a());
                                                    throw new IllegalArgumentException(var15_7.toString());
                                                }
                                            }
                                        }
                                    }
                                    var15_7 = var16_6;
                                    if (var16_6 == null) {
                                        var15_7 = var16_6 = this.g().a(var8_12);
                                        if (var16_6 != null) {
                                            var16_6.v();
                                            var15_7 = var16_6;
                                            if (RecyclerView.a) {
                                                this.f((x)var16_6);
                                                var15_7 = var16_6;
                                            }
                                        }
                                    }
                                    var16_6 = var15_7;
                                    var7_11 = var6_9;
                                    if (var15_7 != null) break block30;
                                    var11_14 = RecyclerView.this.getNanoTime();
                                    if (var3_3 != Long.MAX_VALUE && !this.e.a(var8_12, var11_14, var3_3)) {
                                        return null;
                                    }
                                    var15_7 = RecyclerView.this.m.b(RecyclerView.this, var8_12);
                                    if (RecyclerView.d && (var16_6 = RecyclerView.j(var15_7.a)) != null) {
                                        var15_7.b = new WeakReference<Object>(var16_6);
                                    }
                                    var13_15 = RecyclerView.this.getNanoTime();
                                    this.e.a(var8_12, var13_15 - var11_14);
                                    break block32;
                                }
                                var15_7 = new StringBuilder();
                                var15_7.append("Inconsistency detected. Invalid item position ");
                                var15_7.append(var1_1);
                                var15_7.append("(offset:");
                                var15_7.append(var7_11);
                                var15_7.append(").");
                                var15_7.append("state:");
                                var15_7.append(RecyclerView.this.D.e());
                                var15_7.append(RecyclerView.this.a());
                                throw new IndexOutOfBoundsException(var15_7.toString());
                            }
                            var15_7 = var16_6;
                            var6_9 = var7_11;
                        }
                        if (var6_9 != 0 && !RecyclerView.this.D.a() && var15_7.a(8192)) {
                            var15_7.a(0, 8192);
                            if (RecyclerView.this.D.j) {
                                var5_10 = f.e((x)var15_7);
                                var16_6 = RecyclerView.this.z.a(RecyclerView.this.D, (x)var15_7, var5_10 | 4096, var15_7.u());
                                RecyclerView.this.a((x)var15_7, (f.c)var16_6);
                            }
                        }
                        if (!RecyclerView.this.D.a() || !var15_7.p()) break block33;
                        var15_7.g = var1_1;
                        ** GOTO lbl-1000
                    }
                    if (var15_7.p() && !var15_7.o() && !var15_7.n()) lbl-1000: // 2 sources:
                    {
                        var2_2 = false;
                    } else {
                        var2_2 = this.a((x)var15_7, RecyclerView.this.f.b(var1_1), var1_1, var3_3);
                    }
                    var16_6 = var15_7.a.getLayoutParams();
                    if (var16_6 != null) break block34;
                    var16_6 = RecyclerView.this.generateDefaultLayoutParams();
                    ** GOTO lbl125
                }
                if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)var16_6)) {
                    var16_6 = RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)var16_6);
lbl125: // 2 sources:
                    var16_6 = (j)var16_6;
                    var15_7.a.setLayoutParams((ViewGroup.LayoutParams)var16_6);
                } else {
                    var16_6 = (j)var16_6;
                }
                var16_6.c = var15_7;
                var2_2 = var6_9 != 0 && var2_2 != false ? var9_5 : false;
                var16_6.f = var2_2;
                return var15_7;
            }
            var15_8 = new StringBuilder();
            var15_8.append("Invalid item position ");
            var15_8.append(var1_1);
            var15_8.append("(");
            var15_8.append(var1_1);
            var15_8.append("). Item count:");
            var15_8.append(RecyclerView.this.D.e());
            var15_8.append(RecyclerView.this.a());
            throw new IndexOutOfBoundsException(var15_8.toString());
        }

        x a(long l2, int n2, boolean bl2) {
            int n3;
            x x2;
            for (n3 = this.a.size() - 1; n3 >= 0; --n3) {
                x2 = this.a.get(n3);
                if (x2.g() != l2 || x2.k()) continue;
                if (n2 == x2.h()) {
                    x2.b(32);
                    if (x2.q() && !RecyclerView.this.D.a()) {
                        x2.a(2, 14);
                    }
                    return x2;
                }
                if (bl2) continue;
                this.a.remove(n3);
                RecyclerView.this.removeDetachedView(x2.a, false);
                this.b(x2.a);
            }
            for (n3 = this.c.size() - 1; n3 >= 0; --n3) {
                x2 = this.c.get(n3);
                if (x2.g() != l2) continue;
                if (n2 == x2.h()) {
                    if (!bl2) {
                        this.c.remove(n3);
                    }
                    return x2;
                }
                if (bl2) continue;
                this.d(n3);
                return null;
            }
            return null;
        }

        public void a() {
            this.a.clear();
            this.d();
        }

        public void a(int n2) {
            this.h = n2;
            this.b();
        }

        void a(int n2, int n3) {
            int n4;
            int n5;
            int n6;
            if (n2 < n3) {
                n4 = n2;
                n5 = n3;
                n6 = -1;
            } else {
                n5 = n2;
                n4 = n3;
                n6 = 1;
            }
            int n7 = this.c.size();
            for (int i2 = 0; i2 < n7; ++i2) {
                x x2 = this.c.get(i2);
                if (x2 == null || x2.c < n4 || x2.c > n5) continue;
                if (x2.c == n2) {
                    x2.a(n3 - n2, false);
                    continue;
                }
                x2.a(n6, false);
            }
        }

        void a(int n2, int n3, boolean bl2) {
            for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
                x x2 = this.c.get(i2);
                if (x2 == null) continue;
                if (x2.c >= n2 + n3) {
                    x2.a(-n3, bl2);
                    continue;
                }
                if (x2.c < n2) continue;
                x2.b(8);
                this.d(i2);
            }
        }

        public void a(View view) {
            x x2 = RecyclerView.e(view);
            if (x2.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (x2.i()) {
                x2.j();
            } else if (x2.k()) {
                x2.l();
            }
            this.b(x2);
        }

        void a(a a2, a a3, boolean bl2) {
            this.a();
            this.g().a(a2, a3, bl2);
        }

        void a(o o2) {
            if (this.e != null) {
                this.e.c();
            }
            this.e = o2;
            if (this.e != null && RecyclerView.this.getAdapter() != null) {
                this.e.b();
            }
        }

        void a(v v2) {
            this.i = v2;
        }

        void a(x x2, boolean bl2) {
            RecyclerView.c(x2);
            if (x2.a(16384)) {
                x2.a(0, 16384);
                androidx.core.h.t.a(x2.a, null);
            }
            if (bl2) {
                this.d(x2);
            }
            x2.p = null;
            this.g().a(x2);
        }

        boolean a(x x2) {
            if (x2.q()) {
                return RecyclerView.this.D.a();
            }
            if (x2.c >= 0 && x2.c < RecyclerView.this.m.a()) {
                boolean bl2 = RecyclerView.this.D.a();
                boolean bl3 = false;
                if (!bl2 && RecyclerView.this.m.a(x2.c) != x2.h()) {
                    return false;
                }
                if (RecyclerView.this.m.b()) {
                    if (x2.g() == RecyclerView.this.m.b(x2.c)) {
                        bl3 = true;
                    }
                    return bl3;
                }
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
            stringBuilder.append(x2);
            stringBuilder.append(RecyclerView.this.a());
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        public int b(int n2) {
            if (n2 >= 0 && n2 < RecyclerView.this.D.e()) {
                if (!RecyclerView.this.D.a()) {
                    return n2;
                }
                return RecyclerView.this.f.b(n2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid position ");
            stringBuilder.append(n2);
            stringBuilder.append(". State ");
            stringBuilder.append("item count is ");
            stringBuilder.append(RecyclerView.this.D.e());
            stringBuilder.append(RecyclerView.this.a());
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }

        x b(int n2, boolean bl2) {
            x x2;
            Object object;
            int n3;
            int n4 = this.a.size();
            int n5 = 0;
            for (n3 = 0; n3 < n4; ++n3) {
                x2 = this.a.get(n3);
                if (x2.k() || x2.d() != n2 || x2.n() || !RecyclerView.this.D.g && x2.q()) continue;
                x2.b(32);
                return x2;
            }
            if (!bl2 && (object = RecyclerView.this.g.c(n2)) != null) {
                x2 = RecyclerView.e((View)object);
                RecyclerView.this.g.e((View)object);
                n2 = RecyclerView.this.g.b((View)object);
                if (n2 != -1) {
                    RecyclerView.this.g.e(n2);
                    this.c((View)object);
                    x2.b(8224);
                    return x2;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("layout index should not be -1 after unhiding a view:");
                ((StringBuilder)object).append(x2);
                ((StringBuilder)object).append(RecyclerView.this.a());
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            n4 = this.c.size();
            for (n3 = n5; n3 < n4; ++n3) {
                x2 = this.c.get(n3);
                if (x2.n() || x2.d() != n2) continue;
                if (!bl2) {
                    this.c.remove(n3);
                }
                return x2;
            }
            return null;
        }

        void b() {
            int n2 = RecyclerView.this.n != null ? RecyclerView.this.n.x : 0;
            this.d = this.h + n2;
            for (n2 = this.c.size() - 1; n2 >= 0 && this.c.size() > this.d; --n2) {
                this.d(n2);
            }
        }

        void b(int n2, int n3) {
            int n4 = this.c.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                x x2 = this.c.get(i2);
                if (x2 == null || x2.c < n2) continue;
                x2.a(n3, true);
            }
        }

        void b(View object) {
            object = RecyclerView.e((View)object);
            ((x)object).m = null;
            ((x)object).n = false;
            ((x)object).l();
            this.b((x)object);
        }

        void b(x object) {
            boolean bl2 = ((x)object).i();
            boolean bl3 = false;
            int n2 = 0;
            if (!bl2 && ((x)object).a.getParent() == null) {
                if (!((x)object).r()) {
                    if (!((x)object).c()) {
                        int n3;
                        bl3 = ((x)object).y();
                        int n4 = RecyclerView.this.m != null && bl3 && RecyclerView.this.m.b(object) ? 1 : 0;
                        if (n4 == 0 && !((x)object).w()) {
                            n4 = 0;
                            n3 = n2;
                            n2 = n4;
                        } else {
                            if (this.d > 0 && !((x)object).a(526)) {
                                n4 = n3 = this.c.size();
                                if (n3 >= this.d) {
                                    n4 = n3;
                                    if (n3 > 0) {
                                        this.d(0);
                                        n4 = n3 - 1;
                                    }
                                }
                                n3 = n4;
                                if (RecyclerView.d) {
                                    n3 = n4;
                                    if (n4 > 0) {
                                        n3 = n4--;
                                        if (!RecyclerView.this.C.a(((x)object).c)) {
                                            while (n4 >= 0 && RecyclerView.this.C.a(n3 = this.c.get((int)n4).c)) {
                                                --n4;
                                            }
                                            n3 = n4 + 1;
                                        }
                                    }
                                }
                                this.c.add(n3, (x)object);
                                n4 = 1;
                            } else {
                                n4 = 0;
                            }
                            n3 = n2;
                            n2 = n4;
                            if (n4 == 0) {
                                this.a((x)object, true);
                                n3 = 1;
                                n2 = n4;
                            }
                        }
                        RecyclerView.this.h.g((x)object);
                        if (n2 == 0 && n3 == 0 && bl3) {
                            ((x)object).p = null;
                        }
                        return;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                    ((StringBuilder)object).append(RecyclerView.this.a());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                stringBuilder.append(object);
                stringBuilder.append(RecyclerView.this.a());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
            stringBuilder.append(((x)object).i());
            stringBuilder.append(" isAttached:");
            if (((x)object).a.getParent() != null) {
                bl3 = true;
            }
            stringBuilder.append(bl3);
            stringBuilder.append(RecyclerView.this.a());
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public View c(int n2) {
            return this.a(n2, false);
        }

        public List<x> c() {
            return this.g;
        }

        void c(int n2, int n3) {
            for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
                int n4;
                x x2 = this.c.get(i2);
                if (x2 == null || (n4 = x2.c) < n2 || n4 >= n3 + n2) continue;
                x2.b(2);
                this.d(i2);
            }
        }

        void c(View object) {
            x x2 = RecyclerView.e((View)object);
            if (!x2.a(12) && x2.z() && !RecyclerView.this.b(x2)) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                x2.a(this, true);
                object = this.b;
            } else {
                if (x2.n() && !x2.q() && !RecyclerView.this.m.b()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                    ((StringBuilder)object).append(RecyclerView.this.a());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                x2.a(this, false);
                object = this.a;
            }
            ((ArrayList)object).add(x2);
        }

        /*
         * Enabled aggressive block sorting
         */
        void c(x x2) {
            ArrayList<x> arrayList = x2.n ? this.b : this.a;
            arrayList.remove(x2);
            x2.m = null;
            x2.n = false;
            x2.l();
        }

        void d() {
            for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
                this.d(i2);
            }
            this.c.clear();
            if (RecyclerView.d) {
                RecyclerView.this.C.a();
            }
        }

        void d(int n2) {
            this.a(this.c.get(n2), true);
            this.c.remove(n2);
        }

        void d(x x2) {
            if (RecyclerView.this.o != null) {
                RecyclerView.this.o.a(x2);
            }
            if (RecyclerView.this.m != null) {
                RecyclerView.this.m.a(x2);
            }
            if (RecyclerView.this.D != null) {
                RecyclerView.this.h.g(x2);
            }
        }

        int e() {
            return this.a.size();
        }

        View e(int n2) {
            return this.a.get((int)n2).a;
        }

        x f(int n2) {
            if (this.b != null) {
                x x2;
                int n3 = this.b.size();
                if (n3 == 0) {
                    return null;
                }
                int n4 = 0;
                for (int i2 = 0; i2 < n3; ++i2) {
                    x2 = this.b.get(i2);
                    if (x2.k() || x2.d() != n2) continue;
                    x2.b(32);
                    return x2;
                }
                if (RecyclerView.this.m.b() && (n2 = RecyclerView.this.f.b(n2)) > 0 && n2 < RecyclerView.this.m.a()) {
                    long l2 = RecyclerView.this.m.b(n2);
                    for (n2 = n4; n2 < n3; ++n2) {
                        x2 = this.b.get(n2);
                        if (x2.k() || x2.g() != l2) continue;
                        x2.b(32);
                        return x2;
                    }
                }
            }
            return null;
        }

        void f() {
            this.a.clear();
            if (this.b != null) {
                this.b.clear();
            }
        }

        o g() {
            if (this.e == null) {
                this.e = new o();
            }
            return this.e;
        }

        void h() {
            int n2 = this.c.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                x x2 = this.c.get(i2);
                if (x2 == null) continue;
                x2.b(6);
                x2.a((Object)null);
            }
            if (RecyclerView.this.m == null || !RecyclerView.this.m.b()) {
                this.d();
            }
        }

        void i() {
            int n2;
            int n3 = this.c.size();
            int n4 = 0;
            for (n2 = 0; n2 < n3; ++n2) {
                this.c.get(n2).a();
            }
            n3 = this.a.size();
            for (n2 = 0; n2 < n3; ++n2) {
                this.a.get(n2).a();
            }
            if (this.b != null) {
                n3 = this.b.size();
                for (n2 = n4; n2 < n3; ++n2) {
                    this.b.get(n2).a();
                }
            }
        }

        void j() {
            int n2 = this.c.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                j j2 = (j)this.c.get((int)i2).a.getLayoutParams();
                if (j2 == null) continue;
                j2.e = true;
            }
        }
    }

    public static interface q {
        public void a(x var1);
    }

    private class r
    extends c {
        r() {
        }

        @Override
        public void a() {
            RecyclerView.this.a((String)null);
            RecyclerView.this.D.f = true;
            RecyclerView.this.c(true);
            if (!RecyclerView.this.f.d()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override
        public void a(int n2, int n3, int n4) {
            RecyclerView.this.a((String)null);
            if (RecyclerView.this.f.a(n2, n3, n4)) {
                this.b();
            }
        }

        @Override
        public void a(int n2, int n3, Object object) {
            RecyclerView.this.a((String)null);
            if (RecyclerView.this.f.a(n2, n3, object)) {
                this.b();
            }
        }

        void b() {
            if (RecyclerView.c && RecyclerView.this.r && RecyclerView.this.q) {
                androidx.core.h.t.a((View)RecyclerView.this, RecyclerView.this.j);
                return;
            }
            RecyclerView.this.w = true;
            RecyclerView.this.requestLayout();
        }
    }

    public static class s
    extends androidx.e.a.a {
        public static final Parcelable.Creator<s> CREATOR = new Parcelable.ClassLoaderCreator<s>(){

            public s a(Parcel parcel) {
                return new s(parcel, null);
            }

            public s a(Parcel parcel, ClassLoader classLoader) {
                return new s(parcel, classLoader);
            }

            public s[] a(int n2) {
                return new s[n2];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return this.a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return this.a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int n2) {
                return this.a(n2);
            }
        };
        Parcelable a;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = i.class.getClassLoader();
            }
            this.a = parcel.readParcelable(classLoader);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }

        void a(s s2) {
            this.a = s2.a;
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeParcelable(this.a, 0);
        }

    }

    public static abstract class t {
        private int a;
        private RecyclerView b;
        private i c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;

        public int a(View view) {
            return this.b.f(view);
        }

        public i a() {
            return this.c;
        }

        public void a(int n2) {
            this.a = n2;
        }

        void a(int n2, int n3) {
            PointF pointF;
            RecyclerView recyclerView = this.b;
            if (!this.e || this.a == -1 || recyclerView == null) {
                this.b();
            }
            if (this.d && this.f == null && this.c != null && (pointF = this.b(this.a)) != null && (pointF.x != 0.0f || pointF.y != 0.0f)) {
                recyclerView.a((int)Math.signum(pointF.x), (int)Math.signum(pointF.y), (int[])null);
            }
            this.d = false;
            if (this.f != null) {
                if (this.a(this.f) == this.a) {
                    this.a(this.f, recyclerView.D, this.g);
                    this.g.a(recyclerView);
                    this.b();
                } else {
                    Log.e((String)"RecyclerView", (String)"Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                this.a(n2, n3, recyclerView.D, this.g);
                boolean bl2 = this.g.a();
                this.g.a(recyclerView);
                if (bl2) {
                    if (this.e) {
                        this.d = true;
                        recyclerView.A.a();
                        return;
                    }
                    this.b();
                }
            }
        }

        protected abstract void a(int var1, int var2, u var3, a var4);

        protected abstract void a(View var1, u var2, a var3);

        public PointF b(int n2) {
            Object object = this.a();
            if (object instanceof b) {
                return ((b)object).d(n2);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            ((StringBuilder)object).append(b.class.getCanonicalName());
            Log.w((String)"RecyclerView", (String)((StringBuilder)object).toString());
            return null;
        }

        protected final void b() {
            if (!this.e) {
                return;
            }
            this.e = false;
            this.f();
            this.b.D.a = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            this.c.a(this);
            this.c = null;
            this.b = null;
        }

        protected void b(View view) {
            if (this.a(view) == this.e()) {
                this.f = view;
            }
        }

        public boolean c() {
            return this.d;
        }

        public boolean d() {
            return this.e;
        }

        public int e() {
            return this.a;
        }

        protected abstract void f();

        public static class a {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.c >= 1) {
                    return;
                }
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            void a(RecyclerView recyclerView) {
                if (this.d >= 0) {
                    int n2 = this.d;
                    this.d = -1;
                    recyclerView.c(n2);
                    this.f = false;
                    return;
                }
                if (this.f) {
                    this.b();
                    if (this.e == null) {
                        if (this.c == Integer.MIN_VALUE) {
                            recyclerView.A.b(this.a, this.b);
                        } else {
                            recyclerView.A.a(this.a, this.b, this.c);
                        }
                    } else {
                        recyclerView.A.a(this.a, this.b, this.c, this.e);
                    }
                    ++this.g;
                    if (this.g > 10) {
                        Log.e((String)"RecyclerView", (String)"Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                    return;
                }
                this.g = 0;
            }

            boolean a() {
                return this.d >= 0;
            }
        }

        public static interface b {
            public PointF d(int var1);
        }

    }

    public static class u {
        int a = -1;
        int b = 0;
        int c = 0;
        int d = 1;
        int e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        void a(int n2) {
            if ((this.d & n2) != 0) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Layout state should be one of ");
            stringBuilder.append(Integer.toBinaryString(n2));
            stringBuilder.append(" but it is ");
            stringBuilder.append(Integer.toBinaryString(this.d));
            throw new IllegalStateException(stringBuilder.toString());
        }

        void a(a a2) {
            this.d = 1;
            this.e = a2.a();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.a;
        }

        public boolean d() {
            return this.a != -1;
        }

        public int e() {
            if (this.g) {
                return this.b - this.c;
            }
            return this.e;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("State{mTargetPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mData=");
            stringBuilder.append(this.q);
            stringBuilder.append(", mItemCount=");
            stringBuilder.append(this.e);
            stringBuilder.append(", mIsMeasuring=");
            stringBuilder.append(this.i);
            stringBuilder.append(", mPreviousLayoutItemCount=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mStructureChanged=");
            stringBuilder.append(this.f);
            stringBuilder.append(", mInPreLayout=");
            stringBuilder.append(this.g);
            stringBuilder.append(", mRunSimpleAnimations=");
            stringBuilder.append(this.j);
            stringBuilder.append(", mRunPredictiveAnimations=");
            stringBuilder.append(this.k);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static abstract class v {
        public abstract View a(p var1, int var2, int var3);
    }

    class w
    implements Runnable {
        OverScroller a;
        Interpolator b = RecyclerView.L;
        private int d;
        private int e;
        private boolean f = false;
        private boolean g = false;

        w() {
            this.a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.L);
        }

        private float a(float f2) {
            return (float)Math.sin((f2 - 0.5f) * 0.47123894f);
        }

        private int b(int n2, int n3, int n4, int n5) {
            int n6;
            int n7 = Math.abs(n2);
            boolean bl2 = n7 > (n6 = Math.abs(n3));
            n4 = (int)Math.sqrt(n4 * n4 + n5 * n5);
            n3 = (int)Math.sqrt(n2 * n2 + n3 * n3);
            n2 = bl2 ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            n5 = n2 / 2;
            float f2 = n3;
            float f3 = n2;
            float f4 = Math.min(1.0f, f2 * 1.0f / f3);
            f2 = n5;
            f4 = this.a(f4);
            if (n4 > 0) {
                n2 = Math.round(Math.abs((f2 + f4 * f2) / (float)n4) * 1000.0f) * 4;
            } else {
                n2 = bl2 ? n7 : n6;
                n2 = (int)(((float)n2 / f3 + 1.0f) * 300.0f);
            }
            return Math.min(n2, 2000);
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                this.a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            RecyclerView.this.removeCallbacks((Runnable)this);
            androidx.core.h.t.a((View)RecyclerView.this, this);
        }

        public void a(int n2, int n3) {
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.a.fling(0, 0, n2, n3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            this.a();
        }

        public void a(int n2, int n3, int n4) {
            this.a(n2, n3, n4, RecyclerView.L);
        }

        public void a(int n2, int n3, int n4, int n5) {
            this.a(n2, n3, this.b(n2, n3, n4, n5));
        }

        public void a(int n2, int n3, int n4, Interpolator interpolator) {
            if (this.b != interpolator) {
                this.b = interpolator;
                this.a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.e = 0;
            this.d = 0;
            this.a.startScroll(0, 0, n2, n3, n4);
            if (Build.VERSION.SDK_INT < 23) {
                this.a.computeScrollOffset();
            }
            this.a();
        }

        public void a(int n2, int n3, Interpolator interpolator) {
            int n4 = this.b(n2, n3, 0, 0);
            Interpolator interpolator2 = interpolator;
            if (interpolator == null) {
                interpolator2 = RecyclerView.L;
            }
            this.a(n2, n3, n4, interpolator2);
        }

        public void b() {
            RecyclerView.this.removeCallbacks((Runnable)this);
            this.a.abortAnimation();
        }

        public void b(int n2, int n3) {
            this.a(n2, n3, 0, 0);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public void run() {
            block32 : {
                block33 : {
                    block36 : {
                        block34 : {
                            block35 : {
                                if (RecyclerView.this.n == null) {
                                    this.b();
                                    return;
                                }
                                this.c();
                                RecyclerView.this.e();
                                var13_1 = this.a;
                                var14_2 = RecyclerView.this.n.t;
                                if (!var13_1.computeScrollOffset()) break block32;
                                var15_3 = RecyclerView.this.I;
                                var11_4 = var13_1.getCurrX();
                                var12_5 = var13_1.getCurrY();
                                var2_6 = var11_4 - this.d;
                                var1_7 = var12_5 - this.e;
                                this.d = var11_4;
                                this.e = var12_5;
                                var4_8 = var2_6;
                                var3_9 = var1_7;
                                if (RecyclerView.this.a(var2_6, var1_7, var15_3, null, 1)) {
                                    var4_8 = var2_6 - var15_3[0];
                                    var3_9 = var1_7 - var15_3[1];
                                }
                                if (RecyclerView.this.m != null) {
                                    RecyclerView.this.a(var4_8, var3_9, RecyclerView.this.J);
                                    var1_7 = RecyclerView.this.J[0];
                                    var2_6 = RecyclerView.this.J[1];
                                    var9_10 = var4_8 - var1_7;
                                    var10_11 = var3_9 - var2_6;
                                    var5_12 = var1_7;
                                    var8_13 = var2_6;
                                    var7_14 = var9_10;
                                    var6_15 = var10_11;
                                    if (var14_2 != null) {
                                        var5_12 = var1_7;
                                        var8_13 = var2_6;
                                        var7_14 = var9_10;
                                        var6_15 = var10_11;
                                        if (!var14_2.c()) {
                                            var5_12 = var1_7;
                                            var8_13 = var2_6;
                                            var7_14 = var9_10;
                                            var6_15 = var10_11;
                                            if (var14_2.d()) {
                                                var5_12 = RecyclerView.this.D.e();
                                                if (var5_12 == 0) {
                                                    var14_2.b();
                                                    var5_12 = var1_7;
                                                    var8_13 = var2_6;
                                                    var7_14 = var9_10;
                                                    var6_15 = var10_11;
                                                } else {
                                                    if (var14_2.e() >= var5_12) {
                                                        var14_2.a(var5_12 - 1);
                                                    }
                                                    var14_2.a(var4_8 - var9_10, var3_9 - var10_11);
                                                    var5_12 = var1_7;
                                                    var8_13 = var2_6;
                                                    var7_14 = var9_10;
                                                    var6_15 = var10_11;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    var5_12 = 0;
                                    var8_13 = 0;
                                    var7_14 = 0;
                                    var6_15 = 0;
                                }
                                if (!RecyclerView.this.p.isEmpty()) {
                                    RecyclerView.this.invalidate();
                                }
                                if (RecyclerView.this.getOverScrollMode() != 2) {
                                    RecyclerView.this.c(var4_8, var3_9);
                                }
                                if (RecyclerView.this.a(var5_12, var8_13, var7_14, var6_15, null, 1) || var7_14 == 0 && var6_15 == 0) break block33;
                                var2_6 = (int)var13_1.getCurrVelocity();
                                if (var7_14 == var11_4) ** GOTO lbl-1000
                                if (var7_14 < 0) {
                                    var1_7 = -var2_6;
                                } else if (var7_14 > 0) {
                                    var1_7 = var2_6;
                                } else lbl-1000: // 2 sources:
                                {
                                    var1_7 = 0;
                                }
                                if (var6_15 == var12_5) break block34;
                                if (var6_15 >= 0) break block35;
                                var2_6 = -var2_6;
                                break block36;
                            }
                            if (var6_15 > 0) break block36;
                        }
                        var2_6 = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.d(var1_7, var2_6);
                    }
                    if (!(var1_7 == 0 && var7_14 != var11_4 && var13_1.getFinalX() != 0 || var2_6 == 0 && var6_15 != var12_5 && var13_1.getFinalY() != 0)) {
                        var13_1.abortAnimation();
                    }
                }
                if (var5_12 != 0 || var8_13 != 0) {
                    RecyclerView.this.i(var5_12, var8_13);
                }
                if (!RecyclerView.a(RecyclerView.this)) {
                    RecyclerView.this.invalidate();
                }
                var1_7 = var3_9 != 0 && RecyclerView.this.n.f() != false && var8_13 == var3_9 ? 1 : 0;
                var2_6 = var4_8 != 0 && RecyclerView.this.n.e() != false && var5_12 == var4_8 ? 1 : 0;
                var1_7 = (var4_8 != 0 || var3_9 != 0) && var2_6 == 0 && var1_7 == 0 ? 0 : 1;
                if (!var13_1.isFinished() && (var1_7 != 0 || RecyclerView.this.i(1))) {
                    this.a();
                    if (RecyclerView.this.B != null) {
                        RecyclerView.this.B.a(RecyclerView.this, var4_8, var3_9);
                    }
                } else {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.d) {
                        RecyclerView.this.C.a();
                    }
                    RecyclerView.this.a(1);
                }
            }
            if (var14_2 != null) {
                if (var14_2.c()) {
                    var14_2.a(0, 0);
                }
                if (!this.g) {
                    var14_2.b();
                }
            }
            this.d();
        }
    }

    public static abstract class x {
        private static final List<Object> q = Collections.emptyList();
        public final View a;
        WeakReference<RecyclerView> b;
        int c = -1;
        int d = -1;
        long e = -1L;
        int f = -1;
        int g = -1;
        x h = null;
        x i = null;
        int j;
        List<Object> k = null;
        List<Object> l = null;
        p m = null;
        boolean n = false;
        int o = -1;
        RecyclerView p;
        private int r = 0;
        private int s = 0;

        public x(View view) {
            if (view != null) {
                this.a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void A() {
            if (this.k == null) {
                this.k = new ArrayList<Object>();
                this.l = Collections.unmodifiableList(this.k);
            }
        }

        void a() {
            this.d = -1;
            this.g = -1;
        }

        void a(int n2, int n3) {
            this.j = n2 & n3 | this.j & n3;
        }

        void a(int n2, int n3, boolean bl2) {
            this.b(8);
            this.a(n3, bl2);
            this.c = n2;
        }

        void a(int n2, boolean bl2) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (bl2) {
                this.g += n2;
            }
            this.c += n2;
            if (this.a.getLayoutParams() != null) {
                ((j)this.a.getLayoutParams()).e = true;
            }
        }

        void a(p p2, boolean bl2) {
            this.m = p2;
            this.n = bl2;
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(RecyclerView recyclerView) {
            int n2 = this.o != -1 ? this.o : androidx.core.h.t.e(this.a);
            this.s = n2;
            recyclerView.a(this, 4);
        }

        void a(Object object) {
            if (object == null) {
                this.b(1024);
                return;
            }
            if ((1024 & this.j) == 0) {
                this.A();
                this.k.add(object);
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a(boolean bl2) {
            block6 : {
                int n2;
                block5 : {
                    block4 : {
                        n2 = bl2 ? this.r - 1 : this.r + 1;
                        this.r = n2;
                        if (this.r < 0) {
                            this.r = 0;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                            stringBuilder.append(this);
                            Log.e((String)"View", (String)stringBuilder.toString());
                            return;
                        }
                        if (bl2 || this.r != 1) break block4;
                        n2 = this.j | 16;
                        break block5;
                    }
                    if (!bl2 || this.r != 0) break block6;
                    n2 = this.j & -17;
                }
                this.j = n2;
                return;
            }
        }

        boolean a(int n2) {
            return (n2 & this.j) != 0;
        }

        void b() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        void b(int n2) {
            this.j = n2 | this.j;
        }

        void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.s);
            this.s = 0;
        }

        boolean c() {
            return (this.j & 128) != 0;
        }

        public final int d() {
            if (this.g == -1) {
                return this.c;
            }
            return this.g;
        }

        public final int e() {
            if (this.p == null) {
                return -1;
            }
            return this.p.d(this);
        }

        public final int f() {
            return this.d;
        }

        public final long g() {
            return this.e;
        }

        public final int h() {
            return this.f;
        }

        boolean i() {
            return this.m != null;
        }

        void j() {
            this.m.c(this);
        }

        boolean k() {
            return (this.j & 32) != 0;
        }

        void l() {
            this.j &= -33;
        }

        void m() {
            this.j &= -257;
        }

        boolean n() {
            return (this.j & 4) != 0;
        }

        boolean o() {
            return (this.j & 2) != 0;
        }

        boolean p() {
            return (this.j & 1) != 0;
        }

        boolean q() {
            return (this.j & 8) != 0;
        }

        boolean r() {
            return (this.j & 256) != 0;
        }

        boolean s() {
            return (this.j & 512) != 0 || this.n();
            {
            }
        }

        void t() {
            if (this.k != null) {
                this.k.clear();
            }
            this.j &= -1025;
        }

        public String toString() {
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("ViewHolder{");
            ((StringBuilder)charSequence).append(Integer.toHexString(this.hashCode()));
            ((StringBuilder)charSequence).append(" position=");
            ((StringBuilder)charSequence).append(this.c);
            ((StringBuilder)charSequence).append(" id=");
            ((StringBuilder)charSequence).append(this.e);
            ((StringBuilder)charSequence).append(", oldPos=");
            ((StringBuilder)charSequence).append(this.d);
            ((StringBuilder)charSequence).append(", pLpos:");
            ((StringBuilder)charSequence).append(this.g);
            StringBuilder stringBuilder = new StringBuilder(((StringBuilder)charSequence).toString());
            if (this.i()) {
                stringBuilder.append(" scrap ");
                charSequence = this.n ? "[changeScrap]" : "[attachedScrap]";
                stringBuilder.append((String)charSequence);
            }
            if (this.n()) {
                stringBuilder.append(" invalid");
            }
            if (!this.p()) {
                stringBuilder.append(" unbound");
            }
            if (this.o()) {
                stringBuilder.append(" update");
            }
            if (this.q()) {
                stringBuilder.append(" removed");
            }
            if (this.c()) {
                stringBuilder.append(" ignored");
            }
            if (this.r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!this.w()) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(" not recyclable(");
                ((StringBuilder)charSequence).append(this.r);
                ((StringBuilder)charSequence).append(")");
                stringBuilder.append(((StringBuilder)charSequence).toString());
            }
            if (this.s()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        List<Object> u() {
            if ((this.j & 1024) == 0) {
                if (this.k != null && this.k.size() != 0) {
                    return this.l;
                }
                return q;
            }
            return q;
        }

        void v() {
            this.j = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.r = 0;
            this.h = null;
            this.i = null;
            this.t();
            this.s = 0;
            this.o = -1;
            RecyclerView.c(this);
        }

        public final boolean w() {
            return (this.j & 16) == 0 && !androidx.core.h.t.c(this.a);
        }

        boolean x() {
            return (this.j & 16) != 0;
        }

        boolean y() {
            return (this.j & 16) == 0 && androidx.core.h.t.c(this.a);
        }

        boolean z() {
            return (this.j & 2) != 0;
        }
    }

}

