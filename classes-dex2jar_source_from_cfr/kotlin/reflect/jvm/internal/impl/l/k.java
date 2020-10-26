/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import kotlin.reflect.jvm.internal.impl.l.c;

public class k {
    public static volatile boolean a;
    private static final Object b;

    static {
        b = new Object(){

            public String toString() {
                return "NULL_VALUE";
            }
        };
        a = false;
    }

    public static <V> V a(Object object) {
        Object object2 = object;
        if (object == b) {
            object2 = null;
        }
        return (V)object2;
    }

    public static Object a(Throwable throwable) {
        return new a(throwable);
    }

    public static <V> Object b(V v2) {
        Object object = v2;
        if (v2 == null) {
            object = b;
        }
        return object;
    }

    public static <V> V c(Object object) {
        return k.a(k.d(object));
    }

    public static <V> V d(Object object) {
        if (object instanceof a) {
            object = ((a)object).a();
            if (a && c.b((Throwable)object)) {
                throw new b((Throwable)object);
            }
            throw c.a((Throwable)object);
        }
        return (V)object;
    }

    private static final class a {
        private final Throwable a;

        private a(Throwable throwable) {
            this.a = throwable;
        }

        public Throwable a() {
            return this.a;
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public static class b
    extends RuntimeException {
        public b(Throwable throwable) {
            super("Rethrow stored exception", throwable);
        }
    }

}

