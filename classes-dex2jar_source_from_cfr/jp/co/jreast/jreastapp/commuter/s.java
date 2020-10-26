/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.n;

public final class s
implements c<n> {
    private final a a;

    public s(a a2) {
        this.a = a2;
    }

    public static n a(a a2) {
        return s.c(a2);
    }

    public static s b(a a2) {
        return new s(a2);
    }

    public static n c(a a2) {
        return f.a(a2.o(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public n a() {
        return s.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

