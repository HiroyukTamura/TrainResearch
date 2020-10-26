/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.common.l;

public final class u
implements c<l> {
    private final a a;

    public u(a a2) {
        this.a = a2;
    }

    public static l a(a a2) {
        return u.c(a2);
    }

    public static u b(a a2) {
        return new u(a2);
    }

    public static l c(a a2) {
        return f.a(a2.O(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public l a() {
        return u.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

