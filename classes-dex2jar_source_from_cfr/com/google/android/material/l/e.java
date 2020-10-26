/*
 * Decompiled with CFR 0.139.
 */
package com.google.android.material.l;

import com.google.android.material.l.a;
import com.google.android.material.l.b;
import com.google.android.material.l.d;

public class e {
    private static final a a = new d(0.0f);
    private static final b b = new b();
    private a c;
    private a d;
    private a e;
    private a f;
    private b g;
    private b h;
    private b i;
    private b j;

    public a a() {
        return this.c;
    }

    public a b() {
        return this.d;
    }

    public a c() {
        return this.e;
    }

    public a d() {
        return this.f;
    }

    public b e() {
        return this.g;
    }

    public b f() {
        return this.h;
    }

    public b g() {
        return this.i;
    }

    public b h() {
        return this.j;
    }

    boolean i() {
        boolean bl2 = this.j == b && this.h == b && this.g == b && this.i == b;
        float f2 = this.c.a();
        boolean bl3 = this.d.a() == f2 && this.f.a() == f2 && this.e.a() == f2;
        boolean bl4 = this.d instanceof d && this.c instanceof d && this.e instanceof d && this.f instanceof d;
        return bl2 && bl3 && bl4;
    }
}

