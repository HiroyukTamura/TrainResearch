/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListView
 *  android.widget.ScrollView
 */
package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.ab;
import androidx.core.h.j;
import androidx.core.h.t;
import com.google.android.material.a;
import com.google.android.material.appbar.e;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(a=Behavior.class)
public class AppBarLayout
extends LinearLayout {
    private int a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private ab f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private WeakReference<View> m;
    private int[] n;

    private void a(boolean bl2, boolean bl3, boolean bl4) {
        int n2 = bl2 ? 1 : 2;
        int n3 = 0;
        int n4 = bl3 ? 4 : 0;
        if (bl4) {
            n3 = 8;
        }
        this.e = n2 | n4 | n3;
        this.requestLayout();
    }

    private boolean b(boolean bl2) {
        if (this.i != bl2) {
            this.i = bl2;
            this.refreshDrawableState();
            return true;
        }
        return false;
    }

    private boolean f() {
        int n2 = this.getChildCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((b)this.getChildAt(i2).getLayoutParams()).c()) continue;
            return true;
        }
        return false;
    }

    private void g() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    private View h() {
        Object object = this.m;
        Object var2_2 = null;
        if (object == null && this.l != -1 && (object = (object = com.google.android.material.internal.b.a(this.getContext())) != null ? object.findViewById(this.l) : (this.getParent() instanceof ViewGroup ? ((ViewGroup)this.getParent()).findViewById(this.l) : null)) != null) {
            this.m = new WeakReference<Activity>((Activity)object);
        }
        object = var2_2;
        if (this.m != null) {
            object = (View)this.m.get();
        }
        return object;
    }

    private void i() {
        if (this.m != null) {
            this.m.clear();
        }
        this.m = null;
    }

    protected b a() {
        return new b(-1, -2);
    }

    public b a(AttributeSet attributeSet) {
        return new b(this.getContext(), attributeSet);
    }

    protected b a(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && layoutParams instanceof LinearLayout.LayoutParams) {
            return new b((LinearLayout.LayoutParams)layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams)layoutParams);
        }
        return new b(layoutParams);
    }

    void a(int n2) {
        if (this.g != null) {
            int n3 = this.g.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                a a2 = this.g.get(i2);
                if (a2 == null) continue;
                a2.a(this, n2);
            }
        }
    }

    public void a(boolean bl2, boolean bl3) {
        this.a(bl2, bl3, true);
    }

    boolean a(View view) {
        View view2 = this.h();
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    boolean a(boolean bl2) {
        if (this.j != bl2) {
            this.j = bl2;
            this.refreshDrawableState();
            return true;
        }
        return false;
    }

    boolean b() {
        return this.d;
    }

    boolean c() {
        return this.getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public boolean d() {
        return this.k;
    }

    void e() {
        this.e = 0;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    protected /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    /*
     * Enabled aggressive block sorting
     */
    int getDownNestedPreScrollRange() {
        int n2;
        if (this.b != -1) {
            return this.b;
        }
        int n3 = 0;
        for (int i2 = this.getChildCount() - 1; i2 >= 0; --i2) {
            View view = this.getChildAt(i2);
            b b2 = (b)view.getLayoutParams();
            int n4 = view.getMeasuredHeight();
            n2 = b2.a;
            if ((n2 & 5) == 5) {
                n3 += b2.topMargin + b2.bottomMargin;
                if ((n2 & 8) != 0) {
                    n2 = n3 + t.l(view);
                } else {
                    n2 = (n2 & 2) != 0 ? t.l(view) : this.getTopInset();
                    n2 = n3 + (n4 - n2);
                }
            } else {
                n2 = n3;
                if (n3 > 0) break;
            }
            n3 = n2;
        }
        this.b = n2 = Math.max(0, n3);
        return n2;
    }

    int getDownNestedScrollRange() {
        int n2;
        if (this.c != -1) {
            return this.c;
        }
        int n3 = this.getChildCount();
        int n4 = 0;
        int n5 = 0;
        do {
            n2 = n5;
            if (n4 >= n3) break;
            View view = this.getChildAt(n4);
            b b2 = (b)view.getLayoutParams();
            int n6 = view.getMeasuredHeight();
            int n7 = b2.topMargin;
            int n8 = b2.bottomMargin;
            int n9 = b2.a;
            n2 = n5;
            if ((n9 & 1) == 0) break;
            n5 += n6 + (n7 + n8);
            if ((n9 & 2) != 0) {
                n2 = n5 - (t.l(view) + this.getTopInset());
                break;
            }
            ++n4;
        } while (true);
        this.c = n5 = Math.max(0, n2);
        return n5;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.l;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int n2 = this.getTopInset();
        int n3 = t.l((View)this);
        if (n3 != 0) {
            return n3 * 2 + n2;
        }
        n3 = this.getChildCount();
        n3 = n3 >= 1 ? t.l(this.getChildAt(n3 - 1)) : 0;
        if (n3 == 0) return this.getHeight() / 3;
        return n3 * 2 + n2;
    }

    int getPendingAction() {
        return this.e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        if (this.f != null) {
            return this.f.b();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int n2;
        if (this.a != -1) {
            return this.a;
        }
        int n3 = this.getChildCount();
        int n4 = 0;
        int n5 = 0;
        do {
            n2 = n5;
            if (n4 >= n3) break;
            View view = this.getChildAt(n4);
            b b2 = (b)view.getLayoutParams();
            int n6 = view.getMeasuredHeight();
            int n7 = b2.a;
            n2 = n5;
            if ((n7 & 1) == 0) break;
            n5 += n6 + b2.topMargin + b2.bottomMargin;
            if ((n7 & 2) != 0) {
                n2 = n5 - t.l(view);
                break;
            }
            ++n4;
        } while (true);
        this.a = n5 = Math.max(0, n2 - this.getTopInset());
        return n5;
    }

    int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }

    protected int[] onCreateDrawableState(int n2) {
        if (this.n == null) {
            this.n = new int[4];
        }
        int[] arrn = this.n;
        int[] arrn2 = super.onCreateDrawableState(n2 + arrn.length);
        n2 = this.i ? a.b.state_liftable : -a.b.state_liftable;
        arrn[0] = n2;
        n2 = this.i && this.j ? a.b.state_lifted : -a.b.state_lifted;
        arrn[1] = n2;
        n2 = this.i ? a.b.state_collapsible : -a.b.state_collapsible;
        arrn[2] = n2;
        n2 = this.i && this.j ? a.b.state_collapsed : -a.b.state_collapsed;
        arrn[3] = n2;
        return AppBarLayout.mergeDrawableStates((int[])arrn2, (int[])arrn);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i();
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.g();
        bl2 = false;
        this.d = false;
        n3 = this.getChildCount();
        for (n2 = 0; n2 < n3; ++n2) {
            if (((b)this.getChildAt(n2).getLayoutParams()).b() == null) continue;
            this.d = true;
            break;
        }
        if (!this.h) {
            if (this.k || this.f()) {
                bl2 = true;
            }
            this.b(bl2);
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.g();
    }

    public void setExpanded(boolean bl2) {
        this.a(bl2, t.y((View)this));
    }

    public void setLiftOnScroll(boolean bl2) {
        this.k = bl2;
    }

    public void setLiftOnScrollTargetViewId(int n2) {
        this.l = n2;
        this.i();
    }

    public void setOrientation(int n2) {
        if (n2 == 1) {
            super.setOrientation(n2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a((View)this, f2);
        }
    }

    protected static class BaseBehavior<T extends AppBarLayout>
    extends com.google.android.material.appbar.a<T> {
        private int b;
        private int c;
        private ValueAnimator d;
        private int e = -1;
        private boolean f;
        private float g;
        private WeakReference<View> h;
        private a i;

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int a(T t2, int n2) {
            int n3 = t2.getChildCount();
            for (int i2 = 0; i2 < n3; ++i2) {
                Object object = t2.getChildAt(i2);
                int n4 = object.getTop();
                int n5 = object.getBottom();
                object = (com.google.android.material.appbar.AppBarLayout$b)object.getLayoutParams();
                int n6 = n4;
                int n7 = n5;
                if (BaseBehavior.a(((com.google.android.material.appbar.AppBarLayout$b)((Object)object)).a(), 32)) {
                    n6 = n4 - ((com.google.android.material.appbar.AppBarLayout$b)object).topMargin;
                    n7 = n5 + ((com.google.android.material.appbar.AppBarLayout$b)object).bottomMargin;
                }
                if (n6 > (n5 = -n2) || n7 < n5) continue;
                return i2;
            }
            return -1;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int n2 = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = coordinatorLayout.getChildAt(i2);
                if (!(view instanceof j) && !(view instanceof ListView)) {
                    if (!(view instanceof ScrollView)) continue;
                    return view;
                }
                return view;
            }
            return null;
        }

        private void a(int n2, T t2, View view, int n3) {
            if (n3 == 1) {
                n3 = this.b();
                if (n2 < 0 && n3 == 0 || n2 > 0 && n3 == -((AppBarLayout)((Object)t2)).getDownNestedScrollRange()) {
                    t.d(view, 1);
                }
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, T t2, int n2, float f2) {
            int n3 = Math.abs(this.b() - n2);
            n3 = (f2 = Math.abs(f2)) > 0.0f ? Math.round((float)n3 / f2 * 1000.0f) * 3 : (int)(((float)n3 / (float)t2.getHeight() + 1.0f) * 150.0f);
            this.a(coordinatorLayout, t2, n2, n3);
        }

        private void a(final CoordinatorLayout coordinatorLayout, T t2, int n2, int n3) {
            int n4 = this.b();
            if (n4 == n2) {
                if (this.d != null && this.d.isRunning()) {
                    this.d.cancel();
                }
                return;
            }
            if (this.d == null) {
                this.d = new ValueAnimator();
                this.d.setInterpolator(com.google.android.material.a.a.e);
                this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener((AppBarLayout)((Object)t2)){
                    final /* synthetic */ AppBarLayout b;
                    {
                        this.b = appBarLayout;
                    }

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.a_(coordinatorLayout, this.b, (Integer)valueAnimator.getAnimatedValue());
                    }
                });
            } else {
                this.d.cancel();
            }
            this.d.setDuration((long)Math.min(n3, 600));
            this.d.setIntValues(new int[]{n4, n2});
            this.d.start();
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(CoordinatorLayout coordinatorLayout, T t2, int n2, int n3, boolean bl2) {
            block5 : {
                boolean bl3;
                block6 : {
                    block8 : {
                        View view;
                        int n4;
                        boolean bl4;
                        int n5;
                        block7 : {
                            view = BaseBehavior.c(t2, n2);
                            if (view == null) break block5;
                            n5 = ((com.google.android.material.appbar.AppBarLayout$b)view.getLayoutParams()).a();
                            bl3 = bl4 = false;
                            if ((n5 & 1) == 0) break block6;
                            n4 = t.l(view);
                            if (n3 <= 0 || (n5 & 12) == 0) break block7;
                            bl3 = bl4;
                            if (-n2 < view.getBottom() - n4 - ((AppBarLayout)((Object)t2)).getTopInset()) break block6;
                            break block8;
                        }
                        bl3 = bl4;
                        if ((n5 & 2) == 0) break block6;
                        bl3 = bl4;
                        if (-n2 < view.getBottom() - n4 - ((AppBarLayout)((Object)t2)).getTopInset()) break block6;
                    }
                    bl3 = true;
                }
                if (((AppBarLayout)((Object)t2)).d()) {
                    bl3 = ((AppBarLayout)((Object)t2)).a(this.a(coordinatorLayout));
                }
                bl3 = ((AppBarLayout)((Object)t2)).a(bl3);
                if (Build.VERSION.SDK_INT >= 11 && (bl2 || bl3 && this.d(coordinatorLayout, t2))) {
                    t2.jumpDrawablesToCurrentState();
                }
            }
        }

        private static boolean a(int n2, int n3) {
            return (n2 & n3) == n3;
        }

        @Override
        private boolean a(CoordinatorLayout coordinatorLayout, T t2, View view) {
            return ((AppBarLayout)((Object)t2)).c() && coordinatorLayout.getHeight() - view.getHeight() <= t2.getHeight();
        }

        private int b(T t2, int n2) {
            int n3 = Math.abs(n2);
            int n4 = t2.getChildCount();
            int n5 = 0;
            for (int i2 = 0; i2 < n4; ++i2) {
                View view = t2.getChildAt(i2);
                com.google.android.material.appbar.AppBarLayout$b b2 = (com.google.android.material.appbar.AppBarLayout$b)view.getLayoutParams();
                Interpolator interpolator = b2.b();
                if (n3 < view.getTop() || n3 > view.getBottom()) continue;
                if (interpolator == null) break;
                n4 = b2.a();
                i2 = n5;
                if ((n4 & 1) != 0) {
                    i2 = n5 = 0 + (view.getHeight() + b2.topMargin + b2.bottomMargin);
                    if ((n4 & 2) != 0) {
                        i2 = n5 - t.l(view);
                    }
                }
                n5 = i2;
                if (t.r(view)) {
                    n5 = i2 - ((AppBarLayout)((Object)t2)).getTopInset();
                }
                if (n5 <= 0) break;
                i2 = view.getTop();
                float f2 = n5;
                i2 = Math.round(f2 * interpolator.getInterpolation((float)(n3 - i2) / f2));
                return Integer.signum(n2) * (view.getTop() + i2);
            }
            return n2;
        }

        private static View c(AppBarLayout appBarLayout, int n2) {
            int n3 = Math.abs(n2);
            int n4 = appBarLayout.getChildCount();
            for (n2 = 0; n2 < n4; ++n2) {
                View view = appBarLayout.getChildAt(n2);
                if (n3 < view.getTop() || n3 > view.getBottom()) continue;
                return view;
            }
            return null;
        }

        private void c(CoordinatorLayout coordinatorLayout, T t2) {
            com.google.android.material.appbar.AppBarLayout$b b2;
            View view;
            int n2;
            int n3 = this.b();
            int n4 = this.a(t2, n3);
            if (n4 >= 0 && ((n2 = (b2 = (com.google.android.material.appbar.AppBarLayout$b)(view = t2.getChildAt(n4)).getLayoutParams()).a()) & 17) == 17) {
                int n5;
                int n6 = -view.getTop();
                int n7 = n5 = -view.getBottom();
                if (n4 == t2.getChildCount() - 1) {
                    n7 = n5 + ((AppBarLayout)((Object)t2)).getTopInset();
                }
                if (BaseBehavior.a(n2, 2)) {
                    n5 = n7 + t.l(view);
                    n4 = n6;
                } else {
                    n4 = n6;
                    n5 = n7;
                    if (BaseBehavior.a(n2, 5)) {
                        n5 = t.l(view) + n7;
                        if (n3 < n5) {
                            n4 = n5;
                            n5 = n7;
                        } else {
                            n4 = n6;
                        }
                    }
                }
                n6 = n4;
                n7 = n5;
                if (BaseBehavior.a(n2, 32)) {
                    n6 = n4 + b2.topMargin;
                    n7 = n5 - b2.bottomMargin;
                }
                n5 = n6;
                if (n3 < (n7 + n6) / 2) {
                    n5 = n7;
                }
                this.a(coordinatorLayout, t2, androidx.core.c.a.a(n5, -((AppBarLayout)((Object)t2)).getTotalScrollRange(), 0), 0.0f);
            }
        }

        private boolean d(CoordinatorLayout object, T object2) {
            object = ((CoordinatorLayout)object).d((View)object2);
            int n2 = object.size();
            boolean bl2 = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                object2 = ((CoordinatorLayout.e)((View)object.get(i2)).getLayoutParams()).b();
                if (!(object2 instanceof ScrollingViewBehavior)) continue;
                if (((ScrollingViewBehavior)object2).e() != 0) {
                    bl2 = true;
                }
                return bl2;
            }
            return false;
        }

        @Override
        /* synthetic */ int a(View view) {
            return this.c((T)((Object)((AppBarLayout)view)));
        }

        @Override
        int a(CoordinatorLayout coordinatorLayout, T t2, int n2, int n3, int n4) {
            int n5 = this.b();
            if (n3 != 0 && n5 >= n3 && n5 <= n4) {
                if (n5 != (n3 = androidx.core.c.a.a(n2, n3, n4))) {
                    n2 = ((AppBarLayout)((Object)t2)).b() ? this.b(t2, n3) : n3;
                    boolean bl2 = this.a(n2);
                    this.b = n3 - n2;
                    if (!bl2 && ((AppBarLayout)((Object)t2)).b()) {
                        coordinatorLayout.b((View)t2);
                    }
                    ((AppBarLayout)((Object)t2)).a(this.c());
                    n2 = n3 < n5 ? -1 : 1;
                    this.a(coordinatorLayout, t2, n3, n2, false);
                    return n5 - n3;
                }
            } else {
                this.b = 0;
            }
            return 0;
        }

        void a(CoordinatorLayout coordinatorLayout, T t2) {
            this.c(coordinatorLayout, t2);
            if (((AppBarLayout)((Object)t2)).d()) {
                ((AppBarLayout)((Object)t2)).a(((AppBarLayout)((Object)t2)).a(this.a(coordinatorLayout)));
            }
        }

        @Override
        public void a(CoordinatorLayout coordinatorLayout, T t2, Parcelable parcelable) {
            if (parcelable instanceof b) {
                parcelable = (b)parcelable;
                super.a(coordinatorLayout, t2, parcelable.a());
                this.e = parcelable.a;
                this.g = parcelable.b;
                this.f = parcelable.d;
                return;
            }
            super.a(coordinatorLayout, t2, parcelable);
            this.e = -1;
        }

        @Override
        public void a(CoordinatorLayout coordinatorLayout, T t2, View view, int n2) {
            if (this.c == 0 || n2 == 1) {
                this.c(coordinatorLayout, t2);
                if (((AppBarLayout)((Object)t2)).d()) {
                    ((AppBarLayout)((Object)t2)).a(((AppBarLayout)((Object)t2)).a(view));
                }
            }
            this.h = new WeakReference<View>(view);
        }

        @Override
        public void a(CoordinatorLayout coordinatorLayout, T t2, View view, int n2, int n3, int n4, int n5, int n6) {
            if (n5 < 0) {
                this.b(coordinatorLayout, t2, n5, -((AppBarLayout)((Object)t2)).getDownNestedScrollRange(), 0);
                this.a(n5, t2, view, n6);
            }
        }

        @Override
        public void a(CoordinatorLayout coordinatorLayout, T t2, View view, int n2, int n3, int[] arrn, int n4) {
            if (n3 != 0) {
                int n5;
                if (n3 < 0) {
                    n5 = -((AppBarLayout)((Object)t2)).getTotalScrollRange();
                    int n6 = ((AppBarLayout)((Object)t2)).getDownNestedPreScrollRange();
                    n2 = n5;
                    n5 = n6 + n5;
                } else {
                    n2 = -((AppBarLayout)((Object)t2)).getUpNestedPreScrollRange();
                    n5 = 0;
                }
                if (n2 != n5) {
                    arrn[1] = this.b(coordinatorLayout, t2, n3, n2, n5);
                    this.a(n3, t2, view, n4);
                }
            }
            if (((AppBarLayout)((Object)t2)).d()) {
                ((AppBarLayout)((Object)t2)).a(((AppBarLayout)((Object)t2)).a(view));
            }
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, T t2, int n2) {
            boolean bl2 = super.a(coordinatorLayout, t2, n2);
            int n3 = ((AppBarLayout)((Object)t2)).getPendingAction();
            if (this.e >= 0 && (n3 & 8) == 0) {
                View view = t2.getChildAt(this.e);
                n3 = -view.getBottom();
                n2 = this.f ? t.l(view) + ((AppBarLayout)((Object)t2)).getTopInset() : Math.round((float)view.getHeight() * this.g);
                this.a_(coordinatorLayout, t2, n3 + n2);
            } else if (n3 != 0) {
                n2 = (n3 & 4) != 0 ? 1 : 0;
                if ((n3 & 2) != 0) {
                    n3 = -((AppBarLayout)((Object)t2)).getUpNestedPreScrollRange();
                    if (n2 != 0) {
                        this.a(coordinatorLayout, t2, n3, 0.0f);
                    } else {
                        this.a_(coordinatorLayout, t2, n3);
                    }
                } else if ((n3 & 1) != 0) {
                    if (n2 != 0) {
                        this.a(coordinatorLayout, t2, 0, 0.0f);
                    } else {
                        this.a_(coordinatorLayout, t2, 0);
                    }
                }
            }
            ((AppBarLayout)((Object)t2)).e();
            this.e = -1;
            this.a(androidx.core.c.a.a(this.c(), -((AppBarLayout)((Object)t2)).getTotalScrollRange(), 0));
            this.a(coordinatorLayout, t2, this.c(), 0, true);
            ((AppBarLayout)((Object)t2)).a(this.c());
            return bl2;
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, T t2, int n2, int n3, int n4, int n5) {
            if (((CoordinatorLayout.e)t2.getLayoutParams()).height == -2) {
                coordinatorLayout.a((View)t2, n2, n3, View.MeasureSpec.makeMeasureSpec((int)0, (int)0), n5);
                return true;
            }
            return super.a(coordinatorLayout, t2, n2, n3, n4, n5);
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, T t2, View view, View view2, int n2, int n3) {
            boolean bl2 = (n2 & 2) != 0 && (((AppBarLayout)((Object)t2)).d() || this.a(coordinatorLayout, t2, view));
            if (bl2 && this.d != null) {
                this.d.cancel();
            }
            this.h = null;
            this.c = n3;
            return bl2;
        }

        boolean a(T object) {
            if (this.i != null) {
                return this.i.a(object);
            }
            object = this.h;
            boolean bl2 = true;
            if (object != null) {
                object = (View)this.h.get();
                if (object != null && object.isShown() && !object.canScrollVertically(-1)) {
                    return true;
                }
                bl2 = false;
            }
            return bl2;
        }

        @Override
        int b() {
            return this.c() + this.b;
        }

        @Override
        int b(T t2) {
            return -((AppBarLayout)((Object)t2)).getDownNestedScrollRange();
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, T t2) {
            Parcelable parcelable = super.d(coordinatorLayout, t2);
            int n2 = this.c();
            int n3 = t2.getChildCount();
            boolean bl2 = false;
            for (int i2 = 0; i2 < n3; ++i2) {
                coordinatorLayout = t2.getChildAt(i2);
                int n4 = coordinatorLayout.getBottom() + n2;
                if (coordinatorLayout.getTop() + n2 > 0 || n4 < 0) continue;
                parcelable = new b(parcelable);
                parcelable.a = i2;
                if (n4 == t.l((View)coordinatorLayout) + ((AppBarLayout)((Object)t2)).getTopInset()) {
                    bl2 = true;
                }
                parcelable.d = bl2;
                parcelable.b = (float)n4 / (float)coordinatorLayout.getHeight();
                return parcelable;
            }
            return parcelable;
        }

        int c(T t2) {
            return ((AppBarLayout)((Object)t2)).getTotalScrollRange();
        }

        @Override
        /* synthetic */ boolean c(View view) {
            return this.a((T)((Object)((AppBarLayout)view)));
        }

        @Override
        public /* synthetic */ Parcelable d(CoordinatorLayout coordinatorLayout, View view) {
            return this.b(coordinatorLayout, (T)((Object)((AppBarLayout)view)));
        }

        @Override
        /* synthetic */ void e(CoordinatorLayout coordinatorLayout, View view) {
            this.a(coordinatorLayout, (T)((Object)((AppBarLayout)view)));
        }

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T var1);
        }

        protected static class b
        extends androidx.e.a.a {
            public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>(){

                public b a(Parcel parcel) {
                    return new b(parcel, null);
                }

                public b a(Parcel parcel, ClassLoader classLoader) {
                    return new b(parcel, classLoader);
                }

                public b[] a(int n2) {
                    return new b[n2];
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
            float b;
            boolean d;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readInt();
                this.b = parcel.readFloat();
                boolean bl2 = parcel.readByte() != 0;
                this.d = bl2;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            @Override
            public void writeToParcel(Parcel parcel, int n2) {
                super.writeToParcel(parcel, n2);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.b);
                parcel.writeByte((byte)(this.d ? 1 : 0));
            }

        }

    }

    public static class Behavior
    extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior
    extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, a.i.ScrollingViewBehavior_Layout);
            this.b(context.getDimensionPixelSize(a.i.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            context.recycle();
        }

        private static int a(AppBarLayout object) {
            if ((object = ((CoordinatorLayout.e)object.getLayoutParams()).b()) instanceof BaseBehavior) {
                return ((BaseBehavior)object).b();
            }
            return 0;
        }

        private void a(View view, View view2) {
            CoordinatorLayout.b b2 = ((CoordinatorLayout.e)view2.getLayoutParams()).b();
            if (b2 instanceof BaseBehavior) {
                b2 = (BaseBehavior)b2;
                t.e(view, view2.getBottom() - view.getTop() + ((BaseBehavior)b2).b + this.d() - this.c(view2));
            }
        }

        private void b(View view, View object) {
            if (object instanceof AppBarLayout && ((AppBarLayout)((Object)(object = (AppBarLayout)((Object)object)))).d()) {
                ((AppBarLayout)((Object)object)).a(((AppBarLayout)((Object)object)).a(view));
            }
        }

        @Override
        float a(View object) {
            if (object instanceof AppBarLayout) {
                object = (AppBarLayout)((Object)object);
                int n2 = ((AppBarLayout)((Object)object)).getTotalScrollRange();
                int n3 = ((AppBarLayout)((Object)object)).getDownNestedPreScrollRange();
                int n4 = ScrollingViewBehavior.a((AppBarLayout)((Object)object));
                if (n3 != 0 && n2 + n4 <= n3) {
                    return 0.0f;
                }
                if ((n2 -= n3) != 0) {
                    return (float)n4 / (float)n2 + 1.0f;
                }
            }
            return 0.0f;
        }

        AppBarLayout a(List<View> list) {
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = list.get(i2);
                if (!(view instanceof AppBarLayout)) continue;
                return (AppBarLayout)view;
            }
            return null;
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean bl2) {
            AppBarLayout appBarLayout = this.a(coordinatorLayout.c(view));
            if (appBarLayout != null) {
                rect.offset(view.getLeft(), view.getTop());
                view = this.a;
                view.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!view.contains(rect)) {
                    appBarLayout.a(false, bl2 ^ true);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override
        int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout)view).getTotalScrollRange();
            }
            return super.b(view);
        }

        /* synthetic */ View b(List list) {
            return this.a(list);
        }

        @Override
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            this.a(view, view2);
            this.b(view, view2);
            return false;
        }
    }

    public static interface a<T extends AppBarLayout> {
        public void a(T var1, int var2);
    }

    public static class b
    extends LinearLayout.LayoutParams {
        int a = 1;
        Interpolator b;

        public b(int n2, int n3) {
            super(n2, n3);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            attributeSet = context.obtainStyledAttributes(attributeSet, a.i.AppBarLayout_Layout);
            this.a = attributeSet.getInt(a.i.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (attributeSet.hasValue(a.i.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.b = AnimationUtils.loadInterpolator((Context)context, (int)attributeSet.getResourceId(a.i.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            attributeSet.recycle();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            return (this.a & 1) == 1 && (this.a & 10) != 0;
        }
    }

}

