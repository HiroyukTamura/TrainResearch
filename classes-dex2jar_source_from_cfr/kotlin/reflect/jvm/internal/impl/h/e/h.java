/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.Collection;
import java.util.Set;
import kotlin.a.al;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.i;
import kotlin.reflect.jvm.internal.impl.h.e.j;

public interface h
extends j {
    public static final a c = a.a;

    public Collection<ai> a(f var1, kotlin.reflect.jvm.internal.impl.b.a.b var2);

    public Collection<am> b(f var1, kotlin.reflect.jvm.internal.impl.b.a.b var2);

    public Set<f> l_();

    public Set<f> o_();

    public static final class kotlin.reflect.jvm.internal.impl.h.e.h$a {
        static final /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h$a a;
        private static final kotlin.e.a.b<f, Boolean> b;

        static {
            a = new kotlin.reflect.jvm.internal.impl.h.e.h$a();
            b = a.a;
        }

        private kotlin.reflect.jvm.internal.impl.h.e.h$a() {
        }

        public final kotlin.e.a.b<f, Boolean> a() {
            return b;
        }

    }

    public static final class b {
        public static void a(h h2, f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(b2, "location");
            j.a.a(h2, f2, b2);
        }
    }

    public static final class c
    extends i {
        public static final c a = new c();

        private c() {
        }

        @Override
        public Set<f> l_() {
            return al.a();
        }

        @Override
        public Set<f> o_() {
            return al.a();
        }
    }

}

