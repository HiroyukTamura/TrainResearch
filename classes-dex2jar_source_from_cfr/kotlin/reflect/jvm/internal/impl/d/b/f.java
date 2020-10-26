/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.f.i;

public final class f {
    public static final <M extends i.c<M>, T> T a(i.c<M> c2, i.f<M, T> f2) {
        j.b(c2, "$receiver");
        j.b(f2, "extension");
        if (c2.a(f2)) {
            return c2.c(f2);
        }
        return null;
    }

    public static final <M extends i.c<M>, T> T a(i.c<M> c2, i.f<M, List<T>> f2, int n2) {
        j.b(c2, "$receiver");
        j.b(f2, "extension");
        if (n2 < c2.b(f2)) {
            return c2.a(f2, n2);
        }
        return null;
    }
}

