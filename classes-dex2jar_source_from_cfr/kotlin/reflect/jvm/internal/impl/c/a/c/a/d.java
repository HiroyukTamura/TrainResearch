/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.b.a.c;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.j;
import kotlin.reflect.jvm.internal.impl.c.a.c.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.t;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.l;

public final class d
implements kotlin.reflect.jvm.internal.impl.h.e.h {
    static final /* synthetic */ l[] a;
    private final j b;
    private final kotlin.reflect.jvm.internal.impl.i.f d;
    private final h e;
    private final kotlin.reflect.jvm.internal.impl.c.a.c.a.h f;

    static {
        a = new l[]{v.a(new kotlin.e.b.t(v.a(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    }

    public d(h h2, t t2, kotlin.reflect.jvm.internal.impl.c.a.c.a.h h3) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(t2, "jPackage");
        kotlin.e.b.j.b(h3, "packageFragment");
        this.e = h2;
        this.f = h3;
        this.b = new j(this.e, t2, this.f);
        this.d = this.e.c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.h.e.h>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.h.e.h> b() {
                Object object = this.f.c().values();
                Collection collection = new ArrayList();
                object = object.iterator();
                while (object.hasNext()) {
                    Object object2 = (n)object.next();
                    object2 = this.e.e().d().a(this.f, (n)object2);
                    if (object2 == null) continue;
                    collection.add(object2);
                }
                return m.k((List)collection);
            }
        });
    }

    private final List<kotlin.reflect.jvm.internal.impl.h.e.h> d() {
        return (List)kotlin.reflect.jvm.internal.impl.i.h.a(this.d, (Object)this, a[0]);
    }

    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        Collection<ai> collection = this.b;
        Object object = this.d();
        collection = ((kotlin.reflect.jvm.internal.impl.h.e.h)((Object)collection)).a(f2, b2);
        object = object.iterator();
        while (object.hasNext()) {
            collection = kotlin.reflect.jvm.internal.impl.k.b.a.a(collection, ((kotlin.reflect.jvm.internal.impl.h.e.h)object.next()).a(f2, b2));
        }
        if (collection != null) {
            return collection;
        }
        return al.a();
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        Collection<kotlin.reflect.jvm.internal.impl.a.m> collection = this.b;
        Object object = this.d();
        collection = ((kotlin.reflect.jvm.internal.impl.h.e.h)((Object)collection)).a(d2, b2);
        object = object.iterator();
        while (object.hasNext()) {
            collection = kotlin.reflect.jvm.internal.impl.k.b.a.a(collection, ((kotlin.reflect.jvm.internal.impl.h.e.h)object.next()).a(d2, b2));
        }
        if (collection != null) {
            return collection;
        }
        return al.a();
    }

    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        Collection<am> collection = this.b;
        Object object = this.d();
        collection = ((kotlin.reflect.jvm.internal.impl.h.e.h)((Object)collection)).b(f2, b2);
        object = object.iterator();
        while (object.hasNext()) {
            collection = kotlin.reflect.jvm.internal.impl.k.b.a.a(collection, ((kotlin.reflect.jvm.internal.impl.h.e.h)object.next()).b(f2, b2));
        }
        if (collection != null) {
            return collection;
        }
        return al.a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        Object object = this.b.e(f2, b2);
        if (object != null) {
            return (kotlin.reflect.jvm.internal.impl.a.h)object;
        }
        Object object2 = this.d();
        object = null;
        Iterator<kotlin.reflect.jvm.internal.impl.h.e.h> iterator = object2.iterator();
        do {
            object2 = object;
            if (!iterator.hasNext()) break;
            object2 = iterator.next().c(f2, b2);
            if (object2 == null) continue;
            if (!(object2 instanceof i) || !((i)object2).u()) break;
            if (object != null) continue;
            object = object2;
        } while (true);
        return object2;
    }

    public final j c() {
        return this.b;
    }

    public void d(f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        kotlin.reflect.jvm.internal.impl.b.a.a(this.e.e().m(), b2, this.f, f2);
    }

    @Override
    public Set<f> l_() {
        Object object = this.d();
        Collection collection = new LinkedHashSet();
        object = object.iterator();
        while (object.hasNext()) {
            m.a(collection, (Iterable)((kotlin.reflect.jvm.internal.impl.h.e.h)object.next()).l_());
        }
        collection = (Set)collection;
        collection.addAll((Collection)this.b.l_());
        return collection;
    }

    @Override
    public Set<f> o_() {
        Object object = this.d();
        Collection collection = new LinkedHashSet();
        object = object.iterator();
        while (object.hasNext()) {
            m.a(collection, (Iterable)((kotlin.reflect.jvm.internal.impl.h.e.h)object.next()).o_());
        }
        collection = (Set)collection;
        collection.addAll((Collection)this.b.o_());
        return collection;
    }

}

