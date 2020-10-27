package p122k.p123a.p124a.p125a.p128G;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: k.a.a.a.G.d */
public class C2434d<K, V> implements Map<K, V> {

    /* renamed from: a */
    protected final C2430a<? super K> f3989a;

    /* renamed from: b */
    protected LinkedList<C2435a<K, V>>[] f3990b;

    /* renamed from: c */
    protected int f3991c = 0;

    /* renamed from: d */
    protected int f3992d = 12;

    /* renamed from: e */
    protected int f3993e = 1;

    /* renamed from: k.a.a.a.G.d$a */
    public static class C2435a<K, V> {

        /* renamed from: a */
        public final K f3994a;

        /* renamed from: b */
        public V f3995b;

        public C2435a(K k, V v) {
            this.f3994a = k;
            this.f3995b = v;
        }

        public String toString() {
            return this.f3994a.toString() + ":" + this.f3995b.toString();
        }
    }

    public C2434d(C2430a<? super K> aVar) {
        this.f3989a = aVar == null ? C2441j.f4006a : aVar;
        this.f3990b = new LinkedList[8];
    }

    public void clear() {
        this.f3990b = new LinkedList[16];
        this.f3991c = 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int a = this.f3989a.mo34092a(obj);
        LinkedList<C2435a<K, V>>[] linkedListArr = this.f3990b;
        LinkedList<C2435a<K, V>> linkedList = linkedListArr[a & (linkedListArr.length - 1)];
        if (linkedList == null) {
            return null;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C2435a aVar = (C2435a) it.next();
            if (this.f3989a.mo34093a(aVar.f3994a, obj)) {
                return aVar.f3995b;
            }
        }
        return null;
    }

    public int hashCode() {
        C2435a aVar;
        int i = 0;
        for (LinkedList<C2435a<K, V>> linkedList : this.f3990b) {
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext() && (aVar = (C2435a) it.next()) != null) {
                    i = C1532a.m2145b(i, this.f3989a.mo34092a(aVar.f3994a));
                }
            }
        }
        return C1532a.m2119a(i, this.f3991c);
    }

    public boolean isEmpty() {
        return this.f3991c == 0;
    }

    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public V put(K k, V v) {
        C2435a aVar;
        if (k == null) {
            return null;
        }
        if (this.f3991c > this.f3992d) {
            LinkedList<C2435a<K, V>>[] linkedListArr = this.f3990b;
            this.f3993e += 4;
            int length = linkedListArr.length * 2;
            this.f3990b = new LinkedList[length];
            double d = (double) length;
            Double.isNaN(d);
            Double.isNaN(d);
            Double.isNaN(d);
            this.f3992d = (int) (d * 0.75d);
            int i = this.f3991c;
            for (LinkedList<C2435a<K, V>> linkedList : linkedListArr) {
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext() && (aVar = (C2435a) it.next()) != null) {
                        put(aVar.f3994a, aVar.f3995b);
                    }
                }
            }
            this.f3991c = i;
        }
        int a = this.f3989a.mo34092a(k);
        LinkedList<C2435a<K, V>>[] linkedListArr2 = this.f3990b;
        int length2 = a & (linkedListArr2.length - 1);
        LinkedList<C2435a<K, V>> linkedList2 = linkedListArr2[length2];
        if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
            linkedListArr2[length2] = linkedList2;
        }
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            C2435a aVar2 = (C2435a) it2.next();
            if (this.f3989a.mo34093a(aVar2.f3994a, k)) {
                V v2 = aVar2.f3995b;
                aVar2.f3995b = v;
                this.f3991c++;
                return v2;
            }
        }
        linkedList2.add(new C2435a(k, v));
        this.f3991c++;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f3991c;
    }

    public String toString() {
        C2435a aVar;
        if (this.f3991c == 0) {
            return "{}";
        }
        StringBuilder a = C0681a.m329a('{');
        boolean z = true;
        for (LinkedList<C2435a<K, V>> linkedList : this.f3990b) {
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext() && (aVar = (C2435a) it.next()) != null) {
                    if (z) {
                        z = false;
                    } else {
                        a.append(", ");
                    }
                    a.append(aVar.toString());
                }
            }
        }
        a.append('}');
        return a.toString();
    }

    public Collection<V> values() {
        ArrayList arrayList = new ArrayList(this.f3991c);
        for (LinkedList<C2435a<K, V>> linkedList : this.f3990b) {
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((C2435a) it.next()).f3995b);
                }
            }
        }
        return arrayList;
    }
}
