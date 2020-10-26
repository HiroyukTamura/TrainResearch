/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.graphics.Paint
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.t;
import androidx.j.ad;
import androidx.j.ai;
import androidx.j.m;
import androidx.j.n;
import androidx.j.s;
import java.util.Map;

public class d
extends ai {
    public d() {
    }

    public d(int n2) {
        this.a(n2);
    }

    private static float a(s object, float f2) {
        float f3 = f2;
        if (object != null) {
            object = (Float)((s)object).a.get("android:fade:transitionAlpha");
            f3 = f2;
            if (object != null) {
                f3 = ((Float)object).floatValue();
            }
        }
        return f3;
    }

    private Animator a(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ad.a(view, f2);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, ad.a, (float[])new float[]{f3});
        objectAnimator.addListener((Animator.AnimatorListener)new a(view));
        this.a(new n(){

            @Override
            public void a(m m2) {
                ad.a(view, 1.0f);
                ad.e(view);
                m2.b(this);
            }
        });
        return objectAnimator;
    }

    @Override
    public Animator a(ViewGroup viewGroup, View view, s s2, s s3) {
        float f2 = 0.0f;
        float f3 = d.a(s2, 0.0f);
        if (f3 != 1.0f) {
            f2 = f3;
        }
        return this.a(view, f2, 1.0f);
    }

    @Override
    public void a(s s2) {
        super.a(s2);
        s2.a.put("android:fade:transitionAlpha", Float.valueOf(ad.c(s2.b)));
    }

    @Override
    public Animator b(ViewGroup viewGroup, View view, s s2, s s3) {
        ad.d(view);
        return this.a(view, d.a(s2, 1.0f), 0.0f);
    }

    private static class a
    extends AnimatorListenerAdapter {
        private final View a;
        private boolean b = false;

        a(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            ad.a(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (t.s(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

}

