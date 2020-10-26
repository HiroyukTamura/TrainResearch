/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

public interface q {
    public w a(a.ac var1, String var2, ad var3, ad var4);

    public static final class a
    implements q {
        public static final a a = new a();

        private a() {
        }

        @Override
        public w a(a.ac ac2, String string2, ad ad2, ad ad3) {
            j.b(ac2, "proto");
            j.b(string2, "flexibleId");
            j.b(ad2, "lowerBound");
            j.b(ad3, "upperBound");
            throw (Throwable)new IllegalArgumentException("This method should not be used.");
        }
    }

}

