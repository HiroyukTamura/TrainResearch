/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.util.Set;
import kotlin.a.al;
import kotlin.reflect.jvm.internal.impl.e.b;

public final class j {
    public static final j a = new j();
    private static final Set<b> b = al.a(new b("kotlin.internal.NoInfer"), new b("kotlin.internal.Exact"));

    private j() {
    }

    public final Set<b> a() {
        return b;
    }
}

