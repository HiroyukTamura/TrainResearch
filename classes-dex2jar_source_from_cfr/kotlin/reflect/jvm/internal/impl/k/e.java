/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.h.c.a;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.k.b;

final class e
implements b {
    public static final e a = new e();
    private static final String b = "second parameter must be of type KProperty<*> or its supertype";

    static {
        b = b;
    }

    private e() {
    }

    @Override
    public String a() {
        return b;
    }

    @Override
    public boolean a(t object) {
        j.b(object, "functionDescriptor");
        kotlin.reflect.jvm.internal.impl.a.a.a a2 = object.i().get(1);
        object = ReflectionTypes.Companion;
        j.a((Object)a2, "secondParameter");
        object = ((ReflectionTypes.Companion)object).createKPropertyStarType(a.c(a2));
        if (object != null) {
            a2 = a2.r();
            j.a((Object)a2, "secondParameter.type");
            a2 = kotlin.reflect.jvm.internal.impl.j.c.a.c((w)a2);
            j.a((Object)a2, "secondParameter.type.makeNotNullable()");
            return kotlin.reflect.jvm.internal.impl.j.c.a.a((w)object, (w)a2);
        }
        return false;
    }

    @Override
    public String b(t t2) {
        j.b(t2, "functionDescriptor");
        return b.a.a(this, t2);
    }
}

