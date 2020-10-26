/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.k;

public final class e
implements c<k> {
    private final a a;

    public e(a a2) {
        this.a = a2;
    }

    public static k a(a a2) {
        return e.c(a2);
    }

    public static e b(a a2) {
        return new e(a2);
    }

    public static k c(a a2) {
        return f.a(a2.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public k a() {
        return e.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

