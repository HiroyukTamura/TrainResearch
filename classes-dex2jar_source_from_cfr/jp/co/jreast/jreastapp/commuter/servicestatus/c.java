/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.servicestatus;

import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.servicestatus.b;

public final class c
implements a.b.c<b> {
    private final javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a;
    private final javax.a.a<p> b;
    private final javax.a.a<a> c;

    public c(javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static b a(javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        return new b(a2.b(), a3.b(), a4.b());
    }

    public static c b(javax.a.a<jp.co.jreast.jreastapp.commuter.m.b> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        return new c(a2, a3, a4);
    }

    public b a() {
        return c.a(this.a, this.b, this.c);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

