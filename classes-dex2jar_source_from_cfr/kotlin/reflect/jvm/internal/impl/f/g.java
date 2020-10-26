/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.q;

public class g {
    private static volatile boolean a = false;
    private static final g c = new g(true);
    private final Map<a, i.f<?, ?>> b;

    g() {
        this.b = new HashMap();
    }

    private g(boolean bl2) {
        this.b = Collections.emptyMap();
    }

    public static g a() {
        return new g();
    }

    public static g b() {
        return c;
    }

    public <ContainingType extends q> i.f<ContainingType, ?> a(ContainingType ContainingType, int n2) {
        return this.b.get(new a(ContainingType, n2));
    }

    public final void a(i.f<?, ?> f2) {
        this.b.put(new a(f2.a(), f2.b()), f2);
    }

    private static final class a {
        private final Object a;
        private final int b;

        a(Object object, int n2) {
            this.a = object;
            this.b = n2;
        }

        public boolean equals(Object object) {
            boolean bl2 = object instanceof a;
            boolean bl3 = false;
            if (!bl2) {
                return false;
            }
            object = (a)object;
            bl2 = bl3;
            if (this.a == ((a)object).a) {
                bl2 = bl3;
                if (this.b == ((a)object).b) {
                    bl2 = true;
                }
            }
            return bl2;
        }

        public int hashCode() {
            return System.identityHashCode(this.a) * 65535 + this.b;
        }
    }

}

