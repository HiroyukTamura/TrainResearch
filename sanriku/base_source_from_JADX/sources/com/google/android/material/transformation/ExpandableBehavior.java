package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;
import p009e.p028d.p030b.p054b.p057e.C1553b;

public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f1329a = 0;

    /* renamed from: com.google.android.material.transformation.ExpandableBehavior$a */
    class C1219a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        final /* synthetic */ View f1330a;

        /* renamed from: b */
        final /* synthetic */ int f1331b;

        /* renamed from: c */
        final /* synthetic */ C1553b f1332c;

        C1219a(View view, int i, C1553b bVar) {
            this.f1330a = view;
            this.f1331b = i;
            this.f1332c = bVar;
        }

        public boolean onPreDraw() {
            this.f1330a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f1329a == this.f1331b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                C1553b bVar = this.f1332c;
                expandableBehavior.mo25563a((View) bVar, this.f1330a, bVar.mo25406a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private boolean m1883a(boolean z) {
        if (!z) {
            return this.f1329a == 1;
        }
        int i = this.f1329a;
        return i == 0 || i == 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo25563a(View view, View view2, boolean z, boolean z2);

    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        C1553b bVar = (C1553b) view2;
        if (!m1883a(bVar.mo25406a())) {
            return false;
        }
        this.f1329a = bVar.mo25406a() ? 1 : 2;
        return mo25563a((View) bVar, view, bVar.mo25406a(), true);
    }

    @CallSuper
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        C1553b bVar;
        if (!ViewCompat.isLaidOut(view)) {
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    bVar = null;
                    break;
                }
                View view2 = dependencies.get(i2);
                if (layoutDependsOn(coordinatorLayout, view, view2)) {
                    bVar = (C1553b) view2;
                    break;
                }
                i2++;
            }
            if (bVar != null && m1883a(bVar.mo25406a())) {
                int i3 = bVar.mo25406a() ? 1 : 2;
                this.f1329a = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new C1219a(view, i3, bVar));
            }
        }
        return false;
    }
}
