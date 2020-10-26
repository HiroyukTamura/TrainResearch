/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.Collection;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.a;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ap;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.b.a.b;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class e {
    public static final av a(kotlin.reflect.jvm.internal.impl.a.e ap2) {
        j.b(ap2, "$receiver");
        boolean bl2 = ap2.t();
        Object var2_2 = null;
        if (!bl2) {
            return null;
        }
        Object object = ap2.o();
        ap2 = var2_2;
        if (object != null) {
            object = object.i();
            ap2 = var2_2;
            if (object != null) {
                ap2 = (av)kotlin.a.m.k(object);
            }
        }
        return ap2;
    }

    public static final av a(w a2) {
        j.b(a2, "$receiver");
        a2 = a2.g().d();
        boolean bl2 = a2 instanceof kotlin.reflect.jvm.internal.impl.a.e;
        Object var2_2 = null;
        if (!bl2) {
            a2 = null;
        }
        kotlin.reflect.jvm.internal.impl.a.e e2 = (kotlin.reflect.jvm.internal.impl.a.e)a2;
        a2 = var2_2;
        if (e2 != null) {
            a2 = e.a(e2);
        }
        return a2;
    }

    public static final boolean a(m m2) {
        j.b(m2, "$receiver");
        return m2 instanceof kotlin.reflect.jvm.internal.impl.a.e && ((kotlin.reflect.jvm.internal.impl.a.e)m2).t();
    }

    public static final w b(w a2) {
        j.b(a2, "$receiver");
        a2 = e.a((w)a2);
        if (a2 != null) {
            return a2.r();
        }
        return null;
    }

    public static final boolean c(w a2) {
        j.b(a2, "$receiver");
        a2 = a2.g().d();
        if (a2 != null) {
            return e.a((m)a2);
        }
        return false;
    }

    public static final w d(w object) {
        j.b(object, "$receiver");
        av av2 = e.a((w)object);
        f f2 = null;
        Object object2 = f2;
        if (av2 != null) {
            object = ((w)object).b();
            object2 = av2.h_();
            j.a(object2, "parameter.name");
            object = (ai)kotlin.a.m.g((Iterable)object.a((f)object2, d.l));
            object2 = f2;
            if (object != null) {
                object2 = object.r();
            }
        }
        return object2;
    }
}

