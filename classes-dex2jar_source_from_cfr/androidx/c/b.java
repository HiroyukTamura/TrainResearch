/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import androidx.c.c;
import androidx.c.f;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
implements Collection<E>,
Set<E> {
    private static final int[] c = new int[0];
    private static final Object[] d = new Object[0];
    private static Object[] e;
    private static int f;
    private static Object[] g;
    private static int h;
    Object[] a;
    int b;
    private int[] i;
    private f<E, E> j;

    public b() {
        this(0);
    }

    public b(int n2) {
        if (n2 == 0) {
            this.i = c;
            this.a = d;
        } else {
            this.d(n2);
        }
        this.b = 0;
    }

    private int a() {
        int n2;
        int n3 = this.b;
        if (n3 == 0) {
            return -1;
        }
        int n4 = c.a(this.i, n3, 0);
        if (n4 < 0) {
            return n4;
        }
        if (this.a[n4] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.i[n2] == 0; ++n2) {
            if (this.a[n2] != null) continue;
            return n2;
        }
        for (n3 = n4 - 1; n3 >= 0 && this.i[n3] == 0; --n3) {
            if (this.a[n3] != null) continue;
            return n3;
        }
        return n2;
    }

    private int a(Object object, int n2) {
        int n3;
        int n4 = this.b;
        if (n4 == 0) {
            return -1;
        }
        int n5 = c.a(this.i, n4, n2);
        if (n5 < 0) {
            return n5;
        }
        if (object.equals(this.a[n5])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.i[n3] == n2; ++n3) {
            if (!object.equals(this.a[n3])) continue;
            return n3;
        }
        for (n4 = n5 - 1; n4 >= 0 && this.i[n4] == n2; --n4) {
            if (!object.equals(this.a[n4])) continue;
            return n4;
        }
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static void a(int[] arrn, Object[] arrobject, int n2) {
        block11 : {
            block12 : {
                block9 : {
                    block10 : {
                        block8 : {
                            if (arrn.length != 8) break block8;
                            // MONITORENTER : androidx.c.b.class
                            if (h >= 10) break block9;
                            arrobject[0] = g;
                            arrobject[1] = arrn;
                            --n2;
                            break block10;
                        }
                        if (arrn.length != 4) return;
                        // MONITORENTER : androidx.c.b.class
                        if (f >= 10) break block11;
                        arrobject[0] = e;
                        arrobject[1] = arrn;
                        --n2;
                        break block12;
                    }
                    while (n2 >= 2) {
                        arrobject[n2] = null;
                        --n2;
                    }
                    g = arrobject;
                    ++h;
                }
                // MONITOREXIT : androidx.c.b.class
                return;
            }
            while (n2 >= 2) {
                arrobject[n2] = null;
                --n2;
            }
            e = arrobject;
            ++f;
        }
        // MONITOREXIT : androidx.c.b.class
    }

    private f<E, E> b() {
        if (this.j == null) {
            this.j = new f<E, E>(){

                @Override
                protected int a() {
                    return b.this.b;
                }

                @Override
                protected int a(Object object) {
                    return b.this.a(object);
                }

                @Override
                protected Object a(int n2, int n3) {
                    return b.this.a[n2];
                }

                @Override
                protected E a(int n2, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override
                protected void a(int n2) {
                    b.this.c(n2);
                }

                @Override
                protected void a(E e2, E e3) {
                    b.this.add(e2);
                }

                @Override
                protected int b(Object object) {
                    return b.this.a(object);
                }

                @Override
                protected Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override
                protected void c() {
                    b.this.clear();
                }
            };
        }
        return this.j;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(int n2) {
        if (n2 == 8) {
            synchronized (b.class) {
                if (g != null) {
                    Object[] arrobject = g;
                    this.a = arrobject;
                    g = (Object[])arrobject[0];
                    this.i = (int[])arrobject[1];
                    arrobject[1] = null;
                    arrobject[0] = null;
                    --h;
                    return;
                }
            }
        } else if (n2 == 4) {
            synchronized (b.class) {
                if (e != null) {
                    Object[] arrobject = e;
                    this.a = arrobject;
                    e = (Object[])arrobject[0];
                    this.i = (int[])arrobject[1];
                    arrobject[1] = null;
                    arrobject[0] = null;
                    --f;
                    return;
                }
            }
        }
        this.i = new int[n2];
        this.a = new Object[n2];
    }

    public int a(Object object) {
        if (object == null) {
            return this.a();
        }
        return this.a(object, object.hashCode());
    }

    public void a(int n2) {
        if (this.i.length < n2) {
            int[] arrn = this.i;
            Object[] arrobject = this.a;
            this.d(n2);
            if (this.b > 0) {
                System.arraycopy(arrn, 0, this.i, 0, this.b);
                System.arraycopy(arrobject, 0, this.a, 0, this.b);
            }
            b.a(arrn, arrobject, this.b);
        }
    }

    @Override
    public boolean add(E e2) {
        int n2;
        Object[] arrobject;
        int[] arrn;
        int n3;
        if (e2 == null) {
            n3 = this.a();
            n2 = 0;
        } else {
            n2 = e2.hashCode();
            n3 = this.a(e2, n2);
        }
        if (n3 >= 0) {
            return false;
        }
        int n4 = n3;
        if (this.b >= this.i.length) {
            int n5 = this.b;
            n3 = 4;
            if (n5 >= 8) {
                n3 = this.b;
                n3 = (this.b >> 1) + n3;
            } else if (this.b >= 4) {
                n3 = 8;
            }
            arrn = this.i;
            arrobject = this.a;
            this.d(n3);
            if (this.i.length > 0) {
                System.arraycopy(arrn, 0, this.i, 0, arrn.length);
                System.arraycopy(arrobject, 0, this.a, 0, arrobject.length);
            }
            b.a(arrn, arrobject, this.b);
        }
        if (n4 < this.b) {
            arrn = this.i;
            arrobject = this.i;
            n3 = n4 + 1;
            System.arraycopy(arrn, n4, arrobject, n3, this.b - n4);
            System.arraycopy(this.a, n4, this.a, n3, this.b - n4);
        }
        this.i[n4] = n2;
        this.a[n4] = e2;
        ++this.b;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> object) {
        this.a(this.b + object.size());
        object = object.iterator();
        boolean bl2 = false;
        while (object.hasNext()) {
            bl2 |= this.add(object.next());
        }
        return bl2;
    }

    public E b(int n2) {
        return (E)this.a[n2];
    }

    public E c(int n2) {
        Object object = this.a[n2];
        if (this.b <= 1) {
            b.a(this.i, this.a, this.b);
            this.i = c;
            this.a = d;
            this.b = 0;
            return (E)object;
        }
        int n3 = this.i.length;
        int n4 = 8;
        if (n3 > 8 && this.b < this.i.length / 3) {
            if (this.b > 8) {
                n4 = this.b;
                n4 = (this.b >> 1) + n4;
            }
            int[] arrn = this.i;
            Object[] arrobject = this.a;
            this.d(n4);
            --this.b;
            if (n2 > 0) {
                System.arraycopy(arrn, 0, this.i, 0, n2);
                System.arraycopy(arrobject, 0, this.a, 0, n2);
            }
            if (n2 < this.b) {
                n4 = n2 + 1;
                System.arraycopy(arrn, n4, this.i, n2, this.b - n2);
                System.arraycopy(arrobject, n4, this.a, n2, this.b - n2);
                return (E)object;
            }
        } else {
            --this.b;
            if (n2 < this.b) {
                int[] arrn = this.i;
                n4 = n2 + 1;
                System.arraycopy(arrn, n4, this.i, n2, this.b - n2);
                System.arraycopy(this.a, n4, this.a, n2, this.b - n2);
            }
            this.a[this.b] = null;
        }
        return (E)object;
    }

    @Override
    public void clear() {
        if (this.b != 0) {
            b.a(this.i, this.a, this.b);
            this.i = c;
            this.a = d;
            this.b = 0;
        }
    }

    @Override
    public boolean contains(Object object) {
        return this.a(object) >= 0;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        object = (Set)object;
        if (this.size() != object.size()) {
            return false;
        }
        int n2 = 0;
        try {
            do {
                if (n2 >= this.b) {
                    return true;
                }
                boolean bl2 = object.contains(this.b(n2));
                if (!bl2) {
                    return false;
                }
                ++n2;
            } while (true);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int[] arrn = this.i;
        int n2 = this.b;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 += arrn[i2];
        }
        return n3;
    }

    @Override
    public boolean isEmpty() {
        return this.b <= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return this.b().e().iterator();
    }

    @Override
    public boolean remove(Object object) {
        int n2 = this.a(object);
        if (n2 >= 0) {
            this.c(n2);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> object) {
        object = object.iterator();
        boolean bl2 = false;
        while (object.hasNext()) {
            bl2 |= this.remove(object.next());
        }
        return bl2;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean bl2 = false;
        for (int i2 = this.b - 1; i2 >= 0; --i2) {
            if (collection.contains(this.a[i2])) continue;
            this.c(i2);
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public int size() {
        return this.b;
    }

    @Override
    public Object[] toArray() {
        Object[] arrobject = new Object[this.b];
        System.arraycopy(this.a, 0, arrobject, 0, this.b);
        return arrobject;
    }

    @Override
    public <T> T[] toArray(T[] arrT) {
        Object[] arrobject = arrT;
        if (arrT.length < this.b) {
            arrobject = (Object[])Array.newInstance(arrT.getClass().getComponentType(), this.b);
        }
        System.arraycopy(this.a, 0, arrobject, 0, this.b);
        if (arrobject.length > this.b) {
            arrobject[this.b] = null;
        }
        return arrobject;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.b * 14);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.b; ++i2) {
            E e2;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((e2 = this.b(i2)) != this) {
                stringBuilder.append(e2);
                continue;
            }
            stringBuilder.append("(this Set)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}

