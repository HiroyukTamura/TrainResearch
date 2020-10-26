/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.acknowledgement;

import javax.a.a;
import jp.co.jreast.jreastapp.commuter.acknowledgement.b;
import jp.co.jreast.jreastapp.commuter.m.g;

public final class c
implements a.b.c<b> {
    private final a<g> a;

    public c(a<g> a2) {
        this.a = a2;
    }

    public static b a(a<g> a2) {
        return new b(a2.b());
    }

    public static c b(a<g> a2) {
        return new c(a2);
    }

    public b a() {
        return c.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

