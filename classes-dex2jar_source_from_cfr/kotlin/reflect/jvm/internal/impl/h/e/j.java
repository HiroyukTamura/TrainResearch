/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import java.util.Collection;
import kotlin.e.a.b;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.d;
import kotlin.reflect.jvm.internal.impl.h.e.h;

public interface j {
    public Collection<m> a(d var1, b<? super f, Boolean> var2);

    public Collection<t> b(f var1, kotlin.reflect.jvm.internal.impl.b.a.b var2);

    public kotlin.reflect.jvm.internal.impl.a.h c(f var1, kotlin.reflect.jvm.internal.impl.b.a.b var2);

    public static final class a {
        public static /* synthetic */ Collection a(j j2, d d2, b b2, int n2, Object object) {
            if (object == null) {
                if ((n2 & 1) != 0) {
                    d2 = d.a;
                }
                if ((n2 & 2) != 0) {
                    b2 = h.c.a();
                }
                return j2.a(d2, b2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void a(j j2, f f2, kotlin.reflect.jvm.internal.impl.b.a.b b2) {
            kotlin.e.b.j.b(f2, "name");
            kotlin.e.b.j.b(b2, "location");
            j2.b(f2, b2);
        }
    }

}

