/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.launchscreen;

import jp.co.jreast.jreastapp.commuter.k.a;
import jp.co.jreast.jreastapp.commuter.launchscreen.b;
import jp.co.jreast.jreastapp.commuter.m.n;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.m.t;

public final class c
implements a.b.c<b> {
    private final javax.a.a<r> a;
    private final javax.a.a<n> b;
    private final javax.a.a<s> c;
    private final javax.a.a<t> d;
    private final javax.a.a<a> e;

    public c(javax.a.a<r> a2, javax.a.a<n> a3, javax.a.a<s> a4, javax.a.a<t> a5, javax.a.a<a> a6) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
    }

    public static b a(javax.a.a<r> a2, javax.a.a<n> a3, javax.a.a<s> a4, javax.a.a<t> a5, javax.a.a<a> a6) {
        return new b(a2.b(), a3.b(), a4.b(), a5.b(), a6.b());
    }

    public static c b(javax.a.a<r> a2, javax.a.a<n> a3, javax.a.a<s> a4, javax.a.a<t> a5, javax.a.a<a> a6) {
        return new c(a2, a3, a4, a5, a6);
    }

    public b a() {
        return c.a(this.a, this.b, this.c, this.d, this.e);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

