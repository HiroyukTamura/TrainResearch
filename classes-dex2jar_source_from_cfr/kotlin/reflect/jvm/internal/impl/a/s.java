/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.h.i;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class s {
    public static final kotlin.reflect.jvm.internal.impl.a.e a(y object, kotlin.reflect.jvm.internal.impl.e.a object22) {
        j.b(object, "$receiver");
        j.b(object22, "classId");
        Iterator iterator = ((kotlin.reflect.jvm.internal.impl.e.a)object22).a();
        j.a((Object)iterator, "classId.packageFqName");
        object = object.a((kotlin.reflect.jvm.internal.impl.e.b)((Object)iterator));
        iterator = ((kotlin.reflect.jvm.internal.impl.e.a)object22).b().g();
        object = object.c();
        j.a((Object)iterator, "segments");
        object22 = kotlin.a.m.f(iterator);
        j.a(object22, "segments.first()");
        object = object22 = object.c((f)object22, d.r);
        if (!(object22 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            object = null;
        }
        if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object) != null) {
            for (Object object22 : iterator.subList(1, iterator.size())) {
                object = object.C();
                j.a(object22, "name");
                object = object22 = object.c((f)object22, d.r);
                if (!(object22 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
                    object = null;
                }
                if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object) != null) continue;
                return null;
            }
            return object;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.a.e a(y m2, kotlin.reflect.jvm.internal.impl.e.a a2, aa aa2) {
        j.b(m2, "$receiver");
        j.b(a2, "classId");
        j.b(aa2, "notFoundClasses");
        m2 = s.a(m2, a2);
        if (m2 != null) {
            return m2;
        }
        return aa2.a(a2, i.e(i.e(i.a(a2, a.c), b.a)));
    }

    public static final ar b(y object, kotlin.reflect.jvm.internal.impl.e.a object22) {
        j.b(object, "$receiver");
        j.b(object22, "classId");
        Object object3 = ((kotlin.reflect.jvm.internal.impl.e.a)object22).a();
        j.a(object3, "classId.packageFqName");
        object = object.a((kotlin.reflect.jvm.internal.impl.e.b)object3);
        object3 = ((kotlin.reflect.jvm.internal.impl.e.a)object22).b().g();
        int n2 = object3.size() - 1;
        object = object.c();
        j.a(object3, "segments");
        object22 = kotlin.a.m.f(object3);
        j.a(object22, "segments.first()");
        object = object.c((f)object22, d.r);
        if (n2 == 0) {
            object22 = object;
            if (!(object instanceof ar)) {
                object22 = null;
            }
            return (ar)object22;
        }
        object22 = object;
        if (!(object instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            object22 = null;
        }
        if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object22) != null) {
            for (Object object22 : object3.subList(1, n2)) {
                object = object.C();
                j.a(object22, "name");
                object = object22 = object.c((f)object22, d.r);
                if (!(object22 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
                    object = null;
                }
                if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object) != null) continue;
                return null;
            }
            object22 = (f)object3.get(n2);
            object = object.g();
            j.a(object22, "lastName");
            object = object22 = object.c((f)object22, d.r);
            if (!(object22 instanceof ar)) {
                object = null;
            }
            return (ar)object;
        }
        return null;
    }

}

