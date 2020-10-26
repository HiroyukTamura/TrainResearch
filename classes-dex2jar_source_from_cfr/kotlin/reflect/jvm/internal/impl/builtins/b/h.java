/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class h {
    public static final ao a(e object, e object2) {
        j.b(object, "from");
        j.b(object2, "to");
        boolean bl2 = object.z().size() == object2.z().size();
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object);
            stringBuilder.append(" and ");
            stringBuilder.append(object2);
            stringBuilder.append(" should have same number of type parameters, ");
            stringBuilder.append("but ");
            stringBuilder.append(object.z().size());
            stringBuilder.append(" / ");
            stringBuilder.append(object2.z().size());
            stringBuilder.append(" found");
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        ao.a a2 = ao.b;
        object = object.z();
        j.a(object, "from.declaredTypeParameters");
        Iterator iterator = (Iterable)object;
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object.add(((as)iterator.next()).e());
        }
        object = (List)object;
        object2 = object2.z();
        j.a(object2, "to.declaredTypeParameters");
        iterator = (Iterable)object2;
        object2 = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.a.a a3 = (as)iterator.next();
            j.a((Object)a3, "it");
            a3 = a3.i_();
            j.a((Object)a3, "it.defaultType");
            object2.add(a.f((w)a3));
        }
        return ao.a.a(a2, af.a(m.a(object, (List)object2)), false, 2, null);
    }
}

