/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.p;

public final class aa
implements c<p> {
    private final a a;

    public aa(a a2) {
        this.a = a2;
    }

    public static p a(a a2) {
        return aa.c(a2);
    }

    public static aa b(a a2) {
        return new aa(a2);
    }

    public static p c(a a2) {
        return f.a(a2.j(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public p a() {
        return aa.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

