/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.trainlocation.p;

public final class q
implements c<p> {
    private final a<f> a;
    private final a<b> b;

    public q(a<f> a2, a<b> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static p a(a<f> a2, a<b> a3) {
        return new p(a2.b(), a3.b());
    }

    public static q b(a<f> a2, a<b> a3) {
        return new q(a2, a3);
    }

    public p a() {
        return q.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

