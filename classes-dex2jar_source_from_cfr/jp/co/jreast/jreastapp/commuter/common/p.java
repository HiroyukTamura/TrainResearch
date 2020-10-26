/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.common.o;
import jp.co.jreast.jreastapp.commuter.m.e;

public final class p
implements c<o> {
    private final a<e> a;

    public p(a<e> a2) {
        this.a = a2;
    }

    public static o a(a<e> a2) {
        return new o(a2.b());
    }

    public static p b(a<e> a2) {
        return new p(a2);
    }

    public o a() {
        return p.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

