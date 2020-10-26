/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.a.l;

public final class j {
    public static final h a(h h2, h h3) {
        kotlin.e.b.j.b(h2, "first");
        kotlin.e.b.j.b(h3, "second");
        if (h2.a()) {
            return h3;
        }
        if (h3.a()) {
            return h2;
        }
        return new l(h2, h3);
    }
}

