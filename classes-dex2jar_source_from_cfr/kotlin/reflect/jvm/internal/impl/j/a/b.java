/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.j.a.s;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.n;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.j.y;

public final class b {
    public static final az a(List<? extends az> object) {
        boolean bl2;
        Collection collection;
        Object object2;
        Iterator iterator;
        boolean bl3;
        Object object3;
        j.b(object, "types");
        switch (object.size()) {
            default: {
                object3 = (Iterable)object;
                collection = new ArrayList(kotlin.a.m.a(object3, 10));
                iterator = object3.iterator();
                bl3 = false;
                bl2 = false;
                break;
            }
            case 1: {
                return kotlin.a.m.j(object);
            }
            case 0: {
                throw (Throwable)new IllegalStateException("Expected some types".toString());
            }
        }
        while (iterator.hasNext()) {
            block14 : {
                block13 : {
                    block12 : {
                        object2 = (az)iterator.next();
                        bl3 = bl3 || y.a((w)object2);
                        if (!(object2 instanceof ad)) break block12;
                        object2 = (ad)object2;
                        break block13;
                    }
                    if (!(object2 instanceof q)) break block14;
                    if (n.a((w)object2)) {
                        return object2;
                    }
                    object2 = ((q)object2).f();
                    bl2 = true;
                }
                collection.add(object2);
                continue;
            }
            throw new m();
        }
        object2 = (List)collection;
        if (bl3) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Intersection of error types: ");
            ((StringBuilder)object2).append(object);
            object = p.c(((StringBuilder)object2).toString());
            j.a(object, "ErrorUtils.createErrorTy\u2026 of error types: $types\")");
            return (az)object;
        }
        if (!bl2) {
            return s.a.a((List<? extends ad>)object2);
        }
        object = new ArrayList(kotlin.a.m.a(object3, 10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object.add(t.d((az)object3.next()));
        }
        object = (List)object;
        return x.a(s.a.a((List<? extends ad>)object2), s.a.a((List<? extends ad>)object));
    }
}

