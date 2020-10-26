/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.h.i;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.n;
import kotlin.reflect.jvm.internal.impl.c.a.e.p;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.e.f;

public class a
implements b {
    private final kotlin.e.a.b<q, Boolean> a;
    private final Map<f, List<q>> b;
    private final Map<f, n> c;
    private final g d;
    private final kotlin.e.a.b<p, Boolean> e;

    public a(g arrayList, kotlin.e.a.b<? super p, Boolean> iterator) {
        j.b(arrayList, "jClass");
        j.b(iterator, "memberFilter");
        this.d = arrayList;
        this.e = iterator;
        this.a = new kotlin.e.a.b<q, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a((q)object);
            }

            @Override
            public final boolean a(q q2) {
                j.b(q2, "m");
                return (Boolean)this.e.a(q2) != false && !kotlin.reflect.jvm.internal.impl.c.a.a.a.a((p)q2);
            }
        };
        arrayList = i.a(m.q((Iterable)this.d.k()), this.a);
        Map map = new LinkedHashMap();
        Iterator iterator2 = arrayList.a();
        while (iterator2.hasNext()) {
            Object t2 = iterator2.next();
            f f2 = ((q)t2).r();
            iterator = map.get(f2);
            arrayList = iterator;
            if (iterator == null) {
                arrayList = new ArrayList();
                map.put(f2, arrayList);
            }
            ((List)arrayList).add(t2);
        }
        this.b = map;
        iterator = i.a(m.q((Iterable)this.d.l()), this.e);
        arrayList = new LinkedHashMap();
        iterator = iterator.a();
        while (iterator.hasNext()) {
            map = iterator.next();
            arrayList.put(((n)((Object)map)).r(), map);
        }
        this.c = arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<q> a(f list) {
        j.b(list, "name");
        list = this.b.get(list);
        if (list != null) {
            do {
                return list;
                break;
            } while (true);
        }
        list = m.a();
        return list;
    }

    @Override
    public Set<f> a() {
        Object object = i.a(m.q((Iterable)this.d.k()), this.a);
        Collection collection = new LinkedHashSet();
        object = object.a();
        while (object.hasNext()) {
            collection.add(((q)object.next()).r());
        }
        return (Set)collection;
    }

    @Override
    public Set<f> b() {
        Object object = i.a(m.q((Iterable)this.d.l()), this.e);
        Collection collection = new LinkedHashSet();
        object = object.a();
        while (object.hasNext()) {
            collection.add(((n)object.next()).r());
        }
        return (Set)collection;
    }

    @Override
    public n b(f f2) {
        j.b(f2, "name");
        return this.c.get(f2);
    }

}

