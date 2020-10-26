/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.main;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.main.s;

public final class t
implements c<s> {
    private final javax.a.a<a> a;

    public t(javax.a.a<a> a2) {
        this.a = a2;
    }

    public static s a(javax.a.a<a> a2) {
        return new s(a2.b());
    }

    public static t b(javax.a.a<a> a2) {
        return new t(a2);
    }

    public s a() {
        return t.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

