/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.e;

public final class o
implements c<e> {
    private final a a;

    public o(a a2) {
        this.a = a2;
    }

    public static e a(a a2) {
        return o.c(a2);
    }

    public static o b(a a2) {
        return new o(a2);
    }

    public static e c(a a2) {
        return f.a(a2.q(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public e a() {
        return o.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

