/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class t {
    public static final boolean a(w w2) {
        j.b(w2, "$receiver");
        return w2.l() instanceof q;
    }

    public static final q b(w w2) {
        j.b(w2, "$receiver");
        w2 = w2.l();
        if (w2 != null) {
            return (q)w2;
        }
        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
    }

    public static final ad c(w w2) {
        j.b(w2, "$receiver");
        w2 = w2.l();
        if (w2 instanceof q) {
            return ((q)w2).f();
        }
        if (w2 instanceof ad) {
            return (ad)w2;
        }
        throw new m();
    }

    public static final ad d(w w2) {
        j.b(w2, "$receiver");
        w2 = w2.l();
        if (w2 instanceof q) {
            return ((q)w2).h();
        }
        if (w2 instanceof ad) {
            return (ad)w2;
        }
        throw new m();
    }
}

