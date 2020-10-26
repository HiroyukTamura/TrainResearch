/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.d;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.c.a.a.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.aa;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class a {
    private final kotlin.reflect.jvm.internal.impl.c.a.c.g a;
    private final g b;

    public a(kotlin.reflect.jvm.internal.impl.c.a.c.g g2, g g3) {
        j.b(g2, "packageFragmentProvider");
        j.b(g3, "javaResolverCache");
        this.a = g2;
        this.b = g3;
    }

    public final e a(kotlin.reflect.jvm.internal.impl.c.a.e.g object) {
        j.b(object, "javaClass");
        Object object2 = object.c();
        if (object2 != null && object.j() == aa.a) {
            return this.b.a((b)object2);
        }
        Object object3 = object.f();
        Object object4 = null;
        if (object3 != null) {
            object4 = this.a((kotlin.reflect.jvm.internal.impl.c.a.e.g)object3);
            object4 = object4 != null ? object4.C() : null;
            object = object4 != null ? object4.c(object.r(), d.s) : null;
            object4 = object;
            if (!(object instanceof e)) {
                object4 = null;
            }
            return (e)object4;
        }
        if (object2 == null) {
            return null;
        }
        object3 = this.a;
        object2 = ((b)object2).d();
        j.a(object2, "fqName.parent()");
        object2 = m.g(((kotlin.reflect.jvm.internal.impl.c.a.c.g)object3).a((b)object2));
        if (object2 != null) {
            object4 = ((kotlin.reflect.jvm.internal.impl.c.a.c.a.h)object2).a((kotlin.reflect.jvm.internal.impl.c.a.e.g)object);
        }
        return object4;
    }

    public final kotlin.reflect.jvm.internal.impl.c.a.c.g a() {
        return this.a;
    }
}

