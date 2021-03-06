/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class f<K, V> {
    f<K, V> b;
    f<K, V> c;
    f<K, V> d;

    f() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> object) {
        object = object.iterator();
        while (object.hasNext()) {
            if (map.containsKey(object.next())) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static <T> boolean a(Set<T> set, Object object) {
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        object = (Set)object;
        try {
            boolean bl2;
            return set.size() == object.size() && (bl2 = set.containsAll((Collection<?>)object));
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> object) {
        int n2 = map.size();
        object = object.iterator();
        while (object.hasNext()) {
            map.remove(object.next());
        }
        return n2 != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int n2 = map.size();
        Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (collection.contains(iterator.next())) continue;
            iterator.remove();
        }
        return n2 != map.size();
    }

    protected abstract int a();

    protected abstract int a(Object var1);

    protected abstract Object a(int var1, int var2);

    protected abstract V a(int var1, V var2);

    protected abstract void a(int var1);

    protected abstract void a(K var1, V var2);

    public <T> T[] a(T[] arrT, int n2) {
        int n3 = this.a();
        Object[] arrobject = arrT;
        if (arrT.length < n3) {
            arrobject = (Object[])Array.newInstance(arrT.getClass().getComponentType(), n3);
        }
        for (int i2 = 0; i2 < n3; ++i2) {
            arrobject[i2] = this.a(i2, n2);
        }
        if (arrobject.length > n3) {
            arrobject[n3] = null;
        }
        return arrobject;
    }

    protected abstract int b(Object var1);

    protected abstract Map<K, V> b();

    public Object[] b(int n2) {
        int n3 = this.a();
        Object[] arrobject = new Object[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            arrobject[i2] = this.a(i2, n2);
        }
        return arrobject;
    }

    protected abstract void c();

    public Set<Map.Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c();
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }

    final class a<T>
    implements Iterator<T> {
        final int a;
        int b;
        int c;
        boolean d = false;

        a(int n2) {
            this.a = n2;
            this.b = f.this.a();
        }

        @Override
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                Object object = f.this.a(this.c, this.a);
                ++this.c;
                this.d = true;
                return (T)object;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if (this.d) {
                --this.c;
                --this.b;
                this.d = false;
                f.this.a(this.c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b
    implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public /* synthetic */ boolean add(Object object) {
            return this.a((Map.Entry)object);
        }

        @Override
        public boolean addAll(Collection<? extends Map.Entry<K, V>> object) {
            int n2 = f.this.a();
            object = object.iterator();
            while (object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                f.this.a(entry.getKey(), entry.getValue());
            }
            return n2 != f.this.a();
        }

        @Override
        public void clear() {
            f.this.c();
        }

        @Override
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            int n2 = f.this.a((object = (Map.Entry)object).getKey());
            if (n2 < 0) {
                return false;
            }
            return androidx.c.c.a(f.this.a(n2, 1), object.getValue());
        }

        @Override
        public boolean containsAll(Collection<?> object) {
            object = object.iterator();
            while (object.hasNext()) {
                if (this.contains(object.next())) continue;
                return false;
            }
            return true;
        }

        @Override
        public boolean equals(Object object) {
            return f.a(this, object);
        }

        @Override
        public int hashCode() {
            int n2 = 0;
            for (int i2 = f.this.a() - 1; i2 >= 0; --i2) {
                Object object = f.this.a(i2, 0);
                Object object2 = f.this.a(i2, 1);
                int n3 = object == null ? 0 : object.hashCode();
                int n4 = object2 == null ? 0 : object2.hashCode();
                n2 += n3 ^ n4;
            }
            return n2;
        }

        @Override
        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return f.this.a();
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public <T> T[] toArray(T[] arrT) {
            throw new UnsupportedOperationException();
        }
    }

    final class c
    implements Set<K> {
        c() {
        }

        @Override
        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            f.this.c();
        }

        @Override
        public boolean contains(Object object) {
            return f.this.a(object) >= 0;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return f.a(f.this.b(), collection);
        }

        @Override
        public boolean equals(Object object) {
            return f.a(this, object);
        }

        @Override
        public int hashCode() {
            int n2 = 0;
            for (int i2 = f.this.a() - 1; i2 >= 0; --i2) {
                Object object = f.this.a(i2, 0);
                int n3 = object == null ? 0 : object.hashCode();
                n2 += n3;
            }
            return n2;
        }

        @Override
        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        @Override
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override
        public boolean remove(Object object) {
            int n2 = f.this.a(object);
            if (n2 >= 0) {
                f.this.a(n2);
                return true;
            }
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return f.b(f.this.b(), collection);
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return f.c(f.this.b(), collection);
        }

        @Override
        public int size() {
            return f.this.a();
        }

        @Override
        public Object[] toArray() {
            return f.this.b(0);
        }

        @Override
        public <T> T[] toArray(T[] arrT) {
            return f.this.a(arrT, 0);
        }
    }

    final class d
    implements Iterator<Map.Entry<K, V>>,
    Map.Entry<K, V> {
        int a;
        int b;
        boolean c = false;

        d() {
            this.a = f.this.a() - 1;
            this.b = -1;
        }

        public Map.Entry<K, V> a() {
            if (this.hasNext()) {
                ++this.b;
                this.c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean equals(Object object) {
            if (this.c) {
                boolean bl2 = object instanceof Map.Entry;
                boolean bl3 = false;
                if (!bl2) {
                    return false;
                }
                object = (Map.Entry)object;
                bl2 = bl3;
                if (androidx.c.c.a(object.getKey(), f.this.a(this.b, 0))) {
                    bl2 = bl3;
                    if (androidx.c.c.a(object.getValue(), f.this.a(this.b, 1))) {
                        bl2 = true;
                    }
                }
                return bl2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public K getKey() {
            if (this.c) {
                return (K)f.this.a(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public V getValue() {
            if (this.c) {
                return (V)f.this.a(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public boolean hasNext() {
            return this.b < this.a;
        }

        @Override
        public int hashCode() {
            if (this.c) {
                Object object = f.this;
                int n2 = this.b;
                int n3 = 0;
                object = ((f)object).a(n2, 0);
                Object object2 = f.this.a(this.b, 1);
                n2 = object == null ? 0 : object.hashCode();
                if (object2 != null) {
                    n3 = object2.hashCode();
                }
                return n2 ^ n3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }

        @Override
        public void remove() {
            if (this.c) {
                f.this.a(this.b);
                --this.b;
                --this.a;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override
        public V setValue(V v2) {
            if (this.c) {
                return f.this.a(this.b, v2);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getKey());
            stringBuilder.append("=");
            stringBuilder.append(this.getValue());
            return stringBuilder.toString();
        }
    }

    final class e
    implements Collection<V> {
        e() {
        }

        @Override
        public boolean add(V v2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            f.this.c();
        }

        @Override
        public boolean contains(Object object) {
            return f.this.b(object) >= 0;
        }

        @Override
        public boolean containsAll(Collection<?> object) {
            object = object.iterator();
            while (object.hasNext()) {
                if (this.contains(object.next())) continue;
                return false;
            }
            return true;
        }

        @Override
        public boolean isEmpty() {
            return f.this.a() == 0;
        }

        @Override
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override
        public boolean remove(Object object) {
            int n2 = f.this.b(object);
            if (n2 >= 0) {
                f.this.a(n2);
                return true;
            }
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            int n2 = f.this.a();
            int n3 = 0;
            boolean bl2 = false;
            while (n3 < n2) {
                int n4 = n2;
                int n5 = n3;
                if (collection.contains(f.this.a(n3, 1))) {
                    f.this.a(n3);
                    n5 = n3 - 1;
                    n4 = n2 - 1;
                    bl2 = true;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            return bl2;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            int n2 = f.this.a();
            int n3 = 0;
            boolean bl2 = false;
            while (n3 < n2) {
                int n4 = n2;
                int n5 = n3;
                if (!collection.contains(f.this.a(n3, 1))) {
                    f.this.a(n3);
                    n5 = n3 - 1;
                    n4 = n2 - 1;
                    bl2 = true;
                }
                n3 = n5 + 1;
                n2 = n4;
            }
            return bl2;
        }

        @Override
        public int size() {
            return f.this.a();
        }

        @Override
        public Object[] toArray() {
            return f.this.b(1);
        }

        @Override
        public <T> T[] toArray(T[] arrT) {
            return f.this.a(arrT, 1);
        }
    }

}

