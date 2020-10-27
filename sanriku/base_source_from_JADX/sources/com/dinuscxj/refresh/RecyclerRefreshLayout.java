package com.dinuscxj.refresh;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import p009e.p010a.p011a.p012a.C0681a;

public class RecyclerRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public float f48A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public float f49B;

    /* renamed from: C */
    private boolean f50C;

    /* renamed from: D */
    private boolean f51D;

    /* renamed from: E */
    private boolean f52E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C0542g f53F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public View f54G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View f55H;

    /* renamed from: I */
    private C0544b f56I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public C0543a f57J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C0541f f58K;

    /* renamed from: L */
    private Interpolator f59L;

    /* renamed from: M */
    private Interpolator f60M;

    /* renamed from: N */
    private final Animation f61N;

    /* renamed from: O */
    private final Animation f62O;

    /* renamed from: P */
    private final Animation.AnimationListener f63P;

    /* renamed from: Q */
    private final Animation.AnimationListener f64Q;

    /* renamed from: a */
    private float f65a;

    /* renamed from: b */
    private boolean f66b;

    /* renamed from: c */
    private final int[] f67c;

    /* renamed from: d */
    private final int[] f68d;

    /* renamed from: e */
    private final NestedScrollingChildHelper f69e;

    /* renamed from: f */
    private final NestedScrollingParentHelper f70f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f71g;

    /* renamed from: h */
    private boolean f72h;

    /* renamed from: i */
    private boolean f73i;

    /* renamed from: l */
    private boolean f74l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f75m;

    /* renamed from: n */
    private boolean f76n;

    /* renamed from: o */
    private int f77o;

    /* renamed from: p */
    private int f78p;

    /* renamed from: q */
    private int f79q;

    /* renamed from: r */
    private int f80r;

    /* renamed from: s */
    private int f81s;

    /* renamed from: t */
    private int f82t;

    /* renamed from: u */
    private int f83u;

    /* renamed from: v */
    private float f84v;

    /* renamed from: w */
    private float f85w;

    /* renamed from: x */
    private float f86x;

    /* renamed from: y */
    private float f87y;

    /* renamed from: z */
    private float f88z;

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$a */
    class C0536a extends Animation {
        C0536a() {
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            if (RecyclerRefreshLayout.this.f53F.ordinal() != 2) {
                RecyclerRefreshLayout recyclerRefreshLayout = RecyclerRefreshLayout.this;
                RecyclerRefreshLayout.m28a(recyclerRefreshLayout, recyclerRefreshLayout.f49B, (float) RecyclerRefreshLayout.this.f54G.getTop(), f);
                return;
            }
            float b = RecyclerRefreshLayout.this.f49B + RecyclerRefreshLayout.this.f48A;
            RecyclerRefreshLayout recyclerRefreshLayout2 = RecyclerRefreshLayout.this;
            RecyclerRefreshLayout.m28a(recyclerRefreshLayout2, b, (float) recyclerRefreshLayout2.f55H.getTop(), f);
        }
    }

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$b */
    class C0537b extends Animation {
        C0537b() {
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            RecyclerRefreshLayout recyclerRefreshLayout;
            View view;
            float f2;
            if (RecyclerRefreshLayout.this.f53F.ordinal() != 2) {
                recyclerRefreshLayout = RecyclerRefreshLayout.this;
                f2 = 0.0f;
                view = recyclerRefreshLayout.f54G;
            } else {
                recyclerRefreshLayout = RecyclerRefreshLayout.this;
                f2 = recyclerRefreshLayout.f48A;
                view = RecyclerRefreshLayout.this.f55H;
            }
            RecyclerRefreshLayout.m28a(recyclerRefreshLayout, f2, (float) view.getTop(), f);
        }
    }

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$c */
    class C0538c implements Animation.AnimationListener {
        C0538c() {
        }

        public void onAnimationEnd(Animation animation) {
            if (RecyclerRefreshLayout.this.f75m && RecyclerRefreshLayout.this.f58K != null) {
                RecyclerRefreshLayout.this.f58K.onRefresh();
            }
            boolean unused = RecyclerRefreshLayout.this.f71g = false;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            boolean unused = RecyclerRefreshLayout.this.f71g = true;
            RecyclerRefreshLayout.this.f57J.refreshing();
        }
    }

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$d */
    class C0539d implements Animation.AnimationListener {
        C0539d() {
        }

        public void onAnimationEnd(Animation animation) {
            RecyclerRefreshLayout.this.m37c();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            boolean unused = RecyclerRefreshLayout.this.f71g = true;
            RecyclerRefreshLayout.this.f57J.refreshComplete();
        }
    }

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$e */
    public static class C0540e extends ViewGroup.MarginLayoutParams {
        public C0540e(int i, int i2) {
            super(i, i2);
        }

        public C0540e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0540e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$f */
    public interface C0541f {
        void onRefresh();
    }

    /* renamed from: com.dinuscxj.refresh.RecyclerRefreshLayout$g */
    public enum C0542g {
        NORMAL,
        PINNED,
        FLOAT
    }

    public RecyclerRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67c = new int[2];
        this.f68d = new int[2];
        this.f77o = -1;
        this.f78p = -1;
        this.f79q = 300;
        this.f80r = 300;
        this.f50C = false;
        this.f51D = false;
        this.f52E = false;
        this.f53F = C0542g.NORMAL;
        this.f59L = new DecelerateInterpolator(2.0f);
        this.f60M = new DecelerateInterpolator(2.0f);
        this.f61N = new C0536a();
        this.f62O = new C0537b();
        this.f63P = new C0538c();
        this.f64Q = new C0539d();
        this.f82t = ViewConfiguration.get(context).getScaledTouchSlop();
        float f = getResources().getDisplayMetrics().density;
        this.f83u = (int) (30.0f * f);
        this.f49B = f * 50.0f;
        this.f88z = 0.0f;
        this.f48A = 0.0f;
        this.f70f = new NestedScrollingParentHelper(this);
        this.f69e = new NestedScrollingChildHelper(this);
        C0546d dVar = new C0546d(getContext());
        this.f55H = dVar;
        dVar.setVisibility(8);
        View view = this.f55H;
        if (view instanceof C0543a) {
            this.f57J = (C0543a) view;
            int i = this.f83u;
            addView(this.f55H, new C0540e(i, i));
            this.f56I = new C0544b();
            setNestedScrollingEnabled(true);
            ViewCompat.setChildrenDrawingOrderEnabled(this, true);
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    /* renamed from: a */
    private float m22a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    /* renamed from: a */
    private void m25a(int i) {
        View view;
        View view2;
        C0543a aVar;
        float f;
        float f2;
        if (this.f54G != null) {
            int ordinal = this.f53F.ordinal();
            if (ordinal == 1) {
                view = this.f54G;
                view.offsetTopAndBottom(i);
                view2 = this.f54G;
            } else if (ordinal != 2) {
                this.f54G.offsetTopAndBottom(i);
                view = this.f55H;
                view.offsetTopAndBottom(i);
                view2 = this.f54G;
            } else {
                this.f55H.offsetTopAndBottom(i);
                view2 = this.f55H;
            }
            this.f88z = (float) view2.getTop();
            if (this.f53F.ordinal() != 2) {
                aVar = this.f57J;
                f2 = this.f88z;
                f = f2 / this.f49B;
            } else {
                aVar = this.f57J;
                f2 = this.f88z;
                f = (f2 - this.f48A) / this.f49B;
            }
            aVar.pullProgress(f2, f);
            if (this.f55H.getVisibility() != 0) {
                this.f55H.setVisibility(0);
            }
            invalidate();
        }
    }

    /* renamed from: a */
    private void m26a(int i, Animation.AnimationListener animationListener) {
        clearAnimation();
        float f = (float) i;
        if (m36c(f) <= 0) {
            animationListener.onAnimationStart((Animation) null);
            animationListener.onAnimationEnd((Animation) null);
            return;
        }
        this.f81s = i;
        this.f62O.reset();
        this.f62O.setDuration((long) m36c(f));
        this.f62O.setInterpolator(this.f59L);
        if (animationListener != null) {
            this.f62O.setAnimationListener(animationListener);
        }
        startAnimation(this.f62O);
    }

    /* renamed from: a */
    private void m27a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f78p) {
            this.f78p = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
        this.f86x = m22a(motionEvent, this.f78p) - this.f87y;
    }

    /* renamed from: a */
    static /* synthetic */ void m28a(RecyclerRefreshLayout recyclerRefreshLayout, float f, float f2, float f3) {
        float f4 = (float) recyclerRefreshLayout.f81s;
        recyclerRefreshLayout.m25a((int) (((float) ((int) C0681a.m301a(f, f4, f3, f4))) - f2));
    }

    /* renamed from: a */
    private void m29a(boolean z, boolean z2) {
        if (this.f72h != z) {
            this.f75m = z2;
            this.f72h = z;
            if (z) {
                m35b((int) this.f88z, this.f63P);
            } else {
                m26a((int) this.f88z, this.f64Q);
            }
        }
    }

    /* renamed from: a */
    private boolean m30a(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (m30a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    /* renamed from: b */
    private int m33b(float f) {
        if (f < this.f48A) {
            return 0;
        }
        if (this.f53F.ordinal() == 2) {
            f -= this.f48A;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.f49B) / this.f49B)) * ((float) this.f80r));
    }

    /* renamed from: b */
    private void m34b() {
        if (!this.f72h && !this.f71g) {
            if (((float) (this.f53F.ordinal() != 2 ? this.f54G.getTop() : (int) (((float) this.f55H.getTop()) - this.f48A))) > this.f49B) {
                m29a(true, true);
                return;
            }
            this.f72h = false;
            m26a((int) this.f88z, this.f64Q);
        }
    }

    /* renamed from: b */
    private void m35b(int i, Animation.AnimationListener animationListener) {
        clearAnimation();
        float f = (float) i;
        if (m33b(f) <= 0) {
            animationListener.onAnimationStart((Animation) null);
            animationListener.onAnimationEnd((Animation) null);
            return;
        }
        this.f81s = i;
        this.f61N.reset();
        this.f61N.setDuration((long) m33b(f));
        this.f61N.setInterpolator(this.f60M);
        if (animationListener != null) {
            this.f61N.setAnimationListener(animationListener);
        }
        startAnimation(this.f61N);
    }

    /* renamed from: c */
    private int m36c(float f) {
        if (f < this.f48A) {
            return 0;
        }
        if (this.f53F.ordinal() == 2) {
            f -= this.f48A;
        }
        return (int) (Math.max(0.0f, Math.min(1.0f, Math.abs(f) / this.f49B)) * ((float) this.f79q));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m37c() {
        m25a((int) ((this.f53F.ordinal() != 2 ? 0.0f : this.f48A) - this.f88z));
        this.f87y = 0.0f;
        this.f57J.reset();
        this.f55H.setVisibility(8);
        this.f72h = false;
        this.f71g = false;
    }

    /* renamed from: d */
    private void m40d() {
        this.f85w = 0.0f;
        this.f74l = false;
        this.f76n = false;
        this.f78p = -1;
    }

    /* renamed from: d */
    private void m41d(float f) {
        float f2 = f - this.f84v;
        if (this.f72h && (f2 > ((float) this.f82t) || this.f88z > 0.0f)) {
            this.f74l = true;
            this.f86x = this.f84v + ((float) this.f82t);
        } else if (!this.f74l) {
            int i = this.f82t;
            if (f2 > ((float) i)) {
                this.f86x = this.f84v + ((float) i);
                this.f74l = true;
            }
        }
    }

    /* renamed from: e */
    private void m43e(float f) {
        this.f87y = f;
        if (this.f72h) {
            float f2 = this.f49B;
            if (f > f2) {
                f = f2;
            }
            if (f < 0.0f) {
                f = 0.0f;
            }
        } else if (this.f53F.ordinal() != 2) {
            f = this.f56I.mo9365a(f, this.f49B);
        } else {
            f = this.f56I.mo9365a(f, this.f49B) + this.f48A;
        }
        float f3 = this.f49B;
        if (!this.f72h) {
            if (f > f3 && !this.f73i) {
                this.f73i = true;
                this.f57J.pullToRefresh();
            } else if (f <= f3 && this.f73i) {
                this.f73i = false;
                this.f57J.releaseToRefresh();
            }
        }
        m25a((int) (f - this.f88z));
    }

    /* renamed from: a */
    public void mo9333a(float f) {
        this.f48A = f;
        this.f51D = true;
        requestLayout();
    }

    /* renamed from: a */
    public void mo9334a(View view, ViewGroup.LayoutParams layoutParams) {
        View view2 = this.f55H;
        if (view2 != view) {
            if (!(view2 == null || view2.getParent() == null)) {
                ((ViewGroup) this.f55H.getParent()).removeView(this.f55H);
            }
            if (view instanceof C0543a) {
                this.f57J = (C0543a) view;
                view.setVisibility(8);
                addView(view, layoutParams);
                this.f55H = view;
                return;
            }
            throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
        }
    }

    /* renamed from: a */
    public void mo9335a(C0541f fVar) {
        this.f58K = fVar;
    }

    /* renamed from: a */
    public void mo9336a(@NonNull C0542g gVar) {
        this.f53F = gVar;
    }

    /* renamed from: a */
    public void mo9337a(boolean z) {
        if (!z || this.f72h == z) {
            m29a(z, false);
            return;
        }
        this.f72h = z;
        this.f75m = false;
        m35b((int) this.f88z, this.f63P);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0540e;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f69e.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f69e.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f69e.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f69e.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 1 || actionMasked == 3) {
            onStopNestedScroll(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0540e(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0540e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.f53F.ordinal() != 2) {
            int i3 = this.f77o;
            return i3 < 0 ? i2 : i2 == 0 ? i3 : i2 <= i3 ? i2 - 1 : i2;
        }
        int i4 = this.f77o;
        return i4 < 0 ? i2 : i2 == i + -1 ? i4 : i2 >= i4 ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.f70f.getNestedScrollAxes();
    }

    public boolean hasNestedScrollingParent() {
        return this.f69e.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f69e.isNestedScrollingEnabled();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m37c();
        clearAnimation();
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m24a();
        if (this.f54G == null) {
            return false;
        }
        if (this.f53F.ordinal() != 2) {
            if (!isEnabled() || (m30a(this.f54G) && !this.f76n)) {
                return false;
            }
        } else if (!isEnabled() || m30a(this.f54G) || this.f72h || this.f66b) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f78p;
                    if (i == -1) {
                        return false;
                    }
                    float a = m22a(motionEvent, i);
                    if (a == -1.0f) {
                        return false;
                    }
                    m41d(a);
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        m27a(motionEvent);
                    }
                }
            }
            this.f74l = false;
            this.f78p = -1;
        } else {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f78p = pointerId;
            this.f74l = false;
            float a2 = m22a(motionEvent, pointerId);
            if (a2 == -1.0f) {
                return false;
            }
            if (this.f61N.hasEnded() && this.f62O.hasEnded()) {
                this.f71g = false;
            }
            this.f84v = a2;
            this.f85w = this.f88z;
            this.f76n = false;
        }
        return this.f74l;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() != 0) {
            m24a();
            if (this.f54G != null) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                int paddingTop = getPaddingTop();
                int ordinal = this.f53F.ordinal();
                if (ordinal == 1 || ordinal != 2) {
                    paddingTop += (int) this.f88z;
                }
                int paddingLeft = getPaddingLeft();
                try {
                    this.f54G.layout(paddingLeft, paddingTop, ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight(), ((measuredHeight + paddingTop) - getPaddingTop()) - getPaddingBottom());
                } catch (Exception e) {
                    e.toString();
                    e.getStackTrace().toString();
                }
                int measuredWidth2 = (measuredWidth - this.f55H.getMeasuredWidth()) / 2;
                int i5 = (int) this.f48A;
                if (this.f53F.ordinal() != 1) {
                    i5 += (int) this.f88z;
                }
                this.f55H.layout(measuredWidth2, i5, (this.f55H.getMeasuredWidth() + measuredWidth) / 2, this.f55H.getMeasuredHeight() + i5);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        m24a();
        View view = this.f54G;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55H.getLayoutParams();
            if (marginLayoutParams.width == -1) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824);
            } else {
                i3 = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
            }
            if (marginLayoutParams.height == -1) {
                i4 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824);
            } else {
                i4 = ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
            }
            this.f55H.measure(i3, i4);
            if (!this.f52E && !this.f51D) {
                int ordinal = this.f53F.ordinal();
                if (ordinal == 1) {
                    this.f48A = 0.0f;
                    this.f88z = 0.0f;
                } else if (ordinal != 2) {
                    this.f88z = 0.0f;
                    this.f48A = (float) (-this.f55H.getMeasuredHeight());
                } else {
                    float f = (float) (-this.f55H.getMeasuredHeight());
                    this.f48A = f;
                    this.f88z = f;
                }
            }
            if (!this.f52E && !this.f50C && this.f49B < ((float) this.f55H.getMeasuredHeight())) {
                this.f49B = (float) this.f55H.getMeasuredHeight();
            }
            this.f52E = true;
            this.f77o = -1;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                if (getChildAt(i5) == this.f55H) {
                    this.f77o = i5;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.f65a;
            if (f > 0.0f) {
                float f2 = (float) i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.f65a = 0.0f;
                } else {
                    this.f65a = f - f2;
                    iArr[1] = i2;
                }
                m43e(this.f65a);
            }
        }
        int[] iArr2 = this.f67c;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f68d);
        int i5 = i4 + this.f68d[1];
        if (i5 < 0) {
            float abs = this.f65a + ((float) Math.abs(i5));
            this.f65a = abs;
            m43e(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f70f.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f65a = 0.0f;
        this.f66b = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return this.f53F.ordinal() != 2 ? isEnabled() && m30a(this.f54G) && (i & 2) != 0 : isEnabled() && m30a(this.f54G) && !this.f72h && (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f70f.onStopNestedScroll(view);
        this.f66b = false;
        if (this.f65a > 0.0f) {
            m34b();
            this.f65a = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        m24a();
        if (this.f54G == null) {
            return false;
        }
        if (this.f53F.ordinal() != 2) {
            if (!isEnabled() || (m30a(this.f54G) && !this.f76n)) {
                return false;
            }
        } else if (!isEnabled() || m30a(this.f54G) || this.f66b) {
            return false;
        }
        if (this.f53F == C0542g.FLOAT && (m30a(this.f54G) || this.f66b)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.f78p;
                    if (i == -1) {
                        return false;
                    }
                    float a = m22a(motionEvent, i);
                    if (a == -1.0f) {
                        return false;
                    }
                    if (this.f71g) {
                        f = (float) (this.f53F.ordinal() != 2 ? this.f54G : this.f55H).getTop();
                        this.f86x = a;
                        this.f85w = f;
                    } else {
                        f = (a - this.f86x) + this.f85w;
                    }
                    if (this.f72h) {
                        if (f <= 0.0f) {
                            if (!this.f76n) {
                                motionEvent = MotionEvent.obtain(motionEvent);
                                motionEvent.setAction(0);
                                this.f76n = true;
                            }
                        } else if (f > 0.0f && f < this.f49B && this.f76n) {
                            motionEvent = MotionEvent.obtain(motionEvent);
                            motionEvent.setAction(3);
                            this.f76n = false;
                        }
                        this.f54G.dispatchTouchEvent(motionEvent);
                    } else if (!this.f74l) {
                        m41d(a);
                    } else if (f <= 0.0f) {
                        return false;
                    }
                    m43e(f);
                } else if (action != 3) {
                    if (action == 5) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                        this.f78p = pointerId;
                        this.f86x = m22a(motionEvent, pointerId) - this.f87y;
                    } else if (action == 6) {
                        m27a(motionEvent);
                    }
                }
            }
            int i2 = this.f78p;
            if (i2 == -1 || m22a(motionEvent, i2) == -1.0f) {
                m40d();
                return false;
            } else if (this.f72h || this.f71g) {
                if (this.f76n) {
                    this.f54G.dispatchTouchEvent(motionEvent);
                }
                m40d();
                return false;
            } else {
                m40d();
                m34b();
                return false;
            }
        } else {
            this.f78p = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f74l = false;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f54G instanceof AbsListView)) {
            View view = this.f54G;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f69e.setNestedScrollingEnabled(z);
    }

    public boolean startNestedScroll(int i) {
        return this.f69e.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f69e.stopNestedScroll();
    }

    /* renamed from: a */
    private void m24a() {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= getChildCount()) {
                z = false;
                break;
            } else if (this.f54G == getChildAt(i)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.f55H)) {
                    this.f54G = childAt;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0540e(layoutParams);
    }
}
