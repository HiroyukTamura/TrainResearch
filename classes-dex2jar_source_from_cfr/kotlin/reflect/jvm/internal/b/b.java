/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.b;

import kotlin.reflect.jvm.internal.b.a;
import kotlin.reflect.jvm.internal.b.d;
import kotlin.reflect.jvm.internal.b.e;

public final class b<K, V> {
    private static final b<Object, Object> a = new b<K, V>(d.a(), 0);
    private final d<a<e<K, V>>> b;
    private final int c;

    private b(d<a<e<K, V>>> d2, int n2) {
        this.b = d2;
        this.c = n2;
    }

    private static <K, V> int a(a<e<K, V>> a2, Object object) {
        int n2 = 0;
        while (a2 != null && a2.b() > 0) {
            if (((e)a2.a).a.equals(object)) {
                return n2;
            }
            a2 = a2.b;
            ++n2;
        }
        return -1;
    }

    private a<e<K, V>> a(int n2) {
        a<e<K, V>> a2;
        a<e<K, V>> a3 = a2 = this.b.a(n2);
        if (a2 == null) {
            a3 = a.a();
        }
        return a3;
    }

    public static <K, V> b<K, V> a() {
        return a;
    }

    public V a(Object object) {
        a<e<K, V>> a2 = this.a(object.hashCode());
        while (a2 != null && a2.b() > 0) {
            e e2 = (e)a2.a;
            if (e2.a.equals(object)) {
                return e2.b;
            }
            a2 = a2.b;
        }
        return null;
    }

    public b<K, V> a(K k2, V object) {
        a<e<K, V>> a2 = this.a(k2.hashCode());
        int n2 = a2.b();
        int n3 = b.a(a2, k2);
        a<e<K, V>> a3 = a2;
        if (n3 != -1) {
            a3 = a2.b(n3);
        }
        object = a3.a(new e<K, V>(k2, object));
        return new b<K, V>(this.b.a(k2.hashCode(), (a<e<K, Object>>)object), this.c - n2 + ((a)object).b());
    }
}

