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
import kotlin.a.al;
import kotlin.e.b.j;
import kotlin.h.i;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.f;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.k;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.m;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.l.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.w;

public final class l
extends m {
    private final g b;
    private final f d;

    public l(h h2, g g2, f f2) {
        j.b(h2, "c");
        j.b(g2, "jClass");
        j.b(f2, "ownerDescriptor");
        super(h2);
        this.b = g2;
        this.d = f2;
    }

    private final <R> Set<R> a(final kotlin.reflect.jvm.internal.impl.a.e e2, final Set<R> set, final kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.h.e.h, ? extends Collection<? extends R>> b2) {
        kotlin.reflect.jvm.internal.impl.l.b.a((Collection)kotlin.a.m.a(e2), (b.b)d.a, new b.a<kotlin.reflect.jvm.internal.impl.a.e, w>(){

            public void a() {
            }

            @Override
            public boolean a(kotlin.reflect.jvm.internal.impl.a.e object) {
                j.b(object, "current");
                if (object == e2) {
                    return true;
                }
                if ((object = object.f_()) instanceof m) {
                    set.addAll((Collection)b2.a(object));
                    return false;
                }
                return true;
            }

            @Override
            public /* synthetic */ Object b() {
                this.a();
                return w.a;
            }
        });
        return set;
    }

    private final Set<am> a(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.a.e object) {
        if ((object = kotlin.reflect.jvm.internal.impl.c.a.b.i.a((kotlin.reflect.jvm.internal.impl.a.e)object)) != null) {
            return kotlin.a.m.m((Iterable)((k)object).b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.o));
        }
        return al.a();
    }

    private final ai a(ai object) {
        Object object2 = object.n();
        j.a(object2, "this.kind");
        if (((b.a)((Object)object2)).a()) {
            return object;
        }
        object = object.k();
        j.a(object, "this.overriddenDescriptors");
        object2 = (Iterable)object;
        object = new ArrayList(kotlin.a.m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            ai ai2 = (ai)object2.next();
            j.a((Object)ai2, "it");
            object.add(this.a(ai2));
        }
        return (ai)kotlin.a.m.j(kotlin.a.m.o((List)object));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void a(Collection<am> collection, kotlin.reflect.jvm.internal.impl.e.f object) {
        block2 : {
            Object object2;
            block4 : {
                block3 : {
                    j.b(collection, "result");
                    j.b(object, "name");
                    object2 = kotlin.reflect.jvm.internal.impl.c.a.a.a.b((kotlin.reflect.jvm.internal.impl.e.f)object, (Collection)this.a((kotlin.reflect.jvm.internal.impl.e.f)object, this.e()), collection, this.e(), this.j().e().f());
                    j.a(object2, "resolveOverridesForStati\u2026components.errorReporter)");
                    collection.addAll((Collection<am>)object2);
                    if (!this.b.i()) break block2;
                    if (!j.a(object, (Object)kotlin.reflect.jvm.internal.impl.h.c.b)) break block3;
                    object2 = kotlin.reflect.jvm.internal.impl.h.b.b(this.e());
                    object = "createEnumValueOfMethod(ownerDescriptor)";
                    break block4;
                }
                if (!j.a(object, (Object)kotlin.reflect.jvm.internal.impl.h.c.a)) break block2;
                object2 = kotlin.reflect.jvm.internal.impl.h.b.a(this.e());
                object = "createEnumValuesMethod(ownerDescriptor)";
            }
            j.a(object2, (String)object);
            collection.add((am)object2);
            return;
        }
    }

    @Override
    protected void a(kotlin.reflect.jvm.internal.impl.e.f object, Collection<ai> collection) {
        Iterator iterator;
        j.b(object, "name");
        j.b(collection, "result");
        ArrayList arrayList = this.a(this.e(), new LinkedHashSet(), (kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.h.e.h, Collection<? extends ai>>((kotlin.reflect.jvm.internal.impl.e.f)object){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.f a;
            {
                this.a = f2;
                super(1);
            }

            @Override
            public final Collection<ai> a(kotlin.reflect.jvm.internal.impl.h.e.h h2) {
                j.b(h2, "it");
                return h2.a(this.a, kotlin.reflect.jvm.internal.impl.b.a.d.o);
            }
        });
        if (collection.isEmpty() ^ true) {
            object = kotlin.reflect.jvm.internal.impl.c.a.a.a.b((kotlin.reflect.jvm.internal.impl.e.f)object, arrayList, collection, this.e(), this.j().e().f());
            j.a(object, "resolveOverridesForStati\u2026rorReporter\n            )");
            collection.addAll((Collection<ai>)object);
            return;
        }
        arrayList = arrayList;
        Map map = new LinkedHashMap();
        for (Object object2 : arrayList) {
            ai ai2 = this.a((ai)object2);
            iterator = map.get(ai2);
            arrayList = iterator;
            if (iterator == null) {
                arrayList = new ArrayList();
                map.put(ai2, arrayList);
            }
            ((List)arrayList).add(object2);
        }
        arrayList = new ArrayList();
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            kotlin.a.m.a(arrayList, (Iterable)kotlin.reflect.jvm.internal.impl.c.a.a.a.b((kotlin.reflect.jvm.internal.impl.e.f)object, (Collection)iterator.next().getValue(), collection, this.e(), this.j().e().f()));
        }
        collection.addAll(arrayList);
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> c(kotlin.reflect.jvm.internal.impl.h.e.d set, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> object) {
        j.b(set, "kindFilter");
        object = kotlin.a.m.p((Iterable)((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).a());
        set = kotlin.reflect.jvm.internal.impl.c.a.b.i.a(this.e());
        set = set != null ? ((k)((Object)set)).l_() : null;
        if (set == null) {
            set = al.a();
        }
        object.addAll((Collection)set);
        if (this.b.i()) {
            object.addAll((Collection)kotlin.a.m.b(kotlin.reflect.jvm.internal.impl.h.c.b, kotlin.reflect.jvm.internal.impl.h.c.a));
        }
        return object;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.h c(kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
        j.b(f2, "name");
        j.b(b2, "location");
        return null;
    }

    protected kotlin.reflect.jvm.internal.impl.c.a.c.a.a c() {
        return new kotlin.reflect.jvm.internal.impl.c.a.c.a.a(this.b, a.a);
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> d(kotlin.reflect.jvm.internal.impl.h.e.d d2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        j.b(d2, "kindFilter");
        return al.a();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.c.a.b d() {
        return this.c();
    }

    @Override
    protected Set<kotlin.reflect.jvm.internal.impl.e.f> e(kotlin.reflect.jvm.internal.impl.h.e.d object, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.f, Boolean> b2) {
        j.b(object, "kindFilter");
        object = kotlin.a.m.p((Iterable)((kotlin.reflect.jvm.internal.impl.c.a.c.a.b)this.i().a()).b());
        this.a(this.e(), (Set<R>)object, c.a);
        return object;
    }

    protected f e() {
        return this.d;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.m h() {
        return this.e();
    }

}

