/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.f;

public final class p
implements c<f> {
    private final a a;

    public p(a a2) {
        this.a = a2;
    }

    public static f a(a a2) {
        return p.c(a2);
    }

    public static p b(a a2) {
        return new p(a2);
    }

    public static f c(a a2) {
        return a.b.f.a(a2.s(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public f a() {
        return p.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

