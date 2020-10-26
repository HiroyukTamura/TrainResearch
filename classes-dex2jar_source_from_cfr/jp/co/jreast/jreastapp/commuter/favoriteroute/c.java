/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.favoriteroute;

import javax.a.a;
import jp.co.jreast.jreastapp.commuter.favoriteroute.b;
import jp.co.jreast.jreastapp.commuter.m.q;

public final class c
implements a.b.c<b> {
    private final a<q> a;

    public c(a<q> a2) {
        this.a = a2;
    }

    public static b a(a<q> a2) {
        return new b(a2.b());
    }

    public static c b(a<q> a2) {
        return new c(a2);
    }

    public b a() {
        return c.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

