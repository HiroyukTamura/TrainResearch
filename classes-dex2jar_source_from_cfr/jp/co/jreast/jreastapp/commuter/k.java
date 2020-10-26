/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.b;

public final class k
implements c<b> {
    private final a a;

    public k(a a2) {
        this.a = a2;
    }

    public static b a(a a2) {
        return k.c(a2);
    }

    public static k b(a a2) {
        return new k(a2);
    }

    public static b c(a a2) {
        return f.a(a2.k(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public b a() {
        return k.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

