/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import a.b.c;
import f.n;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.l.d;
import jp.co.jreast.jreastapp.commuter.m.h;

public final class i
implements c<h> {
    private final a<n.a> a;
    private final a<d> b;

    public i(a<n.a> a2, a<d> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static h a(a<n.a> a2, a<d> a3) {
        return new h(a2.b(), a3.b());
    }

    public static i b(a<n.a> a2, a<d> a3) {
        return new i(a2, a3);
    }

    public h a() {
        return i.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

