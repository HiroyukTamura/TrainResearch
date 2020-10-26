/*
 * Decompiled with CFR 0.139.
 */
package a.b;

import a.b.a;
import java.util.Collections;
import java.util.Map;

public final class d<K, V> {
    private final Map<K, V> a;

    private d(int n2) {
        this.a = a.a(n2);
    }

    public static <K, V> d<K, V> a(int n2) {
        return new d<K, V>(n2);
    }

    public d<K, V> a(K k2, V v2) {
        this.a.put(k2, v2);
        return this;
    }

    public Map<K, V> a() {
        if (this.a.size() != 0) {
            return Collections.unmodifiableMap(this.a);
        }
        return Collections.emptyMap();
    }
}

