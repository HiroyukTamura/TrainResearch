/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import androidx.c.f;
import androidx.c.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a<K, V>
extends g<K, V>
implements Map<K, V> {
    f<K, V> a;

    public a() {
    }

    public a(int n2) {
        super(n2);
    }

    public a(g g2) {
        super(g2);
    }

    private f<K, V> b() {
        if (this.a == null) {
            this.a = new f<K, V>(){

                @Override
                protected int a() {
                    return a.this.h;
                }

                @Override
                protected int a(Object object) {
                    return a.this.a(object);
                }

                @Override
                protected Object a(int n2, int n3) {
                    return a.this.g[(n2 << 1) + n3];
                }

                @Override
                protected V a(int n2, V v2) {
                    return a.this.a(n2, v2);
                }

                @Override
                protected void a(int n2) {
                    a.this.d(n2);
                }

                @Override
                protected void a(K k2, V v2) {
                    a.this.put(k2, v2);
                }

                @Override
                protected int b(Object object) {
                    return a.this.b(object);
                }

                @Override
                protected Map<K, V> b() {
                    return a.this;
                }

                @Override
                protected void c() {
                    a.this.clear();
                }
            };
        }
        return this.a;
    }

    public boolean a(Collection<?> collection) {
        return f.c(this, collection);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return this.b().d();
    }

    @Override
    public Set<K> keySet() {
        return this.b().e();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> object) {
        this.a(this.h + object.size());
        for (Map.Entry entry : object.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Collection<V> values() {
        return this.b().f();
    }

}

