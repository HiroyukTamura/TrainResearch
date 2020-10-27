package p009e.p028d.p030b.p054b.p055c;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.d.b.b.c.h */
public class C1541h {

    /* renamed from: a */
    private long f1782a = 0;

    /* renamed from: b */
    private long f1783b = 300;
    @Nullable

    /* renamed from: c */
    private TimeInterpolator f1784c = null;

    /* renamed from: d */
    private int f1785d = 0;

    /* renamed from: e */
    private int f1786e = 1;

    public C1541h(long j, long j2) {
        this.f1782a = j;
        this.f1783b = j2;
    }

    public C1541h(long j, long j2, @NonNull TimeInterpolator timeInterpolator) {
        this.f1782a = j;
        this.f1783b = j2;
        this.f1784c = timeInterpolator;
    }

    /* renamed from: a */
    public long mo27303a() {
        return this.f1782a;
    }

    /* renamed from: a */
    public void mo27304a(Animator animator) {
        animator.setStartDelay(this.f1782a);
        animator.setDuration(this.f1783b);
        animator.setInterpolator(mo27306c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f1785d);
            valueAnimator.setRepeatMode(this.f1786e);
        }
    }

    /* renamed from: b */
    public long mo27305b() {
        return this.f1783b;
    }

    /* renamed from: c */
    public TimeInterpolator mo27306c() {
        TimeInterpolator timeInterpolator = this.f1784c;
        return timeInterpolator != null ? timeInterpolator : C1534a.f1769a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1541h.class != obj.getClass()) {
            return false;
        }
        C1541h hVar = (C1541h) obj;
        if (this.f1782a == hVar.f1782a && this.f1783b == hVar.f1783b && this.f1785d == hVar.f1785d && this.f1786e == hVar.f1786e) {
            return mo27306c().getClass().equals(hVar.mo27306c().getClass());
        }
        return false;
    }

    public int hashCode() {
        long j = this.f1782a;
        long j2 = this.f1783b;
        return ((((mo27306c().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.f1785d) * 31) + this.f1786e;
    }

    public String toString() {
        StringBuilder a = C0681a.m329a(10);
        a.append(C1541h.class.getName());
        a.append('{');
        a.append(Integer.toHexString(System.identityHashCode(this)));
        a.append(" delay: ");
        a.append(this.f1782a);
        a.append(" duration: ");
        a.append(this.f1783b);
        a.append(" interpolator: ");
        a.append(mo27306c().getClass());
        a.append(" repeatCount: ");
        a.append(this.f1785d);
        a.append(" repeatMode: ");
        return C0681a.m322a(a, this.f1786e, "}\n");
    }

    /* renamed from: a */
    static C1541h m2156a(ValueAnimator valueAnimator) {
        long startDelay = valueAnimator.getStartDelay();
        long duration = valueAnimator.getDuration();
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            interpolator = C1534a.f1769a;
        } else if (interpolator instanceof AccelerateInterpolator) {
            interpolator = C1534a.f1770b;
        } else if (interpolator instanceof DecelerateInterpolator) {
            interpolator = C1534a.f1771c;
        }
        C1541h hVar = new C1541h(startDelay, duration, interpolator);
        hVar.f1785d = valueAnimator.getRepeatCount();
        hVar.f1786e = valueAnimator.getRepeatMode();
        return hVar;
    }
}
