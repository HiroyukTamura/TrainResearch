/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.r.g;

public final class w
implements c<g> {
    private final a a;

    public w(a a2) {
        this.a = a2;
    }

    public static g a(a a2) {
        return w.c(a2);
    }

    public static w b(a a2) {
        return new w(a2);
    }

    public static g c(a a2) {
        return f.a(a2.K(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public g a() {
        return w.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

