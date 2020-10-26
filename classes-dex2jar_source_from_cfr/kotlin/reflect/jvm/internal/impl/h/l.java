/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.Collection;
import java.util.Iterator;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.y;

public final class l {
    public static final b a(Collection<? extends b> object) {
        j.b(object, "descriptors");
        boolean bl2 = object.isEmpty();
        if (y.a && !(bl2 ^ true)) {
            throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
        }
        b b2 = null;
        Iterator<? extends b> iterator = object.iterator();
        object = b2;
        while (iterator.hasNext()) {
            Integer n2;
            b2 = iterator.next();
            if (object != null && ((n2 = az.b(object.p(), b2.p())) == null || j.a(n2, 0) >= 0)) continue;
            object = b2;
        }
        if (object == null) {
            j.a();
        }
        return object;
    }
}

