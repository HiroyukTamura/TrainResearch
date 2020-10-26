/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;

public interface c {
    public w a();

    public b b();

    public Map<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> c();

    public an d();

    public static final class a {
        public static b a(c object) {
            Object object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((c)object);
            Object var2_2 = null;
            object = var2_2;
            if (object2 != null) {
                if (p.a((m)object2)) {
                    object2 = null;
                }
                object = var2_2;
                if (object2 != null) {
                    object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((m)object2);
                    object = var2_2;
                    if (object2 != null) {
                        if (!((kotlin.reflect.jvm.internal.impl.e.c)object2).b()) {
                            object2 = null;
                        }
                        object = var2_2;
                        if (object2 != null) {
                            object = ((kotlin.reflect.jvm.internal.impl.e.c)object2).c();
                        }
                    }
                }
            }
            return object;
        }
    }

}

