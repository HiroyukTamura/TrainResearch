/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.h;

import b.a.e.h.c;

public final class b<T> {
    final float a;
    int b;
    int c;
    int d;
    T[] e;

    public b() {
        this(16, 0.75f);
    }

    public b(int n2, float f2) {
        this.a = f2;
        n2 = c.a(n2);
        this.b = n2 - 1;
        this.d = (int)(f2 * (float)n2);
        this.e = new Object[n2];
    }

    static int a(int n2) {
        return (n2 *= -1640531527) ^ n2 >>> 16;
    }

    void a() {
        T[] arrT = this.e;
        int n2 = arrT.length;
        int n3 = n2 << 1;
        int n4 = n3 - 1;
        Object[] arrobject = new Object[n3];
        for (int i2 = this.c; i2 != 0; --i2) {
            int n5;
            while (arrT[--n2] == null) {
            }
            int n6 = n5 = b.a(arrT[n2].hashCode()) & n4;
            if (arrobject[n5] != null) {
                do {
                    n5 = n6 = n5 + 1 & n4;
                } while (arrobject[n6] != null);
            }
            arrobject[n6] = arrT[n2];
        }
        this.b = n4;
        this.d = (int)((float)n3 * this.a);
        this.e = arrobject;
    }

    boolean a(int n2, T[] arrT, int n3) {
        --this.c;
        block0 : do {
            int n4 = n2 + 1;
            do {
                T t2;
                if ((t2 = arrT[n4 &= n3]) == null) {
                    arrT[n2] = null;
                    return true;
                }
                int n5 = b.a(t2.hashCode()) & n3;
                if (n2 <= n4 ? n2 >= n5 || n5 > n4 : n2 >= n5 && n5 > n4) {
                    arrT[n2] = t2;
                    n2 = n4;
                    continue block0;
                }
                ++n4;
            } while (true);
            break;
        } while (true);
    }

    public boolean a(T t2) {
        int n2;
        block4 : {
            T[] arrT = this.e;
            int n3 = this.b;
            n2 = b.a(t2.hashCode()) & n3;
            T t3 = arrT[n2];
            int n4 = n2;
            if (t3 != null) {
                if (t3.equals(t2)) {
                    return false;
                }
                do {
                    if ((t3 = arrT[n2 = n2 + 1 & n3]) != null) continue;
                    n4 = n2;
                    break block4;
                } while (!t3.equals(t2));
                return false;
            }
        }
        arrT[n4] = t2;
        this.c = n2 = this.c + 1;
        if (n2 >= this.d) {
            this.a();
        }
        return true;
    }

    public boolean b(T t2) {
        T[] arrT = this.e;
        int n2 = this.b;
        int n3 = b.a(t2.hashCode()) & n2;
        T t3 = arrT[n3];
        if (t3 == null) {
            return false;
        }
        int n4 = n3;
        if (t3.equals(t2)) {
            return this.a(n3, arrT, n2);
        }
        do {
            if ((t3 = arrT[n3 = n4 + 1 & n2]) == null) {
                return false;
            }
            n4 = n3;
        } while (!t3.equals(t2));
        return this.a(n3, arrT, n2);
    }

    public Object[] b() {
        return this.e;
    }
}

