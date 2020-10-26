/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.e.b.j;
import kotlin.g;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.c.a.a;
import kotlin.reflect.jvm.internal.impl.c.a.c.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.c.i;
import kotlin.reflect.jvm.internal.impl.c.a.c.k;
import kotlin.reflect.jvm.internal.impl.c.a.c.m;
import kotlin.reflect.jvm.internal.impl.c.a.e.x;

public final class a {
    public static final d a(h h2, kotlin.reflect.jvm.internal.impl.a.a.h object) {
        Object object2;
        j.b(h2, "$receiver");
        j.b(object, "additionalAnnotations");
        if (h2.e().p().a()) {
            return h2.a();
        }
        Object object3 = (Iterable)object;
        object = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object2 = a.a(h2, (c)object3.next());
            if (object2 == null) continue;
            object.add(object2);
        }
        object3 = (List)object;
        if (object3.isEmpty()) {
            return h2.a();
        }
        object = h2.a();
        object = object != null && (object = ((d)object).a()) != null ? new EnumMap<a.a, kotlin.reflect.jvm.internal.impl.c.a.f.h>((EnumMap<a.a, kotlin.reflect.jvm.internal.impl.c.a.f.h>)object) : new EnumMap(a.a.class);
        boolean bl2 = false;
        object3 = object3.iterator();
        while (object3.hasNext()) {
            k k2 = (k)object3.next();
            object2 = k2.a();
            for (a.a a2 : k2.b()) {
                ((Map)object).put(a2, object2);
                bl2 = true;
            }
        }
        if (!bl2) {
            return h2.a();
        }
        return new d((EnumMap<a.a, kotlin.reflect.jvm.internal.impl.c.a.f.h>)object);
    }

    public static final h a(final h h2, final kotlin.reflect.jvm.internal.impl.a.g g2, x x2, int n2) {
        j.b(h2, "$receiver");
        j.b(g2, "containingDeclaration");
        return a.a(h2, g2, x2, n2, kotlin.h.a(l.c, (kotlin.e.a.a)new kotlin.e.a.a<d>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final d b() {
                return a.a(h2, g2.x());
            }
        }));
    }

    public static /* bridge */ /* synthetic */ h a(h h2, kotlin.reflect.jvm.internal.impl.a.g g2, x x2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            x2 = null;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return a.a(h2, g2, x2, n2);
    }

    public static final h a(h h2, kotlin.reflect.jvm.internal.impl.a.m m2, x x2, int n2) {
        j.b(h2, "$receiver");
        j.b(m2, "containingDeclaration");
        j.b(x2, "typeParameterOwner");
        return a.a(h2, m2, x2, n2, h2.g());
    }

    public static /* bridge */ /* synthetic */ h a(h h2, kotlin.reflect.jvm.internal.impl.a.m m2, x x2, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return a.a(h2, m2, x2, n2);
    }

    private static final h a(h object, kotlin.reflect.jvm.internal.impl.a.m m2, x x2, int n2, g<d> g2) {
        kotlin.reflect.jvm.internal.impl.c.a.c.b b2 = ((h)object).e();
        object = x2 != null ? (m)new i((h)object, m2, x2, n2) : ((h)object).f();
        return new h(b2, (m)object, g2);
    }

    public static final h a(h h2, kotlin.reflect.jvm.internal.impl.c.a.c.b b2) {
        j.b(h2, "$receiver");
        j.b(b2, "components");
        return new h(b2, h2.f(), h2.g());
    }

    public static final h a(h h2, m m2) {
        j.b(h2, "$receiver");
        j.b(m2, "typeParameterResolver");
        return new h(h2.e(), m2, h2.g());
    }

    private static final k a(h object, c object2) {
        kotlin.reflect.jvm.internal.impl.c.a.a a2 = ((h)object).e().p();
        Object object3 = a2.b((c)object2);
        if (object3 != null) {
            return object3;
        }
        object3 = a2.c((c)object2);
        if (object3 != null) {
            c c2 = ((a.b)object3).a();
            object3 = ((a.b)object3).b();
            if ((object2 = a2.e((c)object2)) == null) {
                object2 = a2.d(c2);
            }
            if (((kotlin.reflect.jvm.internal.impl.l.h)((Object)object2)).b()) {
                return null;
            }
            if ((object = ((h)object).e().q().a(c2)) != null && (object = kotlin.reflect.jvm.internal.impl.c.a.f.h.a((kotlin.reflect.jvm.internal.impl.c.a.f.h)object, null, ((kotlin.reflect.jvm.internal.impl.l.h)((Object)object2)).a(), 1, null)) != null) {
                return new k((kotlin.reflect.jvm.internal.impl.c.a.f.h)object, (Collection)object3);
            }
        }
        return null;
    }

    public static final h b(final h h2, final kotlin.reflect.jvm.internal.impl.a.a.h h3) {
        j.b(h2, "$receiver");
        j.b(h3, "additionalAnnotations");
        if (h3.a()) {
            return h2;
        }
        return new h(h2.e(), h2.f(), kotlin.h.a(l.c, (kotlin.e.a.a)new kotlin.e.a.a<d>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final d b() {
                return a.a(h2, h3);
            }
        }));
    }

}

