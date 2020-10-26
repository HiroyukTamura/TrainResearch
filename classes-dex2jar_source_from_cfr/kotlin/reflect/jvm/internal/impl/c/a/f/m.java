/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ab;
import kotlin.a.af;
import kotlin.a.g;
import kotlin.e.a.b;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.c.a.f.d;
import kotlin.reflect.jvm.internal.impl.c.a.f.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.r;
import kotlin.reflect.jvm.internal.impl.c.b.u;
import kotlin.reflect.jvm.internal.impl.h.d.c;
import kotlin.s;
import kotlin.w;

final class m {
    private final Map<String, j> a = new LinkedHashMap();

    public final Map<String, j> a() {
        return this.a;
    }

    public final class kotlin.reflect.jvm.internal.impl.c.a.f.m$a {
        private final String b;

        public kotlin.reflect.jvm.internal.impl.c.a.f.m$a(String string2) {
            kotlin.e.b.j.b(string2, "className");
            this.b = string2;
        }

        public final String a() {
            return this.b;
        }

        public final void a(String o2, b<? super a, w> b2) {
            kotlin.e.b.j.b(o2, "name");
            kotlin.e.b.j.b(b2, "block");
            Map map = m.this.a;
            o2 = new a((String)((Object)o2));
            b2.a((a)((Object)o2));
            o2 = ((a)((Object)o2)).a();
            map.put(o2.a(), o2.b());
        }

        public final class a {
            private final List<o<String, r>> b;
            private o<String, r> c;
            private final String d;

            public a(String string2) {
                kotlin.e.b.j.b(string2, "functionName");
                this.d = string2;
                this.b = new ArrayList();
                this.c = s.a("V", null);
            }

            public final o<String, j> a() {
                Object object = u.a;
                Object object2 = a.this.a();
                Object object3 = this.d;
                Object object4 = this.b;
                Object object5 = new ArrayList(kotlin.a.m.a(object4, 10));
                object4 = object4.iterator();
                while (object4.hasNext()) {
                    object5.add((String)((o)object4.next()).a());
                }
                object = ((u)object).a((String)object2, ((u)object).a((String)object3, (List)object5, this.c.a()));
                object2 = this.c.b();
                object5 = this.b;
                object3 = new ArrayList(kotlin.a.m.a(object5, 10));
                object5 = object5.iterator();
                while (object5.hasNext()) {
                    object3.add((r)((o)object5.next()).b());
                }
                return s.a(object, new j((r)object2, (List)object3));
            }

            public final /* varargs */ void a(String string2, d ... object) {
                kotlin.e.b.j.b(string2, "type");
                kotlin.e.b.j.b(object, "qualifiers");
                Collection collection = this.b;
                boolean bl2 = ((d[])object).length == 0;
                if (bl2) {
                    object = null;
                } else {
                    Object object2 = g.k(object);
                    object = new LinkedHashMap(kotlin.g.d.c(af.a(kotlin.a.m.a(object2, 10)), 16));
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        ab ab2 = (ab)object2.next();
                        object.put(ab2.a(), (d)ab2.b());
                    }
                    object = new r((Map<Integer, d>)object);
                }
                collection.add(s.a(string2, object));
            }

            public final void a(c c2) {
                kotlin.e.b.j.b((Object)c2, "type");
                this.c = s.a(c2.c(), null);
            }

            public final /* varargs */ void b(String string2, d ... object) {
                kotlin.e.b.j.b(string2, "type");
                kotlin.e.b.j.b(object, "qualifiers");
                Object object2 = g.k(object);
                object = new LinkedHashMap(kotlin.g.d.c(af.a(kotlin.a.m.a(object2, 10)), 16));
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    ab ab2 = (ab)object2.next();
                    object.put(ab2.a(), (d)ab2.b());
                }
                this.c = s.a(string2, new r((Map<Integer, d>)object));
            }
        }

    }

}

