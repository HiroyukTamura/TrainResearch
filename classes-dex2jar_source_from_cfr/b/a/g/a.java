/*
 * Decompiled with CFR 0.139.
 */
package b.a.g;

import b.a.e.g.j;
import b.a.e.g.k;
import java.util.concurrent.Callable;

public final class a {
    static final b.a.h a = b.a.f.a.d(new h());
    static final b.a.h b = b.a.f.a.a(new b());
    static final b.a.h c = b.a.f.a.b(new c());
    static final b.a.h d = k.c();
    static final b.a.h e = b.a.f.a.c(new f());

    public static b.a.h a() {
        return b.a.f.a.a(e);
    }

    static final class a {
        static final b.a.h a = new b.a.e.g.b();
    }

    static final class b
    implements Callable<b.a.h> {
        b() {
        }

        public b.a.h a() {
            return a.a;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    }

    static final class c
    implements Callable<b.a.h> {
        c() {
        }

        public b.a.h a() {
            return d.a;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    }

    static final class d {
        static final b.a.h a = new b.a.e.g.c();
    }

    static final class e {
        static final b.a.h a = new b.a.e.g.d();
    }

    static final class f
    implements Callable<b.a.h> {
        f() {
        }

        public b.a.h a() {
            return e.a;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    }

    static final class g {
        static final b.a.h a = new j();
    }

    static final class h
    implements Callable<b.a.h> {
        h() {
        }

        public b.a.h a() {
            return g.a;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    }

}

