/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.a.a;
import kotlin.reflect.jvm.internal.impl.j.a.e;
import kotlin.reflect.jvm.internal.impl.j.a.f;
import kotlin.reflect.jvm.internal.impl.j.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.l.d;
import kotlin.t;

public final class g {
    public static final ad a(ad ad2, a object, kotlin.e.a.m<? super Integer, ? super e, kotlin.w> m2) {
        Object object2;
        Object object3;
        int n2;
        List<ap> list;
        int n3;
        block13 : {
            j.b(ad2, "type");
            j.b(object, "status");
            j.b(m2, "acceptNewCapturedType");
            if (ad2.a().size() != ad2.g().b().size()) {
                return null;
            }
            list = ad2.a();
            object3 = list;
            boolean bl2 = object3 instanceof Collection;
            int n4 = 0;
            n2 = 1;
            if (bl2 && ((Collection)object3).isEmpty()) {
                n3 = n2;
            } else {
                object2 = object3.iterator();
                do {
                    n3 = n2;
                    if (!object2.hasNext()) break block13;
                } while ((n3 = ((ap)object2.next()).b() == ba.a ? 1 : 0) != 0);
                n3 = 0;
            }
        }
        if (n3 != 0) {
            return null;
        }
        Object object4 = new ArrayList(m.a(object3, 10));
        Object object5 = object3.iterator();
        while (object5.hasNext()) {
            object2 = (ap)object5.next();
            if (object2.b() == ba.a) {
                object3 = object2;
            } else {
                object3 = !object2.a() && object2.b() == ba.b ? object2.c().l() : null;
                object3 = kotlin.reflect.jvm.internal.impl.j.c.a.f(new e((a)((Object)object), (az)object3, (ap)object2));
            }
            object4.add(object3);
        }
        object2 = (List)object4;
        object4 = ao.b.a(ad2.g(), (List<? extends ap>)object2).f();
        n2 = ((Collection)list).size();
        for (n3 = n4; n3 < n2; ++n3) {
            ap ap2 = list.get(n3);
            object5 = (ap)object2.get(n3);
            if (ap2.b() == ba.a) continue;
            object = ad2.g().b().get(n3);
            j.a(object, "type.constructor.parameters[index]");
            object = ((kotlin.reflect.jvm.internal.impl.a.as)object).j();
            j.a(object, "type.constructor.parameters[index].upperBounds");
            object3 = (Iterable)object;
            object = new ArrayList(m.a(object3, 10));
            object3 = object3.iterator();
            while (object3.hasNext()) {
                w w2 = (w)object3.next();
                object.add(h.b.a(((au)object4).a(w2, ba.a).l()));
            }
            object3 = (List)object;
            object = object3;
            if (!ap2.a()) {
                object = object3;
                if (ap2.b() == ba.c) {
                    object = m.a((Collection)object3, h.b.a(ap2.c().l()));
                }
            }
            if ((object3 = object5.c()) != null) {
                object3 = (e)object3;
                ((e)object3).d().a((List<? extends az>)object);
                m2.a((Integer)n3, (e)object3);
                continue;
            }
            throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
        }
        return x.a(ad2.x(), ad2.g(), (List<? extends ap>)object2, ad2.c());
    }

    public static /* synthetic */ ad a(ad ad2, a a2, kotlin.e.a.m m2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            m2 = d.b();
        }
        return g.a(ad2, a2, m2);
    }
}

