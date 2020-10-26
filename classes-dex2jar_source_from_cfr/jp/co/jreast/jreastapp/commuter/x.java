/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.common.q;

public final class x
implements c<q> {
    private final a a;

    public x(a a2) {
        this.a = a2;
    }

    public static q a(a a2) {
        return x.c(a2);
    }

    public static x b(a a2) {
        return new x(a2);
    }

    public static q c(a a2) {
        return f.a(a2.J(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public q a() {
        return x.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

