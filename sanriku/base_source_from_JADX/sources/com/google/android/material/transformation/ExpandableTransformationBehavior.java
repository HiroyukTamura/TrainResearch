package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b */
    public AnimatorSet f1334b;

    /* renamed from: com.google.android.material.transformation.ExpandableTransformationBehavior$a */
    class C1220a extends AnimatorListenerAdapter {
        C1220a() {
        }

        public void onAnimationEnd(Animator animator) {
            AnimatorSet unused = ExpandableTransformationBehavior.this.f1334b = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    /* renamed from: a */
    public boolean mo25563a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f1334b != null;
        if (z3) {
            this.f1334b.cancel();
        }
        AnimatorSet b = mo25565b(view, view2, z, z3);
        this.f1334b = b;
        b.addListener(new C1220a());
        this.f1334b.start();
        if (!z2) {
            this.f1334b.end();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: b */
    public abstract AnimatorSet mo25565b(View view, View view2, boolean z, boolean z2);
}
