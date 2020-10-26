/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.a.m;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.b.a;
import kotlin.reflect.jvm.internal.impl.a.b.b;
import kotlin.reflect.jvm.internal.impl.a.b.c;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.b.e;
import kotlin.reflect.jvm.internal.impl.c.b.c;
import kotlin.reflect.jvm.internal.impl.c.b.f;
import kotlin.reflect.jvm.internal.impl.c.b.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.s;

public final class d {
    private final j a;

    public d(kotlin.reflect.jvm.internal.impl.i.i i2, y y2, k k2, f object, c b2, kotlin.reflect.jvm.internal.impl.c.a.c.g ac2, aa aa2, p p2, kotlin.reflect.jvm.internal.impl.b.a.c c2, i i3) {
        kotlin.e.b.j.b(i2, "storageManager");
        kotlin.e.b.j.b(y2, "moduleDescriptor");
        kotlin.e.b.j.b(k2, "configuration");
        kotlin.e.b.j.b(object, "classDataFinder");
        kotlin.e.b.j.b(b2, "annotationAndConstantLoader");
        kotlin.e.b.j.b(ac2, "packageFragmentProvider");
        kotlin.e.b.j.b(aa2, "notFoundClasses");
        kotlin.e.b.j.b(p2, "errorReporter");
        kotlin.e.b.j.b(c2, "lookupTracker");
        kotlin.e.b.j.b(i3, "contractDeserializer");
        KotlinBuiltIns kotlinBuiltIns = y2.a();
        Object object2 = kotlinBuiltIns;
        if (!(kotlinBuiltIns instanceof e)) {
            object2 = null;
        }
        kotlinBuiltIns = (e)object2;
        object2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.g)object;
        b2 = b2;
        ac2 = ac2;
        s s2 = s.a.a;
        q q2 = g.a;
        Iterable iterable = m.a();
        if (kotlinBuiltIns == null || (object = ((e)kotlinBuiltIns).g()) == null) {
            object = a.a.a;
        }
        a a2 = (a)object;
        if (kotlinBuiltIns == null || (object = ((e)kotlinBuiltIns).g()) == null) {
            object = c.b.a;
        }
        this.a = new j(i2, y2, k2, (kotlin.reflect.jvm.internal.impl.serialization.deserialization.g)object2, b2, ac2, s2, p2, c2, q2, iterable, aa2, i3, a2, (kotlin.reflect.jvm.internal.impl.a.b.c)object, kotlin.reflect.jvm.internal.impl.d.c.a.j.a.a());
    }

    public final j a() {
        return this.a;
    }
}

