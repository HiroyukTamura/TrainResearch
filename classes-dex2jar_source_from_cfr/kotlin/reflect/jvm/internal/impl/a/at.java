/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.ag;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.c;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class at {
    public static final List<as> a(i object) {
        Object object2;
        Object object3;
        List<as> list;
        List list2;
        m m2;
        as as2;
        block8 : {
            block7 : {
                j.b(object, "$receiver");
                list = object.z();
                if (!object.r() && !(object.b() instanceof kotlin.reflect.jvm.internal.impl.a.a)) {
                    j.a(list, "declaredParameters");
                    return list;
                }
                m2 = (m)object;
                list2 = kotlin.h.i.e(kotlin.h.i.d(kotlin.h.i.c(kotlin.reflect.jvm.internal.impl.h.c.a.f(m2), a.a), b.a));
                object2 = kotlin.reflect.jvm.internal.impl.h.c.a.f(m2).a();
                do {
                    boolean bl2 = object2.hasNext();
                    as2 = null;
                    if (!bl2) break block7;
                } while (!((object3 = object2.next()) instanceof e));
                break block8;
            }
            object3 = null;
        }
        object2 = (e)object3;
        object3 = as2;
        if (object2 != null) {
            object2 = object2.e();
            object3 = as2;
            if (object2 != null) {
                object3 = object2.b();
            }
        }
        if (object3 == null) {
            object3 = kotlin.a.m.a();
        }
        if (list2.isEmpty() && object3.isEmpty()) {
            object = object.z();
            j.a(object, "declaredTypeParameters");
            return object;
        }
        object3 = kotlin.a.m.b(list2, (Iterable)object3);
        object = new ArrayList(kotlin.a.m.a(object3, 10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            as2 = (as)object3.next();
            j.a((Object)as2, "it");
            object.add(at.a(as2, m2, list.size()));
        }
        object = (List)object;
        j.a(list, "declaredParameters");
        return kotlin.a.m.b((Collection)list, (Iterable)object);
    }

    public static final ag a(w w2) {
        h h2;
        j.b(w2, "$receiver");
        h h3 = h2 = w2.g().d();
        if (!(h2 instanceof i)) {
            h3 = null;
        }
        return at.a(w2, (i)h3, 0);
    }

    private static final ag a(w w2, i object, int n2) {
        m m2 = null;
        if (object != null) {
            m m3 = (m)object;
            if (p.a(m3)) {
                return null;
            }
            int n3 = object.z().size() + n2;
            if (!object.r()) {
                boolean bl2 = n3 == w2.a().size() || kotlin.reflect.jvm.internal.impl.h.c.b(m3);
                if (y.a && !bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(w2.a().size() - n3);
                    ((StringBuilder)object).append(" trailing arguments were found in ");
                    ((StringBuilder)object).append(w2);
                    ((StringBuilder)object).append(" type");
                    throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
                }
                return new ag((i)object, w2.a().subList(n2, w2.a().size()), null);
            }
            List<ap> list = w2.a().subList(n2, n3);
            m3 = object.b();
            if (m3 instanceof i) {
                m2 = m3;
            }
            return new ag((i)object, list, at.a(w2, (i)m2, n3));
        }
        return null;
    }

    private static final c a(as as2, m m2, int n2) {
        return new c(as2, m2, n2);
    }

}

