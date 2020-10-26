/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.h.t;

class d {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f = true;
    private boolean g = true;

    public d(View view) {
        this.a = view;
    }

    private void c() {
        t.e(this.a, this.d - (this.a.getTop() - this.b));
        t.f(this.a, this.e - (this.a.getLeft() - this.c));
    }

    public void a() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
        this.c();
    }

    public boolean a(int n2) {
        if (this.f && this.d != n2) {
            this.d = n2;
            this.c();
            return true;
        }
        return false;
    }

    public int b() {
        return this.d;
    }

    public boolean b(int n2) {
        if (this.g && this.e != n2) {
            this.e = n2;
            this.c();
            return true;
        }
        return false;
    }
}

