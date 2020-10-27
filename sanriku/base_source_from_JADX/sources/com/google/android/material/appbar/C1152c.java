package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: com.google.android.material.appbar.c */
abstract class C1152c extends C1153d<View> {

    /* renamed from: d */
    final Rect f1035d = new Rect();

    /* renamed from: e */
    final Rect f1036e = new Rect();

    /* renamed from: f */
    private int f1037f = 0;

    /* renamed from: g */
    private int f1038g;

    public C1152c() {
    }

    public C1152c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo25340a(View view) {
        int i;
        if (this.f1038g == 0) {
            return 0;
        }
        float f = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int f2 = appBarLayout.mo25309f();
            int a = appBarLayout.mo25300a();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            int b = behavior instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) behavior).mo25330b() : 0;
            if ((a == 0 || f2 + b > a) && (i = f2 - a) != 0) {
                f = 1.0f + (((float) b) / ((float) i));
            }
        }
        int i2 = this.f1038g;
        return MathUtils.clamp((int) (f * ((float) i2)), 0, i2);
    }

    /* renamed from: b */
    public final int mo25342b() {
        return this.f1038g;
    }

    /* renamed from: b */
    public final void mo25343b(int i) {
        this.f1038g = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final int mo25344c() {
        return this.f1037f;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        AppBarLayout a;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (a = ((AppBarLayout.ScrollingViewBehavior) this).mo25335a(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        if (!ViewCompat.getFitsSystemWindows(a) || ViewCompat.getFitsSystemWindows(view)) {
            View view2 = view;
        } else {
            View view3 = view;
            ViewCompat.setFitsSystemWindows(view, true);
            if (ViewCompat.getFitsSystemWindows(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - a.getMeasuredHeight()) + a.mo25309f(), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25341a(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        AppBarLayout a = ((AppBarLayout.ScrollingViewBehavior) this).mo25335a(coordinatorLayout.getDependencies(view));
        if (a != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f1035d;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, a.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((a.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left = lastWindowInsets.getSystemWindowInsetLeft() + rect.left;
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f1036e;
            int i3 = layoutParams.gravity;
            GravityCompat.apply(i3 == 0 ? 8388659 : i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int a2 = mo25340a(a);
            view.layout(rect2.left, rect2.top - a2, rect2.right, rect2.bottom - a2);
            i2 = rect2.top - a.getBottom();
        } else {
            coordinatorLayout.onLayoutChild(view, i);
            i2 = 0;
        }
        this.f1037f = i2;
    }
}
