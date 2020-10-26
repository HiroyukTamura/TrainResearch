/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.j;

public final class q
implements c<j> {
    private final a a;

    public q(a a2) {
        this.a = a2;
    }

    public static j a(a a2) {
        return q.c(a2);
    }

    public static q b(a a2) {
        return new q(a2);
    }

    public static j c(a a2) {
        return f.a(a2.i(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public j a() {
        return q.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

