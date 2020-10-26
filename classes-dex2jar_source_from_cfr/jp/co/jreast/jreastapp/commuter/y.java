/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;

public final class y
implements c<jp.co.jreast.jreastapp.commuter.i.a> {
    private final a a;

    public y(a a2) {
        this.a = a2;
    }

    public static jp.co.jreast.jreastapp.commuter.i.a a(a a2) {
        return y.c(a2);
    }

    public static y b(a a2) {
        return new y(a2);
    }

    public static jp.co.jreast.jreastapp.commuter.i.a c(a a2) {
        return f.a(a2.I(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public jp.co.jreast.jreastapp.commuter.i.a a() {
        return y.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

