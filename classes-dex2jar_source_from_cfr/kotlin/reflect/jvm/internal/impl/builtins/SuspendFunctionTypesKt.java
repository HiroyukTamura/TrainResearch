/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.c.ag;
import kotlin.reflect.jvm.internal.impl.a.c.m;
import kotlin.reflect.jvm.internal.impl.a.c.v;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.i.b;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.y;

public final class SuspendFunctionTypesKt {
    private static final v a;
    private static final v b;

    static {
        kotlin.reflect.jvm.internal.impl.a.m m2 = p.a();
        j.a((Object)m2, "ErrorUtils.getErrorModule()");
        kotlin.reflect.jvm.internal.impl.e.b b2 = c.e;
        j.a((Object)b2, "DescriptorUtils.COROUTIN\u2026KAGE_FQ_NAME_EXPERIMENTAL");
        m2 = new v(new m((kotlin.reflect.jvm.internal.impl.a.y)m2, b2), kotlin.reflect.jvm.internal.impl.a.f.b, false, false, c.g.e(), an.a, b.a);
        ((v)m2).a(w.d);
        ((v)m2).a(az.e);
        ((v)m2).a(kotlin.a.m.a(ag.a(m2, h.a.a(), false, ba.b, f.a("T"), 0)));
        ((v)m2).c();
        a = m2;
        m2 = p.a();
        j.a((Object)m2, "ErrorUtils.getErrorModule()");
        b2 = c.d;
        j.a((Object)b2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        m2 = new v(new m((kotlin.reflect.jvm.internal.impl.a.y)m2, b2), kotlin.reflect.jvm.internal.impl.a.f.b, false, false, c.h.e(), an.a, b.a);
        ((v)m2).a(w.d);
        ((v)m2).a(az.e);
        ((v)m2).a(kotlin.a.m.a(ag.a(m2, h.a.a(), false, ba.b, f.a("T"), 0)));
        ((v)m2).c();
        b = m2;
    }

    public static final v getFAKE_CONTINUATION_CLASS_DESCRIPTOR_EXPERIMENTAL() {
        return a;
    }

    public static final v getFAKE_CONTINUATION_CLASS_DESCRIPTOR_RELEASE() {
        return b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isContinuation(kotlin.reflect.jvm.internal.impl.e.b b2, boolean bl2) {
        kotlin.reflect.jvm.internal.impl.e.b b3;
        if (bl2) {
            b3 = c.h;
            do {
                return j.a((Object)b2, (Object)b3);
                break;
            } while (true);
        }
        b3 = c.g;
        return j.a((Object)b2, (Object)b3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final ad transformSuspendFunctionToRuntimeFunctionType(kotlin.reflect.jvm.internal.impl.j.w w2, boolean bl2) {
        j.b(w2, "suspendFunType");
        boolean bl3 = FunctionTypesKt.isSuspendFunctionType(w2);
        if (y.a && !bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("This type should be suspend function type: ");
            stringBuilder.append(w2);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        KotlinBuiltIns kotlinBuiltIns = a.a(w2);
        h h2 = w2.x();
        kotlin.reflect.jvm.internal.impl.j.w w3 = FunctionTypesKt.getReceiverTypeFromFunctionType(w2);
        Object object = FunctionTypesKt.getValueParameterTypesFromFunctionType(w2);
        Object object2 = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            object2.add(((ap)object.next()).c());
        }
        object = (List)object2;
        h h3 = h.a.a();
        object2 = bl2 ? b : a;
        object2 = ((v)object2).e();
        j.a(object2, "if (isReleaseCoroutines)\u2026ERIMENTAL.typeConstructor");
        object2 = kotlin.a.m.a(object, x.a(h3, (kotlin.reflect.jvm.internal.impl.j.an)object2, kotlin.a.m.a(a.f(FunctionTypesKt.getReturnTypeFromFunctionType(w2))), false));
        object = a.a(w2).getNullableAnyType();
        j.a(object, "suspendFunType.builtIns.nullableAnyType");
        return FunctionTypesKt.createFunctionType$default(kotlinBuiltIns, h2, w3, object2, null, (kotlin.reflect.jvm.internal.impl.j.w)object, false, 64, null).a(w2.c());
    }
}

