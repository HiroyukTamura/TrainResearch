/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.a.n;
import kotlin.reflect.jvm.internal.impl.a.a.o;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.a.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b.i;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.s;

public final class d {
    public static final d a = new d();
    private static final Map<String, EnumSet<o>> b = af.a(s.a("PACKAGE", EnumSet.noneOf(o.class)), s.a("TYPE", EnumSet.of((Enum)o.a, (Enum)o.n)), s.a("ANNOTATION_TYPE", EnumSet.of((Enum)o.b)), s.a("TYPE_PARAMETER", EnumSet.of((Enum)o.c)), s.a("FIELD", EnumSet.of((Enum)o.e)), s.a("LOCAL_VARIABLE", EnumSet.of((Enum)o.f)), s.a("PARAMETER", EnumSet.of((Enum)o.g)), s.a("CONSTRUCTOR", EnumSet.of((Enum)o.h)), s.a("METHOD", EnumSet.of((Enum)o.i, (Enum)o.j, (Enum)o.k)), s.a("TYPE_USE", EnumSet.of((Enum)o.l)));
    private static final Map<String, n> c = af.a(s.a("RUNTIME", n.a), s.a("CLASS", n.b), s.a("SOURCE", n.c));

    private d() {
    }

    public final Set<o> a(String object) {
        if ((object = b.get(object)) != null) {
            return (Set)object;
        }
        return al.a();
    }

    public final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(List<? extends kotlin.reflect.jvm.internal.impl.c.a.e.b> object) {
        Object object2;
        Object object3;
        j.b(object, "arguments");
        Iterator iterator = (Iterable)object;
        object = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object3 = iterator.next();
            if (!(object3 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.m)) continue;
            object.add(object3);
        }
        object = (Iterable)object;
        iterator = new ArrayList();
        object3 = object.iterator();
        while (object3.hasNext()) {
            object = (kotlin.reflect.jvm.internal.impl.c.a.e.m)object3.next();
            object2 = a;
            object = (object = object.c()) != null ? ((f)object).a() : null;
            m.a(iterator, (Iterable)((d)object2).a((String)object));
        }
        iterator = (List)((Object)iterator);
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = (o)((Object)iterator.next());
            object3 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.annotationTarget);
            j.a(object3, "ClassId.topLevel(KotlinB\u2026Q_NAMES.annotationTarget)");
            object2 = f.a(((Enum)object2).name());
            j.a(object2, "Name.identifier(kotlinTarget.name)");
            object.add(new i((kotlin.reflect.jvm.internal.impl.e.a)object3, (f)object2));
        }
        return new kotlin.reflect.jvm.internal.impl.h.b.b((List)object, a.a);
    }

    public final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.c.a.e.b object) {
        boolean bl2 = object instanceof kotlin.reflect.jvm.internal.impl.c.a.e.m;
        f f2 = null;
        if (!bl2) {
            object = null;
        }
        kotlin.reflect.jvm.internal.impl.c.a.e.m m2 = (kotlin.reflect.jvm.internal.impl.c.a.e.m)object;
        object = f2;
        if (m2 != null) {
            Object object2 = c;
            object = m2.c();
            object = object != null ? ((f)object).a() : null;
            object2 = object2.get(object);
            object = f2;
            if (object2 != null) {
                object = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.annotationRetention);
                j.a(object, "ClassId.topLevel(KotlinB\u2026AMES.annotationRetention)");
                f2 = f.a(((Enum)object2).name());
                j.a((Object)f2, "Name.identifier(retention.name)");
                object = new i((kotlin.reflect.jvm.internal.impl.e.a)object, f2);
            }
        }
        return (kotlin.reflect.jvm.internal.impl.h.b.f)object;
    }

}

