/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.m.s;

public final class e
implements c<d> {
    private final a<s> a;
    private final a<q> b;
    private final a<p> c;

    public e(a<s> a2, a<q> a3, a<p> a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static d a(a<s> a2, a<q> a3, a<p> a4) {
        return new d(a2.b(), a3.b(), a4.b());
    }

    public static e b(a<s> a2, a<q> a3, a<p> a4) {
        return new e(a2, a3, a4);
    }

    public d a() {
        return e.a(this.a, this.b, this.c);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

