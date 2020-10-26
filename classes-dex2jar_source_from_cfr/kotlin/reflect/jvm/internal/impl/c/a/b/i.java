/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.b.a;
import kotlin.reflect.jvm.internal.impl.c.a.b.g;
import kotlin.reflect.jvm.internal.impl.c.a.b.h;
import kotlin.reflect.jvm.internal.impl.c.a.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.l;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b.s;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class i {
    public static final List<av> a(Collection<j> object, Collection<? extends av> collection, kotlin.reflect.jvm.internal.impl.a.a object2) {
        kotlin.e.b.j.b(object, "newValueParametersTypes");
        kotlin.e.b.j.b(collection, "oldValueParameters");
        kotlin.e.b.j.b(object2, "newOwner");
        int n2 = object.size() == collection.size() ? 1 : 0;
        if (y.a && n2 == 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Different value parameters sizes: Enhanced = ");
            ((StringBuilder)object2).append(object.size());
            ((StringBuilder)object2).append(", Old = ");
            ((StringBuilder)object2).append(collection.size());
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object2).toString()));
        }
        object = m.a((Iterable)object, collection);
        collection = new ArrayList(m.a(object, 10));
        Iterator<j> iterator = object.iterator();
        while (iterator.hasNext()) {
            Object object3 = (o)((Object)iterator.next());
            object = (j)((o)object3).c();
            Object object4 = (av)((o)object3).d();
            n2 = object4.c();
            object3 = object4.x();
            f f2 = object4.h_();
            kotlin.e.b.j.a((Object)f2, "oldParameter.name");
            w w2 = ((j)object).a();
            boolean bl2 = ((j)object).b();
            boolean bl3 = object4.o();
            boolean bl4 = object4.q();
            object = object4.m() != null ? kotlin.reflect.jvm.internal.impl.h.c.a.c((kotlin.reflect.jvm.internal.impl.a.m)object2).a().getArrayElementType(((j)object).a()) : null;
            object4 = object4.y();
            kotlin.e.b.j.a(object4, "oldParameter.source");
            collection.add(new ah((kotlin.reflect.jvm.internal.impl.a.a)object2, null, n2, (kotlin.reflect.jvm.internal.impl.a.a.h)object3, f2, w2, bl2, bl3, bl4, (w)object, (an)object4));
        }
        return (List)collection;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final a a(av object) {
        kotlin.e.b.j.b(object, "$receiver");
        Object object2 = object.x();
        Object object3 = kotlin.reflect.jvm.internal.impl.c.a.o.n;
        kotlin.e.b.j.a(object3, "JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME");
        object2 = object2.a((b)object3);
        if (object2 != null && (object3 = kotlin.reflect.jvm.internal.impl.h.c.a.b((c)object2)) != null) {
            object2 = object3;
            if (!(object3 instanceof s)) {
                object2 = null;
            }
            if ((object2 = (s)object2) != null && (object2 = (String)((kotlin.reflect.jvm.internal.impl.h.b.f)object2).a()) != null) {
                object = new h((String)object2);
                do {
                    return (a)object;
                    break;
                } while (true);
            }
        }
        object = object.x();
        object2 = kotlin.reflect.jvm.internal.impl.c.a.o.o;
        kotlin.e.b.j.a(object2, "JvmAnnotationNames.DEFAULT_NULL_FQ_NAME");
        if (!object.b((b)object2)) return null;
        object = g.a;
        return (a)object;
    }

    public static final l a(e e2) {
        kotlin.e.b.j.b(e2, "$receiver");
        e2 = kotlin.reflect.jvm.internal.impl.h.c.a.a(e2);
        if (e2 != null) {
            kotlin.reflect.jvm.internal.impl.h.e.h h2 = e2.f_();
            if (!(h2 instanceof l)) {
                return i.a(e2);
            }
            return (l)h2;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.h.d.b a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.g object) {
        kotlin.e.b.j.b(object, "$receiver");
        object = object.O();
        boolean bl2 = object instanceof kotlin.reflect.jvm.internal.impl.c.b.i;
        Object var2_2 = null;
        if (!bl2) {
            object = null;
        }
        kotlin.reflect.jvm.internal.impl.c.b.i i2 = (kotlin.reflect.jvm.internal.impl.c.b.i)object;
        object = var2_2;
        if (i2 != null) {
            object = i2.d();
        }
        return object;
    }
}

