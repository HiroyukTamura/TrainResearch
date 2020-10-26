/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.candidatestation.e;

public final class c
implements a.b.c<e> {
    private final a a;

    public c(a a2) {
        this.a = a2;
    }

    public static e a(a a2) {
        return c.c(a2);
    }

    public static c b(a a2) {
        return new c(a2);
    }

    public static e c(a a2) {
        return f.a(a2.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public e a() {
        return c.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

