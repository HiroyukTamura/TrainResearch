/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewAnimationUtils
 */
package com.google.android.material.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.d.d;

public final class a {
    public static Animator.AnimatorListener a(final d d2) {
        return new AnimatorListenerAdapter(){

            public void onAnimationEnd(Animator animator) {
                d2.b();
            }

            public void onAnimationStart(Animator animator) {
                d2.a();
            }
        };
    }

    public static Animator a(d d2, float f2, float f3, float f4) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject((Object)d2, d.b.a, d.a.a, (Object[])new d.d[]{new d.d(f2, f3, f4)});
        if (Build.VERSION.SDK_INT >= 21) {
            d.d d3 = d2.getRevealInfo();
            if (d3 != null) {
                float f5 = d3.c;
                d2 = ViewAnimationUtils.createCircularReveal((View)((View)d2), (int)((int)f2), (int)((int)f3), (float)f5, (float)f4);
                d3 = new AnimatorSet();
                d3.playTogether(new Animator[]{objectAnimator, d2});
                return d3;
            }
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        return objectAnimator;
    }

}

