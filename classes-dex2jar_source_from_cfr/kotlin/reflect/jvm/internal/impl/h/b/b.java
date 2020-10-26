/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.a;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class b
extends f<List<? extends f<?>>> {
    private final kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.y, w> a;

    public b(List<? extends f<?>> list, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.a.y, ? extends w> b2) {
        j.b(list, "value");
        j.b(b2, "computeType");
        super(list);
        this.a = b2;
    }

    @Override
    public w a(kotlin.reflect.jvm.internal.impl.a.y a2) {
        j.b(a2, "module");
        a2 = this.a.a((kotlin.reflect.jvm.internal.impl.a.y)a2);
        boolean bl2 = KotlinBuiltIns.isArray((w)a2) || KotlinBuiltIns.isPrimitiveArray((w)a2);
        if (y.a) {
            if (bl2) {
                return a2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Type should be an array, but was ");
            stringBuilder.append(a2);
            stringBuilder.append(": ");
            stringBuilder.append((List)this.a());
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        return a2;
    }
}

