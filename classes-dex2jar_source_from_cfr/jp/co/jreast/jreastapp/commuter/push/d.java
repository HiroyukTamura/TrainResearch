/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.push;

import javax.a.a;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.push.c;

public final class d
implements a.b.c<c> {
    private final a<r> a;
    private final a<p> b;

    public d(a<r> a2, a<p> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static c a(a<r> a2, a<p> a3) {
        return new c(a2.b(), a3.b());
    }

    public static d b(a<r> a2, a<p> a3) {
        return new d(a2, a3);
    }

    public c a() {
        return d.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

