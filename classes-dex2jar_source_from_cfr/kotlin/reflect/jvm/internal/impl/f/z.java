/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import kotlin.reflect.jvm.internal.impl.f.d;

public final class z {
    static final int a = z.a(1, 3);
    static final int b = z.a(1, 4);
    static final int c = z.a(2, 0);
    static final int d = z.a(3, 2);

    static int a(int n2) {
        return n2 & 7;
    }

    static int a(int n2, int n3) {
        return n2 << 3 | n3;
    }

    public static int b(int n2) {
        return n2 >>> 3;
    }

    public static enum a {
        a(b.d, 1),
        b(b.c, 5),
        c(b.b, 0),
        d(b.b, 0),
        e(b.a, 0),
        f(b.b, 1),
        g(b.a, 5),
        h(b.e, 0),
        i(b.f, 2){

            @Override
            public boolean c() {
                return false;
            }
        }
        ,
        j(b.i, 3){

            @Override
            public boolean c() {
                return false;
            }
        }
        ,
        k(b.i, 2){

            @Override
            public boolean c() {
                return false;
            }
        }
        ,
        l(b.g, 2){

            @Override
            public boolean c() {
                return false;
            }
        }
        ,
        m(b.a, 0),
        n(b.h, 0),
        o(b.a, 5),
        p(b.b, 1),
        q(b.a, 0),
        r(b.b, 0);
        
        private final b s;
        private final int t;

        private a(b b2, int n3) {
            this.s = b2;
            this.t = n3;
        }

        public b a() {
            return this.s;
        }

        public int b() {
            return this.t;
        }

        public boolean c() {
            return true;
        }

    }

    public static enum b {
        a(0),
        b(0L),
        c(Float.valueOf(0.0f)),
        d(0.0),
        e(false),
        f(""),
        g(d.a),
        h(null),
        i(null);
        
        private final Object j;

        private b(Object object) {
            this.j = object;
        }
    }

}

