/*
 * Decompiled with CFR 0.139.
 */
package androidx.c;

import androidx.c.c;

public class d<E>
implements Cloneable {
    private static final Object a = new Object();
    private boolean b = false;
    private long[] c;
    private Object[] d;
    private int e;

    public d() {
        this(10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public d(int n2) {
        Object[] arrobject;
        if (n2 == 0) {
            this.c = c.b;
            arrobject = c.c;
        } else {
            n2 = c.b(n2);
            this.c = new long[n2];
            arrobject = new Object[n2];
        }
        this.d = arrobject;
        this.e = 0;
    }

    private void d() {
        int n2 = this.e;
        long[] arrl = this.c;
        Object[] arrobject = this.d;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            int n4 = n3;
            if (object != a) {
                if (i2 != n3) {
                    arrl[n3] = arrl[i2];
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

    public d<E> a() {
        try {
            d d2 = (d)super.clone();
            d2.c = (long[])this.c.clone();
            d2.d = (Object[])this.d.clone();
            return d2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError(cloneNotSupportedException);
        }
    }

    public E a(long l2) {
        return this.a(l2, null);
    }

    public E a(long l2, E e2) {
        int n2 = c.a(this.c, this.e, l2);
        if (n2 >= 0) {
            if (this.d[n2] == a) {
                return e2;
            }
            return (E)this.d[n2];
        }
        return e2;
    }

    public void a(int n2) {
        if (this.d[n2] != a) {
            this.d[n2] = a;
            this.b = true;
        }
    }

    public int b() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }

    public long b(int n2) {
        if (this.b) {
            this.d();
        }
        return this.c[n2];
    }

    public void b(long l2) {
        int n2 = c.a(this.c, this.e, l2);
        if (n2 >= 0 && this.d[n2] != a) {
            this.d[n2] = a;
            this.b = true;
        }
    }

    public void b(long l2, E e2) {
        Object[] arrobject;
        long[] arrl;
        int n2 = c.a(this.c, this.e, l2);
        if (n2 >= 0) {
            this.d[n2] = e2;
            return;
        }
        int n3 = n2;
        if (n3 < this.e && this.d[n3] == a) {
            this.c[n3] = l2;
            this.d[n3] = e2;
            return;
        }
        n2 = n3;
        if (this.b) {
            n2 = n3;
            if (this.e >= this.c.length) {
                this.d();
                n2 = c.a(this.c, this.e, l2);
            }
        }
        if (this.e >= this.c.length) {
            n3 = c.b(this.e + 1);
            arrl = new long[n3];
            arrobject = new Object[n3];
            System.arraycopy(this.c, 0, arrl, 0, this.c.length);
            System.arraycopy(this.d, 0, arrobject, 0, this.d.length);
            this.c = arrl;
            this.d = arrobject;
        }
        if (this.e - n2 != 0) {
            arrl = this.c;
            arrobject = this.c;
            n3 = n2 + 1;
            System.arraycopy(arrl, n2, arrobject, n3, this.e - n2);
            System.arraycopy(this.d, n2, this.d, n3, this.e - n2);
        }
        this.c[n2] = l2;
        this.d[n2] = e2;
        ++this.e;
    }

    public int c(long l2) {
        if (this.b) {
            this.d();
        }
        return c.a(this.c, this.e, l2);
    }

    public E c(int n2) {
        if (this.b) {
            this.d();
        }
        return (E)this.d[n2];
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

    public void c(long l2, E e2) {
        int n2;
        if (this.e != 0 && l2 <= this.c[this.e - 1]) {
            this.b(l2, e2);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            this.d();
        }
        if ((n2 = this.e) >= this.c.length) {
            int n3 = c.b(n2 + 1);
            long[] arrl = new long[n3];
            Object[] arrobject = new Object[n3];
            System.arraycopy(this.c, 0, arrl, 0, this.c.length);
            System.arraycopy(this.d, 0, arrobject, 0, this.d.length);
            this.c = arrl;
            this.d = arrobject;
        }
        this.c[n2] = l2;
        this.d[n2] = e2;
        this.e = n2 + 1;
    }

    public /* synthetic */ Object clone() {
        return this.a();
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
            stringBuilder.append(this.b(i2));
            stringBuilder.append('=');
            E e2 = this.c(i2);
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

