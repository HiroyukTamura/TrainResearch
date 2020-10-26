/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.b.a.b;
import kotlin.reflect.jvm.internal.impl.b.a.c;
import kotlin.reflect.jvm.internal.impl.b.a.e;
import kotlin.reflect.jvm.internal.impl.b.a.f;

public final class a {
    public static final void a(c c2, b object, String string2, String string3) {
        j.b(c2, "$receiver");
        j.b(object, "from");
        j.b(string2, "packageFqName");
        j.b(string3, "name");
        if (c2 == c$a.a) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.b.a.a a2 = object.a();
        if (a2 != null) {
            object = c2.a() ? a2.b() : e.a.a();
            c2.a(a2.a(), (e)object, string2, f.a, string3);
        }
    }

    public static final void a(c c2, b b2, ab object, kotlin.reflect.jvm.internal.impl.e.f object2) {
        j.b(c2, "$receiver");
        j.b(b2, "from");
        j.b(object, "scopeOwner");
        j.b(object2, "name");
        object = object.f().a();
        j.a(object, "scopeOwner.fqName.asString()");
        object2 = ((kotlin.reflect.jvm.internal.impl.e.f)object2).a();
        j.a(object2, "name.asString()");
        a.a(c2, b2, (String)object, (String)object2);
    }

    public static final void a(c c2, b object, kotlin.reflect.jvm.internal.impl.a.e object2, kotlin.reflect.jvm.internal.impl.e.f object3) {
        j.b(c2, "$receiver");
        j.b(object, "from");
        j.b(object2, "scopeOwner");
        j.b(object3, "name");
        if (c2 == c$a.a) {
            return;
        }
        Object object4 = object.a();
        if (object4 != null) {
            object = c2.a() ? object4.b() : e.a.a();
            object4 = object4.a();
            object2 = kotlin.reflect.jvm.internal.impl.h.c.d((m)object2).a();
            j.a(object2, "DescriptorUtils.getFqName(scopeOwner).asString()");
            f f2 = f.b;
            object3 = ((kotlin.reflect.jvm.internal.impl.e.f)object3).a();
            j.a(object3, "name.asString()");
            c2.a((String)object4, (e)object, (String)object2, f2, (String)object3);
        }
    }
}

