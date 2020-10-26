/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.q;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.e;
import jp.co.jreast.jreastapp.commuter.m.l;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.q.b;
import jp.co.jreast.jreastapp.commuter.q.h;

public final class i
implements c<h> {
    private final javax.a.a<l> a;
    private final javax.a.a<b> b;
    private final javax.a.a<p> c;
    private final javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> d;
    private final javax.a.a<e> e;
    private final javax.a.a<s> f;
    private final javax.a.a<a> g;

    public i(javax.a.a<l> a2, javax.a.a<b> a3, javax.a.a<p> a4, javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a5, javax.a.a<e> a6, javax.a.a<s> a7, javax.a.a<a> a8) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
        this.f = a7;
        this.g = a8;
    }

    public static h a(javax.a.a<l> a2, javax.a.a<b> a3, javax.a.a<p> a4, javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a5, javax.a.a<e> a6, javax.a.a<s> a7, javax.a.a<a> a8) {
        return new h(a2.b(), a3.b(), a4.b(), a5.b(), a6.b(), a7.b(), a8.b());
    }

    public static i b(javax.a.a<l> a2, javax.a.a<b> a3, javax.a.a<p> a4, javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a5, javax.a.a<e> a6, javax.a.a<s> a7, javax.a.a<a> a8) {
        return new i(a2, a3, a4, a5, a6, a7, a8);
    }

    public h a() {
        return i.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

