/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.others;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.m.r;
import jp.co.jreast.jreastapp.commuter.others.d;

public final class f
implements c<d> {
    private final a<r> a;

    public f(a<r> a2) {
        this.a = a2;
    }

    public static d a(a<r> a2) {
        return new d(a2.b());
    }

    public static f b(a<r> a2) {
        return new f(a2);
    }

    public d a() {
        return f.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

