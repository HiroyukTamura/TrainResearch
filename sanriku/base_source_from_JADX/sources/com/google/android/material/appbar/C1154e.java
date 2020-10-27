package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.google.android.material.appbar.e */
class C1154e {

    /* renamed from: a */
    private final View f1042a;

    /* renamed from: b */
    private int f1043b;

    /* renamed from: c */
    private int f1044c;

    /* renamed from: d */
    private int f1045d;

    /* renamed from: e */
    private int f1046e;

    public C1154e(View view) {
        this.f1042a = view;
    }

    /* renamed from: c */
    private void m1712c() {
        View view = this.f1042a;
        ViewCompat.offsetTopAndBottom(view, this.f1045d - (view.getTop() - this.f1043b));
        View view2 = this.f1042a;
        ViewCompat.offsetLeftAndRight(view2, this.f1046e - (view2.getLeft() - this.f1044c));
    }

    /* renamed from: a */
    public int mo25347a() {
        return this.f1045d;
    }

    /* renamed from: a */
    public boolean mo25348a(int i) {
        if (this.f1046e == i) {
            return false;
        }
        this.f1046e = i;
        m1712c();
        return true;
    }

    /* renamed from: b */
    public void mo25349b() {
        this.f1043b = this.f1042a.getTop();
        this.f1044c = this.f1042a.getLeft();
        m1712c();
    }

    /* renamed from: b */
    public boolean mo25350b(int i) {
        if (this.f1045d == i) {
            return false;
        }
        this.f1045d = i;
        m1712c();
        return true;
    }
}
