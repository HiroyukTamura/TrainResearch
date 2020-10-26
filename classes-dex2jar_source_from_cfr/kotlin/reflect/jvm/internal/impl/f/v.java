/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.f.h;

class v<K extends Comparable<K>, V>
extends AbstractMap<K, V> {
    private final int a;
    private List<v<K, V>> b;
    private Map<K, V> c;
    private boolean d;
    private volatile v<K, V> e;

    private v(int n2) {
        this.a = n2;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
    }

    private int a(K k2) {
        int n2;
        int n3 = this.b.size() - 1;
        if (n3 >= 0) {
            n2 = k2.compareTo(((b)((Object)this.b.get(n3))).a());
            if (n2 > 0) {
                return -(n3 + 2);
            }
            if (n2 == 0) {
                return n3;
            }
        }
        n2 = 0;
        while (n2 <= n3) {
            int n4 = (n2 + n3) / 2;
            int n5 = k2.compareTo(((b)((Object)this.b.get(n4))).a());
            if (n5 < 0) {
                n3 = n4 - 1;
                continue;
            }
            if (n5 > 0) {
                n2 = n4 + 1;
                continue;
            }
            return n4;
        }
        return -(n2 + 1);
    }

    static <FieldDescriptorType extends h.a<FieldDescriptorType>> v<FieldDescriptorType, Object> a(int n2) {
        return new v<FieldDescriptorType, Object>(n2){

            @Override
            public void a() {
                if (!this.b()) {
                    for (int i2 = 0; i2 < this.c(); ++i2) {
                        Map.Entry entry = this.b(i2);
                        if (!((h.a)entry.getKey()).d()) continue;
                        entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
                    }
                    for (Map.Entry entry : this.d()) {
                        if (!((h.a)entry.getKey()).d()) continue;
                        entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
                    }
                }
                super.a();
            }

            @Override
            public /* synthetic */ Object put(Object object, Object object2) {
                return super.a((h.a)object, object2);
            }
        };
    }

    private V c(int n2) {
        this.e();
        Object v2 = ((b)((Object)this.b.remove(n2))).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> iterator = this.f().entrySet().iterator();
            this.b.add((v<K, V>)((Object)new b(iterator.next())));
            iterator.remove();
        }
        return v2;
    }

    private void e() {
        if (!this.d) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    private SortedMap<K, V> f() {
        this.e();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
        }
        return (SortedMap)this.c;
    }

    private void g() {
        this.e();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList<v<K, V>>(this.a);
        }
    }

    public V a(K k2, V v2) {
        this.e();
        int n2 = this.a(k2);
        if (n2 >= 0) {
            return ((b)((Object)this.b.get(n2))).setValue(v2);
        }
        this.g();
        n2 = -(n2 + 1);
        if (n2 >= this.a) {
            return this.f().put(k2, v2);
        }
        if (this.b.size() == this.a) {
            b b2 = (b)((Object)this.b.remove(this.a - 1));
            this.f().put(b2.a(), b2.getValue());
        }
        this.b.add(n2, (v<K, V>)((Object)new b(this, k2, v2)));
        return null;
    }

    public void a() {
        if (!this.d) {
            Map map = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
            this.c = map;
            this.d = true;
        }
    }

    public Map.Entry<K, V> b(int n2) {
        return (Map.Entry)((Object)this.b.get(n2));
    }

    public boolean b() {
        return this.d;
    }

    public int c() {
        return this.b.size();
    }

    @Override
    public void clear() {
        this.e();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    @Override
    public boolean containsKey(Object object) {
        return this.a(object = (Comparable)object) >= 0 || this.c.containsKey(object);
        {
        }
    }

    public Iterable<Map.Entry<K, V>> d() {
        if (this.c.isEmpty()) {
            return a.a();
        }
        return this.c.entrySet();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new d();
        }
        return this.e;
    }

    @Override
    public V get(Object object) {
        int n2 = this.a(object = (Comparable)object);
        if (n2 >= 0) {
            return ((b)((Object)this.b.get(n2))).getValue();
        }
        return this.c.get(object);
    }

    @Override
    public /* synthetic */ Object put(Object object, Object object2) {
        return this.a((Comparable)object, object2);
    }

    @Override
    public V remove(Object object) {
        this.e();
        object = (Comparable)object;
        int n2 = this.a(object);
        if (n2 >= 0) {
            return this.c(n2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(object);
    }

    @Override
    public int size() {
        return this.b.size() + this.c.size();
    }

    private static class a {
        private static final Iterator<Object> a = new Iterator<Object>(){

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        private static final Iterable<Object> b = new Iterable<Object>(){

            @Override
            public Iterator<Object> iterator() {
                return a;
            }
        };

        static <T> Iterable<T> a() {
            return b;
        }

    }

    private class b
    implements Comparable<v<K, V>>,
    Map.Entry<K, V> {
        private final K b;
        private V c;

        b(K k2, V v2) {
            this.b = k2;
            this.c = v2;
        }

        b(Map.Entry<K, V> entry) {
            this(v2, (Comparable)entry.getKey(), entry.getValue());
        }

        private boolean a(Object object, Object object2) {
            if (object == null) {
                return object2 == null;
            }
            return object.equals(object2);
        }

        public int a(v<K, V> v2) {
            return this.a().compareTo(((b)((Object)v2)).a());
        }

        public K a() {
            return this.b;
        }

        @Override
        public /* synthetic */ int compareTo(Object object) {
            return this.a((b)object);
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            return this.a(this.b, (object = (Map.Entry)object).getKey()) && this.a(this.c, object.getValue());
        }

        @Override
        public /* synthetic */ Object getKey() {
            return this.a();
        }

        @Override
        public V getValue() {
            return this.c;
        }

        @Override
        public int hashCode() {
            K k2 = this.b;
            int n2 = 0;
            int n3 = k2 == null ? 0 : this.b.hashCode();
            if (this.c != null) {
                n2 = this.c.hashCode();
            }
            return n3 ^ n2;
        }

        @Override
        public V setValue(V v2) {
            a.e();
            V v3 = this.c;
            this.c = v2;
            return v3;
        }

        public String toString() {
            String string2 = String.valueOf(String.valueOf(this.b));
            String string3 = String.valueOf(String.valueOf(this.c));
            StringBuilder stringBuilder = new StringBuilder(string2.length() + 1 + string3.length());
            stringBuilder.append(string2);
            stringBuilder.append("=");
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
    }

    private class c
    implements Iterator<Map.Entry<K, V>> {
        private int b = -1;
        private boolean c;
        private Iterator<Map.Entry<K, V>> d;

        private c() {
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.d == null) {
                this.d = v.this.c.entrySet().iterator();
            }
            return this.d;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Map.Entry<K, V> a() {
            void var2_3;
            int n2;
            this.c = true;
            this.b = n2 = this.b + 1;
            if (n2 < v.this.b.size()) {
                Object e2 = v.this.b.get(this.b);
                do {
                    return (Map.Entry)var2_3;
                    break;
                } while (true);
            }
            Map.Entry<K, V> entry = this.b().next();
            return (Map.Entry)var2_3;
        }

        @Override
        public boolean hasNext() {
            int n2 = this.b;
            boolean bl2 = true;
            if (n2 + 1 >= v.this.b.size()) {
                if (this.b().hasNext()) {
                    return true;
                }
                bl2 = false;
            }
            return bl2;
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }

        @Override
        public void remove() {
            if (this.c) {
                this.c = false;
                v.this.e();
                if (this.b < v.this.b.size()) {
                    v v2 = v.this;
                    int n2 = this.b;
                    this.b = n2 - 1;
                    v2.c(n2);
                    return;
                }
                this.b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    private class d
    extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            if (!this.contains(entry)) {
                v.this.a((Comparable)entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override
        public /* synthetic */ boolean add(Object object) {
            return this.a((Map.Entry)object);
        }

        @Override
        public void clear() {
            v.this.clear();
        }

        @Override
        public boolean contains(Object object) {
            Map.Entry entry = (Map.Entry)object;
            object = v.this.get(entry.getKey());
            return object == (entry = entry.getValue()) || object != null && object.equals(entry);
            {
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        @Override
        public boolean remove(Object object) {
            if (this.contains(object = (Map.Entry)object)) {
                v.this.remove(object.getKey());
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            return v.this.size();
        }
    }

}

