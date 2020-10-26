/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.u;

public final class af
implements c<u> {
    private final a a;

    public af(a a2) {
        this.a = a2;
    }

    public static u a(a a2) {
        return af.c(a2);
    }

    public static af b(a a2) {
        return new af(a2);
    }

    public static u c(a a2) {
        return f.a(a2.t(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public u a() {
        return af.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

