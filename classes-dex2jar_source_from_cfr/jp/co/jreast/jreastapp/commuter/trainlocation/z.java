/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.common.q;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;

public final class z
implements c<y> {
    private final javax.a.a<u> a;
    private final javax.a.a<s> b;
    private final javax.a.a<q> c;
    private final javax.a.a<a> d;
    private final javax.a.a<f> e;
    private final javax.a.a<p> f;

    public z(javax.a.a<u> a2, javax.a.a<s> a3, javax.a.a<q> a4, javax.a.a<a> a5, javax.a.a<f> a6, javax.a.a<p> a7) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
        this.f = a7;
    }

    public static y a(javax.a.a<u> a2, javax.a.a<s> a3, javax.a.a<q> a4, javax.a.a<a> a5, javax.a.a<f> a6, javax.a.a<p> a7) {
        return new y(a2.b(), a3.b(), a4.b(), a5.b(), a6.b(), a7.b());
    }

    public static z b(javax.a.a<u> a2, javax.a.a<s> a3, javax.a.a<q> a4, javax.a.a<a> a5, javax.a.a<f> a6, javax.a.a<p> a7) {
        return new z(a2, a3, a4, a5, a6, a7);
    }

    public y a() {
        return z.a(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

