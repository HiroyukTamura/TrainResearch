/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import jp.co.jreast.jreastapp.commuter.l.a;

public final class g
implements c<a> {
    private final jp.co.jreast.jreastapp.commuter.a a;

    public g(jp.co.jreast.jreastapp.commuter.a a2) {
        this.a = a2;
    }

    public static a a(jp.co.jreast.jreastapp.commuter.a a2) {
        return g.c(a2);
    }

    public static g b(jp.co.jreast.jreastapp.commuter.a a2) {
        return new g(a2);
    }

    public static a c(jp.co.jreast.jreastapp.commuter.a a2) {
        return a2.z();
    }

    public a a() {
        return g.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

