/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.b.a;

public final class l {
    public static final boolean a(a a2) {
        j.b(a2, "version");
        return l.b(a2);
    }

    private static final boolean b(a a2) {
        return a2.b() == 1 && a2.c() >= 4;
    }
}

