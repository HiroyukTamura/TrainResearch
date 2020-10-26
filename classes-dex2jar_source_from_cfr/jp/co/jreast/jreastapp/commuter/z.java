/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.q.b;

public final class z
implements c<b> {
    private final a a;

    public z(a a2) {
        this.a = a2;
    }

    public static b a(a a2) {
        return z.c(a2);
    }

    public static z b(a a2) {
        return new z(a2);
    }

    public static b c(a a2) {
        return f.a(a2.u(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public b a() {
        return z.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

