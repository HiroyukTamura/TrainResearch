/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;

public final class t
implements c<jp.co.jreast.jreastapp.commuter.skewscroll.a> {
    private final a a;

    public t(a a2) {
        this.a = a2;
    }

    public static jp.co.jreast.jreastapp.commuter.skewscroll.a a(a a2) {
        return t.c(a2);
    }

    public static t b(a a2) {
        return new t(a2);
    }

    public static jp.co.jreast.jreastapp.commuter.skewscroll.a c(a a2) {
        return f.a(a2.e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public jp.co.jreast.jreastapp.commuter.skewscroll.a a() {
        return t.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

