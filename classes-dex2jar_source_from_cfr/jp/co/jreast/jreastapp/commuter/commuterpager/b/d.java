/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.b;

import jp.co.jreast.jreastapp.commuter.commuterpager.b.c;
import jp.co.jreast.jreastapp.commuter.m.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;

public final class d
implements a.b.c<c> {
    private final javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a;
    private final javax.a.a<p> b;
    private final javax.a.a<s> c;
    private final javax.a.a<a> d;
    private final javax.a.a<jp.co.jreast.jreastapp.commuter.l.a> e;

    public d(javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a2, javax.a.a<p> a3, javax.a.a<s> a4, javax.a.a<a> a5, javax.a.a<jp.co.jreast.jreastapp.commuter.l.a> a6) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
    }

    public static c a(javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a2, javax.a.a<p> a3, javax.a.a<s> a4, javax.a.a<a> a5, javax.a.a<jp.co.jreast.jreastapp.commuter.l.a> a6) {
        return new c(a2.b(), a3.b(), a4.b(), a5.b(), a6.b());
    }

    public static d b(javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a2, javax.a.a<p> a3, javax.a.a<s> a4, javax.a.a<a> a5, javax.a.a<jp.co.jreast.jreastapp.commuter.l.a> a6) {
        return new d(a2, a3, a4, a5, a6);
    }

    public c a() {
        return d.a(this.a, this.b, this.c, this.d, this.e);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

