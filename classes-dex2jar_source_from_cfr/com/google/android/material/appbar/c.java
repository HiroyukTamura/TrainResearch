/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.d;

class c<V extends View>
extends CoordinatorLayout.b<V> {
    private d a;
    private int b = 0;
    private int c = 0;

    public c() {
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int n2) {
        if (this.a != null) {
            return this.a.a(n2);
        }
        this.b = n2;
        return false;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        this.b(coordinatorLayout, v2, n2);
        if (this.a == null) {
            this.a = new d((View)v2);
        }
        this.a.a();
        if (this.b != 0) {
            this.a.a(this.b);
            this.b = 0;
        }
        if (this.c != 0) {
            this.a.b(this.c);
            this.c = 0;
        }
        return true;
    }

    protected void b(CoordinatorLayout coordinatorLayout, V v2, int n2) {
        coordinatorLayout.a((View)v2, n2);
    }

    public int c() {
        if (this.a != null) {
            return this.a.b();
        }
        return 0;
    }
}

