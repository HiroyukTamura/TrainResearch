/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.b;

import java.util.Comparator;
import java.util.concurrent.Callable;

public final class a {
    static final b.a.d.e<Object, Object> a = new g();
    public static final Runnable b = new d();
    public static final b.a.d.a c = new a();
    static final b.a.d.d<Object> d = new b();
    public static final b.a.d.d<Throwable> e = new e();
    public static final b.a.d.d<Throwable> f = new k();
    public static final b.a.d.f g = new c();
    static final b.a.d.g<Object> h = new l();
    static final b.a.d.g<Object> i = new f();
    static final Callable<Object> j = new j();
    static final Comparator<Object> k = new i();
    public static final b.a.d.d<org.a.a> l = new h();

    static final class a
    implements b.a.d.a {
        a() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class b
    implements b.a.d.d<Object> {
        b() {
        }

        @Override
        public void a(Object object) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class c
    implements b.a.d.f {
        c() {
        }
    }

    static final class d
    implements Runnable {
        d() {
        }

        @Override
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class e
    implements b.a.d.d<Throwable> {
        e() {
        }

        @Override
        public void a(Throwable throwable) {
            b.a.f.a.a(throwable);
        }
    }

    static final class f
    implements b.a.d.g<Object> {
        f() {
        }
    }

    static final class g
    implements b.a.d.e<Object, Object> {
        g() {
        }

        @Override
        public Object a(Object object) {
            return object;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class h
    implements b.a.d.d<org.a.a> {
        h() {
        }

        @Override
        public void a(org.a.a a2) {
            a2.a(Long.MAX_VALUE);
        }
    }

    static final class i
    implements Comparator<Object> {
        i() {
        }

        @Override
        public int compare(Object object, Object object2) {
            return ((Comparable)object).compareTo(object2);
        }
    }

    static final class j
    implements Callable<Object> {
        j() {
        }

        @Override
        public Object call() {
            return null;
        }
    }

    static final class k
    implements b.a.d.d<Throwable> {
        k() {
        }

        @Override
        public void a(Throwable throwable) {
            b.a.f.a.a(new b.a.c.d(throwable));
        }
    }

    static final class l
    implements b.a.d.g<Object> {
        l() {
        }
    }

}

