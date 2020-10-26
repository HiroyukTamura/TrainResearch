/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.h.a.a.a;
import kotlin.reflect.jvm.internal.impl.j.a.e;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.g;
import kotlin.reflect.jvm.internal.impl.j.v;
import kotlin.reflect.jvm.internal.impl.j.y;

public final class j {
    public static final boolean a(ad ad2) {
        kotlin.e.b.j.b(ad2, "$receiver");
        return ad2.g().d() instanceof kotlin.reflect.jvm.internal.impl.a.e;
    }

    public static final boolean b(ad ad2) {
        kotlin.e.b.j.b(ad2, "$receiver");
        return !y.a(ad2) && !(ad2.g().d() instanceof ar) && (ad2.g().d() != null || ad2 instanceof a || ad2 instanceof e || ad2 instanceof g);
    }

    public static final boolean c(ad ad2) {
        kotlin.e.b.j.b(ad2, "$receiver");
        return ad2.g() instanceof v;
    }
}

