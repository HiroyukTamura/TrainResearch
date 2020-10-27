package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.google.android.material.transformation.a */
class C1224a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ View f1350a;

    C1224a(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f1350a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1350a.invalidate();
    }
}
