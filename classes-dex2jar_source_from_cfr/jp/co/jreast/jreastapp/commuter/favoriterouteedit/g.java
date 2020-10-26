/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import jp.co.jreast.jreastapp.commuter.m.q;

public final class g
implements c<f> {
    private final a<q> a;
    private final a<jp.co.jreast.jreastapp.commuter.e.c> b;

    public g(a<q> a2, a<jp.co.jreast.jreastapp.commuter.e.c> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static f a(a<q> a2, a<jp.co.jreast.jreastapp.commuter.e.c> a3) {
        return new f(a2.b(), a3.b());
    }

    public static g b(a<q> a2, a<jp.co.jreast.jreastapp.commuter.e.c> a3) {
        return new g(a2, a3);
    }

    public f a() {
        return g.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

