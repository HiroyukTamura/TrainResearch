/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.i;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.i.f;
import kotlin.reflect.jvm.internal.impl.i.g;
import kotlin.reflect.l;

public final class h {
    public static final <T> T a(f<? extends T> f2, Object object, l<?> l2) {
        j.b(f2, "$receiver");
        j.b(l2, "p");
        return (T)f2.a();
    }

    public static final <T> T a(g<? extends T> g2, Object object, l<?> l2) {
        j.b(g2, "$receiver");
        j.b(l2, "p");
        return (T)g2.a();
    }
}

