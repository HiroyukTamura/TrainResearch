/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.e;

import kotlin.e.b.j;
import kotlin.i.k;

public final class g {
    public static final g a = new g();
    private static final k b = new k("[^\\p{L}\\p{Digit}]");

    private g() {
    }

    public static final String a(String string2) {
        j.b(string2, "name");
        return b.a(string2, "_");
    }
}

