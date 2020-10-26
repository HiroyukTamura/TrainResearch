/*
 * Decompiled with CFR 0.139.
 */
package b.a;

import b.a.e.b.b;
import b.a.e.e.a.d;
import b.a.e.e.a.f;
import b.a.f.a;

public abstract class c<T> {
    static final int a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128));

    public static int a() {
        return a;
    }

    public final c<T> a(int n2, boolean bl2, boolean bl3) {
        b.a(n2, "bufferSize");
        return a.a(new b.a.e.e.a.c(this, n2, bl3, bl2, b.a.e.b.a.c));
    }

    public final c<T> b() {
        return this.a(c.a(), false, true);
    }

    public final c<T> c() {
        return a.a(new d(this));
    }

    public final c<T> d() {
        return a.a(new f(this));
    }
}

