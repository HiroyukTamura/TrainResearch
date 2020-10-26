/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.l.d;

public final class v
implements c<d> {
    private final a a;

    public v(a a2) {
        this.a = a2;
    }

    public static d a(a a2) {
        return v.c(a2);
    }

    public static v b(a a2) {
        return new v(a2);
    }

    public static d c(a a2) {
        return f.a(a2.y(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public d a() {
        return v.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

