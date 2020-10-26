/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 */
package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.a.a;

public class i {
    private long a = 0L;
    private long b = 300L;
    private TimeInterpolator c = null;
    private int d = 0;
    private int e = 1;

    public i(long l2, long l3) {
        this.a = l2;
        this.b = l3;
    }

    public i(long l2, long l3, TimeInterpolator timeInterpolator) {
        this.a = l2;
        this.b = l3;
        this.c = timeInterpolator;
    }

    static i a(ValueAnimator valueAnimator) {
        i i2 = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), i.b(valueAnimator));
        i2.d = valueAnimator.getRepeatCount();
        i2.e = valueAnimator.getRepeatMode();
        return i2;
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator timeInterpolator = valueAnimator.getInterpolator();
        if (!(timeInterpolator instanceof AccelerateDecelerateInterpolator) && timeInterpolator != null) {
            if (timeInterpolator instanceof AccelerateInterpolator) {
                return a.c;
            }
            valueAnimator = timeInterpolator;
            if (timeInterpolator instanceof DecelerateInterpolator) {
                valueAnimator = a.d;
            }
            return valueAnimator;
        }
        return a.b;
    }

    public long a() {
        return this.a;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.a());
        animator.setDuration(this.b());
        animator.setInterpolator(this.c());
        if (animator instanceof ValueAnimator) {
            animator = (ValueAnimator)animator;
            animator.setRepeatCount(this.d());
            animator.setRepeatMode(this.e());
        }
    }

    public long b() {
        return this.b;
    }

    public TimeInterpolator c() {
        if (this.c != null) {
            return this.c;
        }
        return a.b;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            object = (i)object;
            if (this.a() != ((i)object).a()) {
                return false;
            }
            if (this.b() != ((i)object).b()) {
                return false;
            }
            if (this.d() != ((i)object).d()) {
                return false;
            }
            if (this.e() != ((i)object).e()) {
                return false;
            }
            return this.c().getClass().equals(((i)object).c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return ((((int)(this.a() ^ this.a() >>> 32) * 31 + (int)(this.b() ^ this.b() >>> 32)) * 31 + this.c().getClass().hashCode()) * 31 + this.d()) * 31 + this.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" delay: ");
        stringBuilder.append(this.a());
        stringBuilder.append(" duration: ");
        stringBuilder.append(this.b());
        stringBuilder.append(" interpolator: ");
        stringBuilder.append(this.c().getClass());
        stringBuilder.append(" repeatCount: ");
        stringBuilder.append(this.d());
        stringBuilder.append(" repeatMode: ");
        stringBuilder.append(this.e());
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

