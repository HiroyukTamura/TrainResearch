/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.ak;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.f;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class am {
    public static final boolean a(w object) {
        j.b(object, "$receiver");
        az az2 = ((w)object).l();
        object = az2;
        if (!(az2 instanceof f)) {
            object = null;
        }
        if ((object = (f)object) != null) {
            return object.q_();
        }
        return false;
    }

    public static final boolean a(w w2, w object) {
        boolean bl2;
        block6 : {
            block5 : {
                j.b(w2, "first");
                j.b(object, "second");
                az az2 = w2.l();
                Object object2 = az2;
                if (!(az2 instanceof ak)) {
                    object2 = null;
                }
                object2 = (ak)object2;
                bl2 = false;
                boolean bl3 = object2 != null ? object2.a((w)object) : false;
                if (bl3) break block5;
                object = object2 = ((w)object).l();
                if (!(object2 instanceof ak)) {
                    object = null;
                }
                if (!(bl3 = (object = (ak)object) != null ? object.a(w2) : false)) break block6;
            }
            bl2 = true;
        }
        return bl2;
    }

    public static final f b(w object) {
        j.b(object, "$receiver");
        object = ((w)object).l();
        boolean bl2 = object instanceof f;
        Object var2_2 = null;
        if (!bl2) {
            object = null;
        }
        f f2 = (f)object;
        object = var2_2;
        if (f2 != null) {
            object = var2_2;
            if (f2.q_()) {
                object = f2;
            }
        }
        return object;
    }

    public static final w c(w w2) {
        Object object;
        j.b(w2, "$receiver");
        Object object2 = object = w2.l();
        if (!(object instanceof ak)) {
            object2 = null;
        }
        object = (ak)object2;
        object2 = w2;
        if (object != null) {
            object = object.d();
            object2 = w2;
            if (object != null) {
                object2 = object;
            }
        }
        return object2;
    }

    public static final w d(w w2) {
        Object object;
        j.b(w2, "$receiver");
        Object object2 = object = w2.l();
        if (!(object instanceof ak)) {
            object2 = null;
        }
        object = (ak)object2;
        object2 = w2;
        if (object != null) {
            object = object.e();
            object2 = w2;
            if (object != null) {
                object2 = object;
            }
        }
        return object2;
    }
}

