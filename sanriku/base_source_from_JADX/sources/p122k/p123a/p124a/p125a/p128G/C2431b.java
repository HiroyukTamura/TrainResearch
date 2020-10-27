package p122k.p123a.p124a.p125a.p128G;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: k.a.a.a.G.b */
public class C2431b<T> implements Set<T> {

    /* renamed from: a */
    protected final C2430a<? super T> f3978a;

    /* renamed from: b */
    protected T[][] f3979b;

    /* renamed from: c */
    protected int f3980c;

    /* renamed from: d */
    protected int f3981d;

    /* renamed from: e */
    protected int f3982e;

    /* renamed from: f */
    protected int f3983f;

    /* renamed from: k.a.a.a.G.b$a */
    protected class C2432a implements Iterator<T> {

        /* renamed from: a */
        final T[] f3984a;

        /* renamed from: b */
        int f3985b = 0;

        /* renamed from: c */
        boolean f3986c = true;

        public C2432a(T[] tArr) {
            this.f3984a = tArr;
        }

        public boolean hasNext() {
            return this.f3985b < this.f3984a.length;
        }

        public T next() {
            if (hasNext()) {
                this.f3986c = false;
                T[] tArr = this.f3984a;
                int i = this.f3985b;
                this.f3985b = i + 1;
                return tArr[i];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (!this.f3986c) {
                C2431b.this.remove(this.f3984a[this.f3985b - 1]);
                this.f3986c = true;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static {
        Class<C2431b> cls = C2431b.class;
    }

    public C2431b() {
        this((C2430a) null, 16, 8);
    }

    public C2431b(C2430a<? super T> aVar, int i, int i2) {
        this.f3980c = 0;
        this.f3981d = (int) Math.floor(12.0d);
        this.f3982e = 1;
        this.f3983f = 8;
        this.f3978a = aVar == null ? C2441j.f4006a : aVar;
        this.f3979b = mo34145b(i);
        this.f3983f = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T mo34143a(Object obj) {
        return obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T[] mo34144a(int i) {
        return new Object[i];
    }

    public final boolean add(T t) {
        return mo34202d(t) == t;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (Object next : collection) {
            if (mo34202d(next) != next) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo34197b(T t) {
        if (t == null) {
            return false;
        }
        T[] tArr = this.f3979b[mo34198c(t)];
        T t2 = null;
        if (tArr != null) {
            int length = tArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    T t3 = tArr[i];
                    if (t3 == null) {
                        break;
                    } else if (this.f3978a.mo34093a(t3, t)) {
                        t2 = t3;
                        break;
                    } else {
                        i++;
                    }
                } else {
                    break;
                }
            }
        }
        return t2 != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public T[][] mo34145b(int i) {
        return new Object[i][];
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo34198c(T t) {
        return this.f3978a.mo34092a(t) & (this.f3979b.length - 1);
    }

    public void clear() {
        this.f3979b = mo34145b(16);
        this.f3980c = 0;
        this.f3981d = (int) Math.floor(12.0d);
    }

    public final boolean contains(Object obj) {
        return mo34197b(mo34143a(obj));
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof C2431b) {
            for (T[] tArr : ((C2431b) collection).f3979b) {
                if (tArr != null) {
                    int length = tArr.length;
                    int i = 0;
                    while (i < length) {
                        T t = tArr[i];
                        if (t == null) {
                            continue;
                            break;
                        } else if (!mo34197b(mo34143a((Object) t))) {
                            return false;
                        } else {
                            i++;
                        }
                    }
                    continue;
                }
            }
            return true;
        }
        for (Object a : collection) {
            if (!mo34197b(mo34143a((Object) a))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final T mo34202d(T t) {
        T[] tArr;
        int i = 0;
        if (this.f3980c > this.f3981d) {
            T[][] tArr2 = this.f3979b;
            this.f3982e += 4;
            int length = tArr2.length * 2;
            T[][] b = mo34145b(length);
            int[] iArr = new int[b.length];
            this.f3979b = b;
            double d = (double) length;
            Double.isNaN(d);
            Double.isNaN(d);
            this.f3981d = (int) (d * 0.75d);
            for (T[] tArr3 : tArr2) {
                if (tArr3 != null) {
                    for (T t2 : tArr3) {
                        if (t2 == null) {
                            break;
                        }
                        int c = mo34198c(t2);
                        int i2 = iArr[c];
                        if (i2 == 0) {
                            tArr = mo34144a(this.f3983f);
                            b[c] = tArr;
                        } else {
                            tArr = b[c];
                            if (i2 == tArr.length) {
                                tArr = Arrays.copyOf(tArr, tArr.length * 2);
                                b[c] = tArr;
                            }
                        }
                        tArr[i2] = t2;
                        iArr[c] = iArr[c] + 1;
                    }
                }
            }
        }
        int c2 = mo34198c(t);
        T[] tArr4 = this.f3979b[c2];
        if (tArr4 != null) {
            while (true) {
                if (i >= tArr4.length) {
                    int length2 = tArr4.length;
                    T[] copyOf = Arrays.copyOf(tArr4, tArr4.length * 2);
                    this.f3979b[c2] = copyOf;
                    copyOf[length2] = t;
                    break;
                }
                T t3 = tArr4[i];
                if (t3 == null) {
                    tArr4[i] = t;
                    break;
                } else if (this.f3978a.mo34093a(t3, t)) {
                    return t3;
                } else {
                    i++;
                }
            }
        } else {
            T[] a = mo34144a(this.f3983f);
            a[0] = t;
            this.f3979b[c2] = a;
        }
        this.f3980c++;
        return t;
    }

    /* renamed from: e */
    public boolean mo34203e(T t) {
        T[] tArr;
        T t2;
        if (t == null || (tArr = this.f3979b[mo34198c(t)]) == null) {
            return false;
        }
        int i = 0;
        while (i < tArr.length && (t2 = tArr[i]) != null) {
            if (this.f3978a.mo34093a(t2, t)) {
                System.arraycopy(tArr, i + 1, tArr, i, (tArr.length - i) - 1);
                tArr[tArr.length - 1] = null;
                this.f3980c--;
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2431b)) {
            return false;
        }
        C2431b bVar = (C2431b) obj;
        if (bVar.f3980c != this.f3980c) {
            return false;
        }
        return containsAll(bVar);
    }

    public int hashCode() {
        int i = 0;
        for (T[] tArr : this.f3979b) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t == null) {
                        break;
                    }
                    i = C1532a.m2145b(i, this.f3978a.mo34092a(t));
                }
            }
        }
        return C1532a.m2119a(i, this.f3980c);
    }

    public final boolean isEmpty() {
        return this.f3980c == 0;
    }

    public Iterator<T> iterator() {
        return new C2432a(toArray());
    }

    public final boolean remove(Object obj) {
        return mo34203e(mo34143a(obj));
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object a : collection) {
            z |= mo34203e(mo34143a((Object) a));
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        T[][] tArr = this.f3979b;
        int length = tArr.length;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            T[] tArr2 = tArr[i2];
            if (tArr2 != null) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < tArr2.length && tArr2[i3] != null) {
                    if (collection.contains(tArr2[i3])) {
                        if (i3 != i4) {
                            tArr2[i4] = tArr2[i3];
                        }
                        i4++;
                        i++;
                    }
                    i3++;
                }
                i += i4;
                while (i4 < i3) {
                    tArr2[i4] = null;
                    i4++;
                }
            }
        }
        if (i != this.f3980c) {
            z = true;
        }
        this.f3980c = i;
        return z;
    }

    public final int size() {
        return this.f3980c;
    }

    public T[] toArray() {
        T[] a = mo34144a(this.f3980c);
        int i = 0;
        for (T[] tArr : this.f3979b) {
            if (tArr != null) {
                int length = tArr.length;
                int i2 = 0;
                while (i2 < length) {
                    T t = tArr[i2];
                    if (t == null) {
                        break;
                    }
                    a[i] = t;
                    i2++;
                    i++;
                }
            }
        }
        return a;
    }

    public String toString() {
        if (this.f3980c == 0) {
            return "{}";
        }
        StringBuilder a = C0681a.m329a('{');
        boolean z = true;
        for (T[] tArr : this.f3979b) {
            if (tArr != null) {
                for (T t : tArr) {
                    if (t == null) {
                        break;
                    }
                    if (z) {
                        z = false;
                    } else {
                        a.append(", ");
                    }
                    a.append(t.toString());
                }
            }
        }
        a.append('}');
        return a.toString();
    }

    public <U> U[] toArray(U[] uArr) {
        int length = uArr.length;
        int i = this.f3980c;
        U[] uArr2 = uArr;
        if (length < i) {
            uArr2 = Arrays.copyOf(uArr, i);
        }
        int i2 = 0;
        for (T[] tArr : this.f3979b) {
            if (tArr != null) {
                int length2 = tArr.length;
                int i3 = 0;
                while (i3 < length2) {
                    T t = tArr[i3];
                    if (t == null) {
                        break;
                    }
                    uArr2[i2] = t;
                    i3++;
                    i2++;
                }
            }
        }
        return uArr2;
    }
}
