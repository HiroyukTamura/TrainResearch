/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.t;

public final class ae
implements c<t> {
    private final a a;

    public ae(a a2) {
        this.a = a2;
    }

    public static t a(a a2) {
        return ae.c(a2);
    }

    public static ae b(a a2) {
        return new ae(a2);
    }

    public static t c(a a2) {
        return f.a(a2.m(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public t a() {
        return ae.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

