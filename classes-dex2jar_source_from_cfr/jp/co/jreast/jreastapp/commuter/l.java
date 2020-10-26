/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.c;

public final class l
implements a.b.c<c> {
    private final a a;

    public l(a a2) {
        this.a = a2;
    }

    public static c a(a a2) {
        return l.c(a2);
    }

    public static l b(a a2) {
        return new l(a2);
    }

    public static c c(a a2) {
        return f.a(a2.L(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public c a() {
        return l.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

