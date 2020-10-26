/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.AnimatorListenerAdapter
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

class a {
    static void a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList arrayList = animator.getListeners();
        if (arrayList != null) {
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)arrayList.get(i2);
                if (!(animatorListener instanceof a)) continue;
                ((a)animatorListener).onAnimationPause(animator);
            }
        }
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener((Animator.AnimatorPauseListener)animatorListenerAdapter);
        }
    }

    static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList arrayList = animator.getListeners();
        if (arrayList != null) {
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)arrayList.get(i2);
                if (!(animatorListener instanceof a)) continue;
                ((a)animatorListener).onAnimationResume(animator);
            }
        }
    }

    static interface a {
        public void onAnimationPause(Animator var1);

        public void onAnimationResume(Animator var1);
    }

}

