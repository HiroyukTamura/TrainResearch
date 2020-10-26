/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.s;

public final class h {
    public static final h a;
    private static final HashMap<b, b> b;

    static {
        h h2;
        a = h2 = new h();
        b = new HashMap();
        b b2 = KotlinBuiltIns.FQ_NAMES.mutableList;
        j.a((Object)b2, "FQ_NAMES.mutableList");
        h2.a(b2, h2.a("java.util.ArrayList", "java.util.LinkedList"));
        b2 = KotlinBuiltIns.FQ_NAMES.mutableSet;
        j.a((Object)b2, "FQ_NAMES.mutableSet");
        h2.a(b2, h2.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        b2 = KotlinBuiltIns.FQ_NAMES.mutableMap;
        j.a((Object)b2, "FQ_NAMES.mutableMap");
        h2.a(b2, h2.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        h2.a(new b("java.util.function.Function"), h2.a("java.util.function.UnaryOperator"));
        h2.a(new b("java.util.function.BiFunction"), h2.a("java.util.function.BinaryOperator"));
    }

    private h() {
    }

    private final /* varargs */ List<b> a(String ... arrstring) {
        Collection collection = new ArrayList(arrstring.length);
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            collection.add(new b(arrstring[i2]));
        }
        return (List)collection;
    }

    private final void a(b b2, List<b> object) {
        Object object2 = (Iterable)object;
        object = b;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            o<b, b> o2 = s.a((b)object2.next(), b2);
            object.put(o2.a(), o2.b());
        }
    }

    public final b a(b b2) {
        j.b(b2, "classFqName");
        return b.get(b2);
    }
}

