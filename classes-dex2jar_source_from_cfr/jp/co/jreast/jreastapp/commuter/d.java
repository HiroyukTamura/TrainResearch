/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.g;

public final class d
implements c<g> {
    private final a a;

    public d(a a2) {
        this.a = a2;
    }

    public static g a(a a2) {
        return d.c(a2);
    }

    public static d b(a a2) {
        return new d(a2);
    }

    public static g c(a a2) {
        return f.a(a2.h(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public g a() {
        return d.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

