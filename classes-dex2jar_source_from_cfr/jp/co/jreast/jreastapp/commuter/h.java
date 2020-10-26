/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;

public final class h
implements c<jp.co.jreast.jreastapp.commuter.e.a> {
    private final a a;

    public h(a a2) {
        this.a = a2;
    }

    public static jp.co.jreast.jreastapp.commuter.e.a a(a a2) {
        return h.c(a2);
    }

    public static h b(a a2) {
        return new h(a2);
    }

    public static jp.co.jreast.jreastapp.commuter.e.a c(a a2) {
        return f.a(a2.F(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public jp.co.jreast.jreastapp.commuter.e.a a() {
        return h.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

