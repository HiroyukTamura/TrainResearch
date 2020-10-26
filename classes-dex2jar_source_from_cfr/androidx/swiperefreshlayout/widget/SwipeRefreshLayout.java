/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.Transformation
 *  android.widget.AbsListView
 *  android.widget.ListView
 */
package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.h.j;
import androidx.core.h.l;
import androidx.core.h.m;
import androidx.core.h.o;
import androidx.core.h.t;
import androidx.core.widget.g;

public class SwipeRefreshLayout
extends ViewGroup
implements j,
m {
    private static final int[] E = new int[]{16842766};
    private static final String n = "SwipeRefreshLayout";
    private boolean A;
    private int B = -1;
    private boolean C;
    private final DecelerateInterpolator D;
    private int F = -1;
    private Animation G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private int L;
    private a M;
    private Animation.AnimationListener N = new Animation.AnimationListener(){

        public void onAnimationEnd(Animation animation) {
            if (SwipeRefreshLayout.this.b) {
                SwipeRefreshLayout.this.k.setAlpha(255);
                SwipeRefreshLayout.this.k.start();
                if (SwipeRefreshLayout.this.l && SwipeRefreshLayout.this.a != null) {
                    SwipeRefreshLayout.this.a.a();
                }
                SwipeRefreshLayout.this.c = SwipeRefreshLayout.this.e.getTop();
                return;
            }
            SwipeRefreshLayout.this.a();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    };
    private final Animation O = new Animation(){

        public void applyTransformation(float f2, Transformation transformation) {
            int n2 = !SwipeRefreshLayout.this.m ? SwipeRefreshLayout.this.i - Math.abs(SwipeRefreshLayout.this.h) : SwipeRefreshLayout.this.i;
            int n3 = SwipeRefreshLayout.this.f;
            n2 = (int)((float)(n2 - SwipeRefreshLayout.this.f) * f2);
            int n4 = SwipeRefreshLayout.this.e.getTop();
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(n3 + n2 - n4);
            SwipeRefreshLayout.this.k.b(1.0f - f2);
        }
    };
    private final Animation P = new Animation(){

        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.a(f2);
        }
    };
    b a;
    boolean b = false;
    int c;
    boolean d;
    androidx.swiperefreshlayout.widget.a e;
    protected int f;
    float g;
    protected int h;
    int i;
    int j;
    androidx.swiperefreshlayout.widget.b k;
    boolean l;
    boolean m;
    private View o;
    private int p;
    private float q = -1.0f;
    private float r;
    private final o s;
    private final l t;
    private final int[] u = new int[2];
    private final int[] v = new int[2];
    private boolean w;
    private int x;
    private float y;
    private float z;

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        int n2;
        super(context, attributeSet);
        this.p = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        this.x = this.getResources().getInteger(17694721);
        this.setWillNotDraw(false);
        this.D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.L = (int)(displayMetrics.density * 40.0f);
        this.c();
        this.setChildrenDrawingOrderEnabled(true);
        this.i = (int)(displayMetrics.density * 64.0f);
        this.q = this.i;
        this.s = new o(this);
        this.t = new l((View)this);
        this.setNestedScrollingEnabled(true);
        this.c = n2 = -this.L;
        this.h = n2;
        this.a(1.0f);
        context = context.obtainStyledAttributes(attributeSet, E);
        this.setEnabled(context.getBoolean(0, true));
        context.recycle();
    }

    private Animation a(final int n2, final int n3) {
        Animation animation = new Animation(){

            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.k.setAlpha((int)((float)n2 + (float)(n3 - n2) * f2));
            }
        };
        animation.setDuration(300L);
        this.e.a(null);
        this.e.clearAnimation();
        this.e.startAnimation(animation);
        return animation;
    }

    private void a(int n2, Animation.AnimationListener animationListener) {
        this.f = n2;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator((Interpolator)this.D);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.O);
    }

    private void a(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(n2) == this.B) {
            n2 = n2 == 0 ? 1 : 0;
            this.B = motionEvent.getPointerId(n2);
        }
    }

    private void a(boolean bl2, boolean bl3) {
        if (this.b != bl2) {
            this.l = bl3;
            this.f();
            this.b = bl2;
            if (this.b) {
                this.a(this.c, this.N);
                return;
            }
            this.a(this.N);
        }
    }

    private boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(float f2) {
        this.k.a(true);
        float f3 = Math.min(1.0f, Math.abs(f2 / this.q));
        float f4 = (float)Math.max((double)f3 - 0.4, 0.0) * 5.0f / 3.0f;
        float f5 = Math.abs(f2);
        float f6 = this.q;
        int n2 = this.j > 0 ? this.j : (this.m ? this.i - this.h : this.i);
        float f7 = n2;
        double d2 = Math.max(0.0f, Math.min(f5 - f6, f7 * 2.0f) / f7) / 4.0f;
        f5 = (float)(d2 - Math.pow(d2, 2.0)) * 2.0f;
        n2 = this.h;
        int n3 = (int)(f7 * f3 + f7 * f5 * 2.0f);
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (!this.d) {
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
        }
        if (this.d) {
            this.setAnimationProgress(Math.min(1.0f, f2 / this.q));
        }
        if (f2 < this.q) {
            if (this.k.getAlpha() > 76 && !this.a(this.I)) {
                this.d();
            }
        } else if (this.k.getAlpha() < 255 && !this.a(this.J)) {
            this.e();
        }
        this.k.a(0.0f, Math.min(0.8f, f4 * 0.8f));
        this.k.b(Math.min(1.0f, f4));
        this.k.c((f4 * 0.4f - 0.25f + f5 * 2.0f) * 0.5f);
        this.setTargetOffsetTopAndBottom(n2 + n3 - this.c);
    }

    private void b(int n2, Animation.AnimationListener animationListener) {
        if (this.d) {
            this.c(n2, animationListener);
            return;
        }
        this.f = n2;
        this.P.reset();
        this.P.setDuration(200L);
        this.P.setInterpolator((Interpolator)this.D);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.P);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.e.setVisibility(0);
        this.k.setAlpha(255);
        this.G = new Animation(){

            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.G.setDuration((long)this.x);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.G);
    }

    private void c() {
        this.e = new androidx.swiperefreshlayout.widget.a(this.getContext(), -328966);
        this.k = new androidx.swiperefreshlayout.widget.b(this.getContext());
        this.k.a(1);
        this.e.setImageDrawable((Drawable)this.k);
        this.e.setVisibility(8);
        this.addView((View)this.e);
    }

    private void c(float f2) {
        if (f2 > this.q) {
            this.a(true, true);
            return;
        }
        this.b = false;
        this.k.a(0.0f, 0.0f);
        Animation.AnimationListener animationListener = null;
        if (!this.d) {
            animationListener = new Animation.AnimationListener(){

                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.d) {
                        SwipeRefreshLayout.this.a((Animation.AnimationListener)null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
        }
        this.b(this.c, animationListener);
        this.k.a(false);
    }

    private void c(int n2, Animation.AnimationListener animationListener) {
        this.f = n2;
        this.g = this.e.getScaleX();
        this.K = new Animation(){

            public void applyTransformation(float f2, Transformation transformation) {
                float f3 = SwipeRefreshLayout.this.g;
                float f4 = -SwipeRefreshLayout.this.g;
                SwipeRefreshLayout.this.setAnimationProgress(f3 + f4 * f2);
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.K.setDuration(150L);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.K);
    }

    private void d() {
        this.I = this.a(this.k.getAlpha(), 76);
    }

    private void d(float f2) {
        if (f2 - this.z > (float)this.p && !this.A) {
            this.y = this.z + (float)this.p;
            this.A = true;
            this.k.setAlpha(76);
        }
    }

    private void e() {
        this.J = this.a(this.k.getAlpha(), 255);
    }

    private void f() {
        if (this.o == null) {
            for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
                View view = this.getChildAt(i2);
                if (view.equals((Object)this.e)) continue;
                this.o = view;
                return;
            }
        }
    }

    private void setColorViewAlpha(int n2) {
        this.e.getBackground().setAlpha(n2);
        this.k.setAlpha(n2);
    }

    void a() {
        this.e.clearAnimation();
        this.k.stop();
        this.e.setVisibility(8);
        this.setColorViewAlpha(255);
        if (this.d) {
            this.setAnimationProgress(0.0f);
        } else {
            this.setTargetOffsetTopAndBottom(this.h - this.c);
        }
        this.c = this.e.getTop();
    }

    void a(float f2) {
        this.setTargetOffsetTopAndBottom(this.f + (int)((float)(this.h - this.f) * f2) - this.e.getTop());
    }

    void a(Animation.AnimationListener animationListener) {
        this.H = new Animation(){

            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.H.setDuration(150L);
        this.e.a(animationListener);
        this.e.clearAnimation();
        this.e.startAnimation(this.H);
    }

    public boolean b() {
        if (this.M != null) {
            return this.M.a(this, this.o);
        }
        if (this.o instanceof ListView) {
            return g.b((ListView)this.o, -1);
        }
        return this.o.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean bl2) {
        return this.t.a(f2, f3, bl2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.t.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.t.a(n2, n3, arrn, arrn2);
    }

    public boolean dispatchNestedScroll(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.t.a(n2, n3, n4, n5, arrn);
    }

    protected int getChildDrawingOrder(int n2, int n3) {
        if (this.F < 0) {
            return n3;
        }
        if (n3 == n2 - 1) {
            return this.F;
        }
        n2 = n3;
        if (n3 >= this.F) {
            n2 = n3 + 1;
        }
        return n2;
    }

    public int getNestedScrollAxes() {
        return this.s.a();
    }

    public int getProgressCircleDiameter() {
        return this.L;
    }

    public int getProgressViewEndOffset() {
        return this.i;
    }

    public int getProgressViewStartOffset() {
        return this.h;
    }

    public boolean hasNestedScrollingParent() {
        return this.t.b();
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return this.t.a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f();
        int n2 = motionEvent.getActionMasked();
        if (this.C && n2 == 0) {
            this.C = false;
        }
        if (this.isEnabled() && !this.C && !this.b() && !this.b) {
            if (this.w) {
                return false;
            }
            if (n2 != 6) {
                switch (n2) {
                    default: {
                        break;
                    }
                    case 2: {
                        if (this.B == -1) {
                            Log.e((String)n, (String)"Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        n2 = motionEvent.findPointerIndex(this.B);
                        if (n2 < 0) {
                            return false;
                        }
                        this.d(motionEvent.getY(n2));
                        break;
                    }
                    case 1: 
                    case 3: {
                        this.A = false;
                        this.B = -1;
                        break;
                    }
                    case 0: {
                        this.setTargetOffsetTopAndBottom(this.h - this.e.getTop());
                        this.B = motionEvent.getPointerId(0);
                        this.A = false;
                        n2 = motionEvent.findPointerIndex(this.B);
                        if (n2 < 0) {
                            return false;
                        }
                        this.z = motionEvent.getY(n2);
                        break;
                    }
                }
            } else {
                this.a(motionEvent);
            }
            return this.A;
        }
        return false;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        n2 = this.getMeasuredWidth();
        n3 = this.getMeasuredHeight();
        if (this.getChildCount() == 0) {
            return;
        }
        if (this.o == null) {
            this.f();
        }
        if (this.o == null) {
            return;
        }
        Object object = this.o;
        n4 = this.getPaddingLeft();
        n5 = this.getPaddingTop();
        object.layout(n4, n5, n2 - this.getPaddingLeft() - this.getPaddingRight() + n4, n3 - this.getPaddingTop() - this.getPaddingBottom() + n5);
        n4 = this.e.getMeasuredWidth();
        n3 = this.e.getMeasuredHeight();
        object = this.e;
        object.layout((n2 /= 2) - (n4 /= 2), this.c, n2 + n4, this.c + n3);
    }

    public void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.o == null) {
            this.f();
        }
        if (this.o == null) {
            return;
        }
        this.o.measure(View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom()), (int)1073741824));
        this.e.measure(View.MeasureSpec.makeMeasureSpec((int)this.L, (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)this.L, (int)1073741824));
        this.F = -1;
        for (n2 = 0; n2 < this.getChildCount(); ++n2) {
            if (this.getChildAt(n2) != this.e) continue;
            this.F = n2;
            return;
        }
    }

    @Override
    public boolean onNestedFling(View view, float f2, float f3, boolean bl2) {
        return this.dispatchNestedFling(f2, f3, bl2);
    }

    @Override
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return this.dispatchNestedPreFling(f2, f3);
    }

    @Override
    public void onNestedPreScroll(View arrn, int n2, int n3, int[] arrn2) {
        if (n3 > 0 && this.r > 0.0f) {
            float f2 = n3;
            if (f2 > this.r) {
                arrn2[1] = n3 - (int)this.r;
                this.r = 0.0f;
            } else {
                this.r -= f2;
                arrn2[1] = n3;
            }
            this.b(this.r);
        }
        if (this.m && n3 > 0 && this.r == 0.0f && Math.abs(n3 - arrn2[1]) > 0) {
            this.e.setVisibility(8);
        }
        if (this.dispatchNestedPreScroll(n2 - arrn2[0], n3 - arrn2[1], arrn = this.u, null)) {
            arrn2[0] = arrn2[0] + arrn[0];
            arrn2[1] = arrn2[1] + arrn[1];
        }
    }

    @Override
    public void onNestedScroll(View view, int n2, int n3, int n4, int n5) {
        this.dispatchNestedScroll(n2, n3, n4, n5, this.v);
        n2 = n5 + this.v[1];
        if (n2 < 0 && !this.b()) {
            this.r += (float)Math.abs(n2);
            this.b(this.r);
        }
    }

    @Override
    public void onNestedScrollAccepted(View view, View view2, int n2) {
        this.s.a(view, view2, n2);
        this.startNestedScroll(n2 & 2);
        this.r = 0.0f;
        this.w = true;
    }

    @Override
    public boolean onStartNestedScroll(View view, View view2, int n2) {
        return this.isEnabled() && !this.C && !this.b && (n2 & 2) != 0;
    }

    @Override
    public void onStopNestedScroll(View view) {
        this.s.a(view);
        this.w = false;
        if (this.r > 0.0f) {
            this.c(this.r);
            this.r = 0.0f;
        }
        this.stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (this.C && n2 == 0) {
            this.C = false;
        }
        if (this.isEnabled() && !this.C && !this.b() && !this.b) {
            if (this.w) {
                return false;
            }
            switch (n2) {
                default: {
                    break;
                }
                case 6: {
                    this.a(motionEvent);
                    break;
                }
                case 5: {
                    n2 = motionEvent.getActionIndex();
                    if (n2 < 0) {
                        Log.e((String)n, (String)"Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.B = motionEvent.getPointerId(n2);
                    break;
                }
                case 3: {
                    return false;
                }
                case 2: {
                    n2 = motionEvent.findPointerIndex(this.B);
                    if (n2 < 0) {
                        Log.e((String)n, (String)"Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float f2 = motionEvent.getY(n2);
                    this.d(f2);
                    if (!this.A) break;
                    if ((f2 = (f2 - this.y) * 0.5f) > 0.0f) {
                        this.b(f2);
                        break;
                    }
                    return false;
                }
                case 1: {
                    n2 = motionEvent.findPointerIndex(this.B);
                    if (n2 < 0) {
                        Log.e((String)n, (String)"Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    if (this.A) {
                        float f3 = motionEvent.getY(n2);
                        float f4 = this.y;
                        this.A = false;
                        this.c((f3 - f4) * 0.5f);
                    }
                    this.B = -1;
                    return false;
                }
                case 0: {
                    this.B = motionEvent.getPointerId(0);
                    this.A = false;
                }
            }
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.o instanceof AbsListView)) {
            if (this.o != null && !t.w(this.o)) {
                return;
            }
            super.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    void setAnimationProgress(float f2) {
        this.e.setScaleX(f2);
        this.e.setScaleY(f2);
    }

    @Deprecated
    public /* varargs */ void setColorScheme(int ... arrn) {
        this.setColorSchemeResources(arrn);
    }

    public /* varargs */ void setColorSchemeColors(int ... arrn) {
        this.f();
        this.k.a(arrn);
    }

    public /* varargs */ void setColorSchemeResources(int ... arrn) {
        Context context = this.getContext();
        int[] arrn2 = new int[arrn.length];
        for (int i2 = 0; i2 < arrn.length; ++i2) {
            arrn2[i2] = androidx.core.a.a.c(context, arrn[i2]);
        }
        this.setColorSchemeColors(arrn2);
    }

    public void setDistanceToTriggerSync(int n2) {
        this.q = n2;
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        if (!bl2) {
            this.a();
        }
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.t.a(bl2);
    }

    public void setOnChildScrollUpCallback(a a2) {
        this.M = a2;
    }

    public void setOnRefreshListener(b b2) {
        this.a = b2;
    }

    @Deprecated
    public void setProgressBackgroundColor(int n2) {
        this.setProgressBackgroundColorSchemeResource(n2);
    }

    public void setProgressBackgroundColorSchemeColor(int n2) {
        this.e.setBackgroundColor(n2);
    }

    public void setProgressBackgroundColorSchemeResource(int n2) {
        this.setProgressBackgroundColorSchemeColor(androidx.core.a.a.c(this.getContext(), n2));
    }

    public void setRefreshing(boolean bl2) {
        if (bl2 && this.b != bl2) {
            this.b = bl2;
            int n2 = !this.m ? this.i + this.h : this.i;
            this.setTargetOffsetTopAndBottom(n2 - this.c);
            this.l = false;
            this.b(this.N);
            return;
        }
        this.a(bl2, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setSize(int n2) {
        if (n2 != 0 && n2 != 1) {
            return;
        }
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f2 = n2 == 0 ? 56.0f : 40.0f;
        this.L = (int)(displayMetrics.density * f2);
        this.e.setImageDrawable(null);
        this.k.a(n2);
        this.e.setImageDrawable((Drawable)this.k);
    }

    public void setSlingshotDistance(int n2) {
        this.j = n2;
    }

    void setTargetOffsetTopAndBottom(int n2) {
        this.e.bringToFront();
        t.e((View)this.e, n2);
        this.c = this.e.getTop();
    }

    public boolean startNestedScroll(int n2) {
        return this.t.b(n2);
    }

    @Override
    public void stopNestedScroll() {
        this.t.c();
    }

    public static interface a {
        public boolean a(SwipeRefreshLayout var1, View var2);
    }

    public static interface b {
        public void a();
    }

}

