/*
 * Decompiled with CFR 0.139.
 */
package androidx.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
implements Iterable<Map.Entry<K, V>> {
    c<K, V> a;
    private c<K, V> b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap();
    private int d = 0;

    public int a() {
        return this.d;
    }

    protected c<K, V> a(K k2) {
        c<K, V> c2 = this.a;
        while (c2 != null) {
            if (c2.a.equals(k2)) {
                return c2;
            }
            c2 = c2.c;
        }
        return c2;
    }

    public V a(K k2, V v2) {
        c<K, V> c2 = this.a(k2);
        if (c2 != null) {
            return c2.b;
        }
        this.b(k2, v2);
        return null;
    }

    protected c<K, V> b(K object, V v2) {
        object = new c<K, V>(object, v2);
        ++this.d;
        if (this.b == null) {
            this.a = object;
            this.b = this.a;
            return object;
        }
        this.b.c = object;
        ((c)object).d = this.b;
        this.b = object;
        return object;
    }

    public V b(K object) {
        if ((object = this.a(object)) == null) {
            return null;
        }
        --this.d;
        if (!this.c.isEmpty()) {
            Iterator<f<K, V>> iterator = this.c.keySet().iterator();
            while (iterator.hasNext()) {
                iterator.next().a_((c<K, V>)object);
            }
        }
        if (((c)object).d != null) {
            object.d.c = ((c)object).c;
        } else {
            this.a = ((c)object).c;
        }
        if (((c)object).c != null) {
            object.c.d = ((c)object).d;
        } else {
            this.b = ((c)object).d;
        }
        ((c)object).c = null;
        ((c)object).d = null;
        return ((c)object).b;
    }

    public Iterator<Map.Entry<K, V>> b() {
        b<K, V> b2 = new b<K, V>(this.b, this.a);
        this.c.put(b2, false);
        return b2;
    }

    public b<K, V> c() {
        d d2 = new d();
        this.c.put(d2, false);
        return d2;
    }

    public Map.Entry<K, V> d() {
        return this.a;
    }

    public Map.Entry<K, V> e() {
        return this.b;
    }

    public boolean equals(Object iterator) {
        if (iterator == this) {
            return true;
        }
        if (!(iterator instanceof b)) {
            return false;
        }
        Object object = (b)((Object)iterator);
        if (this.a() != ((b)object).a()) {
            return false;
        }
        iterator = this.iterator();
        object = ((b)object).iterator();
        while (iterator.hasNext() && object.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            Object e2 = object.next();
            if ((entry != null || e2 == null) && (entry == null || entry.equals(e2))) continue;
            return false;
        }
        return !iterator.hasNext() && !object.hasNext();
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            n2 += iterator.next().hashCode();
        }
        return n2;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        a<K, V> a2 = new a<K, V>(this.a, this.b);
        this.c.put(a2, false);
        return a2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().toString());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class a<K, V>
    extends e<K, V> {
        a(c<K, V> c2, c<K, V> c3) {
            super(c2, c3);
        }

        @Override
        c<K, V> a(c<K, V> c2) {
            return c2.c;
        }

        @Override
        c<K, V> b(c<K, V> c2) {
            return c2.d;
        }
    }

    private static class b<K, V>
    extends e<K, V> {
        b(c<K, V> c2, c<K, V> c3) {
            super(c2, c3);
        }

        @Override
        c<K, V> a(c<K, V> c2) {
            return c2.d;
        }

        @Override
        c<K, V> b(c<K, V> c2) {
            return c2.c;
        }
    }

    static class c<K, V>
    implements Map.Entry<K, V> {
        final K a;
        final V b;
        c<K, V> c;
        c<K, V> d;

        c(K k2, V v2) {
            this.a = k2;
            this.b = v2;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof c)) {
                return false;
            }
            object = (c)object;
            return this.a.equals(((c)object).a) && this.b.equals(((c)object).b);
        }

        @Override
        public K getKey() {
            return this.a;
        }

        @Override
        public V getValue() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override
        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("=");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }

    private class d
    implements f<K, V>,
    Iterator<Map.Entry<K, V>> {
        private c<K, V> b;
        private boolean c = true;

        d() {
        }

        /*
         * Enabled aggressive block sorting
         */
        public Map.Entry<K, V> a() {
            c c2;
            if (this.c) {
                this.c = false;
                c2 = b.this.a;
            } else {
                c2 = this.b != null ? this.b.c : null;
            }
            this.b = c2;
            return this.b;
        }

        @Override
        public void a_(c<K, V> c2) {
            if (c2 == this.b) {
                this.b = this.b.d;
                boolean bl2 = this.b == null;
                this.c = bl2;
            }
        }

        @Override
        public boolean hasNext() {
            boolean bl2 = this.c;
            boolean bl3 = false;
            boolean bl4 = false;
            if (bl2) {
                if (b.this.a != null) {
                    bl4 = true;
                }
                return bl4;
            }
            bl4 = bl3;
            if (this.b != null) {
                bl4 = bl3;
                if (this.b.c != null) {
                    bl4 = true;
                }
            }
            return bl4;
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }
    }

    private static abstract class e<K, V>
    implements f<K, V>,
    Iterator<Map.Entry<K, V>> {
        c<K, V> a;
        c<K, V> b;

        e(c<K, V> c2, c<K, V> c3) {
            this.a = c3;
            this.b = c2;
        }

        private c<K, V> b() {
            if (this.b != this.a && this.a != null) {
                return this.a(this.b);
            }
            return null;
        }

        abstract c<K, V> a(c<K, V> var1);

        public Map.Entry<K, V> a() {
            c<K, V> c2 = this.b;
            this.b = this.b();
            return c2;
        }

        @Override
        public void a_(c<K, V> c2) {
            if (this.a == c2 && c2 == this.b) {
                this.b = null;
                this.a = null;
            }
            if (this.a == c2) {
                this.a = this.b(this.a);
            }
            if (this.b == c2) {
                this.b = this.b();
            }
        }

        abstract c<K, V> b(c<K, V> var1);

        @Override
        public boolean hasNext() {
            return this.b != null;
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }
    }

    static interface f<K, V> {
        public void a_(c<K, V> var1);
    }

}

