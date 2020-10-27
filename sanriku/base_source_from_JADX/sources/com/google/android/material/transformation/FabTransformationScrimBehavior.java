package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import p009e.p028d.p030b.p054b.C1532a;
import p009e.p028d.p030b.p054b.p055c.C1541h;

public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c */
    private final C1541h f1345c = new C1541h(75, 150);

    /* renamed from: d */
    private final C1541h f1346d = new C1541h(0, 150);

    /* renamed from: com.google.android.material.transformation.FabTransformationScrimBehavior$a */
    class C1223a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ boolean f1347a;

        /* renamed from: b */
        final /* synthetic */ View f1348b;

        C1223a(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
            this.f1347a = z;
            this.f1348b = view;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f1347a) {
                this.f1348b.setVisibility(4);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f1347a) {
                this.f1348b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public AnimatorSet mo25565b(View view, View view2, boolean z, boolean z2) {
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        C1541h hVar = z ? this.f1345c : this.f1346d;
        if (z) {
            if (!z2) {
                view2.setAlpha(0.0f);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{1.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f});
        }
        hVar.mo27304a((Animator) objectAnimator);
        arrayList.add(objectAnimator);
        AnimatorSet animatorSet = new AnimatorSet();
        C1532a.m2136a(animatorSet, (List<Animator>) arrayList);
        animatorSet.addListener(new C1223a(this, z, view2));
        return animatorSet;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
