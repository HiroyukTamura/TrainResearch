/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.k;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.k.a;
import jp.co.jreast.jreastapp.commuter.m.h;
import jp.co.jreast.jreastapp.commuter.m.q;

public final class b
implements c<a> {
    private final javax.a.a<h> a;
    private final javax.a.a<q> b;
    private final javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> c;

    public b(javax.a.a<h> a2, javax.a.a<q> a3, javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static a a(javax.a.a<h> a2, javax.a.a<q> a3, javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a4) {
        return new a(a2.b(), a3.b(), a4.b());
    }

    public static b b(javax.a.a<h> a2, javax.a.a<q> a3, javax.a.a<jp.co.jreast.jreastapp.commuter.d.a> a4) {
        return new b(a2, a3, a4);
    }

    public a a() {
        return b.a(this.a, this.b, this.c);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

