/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.b;
import kotlin.reflect.jvm.internal.impl.e.f;

public final class r {
    public static final e a(y object, kotlin.reflect.jvm.internal.impl.e.b object2, b b2) {
        j.b(object, "$receiver");
        j.b(object2, "fqName");
        j.b(b2, "lookupLocation");
        if (((kotlin.reflect.jvm.internal.impl.e.b)object2).c()) {
            return null;
        }
        Object object3 = ((kotlin.reflect.jvm.internal.impl.e.b)object2).d();
        j.a(object3, "fqName.parent()");
        object3 = object.a((kotlin.reflect.jvm.internal.impl.e.b)object3).c();
        Object object4 = ((kotlin.reflect.jvm.internal.impl.e.b)object2).e();
        j.a(object4, "fqName.shortName()");
        object3 = object4 = object3.c((f)object4, b2);
        if (!(object4 instanceof e)) {
            object3 = null;
        }
        if ((object3 = (e)object3) != null) {
            return object3;
        }
        object3 = ((kotlin.reflect.jvm.internal.impl.e.b)object2).d();
        j.a(object3, "fqName.parent()");
        object = r.a((y)object, (kotlin.reflect.jvm.internal.impl.e.b)object3, b2);
        if (object != null && (object = object.C()) != null) {
            object2 = ((kotlin.reflect.jvm.internal.impl.e.b)object2).e();
            j.a(object2, "fqName.shortName()");
            object = object.c((f)object2, b2);
        } else {
            object = null;
        }
        object2 = object;
        if (!(object instanceof e)) {
            object2 = null;
        }
        return (e)object2;
    }
}

