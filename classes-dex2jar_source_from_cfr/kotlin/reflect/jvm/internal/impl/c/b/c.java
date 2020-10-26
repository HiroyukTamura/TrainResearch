/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.a.d;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.c.b.m;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b.i;
import kotlin.reflect.jvm.internal.impl.h.b.j;
import kotlin.reflect.jvm.internal.impl.h.b.l;
import kotlin.reflect.jvm.internal.impl.h.b.p;
import kotlin.reflect.jvm.internal.impl.h.b.r;
import kotlin.reflect.jvm.internal.impl.h.b.t;
import kotlin.reflect.jvm.internal.impl.h.b.u;
import kotlin.reflect.jvm.internal.impl.h.b.v;
import kotlin.reflect.jvm.internal.impl.h.b.w;
import kotlin.reflect.jvm.internal.impl.h.b.x;
import kotlin.reflect.jvm.internal.impl.j.ad;

public final class c
extends kotlin.reflect.jvm.internal.impl.c.b.a<kotlin.reflect.jvm.internal.impl.a.a.c, kotlin.reflect.jvm.internal.impl.h.b.f<?>, g> {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.d b;
    private final y c;
    private final aa d;

    public c(y y2, aa aa2, kotlin.reflect.jvm.internal.impl.i.i i2, m m2) {
        kotlin.e.b.j.b(y2, "module");
        kotlin.e.b.j.b(aa2, "notFoundClasses");
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(m2, "kotlinClassFinder");
        super(i2, m2);
        this.c = y2;
        this.d = aa2;
        this.b = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(this.c, this.d);
    }

    @Override
    private final kotlin.reflect.jvm.internal.impl.a.e a(kotlin.reflect.jvm.internal.impl.e.a a2) {
        return s.a(this.c, a2, this.d);
    }

    @Override
    public /* synthetic */ Object a(String string2, Object object) {
        return this.b(string2, object);
    }

    @Override
    public /* synthetic */ Object a(a.a a2, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        return this.b(a2, c2);
    }

    @Override
    protected List<g> a(List<? extends kotlin.reflect.jvm.internal.impl.a.a.c> collection) {
        kotlin.e.b.j.b(collection, "annotations");
        Object object = collection;
        collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add((kotlin.reflect.jvm.internal.impl.a.a.c)((Object)new g((kotlin.reflect.jvm.internal.impl.a.a.c)object.next(), null)));
        }
        return collection;
    }

    @Override
    protected List<g> a(List<? extends kotlin.reflect.jvm.internal.impl.a.a.c> collection, List<? extends kotlin.reflect.jvm.internal.impl.a.a.c> collection2, e e2) {
        kotlin.e.b.j.b(collection, "propertyAnnotations");
        kotlin.e.b.j.b(collection2, "fieldAnnotations");
        kotlin.e.b.j.b((Object)e2, "fieldUseSiteTarget");
        Iterator iterator = collection;
        collection = new ArrayList(kotlin.a.m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            collection.add((kotlin.reflect.jvm.internal.impl.a.a.c)((Object)new g((kotlin.reflect.jvm.internal.impl.a.a.c)iterator.next(), null)));
        }
        collection = collection;
        iterator = collection2;
        collection2 = new ArrayList(kotlin.a.m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            collection2.add((kotlin.reflect.jvm.internal.impl.a.a.c)((Object)new g((kotlin.reflect.jvm.internal.impl.a.a.c)iterator.next(), e2)));
        }
        return kotlin.a.m.b(collection, (Iterable)collection2);
    }

    @Override
    protected n.a a(kotlin.reflect.jvm.internal.impl.e.a a2, an an2, List<kotlin.reflect.jvm.internal.impl.a.a.c> list) {
        kotlin.e.b.j.b(a2, "annotationClassId");
        kotlin.e.b.j.b(an2, "source");
        kotlin.e.b.j.b(list, "result");
        return new n.a(this.a(a2), list, an2){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.e b;
            final /* synthetic */ List c;
            final /* synthetic */ an d;
            private final HashMap<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> e = new HashMap();
            {
                this.b = e2;
                this.c = list;
                this.d = an2;
            }

            private final kotlin.reflect.jvm.internal.impl.h.b.f<?> b(f f2, Object object) {
                if ((object = kotlin.reflect.jvm.internal.impl.h.b.g.a.a(object)) != null) {
                    return object;
                }
                object = j.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported annotation argument: ");
                stringBuilder.append(f2);
                return ((j.a)object).a(stringBuilder.toString());
            }

            @Override
            public n.a a(f f2, kotlin.reflect.jvm.internal.impl.e.a object) {
                kotlin.e.b.j.b(f2, "name");
                kotlin.e.b.j.b(object, "classId");
                ArrayList arrayList = new ArrayList();
                c c2 = this;
                an an2 = an.a;
                kotlin.e.b.j.a((Object)an2, "SourceElement.NO_SOURCE");
                object = c2.a((kotlin.reflect.jvm.internal.impl.e.a)object, an2, arrayList);
                if (object == null) {
                    kotlin.e.b.j.a();
                }
                return new n.a((n.a)object, f2, arrayList){
                    final /* synthetic */ n.a b;
                    final /* synthetic */ f c;
                    final /* synthetic */ ArrayList d;
                    private final /* synthetic */ n.a e;
                    {
                        this.b = a3;
                        this.c = f2;
                        this.d = arrayList;
                        this.e = a3;
                    }

                    @Override
                    public n.a a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2) {
                        kotlin.e.b.j.b(f2, "name");
                        kotlin.e.b.j.b(a2, "classId");
                        return this.e.a(f2, a2);
                    }

                    @Override
                    public n.b a(f f2) {
                        kotlin.e.b.j.b(f2, "name");
                        return this.e.a(f2);
                    }

                    @Override
                    public void a() {
                        this.b.a();
                        ((Map)this.e).put(this.c, new kotlin.reflect.jvm.internal.impl.h.b.a((kotlin.reflect.jvm.internal.impl.a.a.c)kotlin.a.m.j(this.d)));
                    }

                    @Override
                    public void a(f f2, Object object) {
                        this.e.a(f2, object);
                    }

                    @Override
                    public void a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2, f f3) {
                        kotlin.e.b.j.b(f2, "name");
                        kotlin.e.b.j.b(a2, "enumClassId");
                        kotlin.e.b.j.b(f3, "enumEntryName");
                        this.e.a(f2, a2, f3);
                    }
                };
            }

            @Override
            public n.b a(final f f2) {
                kotlin.e.b.j.b(f2, "name");
                return new n.b(){
                    private final ArrayList<kotlin.reflect.jvm.internal.impl.h.b.f<?>> c = new ArrayList();

                    @Override
                    public void a() {
                        kotlin.reflect.jvm.internal.impl.a.a.a a2 = kotlin.reflect.jvm.internal.impl.c.a.a.a.a(f2, this.b);
                        if (a2 != null) {
                            Map map = this.e;
                            f f22 = f2;
                            kotlin.reflect.jvm.internal.impl.h.b.g g2 = kotlin.reflect.jvm.internal.impl.h.b.g.a;
                            List<kotlin.reflect.jvm.internal.impl.h.b.f<?>> list = kotlin.reflect.jvm.internal.impl.l.a.a(this.c);
                            a2 = a2.r();
                            kotlin.e.b.j.a((Object)a2, "parameter.type");
                            map.put(f22, g2.a(list, (kotlin.reflect.jvm.internal.impl.j.w)a2));
                        }
                    }

                    @Override
                    public void a(Object object) {
                        this.c.add(this.b(f2, object));
                    }

                    @Override
                    public void a(kotlin.reflect.jvm.internal.impl.e.a a2, f f22) {
                        kotlin.e.b.j.b(a2, "enumClassId");
                        kotlin.e.b.j.b(f22, "enumEntryName");
                        this.c.add(new i(a2, f22));
                    }
                };
            }

            @Override
            public void a() {
                this.c.add(new d(this.b.i_(), (Map)this.e, this.d));
            }

            @Override
            public void a(f f2, Object object) {
                if (f2 != null) {
                    ((Map)this.e).put(f2, this.b(f2, object));
                }
            }

            @Override
            public void a(f f2, kotlin.reflect.jvm.internal.impl.e.a a2, f f3) {
                kotlin.e.b.j.b(f2, "name");
                kotlin.e.b.j.b(a2, "enumClassId");
                kotlin.e.b.j.b(f3, "enumEntryName");
                ((Map)this.e).put(f2, new i(a2, f3));
            }

        };
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.h.b.f<?> x2) {
        void var1_3;
        kotlin.e.b.j.b(x2, "constant");
        if (x2 instanceof kotlin.reflect.jvm.internal.impl.h.b.d) {
            t t2 = new t(((Number)((kotlin.reflect.jvm.internal.impl.h.b.d)((Object)x2)).a()).byteValue());
            do {
                return (kotlin.reflect.jvm.internal.impl.h.b.f)var1_3;
                break;
            } while (true);
        }
        if (x2 instanceof r) {
            w w2 = new w(((Number)((r)((Object)x2)).a()).shortValue());
            return (kotlin.reflect.jvm.internal.impl.h.b.f)var1_3;
        }
        if (x2 instanceof l) {
            u u2 = new u(((Number)((l)((Object)x2)).a()).intValue());
            return (kotlin.reflect.jvm.internal.impl.h.b.f)var1_3;
        }
        if (!(x2 instanceof p)) return x2;
        v v2 = new v(((Number)((p)((Object)x2)).a()).longValue());
        return (kotlin.reflect.jvm.internal.impl.h.b.f)var1_3;
    }

    protected kotlin.reflect.jvm.internal.impl.a.a.c b(a.a a2, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        kotlin.e.b.j.b(a2, "proto");
        kotlin.e.b.j.b(c2, "nameResolver");
        return this.b.a(a2, c2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected kotlin.reflect.jvm.internal.impl.h.b.f<?> b(String string2, Object object) {
        kotlin.e.b.j.b(string2, "desc");
        kotlin.e.b.j.b(object, "initializer");
        CharSequence charSequence = "ZBCS";
        CharSequence charSequence2 = string2;
        boolean bl2 = false;
        Object object2 = object;
        if (!kotlin.i.n.b(charSequence, charSequence2, false, 2, null)) return kotlin.reflect.jvm.internal.impl.h.b.g.a.a(object2);
        int n2 = (Integer)object;
        int n3 = string2.hashCode();
        if (n3 != 83) {
            if (n3 != 90) {
                switch (n3) {
                    default: {
                        throw (Throwable)((Object)new AssertionError((Object)string2));
                    }
                    case 67: {
                        if (!string2.equals("C")) throw (Throwable)((Object)new AssertionError((Object)string2));
                        object2 = Character.valueOf((char)n2);
                        return kotlin.reflect.jvm.internal.impl.h.b.g.a.a(object2);
                    }
                    case 66: {
                        if (!string2.equals("B")) throw (Throwable)((Object)new AssertionError((Object)string2));
                        object2 = (byte)n2;
                        return kotlin.reflect.jvm.internal.impl.h.b.g.a.a(object2);
                    }
                }
            }
            if (!string2.equals("Z")) throw (Throwable)((Object)new AssertionError((Object)string2));
            if (n2 != 0) {
                bl2 = true;
            }
            object2 = bl2;
            return kotlin.reflect.jvm.internal.impl.h.b.g.a.a(object2);
        }
        if (!string2.equals("S")) throw (Throwable)((Object)new AssertionError((Object)string2));
        object2 = (short)n2;
        return kotlin.reflect.jvm.internal.impl.h.b.g.a.a(object2);
    }

}

