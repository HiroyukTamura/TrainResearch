/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.o;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.c.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.i;
import kotlin.reflect.jvm.internal.impl.c.a.c.a.j;
import kotlin.reflect.jvm.internal.impl.c.a.c.f;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.l;
import kotlin.s;

public final class h
extends w {
    static final /* synthetic */ l[] a;
    private final kotlin.reflect.jvm.internal.impl.c.a.c.h b;
    private final kotlin.reflect.jvm.internal.impl.i.f c;
    private final d d;
    private final kotlin.reflect.jvm.internal.impl.i.f<List<kotlin.reflect.jvm.internal.impl.e.b>> e;
    private final kotlin.reflect.jvm.internal.impl.a.a.h f;
    private final kotlin.reflect.jvm.internal.impl.i.f g;
    private final kotlin.reflect.jvm.internal.impl.c.a.e.t h;

    static {
        a = new l[]{v.a(new t(v.a(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), v.a(new t(v.a(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    public h(kotlin.reflect.jvm.internal.impl.c.a.c.h object, kotlin.reflect.jvm.internal.impl.c.a.e.t t2) {
        kotlin.e.b.j.b(object, "outerContext");
        kotlin.e.b.j.b(t2, "jPackage");
        super(((kotlin.reflect.jvm.internal.impl.c.a.c.h)object).d(), t2.c());
        this.h = t2;
        this.b = kotlin.reflect.jvm.internal.impl.c.a.c.a.a((kotlin.reflect.jvm.internal.impl.c.a.c.h)object, this, null, 0, 6, null);
        this.c = this.b.c().a((kotlin.e.a.a)new kotlin.e.a.a<Map<String, ? extends n>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final Map<String, n> b() {
                o<Object, Object> o2 = this.b.e().k();
                Object object = this.f().a();
                kotlin.e.b.j.a(object, "fqName.asString()");
                o2 = o2.b((String)object);
                object = new ArrayList();
                Iterator iterator = o2.iterator();
                while (iterator.hasNext()) {
                    o2 = (String)iterator.next();
                    Object object2 = kotlin.reflect.jvm.internal.impl.h.d.b.a((String)((Object)o2));
                    kotlin.e.b.j.a(object2, "JvmClassName.byInternalName(partName)");
                    object2 = kotlin.reflect.jvm.internal.impl.e.a.a(((kotlin.reflect.jvm.internal.impl.h.d.b)object2).a());
                    kotlin.reflect.jvm.internal.impl.c.b.m m2 = this.b.e().c();
                    kotlin.e.b.j.a(object2, "classId");
                    o2 = (object2 = m2.a((kotlin.reflect.jvm.internal.impl.e.a)object2)) != null ? s.a(o2, object2) : null;
                    if (o2 == null) continue;
                    object.add(o2);
                }
                return af.a((List)object);
            }
        });
        this.d = new d(this.b, this.h, this);
        this.e = this.b.c().a((kotlin.e.a.a)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.impl.e.b>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<kotlin.reflect.jvm.internal.impl.e.b> b() {
                Object object = this.h.d();
                Collection collection = new ArrayList(m.a(object, 10));
                object = object.iterator();
                while (object.hasNext()) {
                    collection.add(((kotlin.reflect.jvm.internal.impl.c.a.e.t)object.next()).c());
                }
                return (List)collection;
            }
        }, m.a());
        object = this.b.e().p().a() ? kotlin.reflect.jvm.internal.impl.a.a.h.a.a() : f.a(this.b, this.h);
        this.f = object;
        this.g = this.b.c().a((kotlin.e.a.a)new kotlin.e.a.a<HashMap<kotlin.reflect.jvm.internal.impl.h.d.b, kotlin.reflect.jvm.internal.impl.h.d.b>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final HashMap<kotlin.reflect.jvm.internal.impl.h.d.b, kotlin.reflect.jvm.internal.impl.h.d.b> b() {
                HashMap<kotlin.reflect.jvm.internal.impl.h.d.b, kotlin.reflect.jvm.internal.impl.h.d.b> hashMap = new HashMap<kotlin.reflect.jvm.internal.impl.h.d.b, kotlin.reflect.jvm.internal.impl.h.d.b>();
                block4 : for (Map.Entry<String, n> entry : this.c().entrySet()) {
                    Object object2 = entry.getKey();
                    n n2 = entry.getValue();
                    object2 = kotlin.reflect.jvm.internal.impl.h.d.b.a((String)object2);
                    Object object = n2.d();
                    a.a a2 = ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).d();
                    switch (i.a[a2.ordinal()]) {
                        default: {
                            continue block4;
                        }
                        case 2: {
                            Map map = hashMap;
                            kotlin.e.b.j.a(object2, "partName");
                            map.put(object2, object2);
                            continue block4;
                        }
                        case 1: 
                    }
                    Map map = hashMap;
                    kotlin.e.b.j.a(object2, "partName");
                    if ((object = ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).a()) == null) continue;
                    object = kotlin.reflect.jvm.internal.impl.h.d.b.a((String)object);
                    kotlin.e.b.j.a(object, "JvmClassName.byInternalN\u2026: continue@kotlinClasses)");
                    map.put(object2, object);
                }
                return hashMap;
            }
        });
    }

    public final kotlin.reflect.jvm.internal.impl.a.e a(g g2) {
        kotlin.e.b.j.b(g2, "jClass");
        return this.d.c().a(g2);
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h a() {
        return this.h();
    }

    public final Map<String, n> c() {
        return (Map)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, a[0]);
    }

    public final List<kotlin.reflect.jvm.internal.impl.e.b> g() {
        return (List)this.e.a();
    }

    public d h() {
        return this.d;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy Java package fragment: ");
        stringBuilder.append(this.f());
        return stringBuilder.toString();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a.h x() {
        return this.f;
    }

    @Override
    public an y() {
        return new kotlin.reflect.jvm.internal.impl.c.b.o(this);
    }

}

