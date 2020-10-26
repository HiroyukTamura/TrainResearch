/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.m.a;

public final class b
implements c<a> {
    private final jp.co.jreast.jreastapp.commuter.a a;

    public b(jp.co.jreast.jreastapp.commuter.a a2) {
        this.a = a2;
    }

    public static a a(jp.co.jreast.jreastapp.commuter.a a2) {
        return b.c(a2);
    }

    public static b b(jp.co.jreast.jreastapp.commuter.a a2) {
        return new b(a2);
    }

    public static a c(jp.co.jreast.jreastapp.commuter.a a2) {
        return f.a(a2.C(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public a a() {
        return b.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

