/*
 * Decompiled with CFR 0.139.
 */
package androidx.a.a.b;

import androidx.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V>
extends b<K, V> {
    private HashMap<K, b.c<K, V>> b = new HashMap();

    @Override
    protected b.c<K, V> a(K k2) {
        return this.b.get(k2);
    }

    @Override
    public V a(K k2, V v2) {
        b.c<K, V> c2 = this.a(k2);
        if (c2 != null) {
            return c2.b;
        }
        this.b.put(k2, this.b(k2, v2));
        return null;
    }

    @Override
    public V b(K k2) {
        Object v2 = super.b(k2);
        this.b.remove(k2);
        return v2;
    }

    public boolean c(K k2) {
        return this.b.containsKey(k2);
    }

    public Map.Entry<K, V> d(K k2) {
        if (this.c(k2)) {
            return this.b.get(k2).d;
        }
        return null;
    }
}

