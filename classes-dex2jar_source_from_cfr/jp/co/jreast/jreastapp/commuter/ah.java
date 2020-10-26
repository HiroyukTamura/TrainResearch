/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import f.n;
import jp.co.jreast.jreastapp.commuter.a;

public final class ah
implements c<n.a> {
    private final a a;

    public ah(a a2) {
        this.a = a2;
    }

    public static n.a a(a a2) {
        return ah.c(a2);
    }

    public static ah b(a a2) {
        return new ah(a2);
    }

    public static n.a c(a a2) {
        return f.a(a2.x(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public n.a a() {
        return ah.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

