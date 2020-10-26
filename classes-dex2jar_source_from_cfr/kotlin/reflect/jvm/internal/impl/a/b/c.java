/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.b.d;
import kotlin.reflect.jvm.internal.impl.a.e;

public interface c {
    public boolean a(e var1, am var2);

    public static final class a
    implements c {
        public static final a a = new a();

        private a() {
        }

        @Override
        public boolean a(e e2, am am2) {
            j.b(e2, "classDescriptor");
            j.b(am2, "functionDescriptor");
            return true;
        }
    }

    public static final class b
    implements c {
        public static final b a = new b();

        private b() {
        }

        @Override
        public boolean a(e e2, am am2) {
            j.b(e2, "classDescriptor");
            j.b(am2, "functionDescriptor");
            return am2.x().b(d.a()) ^ true;
        }
    }

}

