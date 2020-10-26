/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.c.a.e.n;

public interface f {
    public kotlin.reflect.jvm.internal.impl.h.b.f<?> a(n var1, ai var2);

    public static final class a
    implements f {
        public static final a a = new a();

        private a() {
        }

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.b.f a(n n2, ai ai2) {
            return (kotlin.reflect.jvm.internal.impl.h.b.f)((Object)this.b(n2, ai2));
        }

        public Void b(n n2, ai ai2) {
            j.b(n2, "field");
            j.b(ai2, "descriptor");
            return null;
        }
    }

}

