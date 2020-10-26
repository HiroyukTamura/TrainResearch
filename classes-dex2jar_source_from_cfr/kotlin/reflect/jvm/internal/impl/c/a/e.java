/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.s;
import kotlin.y;

public final class e {
    public static final e a = new e();
    private static final Map<kotlin.reflect.jvm.internal.impl.e.b, f> b;
    private static final Map<f, List<f>> c;
    private static final Set<kotlin.reflect.jvm.internal.impl.e.b> d;
    private static final Set<f> e;

    static {
        ArrayList arrayList = KotlinBuiltIns.FQ_NAMES._enum;
        j.a((Object)arrayList, "BUILTIN_NAMES._enum");
        arrayList = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((c)((Object)arrayList), "name"), f.a("name"));
        Iterator iterator = KotlinBuiltIns.FQ_NAMES._enum;
        j.a((Object)iterator, "BUILTIN_NAMES._enum");
        iterator = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((c)((Object)iterator), "ordinal"), f.a("ordinal"));
        Object object = KotlinBuiltIns.FQ_NAMES.collection;
        j.a(object, "BUILTIN_NAMES.collection");
        object = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((kotlin.reflect.jvm.internal.impl.e.b)object, "size"), f.a("size"));
        Iterator iterator2 = KotlinBuiltIns.FQ_NAMES.map;
        j.a((Object)iterator2, "BUILTIN_NAMES.map");
        iterator2 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((kotlin.reflect.jvm.internal.impl.e.b)((Object)iterator2), "size"), f.a("size"));
        c object22 = KotlinBuiltIns.FQ_NAMES.charSequence;
        j.a((Object)object22, "BUILTIN_NAMES.charSequence");
        o<kotlin.reflect.jvm.internal.impl.e.b, f> o2 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a(object22, "length"), f.a("length"));
        Object object2 = KotlinBuiltIns.FQ_NAMES.map;
        j.a(object2, "BUILTIN_NAMES.map");
        object2 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((kotlin.reflect.jvm.internal.impl.e.b)object2, "keys"), f.a("keySet"));
        Object object3 = KotlinBuiltIns.FQ_NAMES.map;
        j.a(object3, "BUILTIN_NAMES.map");
        object3 = s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a((kotlin.reflect.jvm.internal.impl.e.b)object3, "values"), f.a("values"));
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.map;
        j.a((Object)b2, "BUILTIN_NAMES.map");
        b = af.a(new o[]{arrayList, iterator, object, iterator2, o2, object2, object3, s.a(kotlin.reflect.jvm.internal.impl.c.a.s.a(b2, "entries"), f.a("entrySet"))});
        iterator = b.entrySet();
        arrayList = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object = (Map.Entry)iterator.next();
            arrayList.add(new o(((kotlin.reflect.jvm.internal.impl.e.b)object.getKey()).e(), object.getValue()));
        }
        arrayList = arrayList;
        object = new LinkedHashMap();
        for (o o3 : arrayList) {
            object2 = (f)o3.b();
            iterator = object.get(object2);
            arrayList = iterator;
            if (iterator == null) {
                arrayList = new ArrayList();
                object.put(object2, arrayList);
            }
            ((List)arrayList).add((f)o3.a());
        }
        c = object;
        d = b.keySet();
        iterator = d;
        arrayList = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.e.b)iterator.next()).e());
        }
        e = m.m(arrayList);
    }

    private e() {
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.a.b iterator) {
        boolean bl2;
        block4 : {
            kotlin.reflect.jvm.internal.impl.a.b b2;
            e e2;
            if (m.a((Iterable)d, kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.a)((Object)iterator))) && iterator.i().isEmpty()) {
                return true;
            }
            bl2 = KotlinBuiltIns.isBuiltIn((kotlin.reflect.jvm.internal.impl.a.m)((Object)iterator));
            boolean bl3 = false;
            if (!bl2) {
                return false;
            }
            iterator = iterator.k();
            j.a((Object)iterator, "overriddenDescriptors");
            iterator = (Iterable)((Object)iterator);
            if (iterator instanceof Collection && ((Collection)((Object)iterator)).isEmpty()) {
                return false;
            }
            iterator = iterator.iterator();
            do {
                bl2 = bl3;
                if (!iterator.hasNext()) break block4;
                b2 = (kotlin.reflect.jvm.internal.impl.a.b)iterator.next();
                e2 = a;
                j.a((Object)b2, "it");
            } while (!e2.a(b2));
            bl2 = true;
        }
        return bl2;
    }

    public final List<f> a(f object) {
        j.b(object, "name1");
        object = c.get(object);
        if (object != null) {
            return object;
        }
        return m.a();
    }

    public final Set<f> a() {
        return e;
    }

    public final boolean a(kotlin.reflect.jvm.internal.impl.a.b b2) {
        j.b(b2, "callableMemberDescriptor");
        if (!e.contains(b2.h_())) {
            return false;
        }
        return this.c(b2);
    }

    public final String b(kotlin.reflect.jvm.internal.impl.a.b object) {
        j.b(object, "$receiver");
        boolean bl2 = KotlinBuiltIns.isBuiltIn((kotlin.reflect.jvm.internal.impl.a.m)object);
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("This method is defined only for builtin members, but ");
            stringBuilder.append(object);
            stringBuilder.append(" found");
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        object = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.b)object);
        Object object2 = a.a;
        Object var3_4 = null;
        object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.b)object, false, (b)object2, 1, null);
        object = var3_4;
        if (object2 != null) {
            object2 = b.get(kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.m)object2));
            object = var3_4;
            if (object2 != null) {
                object = ((f)object2).a();
            }
        }
        return object;
    }

}

