package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p009e.p028d.p030b.p054b.p055c.C1534a;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    private int f1048a = 0;

    /* renamed from: b */
    private int f1049b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ViewPropertyAnimator f1050c;

    /* renamed from: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$a */
    class C1156a extends AnimatorListenerAdapter {
        C1156a() {
        }

        public void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.f1050c = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private void m1719a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f1050c = v.animate().translationY((float) i).setInterpolator(timeInterpolator).setDuration(j).setListener(new C1156a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25351a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f1050c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1049b = 1;
        m1719a(v, this.f1048a, 175, C1534a.f1770b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25352b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f1050c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1049b = 2;
        m1719a(v, 0, 225, C1534a.f1771c);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f1048a = v.getMeasuredHeight();
        return super.onLayoutChild(coordinatorLayout, v, i);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f1049b != 1 && i2 > 0) {
            mo25351a(v);
        } else if (this.f1049b != 2 && i2 < 0) {
            mo25352b(v);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }
}
