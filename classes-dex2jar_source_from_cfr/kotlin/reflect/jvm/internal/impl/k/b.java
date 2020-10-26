/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.t;

public interface b {
    public String a();

    public boolean a(t var1);

    public String b(t var1);

    public static final class a {
        public static String a(b b2, t t2) {
            j.b(t2, "functionDescriptor");
            if (!b2.a(t2)) {
                return b2.a();
            }
            return null;
        }
    }

}

