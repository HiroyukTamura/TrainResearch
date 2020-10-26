/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.a.m;
import kotlin.e.b.j;

public final class a {
    public static final <K, V> HashMap<K, V> a(int n2) {
        return new HashMap(a.d(n2));
    }

    public static final <T> List<T> a(ArrayList<T> arrayList) {
        j.b(arrayList, "$receiver");
        switch (arrayList.size()) {
            default: {
                arrayList.trimToSize();
                return arrayList;
            }
            case 1: {
                return m.a(m.f((List)arrayList));
            }
            case 0: 
        }
        return m.a();
    }

    public static final <K> Map<K, Integer> a(Iterable<? extends K> object) {
        j.b(object, "$receiver");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        object = object.iterator();
        int n2 = 0;
        while (object.hasNext()) {
            Object e2 = object.next();
            ((Map)linkedHashMap).put(e2, n2);
            ++n2;
        }
        return linkedHashMap;
    }

    public static final <T> void a(Collection<T> collection, T t2) {
        j.b(collection, "$receiver");
        if (t2 != null) {
            collection.add(t2);
        }
    }

    public static final <E> HashSet<E> b(int n2) {
        return new HashSet(a.d(n2));
    }

    public static final <E> LinkedHashSet<E> c(int n2) {
        return new LinkedHashSet(a.d(n2));
    }

    private static final int d(int n2) {
        if (n2 < 3) {
            return 3;
        }
        return n2 + n2 / 3 + 1;
    }
}

