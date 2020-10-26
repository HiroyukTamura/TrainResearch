/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.j;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;

public final class k
implements c<j> {
    private final javax.a.a<s> a;
    private final javax.a.a<p> b;
    private final javax.a.a<a> c;

    public k(javax.a.a<s> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static j a(javax.a.a<s> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        return new j(a2.b(), a3.b(), a4.b());
    }

    public static k b(javax.a.a<s> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        return new k(a2, a3, a4);
    }

    public j a() {
        return k.a(this.a, this.b, this.c);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

