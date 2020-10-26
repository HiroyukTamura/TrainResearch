/*
 * Decompiled with CFR 0.139.
 */
package kotlin.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.e;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.k;

@Metadata(bv={1, 0, 2}, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000\u00a2\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b8\b@\bX\u0089\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006*"}, d2={"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public abstract class c<K, V>
implements Map<K, V>,
kotlin.e.b.a.a {
    public static final a a = new a(null);
    private volatile Set<? extends K> b;
    private volatile Collection<? extends V> c;

    protected c() {
    }

    private final String a(Object object) {
        if (object == this) {
            return "(this Map)";
        }
        return String.valueOf(object);
    }

    private final String b(Map.Entry<? extends K, ? extends V> entry) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a(entry.getKey()));
        stringBuilder.append("=");
        stringBuilder.append(this.a(entry.getValue()));
        return stringBuilder.toString();
    }

    private final Map.Entry<K, V> b(K object) {
        block1 : {
            for (Object t2 : (Iterable)this.entrySet()) {
                if (!j.a(((Map.Entry)t2).getKey(), object)) continue;
                object = t2;
                break block1;
            }
            object = null;
        }
        return (Map.Entry)object;
    }

    public abstract Set a();

    public final boolean a(Map.Entry<?, ?> entry) {
        Map map;
        V v2;
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        ? obj = entry.getKey();
        if (j.a(entry = entry.getValue(), v2 = (map = (Map)this).get(obj)) ^ true) {
            return false;
        }
        return v2 != null || map.containsKey(obj);
    }

    public int b() {
        return this.entrySet().size();
    }

    public Set<K> c() {
        Set<? extends K> set;
        if (this.b == null) {
            this.b = new e<K>(){

                @Override
                public int a() {
                    return this.size();
                }

                @Override
                public boolean contains(Object object) {
                    return this.containsKey(object);
                }

                @Override
                public Iterator<K> iterator() {
                    return new Iterator<K>(this.entrySet().iterator()){
                        final /* synthetic */ Iterator a;
                        {
                            this.a = iterator;
                        }

                        @Override
                        public boolean hasNext() {
                            return this.a.hasNext();
                        }

                        @Override
                        public K next() {
                            return ((Map.Entry)this.a.next()).getKey();
                        }

                        @Override
                        public void remove() {
                            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                        }
                    };
                }

            };
        }
        if ((set = this.b) == null) {
            j.a();
        }
        return set;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean containsKey(Object object) {
        return this.b(object) != null;
    }

    @Override
    public boolean containsValue(Object object) {
        boolean bl2;
        block2 : {
            Object object2 = this.entrySet();
            bl2 = object2 instanceof Collection;
            boolean bl3 = false;
            if (bl2 && ((Collection)object2).isEmpty()) {
                return false;
            }
            object2 = object2.iterator();
            do {
                bl2 = bl3;
                if (!object2.hasNext()) break block2;
            } while (!j.a(((Map.Entry)object2.next()).getValue(), object));
            bl2 = true;
        }
        return bl2;
    }

    public Collection<V> d() {
        Collection<? extends V> collection;
        if (this.c == null) {
            this.c = new kotlin.a.a<V>(){

                @Override
                public int a() {
                    return this.size();
                }

                @Override
                public boolean contains(Object object) {
                    return this.containsValue(object);
                }

                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>(this.entrySet().iterator()){
                        final /* synthetic */ Iterator a;
                        {
                            this.a = iterator;
                        }

                        @Override
                        public boolean hasNext() {
                            return this.a.hasNext();
                        }

                        @Override
                        public V next() {
                            return ((Map.Entry)this.a.next()).getValue();
                        }

                        @Override
                        public void remove() {
                            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                        }
                    };
                }

            };
        }
        if ((collection = this.c) == null) {
            j.a();
        }
        return collection;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.a();
    }

    @Override
    public boolean equals(Object iterator) {
        boolean bl2;
        block5 : {
            c c2 = this;
            boolean bl3 = true;
            if (iterator == c2) {
                return true;
            }
            if (!(iterator instanceof Map)) {
                return false;
            }
            int n2 = this.size();
            if (n2 != (iterator = (Map)((Object)iterator)).size()) {
                return false;
            }
            if ((iterator = (Iterable)iterator.entrySet()) instanceof Collection && ((Collection)((Object)iterator)).isEmpty()) {
                return true;
            }
            iterator = iterator.iterator();
            do {
                bl2 = bl3;
                if (!iterator.hasNext()) break block5;
            } while (this.a((Map.Entry)iterator.next()));
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public V get(Object entry) {
        if ((entry = this.b((K)entry)) != null) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return ((Object)this.entrySet()).hashCode();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final Set<K> keySet() {
        return this.c();
    }

    @Override
    public V put(K k2, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public V remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.b();
    }

    public String toString() {
        return m.a(this.entrySet(), ", ", "{", "}", 0, null, new kotlin.e.a.b<Map.Entry<? extends K, ? extends V>, String>(){

            @Override
            public final String a(Map.Entry<? extends K, ? extends V> entry) {
                j.b(entry, "it");
                return this.b(entry);
            }
        }, 24, null);
    }

    @Override
    public final Collection<V> values() {
        return this.d();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

