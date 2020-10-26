/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import java.util.EnumMap;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.a;
import kotlin.reflect.jvm.internal.impl.c.a.f.e;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;
import kotlin.reflect.jvm.internal.impl.c.a.f.h;

public final class d {
    private final EnumMap<a.a, h> a;

    public d(EnumMap<a.a, h> enumMap) {
        j.b(enumMap, "nullabilityQualifiers");
        this.a = enumMap;
    }

    public final EnumMap<a.a, h> a() {
        return this.a;
    }

    public final kotlin.reflect.jvm.internal.impl.c.a.f.d a(a.a object) {
        if ((object = this.a.get(object)) != null) {
            return new kotlin.reflect.jvm.internal.impl.c.a.f.d(((h)object).a(), null, false, ((h)object).b());
        }
        return null;
    }
}

