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
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.q;
import kotlin.reflect.jvm.internal.impl.c.b.r;
import kotlin.reflect.jvm.internal.impl.c.b.u;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.s;
import kotlin.t;

public final class c {
    public static final c a = new c();
    private static final q b;
    private static final Map<q, f> c;
    private static final Map<String, f> d;
    private static final List<f> e;
    private static final Map<f, List<f>> f;

    static {
        Object object = kotlin.reflect.jvm.internal.impl.h.d.c.e.c();
        j.a(object, "JvmPrimitiveType.INT.desc");
        b = kotlin.reflect.jvm.internal.impl.c.a.s.a("java/util/List", "removeAt", (String)object, "Ljava/lang/Object;");
        Iterator iterator = u.a;
        object = ((u)((Object)iterator)).a("Number");
        Object object22 = kotlin.reflect.jvm.internal.impl.h.d.c.c.c();
        j.a(object22, "JvmPrimitiveType.BYTE.desc");
        object = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object, "toByte", "", (String)object22), f.a("byteValue"));
        object22 = ((u)((Object)iterator)).a("Number");
        Iterator iterator2 = kotlin.reflect.jvm.internal.impl.h.d.c.d.c();
        j.a((Object)iterator2, "JvmPrimitiveType.SHORT.desc");
        object22 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object22, "toShort", "", (String)((Object)iterator2)), f.a("shortValue"));
        iterator2 = ((u)((Object)iterator)).a("Number");
        Object object3 = kotlin.reflect.jvm.internal.impl.h.d.c.e.c();
        j.a(object3, "JvmPrimitiveType.INT.desc");
        iterator2 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)((Object)iterator2), "toInt", "", (String)object3), f.a("intValue"));
        object3 = ((u)((Object)iterator)).a("Number");
        Object object4 = kotlin.reflect.jvm.internal.impl.h.d.c.g.c();
        j.a(object4, "JvmPrimitiveType.LONG.desc");
        object3 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object3, "toLong", "", (String)object4), f.a("longValue"));
        object4 = ((u)((Object)iterator)).a("Number");
        Object object5 = kotlin.reflect.jvm.internal.impl.h.d.c.f.c();
        j.a(object5, "JvmPrimitiveType.FLOAT.desc");
        object4 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object4, "toFloat", "", (String)object5), f.a("floatValue"));
        object5 = ((u)((Object)iterator)).a("Number");
        Object object6 = kotlin.reflect.jvm.internal.impl.h.d.c.h.c();
        j.a(object6, "JvmPrimitiveType.DOUBLE.desc");
        object5 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)object5, "toDouble", "", (String)object6), f.a("doubleValue"));
        object6 = s.a(b, f.a("remove"));
        iterator = ((u)((Object)iterator)).a("CharSequence");
        String string2 = kotlin.reflect.jvm.internal.impl.h.d.c.e.c();
        j.a((Object)string2, "JvmPrimitiveType.INT.desc");
        String string3 = kotlin.reflect.jvm.internal.impl.h.d.c.b.c();
        j.a((Object)string3, "JvmPrimitiveType.CHAR.desc");
        c = af.a(new o[]{object, object22, iterator2, object3, object4, object5, object6, s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((String)((Object)iterator), "get", string2, string3), f.a("charAt"))});
        iterator = c;
        object = new LinkedHashMap(af.a(iterator.size()));
        for (Object object22 : (Iterable)iterator.entrySet()) {
            object.put(((q)object22.getKey()).b(), object22.getValue());
        }
        d = object;
        iterator = c.keySet();
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object.add(((q)iterator.next()).a());
        }
        e = (List)object;
        iterator = c.entrySet();
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object22 = (Map.Entry)iterator.next();
            object.add(new o(((q)object22.getKey()).a(), object22.getValue()));
        }
        object = (List)object;
        object22 = new LinkedHashMap();
        iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object3 = (o)iterator2.next();
            object4 = (f)((o)object3).b();
            iterator = object22.get(object4);
            object = iterator;
            if (iterator == null) {
                object = new ArrayList();
                object22.put(object4, object);
            }
            ((List)object).add((f)((o)object3).a());
        }
        f = object22;
    }

    private c() {
    }

    public final List<f> a() {
        return e;
    }

    public final f a(am object) {
        j.b(object, "functionDescriptor");
        Map<String, f> map = d;
        object = r.b((kotlin.reflect.jvm.internal.impl.a.a)object);
        if (object != null) {
            return map.get(object);
        }
        return null;
    }

    public final boolean a(f f2) {
        j.b(f2, "$receiver");
        return e.contains(f2);
    }

    public final List<f> b(f object) {
        j.b(object, "name");
        object = f.get(object);
        if (object != null) {
            return object;
        }
        return m.a();
    }

    public final boolean b(final am am2) {
        j.b(am2, "functionDescriptor");
        return KotlinBuiltIns.isBuiltIn(am2) && kotlin.reflect.jvm.internal.impl.h.c.a.a(am2, false, new b<kotlin.reflect.jvm.internal.impl.a.b, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a((kotlin.reflect.jvm.internal.impl.a.b)object);
            }

            @Override
            public final boolean a(kotlin.reflect.jvm.internal.impl.a.b object) {
                j.b(object, "it");
                object = d;
                String string2 = r.b(am2);
                if (object != null) {
                    return object.containsKey(string2);
                }
                throw new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
        }, 1, null) != null;
    }

    public final boolean c(am am2) {
        j.b(am2, "$receiver");
        return j.a((Object)am2.h_().a(), (Object)"removeAt") && j.a((Object)r.b(am2), (Object)b.b());
    }

}

