/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.m;

public final class f
implements c<m> {
    private final a a;

    public f(a a2) {
        this.a = a2;
    }

    public static m a(a a2) {
        return f.c(a2);
    }

    public static f b(a a2) {
        return new f(a2);
    }

    public static m c(a a2) {
        return a.b.f.a(a2.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public m a() {
        return f.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

