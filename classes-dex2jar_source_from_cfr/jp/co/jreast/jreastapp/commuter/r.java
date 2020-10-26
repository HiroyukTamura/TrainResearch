/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.l;

public final class r
implements c<l> {
    private final a a;

    public r(a a2) {
        this.a = a2;
    }

    public static l a(a a2) {
        return r.c(a2);
    }

    public static r b(a a2) {
        return new r(a2);
    }

    public static l c(a a2) {
        return f.a(a2.g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public l a() {
        return r.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

