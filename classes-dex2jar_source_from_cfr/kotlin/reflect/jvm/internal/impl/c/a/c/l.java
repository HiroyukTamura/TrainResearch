/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.c.j;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.h.d.a;

public final class l
implements j {
    public a a;

    @Override
    public e a(g g2) {
        kotlin.e.b.j.b(g2, "javaClass");
        a a2 = this.a;
        if (a2 == null) {
            kotlin.e.b.j.b("resolver");
        }
        return a2.a(g2);
    }

    public final void a(a a2) {
        kotlin.e.b.j.b(a2, "<set-?>");
        this.a = a2;
    }
}

