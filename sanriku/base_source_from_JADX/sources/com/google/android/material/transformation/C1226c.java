package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import p009e.p028d.p030b.p054b.p056d.C1546c;

/* renamed from: com.google.android.material.transformation.c */
class C1226c extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1546c f1353a;

    C1226c(FabTransformationBehavior fabTransformationBehavior, C1546c cVar) {
        this.f1353a = cVar;
    }

    public void onAnimationEnd(Animator animator) {
        C1546c.C1551e a = this.f1353a.mo27312a();
        a.f1798c = Float.MAX_VALUE;
        this.f1353a.mo27315a(a);
    }
}
