package com.dinuscxj.refresh;

import android.animation.ValueAnimator;

/* renamed from: com.dinuscxj.refresh.c */
class C0545c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ C0546d f97a;

    C0545c(C0546d dVar) {
        this.f97a = dVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        C0546d.m54a(this.f97a, (((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f) + 285.0f);
    }
}
