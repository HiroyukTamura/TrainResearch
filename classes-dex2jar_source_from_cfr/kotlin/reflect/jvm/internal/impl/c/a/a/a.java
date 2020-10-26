/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.e.a.b;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.i;
import kotlin.reflect.jvm.internal.impl.c.a.e.j;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.reflect.jvm.internal.impl.c.a.e.y;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.w;

public final class a {
    public static <D extends kotlin.reflect.jvm.internal.impl.a.b> Collection<D> a(f f2, Collection<D> collection, Collection<D> collection2, e e2, p p2) {
        return a.a(f2, collection, collection2, e2, p2, false);
    }

    private static <D extends kotlin.reflect.jvm.internal.impl.a.b> Collection<D> a(f f2, Collection<D> collection, Collection<D> collection2, e e2, final p p2, final boolean bl2) {
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        kotlin.reflect.jvm.internal.impl.h.j.a(f2, collection, collection2, e2, new h(){

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                kotlin.reflect.jvm.internal.impl.h.j.a(b2, new b<kotlin.reflect.jvm.internal.impl.a.b, w>(){

                    @Override
                    public w a(kotlin.reflect.jvm.internal.impl.a.b b2) {
                        p2.a(b2);
                        return w.a;
                    }
                });
                linkedHashSet.add(b2);
            }

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.a.b b2, Collection<? extends kotlin.reflect.jvm.internal.impl.a.b> collection) {
                if (bl2 && b2.n() != b.a.b) {
                    return;
                }
                super.a(b2, collection);
            }

            @Override
            public void a(kotlin.reflect.jvm.internal.impl.a.b b2, kotlin.reflect.jvm.internal.impl.a.b b3) {
            }

        });
        return linkedHashSet;
    }

    public static av a(f f2, e iterator) {
        if ((iterator = iterator.k()).size() != 1) {
            return null;
        }
        for (av av2 : ((d)iterator.iterator().next()).i()) {
            if (!av2.h_().equals(f2)) continue;
            return av2;
        }
        return null;
    }

    public static boolean a(kotlin.reflect.jvm.internal.impl.c.a.e.p p2) {
        return p2.f().g() && p2 instanceof q && a.a((q)p2);
    }

    public static boolean a(q q2) {
        String string2 = q2.r().a();
        if (!string2.equals("toString") && !string2.equals("hashCode")) {
            if (string2.equals("equals")) {
                return a.a(q2, "java.lang.Object");
            }
            return false;
        }
        return q2.c().isEmpty();
    }

    private static boolean a(q object, String string2) {
        if ((object = object.c()).size() == 1 && (object = ((y)object.get(0)).d()) instanceof j && (object = ((j)object).c()) instanceof g) {
            return (object = ((g)object).c()) != null && ((kotlin.reflect.jvm.internal.impl.e.b)object).a().equals(string2);
        }
        return false;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.a.b> Collection<D> b(f f2, Collection<D> collection, Collection<D> collection2, e e2, p p2) {
        return a.a(f2, collection, collection2, e2, p2, true);
    }

}

