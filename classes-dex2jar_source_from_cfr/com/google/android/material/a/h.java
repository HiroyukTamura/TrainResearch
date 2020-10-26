/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.util.Log
 */
package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import androidx.c.g;
import com.google.android.material.a.i;
import java.util.ArrayList;
import java.util.List;

public class h {
    private final g<String, i> a = new g();

    public static h a(Context object, int n2) {
        block4 : {
            try {
                object = AnimatorInflater.loadAnimator((Context)object, (int)n2);
                if (object instanceof AnimatorSet) {
                    return h.a(((AnimatorSet)object).getChildAnimations());
                }
                if (object == null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(n2));
                Log.w((String)"MotionSpec", (String)stringBuilder.toString(), (Throwable)exception);
                return null;
            }
            ArrayList<Animator> arrayList = new ArrayList<Animator>();
            arrayList.add((Animator)object);
            object = h.a(arrayList);
            return object;
        }
        return null;
    }

    private static h a(List<Animator> list) {
        h h2 = new h();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            h.a(h2, list.get(i2));
        }
        return h2;
    }

    private static void a(h object, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            animator = (ObjectAnimator)animator;
            ((h)object).a(animator.getPropertyName(), i.a((ValueAnimator)animator));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Animator must be an ObjectAnimator: ");
        ((StringBuilder)object).append((Object)animator);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public long a() {
        int n2 = this.a.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            i i3 = this.a.c(i2);
            l2 = Math.max(l2, i3.a() + i3.b());
        }
        return l2;
    }

    public void a(String string2, i i2) {
        this.a.put(string2, i2);
    }

    public boolean a(String string2) {
        return this.a.get(string2) != null;
    }

    public i b(String string2) {
        if (this.a(string2)) {
            return this.a.get(string2);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            object = (h)object;
            return this.a.equals(((h)object).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" timings: ");
        stringBuilder.append(this.a);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

