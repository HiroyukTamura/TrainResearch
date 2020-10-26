/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.b;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.c.a.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.b;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ah;
import kotlin.reflect.jvm.internal.impl.j.ai;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;

public final class d {
    private static final kotlin.reflect.jvm.internal.impl.e.b a = new kotlin.reflect.jvm.internal.impl.e.b("java.lang.Class");

    public static final kotlin.reflect.jvm.internal.impl.c.a.c.b.a a(l l2, boolean bl2, as as2) {
        j.b((Object)l2, "$receiver");
        return new kotlin.reflect.jvm.internal.impl.c.a.c.b.a(l2, null, bl2, as2, 2, null);
    }

    public static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.c.b.a a(l l2, boolean bl2, as as2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl2 = false;
        }
        if ((n2 & 2) != 0) {
            as2 = null;
        }
        return d.a(l2, bl2, as2);
    }

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.e.b a() {
        return a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final ap a(as object, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2) {
        j.b(object, "typeParameter");
        j.b(a2, "attr");
        if (a2.a() == l.a) {
            object = new ar(ai.a((as)object));
            do {
                return (ap)object;
                break;
            } while (true);
        }
        object = new ah((as)object);
        return (ap)object;
    }

    public static final w a(as as2, as object, kotlin.e.a.a<? extends w> a2) {
        j.b(as2, "$receiver");
        j.b(a2, "defaultValue");
        if (as2 == object) {
            return a2.a();
        }
        Object object2 = as2.j();
        j.a(object2, "upperBounds");
        object2 = m.f(object2);
        if (((w)object2).g().d() instanceof e) {
            j.a(object2, "firstUpperBound");
            return kotlin.reflect.jvm.internal.impl.j.c.a.g((w)object2);
        }
        if (object != null) {
            as2 = object;
        }
        if ((object = ((w)object2).g().d()) != null) {
            while (j.a(object, (Object)as2) ^ true) {
                object = object.j();
                j.a(object, "current.upperBounds");
                object = (w)m.f(object);
                if (((w)object).g().d() instanceof e) {
                    j.a(object, "nextUpperBound");
                    return kotlin.reflect.jvm.internal.impl.j.c.a.g((w)object);
                }
                if ((object = ((w)object).g().d()) != null) continue;
                throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            }
            return a2.a();
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
    }

    public static /* synthetic */ w a(final as as2, as as3, kotlin.e.a.a a2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            as3 = null;
        }
        if ((n2 & 2) != 0) {
            a2 = new kotlin.e.a.a<ad>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final ad b() {
                    Object object = new StringBuilder();
                    ((StringBuilder)object).append("Can't compute erased upper bound of type parameter `");
                    ((StringBuilder)object).append(as2);
                    ((StringBuilder)object).append('`');
                    object = p.c(((StringBuilder)object).toString());
                    j.a(object, "ErrorUtils.createErrorTy\u2026 type parameter `$this`\")");
                    return object;
                }
            };
        }
        return d.a(as2, as3, a2);
    }

}

