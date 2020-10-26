/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.a;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.g;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.y;

public final class ag {
    public static final a a(w w2) {
        j.b(w2, "$receiver");
        az az2 = w2.l();
        w2 = az2;
        if (!(az2 instanceof a)) {
            w2 = null;
        }
        return (a)w2;
    }

    public static final ad a(ad ad2) {
        j.b(ad2, "$receiver");
        g g2 = g.a.a(ad2);
        if (g2 != null) {
            return g2;
        }
        return ad2.a(false);
    }

    public static final ad a(ad ad2, ad ad3) {
        j.b(ad2, "$receiver");
        j.b(ad3, "abbreviatedType");
        if (y.a(ad2)) {
            return ad2;
        }
        return new a(ad2, ad3);
    }

    public static final az a(az az2) {
        j.b(az2, "$receiver");
        g g2 = g.a.a(az2);
        if (g2 != null) {
            return g2;
        }
        return az2.b(false);
    }

    public static final ad b(w w2) {
        j.b(w2, "$receiver");
        w2 = ag.a(w2);
        if (w2 != null) {
            return ((a)w2).f();
        }
        return null;
    }

    public static final boolean c(w w2) {
        j.b(w2, "$receiver");
        return w2.l() instanceof g;
    }
}

