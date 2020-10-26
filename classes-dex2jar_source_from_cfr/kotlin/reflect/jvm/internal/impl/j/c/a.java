/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.a.e;
import kotlin.reflect.jvm.internal.impl.j.a.k;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ah;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.at;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public final class a {
    public static final KotlinBuiltIns a(w object) {
        j.b(object, "$receiver");
        object = ((w)object).g().e();
        j.a(object, "constructor.builtIns");
        return object;
    }

    public static final ap a(w w2, ba ba2, as object) {
        j.b(w2, "type");
        j.b((Object)ba2, "projectionKind");
        object = object != null ? object.k() : null;
        ba ba3 = ba2;
        if (object == ba2) {
            ba3 = ba.a;
        }
        return new ar(ba3, w2);
    }

    public static final w a(w w2, h h2) {
        j.b(w2, "$receiver");
        j.b(h2, "newAnnotations");
        if (w2.x().a() && h2.a()) {
            return w2;
        }
        return w2.l().b(h2);
    }

    public static final boolean a(az az2) {
        j.b(az2, "$receiver");
        return az2.g() instanceof k || az2.g().d() instanceof as || az2 instanceof e;
        {
        }
    }

    public static final boolean a(w w2, w w3) {
        j.b(w2, "$receiver");
        j.b(w3, "superType");
        return c.a.a(w2, w3);
    }

    public static final w b(w w2) {
        j.b(w2, "$receiver");
        return av.c(w2);
    }

    public static final w c(w w2) {
        j.b(w2, "$receiver");
        return av.d(w2);
    }

    public static final boolean d(w w2) {
        j.b(w2, "$receiver");
        return KotlinBuiltIns.isAnyOrNullableAny(w2);
    }

    public static final boolean e(w w2) {
        j.b(w2, "$receiver");
        return av.j(w2);
    }

    public static final ap f(w w2) {
        j.b(w2, "$receiver");
        return new ar(w2);
    }

    public static final w g(w object) {
        block17 : {
            az az2;
            block16 : {
                block15 : {
                    Object object2;
                    Iterator iterator;
                    j.b(object, "$receiver");
                    az2 = ((w)object).l();
                    if (!(az2 instanceof q)) break block15;
                    az az3 = (q)az2;
                    object = object2 = ((q)az3).f();
                    if (!((w)object2).g().b().isEmpty()) {
                        if (((w)object2).g().d() == null) {
                            object = object2;
                        } else {
                            object = ((w)object2).g().b();
                            j.a(object, "constructor.parameters");
                            iterator = (Iterable)object;
                            object = new ArrayList(kotlin.a.m.a(iterator, 10));
                            iterator = iterator.iterator();
                            while (iterator.hasNext()) {
                                object.add(new ah((as)iterator.next()));
                            }
                            object = at.a((ad)object2, (List)object, null, 2, null);
                        }
                    }
                    az3 = ((q)az3).h();
                    object2 = az3;
                    if (!az3.g().b().isEmpty()) {
                        if (az3.g().d() == null) {
                            object2 = az3;
                        } else {
                            object2 = az3.g().b();
                            j.a(object2, "constructor.parameters");
                            iterator = (Iterable)object2;
                            object2 = new ArrayList(kotlin.a.m.a(iterator, 10));
                            iterator = iterator.iterator();
                            while (iterator.hasNext()) {
                                object2.add(new ah((as)iterator.next()));
                            }
                            object2 = at.a((ad)az3, (List)object2, null, 2, null);
                        }
                    }
                    object = x.a(object, (ad)object2);
                    break block16;
                }
                if (!(az2 instanceof ad)) break block17;
                ad ad2 = (ad)az2;
                object = ad2;
                if (!ad2.g().b().isEmpty()) {
                    if (ad2.g().d() == null) {
                        object = ad2;
                    } else {
                        object = ad2.g().b();
                        j.a(object, "constructor.parameters");
                        Object object3 = (Iterable)object;
                        object = new ArrayList(kotlin.a.m.a(object3, 10));
                        object3 = object3.iterator();
                        while (object3.hasNext()) {
                            object.add(new ah((as)object3.next()));
                        }
                        object = at.a(ad2, (List)object, null, 2, null);
                    }
                }
                object = (az)object;
            }
            return ax.a((az)object, az2);
        }
        throw new m();
    }
}

