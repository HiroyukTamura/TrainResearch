/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  android.util.StateSet
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class e {
    ValueAnimator a = null;
    private final ArrayList<a> b = new ArrayList();
    private a c = null;
    private final Animator.AnimatorListener d = new AnimatorListenerAdapter(){

        public void onAnimationEnd(Animator animator) {
            if (e.this.a == animator) {
                e.this.a = null;
            }
        }
    };

    private void a(a a2) {
        this.a = a2.b;
        this.a.start();
    }

    private void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.end();
            this.a = null;
        }
    }

    public void a(int[] object) {
        block4 : {
            int n2 = this.b.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                a a2 = this.b.get(i2);
                if (!StateSet.stateSetMatches((int[])a2.a, (int[])object)) continue;
                object = a2;
                break block4;
            }
            object = null;
        }
        if (object == this.c) {
            return;
        }
        if (this.c != null) {
            this.b();
        }
        this.c = object;
        if (object != null) {
            this.a((a)object);
        }
    }

    public void a(int[] object, ValueAnimator valueAnimator) {
        object = new a((int[])object, valueAnimator);
        valueAnimator.addListener(this.d);
        this.b.add((a)object);
    }

    static class a {
        final int[] a;
        final ValueAnimator b;

        a(int[] arrn, ValueAnimator valueAnimator) {
            this.a = arrn;
            this.b = valueAnimator;
        }
    }

}

