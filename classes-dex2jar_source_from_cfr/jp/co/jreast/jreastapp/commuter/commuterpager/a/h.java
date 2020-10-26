/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.a;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.l;
import jp.co.jreast.jreastapp.commuter.m.p;

public final class h
implements c<g> {
    private final javax.a.a<b> a;
    private final javax.a.a<l> b;
    private final javax.a.a<p> c;
    private final javax.a.a<a> d;

    public h(javax.a.a<b> a2, javax.a.a<l> a3, javax.a.a<p> a4, javax.a.a<a> a5) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
    }

    public static g a(javax.a.a<b> a2, javax.a.a<l> a3, javax.a.a<p> a4, javax.a.a<a> a5) {
        return new g(a2.b(), a3.b(), a4.b(), a5.b());
    }

    public static h b(javax.a.a<b> a2, javax.a.a<l> a3, javax.a.a<p> a4, javax.a.a<a> a5) {
        return new h(a2, a3, a4, a5);
    }

    public g a() {
        return h.a(this.a, this.b, this.c, this.d);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

