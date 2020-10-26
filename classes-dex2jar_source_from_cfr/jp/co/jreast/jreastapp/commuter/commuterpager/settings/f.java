/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.e;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.j;
import jp.co.jreast.jreastapp.commuter.m.s;

public final class f
implements c<e> {
    private final javax.a.a<j> a;
    private final javax.a.a<a> b;
    private final javax.a.a<s> c;

    public f(javax.a.a<j> a2, javax.a.a<a> a3, javax.a.a<s> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static e a(javax.a.a<j> a2, javax.a.a<a> a3, javax.a.a<s> a4) {
        return new e(a2.b(), a3.b(), a4.b());
    }

    public static f b(javax.a.a<j> a2, javax.a.a<a> a3, javax.a.a<s> a4) {
        return new f(a2, a3, a4);
    }

    public e a() {
        return f.a(this.a, this.b, this.c);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

