package p009e.p028d.p030b.p054b.p056d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import p009e.p028d.p030b.p054b.p056d.C1546c;

/* renamed from: e.d.b.b.d.a */
public final class C1543a {

    /* renamed from: e.d.b.b.d.a$a */
    static class C1544a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C1546c f1790a;

        C1544a(C1546c cVar) {
            this.f1790a = cVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1790a.mo27318d();
        }

        public void onAnimationStart(Animator animator) {
            this.f1790a.mo27316b();
        }
    }

    /* renamed from: a */
    public static Animator.AnimatorListener m2161a(C1546c cVar) {
        return new C1544a(cVar);
    }

    /* renamed from: a */
    public static Animator m2162a(C1546c cVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, C1546c.C1549c.f1794a, C1546c.C1548b.f1792b, new C1546c.C1551e[]{new C1546c.C1551e(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        C1546c.C1551e a = cVar.mo27312a();
        if (a != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f, (int) f2, a.f1798c, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
}
