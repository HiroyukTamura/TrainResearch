/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.m.s;

public final class ad
implements c<s> {
    private final a a;

    public ad(a a2) {
        this.a = a2;
    }

    public static s a(a a2) {
        return ad.c(a2);
    }

    public static ad b(a a2) {
        return new ad(a2);
    }

    public static s c(a a2) {
        return f.a(a2.p(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public s a() {
        return ad.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

