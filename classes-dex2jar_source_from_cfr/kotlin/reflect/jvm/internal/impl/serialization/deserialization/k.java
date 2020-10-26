/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

public interface k {
    public boolean a();

    public boolean b();

    public boolean c();

    public boolean d();

    public boolean e();

    public static final class a
    implements k {
        public static final a a = new a();

        private a() {
        }

        @Override
        public boolean a() {
            return b.a(this);
        }

        @Override
        public boolean b() {
            return b.b(this);
        }

        @Override
        public boolean c() {
            return b.c(this);
        }

        @Override
        public boolean d() {
            return b.d(this);
        }

        @Override
        public boolean e() {
            return b.e(this);
        }
    }

    public static final class b {
        public static boolean a(k k2) {
            return false;
        }

        public static boolean b(k k2) {
            return false;
        }

        public static boolean c(k k2) {
            return true;
        }

        public static boolean d(k k2) {
            return true;
        }

        public static boolean e(k k2) {
            return false;
        }
    }

}

