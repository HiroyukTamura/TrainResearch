/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.f.j;

public class b {
    public static final a A;
    public static final a B;
    public static final a C;
    public static final a D;
    public static final a E;
    public static final a F;
    public static final a G;
    public static final a H;
    public static final a I;
    public static final a J;
    public static final a K;
    public static final a a;
    public static final a b;
    public static final c<a.aq> c;
    public static final c<a.r> d;
    public static final c<a.c.b> e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final c<a.q> l;
    public static final a m;
    public static final a n;
    public static final a o;
    public static final a p;
    public static final a q;
    public static final a r;
    public static final a s;
    public static final a t;
    public static final a u;
    public static final a v;
    public static final a w;
    public static final a x;
    public static final a y;
    public static final a z;

    static {
        a = c.a();
        b = c.a();
        c = c.a((c)b, (j.a[])a.aq.values());
        d = c.a(c, (j.a[])a.r.values());
        e = c.a(d, (j.a[])a.c.b.values());
        f = c.a(e);
        g = c.a(f);
        h = c.a(g);
        i = c.a(h);
        j = c.a(i);
        k = c.a(c);
        l = c.a(d, (j.a[])a.q.values());
        m = c.a(l);
        n = c.a(m);
        o = c.a(n);
        p = c.a(o);
        q = c.a(p);
        r = c.a(q);
        s = c.a(r);
        t = c.a(l);
        u = c.a(t);
        v = c.a(u);
        w = c.a(v);
        x = c.a(w);
        y = c.a(x);
        z = c.a(y);
        A = c.a(z);
        B = c.a(A);
        C = c.a(b);
        D = c.a(C);
        E = c.a(D);
        F = c.a(d);
        G = c.a(F);
        H = c.a(G);
        I = c.a();
        J = c.a(I);
        K = c.a();
    }

    public static class a
    extends c<Boolean> {
        public a(int n2) {
            super(n2, 1);
        }

        public Boolean a(int n2) {
            int n3 = this.a;
            boolean bl2 = true;
            if ((n2 & 1 << n3) == 0) {
                bl2 = false;
            }
            return bl2;
        }

        @Override
        public /* synthetic */ Object b(int n2) {
            return this.a(n2);
        }
    }

    private static class b<E extends j.a>
    extends c<E> {
        private final E[] c;

        public b(int n2, E[] arrE) {
            super(n2, b.a(arrE));
            this.c = arrE;
        }

        private static <E> int a(E[] arrE) {
            int n2 = arrE.length - 1;
            if (n2 == 0) {
                return 1;
            }
            for (int i2 = 31; i2 >= 0; --i2) {
                if ((1 << i2 & n2) == 0) continue;
                return i2 + 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Empty enum: ");
            stringBuilder.append(arrE.getClass());
            throw new IllegalStateException(stringBuilder.toString());
        }

        public E a(int n2) {
            int n3 = this.b;
            int n4 = this.a;
            int n5 = this.a;
            for (E e2 : this.c) {
                if (e2.a() != (n2 & (1 << n3) - 1 << n4) >> n5) continue;
                return e2;
            }
            return null;
        }

        @Override
        public /* synthetic */ Object b(int n2) {
            return this.a(n2);
        }
    }

    public static abstract class c<E> {
        public final int a;
        public final int b;

        private c(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        public static a a() {
            return new a(0);
        }

        public static a a(c<?> c2) {
            return new a(c2.a + c2.b);
        }

        public static <E extends j.a> c<E> a(c<?> c2, E[] arrE) {
            return new b(c2.a + c2.b, arrE);
        }

        public abstract E b(int var1);
    }

}

