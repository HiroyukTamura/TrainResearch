package com.google.android.material.tabs;

import android.animation.ValueAnimator;

/* renamed from: com.google.android.material.tabs.b */
class C1218b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ TabLayout f1328a;

    C1218b(TabLayout tabLayout) {
        this.f1328a = tabLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1328a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
