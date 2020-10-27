package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import p009e.p028d.p030b.p054b.p056d.C1546c;

/* renamed from: com.google.android.material.transformation.b */
class C1225b extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1546c f1351a;

    /* renamed from: b */
    final /* synthetic */ Drawable f1352b;

    C1225b(FabTransformationBehavior fabTransformationBehavior, C1546c cVar, Drawable drawable) {
        this.f1351a = cVar;
        this.f1352b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1351a.mo27314a((Drawable) null);
    }

    public void onAnimationStart(Animator animator) {
        this.f1351a.mo27314a(this.f1352b);
    }
}
