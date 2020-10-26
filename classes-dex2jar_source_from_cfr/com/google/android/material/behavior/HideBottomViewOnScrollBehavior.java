/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 */
package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.a;

public class HideBottomViewOnScrollBehavior<V extends View>
extends CoordinatorLayout.b<V> {
    private int a = 0;
    private int b = 2;
    private ViewPropertyAnimator c;

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(V v2, int n2, long l2, TimeInterpolator timeInterpolator) {
        this.c = v2.animate().translationY((float)n2).setInterpolator(timeInterpolator).setDuration(l2).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.c = null;
            }
        });
    }

    public void a(V v2) {
        if (this.c != null) {
            this.c.cancel();
            v2.clearAnimation();
        }
        this.b = 2;
        this.a(v2, 0, 225L, a.d);
    }

    @Override
    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int n2, int n3, int n4, int n5) {
        if (this.b != 1 && n3 > 0) {
            this.b(v2);
            return;
        }
        if (this.b != 2 && n3 < 0) {
            this.a(v2);
        }
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        this.a = v2.getMeasuredHeight();
        return super.a(coordinatorLayout, v2, n2);
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int n2) {
        return n2 == 2;
    }

    public void b(V v2) {
        if (this.c != null) {
            this.c.cancel();
            v2.clearAnimation();
        }
        this.b = 1;
        this.a(v2, this.a, 175L, a.c);
    }

}

