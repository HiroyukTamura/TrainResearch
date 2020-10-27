package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.google.android.material.internal.c */
public final class C1193c {

    /* renamed from: a */
    private final ArrayList<C1195b> f1221a = new ArrayList<>();

    /* renamed from: b */
    private C1195b f1222b = null;

    /* renamed from: c */
    ValueAnimator f1223c = null;

    /* renamed from: d */
    private final Animator.AnimatorListener f1224d = new C1194a();

    /* renamed from: com.google.android.material.internal.c$a */
    class C1194a extends AnimatorListenerAdapter {
        C1194a() {
        }

        public void onAnimationEnd(Animator animator) {
            C1193c cVar = C1193c.this;
            if (cVar.f1223c == animator) {
                cVar.f1223c = null;
            }
        }
    }

    /* renamed from: com.google.android.material.internal.c$b */
    static class C1195b {

        /* renamed from: a */
        final int[] f1226a;

        /* renamed from: b */
        final ValueAnimator f1227b;

        C1195b(int[] iArr, ValueAnimator valueAnimator) {
            this.f1226a = iArr;
            this.f1227b = valueAnimator;
        }
    }

    /* renamed from: a */
    public void mo25476a() {
        ValueAnimator valueAnimator = this.f1223c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f1223c = null;
        }
    }

    /* renamed from: a */
    public void mo25477a(int[] iArr) {
        C1195b bVar;
        ValueAnimator valueAnimator;
        int size = this.f1221a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = this.f1221a.get(i);
            if (StateSet.stateSetMatches(bVar.f1226a, iArr)) {
                break;
            }
            i++;
        }
        C1195b bVar2 = this.f1222b;
        if (bVar != bVar2) {
            if (!(bVar2 == null || (valueAnimator = this.f1223c) == null)) {
                valueAnimator.cancel();
                this.f1223c = null;
            }
            this.f1222b = bVar;
            if (bVar != null) {
                ValueAnimator valueAnimator2 = bVar.f1227b;
                this.f1223c = valueAnimator2;
                valueAnimator2.start();
            }
        }
    }

    /* renamed from: a */
    public void mo25478a(int[] iArr, ValueAnimator valueAnimator) {
        C1195b bVar = new C1195b(iArr, valueAnimator);
        valueAnimator.addListener(this.f1224d);
        this.f1221a.add(bVar);
    }
}
