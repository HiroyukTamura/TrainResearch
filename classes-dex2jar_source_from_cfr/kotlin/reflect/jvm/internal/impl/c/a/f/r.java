/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.Map;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.d;

public final class r {
    private final Map<Integer, d> a;

    public r(Map<Integer, d> map) {
        j.b(map, "map");
        this.a = map;
    }

    public final Map<Integer, d> a() {
        return this.a;
    }
}

