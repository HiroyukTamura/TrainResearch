/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import kotlin.reflect.jvm.internal.impl.h.e.d;

public abstract class c {
    public abstract int a();

    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static final class a
    extends c {
        public static final a a = new a();
        private static final int b = d.k.g() & (d.k.e() | d.k.f());

        private a() {
        }

        @Override
        public int a() {
            return b;
        }
    }

    public static final class b
    extends c {
        public static final b a = new b();

        private b() {
        }

        @Override
        public int a() {
            return 0;
        }
    }

}

