/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import androidx.c.c;

public class h<E>
implements Cloneable {
    private static final Object a = new Object();
    private boolean b = false;
    private int[] c;
    private Object[] d;
    private int e;

    public h() {
        this(10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public h(int n2) {
        Object[] arrobject;
        if (n2 == 0) {
            this.c = c.a;
            arrobject = c.c;
        } else {
            n2 = c.a(n2);
            this.c = new int[n2];
            arrobject = new Object[n2];
        }
        this.d = arrobject;
        this.e = 0;
    }

    private void d() {
        int n2 = this.e;
        int[] arrn = this.c;
        Object[] arrobject = this.d;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            int n4 = n3;
            if (object != a) {
                if (i2 != n3) {
                    arrn[n3] = arrn[i2];
                    arrobject[n3] = object;
                    arrobject[i2] = null;
                }
                n4 = n3 + 1;
            }
            n3 = n4;
        }
        this.b = false;
        this.e = n3;
    }

    public h<E> a() {
        try {
            h h2 = (h)super.clone();
            h2.c = (int[])this.c.clone();
            h2.d = (Object[])this.d.clone();
            return h2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError(cloneNotSupportedException);
        }
    }

    public E a(int n2) {
        return this.a(n2, null);
    }

    public E a(int n2, E e2) {
        if ((n2 = c.a(this.c, this.e, n2)) >= 0) {
            if (this.d[n2] == a) {
                return e2;
            }
            return (E)this.d[n2];
        }
        return e2;
    }

    public int b() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }

    public void b(int n2) {
        if ((n2 = c.a(this.c, this.e, n2)) >= 0 && this.d[n2] != a) {
            this.d[n2] = a;
            this.b = true;
        }
    }

    public void b(int n2, E e2) {
        Object[] arrobject;
        int[] arrn;
        int n3 = c.a(this.c, this.e, n2);
        if (n3 >= 0) {
            this.d[n3] = e2;
            return;
        }
        int n4 = n3;
        if (n4 < this.e && this.d[n4] == a) {
            this.c[n4] = n2;
            this.d[n4] = e2;
            return;
        }
        n3 = n4;
        if (this.b) {
            n3 = n4;
            if (this.e >= this.c.length) {
                this.d();
                n3 = c.a(this.c, this.e, n2);
            }
        }
        if (this.e >= this.c.length) {
            n4 = c.a(this.e + 1);
            arrn = new int[n4];
            arrobject = new Object[n4];
            System.arraycopy(this.c, 0, arrn, 0, this.c.length);
            System.arraycopy(this.d, 0, arrobject, 0, this.d.length);
            this.c = arrn;
            this.d = arrobject;
        }
        if (this.e - n3 != 0) {
            arrn = this.c;
            arrobject = this.c;
            n4 = n3 + 1;
            System.arraycopy(arrn, n3, arrobject, n4, this.e - n3);
            System.arraycopy(this.d, n3, this.d, n4, this.e - n3);
        }
        this.c[n3] = n2;
        this.d[n3] = e2;
        ++this.e;
    }

    public void c() {
        int n2 = this.e;
        Object[] arrobject = this.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrobject[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(int n2) {
        this.b(n2);
    }

    public void c(int n2, E e2) {
        int n3;
        if (this.e != 0 && n2 <= this.c[this.e - 1]) {
            this.b(n2, e2);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            this.d();
        }
        if ((n3 = this.e) >= this.c.length) {
            int n4 = c.a(n3 + 1);
            int[] arrn = new int[n4];
            Object[] arrobject = new Object[n4];
            System.arraycopy(this.c, 0, arrn, 0, this.c.length);
            System.arraycopy(this.d, 0, arrobject, 0, this.d.length);
            this.c = arrn;
            this.d = arrobject;
        }
        this.c[n3] = n2;
        this.d[n3] = e2;
        this.e = n3 + 1;
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    public int d(int n2) {
        if (this.b) {
            this.d();
        }
        return this.c[n2];
    }

    public E e(int n2) {
        if (this.b) {
            this.d();
        }
        return (E)this.d[n2];
    }

    public int f(int n2) {
        if (this.b) {
            this.d();
        }
        return c.a(this.c, this.e, n2);
    }

    public String toString() {
        if (this.b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i2 = 0; i2 < this.e; ++i2) {
            if (i2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.d(i2));
            stringBuilder.append('=');
            E e2 = this.e(i2);
            if (e2 != this) {
                stringBuilder.append(e2);
                continue;
            }
            stringBuilder.append("(this Map)");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

