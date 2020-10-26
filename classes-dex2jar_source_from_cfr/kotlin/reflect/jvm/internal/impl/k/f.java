/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.k.b;

public abstract class f
implements kotlin.reflect.jvm.internal.impl.k.b {
    private final String a;

    private f(String string2) {
        this.a = string2;
    }

    public /* synthetic */ f(String string2, g g2) {
        this(string2);
    }

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public String b(t t2) {
        j.b(t2, "functionDescriptor");
        return b.a.a(this, t2);
    }

    public static final class a
    extends f {
        public static final a a = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override
        public boolean a(t t2) {
            j.b(t2, "functionDescriptor");
            return t2.e() != null;
        }
    }

    public static final class b
    extends f {
        public static final b a = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override
        public boolean a(t t2) {
            j.b(t2, "functionDescriptor");
            return t2.e() != null || t2.d() != null;
            {
            }
        }
    }

}

