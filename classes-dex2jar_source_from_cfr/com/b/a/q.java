/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  com.b.a.q.e
 */
package com.b.a;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

final class q<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final /* synthetic */ boolean g;
    private static final Comparator<Comparable> h;
    Comparator<? super K> a;
    f<K, V>[] b;
    final f<K, V> c;
    int d = 0;
    int e = 0;
    int f;
    private q<K, V> i;
    private q<K, V> j;

    static {
        g = q.class.desiredAssertionStatus() ^ true;
        h = new Comparator<Comparable>(){

            public int a(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((Comparable)object, (Comparable)object2);
            }
        };
    }

    q() {
        this(null);
    }

    q(Comparator<? super K> comparator) {
        if (comparator == null) {
            comparator = h;
        }
        this.a = comparator;
        this.c = new f();
        this.b = new f[16];
        this.f = this.b.length / 2 + this.b.length / 4;
    }

    private static int a(int n2) {
        n2 ^= n2 >>> 20 ^ n2 >>> 12;
        return n2 >>> 4 ^ (n2 >>> 7 ^ n2);
    }

    private void a() {
        this.b = q.a(this.b);
        this.f = this.b.length / 2 + this.b.length / 4;
    }

    private void a(f<K, V> f2) {
        f f3 = f2.b;
        f f4 = f2.c;
        f f5 = f4.b;
        f f6 = f4.c;
        f2.c = f5;
        if (f5 != null) {
            f5.a = f2;
        }
        this.a(f2, f4);
        f4.b = f2;
        f2.a = f4;
        int n2 = 0;
        int n3 = f3 != null ? f3.i : 0;
        int n4 = f5 != null ? f5.i : 0;
        n4 = f2.i = Math.max(n3, n4) + 1;
        n3 = n2;
        if (f6 != null) {
            n3 = f6.i;
        }
        f4.i = Math.max(n4, n3) + 1;
    }

    private void a(f<K, V> f2, f<K, V> f3) {
        f f4 = f2.a;
        f2.a = null;
        if (f3 != null) {
            f3.a = f4;
        }
        if (f4 != null) {
            if (f4.b == f2) {
                f4.b = f3;
                return;
            }
            if (!g && f4.c != f2) {
                throw new AssertionError();
            }
            f4.c = f3;
            return;
        }
        int n2 = f2.g;
        int n3 = this.b.length;
        this.b[n2 & n3 - 1] = f3;
    }

    private boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    static <K, V> f<K, V>[] a(f<K, V>[] arrf) {
        int n2 = arrf.length;
        f[] arrf2 = new f[n2 * 2];
        b<K, V> b2 = new b<K, V>();
        a<K, V> a2 = new a<K, V>();
        a<K, V> a3 = new a<K, V>();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2;
            f<K, V> f3 = arrf[i2];
            if (f3 == null) continue;
            b2.a(f3);
            int n3 = 0;
            int n4 = 0;
            while ((f2 = b2.a()) != null) {
                if ((f2.g & n2) == 0) {
                    ++n3;
                    continue;
                }
                ++n4;
            }
            a2.a(n3);
            a3.a(n4);
            b2.a(f3);
            while ((f3 = b2.a()) != null) {
                if ((f3.g & n2) == 0) {
                    a2.a(f3);
                    continue;
                }
                a3.a(f3);
            }
            f2 = null;
            f3 = n3 > 0 ? a2.a() : null;
            arrf2[i2] = f3;
            f3 = f2;
            if (n4 > 0) {
                f3 = a3.a();
            }
            arrf2[i2 + n2] = f3;
        }
        return arrf2;
    }

    private void b(f<K, V> f2) {
        f f3 = f2.b;
        f f4 = f2.c;
        f f5 = f3.b;
        f f6 = f3.c;
        f2.b = f6;
        if (f6 != null) {
            f6.a = f2;
        }
        this.a(f2, f3);
        f3.c = f2;
        f2.a = f3;
        int n2 = 0;
        int n3 = f4 != null ? f4.i : 0;
        int n4 = f6 != null ? f6.i : 0;
        n4 = f2.i = Math.max(n3, n4) + 1;
        n3 = n2;
        if (f5 != null) {
            n3 = f5.i;
        }
        f3.i = Math.max(n4, n3) + 1;
    }

    private void b(f<K, V> f2, boolean bl2) {
        while (f2 != null) {
            f f3;
            int n2;
            f f4 = f2.b;
            f f5 = f2.c;
            int n3 = 0;
            int n4 = 0;
            int n5 = f4 != null ? f4.i : 0;
            int n6 = n5 - (n2 = f5 != null ? f5.i : 0);
            if (n6 == -2) {
                f4 = f5.b;
                f3 = f5.c;
                n5 = f3 != null ? f3.i : 0;
                n2 = n4;
                if (f4 != null) {
                    n2 = f4.i;
                }
                if ((n5 = n2 - n5) != -1 && (n5 != 0 || bl2)) {
                    if (!g && n5 != 1) {
                        throw new AssertionError();
                    }
                    this.b(f5);
                }
                this.a(f2);
                if (bl2) {
                    return;
                }
            } else if (n6 == 2) {
                f5 = f4.b;
                f3 = f4.c;
                n5 = f3 != null ? f3.i : 0;
                n2 = n3;
                if (f5 != null) {
                    n2 = f5.i;
                }
                if ((n5 = n2 - n5) != 1 && (n5 != 0 || bl2)) {
                    if (!g && n5 != -1) {
                        throw new AssertionError();
                    }
                    this.a(f4);
                }
                this.b(f2);
                if (bl2) {
                    return;
                }
            } else if (n6 == 0) {
                f2.i = n5 + 1;
                if (bl2) {
                    return;
                }
            } else {
                if (!g && n6 != -1 && n6 != 1) {
                    throw new AssertionError();
                }
                f2.i = Math.max(n5, n2) + 1;
                if (!bl2) {
                    return;
                }
            }
            f2 = f2.a;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    f<K, V> a(Object f2) {
        if (f2 == null) return null;
        try {
            return this.a((K)f2, false);
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    f<K, V> a(K object, boolean bl2) {
        f<K, V> f2;
        int n2;
        Comparator<K> comparator = this.a;
        f<K, V>[] arrf = this.b;
        int n3 = q.a(object.hashCode());
        int n4 = arrf.length - 1 & n3;
        f<K, V> f3 = arrf[n4];
        if (f3 != null) {
            Comparable comparable = comparator == h ? (Comparable)object : null;
            do {
                if ((n2 = comparable != null ? comparable.compareTo(f3.f) : comparator.compare(object, f3.f)) == 0) {
                    return f3;
                }
                f2 = n2 < 0 ? f3.b : f3.c;
                if (f2 != null) {
                    f3 = f2;
                    continue;
                }
                break;
            } while (true);
        } else {
            n2 = 0;
        }
        if (!bl2) {
            return null;
        }
        f2 = this.c;
        if (f3 == null) {
            if (comparator == h && !(object instanceof Comparable)) {
                f3 = new StringBuilder();
                ((StringBuilder)((Object)f3)).append(object.getClass().getName());
                ((StringBuilder)((Object)f3)).append(" is not Comparable");
                throw new ClassCastException(((StringBuilder)((Object)f3)).toString());
            }
            arrf[n4] = object = new f<K, V>(f3, object, n3, f2, f2.e);
        } else {
            object = new f<K, V>(f3, object, n3, f2, f2.e);
            if (n2 < 0) {
                f3.b = object;
            } else {
                f3.c = object;
            }
            this.b(f3, true);
        }
        n2 = this.d;
        this.d = n2 + 1;
        if (n2 > this.f) {
            this.a();
        }
        ++this.e;
        return object;
    }

    f<K, V> a(Map.Entry<?, ?> entry) {
        f<K, V> f2 = this.a(entry.getKey());
        boolean bl2 = f2 != null && this.a(f2.h, entry.getValue());
        if (bl2) {
            return f2;
        }
        return null;
    }

    void a(f<K, V> f2, boolean bl2) {
        if (bl2) {
            f2.e.d = f2.d;
            f2.d.e = f2.e;
            f2.e = null;
            f2.d = null;
        }
        f f3 = f2.b;
        f f4 = f2.c;
        f f5 = f2.a;
        int n2 = 0;
        if (f3 != null && f4 != null) {
            int n3;
            f3 = f3.i > f4.i ? f3.b() : f4.a();
            this.a((f<K, V>)f3, false);
            f4 = f2.b;
            if (f4 != null) {
                n3 = f4.i;
                f3.b = f4;
                f4.a = f3;
                f2.b = null;
            } else {
                n3 = 0;
            }
            f4 = f2.c;
            if (f4 != null) {
                n2 = f4.i;
                f3.c = f4;
                f4.a = f3;
                f2.c = null;
            }
            f3.i = Math.max(n3, n2) + 1;
            this.a(f2, f3);
            return;
        }
        if (f3 != null) {
            this.a(f2, f3);
            f2.b = null;
        } else if (f4 != null) {
            this.a(f2, f4);
            f2.c = null;
        } else {
            this.a(f2, null);
        }
        this.b(f5, false);
        --this.d;
        ++this.e;
    }

    f<K, V> b(Object f2) {
        if ((f2 = this.a((Object)f2)) != null) {
            this.a(f2, true);
        }
        return f2;
    }

    @Override
    public void clear() {
        Arrays.fill(this.b, null);
        this.d = 0;
        ++this.e;
        f<K, V> f2 = this.c;
        f f3 = f2.d;
        while (f3 != f2) {
            f f4 = f3.d;
            f3.e = null;
            f3.d = null;
            f3 = f4;
        }
        f2.e = f2;
        f2.d = f2;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.a(object) != null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        q<K, V> q2 = this.i;
        if (q2 != null) {
            return q2;
        }
        this.i = q2 = new c();
        return q2;
    }

    @Override
    public V get(Object f2) {
        if ((f2 = this.a((Object)f2)) != null) {
            return f2.h;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        q<K, V> q2 = this.j;
        if (q2 != null) {
            return q2;
        }
        this.j = q2 = new d();
        return q2;
    }

    @Override
    public V put(K object, V v2) {
        if (object != null) {
            object = this.a((K)object, true);
            Object v3 = ((f)object).h;
            ((f)object).h = v2;
            return v3;
        }
        throw new NullPointerException("key == null");
    }

    @Override
    public V remove(Object f2) {
        if ((f2 = this.b((Object)f2)) != null) {
            return f2.h;
        }
        return null;
    }

    @Override
    public int size() {
        return this.d;
    }

    static final class a<K, V> {
        private f<K, V> a;
        private int b;
        private int c;
        private int d;

        a() {
        }

        f<K, V> a() {
            f<K, V> f2 = this.a;
            if (f2.a == null) {
                return f2;
            }
            throw new IllegalStateException();
        }

        void a(int n2) {
            this.b = Integer.highestOneBit(n2) * 2 - 1 - n2;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(f<K, V> f2) {
            f2.c = null;
            f2.a = null;
            f2.b = null;
            f2.i = 1;
            if (this.b > 0 && (this.d & 1) == 0) {
                ++this.d;
                --this.b;
                ++this.c;
            }
            f2.a = this.a;
            this.a = f2;
            ++this.d;
            if (this.b > 0 && (this.d & 1) == 0) {
                ++this.d;
                --this.b;
                ++this.c;
            }
            int n2 = 4;
            do {
                block8 : {
                    block10 : {
                        block9 : {
                            f f3;
                            block7 : {
                                int n3;
                                int n4;
                                if (((n3 = this.d) & (n4 = n2 - 1)) != n4) {
                                    return;
                                }
                                if (this.c != 0) break block7;
                                f2 = this.a;
                                f3 = f2.a;
                                f f4 = f3.a;
                                f3.a = f4.a;
                                this.a = f3;
                                f3.b = f4;
                                f3.c = f2;
                                f3.i = f2.i + 1;
                                f4.a = f3;
                                f2.a = f3;
                                break block8;
                            }
                            if (this.c != 1) break block9;
                            f2 = this.a;
                            f3 = f2.a;
                            this.a = f3;
                            f3.c = f2;
                            f3.i = f2.i + 1;
                            f2.a = f3;
                            break block10;
                        }
                        if (this.c != 2) break block8;
                    }
                    this.c = 0;
                }
                n2 *= 2;
            } while (true);
        }
    }

    static class b<K, V> {
        private f<K, V> a;

        b() {
        }

        public f<K, V> a() {
            f f2;
            f<K, V> f3 = this.a;
            if (f3 == null) {
                return null;
            }
            f f4 = f3.a;
            f3.a = null;
            f f5 = f3.c;
            do {
                f2 = f4;
                f4 = f5;
                if (f4 == null) break;
                f4.a = f2;
                f5 = f4.b;
            } while (true);
            this.a = f2;
            return f3;
        }

        void a(f<K, V> f2) {
            f<K, V> f3 = null;
            while (f2 != null) {
                f2.a = f3;
                f f4 = f2.b;
                f3 = f2;
                f2 = f4;
            }
            this.a = f3;
        }
    }

    final class c
    extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override
        public void clear() {
            q.this.clear();
        }

        @Override
        public boolean contains(Object object) {
            return object instanceof Map.Entry && q.this.a((Map.Entry)object) != null;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new com.b.a.q.e<Map.Entry<K, V>>(){

                public Map.Entry<K, V> a() {
                    return this.b();
                }

                public /* synthetic */ Object next() {
                    return this.a();
                }
            };
        }

        @Override
        public boolean remove(Object f2) {
            if (!(f2 instanceof Map.Entry)) {
                return false;
            }
            if ((f2 = q.this.a(f2)) == null) {
                return false;
            }
            q.this.a(f2, true);
            return true;
        }

        @Override
        public int size() {
            return q.this.d;
        }

    }

    final class d
    extends AbstractSet<K> {
        d() {
        }

        @Override
        public void clear() {
            q.this.clear();
        }

        @Override
        public boolean contains(Object object) {
            return q.this.containsKey(object);
        }

        @Override
        public Iterator<K> iterator() {
            return new q<K, V>(){

                public K next() {
                    return this.b().f;
                }
            };
        }

        @Override
        public boolean remove(Object object) {
            return q.this.b(object) != null;
        }

        @Override
        public int size() {
            return q.this.d;
        }

    }

    abstract class e<T>
    implements Iterator<T> {
        f<K, V> b;
        f<K, V> c;
        int d;

        e() {
            this.b = q.this.c.d;
            this.c = null;
            this.d = q.this.e;
        }

        final f<K, V> b() {
            f<K, V> f2 = this.b;
            if (f2 != q.this.c) {
                if (q.this.e == this.d) {
                    this.b = f2.d;
                    this.c = f2;
                    return f2;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override
        public final boolean hasNext() {
            return this.b != q.this.c;
        }

        @Override
        public final void remove() {
            if (this.c != null) {
                q.this.a(this.c, true);
                this.c = null;
                this.d = q.this.e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static final class f<K, V>
    implements Map.Entry<K, V> {
        f<K, V> a;
        f<K, V> b;
        f<K, V> c;
        f<K, V> d;
        f<K, V> e;
        final K f;
        final int g;
        V h;
        int i;

        f() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        f(f<K, V> f2, K k2, int n2, f<K, V> f3, f<K, V> f4) {
            this.a = f2;
            this.f = k2;
            this.g = n2;
            this.i = 1;
            this.d = f3;
            this.e = f4;
            f4.d = this;
            f3.e = this;
        }

        public f<K, V> a() {
            f<K, V> f2 = this.b;
            f<K, V> f3 = this;
            while (f2 != null) {
                f<K, V> f4 = f2.b;
                f3 = f2;
                f2 = f4;
            }
            return f3;
        }

        public f<K, V> b() {
            f<K, V> f2 = this.c;
            f<K, V> f3 = this;
            while (f2 != null) {
                f<K, V> f4 = f2.c;
                f3 = f2;
                f2 = f4;
            }
            return f3;
        }

        @Override
        public boolean equals(Object object) {
            boolean bl2;
            block2 : {
                block6 : {
                    boolean bl3;
                    block5 : {
                        block4 : {
                            block3 : {
                                boolean bl4 = object instanceof Map.Entry;
                                bl2 = bl3 = false;
                                if (!bl4) break block2;
                                object = (Map.Entry)object;
                                if (this.f != null) break block3;
                                bl2 = bl3;
                                if (object.getKey() != null) break block2;
                                break block4;
                            }
                            bl2 = bl3;
                            if (!this.f.equals(object.getKey())) break block2;
                        }
                        if (this.h != null) break block5;
                        bl2 = bl3;
                        if (object.getValue() != null) break block2;
                        break block6;
                    }
                    bl2 = bl3;
                    if (!this.h.equals(object.getValue())) break block2;
                }
                bl2 = true;
            }
            return bl2;
        }

        @Override
        public K getKey() {
            return this.f;
        }

        @Override
        public V getValue() {
            return this.h;
        }

        @Override
        public int hashCode() {
            K k2 = this.f;
            int n2 = 0;
            int n3 = k2 == null ? 0 : this.f.hashCode();
            if (this.h != null) {
                n2 = this.h.hashCode();
            }
            return n3 ^ n2;
        }

        @Override
        public V setValue(V v2) {
            V v3 = this.h;
            this.h = v2;
            return v3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append("=");
            stringBuilder.append(this.h);
            return stringBuilder.toString();
        }
    }

}

