package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: com.google.android.material.appbar.d */
class C1153d<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    private C1154e f1039a;

    /* renamed from: b */
    private int f1040b = 0;

    /* renamed from: c */
    private int f1041c = 0;

    public C1153d() {
    }

    public C1153d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public int mo25345a() {
        C1154e eVar = this.f1039a;
        if (eVar != null) {
            return eVar.mo25347a();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo25341a(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    /* renamed from: a */
    public boolean mo25346a(int i) {
        C1154e eVar = this.f1039a;
        if (eVar != null) {
            return eVar.mo25350b(i);
        }
        this.f1040b = i;
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo25341a(coordinatorLayout, v, i);
        if (this.f1039a == null) {
            this.f1039a = new C1154e(v);
        }
        this.f1039a.mo25349b();
        int i2 = this.f1040b;
        if (i2 != 0) {
            this.f1039a.mo25350b(i2);
            this.f1040b = 0;
        }
        int i3 = this.f1041c;
        if (i3 == 0) {
            return true;
        }
        this.f1039a.mo25348a(i3);
        this.f1041c = 0;
        return true;
    }
}
