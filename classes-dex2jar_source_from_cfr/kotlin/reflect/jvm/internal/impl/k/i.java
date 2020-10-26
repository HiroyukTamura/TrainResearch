/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.k;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.k.d;
import kotlin.reflect.jvm.internal.impl.k.e;
import kotlin.reflect.jvm.internal.impl.k.f;
import kotlin.reflect.jvm.internal.impl.k.h;
import kotlin.reflect.jvm.internal.impl.k.j;
import kotlin.reflect.jvm.internal.impl.k.k;
import kotlin.reflect.jvm.internal.impl.k.l;

public final class i
extends kotlin.reflect.jvm.internal.impl.k.a {
    public static final i a = new i();
    private static final List<d> b;

    static {
        Object object = j.i;
        kotlin.e.b.j.a(object, "GET");
        object = new d((kotlin.reflect.jvm.internal.impl.e.f)object, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, new l.a(1)}, null, 4, null);
        Object object2 = j.j;
        kotlin.e.b.j.a(object2, "SET");
        Object object3 = f.b.a;
        Object object4 = new l.a(2);
        Object object5 = a.a;
        object2 = new d((kotlin.reflect.jvm.internal.impl.e.f)object2, new kotlin.reflect.jvm.internal.impl.k.b[]{object3, object4}, (kotlin.e.a.b<? super t, String>)object5);
        object3 = j.a;
        kotlin.e.b.j.a(object3, "GET_VALUE");
        object3 = new d((kotlin.reflect.jvm.internal.impl.e.f)object3, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, h.a, new l.a(2), e.a}, null, 4, null);
        object4 = j.b;
        kotlin.e.b.j.a(object4, "SET_VALUE");
        object4 = new d((kotlin.reflect.jvm.internal.impl.e.f)object4, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, h.a, new l.a(3), e.a}, null, 4, null);
        object5 = j.c;
        kotlin.e.b.j.a(object5, "PROVIDE_DELEGATE");
        object5 = new d((kotlin.reflect.jvm.internal.impl.e.f)object5, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, h.a, new l.b(2), e.a}, null, 4, null);
        Object object6 = j.g;
        kotlin.e.b.j.a(object6, "INVOKE");
        object6 = new d((kotlin.reflect.jvm.internal.impl.e.f)object6, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a}, null, 4, null);
        Object object7 = j.f;
        kotlin.e.b.j.a(object7, "CONTAINS");
        object7 = new d((kotlin.reflect.jvm.internal.impl.e.f)object7, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.d.a, h.a, k.a.a}, null, 4, null);
        Object object8 = j.h;
        kotlin.e.b.j.a(object8, "ITERATOR");
        object8 = new d((kotlin.reflect.jvm.internal.impl.e.f)object8, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.c.a}, null, 4, null);
        Object object9 = j.k;
        kotlin.e.b.j.a(object9, "NEXT");
        object9 = new d((kotlin.reflect.jvm.internal.impl.e.f)object9, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.c.a}, null, 4, null);
        Object object10 = j.l;
        kotlin.e.b.j.a(object10, "HAS_NEXT");
        object10 = new d((kotlin.reflect.jvm.internal.impl.e.f)object10, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.c.a, k.a.a}, null, 4, null);
        Object object11 = j.A;
        kotlin.e.b.j.a(object11, "RANGE_TO");
        object11 = new d((kotlin.reflect.jvm.internal.impl.e.f)object11, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.d.a, h.a}, null, 4, null);
        Object object12 = j.d;
        kotlin.e.b.j.a(object12, "EQUALS");
        Object object13 = f.a.a;
        Object object14 = b.a;
        object12 = new d((kotlin.reflect.jvm.internal.impl.e.f)object12, new kotlin.reflect.jvm.internal.impl.k.b[]{object13}, (kotlin.e.a.b<? super t, String>)object14);
        object13 = j.e;
        kotlin.e.b.j.a(object13, "COMPARE_TO");
        object13 = new d((kotlin.reflect.jvm.internal.impl.e.f)object13, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, k.b.a, l.d.a, h.a}, null, 4, null);
        object14 = new d(j.J, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.d.a, h.a}, null, 4, null);
        d d2 = new d(j.I, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.c.a}, null, 4, null);
        Collection collection = m.b(j.p, j.q);
        kotlin.reflect.jvm.internal.impl.k.b b2 = f.b.a;
        kotlin.e.a.b b3 = c.a;
        b = m.b(object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11, object12, object13, object14, d2, new d(collection, new kotlin.reflect.jvm.internal.impl.k.b[]{b2}, (kotlin.e.a.b<? super t, String>)b3), new d(j.K, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, k.c.a, l.d.a, h.a}, null, 4, null), new d(j.m, new kotlin.reflect.jvm.internal.impl.k.b[]{f.b.a, l.c.a}, null, 4, null));
    }

    private i() {
    }

    @Override
    public List<d> a() {
        return b;
    }

}

