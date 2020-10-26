/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.i;
import kotlin.reflect.jvm.internal.impl.h.e.j;
import kotlin.reflect.jvm.internal.impl.h.h;
import kotlin.reflect.jvm.internal.impl.h.j;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.l;

public abstract class e
extends i {
    static final /* synthetic */ l[] b;
    private final kotlin.reflect.jvm.internal.impl.i.f a;
    private final kotlin.reflect.jvm.internal.impl.a.e d;

    static {
        b = new l[]{v.a(new kotlin.e.b.t(v.a(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public e(kotlin.reflect.jvm.internal.impl.i.i i2, kotlin.reflect.jvm.internal.impl.a.e e2) {
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(e2, "containingClass");
        this.d = e2;
        this.a = i2.a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.a.m>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.a.m> b() {
                List<t> list = this.a();
                return m.b((Collection)list, this.a(list));
            }
        });
    }

    private final List<kotlin.reflect.jvm.internal.impl.a.m> a(List<? extends t> list) {
        Object object;
        Iterator iterator;
        final ArrayList arrayList = new ArrayList(3);
        an collection22 = this.d.e();
        kotlin.e.b.j.a((Object)collection22, "containingClass.typeConstructor");
        Collection<w> collection = collection22.k_();
        kotlin.e.b.j.a(collection, "containingClass.typeConstructor.supertypes");
        Iterator<Object> iterator2 = collection;
        Collection collection2 = new ArrayList();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            m.a(collection2, j.a.a(((w)iterator2.next()).b(), null, null, 3, null));
        }
        iterator2 = (List)collection2;
        Collection collection3 = new ArrayList();
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if (!(object instanceof kotlin.reflect.jvm.internal.impl.a.b)) continue;
            collection3.add(object);
        }
        Iterable iterable = (List)collection3;
        object = new LinkedHashMap();
        for (Object object2 : iterable) {
            void var3_11;
            iterator = ((kotlin.reflect.jvm.internal.impl.a.b)object2).h_();
            Iterator<Object> iterator3 = iterator2 = object.get(iterator);
            if (iterator2 == null) {
                ArrayList arrayList2 = new ArrayList();
                object.put(iterator, arrayList2);
            }
            ((List)var3_11).add(object2);
        }
        for (Map.Entry entry : object.entrySet()) {
            Object object2;
            f f2 = (f)entry.getKey();
            Iterable iterable2 = (List)entry.getValue();
            object2 = new LinkedHashMap();
            for (Object e2 : iterable2) {
                void var3_18;
                Boolean bl2 = (kotlin.reflect.jvm.internal.impl.a.b)e2 instanceof t;
                Iterator<Object> iterator4 = iterator2 = object2.get(bl2);
                if (iterator2 == null) {
                    ArrayList arrayList3 = new ArrayList();
                    object2.put(bl2, arrayList3);
                }
                ((List)var3_18).add(e2);
            }
            iterator2 = object2.entrySet().iterator();
            while (iterator2.hasNext()) {
                void var3_24;
                Map.Entry entry2 = (Map.Entry)iterator2.next();
                boolean bl3 = (Boolean)entry2.getKey();
                object2 = (List)entry2.getValue();
                if (bl3) {
                    iterator = list;
                    Collection collection4 = new ArrayList();
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        Object t2 = iterator.next();
                        if (!kotlin.e.b.j.a((Object)((t)t2).h_(), (Object)f2)) continue;
                        collection4.add(t2);
                    }
                    List list2 = (List)collection4;
                } else {
                    List list3 = m.a();
                }
                j.a(f2, (Collection<? extends kotlin.reflect.jvm.internal.impl.a.b>)object2, (Collection)var3_24, this.d, new h(){

                    @Override
                    public void a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                        kotlin.e.b.j.b(b2, "fakeOverride");
                        j.a(b2, null);
                        arrayList.add(b2);
                    }

                    @Override
                    protected void a(kotlin.reflect.jvm.internal.impl.a.b b2, kotlin.reflect.jvm.internal.impl.a.b b3) {
                        kotlin.e.b.j.b(b2, "fromSuper");
                        kotlin.e.b.j.b(b3, "fromCurrent");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Conflict in scope of ");
                        stringBuilder.append(this.c());
                        stringBuilder.append(": ");
                        stringBuilder.append(b2);
                        stringBuilder.append(" vs ");
                        stringBuilder.append(b3);
                        throw (Throwable)new IllegalStateException(stringBuilder.toString().toString());
                    }
                });
            }
        }
        return kotlin.reflect.jvm.internal.impl.l.a.a(arrayList);
    }

    private final List<kotlin.reflect.jvm.internal.impl.a.m> d() {
        return (List)kotlin.reflect.jvm.internal.impl.i.h.a(this.a, (Object)this, b[0]);
    }

    @Override
    public Collection<ai> a(f f2, kotlin.reflect.jvm.internal.impl.b.a.b object) {
        Object object2;
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(object, "location");
        Iterator iterator = this.d();
        object = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (!(object2 instanceof ai)) continue;
            object.add(object2);
        }
        iterator = (List)object;
        object = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (!kotlin.e.b.j.a((Object)((ai)object2).h_(), (Object)f2)) continue;
            object.add(object2);
        }
        return (List)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.m> a(d list, kotlin.e.a.b<? super f, Boolean> b2) {
        kotlin.e.b.j.b(list, "kindFilter");
        kotlin.e.b.j.b(b2, "nameFilter");
        if (!((d)((Object)list)).a(d.b.a())) {
            list = m.a();
            do {
                return list;
                break;
            } while (true);
        }
        list = this.d();
        return list;
    }

    protected abstract List<t> a();

    @Override
    public Collection<am> b(f f2, kotlin.reflect.jvm.internal.impl.b.a.b object) {
        Object object2;
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b(object, "location");
        Iterator<T> iterator = this.d();
        object = new ArrayList<E>();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (!(object2 instanceof am)) continue;
            object.add(object2);
        }
        iterator = (List)object;
        object = new ArrayList<E>();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (!kotlin.e.b.j.a((Object)((am)object2).h_(), (Object)f2)) continue;
            object.add(object2);
        }
        return (List)object;
    }

    protected final kotlin.reflect.jvm.internal.impl.a.e c() {
        return this.d;
    }

}

