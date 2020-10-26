/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.m;

public interface g {
    public boolean a(m var1, m var2);

    public static final class a
    implements g {
        public static final a a = new a();

        private a() {
        }

        @Override
        public boolean a(m m2, m m3) {
            j.b(m2, "what");
            j.b(m3, "from");
            return true;
        }
    }

}

