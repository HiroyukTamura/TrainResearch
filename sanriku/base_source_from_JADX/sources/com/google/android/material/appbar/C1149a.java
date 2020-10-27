package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: com.google.android.material.appbar.a */
class C1149a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ CoordinatorLayout f1022a;

    /* renamed from: b */
    final /* synthetic */ AppBarLayout f1023b;

    /* renamed from: c */
    final /* synthetic */ AppBarLayout.BaseBehavior f1024c;

    C1149a(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f1024c = baseBehavior;
        this.f1022a = coordinatorLayout;
        this.f1023b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1024c.mo25338b(this.f1022a, this.f1023b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
