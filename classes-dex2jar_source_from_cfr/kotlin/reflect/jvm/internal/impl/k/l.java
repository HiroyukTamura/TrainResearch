/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.k.b;

public abstract class l
implements kotlin.reflect.jvm.internal.impl.k.b {
    private final String a;

    private l(String string2) {
        this.a = string2;
    }

    public /* synthetic */ l(String string2, g g2) {
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
    extends l {
        private final int a;

        public a(int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("must have at least ");
            stringBuilder.append(n2);
            stringBuilder.append(" value parameter");
            String string2 = n2 > 1 ? "s" : "";
            stringBuilder.append(string2);
            super(stringBuilder.toString(), null);
            this.a = n2;
        }

        @Override
        public boolean a(t t2) {
            j.b(t2, "functionDescriptor");
            return t2.i().size() >= this.a;
        }
    }

    public static final class b
    extends l {
        private final int a;

        public b(int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("must have exactly ");
            stringBuilder.append(n2);
            stringBuilder.append(" value parameters");
            super(stringBuilder.toString(), null);
            this.a = n2;
        }

        @Override
        public boolean a(t t2) {
            j.b(t2, "functionDescriptor");
            return t2.i().size() == this.a;
        }
    }

    public static final class c
    extends l {
        public static final c a = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override
        public boolean a(t t2) {
            j.b(t2, "functionDescriptor");
            return t2.i().isEmpty();
        }
    }

    public static final class d
    extends l {
        public static final d a = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override
        public boolean a(t t2) {
            j.b(t2, "functionDescriptor");
            return t2.i().size() == 1;
        }
    }

}

