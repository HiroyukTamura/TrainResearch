/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.Map;
import java.util.Set;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.c.a.b.i;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.h;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.h.d.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.g;

public final class o
implements an {
    private final h b;

    public o(h h2) {
        j.b(h2, "packageFragment");
        this.b = h2;
    }

    @Override
    public ao a() {
        ao ao2 = ao.a;
        j.a((Object)ao2, "SourceFile.NO_SOURCE_FILE");
        return ao2;
    }

    public final n a(g object) {
        j.b(object, "descriptor");
        object = i.a((g)object);
        if (object != null) {
            return this.b.c().get(((b)object).c());
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(": ");
        stringBuilder.append(this.b.c().keySet());
        return stringBuilder.toString();
    }
}

