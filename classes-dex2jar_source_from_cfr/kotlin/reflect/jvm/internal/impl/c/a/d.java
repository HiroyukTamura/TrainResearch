/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.c.a.q;
import kotlin.reflect.jvm.internal.impl.c.b.r;
import kotlin.reflect.jvm.internal.impl.c.b.u;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.s;

public final class d {
    public static final d a;
    private static final List<q> b;
    private static final List<String> c;
    private static final List<String> d;
    private static final Map<q, b> e;
    private static final Map<String, b> f;
    private static final Set<f> g;
    private static final Set<String> h;

    static {
        Object object;
        Iterator iterator3;
        a = new d();
        Object object2 = al.a("containsAll", "removeAll", "retainAll");
        Iterator iterator2 = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            iterator3 = (String)object2.next();
            object = kotlin.reflect.jvm.internal.impl.h.d.c.a.c();
            j.a(object, "JvmPrimitiveType.BOOLEAN.desc");
            iterator2.add(kotlin.reflect.jvm.internal.impl.c.a.s.a("java/util/Collection", (String)((Object)iterator3), "Ljava/util/Collection;", (String)object));
        }
        b = (List)((Object)iterator2);
        object2 = b;
        iterator2 = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            iterator2.add(((q)object2.next()).b());
        }
        c = (List)((Object)iterator2);
        object2 = b;
        iterator2 = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            iterator2.add(((q)object2.next()).a().a());
        }
        d = (List)((Object)iterator2);
        iterator2 = u.a;
        object2 = ((u)((Object)iterator2)).b("Collection");
        iterator3 = kotlin.reflect.jvm.internal.impl.h.d.c.a.c();
        j.a((Object)iterator3, "JvmPrimitiveType.BOOLEAN.desc");
        object2 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object2, "contains", "Ljava/lang/Object;", (String)((Object)iterator3)), b.c);
        iterator3 = ((u)((Object)iterator2)).b("Collection");
        object = kotlin.reflect.jvm.internal.impl.h.d.c.a.c();
        j.a(object, "JvmPrimitiveType.BOOLEAN.desc");
        iterator3 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)((Object)iterator3), "remove", "Ljava/lang/Object;", (String)object), b.c);
        object = ((u)((Object)iterator2)).b("Map");
        Object object3 = kotlin.reflect.jvm.internal.impl.h.d.c.a.c();
        j.a(object3, "JvmPrimitiveType.BOOLEAN.desc");
        object = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object, "containsKey", "Ljava/lang/Object;", (String)object3), b.c);
        object3 = ((u)((Object)iterator2)).b("Map");
        Object object4 = kotlin.reflect.jvm.internal.impl.h.d.c.a.c();
        j.a(object4, "JvmPrimitiveType.BOOLEAN.desc");
        object3 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object3, "containsValue", "Ljava/lang/Object;", (String)object4), b.c);
        object4 = ((u)((Object)iterator2)).b("Map");
        Object object5 = kotlin.reflect.jvm.internal.impl.h.d.c.a.c();
        j.a(object5, "JvmPrimitiveType.BOOLEAN.desc");
        object4 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object4, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)object5), b.c);
        object5 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a(((u)((Object)iterator2)).b("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.d);
        o<q, b> o2 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a(((u)((Object)iterator2)).b("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.a);
        o<q, b> o3 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a(((u)((Object)iterator2)).b("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.a);
        Object object6 = ((u)((Object)iterator2)).b("List");
        String string2 = kotlin.reflect.jvm.internal.impl.h.d.c.e.c();
        j.a((Object)string2, "JvmPrimitiveType.INT.desc");
        object6 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object6, "indexOf", "Ljava/lang/Object;", string2), b.b);
        iterator2 = ((u)((Object)iterator2)).b("List");
        string2 = kotlin.reflect.jvm.internal.impl.h.d.c.e.c();
        j.a((Object)string2, "JvmPrimitiveType.INT.desc");
        e = af.a(new o[]{object2, iterator3, object, object3, object4, object5, o2, o3, object6, s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)((Object)iterator2), "lastIndexOf", "Ljava/lang/Object;", string2), b.b)});
        object2 = e;
        iterator2 = new LinkedHashMap(af.a(object2.size()));
        for (Iterator iterator3 : (Iterable)object2.entrySet()) {
            iterator2.put(((q)iterator3.getKey()).b(), iterator3.getValue());
        }
        f = iterator2;
        iterator2 = al.a(e.keySet(), (Iterable)b);
        object2 = new ArrayList(m.a(iterator2, 10));
        iterator3 = iterator2.iterator();
        while (iterator3.hasNext()) {
            object2.add(((q)iterator3.next()).a());
        }
        g = m.m((List)object2);
        object2 = new ArrayList(m.a(iterator2, 10));
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2.add(((q)iterator2.next()).b());
        }
        h = m.m((List)object2);
    }

    private d() {
    }

    public static final t a(t t2) {
        j.b(t2, "functionDescriptor");
        d d2 = a;
        f f2 = t2.h_();
        j.a((Object)f2, "functionDescriptor.name");
        if (!d2.a(f2)) {
            return null;
        }
        return (t)kotlin.reflect.jvm.internal.impl.h.c.a.a(t2, false, c.a, 1, null);
    }

    public static final a a(kotlin.reflect.jvm.internal.impl.a.b object) {
        j.b(object, "$receiver");
        if (!g.contains(object.h_())) {
            return null;
        }
        if ((object = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.b)object, false, d.a, 1, null)) != null && (object = r.b((kotlin.reflect.jvm.internal.impl.a.a)object)) != null) {
            if (c.contains(object)) {
                return a.a;
            }
            if ((object = f.get(object)) == null) {
                j.a();
            }
            if ((b)((Object)object) == b.a) {
                return a.c;
            }
            return a.b;
        }
        return null;
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.a.b b2) {
        return m.a((Iterable)h, r.b(b2));
    }

    public final boolean a(f f2) {
        j.b(f2, "$receiver");
        return g.contains(f2);
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        public static final /* enum */ a c;
        private static final /* synthetic */ a[] d;
        private final String e;
        private final boolean f;

        static {
            a a2;
            a a3;
            a a4;
            a = a3 = new a("Ljava/util/Collection<+Ljava/lang/Object;>;", false);
            b = a2 = new a(null, true);
            c = a4 = new a("Ljava/lang/Object;", true);
            d = new a[]{a3, a2, a4};
        }

        protected a(String string3, boolean bl2) {
            this.e = string3;
            this.f = bl2;
        }

        public static a valueOf(String string2) {
            return Enum.valueOf(a.class, string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        private static final /* synthetic */ b[] e;
        private final Object f;

        static {
            b b2;
            b b3;
            b b4;
            a = b4 = new b(null);
            b = b2 = new b(-1);
            c = b3 = new b(false);
            a a2 = new a("MAP_GET_OR_DEFAULT", 3);
            d = a2;
            e = new b[]{b4, b2, b3, a2};
        }

        protected b(Object object) {
            this.f = object;
        }

        public static b valueOf(String string2) {
            return Enum.valueOf(b.class, string2);
        }

        public static b[] values() {
            return (b[])e.clone();
        }

        public static final class a
        extends b {
            a() {
            }
        }

    }

}

