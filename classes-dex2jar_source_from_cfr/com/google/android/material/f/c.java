/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewParent
 */
package com.google.android.material.f;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class c {
    private final View a;
    private boolean b;
    private int c;

    private void d() {
        ViewParent viewParent = this.a.getParent();
        if (viewParent instanceof CoordinatorLayout) {
            ((CoordinatorLayout)viewParent).b(this.a);
        }
    }

    public void a(int n2) {
        this.c = n2;
    }

    public void a(Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            this.d();
        }
    }

    public boolean a() {
        return this.b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public int c() {
        return this.c;
    }
}

