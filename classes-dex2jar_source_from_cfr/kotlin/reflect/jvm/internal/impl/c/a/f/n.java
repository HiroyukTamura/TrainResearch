/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.d;
import kotlin.reflect.jvm.internal.impl.c.a.f.e;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;

public final class n {
    public static final /* synthetic */ Object a(Set set, Object object, Object object2, Object object3, boolean bl2) {
        return n.b(set, object, object2, object3, bl2);
    }

    public static final /* synthetic */ d a(g g2, e e2, boolean bl2, boolean bl3) {
        return n.b(g2, e2, bl2, bl3);
    }

    public static final /* synthetic */ g a(Set set, g g2, boolean bl2) {
        return n.b(set, g2, bl2);
    }

    private static final <T> T b(Set<? extends T> object, T object2, T object3, T t2, boolean bl2) {
        if (bl2) {
            if (j.a(object = object.contains(object2) ? object2 : (object.contains(object3) ? object3 : null), object2) && j.a(t2, object3)) {
                return null;
            }
            if (t2 != null) {
                object = t2;
            }
            return (T)object;
        }
        object2 = object;
        if (t2 != null) {
            object3 = m.m((Iterable)al.a(object, t2));
            object2 = object;
            if (object3 != null) {
                object2 = object3;
            }
        }
        return m.g((Iterable)object2);
    }

    private static final d b(g g2, e e2, boolean bl2, boolean bl3) {
        if (bl3 && g2 == g.b) {
            return new d(g2, e2, true, bl2);
        }
        return new d(g2, e2, false, bl2);
    }

    private static final g b(Set<? extends g> set, g g2, boolean bl2) {
        if (g2 == g.c) {
            return g.c;
        }
        return n.b(set, g.b, g.a, g2, bl2);
    }
}

