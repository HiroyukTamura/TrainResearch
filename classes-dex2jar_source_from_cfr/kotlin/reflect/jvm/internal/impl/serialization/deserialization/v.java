/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.g.d;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;

public final class v
implements g {
    private final Map<kotlin.reflect.jvm.internal.impl.e.a, a.c> a;
    private final c b;
    private final a c;
    private final b<kotlin.reflect.jvm.internal.impl.e.a, an> d;

    public v(a.t object, c iterator, a a2, b<? super kotlin.reflect.jvm.internal.impl.e.a, ? extends an> object2) {
        j.b(object, "proto");
        j.b(iterator, "nameResolver");
        j.b(a2, "metadataVersion");
        j.b(object2, "classSource");
        this.b = iterator;
        this.c = a2;
        this.d = object2;
        object = ((a.t)object).l();
        j.a(object, "proto.class_List");
        iterator = (Iterable)object;
        object = new LinkedHashMap(d.c(af.a(m.a(iterator, 10)), 16));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            a2 = iterator.next();
            object2 = (a.c)((Object)a2);
            c c2 = this.b;
            j.a(object2, "klass");
            object.put(u.a(c2, ((a.c)object2).g()), a2);
        }
        this.a = object;
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.e.a> a() {
        return this.a.keySet();
    }

    @Override
    public f a(kotlin.reflect.jvm.internal.impl.e.a a2) {
        j.b(a2, "classId");
        a.c c2 = this.a.get(a2);
        if (c2 != null) {
            return new f(this.b, c2, this.c, this.d.a(a2));
        }
        return null;
    }
}

