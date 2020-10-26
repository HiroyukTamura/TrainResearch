/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.q;

public final class ab
implements c<q> {
    private final a a;

    public ab(a a2) {
        this.a = a2;
    }

    public static q a(a a2) {
        return ab.c(a2);
    }

    public static ab b(a a2) {
        return new ab(a2);
    }

    public static q c(a a2) {
        return f.a(a2.l(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public q a() {
        return ab.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

