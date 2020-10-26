/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import javax.a.a;
import jp.co.jreast.jreastapp.commuter.candidatestation.c;
import jp.co.jreast.jreastapp.commuter.candidatestation.e;
import jp.co.jreast.jreastapp.commuter.m.t;

public final class d
implements a.b.c<c> {
    private final a<e> a;
    private final a<t> b;

    public d(a<e> a2, a<t> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static c a(a<e> a2, a<t> a3) {
        return new c(a2.b(), a3.b());
    }

    public static d b(a<e> a2, a<t> a3) {
        return new d(a2, a3);
    }

    public c a() {
        return d.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

