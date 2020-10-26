/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.c.ag;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public class k {
    public static au a(List<kotlin.reflect.jvm.internal.impl.a.as> object, as as2, m m2, List<kotlin.reflect.jvm.internal.impl.a.as> list) {
        if ((object = k.a(object, as2, m2, list, null)) != null) {
            return object;
        }
        throw new AssertionError((Object)"Substitution failed");
    }

    public static au a(List<kotlin.reflect.jvm.internal.impl.a.as> object, as object2, m m2, List<kotlin.reflect.jvm.internal.impl.a.as> iterator, boolean[] arrbl) {
        HashMap<an, ar> object32 = new HashMap<an, ar>();
        HashMap<kotlin.reflect.jvm.internal.impl.a.as, ag> hashMap = new HashMap<kotlin.reflect.jvm.internal.impl.a.as, ag>();
        Object object3 = object.iterator();
        int n2 = 0;
        while (object3.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.as as2 = (kotlin.reflect.jvm.internal.impl.a.as)object3.next();
            ag ag2 = ag.a(m2, as2.x(), as2.l(), as2.k(), as2.h_(), n2, kotlin.reflect.jvm.internal.impl.a.an.a);
            object32.put(as2.e(), new ar(ag2.i_()));
            hashMap.put(as2, ag2);
            iterator.add((w)((Object)ag2));
            ++n2;
        }
        object2 = au.a((as)object2, ao.a(object32));
        object = object.iterator();
        while (object.hasNext()) {
            iterator = (kotlin.reflect.jvm.internal.impl.a.as)object.next();
            m2 = (ag)hashMap.get(iterator);
            for (w w2 : iterator.j()) {
                object3 = ((au)object2).b(w2, ba.b);
                if (object3 == null) {
                    return null;
                }
                if (object3 != w2 && arrbl != null) {
                    arrbl[0] = true;
                }
                ((ag)m2).b((w)object3);
            }
            ((ag)m2).o();
        }
        return object2;
    }
}

