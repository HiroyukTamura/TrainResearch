/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.r;

public final class ac
implements c<r> {
    private final a a;

    public ac(a a2) {
        this.a = a2;
    }

    public static r a(a a2) {
        return ac.c(a2);
    }

    public static ac b(a a2) {
        return new ac(a2);
    }

    public static r c(a a2) {
        return f.a(a2.n(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public r a() {
        return ac.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

