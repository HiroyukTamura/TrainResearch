/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import androidx.c.a;
import androidx.c.c;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    public g() {
        this.f = c.a;
        this.g = c.c;
        this.h = 0;
    }

    public g(int n2) {
        if (n2 == 0) {
            this.f = c.a;
            this.g = c.c;
        } else {
            this.e(n2);
        }
        this.h = 0;
    }

    public g(g<K, V> g2) {
        this();
        if (g2 != null) {
            this.a(g2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int a(int[] arrn, int n2, int n3) {
        try {
            return c.a(arrn, n2, n3);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ConcurrentModificationException();
        }
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
                            // MONITORENTER : androidx.c.a.class
                            if (e >= 10) break block9;
                            arrobject[0] = d;
                            arrobject[1] = arrn;
                            break block10;
                        }
                        if (arrn.length != 4) return;
                        // MONITORENTER : androidx.c.a.class
                        if (c >= 10) break block11;
                        arrobject[0] = b;
                        arrobject[1] = arrn;
                        break block12;
                    }
                    for (n2 = (n2 << 1) - 1; n2 >= 2; --n2) {
                        arrobject[n2] = null;
                    }
                    d = arrobject;
                    ++e;
                }
                // MONITOREXIT : androidx.c.a.class
                return;
            }
            for (n2 = (n2 << 1) - 1; n2 >= 2; --n2) {
                arrobject[n2] = null;
            }
            b = arrobject;
            ++c;
        }
        // MONITOREXIT : androidx.c.a.class
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(int n2) {
        if (n2 == 8) {
            synchronized (a.class) {
                if (d != null) {
                    Object[] arrobject = d;
                    this.g = arrobject;
                    d = (Object[])arrobject[0];
                    this.f = (int[])arrobject[1];
                    arrobject[1] = null;
                    arrobject[0] = null;
                    --e;
                    return;
                }
            }
        } else if (n2 == 4) {
            synchronized (a.class) {
                if (b != null) {
                    Object[] arrobject = b;
                    this.g = arrobject;
                    b = (Object[])arrobject[0];
                    this.f = (int[])arrobject[1];
                    arrobject[1] = null;
                    arrobject[0] = null;
                    --c;
                    return;
                }
            }
        }
        this.f = new int[n2];
        this.g = new Object[n2 << 1];
    }

    int a() {
        int n2;
        int n3 = this.h;
        if (n3 == 0) {
            return -1;
        }
        int n4 = g.a(this.f, n3, 0);
        if (n4 < 0) {
            return n4;
        }
        if (this.g[n4 << 1] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.f[n2] == 0; ++n2) {
            if (this.g[n2 << 1] != null) continue;
            return n2;
        }
        for (n3 = n4 - 1; n3 >= 0 && this.f[n3] == 0; --n3) {
            if (this.g[n3 << 1] != null) continue;
            return n3;
        }
        return n2;
    }

    public int a(Object object) {
        if (object == null) {
            return this.a();
        }
        return this.a(object, object.hashCode());
    }

    int a(Object object, int n2) {
        int n3;
        int n4 = this.h;
        if (n4 == 0) {
            return -1;
        }
        int n5 = g.a(this.f, n4, n2);
        if (n5 < 0) {
            return n5;
        }
        if (object.equals(this.g[n5 << 1])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.f[n3] == n2; ++n3) {
            if (!object.equals(this.g[n3 << 1])) continue;
            return n3;
        }
        for (n4 = n5 - 1; n4 >= 0 && this.f[n4] == n2; --n4) {
            if (!object.equals(this.g[n4 << 1])) continue;
            return n4;
        }
        return n3;
    }

    public V a(int n2, V v2) {
        n2 = (n2 << 1) + 1;
        Object object = this.g[n2];
        this.g[n2] = v2;
        return (V)object;
    }

    public void a(int n2) {
        int n3 = this.h;
        if (this.f.length < n2) {
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            this.e(n2);
            if (this.h > 0) {
                System.arraycopy(arrn, 0, this.f, 0, n3);
                System.arraycopy(arrobject, 0, this.g, 0, n3 << 1);
            }
            g.a(arrn, arrobject, n3);
        }
        if (this.h == n3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public void a(g<? extends K, ? extends V> g2) {
        int n2 = g2.h;
        this.a(this.h + n2);
        int n3 = this.h;
        if (n3 == 0) {
            if (n2 > 0) {
                System.arraycopy(g2.f, 0, this.f, 0, n2);
                System.arraycopy(g2.g, 0, this.g, 0, n2 << 1);
                this.h = n2;
                return;
            }
        } else {
            for (int i2 = 0; i2 < n2; ++i2) {
                this.put(g2.b(i2), g2.c(i2));
            }
        }
    }

    int b(Object object) {
        int n2 = this.h * 2;
        Object[] arrobject = this.g;
        if (object == null) {
            for (int i2 = 1; i2 < n2; i2 += 2) {
                if (arrobject[i2] != null) continue;
                return i2 >> 1;
            }
        } else {
            for (int i3 = 1; i3 < n2; i3 += 2) {
                if (!object.equals(arrobject[i3])) continue;
                return i3 >> 1;
            }
        }
        return -1;
    }

    public K b(int n2) {
        return (K)this.g[n2 << 1];
    }

    public V c(int n2) {
        return (V)this.g[(n2 << 1) + 1];
    }

    public void clear() {
        if (this.h > 0) {
            int[] arrn = this.f;
            Object[] arrobject = this.g;
            int n2 = this.h;
            this.f = c.a;
            this.g = c.c;
            this.h = 0;
            g.a(arrn, arrobject, n2);
        }
        if (this.h <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object object) {
        return this.a(object) >= 0;
    }

    public boolean containsValue(Object object) {
        return this.b(object) >= 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public V d(int n2) {
        Object[] arrobject = this.g;
        int n3 = n2 << 1;
        Object object = arrobject[n3 + 1];
        int n4 = this.h;
        int n5 = 0;
        if (n4 <= 1) {
            g.a(this.f, this.g, n4);
            this.f = c.a;
            this.g = c.c;
            n2 = n5;
        } else {
            int n6 = n4 - 1;
            int n7 = this.f.length;
            n5 = 8;
            if (n7 > 8 && this.h < this.f.length / 3) {
                if (n4 > 8) {
                    n5 = n4 + (n4 >> 1);
                }
                int[] arrn = this.f;
                Object[] arrobject2 = this.g;
                this.e(n5);
                if (n4 != this.h) throw new ConcurrentModificationException();
                if (n2 > 0) {
                    System.arraycopy(arrn, 0, this.f, 0, n2);
                    System.arraycopy(arrobject2, 0, this.g, 0, n3);
                }
                if (n2 < n6) {
                    n5 = n2 + 1;
                    int[] arrn2 = this.f;
                    n7 = n6 - n2;
                    System.arraycopy(arrn, n5, arrn2, n2, n7);
                    System.arraycopy(arrobject2, n5 << 1, this.g, n3, n7 << 1);
                }
            } else {
                if (n2 < n6) {
                    int[] arrn = this.f;
                    n5 = n2 + 1;
                    int[] arrn3 = this.f;
                    n7 = n6 - n2;
                    System.arraycopy(arrn, n5, arrn3, n2, n7);
                    System.arraycopy(this.g, n5 << 1, this.g, n3, n7 << 1);
                }
                Object[] arrobject3 = this.g;
                n2 = n6 << 1;
                arrobject3[n2] = null;
                this.g[n2 + 1] = null;
            }
            n2 = n6;
        }
        if (n4 != this.h) throw new ConcurrentModificationException();
        this.h = n2;
        return (V)object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof g)) {
            if (!(object instanceof Map)) {
                return false;
            }
            object = (Map)object;
            if (this.size() != object.size()) {
                return false;
            }
        } else {
            object = (g)object;
            if (this.size() != ((g)object).size()) {
                return false;
            }
            int n2 = 0;
            try {
                do {
                    if (n2 >= this.h) {
                        return true;
                    }
                    K k2 = this.b(n2);
                    V v2 = this.c(n2);
                    V v3 = ((g)object).get(k2);
                    if (v2 == null) {
                        if (v3 != null) break;
                        if (!((g)object).containsKey(k2)) {
                            return false;
                        }
                    } else {
                        boolean bl2 = v2.equals(v3);
                        if (!bl2) {
                            return false;
                        }
                    }
                    ++n2;
                } while (true);
            }
            catch (ClassCastException | NullPointerException runtimeException) {
                return false;
            }
            return false;
        }
        int n3 = 0;
        try {
            do {
                if (n3 >= this.h) {
                    return true;
                }
                K k3 = this.b(n3);
                V v4 = this.c(n3);
                Object v5 = object.get(k3);
                if (v4 == null) {
                    if (v5 != null) break;
                    if (!object.containsKey(k3)) {
                        return false;
                    }
                } else {
                    boolean bl3 = v4.equals(v5);
                    if (!bl3) {
                        return false;
                    }
                }
                ++n3;
            } while (true);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
        return false;
    }

    public V get(Object object) {
        int n2 = this.a(object);
        if (n2 >= 0) {
            return (V)this.g[(n2 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] arrn = this.f;
        Object[] arrobject = this.g;
        int n2 = this.h;
        int n3 = 0;
        int n4 = 1;
        int n5 = 0;
        while (n3 < n2) {
            Object object = arrobject[n4];
            int n6 = arrn[n3];
            int n7 = object == null ? 0 : object.hashCode();
            n5 += n7 ^ n6;
            ++n3;
            n4 += 2;
        }
        return n5;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K object, V v2) {
        Object[] arrobject;
        int n2;
        Object[] arrobject2;
        int n3;
        int n4 = this.h;
        if (object == null) {
            n3 = this.a();
            n2 = 0;
        } else {
            n2 = object.hashCode();
            n3 = this.a(object, n2);
        }
        if (n3 >= 0) {
            n3 = (n3 << 1) + 1;
            object = this.g[n3];
            this.g[n3] = v2;
            return (V)object;
        }
        int n5 = n3;
        if (n4 >= this.f.length) {
            n3 = 4;
            if (n4 >= 8) {
                n3 = (n4 >> 1) + n4;
            } else if (n4 >= 4) {
                n3 = 8;
            }
            arrobject2 = this.f;
            arrobject = this.g;
            this.e(n3);
            if (n4 == this.h) {
                if (this.f.length > 0) {
                    System.arraycopy(arrobject2, 0, this.f, 0, arrobject2.length);
                    System.arraycopy(arrobject, 0, this.g, 0, arrobject.length);
                }
                g.a(arrobject2, arrobject, n4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (n5 < n4) {
            arrobject2 = this.f;
            arrobject = this.f;
            n3 = n5 + 1;
            System.arraycopy(arrobject2, n5, arrobject, n3, n4 - n5);
            System.arraycopy(this.g, n5 << 1, this.g, n3 << 1, this.h - n5 << 1);
        }
        if (n4 == this.h && n5 < this.f.length) {
            this.f[n5] = n2;
            arrobject2 = this.g;
            n3 = n5 << 1;
            arrobject2[n3] = (int)object;
            this.g[n3 + 1] = v2;
            ++this.h;
            return null;
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object object) {
        int n2 = this.a(object);
        if (n2 >= 0) {
            return this.d(n2);
        }
        return null;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.h * 28);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.h; ++i2) {
            Object object;
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            if ((object = this.b(i2)) != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            object = this.c(i2);
            if (object != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

