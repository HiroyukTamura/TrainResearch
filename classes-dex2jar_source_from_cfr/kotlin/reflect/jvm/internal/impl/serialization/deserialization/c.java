/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.a;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.d;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;

public final class c
implements b<kotlin.reflect.jvm.internal.impl.a.a.c, kotlin.reflect.jvm.internal.impl.h.b.f<?>, g> {
    private final d a;
    private final a b;

    public c(y y2, aa aa2, a a2) {
        j.b(y2, "module");
        j.b(aa2, "notFoundClasses");
        j.b(a2, "protocol");
        this.b = a2;
        this.a = new d(y2, aa2);
    }

    @Override
    public /* synthetic */ Object a(w w2, a.w w3, kotlin.reflect.jvm.internal.impl.j.w w4) {
        return this.b(w2, w3, w4);
    }

    @Override
    public List<kotlin.reflect.jvm.internal.impl.a.a.c> a(a.ac list, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        j.b(list, "proto");
        j.b(c2, "nameResolver");
        list = ((i.c)((Object)list)).c(this.b.i());
        if (list == null) {
            list = m.a();
        }
        Object object = list;
        list = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            a.a a2 = (a.a)object.next();
            list.add(this.a.a(a2, c2));
        }
        return list;
    }

    @Override
    public List<kotlin.reflect.jvm.internal.impl.a.a.c> a(a.ag list, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        j.b(list, "proto");
        j.b(c2, "nameResolver");
        list = ((i.c)((Object)list)).c(this.b.j());
        if (list == null) {
            list = m.a();
        }
        Object object = list;
        list = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            a.a a2 = (a.a)object.next();
            list.add(this.a.a(a2, c2));
        }
        return list;
    }

    @Override
    public List<kotlin.reflect.jvm.internal.impl.a.a.c> a(w.a a2) {
        j.b(a2, "container");
        Collection<a.a> collection = a2.h().c(this.b.c());
        if (collection == null) {
            collection = m.a();
        }
        Object object = collection;
        collection = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            a.a a3 = (a.a)object.next();
            collection.add((a.a)((Object)this.a.a(a3, a2.b())));
        }
        return collection;
    }

    @Override
    public List<kotlin.reflect.jvm.internal.impl.a.a.c> a(w w2, a.k list) {
        j.b(w2, "container");
        j.b(list, "proto");
        list = ((i.c)((Object)list)).c(this.b.f());
        if (list == null) {
            list = m.a();
        }
        Object object = list;
        list = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            a.a a2 = (a.a)object.next();
            list.add(this.a.a(a2, w2.b()));
        }
        return list;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public List<g> a(w object, q collection, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a object2) {
        j.b(object, "container");
        j.b(collection, "proto");
        j.b(object2, "kind");
        if (collection instanceof a.e) {
            collection = ((a.e)((Object)collection)).c(this.b.b());
        } else if (collection instanceof a.o) {
            collection = ((a.o)((Object)collection)).c(this.b.d());
        } else {
            if (!(collection instanceof a.w)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown message: ");
                ((StringBuilder)object).append(collection);
                throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
            }
            collection = ((a.w)((Object)collection)).c(this.b.e());
        }
        collection = (List)collection;
        if (collection == null) {
            collection = m.a();
        }
        object2 = collection;
        collection = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            a.a a2 = (a.a)object2.next();
            collection.add((a.a)((Object)new g(this.a.a(a2, ((w)object).b()), null)));
        }
        return (List)collection;
    }

    @Override
    public List<kotlin.reflect.jvm.internal.impl.a.a.c> a(w w2, q list, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a object, int n2, a.ak i2) {
        j.b(w2, "container");
        j.b(list, "callableProto");
        j.b(object, "kind");
        j.b(i2, "proto");
        list = i2.c(this.b.h());
        if (list == null) {
            list = m.a();
        }
        object = list;
        list = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            i2 = (a.a)object.next();
            list.add(this.a.a((a.a)i2, w2.b()));
        }
        return list;
    }

    @Override
    public List<kotlin.reflect.jvm.internal.impl.a.a.c> b(w w2, q q2, kotlin.reflect.jvm.internal.impl.serialization.deserialization.a a2) {
        j.b(w2, "container");
        j.b(q2, "proto");
        j.b((Object)a2, "kind");
        return m.a();
    }

    public kotlin.reflect.jvm.internal.impl.h.b.f<?> b(w w2, a.w i2, kotlin.reflect.jvm.internal.impl.j.w w3) {
        j.b(w2, "container");
        j.b(i2, "proto");
        j.b(w3, "expectedType");
        i2 = f.a(i2, this.b.g());
        if (i2 != null) {
            return this.a.a(w3, (a.a.a.b)i2, w2.b());
        }
        return null;
    }
}

