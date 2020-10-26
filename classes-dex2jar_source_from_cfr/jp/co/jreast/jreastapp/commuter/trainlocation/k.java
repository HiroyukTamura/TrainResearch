/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.trainlocation.j;

public final class k
implements c<j> {
    private final a<u> a;
    private final a<b> b;

    public k(a<u> a2, a<b> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static j a(a<u> a2, a<b> a3) {
        return new j(a2.b(), a3.b());
    }

    public static k b(a<u> a2, a<b> a3) {
        return new k(a2, a3);
    }

    public j a() {
        return k.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

