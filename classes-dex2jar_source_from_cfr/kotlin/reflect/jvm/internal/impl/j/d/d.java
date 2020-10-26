/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.d;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.w;

final class d {
    private final as a;
    private final w b;
    private final w c;

    public d(as as2, w w2, w w3) {
        j.b(as2, "typeParameter");
        j.b(w2, "inProjection");
        j.b(w3, "outProjection");
        this.a = as2;
        this.b = w2;
        this.c = w3;
    }

    public final boolean a() {
        return c.a.a(this.b, this.c);
    }

    public final as b() {
        return this.a;
    }

    public final w c() {
        return this.b;
    }

    public final w d() {
        return this.c;
    }
}

