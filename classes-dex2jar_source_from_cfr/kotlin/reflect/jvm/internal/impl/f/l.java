/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.Iterator;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.f.m;
import kotlin.reflect.jvm.internal.impl.f.q;

public class l
extends m {
    private final q b;

    public q a() {
        return this.a(this.b);
    }

    public boolean equals(Object object) {
        return this.a().equals(object);
    }

    public int hashCode() {
        return this.a().hashCode();
    }

    public String toString() {
        return this.a().toString();
    }

    static class a<K>
    implements Map.Entry<K, Object> {
        private Map.Entry<K, l> a;

        private a(Map.Entry<K, l> entry) {
            this.a = entry;
        }

        @Override
        public K getKey() {
            return this.a.getKey();
        }

        @Override
        public Object getValue() {
            l l2 = this.a.getValue();
            if (l2 == null) {
                return null;
            }
            return l2.a();
        }

        @Override
        public Object setValue(Object object) {
            if (object instanceof q) {
                return this.a.getValue().b((q)object);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class b<K>
    implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> a;

        public b(Iterator<Map.Entry<K, Object>> iterator) {
            this.a = iterator;
        }

        public Map.Entry<K, Object> a() {
            Map.Entry<K, Object> entry = this.a.next();
            if (entry.getValue() instanceof l) {
                return new a(entry);
            }
            return entry;
        }

        @Override
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }

        @Override
        public void remove() {
            this.a.remove();
        }
    }

}

