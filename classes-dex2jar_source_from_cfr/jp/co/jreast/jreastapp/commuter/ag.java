/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.e.c;

public final class ag
implements a.b.c<c> {
    private final a a;

    public ag(a a2) {
        this.a = a2;
    }

    public static c a(a a2) {
        return ag.c(a2);
    }

    public static ag b(a a2) {
        return new ag(a2);
    }

    public static c c(a a2) {
        return f.a(a2.E(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public c a() {
        return ag.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

