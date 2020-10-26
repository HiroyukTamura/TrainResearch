/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.e;
import kotlin.reflect.jvm.internal.impl.c.b.m;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.y;

public final class f
implements g {
    private final m a;
    private final e b;

    public f(m m2, e e2) {
        j.b(m2, "kotlinClassFinder");
        j.b(e2, "deserializedDescriptorResolver");
        this.a = m2;
        this.b = e2;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.f a(a a2) {
        j.b(a2, "classId");
        n n2 = this.a.a(a2);
        if (n2 != null) {
            boolean bl2 = j.a((Object)n2.b(), (Object)a2);
            if (y.a && !bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Class with incorrect id found: expected ");
                stringBuilder.append(a2);
                stringBuilder.append(", actual ");
                stringBuilder.append(n2.b());
                throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
            }
            return this.b.b(n2);
        }
        return null;
    }
}

