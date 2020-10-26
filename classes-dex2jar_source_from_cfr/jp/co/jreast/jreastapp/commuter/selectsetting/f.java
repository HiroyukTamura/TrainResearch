/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.selectsetting;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;

public final class f
implements c<d> {
    private final javax.a.a<s> a;
    private final javax.a.a<p> b;
    private final javax.a.a<a> c;

    public f(javax.a.a<s> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static d a(javax.a.a<s> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        return new d(a2.b(), a3.b(), a4.b());
    }

    public static f b(javax.a.a<s> a2, javax.a.a<p> a3, javax.a.a<a> a4) {
        return new f(a2, a3, a4);
    }

    public d a() {
        return f.a(this.a, this.b, this.c);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

