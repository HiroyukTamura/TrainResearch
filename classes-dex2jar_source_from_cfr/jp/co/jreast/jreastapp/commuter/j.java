/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;

public final class j
implements c<jp.co.jreast.jreastapp.commuter.d.a> {
    private final a a;

    public j(a a2) {
        this.a = a2;
    }

    public static jp.co.jreast.jreastapp.commuter.d.a a(a a2) {
        return j.c(a2);
    }

    public static j b(a a2) {
        return new j(a2);
    }

    public static jp.co.jreast.jreastapp.commuter.d.a c(a a2) {
        return f.a(a2.A(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public jp.co.jreast.jreastapp.commuter.d.a a() {
        return j.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

