/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.b;

import java.util.Collection;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.w;

public interface a {
    public Collection<w> a(e var1);

    public Collection<am> a(f var1, e var2);

    public Collection<f> c(e var1);

    public Collection<d> d(e var1);

    public static final class a
    implements a {
        public static final a a = new a();

        private a() {
        }

        @Override
        public Collection<w> a(e e2) {
            j.b(e2, "classDescriptor");
            return m.a();
        }

        @Override
        public Collection<am> a(f f2, e e2) {
            j.b(f2, "name");
            j.b(e2, "classDescriptor");
            return m.a();
        }

        @Override
        public Collection<f> c(e e2) {
            j.b(e2, "classDescriptor");
            return m.a();
        }

        @Override
        public Collection<d> d(e e2) {
            j.b(e2, "classDescriptor");
            return m.a();
        }
    }

}

