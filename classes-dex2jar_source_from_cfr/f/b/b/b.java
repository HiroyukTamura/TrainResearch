/*
 * Decompiled with CFR 0.139.
 */
package f.b.b;

import c.ad;
import java.io.IOException;

final class b {

    static final class a
    implements f.e<ad, Boolean> {
        static final a a = new a();

        a() {
        }

        @Override
        public Boolean a(ad ad2) {
            return Boolean.valueOf(ad2.e());
        }
    }

    static final class b
    implements f.e<ad, Byte> {
        static final b a = new b();

        b() {
        }

        @Override
        public Byte a(ad ad2) {
            return Byte.valueOf(ad2.e());
        }
    }

    static final class c
    implements f.e<ad, Character> {
        static final c a = new c();

        c() {
        }

        @Override
        public Character a(ad object) {
            if (((String)(object = ((ad)object).e())).length() == 1) {
                return Character.valueOf(((String)object).charAt(0));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected body of length 1 for Character conversion but was ");
            stringBuilder.append(((String)object).length());
            throw new IOException(stringBuilder.toString());
        }
    }

    static final class d
    implements f.e<ad, Double> {
        static final d a = new d();

        d() {
        }

        @Override
        public Double a(ad ad2) {
            return Double.valueOf(ad2.e());
        }
    }

    static final class e
    implements f.e<ad, Float> {
        static final e a = new e();

        e() {
        }

        @Override
        public Float a(ad ad2) {
            return Float.valueOf(ad2.e());
        }
    }

    static final class f
    implements f.e<ad, Integer> {
        static final f a = new f();

        f() {
        }

        @Override
        public Integer a(ad ad2) {
            return Integer.valueOf(ad2.e());
        }
    }

    static final class g
    implements f.e<ad, Long> {
        static final g a = new g();

        g() {
        }

        @Override
        public Long a(ad ad2) {
            return Long.valueOf(ad2.e());
        }
    }

    static final class h
    implements f.e<ad, Short> {
        static final h a = new h();

        h() {
        }

        @Override
        public Short a(ad ad2) {
            return Short.valueOf(ad2.e());
        }
    }

    static final class i
    implements f.e<ad, String> {
        static final i a = new i();

        i() {
        }

        @Override
        public String a(ad ad2) {
            return ad2.e();
        }
    }

}

