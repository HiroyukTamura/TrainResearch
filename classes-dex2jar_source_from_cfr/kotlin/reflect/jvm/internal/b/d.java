/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.b;

import kotlin.reflect.jvm.internal.b.c;

final class d<V> {
    private static final d<Object> a = new d<Object>(c.a);
    private final c<V> b;

    private d(c<V> c2) {
        this.b = c2;
    }

    public static <V> d<V> a() {
        return a;
    }

    private d<V> a(c<V> c2) {
        if (c2 == this.b) {
            return this;
        }
        return new d<V>(c2);
    }

    public V a(int n2) {
        return this.b.a(n2);
    }

    public d<V> a(int n2, V v2) {
        return this.a(this.b.a(n2, v2));
    }
}

