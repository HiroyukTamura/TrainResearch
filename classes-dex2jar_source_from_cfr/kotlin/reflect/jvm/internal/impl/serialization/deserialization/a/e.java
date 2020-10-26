/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.at;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.h.e.j;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;

public final class e
extends kotlin.reflect.jvm.internal.impl.a.c.a {
    private final kotlin.reflect.jvm.internal.impl.e.a c;
    private final kotlin.reflect.jvm.internal.impl.a.w d;
    private final ba e;
    private final kotlin.reflect.jvm.internal.impl.a.f f;
    private final l g;
    private final kotlin.reflect.jvm.internal.impl.h.e.i h;
    private final b i;
    private final a j;
    private final c k;
    private final kotlin.reflect.jvm.internal.impl.a.m l;
    private final kotlin.reflect.jvm.internal.impl.i.g<kotlin.reflect.jvm.internal.impl.a.d> m;
    private final kotlin.reflect.jvm.internal.impl.i.f<Collection<kotlin.reflect.jvm.internal.impl.a.d>> n;
    private final kotlin.reflect.jvm.internal.impl.i.g<kotlin.reflect.jvm.internal.impl.a.e> o;
    private final kotlin.reflect.jvm.internal.impl.i.f<Collection<kotlin.reflect.jvm.internal.impl.a.e>> p;
    private final w.a q;
    private final kotlin.reflect.jvm.internal.impl.a.a.h r;
    private final a.c s;
    private final kotlin.reflect.jvm.internal.impl.d.b.a t;
    private final kotlin.reflect.jvm.internal.impl.a.an u;

    /*
     * Enabled aggressive block sorting
     */
    public e(l object, a.c object2, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.a object3, kotlin.reflect.jvm.internal.impl.a.an object4) {
        void var4_24;
        Object var3_23;
        void var1_7;
        kotlin.reflect.jvm.internal.impl.a.m m2;
        void var1_4;
        void var2_11;
        void var2_14;
        Object object5;
        void var2_20;
        void var1_10;
        kotlin.e.b.j.b(object, "outerContext");
        kotlin.e.b.j.b(var2_11, "classProto");
        kotlin.e.b.j.b(var3_23, "nameResolver");
        kotlin.e.b.j.b(var4_24, "metadataVersion");
        kotlin.e.b.j.b(object5, "sourceElement");
        super(((l)object).c(), u.a(var3_23, var2_11.g()).c());
        this.s = var2_11;
        this.t = var4_24;
        this.u = object5;
        this.c = u.a(var3_23, this.s.g());
        this.d = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.d.b(this.s.e()));
        this.e = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.c.b(this.s.e()));
        this.f = x.a.a(kotlin.reflect.jvm.internal.impl.d.b.b.e.b(this.s.e()));
        kotlin.reflect.jvm.internal.impl.a.m m3 = this;
        List<a.ag> list = this.s.l();
        kotlin.e.b.j.a(list, "classProto.typeParameterList");
        object5 = this.s.G();
        kotlin.e.b.j.a(object5, "classProto.typeTable");
        object5 = new kotlin.reflect.jvm.internal.impl.d.b.h((a.ai)object5);
        Object object6 = kotlin.reflect.jvm.internal.impl.d.b.k.a;
        Object object7 = this.s.J();
        kotlin.e.b.j.a(object7, "classProto.versionRequirementTable");
        this.g = ((l)object).a(m3, list, var3_23, (kotlin.reflect.jvm.internal.impl.d.b.h)object5, ((k.a)object6).a((a.ao)object7), this.t);
        if (this.f == kotlin.reflect.jvm.internal.impl.a.f.c) {
            kotlin.reflect.jvm.internal.impl.h.e.k k2 = new kotlin.reflect.jvm.internal.impl.h.e.k(this.g.c(), this);
        } else {
            h.c c3 = h.c.a;
        }
        kotlin.reflect.jvm.internal.impl.h.e.i i2 = (kotlin.reflect.jvm.internal.impl.h.e.i)var2_14;
        this.h = i2;
        this.i = new b();
        this.j = new a();
        kotlin.reflect.jvm.internal.impl.a.f f2 = this.f;
        kotlin.reflect.jvm.internal.impl.a.f f3 = kotlin.reflect.jvm.internal.impl.a.f.c;
        var3_23 = null;
        if (f2 == f3) {
            c c4 = new c();
        } else {
            Object var2_19 = null;
        }
        this.k = var2_20;
        this.l = ((l)object).f();
        this.m = this.g.c().b((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.a.d>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.a.d b() {
                return this.J();
            }
        });
        this.n = this.g.c().a((kotlin.e.a.a)new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.impl.a.d>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Collection<kotlin.reflect.jvm.internal.impl.a.d> b() {
                return this.K();
            }
        });
        this.o = this.g.c().b((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.a.e>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.a.e b() {
                return this.M();
            }
        });
        this.p = this.g.c().a((kotlin.e.a.a)new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.impl.a.e>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Collection<kotlin.reflect.jvm.internal.impl.a.e> b() {
                return this.N();
            }
        });
        a.c c5 = this.s;
        object5 = this.g.e();
        object6 = this.g.g();
        object7 = this.u;
        kotlin.reflect.jvm.internal.impl.a.m m4 = m2 = this.l;
        if (!(m2 instanceof e)) {
            Object var1_3 = null;
        }
        e e2 = (e)var1_4;
        Object var1_5 = var3_23;
        if (e2 != null) {
            w.a a2 = e2.q;
        }
        this.q = new w.a(c5, (kotlin.reflect.jvm.internal.impl.d.b.c)object5, (kotlin.reflect.jvm.internal.impl.d.b.h)object6, (kotlin.reflect.jvm.internal.impl.a.an)object7, (w.a)var1_7);
        if (!kotlin.reflect.jvm.internal.impl.d.b.b.b.a(this.s.e()).booleanValue()) {
            kotlin.reflect.jvm.internal.impl.a.a.h h2 = kotlin.reflect.jvm.internal.impl.a.a.h.a.a();
        } else {
            kotlin.reflect.jvm.internal.impl.a.a.h h3 = new n(this.g.c(), (kotlin.e.a.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.impl.a.a.c> b() {
                    return m.k((Iterable)this.a().d().f().a(this.c()));
                }
            });
        }
        this.r = var1_10;
    }

    private final kotlin.reflect.jvm.internal.impl.a.d J() {
        Object object;
        Object var3_5;
        Object object2;
        block4 : {
            block3 : {
                a.e e2;
                b.a a2;
                if (this.f.a()) {
                    kotlin.reflect.jvm.internal.impl.a.c.f f2 = kotlin.reflect.jvm.internal.impl.h.b.a(this, kotlin.reflect.jvm.internal.impl.a.an.a);
                    f2.a(this.i_());
                    return f2;
                }
                object2 = this.s.u();
                kotlin.e.b.j.a(object2, "classProto.constructorList");
                object = ((Iterable)object2).iterator();
                do {
                    boolean bl2 = object.hasNext();
                    var3_5 = null;
                    if (!bl2) break block3;
                    object2 = object.next();
                    e2 = (a.e)object2;
                    a2 = kotlin.reflect.jvm.internal.impl.d.b.b.k;
                    kotlin.e.b.j.a((Object)e2, "it");
                } while (!(a2.a(e2.e()) ^ true));
                break block4;
            }
            object2 = null;
        }
        object = (a.e)object2;
        object2 = var3_5;
        if (object != null) {
            object2 = this.g.b().a((a.e)object, true);
        }
        return object2;
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.a.d> K() {
        return m.b(m.b((Collection)this.L(), (Iterable)m.b(this.o())), (Iterable)this.g.d().o().d(this));
    }

    private final List<kotlin.reflect.jvm.internal.impl.a.d> L() {
        Object object;
        Object object2;
        Collection<a.e> collection = this.s.u();
        kotlin.e.b.j.a(collection, "classProto.constructorList");
        Iterator iterator = collection;
        collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            object = (a.e)object2;
            b.a a2 = kotlin.reflect.jvm.internal.impl.d.b.b.k;
            kotlin.e.b.j.a(object, "it");
            object = a2.a(((a.e)object).e());
            kotlin.e.b.j.a(object, "Flags.IS_SECONDARY.get(it.flags)");
            if (!((Boolean)object).booleanValue()) continue;
            collection.add((a.e)object2);
        }
        iterator = collection;
        collection = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = (a.e)iterator.next();
            object = this.g.b();
            kotlin.e.b.j.a(object2, "it");
            collection.add((a.e)((Object)((t)object).a((a.e)object2, false)));
        }
        return collection;
    }

    private final kotlin.reflect.jvm.internal.impl.a.e M() {
        if (!this.s.j()) {
            return null;
        }
        Object object = u.b(this.g.e(), this.s.k());
        kotlin.reflect.jvm.internal.impl.a.h h2 = this.j.c((kotlin.reflect.jvm.internal.impl.e.f)object, kotlin.reflect.jvm.internal.impl.b.a.d.r);
        object = h2;
        if (!(h2 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            object = null;
        }
        return (kotlin.reflect.jvm.internal.impl.a.e)object;
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.a.e> N() {
        if (this.d != kotlin.reflect.jvm.internal.impl.a.w.b) {
            return m.a();
        }
        Collection<Integer> collection = this.s.E();
        kotlin.e.b.j.a(collection, "fqNames");
        if (((Collection)collection).isEmpty() ^ true) {
            Object object = collection;
            collection = new ArrayList();
            object = object.iterator();
            while (object.hasNext()) {
                Object object2 = (Integer)object.next();
                j j2 = this.g.d();
                kotlin.reflect.jvm.internal.impl.d.b.c c2 = this.g.e();
                kotlin.e.b.j.a(object2, "index");
                if ((object2 = j2.a(u.a(c2, (Integer)object2))) == null) continue;
                collection.add((Integer)object2);
            }
            return collection;
        }
        return kotlin.reflect.jvm.internal.impl.h.c.a.b(this);
    }

    public Boolean A() {
        return kotlin.reflect.jvm.internal.impl.d.b.b.j.a(this.s.e());
    }

    public Boolean B() {
        return kotlin.reflect.jvm.internal.impl.d.b.b.i.a(this.s.e());
    }

    public Boolean F() {
        return kotlin.reflect.jvm.internal.impl.d.b.b.h.a(this.s.e());
    }

    public kotlin.reflect.jvm.internal.impl.h.e.i G() {
        return this.h;
    }

    public final a.c H() {
        return this.s;
    }

    public final kotlin.reflect.jvm.internal.impl.d.b.a I() {
        return this.t;
    }

    public final l a() {
        return this.g;
    }

    public final boolean a(kotlin.reflect.jvm.internal.impl.e.f f2) {
        kotlin.e.b.j.b(f2, "name");
        return this.j.e().contains(f2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.m b() {
        return this.l;
    }

    public final w.a c() {
        return this.q;
    }

    @Override
    public an e() {
        return this.i;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return this.G();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h g() {
        return this.j;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.e i() {
        return (kotlin.reflect.jvm.internal.impl.a.e)this.o.a();
    }

    public Boolean j() {
        return kotlin.reflect.jvm.internal.impl.d.b.b.f.a(this.s.e());
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.d> k() {
        return (Collection)this.n.a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.f l() {
        return this.f;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.w m() {
        return this.d;
    }

    public Boolean n() {
        return kotlin.reflect.jvm.internal.impl.d.b.b.g.a(this.s.e());
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.d o() {
        return (kotlin.reflect.jvm.internal.impl.a.d)this.m.a();
    }

    @Override
    public ba p() {
        return this.e;
    }

    @Override
    public boolean q() {
        return kotlin.reflect.jvm.internal.impl.d.b.b.e.b(this.s.e()) == a.c.b.g;
    }

    @Override
    public /* synthetic */ boolean r() {
        return this.j();
    }

    @Override
    public /* synthetic */ boolean s() {
        return this.n();
    }

    @Override
    public /* synthetic */ boolean t() {
        return this.A();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deserialized class ");
        stringBuilder.append(this.h_());
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ boolean u() {
        return this.B();
    }

    @Override
    public boolean v() {
        return false;
    }

    @Override
    public /* synthetic */ boolean w() {
        return this.F();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a.h x() {
        return this.r;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.an y() {
        return this.u;
    }

    @Override
    public List<as> z() {
        return this.g.a().a();
    }

    private final class kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e$a
    extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.h {
        private final kotlin.reflect.jvm.internal.impl.i.f<Collection<kotlin.reflect.jvm.internal.impl.a.m>> d;

        public kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e$a() {
            l l2 = ((e)e.this).a();
            Collection<a.o> collection = ((e)e.this).H().w();
            kotlin.e.b.j.a(collection, "classProto.functionList");
            collection = collection;
            Collection<a.w> collection2 = ((e)e.this).H().y();
            kotlin.e.b.j.a(collection2, "classProto.propertyList");
            collection2 = collection2;
            Collection<a.ad> collection3 = ((e)e.this).H().A();
            kotlin.e.b.j.a(collection3, "classProto.typeAliasList");
            collection3 = collection3;
            Object object2 = ((e)e.this).H().t();
            kotlin.e.b.j.a(object2, "classProto.nestedClassNameList");
            object2 = (Iterable)object2;
            e.this = ((e)e.this).a().e();
            Collection collection4 = new ArrayList(m.a(object2, 10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                collection4.add(u.b((kotlin.reflect.jvm.internal.impl.d.b.c)e.this, ((Number)object2.next()).intValue()));
            }
            super(l2, collection, collection2, collection3, (kotlin.e.a.a<? extends Collection<kotlin.reflect.jvm.internal.impl.e.f>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.e.f>>((List)collection4){
                final /* synthetic */ List a;
                {
                    this.a = list;
                    super(0);
                }

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.impl.e.f> b() {
                    return this.a;
                }
            });
            this.d = this.f().c().a((kotlin.e.a.a)new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.impl.a.m>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Collection<kotlin.reflect.jvm.internal.impl.a.m> b() {
                    return this.a(kotlin.reflect.jvm.internal.impl.h.e.d.a, kotlin.reflect.jvm.internal.impl.h.e.h.c.a(), kotlin.reflect.jvm.internal.impl.b.a.d.m);
                }
            });
        }

        private final <D extends kotlin.reflect.jvm.internal.impl.a.b> void a(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<? extends D> collection, final Collection<D> collection2) {
            kotlin.reflect.jvm.internal.impl.h.j.a(f2, collection, (Collection<? extends kotlin.reflect.jvm.internal.impl.a.b>)new ArrayList<D>(collection2), this.g(), new kotlin.reflect.jvm.internal.impl.h.h(){

                @Override
                public void a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                    kotlin.e.b.j.b(b2, "fakeOverride");
                    kotlin.reflect.jvm.internal.impl.h.j.a(b2, null);
                    collection2.add(b2);
                }

                @Override
                protected void a(kotlin.reflect.jvm.internal.impl.a.b b2, kotlin.reflect.jvm.internal.impl.a.b b3) {
                    kotlin.e.b.j.b(b2, "fromSuper");
                    kotlin.e.b.j.b(b3, "fromCurrent");
                }
            });
        }

        private final e g() {
            return e.this;
        }

        @Override
        public Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(b2, "location");
            this.d(f2, b2);
            return super.a(f2, b2);
        }

        @Override
        public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
            kotlin.e.b.j.b(d2, "kindFilter");
            kotlin.e.b.j.b(b2, "nameFilter");
            return (Collection)this.d.a();
        }

        @Override
        protected kotlin.reflect.jvm.internal.impl.e.a a(kotlin.reflect.jvm.internal.impl.e.f f2) {
            kotlin.e.b.j.b(f2, "name");
            return e.this.c.a(f2);
        }

        @Override
        protected void a(Collection<kotlin.reflect.jvm.internal.impl.a.m> collection, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> collection2) {
            kotlin.e.b.j.b(collection, "result");
            kotlin.e.b.j.b(collection2, "nameFilter");
            collection2 = this.g().k;
            collection2 = collection2 != null ? ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e$c)((Object)collection2)).a() : null;
            if (collection2 == null) {
                collection2 = m.a();
            }
            collection.addAll(collection2);
        }

        @Override
        protected void a(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<am> collection) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(collection, "functions");
            ArrayList<am> arrayList = new ArrayList<am>();
            Iterator<kotlin.reflect.jvm.internal.impl.j.w> iterator = this.g().e().k_().iterator();
            while (iterator.hasNext()) {
                arrayList.addAll(iterator.next().b().b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.l));
            }
            m.a((Iterable)collection, (kotlin.e.a.b)new kotlin.e.a.b<am, Boolean>(){

                @Override
                public /* synthetic */ Object a(Object object) {
                    return this.a((am)object);
                }

                @Override
                public final boolean a(am am2) {
                    kotlin.e.b.j.b(am2, "it");
                    return this.f().d().p().a(e.this, am2);
                }
            });
            collection.addAll(this.f().d().o().a(f2, e.this));
            this.a(f2, (Collection)arrayList, collection);
        }

        @Override
        public Collection<am> b(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(b2, "location");
            this.d(f2, b2);
            return super.b(f2, b2);
        }

        @Override
        protected void b(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<ai> collection) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(collection, "descriptors");
            ArrayList<ai> arrayList = new ArrayList<ai>();
            Iterator<kotlin.reflect.jvm.internal.impl.j.w> iterator = this.g().e().k_().iterator();
            while (iterator.hasNext()) {
                arrayList.addAll(iterator.next().b().a(f2, kotlin.reflect.jvm.internal.impl.b.a.d.l));
            }
            this.a(f2, (Collection)arrayList, collection);
        }

        @Override
        protected Set<kotlin.reflect.jvm.internal.impl.e.f> c() {
            Object object = this.g().i.j();
            Collection collection = new LinkedHashSet();
            object = object.iterator();
            while (object.hasNext()) {
                m.a(collection, (Iterable)((kotlin.reflect.jvm.internal.impl.j.w)object.next()).b().l_());
            }
            ((LinkedHashSet)collection).addAll(this.f().d().o().c(e.this));
            return (Set)collection;
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(b2, "location");
            this.d(f2, b2);
            Object object = this.g().k;
            if (object != null && (object = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e$c)object).a(f2)) != null) {
                return (kotlin.reflect.jvm.internal.impl.a.h)object;
            }
            return super.c(f2, b2);
        }

        @Override
        protected Set<kotlin.reflect.jvm.internal.impl.e.f> d() {
            Object object = this.g().i.j();
            Collection collection = new LinkedHashSet();
            object = object.iterator();
            while (object.hasNext()) {
                m.a(collection, (Iterable)((kotlin.reflect.jvm.internal.impl.j.w)object.next()).b().o_());
            }
            return (Set)collection;
        }

        @Override
        public void d(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(b2, "location");
            kotlin.reflect.jvm.internal.impl.b.a.a(this.f().d().j(), b2, this.g(), f2);
        }

    }

    private final class b
    extends kotlin.reflect.jvm.internal.impl.j.b {
        private final kotlin.reflect.jvm.internal.impl.i.f<List<as>> b;

        public b() {
            super(e.this.a().c());
            this.b = e.this.a().c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends as>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<as> b() {
                    return at.a(e.this);
                }
            });
        }

        @Override
        protected Collection<kotlin.reflect.jvm.internal.impl.j.w> a() {
            Object object;
            Object object2 = kotlin.reflect.jvm.internal.impl.d.b.g.a(e.this.H(), e.this.a().g());
            Object object3 = new ArrayList(m.a(object2, 10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object = (a.ac)object2.next();
                object3.add(aa.a(e.this.a().a(), (a.ac)object, null, 2, null));
            }
            object = m.b((List)object3, (Iterable)e.this.a().d().o().a(e.this));
            Object object4 = new ArrayList();
            Object object5 = object.iterator();
            while (object5.hasNext()) {
                object3 = object2 = ((kotlin.reflect.jvm.internal.impl.j.w)object5.next()).g().d();
                if (!(object2 instanceof aa.b)) {
                    object3 = null;
                }
                if ((object3 = (aa.b)object3) == null) continue;
                object4.add(object3);
            }
            object3 = (List)object4;
            if (object3.isEmpty() ^ true) {
                object2 = e.this.a().d().i();
                object4 = e.this;
                object3 = (Iterable)object3;
                object5 = new ArrayList(m.a(object3, 10));
                Iterator iterator = object3.iterator();
                while (iterator.hasNext()) {
                    aa.b b2 = (aa.b)iterator.next();
                    object3 = kotlin.reflect.jvm.internal.impl.h.c.a.a((i)b2);
                    if (object3 == null || (object3 = ((kotlin.reflect.jvm.internal.impl.e.a)object3).g()) == null || (object3 = ((kotlin.reflect.jvm.internal.impl.e.b)object3).a()) == null) {
                        object3 = b2.h_().a();
                    }
                    object5.add(object3);
                }
                object2.a((kotlin.reflect.jvm.internal.impl.a.e)object4, (List)object5);
            }
            return m.k(object);
        }

        @Override
        public List<as> b() {
            return (List)this.b.a();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.h d() {
            return this.i();
        }

        @Override
        public boolean f() {
            return true;
        }

        @Override
        protected aq g() {
            return aq.a.a;
        }

        public e i() {
            return e.this;
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.e j_() {
            return this.i();
        }

        public String toString() {
            return e.this.h_().toString();
        }

    }

    private final class c {
        private final Map<kotlin.reflect.jvm.internal.impl.e.f, a.k> b;
        private final kotlin.reflect.jvm.internal.impl.i.d<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.a.e> c;
        private final kotlin.reflect.jvm.internal.impl.i.f<Set<kotlin.reflect.jvm.internal.impl.e.f>> d;

        public c() {
            Object object = e.this.H().C();
            kotlin.e.b.j.a(object, "classProto.enumEntryList");
            Object object2 = (Iterable)object;
            object = new LinkedHashMap(kotlin.g.d.c(af.a(m.a(object2, 10)), 16));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object e3 = object2.next();
                a.k k2 = (a.k)e3;
                kotlin.reflect.jvm.internal.impl.d.b.c c2 = e.this.a().e();
                kotlin.e.b.j.a((Object)k2, "it");
                object.put(u.b(c2, k2.e()), e3);
            }
            this.b = object;
            this.c = e.this.a().c().b((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.a.c.n>(){

                @Override
                public final kotlin.reflect.jvm.internal.impl.a.c.n a(final kotlin.reflect.jvm.internal.impl.e.f f2) {
                    kotlin.e.b.j.b(f2, "name");
                    final a.k k2 = (a.k)this.b.get(f2);
                    if (k2 != null) {
                        return kotlin.reflect.jvm.internal.impl.a.c.n.a(e.this.a().c(), e.this, f2, this.d, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.a(e.this.a().c(), (kotlin.e.a.a<? extends List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>>)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.a.c>>(){

                            @Override
                            public /* synthetic */ Object a() {
                                return this.b();
                            }

                            public final List<kotlin.reflect.jvm.internal.impl.a.a.c> b() {
                                return m.k((Iterable)e.this.a().d().f().a(e.this.c(), k2));
                            }
                        }), kotlin.reflect.jvm.internal.impl.a.an.a);
                    }
                    return null;
                }

            });
            this.d = e.this.a().c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                    return this.b();
                }
            });
        }

        private final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
            kotlin.reflect.jvm.internal.impl.d.b.c c2;
            Object object;
            Collection<kotlin.reflect.jvm.internal.impl.e.f> collection = new HashSet();
            Object object2 = e.this.e().k_().iterator();
            while (object2.hasNext()) {
                for (Object object3 : j.a.a(object2.next().b(), null, null, 3, null)) {
                    if (!(object3 instanceof am) && !(object3 instanceof ai)) continue;
                    ((HashSet)collection).add(object3.h_());
                }
            }
            object2 = e.this.H().w();
            kotlin.e.b.j.a(object2, "classProto.functionList");
            for (Object object3 : (Iterable)object2) {
                object = collection;
                object3 = (a.o)object3;
                c2 = e.this.a().e();
                kotlin.e.b.j.a(object3, "it");
                object.add((a.w)((Object)u.b(c2, ((a.o)object3).k())));
            }
            collection = collection;
            object2 = (Set)collection;
            object = e.this.H().y();
            kotlin.e.b.j.a(object, "classProto.propertyList");
            for (Object object3 : (Iterable)object) {
                c2 = e.this.a().e();
                kotlin.e.b.j.a(object3, "it");
                collection.add(u.b(c2, ((a.w)object3).k()));
            }
            return al.a(object2, (Iterable)collection);
        }

        public final Collection<kotlin.reflect.jvm.internal.impl.a.e> a() {
            Object object = this.b.keySet();
            Collection collection = new ArrayList();
            object = object.iterator();
            while (object.hasNext()) {
                kotlin.reflect.jvm.internal.impl.a.e e2 = this.a((kotlin.reflect.jvm.internal.impl.e.f)object.next());
                if (e2 == null) continue;
                collection.add(e2);
            }
            return (List)collection;
        }

        public final kotlin.reflect.jvm.internal.impl.a.e a(kotlin.reflect.jvm.internal.impl.e.f f2) {
            kotlin.e.b.j.b(f2, "name");
            return (kotlin.reflect.jvm.internal.impl.a.e)this.c.a(f2);
        }

    }

}

