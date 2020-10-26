/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.transformation.ExpandableBehavior;

public abstract class ExpandableTransformationBehavior
extends ExpandableBehavior {
    private AnimatorSet a;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected boolean a(View view, View view2, boolean bl2, boolean bl3) {
        boolean bl4 = this.a != null;
        if (bl4) {
            this.a.cancel();
        }
        this.a = this.b(view, view2, bl2, bl4);
        this.a.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.a = null;
            }
        });
        this.a.start();
        if (!bl3) {
            this.a.end();
        }
        return true;
    }

    protected abstract AnimatorSet b(View var1, View var2, boolean var3, boolean var4);

}

