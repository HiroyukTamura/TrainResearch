/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.w;

class k {
    private final w a;
    private final int b;
    private final boolean c;

    public k(w w2, int n2, boolean bl2) {
        j.b(w2, "type");
        this.a = w2;
        this.b = n2;
        this.c = bl2;
    }

    public final w a() {
        w w2 = this.b();
        if (this.c) {
            return w2;
        }
        return null;
    }

    public w b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }
}

