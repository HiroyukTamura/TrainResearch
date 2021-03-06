/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.SoundEffectConstants
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.Scroller
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.h.ab;
import androidx.core.h.p;
import androidx.core.h.t;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
extends ViewGroup {
    static final int[] a = new int[]{16842931};
    private static final j ai;
    private static final Comparator<b> e;
    private static final Interpolator f;
    private int A = 1;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K = -1;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T = true;
    private boolean U = false;
    private boolean V;
    private int W;
    private List<f> aa;
    private f ab;
    private f ac;
    private List<e> ad;
    private g ae;
    private int af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new Runnable(){

        @Override
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.c();
        }
    };
    private int ak = 0;
    androidx.viewpager.widget.a b;
    int c;
    private int d;
    private final ArrayList<b> g = new ArrayList();
    private final b h = new b();
    private final Rect i = new Rect();
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private boolean n;
    private h o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t = -3.4028235E38f;
    private float u = Float.MAX_VALUE;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    static {
        e = new Comparator<b>(){

            public int a(b b2, b b3) {
                return b2.b - b3.b;
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((b)object, (b)object2);
            }
        };
        f = new Interpolator(){

            public float getInterpolation(float f2) {
                return (f2 -= 1.0f) * f2 * f2 * f2 * f2 + 1.0f;
            }
        };
        ai = new j();
    }

    public ViewPager(Context context) {
        super(context);
        this.a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
    }

    private int a(int n2, float f2, int n3, int n4) {
        if (Math.abs(n4) > this.O && Math.abs(n3) > this.M) {
            if (n3 <= 0) {
                ++n2;
            }
        } else {
            float f3 = n2 >= this.c ? 0.4f : 0.6f;
            n2 += (int)(f2 + f3);
        }
        n3 = n2;
        if (this.g.size() > 0) {
            b b2 = this.g.get(0);
            b b3 = this.g.get(this.g.size() - 1);
            n3 = Math.max(b2.b, Math.min(n2, b3.b));
        }
        return n3;
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect();
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        for (rect = view.getParent(); rect instanceof ViewGroup && rect != this; rect = rect.getParent()) {
            rect = (ViewGroup)rect;
            rect2.left += rect.getLeft();
            rect2.right += rect.getRight();
            rect2.top += rect.getTop();
            rect2.bottom += rect.getBottom();
        }
        return rect2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(int n2, int n3, int n4, int n5) {
        if (n3 > 0 && !this.g.isEmpty()) {
            if (!this.m.isFinished()) {
                this.m.setFinalX(this.getCurrentItem() * this.getClientWidth());
                return;
            }
            int n6 = this.getPaddingLeft();
            int n7 = this.getPaddingRight();
            int n8 = this.getPaddingLeft();
            int n9 = this.getPaddingRight();
            n2 = (int)((float)this.getScrollX() / (float)(n3 - n8 - n9 + n5) * (float)(n2 - n6 - n7 + n4));
        } else {
            b b2 = this.b(this.c);
            float f2 = b2 != null ? Math.min(b2.e, this.u) : 0.0f;
            n2 = (int)(f2 * (float)(n2 - this.getPaddingLeft() - this.getPaddingRight()));
            if (n2 == this.getScrollX()) {
                return;
            }
            this.a(false);
        }
        this.scrollTo(n2, this.getScrollY());
    }

    private void a(int n2, boolean bl2, int n3, boolean bl3) {
        b b2 = this.b(n2);
        int n4 = b2 != null ? (int)((float)this.getClientWidth() * Math.max(this.t, Math.min(b2.e, this.u))) : 0;
        if (bl2) {
            this.a(n4, 0, n3);
            if (bl3) {
                this.e(n2);
                return;
            }
        } else {
            if (bl3) {
                this.e(n2);
            }
            this.a(false);
            this.scrollTo(n4, 0);
            this.d(n4);
        }
    }

    private void a(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n2) == this.K) {
            n2 = n2 == 0 ? 1 : 0;
            this.G = motionEvent.getX(n2);
            this.K = motionEvent.getPointerId(n2);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void a(b b2, int n2, b b3) {
        int n3;
        float f2;
        int n4;
        float f3;
        int n5 = this.b.b();
        int n6 = this.getClientWidth();
        float f4 = n6 > 0 ? (float)this.p / (float)n6 : 0.0f;
        if (b3 != null) {
            n6 = b3.b;
            if (n6 < b2.b) {
                f3 = b3.e + b3.d + f4;
                ++n6;
                n4 = 0;
                while (n6 <= b2.b && n4 < this.g.size()) {
                    do {
                        b3 = this.g.get(n4);
                        n3 = n6;
                        f2 = f3;
                        if (n6 <= b3.b) break;
                        n3 = n6;
                        f2 = f3;
                        if (n4 >= this.g.size() - 1) break;
                        ++n4;
                    } while (true);
                    while (n3 < b3.b) {
                        f2 += this.b.d(n3) + f4;
                        ++n3;
                    }
                    b3.e = f2;
                    f3 = f2 + (b3.d + f4);
                    n6 = n3 + 1;
                }
            } else if (n6 > b2.b) {
                n4 = this.g.size() - 1;
                f3 = b3.e;
                --n6;
                while (n6 >= b2.b && n4 >= 0) {
                    do {
                        b3 = this.g.get(n4);
                        n3 = n6;
                        f2 = f3;
                        if (n6 >= b3.b) break;
                        n3 = n6;
                        f2 = f3;
                        if (n4 <= 0) break;
                        --n4;
                    } while (true);
                    while (n3 > b3.b) {
                        f2 -= this.b.d(n3) + f4;
                        --n3;
                    }
                    b3.e = f3 = f2 - (b3.d + f4);
                    n6 = n3 - 1;
                }
            }
        }
        n3 = this.g.size();
        f2 = b2.e;
        n6 = b2.b - 1;
        f3 = b2.b == 0 ? b2.e : -3.4028235E38f;
        this.t = f3;
        n4 = b2.b;
        f3 = n4 == --n5 ? b2.e + b2.d - 1.0f : Float.MAX_VALUE;
        this.u = f3;
        n4 = n2 - 1;
        f3 = f2;
        while (n4 >= 0) {
            b3 = this.g.get(n4);
            while (n6 > b3.b) {
                f3 -= this.b.d(n6) + f4;
                --n6;
            }
            b3.e = f3 -= b3.d + f4;
            if (b3.b == 0) {
                this.t = f3;
            }
            --n4;
            --n6;
        }
        f3 = b2.e + b2.d + f4;
        n4 = b2.b + 1;
        n6 = n2 + 1;
        n2 = n4;
        while (n6 < n3) {
            b2 = this.g.get(n6);
            while (n2 < b2.b) {
                f3 += this.b.d(n2) + f4;
                ++n2;
            }
            if (b2.b == n5) {
                this.u = b2.d + f3 - 1.0f;
            }
            b2.e = f3;
            f3 += b2.d + f4;
            ++n6;
            ++n2;
        }
        this.U = false;
    }

    private void a(boolean bl2) {
        int n2;
        int n3;
        int n4 = this.ak == 2 ? 1 : 0;
        if (n4 != 0) {
            this.setScrollingCacheEnabled(false);
            if (this.m.isFinished() ^ true) {
                this.m.abortAnimation();
                n2 = this.getScrollX();
                n3 = this.getScrollY();
                int n5 = this.m.getCurrX();
                int n6 = this.m.getCurrY();
                if (n2 != n5 || n3 != n6) {
                    this.scrollTo(n5, n6);
                    if (n5 != n2) {
                        this.d(n5);
                    }
                }
            }
        }
        this.z = false;
        n3 = 0;
        n2 = n4;
        for (n4 = n3; n4 < this.g.size(); ++n4) {
            b b2 = this.g.get(n4);
            if (!b2.c) continue;
            b2.c = false;
            n2 = 1;
        }
        if (n2 != 0) {
            if (bl2) {
                t.a((View)this, this.aj);
                return;
            }
            this.aj.run();
        }
    }

    private boolean a(float f2, float f3) {
        return f2 < (float)this.E && f3 > 0.0f || f2 > (float)(this.getWidth() - this.E) && f3 < 0.0f;
    }

    private void b(int n2, float f2, int n3) {
        if (this.ab != null) {
            this.ab.a(n2, f2, n3);
        }
        if (this.aa != null) {
            int n4 = this.aa.size();
            for (int i2 = 0; i2 < n4; ++i2) {
                f f3 = this.aa.get(i2);
                if (f3 == null) continue;
                f3.a(n2, f2, n3);
            }
        }
        if (this.ac != null) {
            this.ac.a(n2, f2, n3);
        }
    }

    private void b(boolean bl2) {
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = bl2 ? this.af : 0;
            this.getChildAt(i2).setLayerType(n3, null);
        }
    }

    private boolean b(float f2) {
        boolean bl2;
        int n2;
        float f3 = this.G;
        this.G = f2;
        float f4 = (float)this.getScrollX() + (f3 - f2);
        float f5 = this.getClientWidth();
        f2 = this.t * f5;
        f3 = this.u * f5;
        Object object = this.g;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        object = ((ArrayList)object).get(0);
        b b2 = this.g.get(this.g.size() - 1);
        if (((b)object).b != 0) {
            f2 = ((b)object).e * f5;
            n2 = 0;
        } else {
            n2 = 1;
        }
        if (b2.b != this.b.b() - 1) {
            f3 = b2.e * f5;
            bl2 = false;
        } else {
            bl2 = true;
        }
        if (f4 < f2) {
            if (n2 != 0) {
                this.R.onPull(Math.abs(f2 - f4) / f5);
                bl5 = true;
            }
        } else {
            bl5 = bl4;
            f2 = f4;
            if (f4 > f3) {
                bl5 = bl3;
                if (bl2) {
                    this.S.onPull(Math.abs(f4 - f3) / f5);
                    bl5 = true;
                }
                f2 = f3;
            }
        }
        f3 = this.G;
        n2 = (int)f2;
        this.G = f3 + (f2 - (float)n2);
        this.scrollTo(n2, this.getScrollY());
        this.d(n2);
        return bl5;
    }

    private void c(boolean bl2) {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    private boolean d(int n2) {
        if (this.g.size() == 0) {
            if (this.T) {
                return false;
            }
            this.V = false;
            this.a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b b2 = this.i();
        int n3 = this.getClientWidth();
        int n4 = this.p;
        float f2 = this.p;
        float f3 = n3;
        int n5 = b2.b;
        f3 = ((float)n2 / f3 - b2.e) / (b2.d + (f2 /= f3));
        n2 = (int)((float)(n4 + n3) * f3);
        this.V = false;
        this.a(n5, f3, n2);
        if (this.V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void e(int n2) {
        if (this.ab != null) {
            this.ab.a(n2);
        }
        if (this.aa != null) {
            int n3 = this.aa.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                f f2 = this.aa.get(i2);
                if (f2 == null) continue;
                f2.a(n2);
            }
        }
        if (this.ac != null) {
            this.ac.a(n2);
        }
    }

    private void f() {
        int n2 = 0;
        while (n2 < this.getChildCount()) {
            int n3 = n2;
            if (!((c)this.getChildAt((int)n2).getLayoutParams()).a) {
                this.removeViewAt(n2);
                n3 = n2 - 1;
            }
            n2 = n3 + 1;
        }
    }

    private void f(int n2) {
        if (this.ab != null) {
            this.ab.b(n2);
        }
        if (this.aa != null) {
            int n3 = this.aa.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                f f2 = this.aa.get(i2);
                if (f2 == null) continue;
                f2.b(n2);
            }
        }
        if (this.ac != null) {
            this.ac.b(n2);
        }
    }

    private void g() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int n2 = this.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = this.getChildAt(i2);
                this.ah.add(view);
            }
            Collections.sort(this.ah, ai);
        }
    }

    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }

    private boolean h() {
        this.K = -1;
        this.j();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
        {
        }
    }

    private b i() {
        int n2 = this.getClientWidth();
        float f2 = n2 > 0 ? (float)this.getScrollX() / (float)n2 : 0.0f;
        float f3 = n2 > 0 ? (float)this.p / (float)n2 : 0.0f;
        b b2 = null;
        n2 = 0;
        boolean bl2 = true;
        int n3 = -1;
        float f4 = 0.0f;
        float f5 = 0.0f;
        while (n2 < this.g.size()) {
            b b3 = this.g.get(n2);
            int n4 = n2;
            b b4 = b3;
            if (!bl2) {
                int n5 = b3.b;
                n4 = n2;
                b4 = b3;
                if (n5 != ++n3) {
                    b4 = this.h;
                    b4.e = f4 + f5 + f3;
                    b4.b = n3;
                    b4.d = this.b.d(b4.b);
                    n4 = n2 - 1;
                }
            }
            f4 = b4.e;
            f5 = b4.d;
            if (!bl2 && !(f2 >= f4)) {
                return b2;
            }
            if (!(f2 < f5 + f4 + f3)) {
                if (n4 == this.g.size() - 1) {
                    return b4;
                }
                n3 = b4.b;
                f5 = b4.d;
                n2 = n4 + 1;
                bl2 = false;
                b2 = b4;
                continue;
            }
            return b4;
        }
        return b2;
    }

    private void j() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean bl2) {
        if (this.y != bl2) {
            this.y = bl2;
        }
    }

    float a(float f2) {
        return (float)Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    b a(int n2, int n3) {
        b b2 = new b();
        b2.b = n2;
        b2.a = this.b.a(this, n2);
        b2.d = this.b.d(n2);
        if (n3 >= 0 && n3 < this.g.size()) {
            this.g.add(n3, b2);
            return b2;
        }
        this.g.add(b2);
        return b2;
    }

    b a(View view) {
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            b b2 = this.g.get(i2);
            if (!this.b.a(view, b2.a)) continue;
            return b2;
        }
        return null;
    }

    void a() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        this.setFocusable(true);
        Context context = this.getContext();
        this.m = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int)(400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int)(25.0f * f2);
        this.P = (int)(2.0f * f2);
        this.D = (int)(f2 * 16.0f);
        t.a((View)this, new d());
        if (t.e((View)this) == 0) {
            t.b((View)this, 1);
        }
        t.a((View)this, new p(){
            private final Rect b = new Rect();

            @Override
            public ab a(View object, ab ab2) {
                if (((ab)(object = t.a((View)object, ab2))).e()) {
                    return object;
                }
                ab2 = this.b;
                ((Rect)ab2).left = ((ab)object).a();
                ((Rect)ab2).top = ((ab)object).b();
                ((Rect)ab2).right = ((ab)object).c();
                ((Rect)ab2).bottom = ((ab)object).d();
                int n2 = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ab ab3 = t.b(ViewPager.this.getChildAt(i2), (ab)object);
                    ((Rect)ab2).left = Math.min(ab3.a(), ((Rect)ab2).left);
                    ((Rect)ab2).top = Math.min(ab3.b(), ((Rect)ab2).top);
                    ((Rect)ab2).right = Math.min(ab3.c(), ((Rect)ab2).right);
                    ((Rect)ab2).bottom = Math.min(ab3.d(), ((Rect)ab2).bottom);
                }
                return ((ab)object).a(((Rect)ab2).left, ((Rect)ab2).top, ((Rect)ab2).right, ((Rect)ab2).bottom);
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    void a(int var1_1) {
        block30 : {
            block34 : {
                block29 : {
                    if (this.c != var1_1) {
                        var14_2 = this.b(this.c);
                        this.c = var1_1;
                    } else {
                        var14_2 = null;
                    }
                    if (this.b == null) {
                        this.g();
                        return;
                    }
                    if (this.z) {
                        this.g();
                        return;
                    }
                    if (this.getWindowToken() == null) {
                        return;
                    }
                    this.b.a(this);
                    var1_1 = this.A;
                    var11_3 = Math.max(0, this.c - var1_1);
                    var9_4 = this.b.b();
                    var10_5 = Math.min(var9_4 - 1, this.c + var1_1);
                    if (var9_4 == this.d) {
                    } else {
                        block28 : {
                            try {
                                var13_39 = this.getResources().getResourceName(this.getId());
                                break block28;
                            }
                            catch (Resources.NotFoundException var13_40) {}
                            var13_41 = Integer.toHexString(this.getId());
                        }
                        var14_2 = new StringBuilder();
                        var14_2.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
                        var14_2.append(this.d);
                        var14_2.append(", found: ");
                        var14_2.append(var9_4);
                        var14_2.append(" Pager id: ");
                        var14_2.append((String)var13_42);
                        var14_2.append(" Pager class: ");
                        var14_2.append(this.getClass());
                        var14_2.append(" Problematic adapter: ");
                        var14_2.append(this.b.getClass());
                        throw new IllegalStateException(var14_2.toString());
                    }
                    for (var1_1 = 0; var1_1 < this.g.size(); ++var1_1) {
                        var13_6 = this.g.get(var1_1);
                        if (var13_6.b < this.c) continue;
                        if (var13_6.b != this.c) break;
                        break block29;
                    }
                    var13_7 = null;
                }
                var15_43 = var13_8;
                if (var13_8 == null) {
                    var15_43 = var13_8;
                    if (var9_4 > 0) {
                        var15_43 = this.a(this.c, var1_1);
                    }
                }
                if (var15_43 == null) break block30;
                var5_44 = var1_1 - 1;
                if (var5_44 >= 0) {
                    var13_9 = this.g.get(var5_44);
                } else {
                    var13_10 = null;
                }
                var12_45 = this.getClientWidth();
                var4_46 = var12_45 <= 0 ? 0.0f : 2.0f - var15_43.d + (float)this.getPaddingLeft() / (float)var12_45;
                var3_48 = 0.0f;
                for (var8_47 = this.c - 1; var8_47 >= 0; --var8_47) {
                    block32 : {
                        block33 : {
                            block31 : {
                                if (!(var3_48 >= var4_46) || var8_47 >= var11_3) break block31;
                                if (var13_12 == null) break;
                                var2_49 = var3_48;
                                var7_51 = var5_44;
                                var16_53 = var13_12;
                                var6_50 = var1_1;
                                if (var8_47 != var13_12.b) break block32;
                                var2_49 = var3_48;
                                var7_51 = var5_44;
                                var16_54 = var13_12;
                                var6_50 = var1_1--;
                                if (var13_12.c) break block32;
                                this.g.remove(var5_44);
                                this.b.a(this, var8_47, var13_12.a);
                                var2_49 = var3_48;
                                var6_50 = --var5_44;
                                var7_51 = var1_1;
                                if (var5_44 < 0) ** GOTO lbl-1000
                                ** GOTO lbl-1000
                            }
                            if (var13_12 == null || var8_47 != var13_12.b) break block33;
                            var2_49 = var3_48 += var13_12.d;
                            var6_50 = --var5_44;
                            var7_51 = var1_1;
                            if (var5_44 < 0) ** GOTO lbl-1000
                            ** GOTO lbl-1000
                        }
                        var2_49 = var3_48 += this.a((int)var8_47, (int)(var5_44 + 1)).d;
                        var6_50 = var5_44;
                        var7_51 = ++var1_1;
                        if (var5_44 >= 0) lbl-1000: // 3 sources:
                        {
                            var13_13 = this.g.get(var5_44);
                            var2_49 = var3_48;
                        } else lbl-1000: // 3 sources:
                        {
                            var13_14 = null;
                            var1_1 = var7_51;
                            var5_44 = var6_50;
                        }
                        var6_50 = var1_1;
                        var16_55 = var13_15;
                        var7_51 = var5_44;
                    }
                    var3_48 = var2_49;
                    var5_44 = var7_51;
                    var13_17 = var16_52;
                    var1_1 = var6_50;
                }
                var3_48 = var15_43.d;
                var5_44 = var1_1 + 1;
                if (!(var3_48 < 2.0f)) break block34;
                if (var5_44 < this.g.size()) {
                    var13_18 = this.g.get(var5_44);
                } else {
                    var13_19 = null;
                }
                var4_46 = var12_45 <= 0 ? 0.0f : (float)this.getPaddingRight() / (float)var12_45 + 2.0f;
                var6_50 = this.c;
                var16_56 = var13_20;
                while ((var7_51 = var6_50 + 1) < var9_4) {
                    block36 : {
                        block37 : {
                            block35 : {
                                if (!(var3_48 >= var4_46) || var7_51 <= var10_5) break block35;
                                if (var16_57 == null) break;
                                var2_49 = var3_48;
                                var6_50 = var5_44;
                                var13_22 = var16_57;
                                if (var7_51 != var16_57.b) break block36;
                                var2_49 = var3_48;
                                var6_50 = var5_44;
                                var13_23 = var16_57;
                                if (var16_57.c) break block36;
                                this.g.remove(var5_44);
                                this.b.a(this, var7_51, var16_57.a);
                                var2_49 = var3_48;
                                var6_50 = var5_44;
                                if (var5_44 >= this.g.size()) ** GOTO lbl-1000
                                ** GOTO lbl-1000
                            }
                            if (var16_57 == null || var7_51 != var16_57.b) break block37;
                            var2_49 = var3_48 += var16_57.d;
                            var6_50 = ++var5_44;
                            if (var5_44 >= this.g.size()) ** GOTO lbl-1000
                            ** GOTO lbl-1000
                        }
                        var13_27 = this.a(var7_51, var5_44);
                        var2_49 = var3_48 += var13_27.d;
                        var6_50 = ++var5_44;
                        if (var5_44 < this.g.size()) lbl-1000: // 3 sources:
                        {
                            var13_25 = this.g.get(var5_44);
                            var2_49 = var3_48;
                            var6_50 = var5_44;
                        } else lbl-1000: // 3 sources:
                        {
                            var13_26 = null;
                        }
                    }
                    var3_48 = var2_49;
                    var5_44 = var6_50;
                    var16_58 = var13_28;
                    var6_50 = var7_51;
                }
            }
            this.a(var15_43, var1_1, (b)var14_2);
            this.b.b(this, this.c, var15_43.a);
        }
        this.b.b(this);
        var5_44 = this.getChildCount();
        for (var1_1 = 0; var1_1 < var5_44; ++var1_1) {
            var14_2 = this.getChildAt(var1_1);
            var13_32 = (c)var14_2.getLayoutParams();
            var13_32.f = var1_1;
            if (var13_32.a || var13_32.c != 0.0f || (var14_2 = this.a((View)var14_2)) == null) continue;
            var13_32.c = var14_2.d;
            var13_32.e = var14_2.b;
        }
        this.g();
        if (this.hasFocus() == false) return;
        var13_33 = this.findFocus();
        if (var13_33 != null) {
            var13_34 = this.b(var13_33);
        } else {
            var13_35 = null;
        }
        if (var13_36 != null) {
            if (var13_36.b == this.c) return;
        }
        var1_1 = 0;
        while (var1_1 < this.getChildCount()) {
            var13_38 = this.getChildAt(var1_1);
            var14_2 = this.a(var13_38);
            if (var14_2 != null && var14_2.b == this.c && var13_38.requestFocus(2)) {
                return;
            }
            ++var1_1;
        }
    }

    protected void a(int n2, float f2, int n3) {
        View view;
        int n4 = this.W;
        int n5 = 0;
        if (n4 > 0) {
            int n6 = this.getScrollX();
            n4 = this.getPaddingLeft();
            int n7 = this.getPaddingRight();
            int n8 = this.getWidth();
            int n9 = this.getChildCount();
            for (int i2 = 0; i2 < n9; ++i2) {
                view = this.getChildAt(i2);
                c c2 = (c)view.getLayoutParams();
                if (!c2.a) continue;
                int n10 = c2.b & 7;
                if (n10 != 1) {
                    int n11;
                    if (n10 != 3) {
                        if (n10 != 5) {
                            n11 = n4;
                            n10 = n4;
                            n4 = n11;
                        } else {
                            n10 = n8 - n7 - view.getMeasuredWidth();
                            n7 += view.getMeasuredWidth();
                        }
                    } else {
                        n11 = view.getWidth() + n4;
                        n10 = n4;
                        n4 = n11;
                    }
                } else {
                    n10 = Math.max((n8 - view.getMeasuredWidth()) / 2, n4);
                }
                n10 = n10 + n6 - view.getLeft();
                if (n10 == 0) continue;
                view.offsetLeftAndRight(n10);
            }
        }
        this.b(n2, f2, n3);
        if (this.ae != null) {
            n3 = this.getScrollX();
            n4 = this.getChildCount();
            for (n2 = n5; n2 < n4; ++n2) {
                view = this.getChildAt(n2);
                if (((c)view.getLayoutParams()).a) continue;
                f2 = (float)(view.getLeft() - n3) / (float)this.getClientWidth();
                this.ae.a(view, f2);
            }
        }
        this.V = true;
    }

    void a(int n2, int n3, int n4) {
        if (this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        int n5 = this.m != null && !this.m.isFinished() ? 1 : 0;
        if (n5 != 0) {
            n5 = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            this.setScrollingCacheEnabled(false);
        } else {
            n5 = this.getScrollX();
        }
        int n6 = this.getScrollY();
        int n7 = n2 - n5;
        if (n7 == 0 && (n3 -= n6) == 0) {
            this.a(false);
            this.c();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        n2 = this.getClientWidth();
        int n8 = n2 / 2;
        float f2 = Math.abs(n7);
        float f3 = n2;
        float f4 = Math.min(1.0f, f2 * 1.0f / f3);
        f2 = n8;
        f4 = this.a(f4);
        n2 = Math.abs(n4);
        if (n2 > 0) {
            n2 = Math.round(Math.abs((f2 + f4 * f2) / (float)n2) * 1000.0f) * 4;
        } else {
            f2 = this.b.d(this.c);
            n2 = (int)(((float)Math.abs(n7) / (f3 * f2 + (float)this.p) + 1.0f) * 100.0f);
        }
        n2 = Math.min(n2, 600);
        this.n = false;
        this.m.startScroll(n5, n6, n7, n3, n2);
        t.d((View)this);
    }

    public void a(int n2, boolean bl2) {
        this.z = false;
        this.a(n2, bl2, false);
    }

    void a(int n2, boolean bl2, boolean bl3) {
        this.a(n2, bl2, bl3, 0);
    }

    void a(int n2, boolean bl2, boolean bl3, int n3) {
        if (this.b != null && this.b.b() > 0) {
            int n4;
            if (!bl3 && this.c == n2 && this.g.size() != 0) {
                this.setScrollingCacheEnabled(false);
                return;
            }
            bl3 = true;
            if (n2 < 0) {
                n4 = 0;
            } else {
                n4 = n2;
                if (n2 >= this.b.b()) {
                    n4 = this.b.b() - 1;
                }
            }
            n2 = this.A;
            if (n4 > this.c + n2 || n4 < this.c - n2) {
                for (n2 = 0; n2 < this.g.size(); ++n2) {
                    this.g.get((int)n2).c = true;
                }
            }
            if (this.c == n4) {
                bl3 = false;
            }
            if (this.T) {
                this.c = n4;
                if (bl3) {
                    this.e(n4);
                }
                this.requestLayout();
                return;
            }
            this.a(n4);
            this.a(n4, bl2, n3, bl3);
            return;
        }
        this.setScrollingCacheEnabled(false);
    }

    public void a(e e2) {
        if (this.ad == null) {
            this.ad = new ArrayList<e>();
        }
        this.ad.add(e2);
    }

    public void a(f f2) {
        if (this.aa == null) {
            this.aa = new ArrayList<f>();
        }
        this.aa.add(f2);
    }

    public boolean a(KeyEvent keyEvent) {
        block8 : {
            block9 : {
                if (keyEvent.getAction() != 0) break block8;
                int n2 = keyEvent.getKeyCode();
                if (n2 == 61) break block9;
                switch (n2) {
                    default: {
                        break block8;
                    }
                    case 22: {
                        if (keyEvent.hasModifiers(2)) {
                            return this.e();
                        }
                        n2 = 66;
                        break;
                    }
                    case 21: {
                        if (keyEvent.hasModifiers(2)) {
                            return this.d();
                        }
                        n2 = 17;
                    }
                }
                return this.c(n2);
            }
            if (keyEvent.hasNoModifiers()) {
                return this.c(2);
            }
            if (keyEvent.hasModifiers(1)) {
                return this.c(1);
            }
        }
        return false;
    }

    protected boolean a(View view, boolean bl2, int n2, int n3, int n4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n5 = view.getScrollX();
            int n6 = view.getScrollY();
            for (int i2 = viewGroup.getChildCount() - 1; i2 >= 0; --i2) {
                int n7;
                int n8 = n3 + n5;
                View view2 = viewGroup.getChildAt(i2);
                if (n8 < view2.getLeft() || n8 >= view2.getRight() || (n7 = n4 + n6) < view2.getTop() || n7 >= view2.getBottom() || !this.a(view2, true, n2, n8 - view2.getLeft(), n7 - view2.getTop())) continue;
                return true;
            }
        }
        return bl2 && view.canScrollHorizontally(-n2);
    }

    public void addFocusables(ArrayList<View> arrayList, int n2, int n3) {
        int n4 = arrayList.size();
        int n5 = this.getDescendantFocusability();
        if (n5 != 393216) {
            for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
                b b2;
                View view = this.getChildAt(i2);
                if (view.getVisibility() != 0 || (b2 = this.a(view)) == null || b2.b != this.c) continue;
                view.addFocusables(arrayList, n2, n3);
            }
        }
        if (n5 != 262144 || n4 == arrayList.size()) {
            if (!this.isFocusable()) {
                return;
            }
            if ((n3 & 1) == 1 && this.isInTouchMode() && !this.isFocusableInTouchMode()) {
                return;
            }
            if (arrayList != null) {
                arrayList.add((View)this);
            }
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            b b2;
            View view = this.getChildAt(i2);
            if (view.getVisibility() != 0 || (b2 = this.a(view)) == null || b2.b != this.c) continue;
            view.addTouchables(arrayList);
        }
    }

    public void addView(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (!this.checkLayoutParams(layoutParams)) {
            layoutParams2 = this.generateLayoutParams(layoutParams);
        }
        layoutParams = (c)layoutParams2;
        layoutParams.a |= ViewPager.c(view);
        if (this.x) {
            if (layoutParams != null && layoutParams.a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams.d = true;
            this.addViewInLayout(view, n2, layoutParams2);
            return;
        }
        super.addView(view, n2, layoutParams2);
    }

    b b(int n2) {
        for (int i2 = 0; i2 < this.g.size(); ++i2) {
            b b2 = this.g.get(i2);
            if (b2.b != n2) continue;
            return b2;
        }
        return null;
    }

    b b(View view) {
        ViewParent viewParent;
        while ((viewParent = view.getParent()) != this) {
            if (viewParent != null && viewParent instanceof View) {
                view = (View)viewParent;
                continue;
            }
            return null;
        }
        return this.a(view);
    }

    /*
     * Enabled aggressive block sorting
     */
    void b() {
        int n2;
        this.d = n2 = this.b.b();
        int n3 = this.g.size() < this.A * 2 + 1 && this.g.size() < n2 ? 1 : 0;
        int n4 = this.c;
        int n5 = n3;
        n3 = n4;
        int n6 = 0;
        n4 = 0;
        while (n6 < this.g.size()) {
            int n7;
            int n8;
            int n9;
            block12 : {
                block14 : {
                    int n10;
                    b b2;
                    block13 : {
                        block11 : {
                            b2 = this.g.get(n6);
                            n10 = this.b.a(b2.a);
                            if (n10 != -1) break block11;
                            n7 = n6;
                            n8 = n4;
                            n9 = n3;
                            break block12;
                        }
                        if (n10 != -2) break block13;
                        this.g.remove(n6);
                        n8 = n6 - 1;
                        n7 = n4;
                        if (n4 == 0) {
                            this.b.a(this);
                            n7 = 1;
                        }
                        this.b.a(this, b2.b, b2.a);
                        n6 = n8;
                        n4 = n7;
                        if (this.c == b2.b) {
                            n3 = Math.max(0, Math.min(this.c, n2 - 1));
                            n4 = n7;
                            n6 = n8;
                        }
                        break block14;
                    }
                    n7 = n6;
                    n8 = n4;
                    n9 = n3;
                    if (b2.b == n10) break block12;
                    if (b2.b == this.c) {
                        n3 = n10;
                    }
                    b2.b = n10;
                }
                n5 = 1;
                n7 = n6;
                n8 = n4;
                n9 = n3;
            }
            n6 = n7 + 1;
            n4 = n8;
            n3 = n9;
        }
        if (n4 != 0) {
            this.b.b(this);
        }
        Collections.sort(this.g, e);
        if (n5 != 0) {
            n6 = this.getChildCount();
            for (n4 = 0; n4 < n6; ++n4) {
                c c2 = (c)this.getChildAt(n4).getLayoutParams();
                if (c2.a) continue;
                c2.c = 0.0f;
            }
            this.a(n3, false, true);
            this.requestLayout();
        }
    }

    public void b(e e2) {
        if (this.ad != null) {
            this.ad.remove(e2);
        }
    }

    public void b(f f2) {
        if (this.aa != null) {
            this.aa.remove(f2);
        }
    }

    void c() {
        this.a(this.c);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean c(int var1_1) {
        block16 : {
            block14 : {
                block15 : {
                    block13 : {
                        block11 : {
                            block12 : {
                                var7_2 = this.findFocus();
                                var4_3 = false;
                                var6_4 = null;
                                if (var7_2 != this) break block12;
                                var5_5 = var6_4;
                                break block13;
                            }
                            if (var7_2 == null) ** GOTO lbl-1000
                            var5_5 = var7_2.getParent();
                            while (var5_5 instanceof ViewGroup) {
                                if (var5_5 == this) {
                                    var2_6 = 1;
                                    break block11;
                                }
                                var5_5 = var5_5.getParent();
                            }
                            var2_6 = 0;
                        }
                        if (var2_6 == 0) {
                            var8_7 = new StringBuilder();
                            var8_7.append(var7_2.getClass().getSimpleName());
                            var5_5 = var7_2.getParent();
                            while (var5_5 instanceof ViewGroup) {
                                var8_7.append(" => ");
                                var8_7.append(var5_5.getClass().getSimpleName());
                                var5_5 = var5_5.getParent();
                            }
                            var5_5 = new StringBuilder();
                            var5_5.append("arrowScroll tried to find focus based on non-child current focused view ");
                            var5_5.append(var8_7.toString());
                            Log.e((String)"ViewPager", (String)var5_5.toString());
                            var5_5 = var6_4;
                        } else lbl-1000: // 2 sources:
                        {
                            var5_5 = var7_2;
                        }
                    }
                    var6_4 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)var5_5, var1_1);
                    if (var6_4 == null || var6_4 == var5_5) break block14;
                    if (var1_1 != 17) break block15;
                    var2_6 = this.a((Rect)this.i, (View)var6_4).left;
                    var3_8 = this.a((Rect)this.i, (View)var5_5).left;
                    if (var5_5 == null || var2_6 < var3_8) ** GOTO lbl-1000
                    var4_3 = this.d();
                    break block16;
                }
                if (var1_1 == 66) {
                    var2_6 = this.a((Rect)this.i, (View)var6_4).left;
                    var3_9 = this.a((Rect)this.i, (View)var5_5).left;
                    ** if (var5_5 == null || var2_6 > var3_9) goto lbl-1000
lbl-1000: // 1 sources:
                    {
                        var4_3 = this.e();
                        ** GOTO lbl59
                    }
                }
                break block16;
lbl-1000: // 2 sources:
                {
                    var4_3 = var6_4.requestFocus();
                }
                break block16;
            }
            if (var1_1 != 17 && var1_1 != 1) {
                if (var1_1 == 66 || var1_1 == 2) {
                    var4_3 = this.e();
                }
            } else {
                var4_3 = this.d();
            }
        }
        if (var4_3 == false) return var4_3;
        this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection((int)var1_1));
        return var4_3;
    }

    public boolean canScrollHorizontally(int n2) {
        androidx.viewpager.widget.a a2 = this.b;
        boolean bl2 = false;
        boolean bl3 = false;
        if (a2 == null) {
            return false;
        }
        int n3 = this.getClientWidth();
        int n4 = this.getScrollX();
        if (n2 < 0) {
            if (n4 > (int)((float)n3 * this.t)) {
                bl3 = true;
            }
            return bl3;
        }
        bl3 = bl2;
        if (n2 > 0) {
            bl3 = bl2;
            if (n4 < (int)((float)n3 * this.u)) {
                bl3 = true;
            }
        }
        return bl3;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.n = true;
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            int n2 = this.getScrollX();
            int n3 = this.getScrollY();
            int n4 = this.m.getCurrX();
            int n5 = this.m.getCurrY();
            if (n2 != n4 || n3 != n5) {
                this.scrollTo(n4, n5);
                if (!this.d(n4)) {
                    this.m.abortAnimation();
                    this.scrollTo(0, n5);
                }
            }
            t.d((View)this);
            return;
        }
        this.a(true);
    }

    boolean d() {
        if (this.c > 0) {
            this.a(this.c - 1, true);
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || this.a(keyEvent);
        {
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            b b2;
            View view = this.getChildAt(i2);
            if (view.getVisibility() != 0 || (b2 = this.a(view)) == null || b2.b != this.c || !view.dispatchPopulateAccessibilityEvent(accessibilityEvent)) continue;
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int n2 = this.getOverScrollMode();
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0 && (n2 != 1 || this.b == null || this.b.b() <= 1)) {
            this.R.finish();
            this.S.finish();
        } else {
            if (!this.R.isFinished()) {
                n3 = canvas.save();
                n4 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                n2 = this.getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float)(-n4 + this.getPaddingTop()), this.t * (float)n2);
                this.R.setSize(n4, n2);
                n4 = false | this.R.draw(canvas);
                canvas.restoreToCount(n3);
            }
            n3 = n4;
            if (!this.S.isFinished()) {
                n2 = canvas.save();
                n3 = this.getWidth();
                int n5 = this.getHeight();
                int n6 = this.getPaddingTop();
                int n7 = this.getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float)(-this.getPaddingTop()), -(this.u + 1.0f) * (float)n3);
                this.S.setSize(n5 - n6 - n7, n3);
                n3 = n4 | this.S.draw(canvas);
                canvas.restoreToCount(n2);
            }
        }
        if (n3 != 0) {
            t.d((View)this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable2 = this.q;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(this.getDrawableState());
        }
    }

    boolean e() {
        if (this.b != null && this.c < this.b.b() - 1) {
            this.a(this.c + 1, true);
            return true;
        }
        return false;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(this.getContext(), attributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.b;
    }

    protected int getChildDrawingOrder(int n2, int n3) {
        int n4 = n3;
        if (this.ag == 2) {
            n4 = n2 - 1 - n3;
        }
        return ((c)this.ah.get((int)n4).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.c;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getPageMargin() {
        return this.p;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.aj);
        if (this.m != null && !this.m.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p > 0 && this.q != null && this.g.size() > 0 && this.b != null) {
            int n2 = this.getScrollX();
            int n3 = this.getWidth();
            float f2 = this.p;
            float f3 = n3;
            float f4 = f2 / f3;
            Object object = this.g;
            int n4 = 0;
            object = ((ArrayList)object).get(0);
            f2 = ((b)object).e;
            int n5 = this.g.size();
            int n6 = this.g.get((int)(n5 - 1)).b;
            for (int i2 = object.b; i2 < n6; ++i2) {
                float f5;
                while (i2 > ((b)object).b && n4 < n5) {
                    object = this.g;
                    object = ((ArrayList)object).get(++n4);
                }
                if (i2 == ((b)object).b) {
                    f5 = (((b)object).e + ((b)object).d) * f3;
                    f2 = ((b)object).e + ((b)object).d + f4;
                } else {
                    float f6 = this.b.d(i2);
                    f5 = f2 + (f6 + f4);
                    f6 = (f2 + f6) * f3;
                    f2 = f5;
                    f5 = f6;
                }
                if ((float)this.p + f5 > (float)n2) {
                    this.q.setBounds(Math.round(f5), this.r, Math.round((float)this.p + f5), this.s);
                    this.q.draw(canvas);
                }
                if (!(f5 > (float)(n2 + n3))) continue;
                return;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction() & 255;
        if (n2 != 3 && n2 != 1) {
            if (n2 != 0) {
                if (this.B) {
                    return true;
                }
                if (this.C) {
                    return false;
                }
            }
            if (n2 != 0) {
                if (n2 != 2) {
                    if (n2 == 6) {
                        this.a(motionEvent);
                    }
                } else {
                    n2 = this.K;
                    if (n2 != -1) {
                        n2 = motionEvent.findPointerIndex(n2);
                        float f2 = motionEvent.getX(n2);
                        float f3 = f2 - this.G;
                        float f4 = Math.abs(f3);
                        float f5 = motionEvent.getY(n2);
                        float f6 = Math.abs(f5 - this.J);
                        n2 = (int)(f3 FCMPL 0.0f);
                        if (n2 != 0 && !this.a(this.G, f3) && this.a((View)this, false, (int)f3, (int)f2, (int)f5)) {
                            this.G = f2;
                            this.H = f5;
                            this.C = true;
                            return false;
                        }
                        if (f4 > (float)this.F && f4 * 0.5f > f6) {
                            this.B = true;
                            this.c(true);
                            this.setScrollState(1);
                            f3 = n2 > 0 ? this.I + (float)this.F : this.I - (float)this.F;
                            this.G = f3;
                            this.H = f5;
                            this.setScrollingCacheEnabled(true);
                        } else if (f6 > (float)this.F) {
                            this.C = true;
                        }
                        if (this.B && this.b(f2)) {
                            t.d((View)this);
                        }
                    }
                }
            } else {
                float f7;
                this.I = f7 = motionEvent.getX();
                this.G = f7;
                this.J = f7 = motionEvent.getY();
                this.H = f7;
                this.K = motionEvent.getPointerId(0);
                this.C = false;
                this.n = true;
                this.m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                    this.m.abortAnimation();
                    this.z = false;
                    this.c();
                    this.B = true;
                    this.c(true);
                    this.setScrollState(1);
                } else {
                    this.a(false);
                    this.B = false;
                }
            }
            if (this.L == null) {
                this.L = VelocityTracker.obtain();
            }
            this.L.addMovement(motionEvent);
            return this.B;
        }
        this.h();
        return false;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        c c2;
        View view;
        int n6;
        int n7 = this.getChildCount();
        int n8 = n4 - n2;
        int n9 = n5 - n3;
        n3 = this.getPaddingLeft();
        n2 = this.getPaddingTop();
        int n10 = this.getPaddingRight();
        n5 = this.getPaddingBottom();
        int n11 = this.getScrollX();
        int n12 = 0;
        for (int i2 = 0; i2 < n7; ++i2) {
            view = this.getChildAt(i2);
            n6 = n3;
            int n13 = n10;
            int n14 = n2;
            int n15 = n5;
            n4 = n12;
            if (view.getVisibility() != 8) {
                c2 = (c)view.getLayoutParams();
                n6 = n3;
                n13 = n10;
                n14 = n2;
                n15 = n5;
                n4 = n12;
                if (c2.a) {
                    n4 = c2.b & 7;
                    n15 = c2.b & 112;
                    if (n4 != 1) {
                        if (n4 != 3) {
                            if (n4 != 5) {
                                n4 = n3;
                                n6 = n3;
                            } else {
                                n4 = n8 - n10 - view.getMeasuredWidth();
                                n10 += view.getMeasuredWidth();
                                n6 = n3;
                            }
                        } else {
                            n6 = view.getMeasuredWidth();
                            n4 = n3;
                            n6 += n3;
                        }
                    } else {
                        n4 = Math.max((n8 - view.getMeasuredWidth()) / 2, n3);
                        n6 = n3;
                    }
                    if (n15 != 16) {
                        if (n15 != 48) {
                            if (n15 != 80) {
                                n3 = n2;
                            } else {
                                n3 = n9 - n5 - view.getMeasuredHeight();
                                n5 += view.getMeasuredHeight();
                            }
                        } else {
                            n15 = view.getMeasuredHeight();
                            n3 = n2;
                            n2 = n15 + n2;
                        }
                    } else {
                        n3 = Math.max((n9 - view.getMeasuredHeight()) / 2, n2);
                    }
                    view.layout(n4 += n11, n3, view.getMeasuredWidth() + n4, n3 + view.getMeasuredHeight());
                    n4 = n12 + 1;
                    n15 = n5;
                    n14 = n2;
                    n13 = n10;
                }
            }
            n3 = n6;
            n10 = n13;
            n2 = n14;
            n5 = n15;
            n12 = n4;
        }
        for (n4 = 0; n4 < n7; ++n4) {
            b b2;
            view = this.getChildAt(n4);
            if (view.getVisibility() == 8) continue;
            c2 = (c)view.getLayoutParams();
            if (c2.a || (b2 = this.a(view)) == null) continue;
            float f2 = n8 - n3 - n10;
            n6 = (int)(b2.e * f2) + n3;
            if (c2.d) {
                c2.d = false;
                view.measure(View.MeasureSpec.makeMeasureSpec((int)((int)(f2 * c2.c)), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)(n9 - n2 - n5), (int)1073741824));
            }
            view.layout(n6, n2, view.getMeasuredWidth() + n6, view.getMeasuredHeight() + n2);
        }
        this.r = n2;
        this.s = n9 - n5;
        this.W = n12;
        if (this.T) {
            this.a(this.c, false, 0, false);
        }
        this.T = false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    protected void onMeasure(int var1_1, int var2_2) {
        this.setMeasuredDimension(ViewPager.getDefaultSize((int)0, (int)var1_1), ViewPager.getDefaultSize((int)0, (int)var2_2));
        var1_1 = this.getMeasuredWidth();
        this.E = Math.min(var1_1 / 10, this.D);
        var3_3 = this.getPaddingLeft();
        var4_4 = this.getPaddingRight();
        var2_2 = this.getMeasuredHeight();
        var5_5 = this.getPaddingTop();
        var6_6 = this.getPaddingBottom();
        var11_7 = this.getChildCount();
        var2_2 = var2_2 - var5_5 - var6_6;
        var1_1 = var1_1 - var3_3 - var4_4;
        var5_5 = 0;
        do {
            block13 : {
                block14 : {
                    var8_9 = 1;
                    var10_11 = 1073741824;
                    if (var5_5 >= var11_7) break;
                    var12_12 = this.getChildAt(var5_5);
                    var3_3 = var1_1;
                    var4_4 = var2_2;
                    if (var12_12.getVisibility() == 8) break block13;
                    var13_13 = (c)var12_12.getLayoutParams();
                    var3_3 = var1_1;
                    var4_4 = var2_2;
                    if (var13_13 == null) break block13;
                    var3_3 = var1_1;
                    var4_4 = var2_2;
                    if (!var13_13.a) break block13;
                    var3_3 = var13_13.b & 7;
                    var4_4 = var13_13.b & 112;
                    var7_8 = var4_4 == 48 || var4_4 == 80;
                    var6_6 = var8_9;
                    if (var3_3 != 3) {
                        var6_6 = var3_3 == 5 ? var8_9 : 0;
                    }
                    var8_9 = Integer.MIN_VALUE;
                    if (!var7_8) break block14;
                    var4_4 = 1073741824;
                    ** GOTO lbl-1000
                }
                var4_4 = var8_9;
                if (var6_6 != 0) {
                    var3_3 = 1073741824;
                    var4_4 = var8_9;
                } else lbl-1000: // 2 sources:
                {
                    var3_3 = Integer.MIN_VALUE;
                }
                if (var13_13.width != -2) {
                    var4_4 = var13_13.width != -1 ? var13_13.width : var1_1;
                    var8_9 = 1073741824;
                    var9_10 = var4_4;
                } else {
                    var9_10 = var1_1;
                    var8_9 = var4_4;
                }
                if (var13_13.height != -2) {
                    var3_3 = var13_13.height != -1 ? var13_13.height : var2_2;
                } else {
                    var4_4 = var2_2;
                    var10_11 = var3_3;
                    var3_3 = var4_4;
                }
                var12_12.measure(View.MeasureSpec.makeMeasureSpec((int)var9_10, (int)var8_9), View.MeasureSpec.makeMeasureSpec((int)var3_3, (int)var10_11));
                if (var7_8) {
                    var4_4 = var2_2 - var12_12.getMeasuredHeight();
                    var3_3 = var1_1;
                } else {
                    var3_3 = var1_1;
                    var4_4 = var2_2;
                    if (var6_6 != 0) {
                        var3_3 = var1_1 - var12_12.getMeasuredWidth();
                        var4_4 = var2_2;
                    }
                }
            }
            ++var5_5;
            var1_1 = var3_3;
            var2_2 = var4_4;
        } while (true);
        this.v = View.MeasureSpec.makeMeasureSpec((int)var1_1, (int)1073741824);
        this.w = View.MeasureSpec.makeMeasureSpec((int)var2_2, (int)1073741824);
        this.x = true;
        this.c();
        var2_2 = 0;
        this.x = false;
        var3_3 = this.getChildCount();
        while (var2_2 < var3_3) {
            var12_12 = this.getChildAt(var2_2);
            if (!(var12_12.getVisibility() == 8 || (var13_13 = (c)var12_12.getLayoutParams()) != null && var13_13.a)) {
                var12_12.measure(View.MeasureSpec.makeMeasureSpec((int)((int)((float)var1_1 * var13_13.c)), (int)1073741824), this.w);
            }
            ++var2_2;
        }
    }

    protected boolean onRequestFocusInDescendants(int n2, Rect rect) {
        int n3;
        int n4 = this.getChildCount();
        int n5 = -1;
        if ((n2 & 2) != 0) {
            n5 = n4;
            n4 = 0;
            n3 = 1;
        } else {
            --n4;
            n3 = -1;
        }
        while (n4 != n5) {
            b b2;
            View view = this.getChildAt(n4);
            if (view.getVisibility() == 0 && (b2 = this.a(view)) != null && b2.b == this.c && view.requestFocus(n2, rect)) {
                return true;
            }
            n4 += n3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (i)parcelable;
        super.onRestoreInstanceState(parcelable.a());
        if (this.b != null) {
            this.b.a(parcelable.b, parcelable.d);
            this.a(parcelable.a, false, true);
            return;
        }
        this.j = parcelable.a;
        this.k = parcelable.b;
        this.l = parcelable.d;
    }

    public Parcelable onSaveInstanceState() {
        i i2 = new i(super.onSaveInstanceState());
        i2.a = this.c;
        if (this.b != null) {
            i2.b = this.b.a();
        }
        return i2;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        if (n2 != n4) {
            this.a(n2, n4, this.p, this.p);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block17 : {
            block18 : {
                if (this.Q) {
                    return true;
                }
                var6_2 = var1_1.getAction();
                var9_3 = false;
                if (var6_2 == 0 && var1_1.getEdgeFlags() != 0) {
                    return false;
                }
                if (this.b == null) return false;
                if (this.b.b() == 0) {
                    return false;
                }
                if (this.L == null) {
                    this.L = VelocityTracker.obtain();
                }
                this.L.addMovement(var1_1);
                switch (var1_1.getAction() & 255) {
                    default: {
                        break block17;
                    }
                    case 6: {
                        this.a(var1_1);
                        this.G = var1_1.getX(var1_1.findPointerIndex(this.K));
                        break block17;
                    }
                    case 5: {
                        var6_2 = var1_1.getActionIndex();
                        this.G = var1_1.getX(var6_2);
                        var6_2 = var1_1.getPointerId(var6_2);
                        break block18;
                    }
                    case 3: {
                        if (!this.B) break block17;
                        this.a(this.c, true, 0, false);
                        ** GOTO lbl63
                    }
                    case 2: {
                        if (this.B) ** GOTO lbl48
                        var6_2 = var1_1.findPointerIndex(this.K);
                        if (var6_2 == -1) ** GOTO lbl63
                        var2_4 = var1_1.getX(var6_2);
                        var4_7 = Math.abs(var2_4 - this.G);
                        var3_8 = var1_1.getY(var6_2);
                        var5_10 = Math.abs(var3_8 - this.H);
                        if (var4_7 > (float)this.F && var4_7 > var5_10) {
                            this.B = true;
                            this.c(true);
                            var2_4 = var2_4 - this.I > 0.0f ? this.I + (float)this.F : this.I - (float)this.F;
                            this.G = var2_4;
                            this.H = var3_8;
                            this.setScrollState(1);
                            this.setScrollingCacheEnabled(true);
                            var10_11 = this.getParent();
                            if (var10_11 != null) {
                                var10_11.requestDisallowInterceptTouchEvent(true);
                            }
                        }
lbl48: // 6 sources:
                        if (this.B) {
                            var9_3 = false | this.b(var1_1.getX(var1_1.findPointerIndex(this.K)));
                        }
                        break block17;
                    }
                    case 1: {
                        if (!this.B) break block17;
                        var10_12 = this.L;
                        var10_12.computeCurrentVelocity(1000, (float)this.N);
                        var6_2 = (int)var10_12.getXVelocity(this.K);
                        this.z = true;
                        var7_14 = this.getClientWidth();
                        var8_15 = this.getScrollX();
                        var10_13 = this.i();
                        var3_9 = this.p;
                        var2_5 = var7_14;
                        this.a(this.a(var10_13.b, ((float)var8_15 / var2_5 - var10_13.e) / (var10_13.d + (var3_9 /= var2_5)), var6_2, (int)(var1_1.getX(var1_1.findPointerIndex(this.K)) - this.I)), true, true, var6_2);
lbl63: // 3 sources:
                        var9_3 = this.h();
                        break block17;
                    }
                    case 0: 
                }
                this.m.abortAnimation();
                this.z = false;
                this.c();
                this.I = var2_6 = var1_1.getX();
                this.G = var2_6;
                this.J = var2_6 = var1_1.getY();
                this.H = var2_6;
                var6_2 = var1_1.getPointerId(0);
            }
            this.K = var6_2;
        }
        if (var9_3 == false) return true;
        t.d((View)this);
        return true;
    }

    public void removeView(View view) {
        if (this.x) {
            this.removeViewInLayout(view);
            return;
        }
        super.removeView(view);
    }

    public void setAdapter(androidx.viewpager.widget.a a2) {
        int n2;
        Object object = this.b;
        int n3 = 0;
        if (object != null) {
            this.b.c(null);
            this.b.a(this);
            for (n2 = 0; n2 < this.g.size(); ++n2) {
                object = this.g.get(n2);
                this.b.a(this, ((b)object).b, ((b)object).a);
            }
            this.b.b(this);
            this.g.clear();
            this.f();
            this.c = 0;
            this.scrollTo(0, 0);
        }
        object = this.b;
        this.b = a2;
        this.d = 0;
        if (this.b != null) {
            if (this.o == null) {
                this.o = new h();
            }
            this.b.c(this.o);
            this.z = false;
            boolean bl2 = this.T;
            this.T = true;
            this.d = this.b.b();
            if (this.j >= 0) {
                this.b.a(this.k, this.l);
                this.a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (!bl2) {
                this.c();
            } else {
                this.requestLayout();
            }
        }
        if (this.ad != null && !this.ad.isEmpty()) {
            int n4 = this.ad.size();
            for (n2 = n3; n2 < n4; ++n2) {
                this.ad.get(n2).a(this, (androidx.viewpager.widget.a)object, a2);
            }
        }
    }

    public void setCurrentItem(int n2) {
        this.z = false;
        this.a(n2, this.T ^ true, false);
    }

    public void setOffscreenPageLimit(int n2) {
        int n3 = n2;
        if (n2 < 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested offscreen page limit ");
            stringBuilder.append(n2);
            stringBuilder.append(" too small; defaulting to ");
            stringBuilder.append(1);
            Log.w((String)"ViewPager", (String)stringBuilder.toString());
            n3 = 1;
        }
        if (n3 != this.A) {
            this.A = n3;
            this.c();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f f2) {
        this.ab = f2;
    }

    public void setPageMargin(int n2) {
        int n3 = this.p;
        this.p = n2;
        int n4 = this.getWidth();
        this.a(n4, n4, n2, n3);
        this.requestLayout();
    }

    public void setPageMarginDrawable(int n2) {
        this.setPageMarginDrawable(androidx.core.a.a.a(this.getContext(), n2));
    }

    public void setPageMarginDrawable(Drawable drawable2) {
        this.q = drawable2;
        if (drawable2 != null) {
            this.refreshDrawableState();
        }
        boolean bl2 = drawable2 == null;
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    void setScrollState(int n2) {
        if (this.ak == n2) {
            return;
        }
        this.ak = n2;
        if (this.ae != null) {
            boolean bl2 = n2 != 0;
            this.b(bl2);
        }
        this.f(n2);
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        return super.verifyDrawable(drawable2) || drawable2 == this.q;
        {
        }
    }

    @Inherited
    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface a {
    }

    static class b {
        Object a;
        int b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public static class c
    extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, ViewPager.a);
            this.b = context.getInteger(0, 48);
            context.recycle();
        }
    }

    class d
    extends androidx.core.h.a {
        d() {
        }

        private boolean b() {
            return ViewPager.this.b != null && ViewPager.this.b.b() > 1;
        }

        @Override
        public void a(View view, androidx.core.h.a.b b2) {
            super.a(view, b2);
            b2.a(ViewPager.class.getName());
            b2.c(this.b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                b2.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                b2.a(8192);
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public boolean a(View object, int n2, Bundle bundle) {
            if (super.a((View)object, n2, bundle)) {
                return true;
            }
            if (n2 != 4096) {
                if (n2 != 8192) {
                    return false;
                }
                if (!ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                object = ViewPager.this;
                n2 = ViewPager.this.c - 1;
            } else {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                object = ViewPager.this;
                n2 = ViewPager.this.c + 1;
            }
            ((ViewPager)((Object)object)).setCurrentItem(n2);
            return true;
        }

        @Override
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
            accessibilityEvent.setScrollable(this.b());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.b != null) {
                accessibilityEvent.setItemCount(ViewPager.this.b.b());
                accessibilityEvent.setFromIndex(ViewPager.this.c);
                accessibilityEvent.setToIndex(ViewPager.this.c);
            }
        }
    }

    public static interface e {
        public void a(ViewPager var1, androidx.viewpager.widget.a var2, androidx.viewpager.widget.a var3);
    }

    public static interface f {
        public void a(int var1);

        public void a(int var1, float var2, int var3);

        public void b(int var1);
    }

    public static interface g {
        public void a(View var1, float var2);
    }

    private class h
    extends DataSetObserver {
        h() {
        }

        public void onChanged() {
            ViewPager.this.b();
        }

        public void onInvalidated() {
            ViewPager.this.b();
        }
    }

    public static class i
    extends androidx.e.a.a {
        public static final Parcelable.Creator<i> CREATOR = new Parcelable.ClassLoaderCreator<i>(){

            public i a(Parcel parcel) {
                return new i(parcel, null);
            }

            public i a(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            public i[] a(int n2) {
                return new i[n2];
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
        int a;
        Parcelable b;
        ClassLoader d;

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            ClassLoader classLoader2 = classLoader;
            if (classLoader == null) {
                classLoader2 = this.getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader2);
            this.d = classLoader2;
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FragmentPager.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" position=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        @Override
        public void writeToParcel(Parcel parcel, int n2) {
            super.writeToParcel(parcel, n2);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, n2);
        }

    }

    static class j
    implements Comparator<View> {
        j() {
        }

        public int a(View object, View object2) {
            object = (c)object.getLayoutParams();
            object2 = (c)object2.getLayoutParams();
            if (object.a != object2.a) {
                if (object.a) {
                    return 1;
                }
                return -1;
            }
            return object.e - object2.e;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((View)object, (View)object2);
        }
    }

}

