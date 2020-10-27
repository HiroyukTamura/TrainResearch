package com.isseiaoki.simplecropview.p051g;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;

@TargetApi(14)
/* renamed from: com.isseiaoki.simplecropview.g.c */
public class C1459c implements C1457a, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    private ValueAnimator f1532a;

    /* renamed from: b */
    private C1458b f1533b = new C1460a(this);

    /* renamed from: com.isseiaoki.simplecropview.g.c$a */
    class C1460a implements C1458b {
        C1460a(C1459c cVar) {
        }

        /* renamed from: a */
        public void mo27146a() {
        }

        /* renamed from: a */
        public void mo27147a(float f) {
        }

        /* renamed from: b */
        public void mo27148b() {
        }
    }

    public C1459c(Interpolator interpolator) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f1532a = ofFloat;
        ofFloat.addListener(this);
        this.f1532a.addUpdateListener(this);
        this.f1532a.setInterpolator(interpolator);
    }

    /* renamed from: a */
    public void mo27161a() {
        this.f1532a.cancel();
    }

    /* renamed from: a */
    public void mo27162a(long j) {
        if (j >= 0) {
            this.f1532a.setDuration(j);
        } else {
            this.f1532a.setDuration(150);
        }
        this.f1532a.start();
    }

    /* renamed from: a */
    public void mo27163a(C1458b bVar) {
        if (bVar != null) {
            this.f1533b = bVar;
        }
    }

    public void onAnimationCancel(Animator animator) {
        this.f1533b.mo27146a();
    }

    public void onAnimationEnd(Animator animator) {
        this.f1533b.mo27146a();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.f1533b.mo27148b();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1533b.mo27147a(valueAnimator.getAnimatedFraction());
    }
}
