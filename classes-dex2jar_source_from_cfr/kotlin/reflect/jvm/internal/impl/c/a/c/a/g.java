/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.ah;
import kotlin.reflect.jvm.internal.impl.a.c.ai;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.c.a.a.k;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.k;
import kotlin.reflect.jvm.internal.impl.c.a.e.p;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.c.a.e.x;
import kotlin.reflect.jvm.internal.impl.c.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.n;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.c.a.r;
import kotlin.reflect.jvm.internal.impl.c.a.s;
import kotlin.reflect.jvm.internal.impl.h.j;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.l.j;
import kotlin.y;

public final class g
extends k {
    private final kotlin.reflect.jvm.internal.impl.i.f<List<kotlin.reflect.jvm.internal.impl.a.d>> b;
    private final kotlin.reflect.jvm.internal.impl.i.f<Set<kotlin.reflect.jvm.internal.impl.e.f>> d;
    private final kotlin.reflect.jvm.internal.impl.i.f<Map<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.c.a.e.n>> e;
    private final kotlin.reflect.jvm.internal.impl.i.d<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.a.c.g> f;
    private final kotlin.reflect.jvm.internal.impl.a.e g;
    private final kotlin.reflect.jvm.internal.impl.c.a.e.g h;

    public g(final kotlin.reflect.jvm.internal.impl.c.a.c.h h2, kotlin.reflect.jvm.internal.impl.a.e e2, kotlin.reflect.jvm.internal.impl.c.a.e.g g2) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(e2, "ownerDescriptor");
        kotlin.e.b.j.b(g2, "jClass");
        super(h2);
        this.g = e2;
        this.h = g2;
        this.b = h2.c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.d>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.a.d> b() {
                Object object;
                Object object2 = this.h.m();
                Object object3 = new ArrayList<kotlin.reflect.jvm.internal.impl.c.a.b.c>(object2.size());
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object = (kotlin.reflect.jvm.internal.impl.c.a.e.k)object2.next();
                    ((ArrayList)object3).add(this.a((kotlin.reflect.jvm.internal.impl.c.a.e.k)object));
                }
                object = h2.e().q();
                kotlin.reflect.jvm.internal.impl.c.a.c.h h22 = h2;
                object3 = object2 = (Collection)object3;
                if (object2.isEmpty()) {
                    object3 = kotlin.a.m.b(this.k());
                }
                return kotlin.a.m.k(((kotlin.reflect.jvm.internal.impl.c.a.f.l)object).a(h22, object3));
            }
        });
        this.d = h2.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                return kotlin.a.m.m((Iterable)this.h.e());
            }
        });
        this.e = h2.c().a((kotlin.e.a.a)new kotlin.e.a.a<Map<kotlin.reflect.jvm.internal.impl.e.f, ? extends kotlin.reflect.jvm.internal.impl.c.a.e.n>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Map<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.c.a.e.n> b() {
                Object object;
                Iterator iterator = this.h.l();
                Object object2 = new ArrayList();
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    if (!((kotlin.reflect.jvm.internal.impl.c.a.e.n)object).c()) continue;
                    object2.add(object);
                }
                iterator = (List)object2;
                object2 = new LinkedHashMap(kotlin.g.d.c(af.a(kotlin.a.m.a(iterator, 10)), 16));
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    object2.put(((kotlin.reflect.jvm.internal.impl.c.a.e.n)object).r(), object);
                }
                return object2;
            }
        });
        this.f = h2.c().b((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, kotlin.reflect.jvm.internal.impl.a.c.g>(){

            @Override
            public final kotlin.reflect.jvm.internal.impl.a.c.g a(kotlin.reflect.jvm.internal.impl.e.f object) {
                kotlin.e.b.j.b(object, "name");
                boolean bl2 = ((Set)this.d.a()).contains(object);
                Object object2 = null;
                if (!bl2) {
                    kotlin.reflect.jvm.internal.impl.c.a.e.n n2 = (kotlin.reflect.jvm.internal.impl.c.a.e.n)((Map)this.e.a()).get(object);
                    if (n2 != null) {
                        object2 = h2.c().a((kotlin.e.a.a)new kotlin.e.a.a<Set<? extends kotlin.reflect.jvm.internal.impl.e.f>>(){

                            @Override
                            public /* synthetic */ Object a() {
                                return this.b();
                            }

                            public final Set<kotlin.reflect.jvm.internal.impl.e.f> b() {
                                return al.a(this.l_(), (Iterable)this.o_());
                            }
                        });
                        object2 = kotlin.reflect.jvm.internal.impl.a.c.n.a(h2.c(), this.g(), (kotlin.reflect.jvm.internal.impl.e.f)object, (kotlin.reflect.jvm.internal.impl.i.f<Set<kotlin.reflect.jvm.internal.impl.e.f>>)object2, kotlin.reflect.jvm.internal.impl.c.a.c.f.a(h2, n2), h2.e().i().a(n2));
                    }
                    return (kotlin.reflect.jvm.internal.impl.a.c.g)object2;
                }
                object2 = h2.e().b();
                Object object3 = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.i)this.g());
                if (object3 == null) {
                    kotlin.e.b.j.a();
                }
                if ((object = object2.a(((kotlin.reflect.jvm.internal.impl.e.a)object3).a((kotlin.reflect.jvm.internal.impl.e.f)object))) != null) {
                    object2 = h2;
                    object3 = this.g();
                    kotlin.e.b.j.a(object, "it");
                    object = new kotlin.reflect.jvm.internal.impl.c.a.c.a.f((kotlin.reflect.jvm.internal.impl.c.a.c.h)object2, (kotlin.reflect.jvm.internal.impl.a.m)object3, (kotlin.reflect.jvm.internal.impl.c.a.e.g)object, null, 8, null);
                    h2.e().r().a((kotlin.reflect.jvm.internal.impl.c.a.b.d)object);
                } else {
                    object = null;
                }
                return (kotlin.reflect.jvm.internal.impl.a.c.g)object;
            }

        });
    }

    private final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f object) {
        Object object2 = ((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).a((kotlin.reflect.jvm.internal.impl.e.f)object);
        object = new ArrayList(kotlin.a.m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(this.a((q)object2.next()));
        }
        return (List)object;
    }

    private final List<kotlin.reflect.jvm.internal.impl.a.av> a(kotlin.reflect.jvm.internal.impl.a.c.f object) {
        Object object2;
        kotlin.o<kotlin.reflect.jvm.internal.impl.j.w, kotlin.reflect.jvm.internal.impl.j.w> o2 = this.h.k();
        ArrayList arrayList = new ArrayList(o2.size());
        kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2 = kotlin.reflect.jvm.internal.impl.c.a.c.b.d.a(kotlin.reflect.jvm.internal.impl.c.a.a.l.b, true, null, 2, null);
        Object object3 = (Iterable)((Object)o2);
        o2 = new ArrayList<q>();
        Object object42 = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object2 = object3.next();
            if (kotlin.e.b.j.a((Object)((q)object2).r(), (Object)o.c)) {
                ((ArrayList)((Object)o2)).add(object2);
                continue;
            }
            ((ArrayList)object42).add(object2);
        }
        object42 = new kotlin.o((Collection<q>)((Object)o2), object42);
        o2 = (List)((kotlin.o)object42).c();
        object42 = (List)((kotlin.o)object42).d();
        int n2 = o2.size();
        int n3 = 0;
        n2 = n2 <= 1 ? 1 : 0;
        if (y.a && n2 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("There can't be more than one method named 'value' in annotation class: ");
            ((StringBuilder)object).append(this.h);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        object3 = (q)kotlin.a.m.g(o2);
        if (object3 != null) {
            object2 = object3.d();
            if (object2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.f) {
                o2 = this.j().b();
                object2 = (kotlin.reflect.jvm.internal.impl.c.a.e.f)object2;
                o2 = new kotlin.o<kotlin.reflect.jvm.internal.impl.j.w, kotlin.reflect.jvm.internal.impl.j.w>(((kotlin.reflect.jvm.internal.impl.c.a.c.b.c)((Object)o2)).a((kotlin.reflect.jvm.internal.impl.c.a.e.f)object2, a2, true), this.j().b().a(object2.a(), a2));
            } else {
                o2 = new kotlin.o<kotlin.reflect.jvm.internal.impl.j.w, Object>(this.j().b().a((kotlin.reflect.jvm.internal.impl.c.a.e.v)object2, a2), null);
            }
            object2 = o2.c();
            o2 = o2.d();
            this.a(arrayList, (kotlin.reflect.jvm.internal.impl.a.l)object, 0, (q)object3, (kotlin.reflect.jvm.internal.impl.j.w)object2, (kotlin.reflect.jvm.internal.impl.j.w)((Object)o2));
        }
        n2 = object3 != null ? 1 : 0;
        for (Object object42 : (Iterable)object42) {
            object3 = this.j().b().a(object42.d(), a2);
            this.a(arrayList, (kotlin.reflect.jvm.internal.impl.a.l)object, n3 + n2, (q)object42, (kotlin.reflect.jvm.internal.impl.j.w)object3, null);
            ++n3;
        }
        return arrayList;
    }

    private final am a(kotlin.reflect.jvm.internal.impl.a.ai ai2, String object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> b2) {
        object = kotlin.reflect.jvm.internal.impl.e.f.a((String)object);
        kotlin.e.b.j.a(object, "Name.identifier(getterName)");
        Iterator iterator = ((Iterable)b2.a((kotlin.reflect.jvm.internal.impl.e.f)object)).iterator();
        do {
            boolean bl2 = iterator.hasNext();
            object = null;
            b2 = null;
            if (!bl2) break;
            am am2 = (am)iterator.next();
            if (am2.i().size() != 0) {
                object = b2;
                continue;
            }
            object = kotlin.reflect.jvm.internal.impl.j.a.c.a;
            kotlin.reflect.jvm.internal.impl.j.w w2 = am2.g();
            bl2 = w2 != null ? object.a(w2, ai2.r()) : false;
            object = b2;
            if (!bl2) continue;
            object = am2;
        } while (object == null);
        return object;
    }

    private final am a(kotlin.reflect.jvm.internal.impl.a.ai ai2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> b2) {
        Object object = ai2.a();
        String string2 = null;
        if ((object = object != null ? (aj)s.a((kotlin.reflect.jvm.internal.impl.a.b)object) : null) != null) {
            string2 = kotlin.reflect.jvm.internal.impl.c.a.e.a.b((kotlin.reflect.jvm.internal.impl.a.b)object);
        }
        if (string2 != null && !s.a(this.g(), (kotlin.reflect.jvm.internal.impl.a.a)object)) {
            return this.a(ai2, string2, b2);
        }
        object = n.c(ai2.h_().a());
        kotlin.e.b.j.a(object, "JvmAbi.getterName(name.asString())");
        return this.a(ai2, (String)object, b2);
    }

    private final am a(am am2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object) {
        if (!am2.D()) {
            return null;
        }
        Object object2 = am2.h_();
        kotlin.e.b.j.a(object2, "descriptor.name");
        object2 = ((Iterable)object.a((kotlin.reflect.jvm.internal.impl.e.f)object2)).iterator();
        while (object2.hasNext()) {
            object = this.e((am)object2.next());
            if (object == null || !this.a((kotlin.reflect.jvm.internal.impl.a.a)object, (kotlin.reflect.jvm.internal.impl.a.a)am2)) {
                object = null;
            }
            if (object == null) continue;
            return object;
        }
        return null;
    }

    private final am a(am am2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object, Collection<? extends am> collection) {
        t t2 = kotlin.reflect.jvm.internal.impl.c.a.d.a(am2);
        Object var4_5 = null;
        am2 = var4_5;
        if (t2 != null) {
            object = this.a(t2, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)object);
            am2 = var4_5;
            if (object != null) {
                if (!this.a((am)object)) {
                    object = null;
                }
                am2 = var4_5;
                if (object != null) {
                    am2 = this.a((am)object, t2, collection);
                }
            }
        }
        return am2;
    }

    private final am a(am am2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object, kotlin.reflect.jvm.internal.impl.e.f f2, Collection<? extends am> collection) {
        if ((am2 = (am)s.a((kotlin.reflect.jvm.internal.impl.a.b)am2)) != null) {
            Object object2 = s.d(am2);
            if (object2 == null) {
                kotlin.e.b.j.a();
            }
            object2 = kotlin.reflect.jvm.internal.impl.e.f.a((String)object2);
            kotlin.e.b.j.a(object2, "Name.identifier(nameInJava)");
            object = object.a((kotlin.reflect.jvm.internal.impl.e.f)object2).iterator();
            while (object.hasNext()) {
                object2 = this.a((am)object.next(), f2);
                if (!this.a(am2, (t)object2)) continue;
                return this.a((am)object2, am2, collection);
            }
        }
        return null;
    }

    private final am a(am am2, kotlin.reflect.jvm.internal.impl.a.a a2, Collection<? extends am> object) {
        boolean bl2;
        block5 : {
            object = (Iterable)object;
            boolean bl3 = object instanceof Collection;
            boolean bl4 = true;
            if (bl3 && object.isEmpty()) {
                bl2 = bl4;
            } else {
                am am3;
                object = object.iterator();
                do {
                    bl2 = bl4;
                    if (!object.hasNext()) break block5;
                } while (!(bl2 = kotlin.e.b.j.a((Object)am2, (Object)(am3 = (am)object.next())) ^ true && am3.t() == null && this.a((kotlin.reflect.jvm.internal.impl.a.a)am3, a2)));
                bl2 = false;
            }
        }
        if (bl2) {
            return am2;
        }
        if ((am2 = am2.E().d().f()) == null) {
            kotlin.e.b.j.a();
        }
        return am2;
    }

    private final am a(am object, kotlin.reflect.jvm.internal.impl.e.f f2) {
        object = object.E();
        object.a(f2);
        object.a();
        object.b();
        object = object.f();
        if (object == null) {
            kotlin.e.b.j.a();
        }
        return (am)object;
    }

    private final am a(t t2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object) {
        Object object2;
        List<kotlin.reflect.jvm.internal.impl.a.av> list;
        block4 : {
            block3 : {
                object2 = t2.h_();
                kotlin.e.b.j.a(object2, "overridden.name");
                list = ((Iterable)object.a((kotlin.reflect.jvm.internal.impl.e.f)object2)).iterator();
                do {
                    boolean bl2 = list.hasNext();
                    object2 = null;
                    if (!bl2) break block3;
                } while (!this.b((am)(object = list.next()), t2));
                break block4;
            }
            object = null;
        }
        list = (am)object;
        object = object2;
        if (list != null) {
            object = list.E();
            object2 = t2.i();
            kotlin.e.b.j.a(object2, "overridden.valueParameters");
            Object object3 = (Iterable)object2;
            object2 = new ArrayList(kotlin.a.m.a(object3, 10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                kotlin.reflect.jvm.internal.impl.a.av av2 = (kotlin.reflect.jvm.internal.impl.a.av)object3.next();
                kotlin.e.b.j.a((Object)av2, "it");
                kotlin.reflect.jvm.internal.impl.j.w w2 = av2.r();
                kotlin.e.b.j.a((Object)w2, "it.type");
                object2.add(new kotlin.reflect.jvm.internal.impl.c.a.b.j(w2, av2.l()));
            }
            object2 = (List)object2;
            list = list.i();
            kotlin.e.b.j.a(list, "override.valueParameters");
            object.a(kotlin.reflect.jvm.internal.impl.c.a.b.i.a((Collection<kotlin.reflect.jvm.internal.impl.c.a.b.j>)object2, (Collection<? extends kotlin.reflect.jvm.internal.impl.a.av>)list, t2));
            object.a();
            object.b();
            object = object.f();
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final ba a(kotlin.reflect.jvm.internal.impl.a.e object) {
        ba ba2 = object.p();
        if (kotlin.e.b.j.a((Object)ba2, (Object)m.b)) {
            ba2 = m.c;
            object = "JavaVisibilities.PROTECTED_AND_PACKAGE";
        } else {
            object = "visibility";
        }
        kotlin.e.b.j.a((Object)ba2, (String)object);
        return ba2;
    }

    private final kotlin.reflect.jvm.internal.impl.c.a.b.c a(kotlin.reflect.jvm.internal.impl.c.a.e.k k2) {
        kotlin.reflect.jvm.internal.impl.a.e e2 = this.g();
        Object object = kotlin.reflect.jvm.internal.impl.c.a.c.f.a(this.j(), k2);
        Object object2 = this.j().e().i();
        kotlin.reflect.jvm.internal.impl.c.a.e.l l2 = k2;
        object = kotlin.reflect.jvm.internal.impl.c.a.b.c.b(e2, (kotlin.reflect.jvm.internal.impl.a.a.h)object, false, object2.a(l2));
        object2 = this.j();
        kotlin.e.b.j.a(object, "constructorDescriptor");
        object2 = kotlin.reflect.jvm.internal.impl.c.a.c.a.a((kotlin.reflect.jvm.internal.impl.c.a.c.h)object2, (kotlin.reflect.jvm.internal.impl.a.m)object, (x)k2, e2.z().size());
        k.b b2 = this.a((kotlin.reflect.jvm.internal.impl.c.a.c.h)object2, (t)object, k2.c());
        Collection<as> collection = e2.z();
        kotlin.e.b.j.a(collection, "classDescriptor.declaredTypeParameters");
        collection = collection;
        Object object3 = k2.s();
        Collection collection2 = new ArrayList(kotlin.a.m.a(object3, 10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            Object object4 = (kotlin.reflect.jvm.internal.impl.c.a.e.w)object3.next();
            object4 = ((kotlin.reflect.jvm.internal.impl.c.a.c.h)object2).f().a((kotlin.reflect.jvm.internal.impl.c.a.e.w)object4);
            if (object4 == null) {
                kotlin.e.b.j.a();
            }
            collection2.add(object4);
        }
        collection = kotlin.a.m.b(collection, (List)collection2);
        ((kotlin.reflect.jvm.internal.impl.a.c.f)object).a(b2.a(), k2.q(), (List<as>)collection);
        ((kotlin.reflect.jvm.internal.impl.c.a.b.c)object).i(false);
        ((kotlin.reflect.jvm.internal.impl.c.a.b.c)object).j(b2.b());
        ((kotlin.reflect.jvm.internal.impl.a.c.o)object).a(e2.i_());
        ((kotlin.reflect.jvm.internal.impl.c.a.c.h)object2).e().g().a(l2, (kotlin.reflect.jvm.internal.impl.a.l)object);
        return object;
    }

    static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.b.f a(g g2, q q2, kotlin.reflect.jvm.internal.impl.j.w w2, w w3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            w2 = null;
        }
        return g2.a(q2, w2, w3);
    }

    private final kotlin.reflect.jvm.internal.impl.c.a.b.f a(q q2, kotlin.reflect.jvm.internal.impl.j.w object, w object2) {
        Object object3 = kotlin.reflect.jvm.internal.impl.c.a.c.f.a(this.j(), q2);
        object2 = kotlin.reflect.jvm.internal.impl.c.a.b.f.a(this.g(), (kotlin.reflect.jvm.internal.impl.a.a.h)object3, (w)((Object)object2), q2.q(), false, q2.r(), this.j().e().i().a(q2), false);
        object3 = kotlin.reflect.jvm.internal.impl.h.b.b((kotlin.reflect.jvm.internal.impl.a.ai)object2, kotlin.reflect.jvm.internal.impl.a.a.h.a.a());
        ((kotlin.reflect.jvm.internal.impl.a.c.y)object2).a((z)object3, null);
        if (object == null) {
            object = this.j();
            kotlin.e.b.j.a(object2, "propertyDescriptor");
            object = this.a(q2, kotlin.reflect.jvm.internal.impl.c.a.c.a.a((kotlin.reflect.jvm.internal.impl.c.a.c.h)object, (kotlin.reflect.jvm.internal.impl.a.m)object2, (x)q2, 0, 4, null));
        }
        ((kotlin.reflect.jvm.internal.impl.a.c.y)object2).a((kotlin.reflect.jvm.internal.impl.j.w)object, kotlin.a.m.a(), this.f(), (kotlin.reflect.jvm.internal.impl.j.w)null);
        ((z)object3).a((kotlin.reflect.jvm.internal.impl.j.w)object);
        kotlin.e.b.j.a(object2, "propertyDescriptor");
        return object2;
    }

    private final void a(Collection<am> collection, kotlin.reflect.jvm.internal.impl.e.f object, Collection<? extends am> object2, boolean bl2) {
        object = kotlin.reflect.jvm.internal.impl.c.a.a.a.a((kotlin.reflect.jvm.internal.impl.e.f)object, object2, collection, this.g(), this.j().e().f());
        if (!bl2) {
            kotlin.e.b.j.a(object, "additionalOverrides");
            collection.addAll((Collection<am>)object);
            return;
        }
        kotlin.e.b.j.a(object, "additionalOverrides");
        object = (Iterable)object;
        List<am> list = kotlin.a.m.b(collection, object);
        Collection collection2 = new ArrayList(kotlin.a.m.a(object, 10));
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object2 = (am)iterator.next();
            am am2 = (am)s.c((kotlin.reflect.jvm.internal.impl.a.b)object2);
            object = object2;
            if (am2 != null) {
                kotlin.e.b.j.a(object2, "resolvedOverride");
                object = this.a((am)object2, am2, (Collection<? extends am>)list);
            }
            collection2.add(object);
        }
        collection.addAll((List)collection2);
    }

    private final void a(List<kotlin.reflect.jvm.internal.impl.a.av> list, kotlin.reflect.jvm.internal.impl.a.l a2, int n2, q q2, kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.j.w w3) {
        kotlin.reflect.jvm.internal.impl.a.a a3 = a2;
        kotlin.reflect.jvm.internal.impl.a.a.h h2 = kotlin.reflect.jvm.internal.impl.a.a.h.a.a();
        kotlin.reflect.jvm.internal.impl.e.f f2 = q2.r();
        w2 = av.d(w2);
        kotlin.e.b.j.a((Object)w2, "TypeUtils.makeNotNullable(returnType)");
        boolean bl2 = q2.e();
        a2 = w3 != null ? av.d(w3) : null;
        list.add(new ah(a3, null, n2, h2, f2, w2, bl2, false, false, (kotlin.reflect.jvm.internal.impl.j.w)a2, this.j().e().i().a(q2)));
    }

    private final void a(Set<? extends kotlin.reflect.jvm.internal.impl.a.ai> object, Collection<kotlin.reflect.jvm.internal.impl.a.ai> collection, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> b2) {
        object = object.iterator();
        while (object.hasNext()) {
            kotlin.reflect.jvm.internal.impl.c.a.b.f f2 = this.d((kotlin.reflect.jvm.internal.impl.a.ai)object.next(), b2);
            if (f2 == null) continue;
            collection.add(f2);
            break;
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.e.f f2, Collection<? extends am> collection, Collection<? extends am> object, Collection<am> collection2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> b2) {
        object = object.iterator();
        while (object.hasNext()) {
            am am2 = (am)object.next();
            kotlin.reflect.jvm.internal.impl.l.a.a(collection2, this.a(am2, b2, f2, collection));
            kotlin.reflect.jvm.internal.impl.l.a.a(collection2, this.a(am2, b2, collection));
            kotlin.reflect.jvm.internal.impl.l.a.a(collection2, this.a(am2, b2));
        }
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.a.a a3) {
        j.a a4 = kotlin.reflect.jvm.internal.impl.h.j.a.a(a3, a2, true);
        kotlin.e.b.j.a((Object)a4, "OverridingUtil.DEFAULT.i\u2026erDescriptor, this, true)");
        return a4.b() == j.a.a.a && !l.a.a(a3, a2);
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean a(final am var1_1) {
        var3_2 = var1_1.h_();
        kotlin.e.b.j.a((Object)var3_2, "function.name");
        var3_2 = r.c((kotlin.reflect.jvm.internal.impl.e.f)var3_2);
        if (var3_2 instanceof Collection && ((Collection)var3_2).isEmpty()) {
            do {
                break;
            } while (true);
        } else {
            var3_2 = var3_2.iterator();
            do {
                if (!var3_2.hasNext()) ** continue;
                var4_4 = this.d((kotlin.reflect.jvm.internal.impl.e.f)var3_2.next());
                if (var4_4 instanceof Collection && ((Collection)var4_4).isEmpty()) {
                    do {
                        break;
                    } while (true);
                } else {
                    var4_4 = var4_4.iterator();
                    do {
                        if (!var4_4.hasNext()) ** continue;
                        var5_5 = (kotlin.reflect.jvm.internal.impl.a.ai)var4_4.next();
                        if (!this.c(var5_5, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends am>>(){

                            /*
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            @Override
                            public final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f list) {
                                kotlin.e.b.j.b(list, "accessorName");
                                if (kotlin.e.b.j.a((Object)var1_1.h_(), list)) {
                                    list = kotlin.a.m.a(var1_1);
                                    do {
                                        return list;
                                        break;
                                    } while (true);
                                }
                                list = kotlin.a.m.b(this.a(list), this.b(list));
                                return list;
                            }
                        })) continue;
                        if (var5_5.s() != false) return false;
                        if (n.b(var1_1.h_().a())) continue;
                        return false;
                    } while (!(var2_3 = false));
                    return false;
                }
                var2_3 = false;
            } while (!var2_3);
            return false;
        }
        var2_3 = false;
        if (var2_3) {
            return false;
        }
        if (this.c(var1_1) != false) return false;
        if (this.b(var1_1) != false) return false;
        if (this.d(var1_1) != false) return false;
        return true;
    }

    private final boolean a(am am2, t t2) {
        t t3 = t2;
        if (kotlin.reflect.jvm.internal.impl.c.a.c.a.c(am2)) {
            t3 = t2.s();
        }
        kotlin.e.b.j.a((Object)t3, "subDescriptorToCheck");
        return this.a((kotlin.reflect.jvm.internal.impl.a.a)t3, (kotlin.reflect.jvm.internal.impl.a.a)am2);
    }

    private final Collection<am> b(kotlin.reflect.jvm.internal.impl.e.f object) {
        Object object2 = this.c((kotlin.reflect.jvm.internal.impl.e.f)object);
        object = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object e2 = object2.next();
            am am2 = (am)e2;
            boolean bl2 = s.b(am2) || kotlin.reflect.jvm.internal.impl.c.a.d.a(am2) != null;
            if (bl2) continue;
            object.add(e2);
        }
        return (List)object;
    }

    private final am b(kotlin.reflect.jvm.internal.impl.a.ai ai2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object) {
        kotlin.reflect.jvm.internal.impl.e.f f2 = kotlin.reflect.jvm.internal.impl.e.f.a(n.d(ai2.h_().a()));
        kotlin.e.b.j.a((Object)f2, "Name.identifier(JvmAbi.s\u2026terName(name.asString()))");
        Iterator iterator = ((Iterable)object.a((kotlin.reflect.jvm.internal.impl.e.f)f2)).iterator();
        do {
            boolean bl2 = iterator.hasNext();
            object = null;
            f2 = null;
            if (!bl2) break;
            am am2 = (am)iterator.next();
            if (am2.i().size() != 1) {
                object = f2;
                continue;
            }
            Object object2 = am2.g();
            object = f2;
            if (object2 == null) continue;
            if (!KotlinBuiltIns.isUnit((kotlin.reflect.jvm.internal.impl.j.w)object2)) {
                object = f2;
                continue;
            }
            object2 = kotlin.reflect.jvm.internal.impl.j.a.c.a;
            object = am2.i();
            kotlin.e.b.j.a(object, "descriptor.valueParameters");
            kotlin.reflect.jvm.internal.impl.a.av av2 = kotlin.a.m.j(object);
            kotlin.e.b.j.a((Object)av2, "descriptor.valueParameters.single()");
            object = f2;
            if (!object2.b(av2.r(), ai2.r())) continue;
            object = am2;
        } while (object == null);
        return object;
    }

    private final void b(kotlin.reflect.jvm.internal.impl.e.f object, Collection<kotlin.reflect.jvm.internal.impl.a.ai> collection) {
        object = (q)kotlin.a.m.g((Iterable)((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).a((kotlin.reflect.jvm.internal.impl.e.f)object));
        if (object != null) {
            collection.add(g.a(this, (q)object, null, w.a, 2, null));
        }
    }

    private final boolean b(am am2) {
        boolean bl2;
        block4 : {
            Iterator iterator = kotlin.reflect.jvm.internal.impl.c.a.d.a;
            Iterator iterator2 = am2.h_();
            kotlin.e.b.j.a((Object)iterator2, "name");
            bl2 = ((kotlin.reflect.jvm.internal.impl.c.a.d)((Object)iterator)).a((kotlin.reflect.jvm.internal.impl.e.f)((Object)iterator2));
            boolean bl3 = false;
            if (!bl2) {
                return false;
            }
            iterator = am2.h_();
            kotlin.e.b.j.a((Object)iterator, "name");
            iterator2 = this.c((kotlin.reflect.jvm.internal.impl.e.f)((Object)iterator));
            iterator = new ArrayList();
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                t t2 = kotlin.reflect.jvm.internal.impl.c.a.d.a((am)iterator2.next());
                if (t2 == null) continue;
                iterator.add((t)t2);
            }
            if ((iterator = (Iterable)((List)((Object)iterator))) instanceof Collection && ((Collection)((Object)iterator)).isEmpty()) {
                return false;
            }
            iterator = iterator.iterator();
            do {
                bl2 = bl3;
                if (!iterator.hasNext()) break block4;
            } while (!this.b(am2, (t)iterator.next()));
            bl2 = true;
        }
        return bl2;
    }

    private final boolean b(am am2, t t2) {
        Object object = am2;
        boolean bl2 = false;
        object = kotlin.reflect.jvm.internal.impl.c.b.r.a((t)object, false, false, 2, null);
        t t3 = t2.s();
        kotlin.e.b.j.a((Object)t3, "builtinWithErasedParameters.original");
        boolean bl3 = bl2;
        if (kotlin.e.b.j.a(object, (Object)kotlin.reflect.jvm.internal.impl.c.b.r.a(t3, false, false, 2, null))) {
            bl3 = bl2;
            if (!this.a((kotlin.reflect.jvm.internal.impl.a.a)am2, (kotlin.reflect.jvm.internal.impl.a.a)t2)) {
                bl3 = true;
            }
        }
        return bl3;
    }

    private final Set<am> c(kotlin.reflect.jvm.internal.impl.e.f f2) {
        Object object = this.g().e();
        kotlin.e.b.j.a(object, "ownerDescriptor.typeConstructor");
        object = object.k_();
        kotlin.e.b.j.a(object, "ownerDescriptor.typeConstructor.supertypes");
        Object object2 = (Iterable)object;
        object = new LinkedHashSet();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            kotlin.a.m.a(object, (Iterable)((kotlin.reflect.jvm.internal.impl.j.w)object2.next()).b().b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.o));
        }
        return (Set)object;
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.a.ai ai2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object) {
        boolean bl2 = kotlin.reflect.jvm.internal.impl.c.a.c.a.c.a(ai2);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        am am2 = this.a(ai2, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)object);
        object = this.b(ai2, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)object);
        if (am2 == null) {
            return false;
        }
        if (!ai2.s()) {
            return true;
        }
        bl2 = bl3;
        if (object != null) {
            bl2 = bl3;
            if (object.m() == am2.m()) {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final boolean c(am am2) {
        boolean bl2;
        Iterator iterator = kotlin.reflect.jvm.internal.impl.c.a.c.a;
        Object object = am2.h_();
        kotlin.e.b.j.a(object, "name");
        iterator = ((kotlin.reflect.jvm.internal.impl.c.a.c)((Object)iterator)).b((kotlin.reflect.jvm.internal.impl.e.f)object);
        boolean bl3 = iterator instanceof Collection;
        boolean bl4 = false;
        if (bl3 && ((Collection)((Object)iterator)).isEmpty()) {
            return false;
        }
        iterator = iterator.iterator();
        do {
            bl3 = bl4;
            if (!iterator.hasNext()) return bl3;
            object = (kotlin.reflect.jvm.internal.impl.e.f)iterator.next();
            Object object2 = this.c((kotlin.reflect.jvm.internal.impl.e.f)object);
            Object object3 = new ArrayList();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object e2 = object2.next();
                if (!s.b((am)e2)) continue;
                object3.add(e2);
            }
            if ((object3 = (List)object3).isEmpty()) continue;
            object = this.a(am2, (kotlin.reflect.jvm.internal.impl.e.f)object);
            if ((object3 = (Iterable)object3) instanceof Collection && object3.isEmpty()) continue;
            object3 = object3.iterator();
            while (object3.hasNext()) {
                if (!this.a((am)object3.next(), (t)object)) continue;
                return true;
            }
        } while (!(bl2 = false));
        return true;
    }

    private final Set<kotlin.reflect.jvm.internal.impl.a.ai> d(kotlin.reflect.jvm.internal.impl.e.f f2) {
        Object object = this.g().e();
        kotlin.e.b.j.a(object, "ownerDescriptor.typeConstructor");
        object = object.k_();
        kotlin.e.b.j.a(object, "ownerDescriptor.typeConstructor.supertypes");
        Object object2 = (Iterable)object;
        object = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object object3 = ((kotlin.reflect.jvm.internal.impl.j.w)object2.next()).b().a(f2, kotlin.reflect.jvm.internal.impl.b.a.d.o);
            Collection collection = new ArrayList(kotlin.a.m.a(object3, 10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                collection.add((kotlin.reflect.jvm.internal.impl.a.ai)object3.next());
            }
            kotlin.a.m.a(object, (List)collection);
        }
        return kotlin.a.m.m((List)object);
    }

    private final kotlin.reflect.jvm.internal.impl.c.a.b.f d(kotlin.reflect.jvm.internal.impl.a.ai object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>> object2) {
        Object object3;
        boolean bl2 = this.c((kotlin.reflect.jvm.internal.impl.a.ai)object, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)object2);
        StringBuilder stringBuilder = null;
        kotlin.reflect.jvm.internal.impl.a.m m2 = null;
        if (!bl2) {
            return null;
        }
        am am2 = this.a((kotlin.reflect.jvm.internal.impl.a.ai)object, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)object2);
        if (am2 == null) {
            kotlin.e.b.j.a();
        }
        if (object.s()) {
            object2 = object3 = this.b((kotlin.reflect.jvm.internal.impl.a.ai)object, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)object2);
            if (object3 == null) {
                kotlin.e.b.j.a();
                object2 = object3;
            }
        } else {
            object2 = null;
        }
        boolean bl3 = object2 == null || object2.m() == am2.m();
        if (y.a && !bl3) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Different accessors modalities when creating overrides for ");
            stringBuilder.append(object);
            stringBuilder.append(" in ");
            stringBuilder.append(this.g());
            stringBuilder.append("for getter is ");
            stringBuilder.append((Object)am2.m());
            stringBuilder.append(", but for setter is ");
            object = m2;
            if (object2 != null) {
                object = object2.m();
            }
            stringBuilder.append(object);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        m2 = this.g();
        object3 = kotlin.reflect.jvm.internal.impl.a.a.h.a.a();
        Object object4 = am2.m();
        ba ba2 = am2.p();
        bl2 = object2 != null;
        m2 = kotlin.reflect.jvm.internal.impl.c.a.b.f.a(m2, (kotlin.reflect.jvm.internal.impl.a.a.h)object3, object4, ba2, bl2, object.h_(), am2.y(), false);
        object = am2.g();
        if (object == null) {
            kotlin.e.b.j.a();
        }
        ((kotlin.reflect.jvm.internal.impl.a.c.y)m2).a((kotlin.reflect.jvm.internal.impl.j.w)object, kotlin.a.m.a(), this.f(), (kotlin.reflect.jvm.internal.impl.j.w)null);
        object4 = (kotlin.reflect.jvm.internal.impl.a.ai)m2;
        object3 = kotlin.reflect.jvm.internal.impl.h.b.b((kotlin.reflect.jvm.internal.impl.a.ai)object4, am2.x(), false, false, false, am2.y());
        ((kotlin.reflect.jvm.internal.impl.a.c.x)object3).a(am2);
        kotlin.e.b.j.a((Object)m2, "propertyDescriptor");
        ((z)object3).a(((ai)m2).r());
        object = stringBuilder;
        if (object2 != null) {
            object = kotlin.reflect.jvm.internal.impl.h.b.a((kotlin.reflect.jvm.internal.impl.a.ai)object4, object2.x(), false, false, false, object2.p(), object2.y());
            ((kotlin.reflect.jvm.internal.impl.a.c.x)object).a((t)object2);
        }
        ((kotlin.reflect.jvm.internal.impl.a.c.y)m2).a((z)object3, (ak)object);
        return m2;
    }

    private final boolean d(am iterator) {
        boolean bl2;
        block3 : {
            boolean bl3;
            am am2 = this.e((am)((Object)iterator));
            bl2 = bl3 = false;
            if (am2 != null) {
                boolean bl4;
                am am3;
                iterator = iterator.h_();
                kotlin.e.b.j.a((Object)iterator, "name");
                iterator = this.c((kotlin.reflect.jvm.internal.impl.e.f)((Object)iterator));
                if (iterator instanceof Collection && ((Collection)((Object)iterator)).isEmpty()) {
                    return false;
                }
                iterator = iterator.iterator();
                do {
                    bl2 = bl3;
                    if (!iterator.hasNext()) break block3;
                } while (!(bl4 = (am3 = (am)iterator.next()).D() && this.a((kotlin.reflect.jvm.internal.impl.a.a)am2, (kotlin.reflect.jvm.internal.impl.a.a)am3)));
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final am e(am var1_1) {
        var2_2 = var1_1.i();
        kotlin.e.b.j.a(var2_2, "valueParameters");
        var3_3 = kotlin.a.m.i(var2_2);
        if (var3_3 == null) return null;
        var2_2 = var3_3.r().g().d();
        if (var2_2 == null || (var2_2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.m)var2_2)) == null) ** GOTO lbl-1000
        if (!var2_2.b()) {
            var2_2 = null;
        }
        if (var2_2 != null) {
            var2_2 = var2_2.c();
        } else lbl-1000: // 2 sources:
        {
            var2_2 = null;
        }
        var2_2 = SuspendFunctionTypesKt.isContinuation((kotlin.reflect.jvm.internal.impl.e.b)var2_2, this.j().e().s().a()) != false ? var3_3 : null;
        if (var2_2 == null) return null;
        var3_3 = var1_1.E();
        var1_1 = var1_1.i();
        kotlin.e.b.j.a(var1_1, "valueParameters");
        var1_1 = (am)var3_3.a(kotlin.a.m.d(var1_1, 1)).a(var2_2.r().a().get(0).c()).f();
        var2_2 = (ac)var1_1;
        if (var2_2 == null) return var1_1;
        var2_2.h(true);
        return var1_1;
    }

    private final kotlin.reflect.jvm.internal.impl.a.d k() {
        List<kotlin.reflect.jvm.internal.impl.a.av> list;
        boolean bl2 = this.h.h();
        if (this.h.g() && !bl2) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.a.e e2 = this.g();
        kotlin.reflect.jvm.internal.impl.c.a.b.c c2 = kotlin.reflect.jvm.internal.impl.c.a.b.c.b(e2, kotlin.reflect.jvm.internal.impl.a.a.h.a.a(), true, this.j().e().i().a(this.h));
        if (bl2) {
            kotlin.e.b.j.a((Object)c2, "constructorDescriptor");
            list = this.a(c2);
        } else {
            list = Collections.emptyList();
        }
        c2.j(false);
        c2.a(list, this.a(e2));
        c2.i(true);
        kotlin.e.b.j.a((Object)c2, "constructorDescriptor");
        c2.a(e2.i_());
        this.j().e().g().a((kotlin.reflect.jvm.internal.impl.c.a.e.l)this.h, c2);
        return c2;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.ai> a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        return super.a(f2, b2);
    }

    @Override
    protected k.a a(q object, List<? extends as> object2, kotlin.reflect.jvm.internal.impl.j.w object3, List<? extends kotlin.reflect.jvm.internal.impl.a.av> list) {
        kotlin.e.b.j.b(object, "method");
        kotlin.e.b.j.b(object2, "methodTypeParameters");
        kotlin.e.b.j.b(object3, "returnType");
        kotlin.e.b.j.b(list, "valueParameters");
        Object object4 = this.j().e().e().a((q)object, this.g(), (kotlin.reflect.jvm.internal.impl.j.w)object3, null, list, (List<as>)object2);
        kotlin.e.b.j.a(object4, "propagated");
        object = ((k.a)object4).a();
        kotlin.e.b.j.a(object, "propagated.returnType");
        object2 = ((k.a)object4).b();
        object3 = ((k.a)object4).c();
        kotlin.e.b.j.a(object3, "propagated.valueParameters");
        list = ((k.a)object4).d();
        kotlin.e.b.j.a(list, "propagated.typeParameters");
        boolean bl2 = ((k.a)object4).e();
        object4 = ((k.a)object4).f();
        kotlin.e.b.j.a(object4, "propagated.errors");
        return new k.a((kotlin.reflect.jvm.internal.impl.j.w)object, (kotlin.reflect.jvm.internal.impl.j.w)object2, (List<? extends kotlin.reflect.jvm.internal.impl.a.av>)object3, list, bl2, (List<String>)object4);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void a(Collection<am> collection, kotlin.reflect.jvm.internal.impl.e.f f2) {
        Object object;
        kotlin.e.b.j.b(collection, "result");
        kotlin.e.b.j.b(f2, "name");
        Collection<am> collection2 = this.c(f2);
        if (!kotlin.reflect.jvm.internal.impl.c.a.c.a.a(f2) && !kotlin.reflect.jvm.internal.impl.c.a.d.a.a(f2)) {
            boolean bl2;
            object = collection2;
            if (!(object instanceof Collection) || !((Collection)object).isEmpty()) {
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    if (!((t)iterator.next()).D()) continue;
                    bl2 = false;
                    break;
                }
            } else {
                bl2 = true;
            }
            if (bl2) {
                collection2 = new ArrayList();
                object = object.iterator();
                do {
                    if (!object.hasNext()) {
                        this.a(collection, f2, (List)collection2, false);
                        return;
                    }
                    Object e2 = object.next();
                    if (!this.a((am)e2)) continue;
                    collection2.add((am)e2);
                } while (true);
            }
        }
        object = kotlin.reflect.jvm.internal.impl.l.j.a.a();
        Collection collection3 = kotlin.reflect.jvm.internal.impl.c.a.a.a.a(f2, (Collection)collection2, kotlin.a.m.a(), this.g(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.p.b);
        kotlin.e.b.j.a(collection3, "mergedFunctionFromSuperTypes");
        g g2 = this;
        this.a(f2, collection, collection3, collection, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends am>>(g2){

            @Override
            public final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "p1");
                return ((g)this.a).a(f2);
            }

            @Override
            public final kotlin.reflect.e f() {
                return v.a(g.class);
            }

            @Override
            public final String g() {
                return "searchMethodsByNameWithoutBuiltinMagic";
            }

            @Override
            public final String h() {
                return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            }
        });
        this.a(f2, collection, collection3, (Collection)object, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends am>>(g2){

            @Override
            public final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "p1");
                return ((g)this.a).b(f2);
            }

            @Override
            public final kotlin.reflect.e f() {
                return v.a(g.class);
            }

            @Override
            public final String g() {
                return "searchMethodsInSupertypesWithoutBuiltinMagic";
            }

            @Override
            public final String h() {
                return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            }
        });
        Iterable iterable = collection2;
        collection2 = new ArrayList();
        Iterator iterator = iterable.iterator();
        do {
            if (!iterator.hasNext()) {
                this.a(collection, f2, kotlin.a.m.b((List)collection2, (Iterable)object), true);
                return;
            }
            Object t2 = iterator.next();
            if (!this.a((am)t2)) continue;
            collection2.add((am)t2);
        } while (true);
    }

    @Override
    protected void a(kotlin.reflect.jvm.internal.impl.e.f object, Collection<kotlin.reflect.jvm.internal.impl.a.ai> collection) {
        Set<kotlin.reflect.jvm.internal.impl.a.ai> set;
        kotlin.e.b.j.b(object, "name");
        kotlin.e.b.j.b(collection, "result");
        if (this.h.h()) {
            this.b((kotlin.reflect.jvm.internal.impl.e.f)object, collection);
        }
        if ((set = this.d((kotlin.reflect.jvm.internal.impl.e.f)object)).isEmpty()) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.l.j j2 = kotlin.reflect.jvm.internal.impl.l.j.a.a();
        this.a(set, collection, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends am>>(){

            @Override
            public final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "it");
                return this.a(f2);
            }
        });
        this.a(set, j2, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, ? extends Collection<? extends am>>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.f, Collection<? extends am>>(){

            @Override
            public final Collection<am> a(kotlin.reflect.jvm.internal.impl.e.f f2) {
                kotlin.e.b.j.b(f2, "it");
                return this.b(f2);
            }
        });
        object = kotlin.reflect.jvm.internal.impl.c.a.a.a.a((kotlin.reflect.jvm.internal.impl.e.f)object, (Collection)al.a(set, (Iterable)j2), collection, this.g(), this.j().e().f());
        kotlin.e.b.j.a(object, "resolveOverridesForNonSt\u2026rorReporter\n            )");
        collection.addAll((Collection<kotlin.reflect.jvm.internal.impl.a.ai>)object);
    }

    @Override
    protected boolean a(kotlin.reflect.jvm.internal.impl.c.a.b.e e2) {
        kotlin.e.b.j.b(e2, "$receiver");
        if (this.h.h()) {
            return false;
        }
        return this.a((am)e2);
    }

    @Override
    public Collection<am> b(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        return super.b(f2, b2);
    }

    protected HashSet<kotlin.reflect.jvm.internal.impl.e.f> b(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        Object object = this.g().e();
        kotlin.e.b.j.a(object, "ownerDescriptor.typeConstructor");
        object = object.k_();
        kotlin.e.b.j.a(object, "ownerDescriptor.typeConstructor.supertypes");
        Object object2 = (Iterable)object;
        object = new HashSet();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            kotlin.a.m.a(object, (Iterable)((kotlin.reflect.jvm.internal.impl.j.w)object2.next()).b().l_());
        }
        object = (HashSet)object;
        ((AbstractCollection)object).addAll((Collection)((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).a());
        ((AbstractCollection)object).addAll((Collection)this.d(d2, b2));
        return object;
    }

    public /* synthetic */ Set c(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b b2) {
        return this.b(d2, b2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        this.d(f2, b2);
        return (kotlin.reflect.jvm.internal.impl.a.h)this.f.a(f2);
    }

    protected kotlin.reflect.jvm.internal.impl.c.a.c.a.a c() {
        return new kotlin.reflect.jvm.internal.impl.c.a.c.a.a(this.h, a.a);
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> d(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        kotlin.e.b.j.b(d2, "kindFilter");
        return al.a((Set)this.d.a(), (Iterable)((Map)this.e.a()).keySet());
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.c.a.b d() {
        return this.c();
    }

    @Override
    public void d(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(b2, "location");
        kotlin.reflect.jvm.internal.impl.b.a.a(this.j().e().m(), b2, this.g(), f2);
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> e(kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> object2) {
        kotlin.e.b.j.b(object, "kindFilter");
        if (this.h.h()) {
            return this.l_();
        }
        object = new LinkedHashSet(((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).b());
        object2 = this.g().e();
        kotlin.e.b.j.a(object2, "ownerDescriptor.typeConstructor");
        object2 = object2.k_();
        kotlin.e.b.j.a(object2, "ownerDescriptor.typeConstructor.supertypes");
        object2 = ((Iterable)object2).iterator();
        while (object2.hasNext()) {
            Iterable iterable = ((kotlin.reflect.jvm.internal.impl.j.w)object2.next()).b().o_();
            kotlin.a.m.a((Collection)object, iterable);
        }
        return (Set)((Collection)object);
    }

    public final kotlin.reflect.jvm.internal.impl.i.f<List<kotlin.reflect.jvm.internal.impl.a.d>> e() {
        return this.b;
    }

    @Override
    protected kotlin.reflect.jvm.internal.impl.a.al f() {
        return kotlin.reflect.jvm.internal.impl.h.c.a((kotlin.reflect.jvm.internal.impl.a.m)this.g());
    }

    protected kotlin.reflect.jvm.internal.impl.a.e g() {
        return this.g;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.m h() {
        return this.g();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy Java member scope for ");
        stringBuilder.append(this.h.c());
        return stringBuilder.toString();
    }

}

