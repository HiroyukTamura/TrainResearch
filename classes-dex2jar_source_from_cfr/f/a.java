/*
 * Decompiled with CFR 0.139.
 */
package f;

import c.ab;
import c.ad;
import f.c.w;
import f.e;
import f.n;
import f.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class a
extends e.a {
    a() {
    }

    @Override
    public f.e<ad, ?> a(Type type, Annotation[] arrannotation, n n2) {
        if (type == ad.class) {
            if (p.a(arrannotation, w.class)) {
                return c.a;
            }
            return a.a;
        }
        if (type == Void.class) {
            return e.a;
        }
        return null;
    }

    @Override
    public f.e<?, ab> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, n n2) {
        if (ab.class.isAssignableFrom(p.a(type))) {
            return b.a;
        }
        return null;
    }

    static final class a
    implements f.e<ad, ad> {
        static final a a = new a();

        a() {
        }

        @Override
        public ad a(ad ad2) {
            try {
                ad ad3 = p.a(ad2);
                return ad3;
            }
            finally {
                ad2.close();
            }
        }
    }

    static final class b
    implements f.e<ab, ab> {
        static final b a = new b();

        b() {
        }

        @Override
        public ab a(ab ab2) {
            return ab2;
        }
    }

    static final class c
    implements f.e<ad, ad> {
        static final c a = new c();

        c() {
        }

        @Override
        public ad a(ad ad2) {
            return ad2;
        }
    }

    static final class d
    implements f.e<Object, String> {
        static final d a = new d();

        d() {
        }

        @Override
        public /* synthetic */ Object a(Object object) {
            return this.b(object);
        }

        public String b(Object object) {
            return object.toString();
        }
    }

    static final class e
    implements f.e<ad, Void> {
        static final e a = new e();

        e() {
        }

        @Override
        public Void a(ad ad2) {
            ad2.close();
            return null;
        }
    }

}

