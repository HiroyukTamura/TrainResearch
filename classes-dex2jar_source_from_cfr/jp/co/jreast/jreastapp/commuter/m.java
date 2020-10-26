/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.d;

public final class m
implements c<d> {
    private final a a;

    public m(a a2) {
        this.a = a2;
    }

    public static d a(a a2) {
        return m.c(a2);
    }

    public static m b(a a2) {
        return new m(a2);
    }

    public static d c(a a2) {
        return f.a(a2.r(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public d a() {
        return m.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

