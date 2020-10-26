/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.s;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.l;
import kotlin.w;

public abstract class h
extends kotlin.reflect.jvm.internal.impl.h.e.i {
    static final /* synthetic */ l[] b;
    private final Map<kotlin.reflect.jvm.internal.impl.e.f, byte[]> a;
    private final Map<kotlin.reflect.jvm.internal.impl.e.f, byte[]> d;
    private final Map<kotlin.reflect.jvm.internal.impl.e.f, byte[]> e;
    private final kotlin.reflect.jvm.internal.impl.i.c<kotlin.reflect.jvm.internal.impl.e.f, Collection<am>> f;
    private final kotlin.reflect.jvm.internal.impl.i.c<kotlin.reflect.jvm.internal.impl.e.f, Collection<ai>> g;
    private final kotlin.reflect.jvm.internal.impl.i.d<kotlin.reflect.jvm.internal.impl.e.f, ar> h;
    private final kotlin.reflect.jvm.internal.impl.i.f i;
    private final kotlin.reflect.jvm.internal.impl.i.f j;
    private final kotlin.reflect.jvm.internal.impl.i.f k;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.l l;

    static {
        b = new l[]{v.a(new kotlin.e.b.t(v.a(h.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), v.a(new kotlin.e.b.t(v.a(h.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), v.a(new kotlin.e.b.t(v.a(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;"))};
    }

    protected h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.l collection, Collection<a.o> collection2, Collection<a.w> object, Collection<a.ad> object2, final kotlin.e.a.a<? extends Collection<kotlin.reflect.jvm.internal.impl.e.f>> a2) {
        kotlin.e.b.j.b(collection, "c");
        kotlin.e.b.j.b(collection2, "functionList");
        kotlin.e.b.j.b(object, "propertyList");
        kotlin.e.b.j.b(object2, "typeAliasList");
        kotlin.e.b.j.b(a2, "classNames");
        this.l = collection;
        collection = collection2;
        Map object32 = new LinkedHashMap();
        for (a.o o2 : collection) {
            collection = o2;
            kotlin.reflect.jvm.internal.impl.e.f f2 = u.b(this.l.e(), ((a.o)((Object)collection)).k());
            collection = collection2 = object32.get(f2);
            if (collection2 == null) {
                collection = new ArrayList();
                object32.put(f2, collection);
            }
            ((List)collection).add(o2);
        }
        this.a = this.a(object32);
        collection = (Iterable)object;
        object = new LinkedHashMap();
        for (Object t2 : collection) {
            collection = (q)t2;
            kotlin.reflect.jvm.internal.impl.e.f f3 = u.b(this.l.e(), ((a.w)((Object)collection)).k());
            collection = collection2 = object.get(f3);
            if (collection2 == null) {
                collection = new ArrayList();
                object.put(f3, collection);
            }
            ((List)collection).add(t2);
        }
        this.d = this.a((Map<kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.f.a>>)object);
        if (this.l.d().d().c()) {
            collection = (Iterable)((Object)object2);
            object = new LinkedHashMap();
            for (Object t3 : collection) {
                collection = (q)t3;
                kotlin.reflect.jvm.internal.impl.e.f f4 = u.b(this.l.e(), ((a.ad)((Object)collection)).g());
                collection = collection2 = object.get(f4);
                if (collection2 == null) {
                    collection = new ArrayList<a.o>();
                    object.put(f4, collection);
                }
                ((List)collection).add(t3);
            }
            collection = this.a((Map<kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.f.a>>)object);
        } else {
            collection = af.a();
        }
        this.e = collection;
        this.f = this.l.c().a((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends am>>(){

            @Override
            public final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "it");
                return this.c(f2);
            }
        });
        this.g = this.l.c().a((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends ai>>(){

            @Override
            public final Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "it");
                return this.d(f2);
            }
        });
        this.h = this.l.c().b((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, ar>(){

            @Override
            public final ar a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "it");
                return this.e(f2);
            }
        });
        this.i = this.l.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return al.a(this.a.keySet(), (Iterable)this.c());
            }
        });
        this.j = this.l.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return al.a(this.d.keySet(), (Iterable)this.d());
            }
        });
        this.k = this.l.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return m.m((Iterable)a2.a());
            }
        });
    }

    private final Map<kotlin.reflect.jvm.internal.impl.e.f, byte[]> a(Map<kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.f.a>> object) {
        Map map = new LinkedHashMap(af.a(object.size()));
        for (Object object2 : (Iterable)object.entrySet()) {
            Object k2 = object2.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Object object3 = (Iterable)object2.getValue();
            object2 = new ArrayList(m.a(object3, 10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                ((kotlin.reflect.jvm.internal.impl.f.a)object3.next()).a(byteArrayOutputStream);
                object2.add(w.a);
            }
            object2 = (List)object2;
            map.put(k2, byteArrayOutputStream.toByteArray());
        }
        return map;
    }

    private final void a(Collection<kotlin.reflect.jvm.internal.impl.a.m> collection, kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> object2, kotlin.reflect.jvm.internal.impl.b.a.b object3) {
        Object object4;
        Object object5;
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)object).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.f())) {
            Object object6;
            object4 = this.o_();
            object5 = new ArrayList();
            object4 = object4.iterator();
            while (object4.hasNext()) {
                object6 = (kotlin.reflect.jvm.internal.impl.e.f)object4.next();
                if (!object2.a((kotlin.reflect.jvm.internal.impl.e.f)object6).booleanValue()) continue;
                ((ArrayList)object5).addAll(this.a((kotlin.reflect.jvm.internal.impl.e.f)object6, (kotlin.reflect.jvm.internal.impl.b.a.b)object3));
            }
            object4 = (List)object5;
            object6 = f.a.a;
            kotlin.e.b.j.a(object6, "MemberComparator.NameAnd\u2026MemberComparator.INSTANCE");
            m.a(object4, (Comparator)object6);
            collection.addAll((Collection)object5);
        }
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)object).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.e())) {
            object5 = this.l_();
            object = new ArrayList();
            object5 = object5.iterator();
            while (object5.hasNext()) {
                object4 = (kotlin.reflect.jvm.internal.impl.e.f)object5.next();
                if (!((Boolean)object2.a(object4)).booleanValue()) continue;
                ((ArrayList)object).addAll(this.b((kotlin.reflect.jvm.internal.impl.e.f)object4, (kotlin.reflect.jvm.internal.impl.b.a.b)object3));
            }
            object2 = (List)object;
            object3 = f.a.a;
            kotlin.e.b.j.a(object3, "MemberComparator.NameAnd\u2026MemberComparator.INSTANCE");
            m.a(object2, (Comparator)object3);
            collection.addAll((Collection)object);
        }
    }

    private final Collection<am> c(kotlin.reflect.jvm.internal.impl.e.f f2) {
        Object object = this.a;
        ArrayList arrayList = a.o.a;
        kotlin.e.b.j.a(arrayList, "ProtoBuf.Function.PARSER");
        object = object.get(f2);
        if (object == null || (arrayList = kotlin.h.i.e(kotlin.h.i.a(new kotlin.e.a.a<M>(new ByteArrayInputStream((byte[])object), this, (s)((Object)arrayList)){
            final /* synthetic */ ByteArrayInputStream a;
            final /* synthetic */ h b;
            final /* synthetic */ s c;
            {
                this.a = byteArrayInputStream;
                this.b = h2;
                this.c = s2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final M b() {
                return (M)((q)this.c.e(this.a, this.b.f().d().q()));
            }
        }))) == null) {
            arrayList = m.a();
        }
        object = arrayList;
        arrayList = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            a.o o2 = (a.o)object.next();
            t t2 = this.l.b();
            kotlin.e.b.j.a((Object)o2, "it");
            arrayList.add(t2.a(o2));
        }
        arrayList = arrayList;
        this.a(f2, arrayList);
        return kotlin.reflect.jvm.internal.impl.l.a.a(arrayList);
    }

    private final Collection<ai> d(kotlin.reflect.jvm.internal.impl.e.f f2) {
        Object object = this.d;
        ArrayList arrayList = a.w.a;
        kotlin.e.b.j.a(arrayList, "ProtoBuf.Property.PARSER");
        object = object.get(f2);
        if (object == null || (arrayList = kotlin.h.i.e(kotlin.h.i.a(new kotlin.e.a.a<M>(new ByteArrayInputStream((byte[])object), this, (s)((Object)arrayList)){
            final /* synthetic */ ByteArrayInputStream a;
            final /* synthetic */ h b;
            final /* synthetic */ s c;
            {
                this.a = byteArrayInputStream;
                this.b = h2;
                this.c = s2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final M b() {
                return (M)((q)this.c.e(this.a, this.b.f().d().q()));
            }
        }))) == null) {
            arrayList = m.a();
        }
        object = arrayList;
        arrayList = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            a.w w2 = (a.w)object.next();
            t t2 = this.l.b();
            kotlin.e.b.j.a((Object)w2, "it");
            arrayList.add(t2.a(w2));
        }
        arrayList = arrayList;
        this.b(f2, arrayList);
        return kotlin.reflect.jvm.internal.impl.l.a.a(arrayList);
    }

    private final ar e(kotlin.reflect.jvm.internal.impl.e.f object) {
        if ((object = this.e.get(object)) != null && (object = a.ad.a(new ByteArrayInputStream((byte[])object), this.l.d().q())) != null) {
            return this.l.b().a((a.ad)object);
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.a.e f(kotlin.reflect.jvm.internal.impl.e.f f2) {
        return this.l.d().a(this.a(f2));
    }

    private final Set<kotlin.reflect.jvm.internal.impl.e.f> g() {
        return (Set)kotlin.reflect.jvm.internal.impl.i.h.a(this.i, (Object)this, b[0]);
    }

    private final Set<kotlin.reflect.jvm.internal.impl.e.f> h() {
        return (Set)kotlin.reflect.jvm.internal.impl.i.h.a(this.j, (Object)this, b[1]);
    }

    private final Set<kotlin.reflect.jvm.internal.impl.e.f> i() {
        return this.e.keySet();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f list, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(list, "name");
        kotlin.e.b.j.b(b2, "location");
        if (!this.o_().contains(list)) {
            list = m.a();
            do {
                return list;
                break;
            } while (true);
        }
        list = this.g.a((kotlin.reflect.jvm.internal.impl.e.f)((Object)list));
        return list;
    }

    protected final Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2, kotlin.reflect.jvm.internal.impl.b.a.b object22) {
        kotlin.e.b.j.b(object, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        kotlin.e.b.j.b(object22, "location");
        ArrayList arrayList = new ArrayList(0);
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.b())) {
            this.a(arrayList, b2);
        }
        Collection collection = arrayList;
        this.a(collection, (kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object), b2, (kotlin.reflect.jvm.internal.impl.b.a.b)object22);
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.h())) {
            for (kotlin.reflect.jvm.internal.impl.e.f f2 : this.e()) {
                if (!b2.a(f2).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.l.a.a(collection, this.f(f2));
            }
        }
        if (((kotlin.reflect.jvm.internal.impl.h.e.d)((Object)object)).a(kotlin.reflect.jvm.internal.impl.h.e.d.k.c())) {
            for (kotlin.reflect.jvm.internal.impl.e.f f3 : this.i()) {
                if (!b2.a(f3).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.l.a.a(collection, this.h.a(f3));
            }
        }
        return kotlin.reflect.jvm.internal.impl.l.a.a(arrayList);
    }

    protected abstract kotlin.reflect.jvm.internal.impl.e.a a(kotlin.reflect.jvm.internal.impl.e.f var1);

    protected abstract void a(Collection<kotlin.reflect.jvm.internal.impl.a.m> var1, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> var2);

    protected void a(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<am> collection) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(collection, "functions");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<am> b(kotlin.reflect.jvm.internal.impl.e.f list, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(list, "name");
        kotlin.e.b.j.b(b2, "location");
        if (!this.l_().contains(list)) {
            list = m.a();
            do {
                return list;
                break;
            } while (true);
        }
        list = this.f.a((kotlin.reflect.jvm.internal.impl.e.f)((Object)list));
        return list;
    }

    protected void b(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<ai> collection) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(collection, "descriptors");
    }

    protected boolean b(kotlin.reflect.jvm.internal.impl.e.f f2) {
        kotlin.e.b.j.b(f2, "name");
        return this.e().contains(f2);
    }

    protected abstract Set<kotlin.reflect.jvm.internal.impl.e.f> c();

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f object, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(object, "name");
        kotlin.e.b.j.b(b2, "location");
        if (this.b((kotlin.reflect.jvm.internal.impl.e.f)object)) {
            object = this.f((kotlin.reflect.jvm.internal.impl.e.f)object);
            do {
                return (kotlin.reflect.jvm.internal.impl.a.h)object;
                break;
            } while (true);
        }
        if (!this.i().contains(object)) return null;
        object = this.h.a((kotlin.reflect.jvm.internal.impl.e.f)object);
        return (kotlin.reflect.jvm.internal.impl.a.h)object;
    }

    protected abstract Set<kotlin.reflect.jvm.internal.impl.e.f> d();

    public final Set<kotlin.reflect.jvm.internal.impl.e.f> e() {
        return (Set)kotlin.reflect.jvm.internal.impl.i.h.a(this.k, (Object)this, b[2]);
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.l f() {
        return this.l;
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.f> l_() {
        return this.g();
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.f> o_() {
        return this.h();
    }

}

