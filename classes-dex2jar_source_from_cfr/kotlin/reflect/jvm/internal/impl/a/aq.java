/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.Collection;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.w;

public interface aq {
    public Collection<kotlin.reflect.jvm.internal.impl.j.w> a(an var1, Collection<? extends kotlin.reflect.jvm.internal.impl.j.w> var2, b<? super an, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.j.w>> var3, b<? super kotlin.reflect.jvm.internal.impl.j.w, w> var4);

    public static final class a
    implements aq {
        public static final a a = new a();

        private a() {
        }

        @Override
        public Collection<kotlin.reflect.jvm.internal.impl.j.w> a(an an2, Collection<? extends kotlin.reflect.jvm.internal.impl.j.w> collection, b<? super an, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.j.w>> b2, b<? super kotlin.reflect.jvm.internal.impl.j.w, w> b3) {
            j.b(an2, "currentTypeConstructor");
            j.b(collection, "superTypes");
            j.b(b2, "neighbors");
            j.b(b3, "reportLoop");
            return collection;
        }
    }

}

