/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.q;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.e.a.e;

public class m {
    public static final ba a = new ba("package", false){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        protected Integer a(ba ba2) {
            int n2;
            if (this == ba2) {
                n2 = 0;
                do {
                    return n2;
                    break;
                } while (true);
            }
            if (az.a(ba2)) {
                n2 = 1;
                return n2;
            }
            n2 = -1;
            return n2;
        }

        @Override
        public String a() {
            return "public/*package*/";
        }

        @Override
        public boolean a(e e2, q q2, kotlin.reflect.jvm.internal.impl.a.m m2) {
            return m.b(q2, m2);
        }

        @Override
        public ba b() {
            return az.c;
        }
    };
    public static final ba b = new ba("protected_static", true){

        @Override
        public String a() {
            return "protected/*protected static*/";
        }

        @Override
        public boolean a(e e2, q q2, kotlin.reflect.jvm.internal.impl.a.m m2) {
            return m.b(e2, q2, m2);
        }

        @Override
        public ba b() {
            return az.c;
        }
    };
    public static final ba c = new ba("protected_and_package", true){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        protected Integer a(ba ba2) {
            int n2;
            if (this == ba2) {
                n2 = 0;
                do {
                    return n2;
                    break;
                } while (true);
            }
            if (ba2 == az.d) {
                return null;
            }
            if (az.a(ba2)) {
                n2 = 1;
                return n2;
            }
            n2 = -1;
            return n2;
        }

        @Override
        public String a() {
            return "protected/*protected and package*/";
        }

        @Override
        public boolean a(e e2, q q2, kotlin.reflect.jvm.internal.impl.a.m m2) {
            return m.b(e2, q2, m2);
        }

        @Override
        public ba b() {
            return az.c;
        }
    };

    private static boolean b(kotlin.reflect.jvm.internal.impl.a.m m2, kotlin.reflect.jvm.internal.impl.a.m m3) {
        boolean bl2 = false;
        m2 = c.a(m2, ab.class, false);
        m3 = c.a(m3, ab.class, false);
        boolean bl3 = bl2;
        if (m3 != null) {
            bl3 = bl2;
            if (m2 != null) {
                bl3 = bl2;
                if (m2.f().equals(m3.f())) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    private static boolean b(e e2, q q2, kotlin.reflect.jvm.internal.impl.a.m m2) {
        if (m.b(c.a(q2), m2)) {
            return true;
        }
        return az.c.a(e2, q2, m2);
    }

}

