/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.Collection;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.f;

public interface y
extends m {
    public Collection<kotlin.reflect.jvm.internal.impl.e.b> a(kotlin.reflect.jvm.internal.impl.e.b var1, kotlin.e.a.b<? super f, Boolean> var2);

    public ae a(kotlin.reflect.jvm.internal.impl.e.b var1);

    public KotlinBuiltIns a();

    public boolean a(y var1);

    public static final class a<T> {
        private final String a;

        public a(String string2) {
            j.b(string2, "name");
            this.a = string2;
        }

        public String toString() {
            return this.a;
        }
    }

    public static final class b {
        public static <R, D> R a(y y2, o<R, D> o2, D d2) {
            j.b(o2, "visitor");
            return o2.a(y2, d2);
        }

        public static m a(y y2) {
            return null;
        }
    }

}

