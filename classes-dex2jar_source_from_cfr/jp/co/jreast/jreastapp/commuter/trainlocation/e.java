/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.trainlocation.d;

public final class e
implements c<d> {
    private final a<f> a;
    private final a<u> b;

    public e(a<f> a2, a<u> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static d a(a<f> a2, a<u> a3) {
        return new d(a2.b(), a3.b());
    }

    public static e b(a<f> a2, a<u> a3) {
        return new e(a2, a3);
    }

    public d a() {
        return e.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

