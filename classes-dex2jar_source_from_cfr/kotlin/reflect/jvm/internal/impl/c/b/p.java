/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.r;

public final class p
implements f {
    private final n b;
    private final r<g> c;
    private final boolean d;

    public p(n n2, r<g> r2, boolean bl2) {
        j.b(n2, "binaryClass");
        this.b = n2;
        this.c = r2;
        this.d = bl2;
    }

    @Override
    public ao a() {
        ao ao2 = ao.a;
        j.a((Object)ao2, "SourceFile.NO_SOURCE_FILE");
        return ao2;
    }

    public final n b() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}

