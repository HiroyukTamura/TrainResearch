/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 */
package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.Collection;
import java.util.List;

public class b {
    public static void a(AnimatorSet animatorSet, List<Animator> list) {
        Animator animator;
        int n2 = list.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            animator = list.get(i2);
            l2 = Math.max(l2, animator.getStartDelay() + animator.getDuration());
        }
        animator = ValueAnimator.ofInt((int[])new int[]{0, 0});
        animator.setDuration(l2);
        list.add(0, animator);
        animatorSet.playTogether(list);
    }
}

