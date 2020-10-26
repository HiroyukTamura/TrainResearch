/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.k.c;
import kotlin.reflect.jvm.internal.impl.k.d;

public abstract class a {
    public abstract List<d> a();

    public final c a(t t2) {
        j.b(t2, "functionDescriptor");
        for (d d2 : this.a()) {
            if (!d2.a(t2)) continue;
            return d2.b(t2);
        }
        return c.a.a;
    }
}

