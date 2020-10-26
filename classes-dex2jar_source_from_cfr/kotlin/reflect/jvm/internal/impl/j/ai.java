/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;

public final class ai {
    public static final w a(as a2) {
        j.b(a2, "$receiver");
        Object object = a2.b();
        if (object != null) {
            object = ((i)object).e();
            j.a(object, "classDescriptor.typeConstructor");
            object = object.b();
            j.a(object, "classDescriptor.typeConstructor.parameters");
            List<w> list = (Iterable)object;
            object = new ArrayList(kotlin.a.m.a(list, 10));
            for (as as2 : list) {
                j.a((Object)as2, "it");
                object.add((as)((Object)as2.e()));
            }
            object = au.a(new ao((List)object){
                final /* synthetic */ List a;
                {
                    this.a = list;
                }

                @Override
                public ap a(an object) {
                    j.b(object, "key");
                    if (this.a.contains(object)) {
                        if ((object = object.d()) != null) {
                            return av.a((as)object);
                        }
                        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    }
                    return null;
                }
            });
            list = a2.j();
            j.a(list, "this.upperBounds");
            object = ((au)object).b(kotlin.a.m.f(list), ba.c);
            if (object != null) {
                return object;
            }
            a2 = kotlin.reflect.jvm.internal.impl.h.c.a.d((m)a2).getDefaultBound();
            j.a((Object)a2, "builtIns.defaultBound");
            return (w)a2;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
    }

}

