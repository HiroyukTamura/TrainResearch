/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ae;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.d;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.r;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class x {
    public static final x a = new x();

    private x() {
    }

    /*
     * Enabled aggressive block sorting
     */
    private final kotlin.reflect.jvm.internal.impl.h.e.h a(an object, List<? extends ap> object2) {
        kotlin.reflect.jvm.internal.impl.a.h h2 = object.d();
        if (h2 instanceof kotlin.reflect.jvm.internal.impl.a.as) {
            object = h2.i_();
            return ((w)object).b();
        }
        if (h2 instanceof e) {
            if (object2.isEmpty()) {
                object = ((e)h2).i_();
                return ((w)object).b();
            }
            object = ((e)h2).a(ao.b.a((an)object, (List<? extends ap>)object2));
            object2 = "descriptor.getMemberScop\u2026(constructor, arguments))";
        } else {
            if (!(h2 instanceof ar)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unsupported classifier: ");
                ((StringBuilder)object2).append(h2);
                ((StringBuilder)object2).append(" for constructor: ");
                ((StringBuilder)object2).append(object);
                throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString());
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Scope for abbreviation: ");
            ((StringBuilder)object).append(((ar)h2).h_());
            object = p.a(((StringBuilder)object).toString(), true);
            object2 = "ErrorUtils.createErrorSc\u2026{descriptor.name}\", true)";
        }
        j.a(object, (String)object2);
        return object;
    }

    public static final ad a(h h2, e object, List<? extends ap> list) {
        j.b(h2, "annotations");
        j.b(object, "descriptor");
        j.b(list, "arguments");
        object = object.e();
        j.a(object, "descriptor.typeConstructor");
        return x.a(h2, (an)object, list, false);
    }

    public static final ad a(h object, an an2, List<? extends ap> list, boolean bl2) {
        j.b(object, "annotations");
        j.b(an2, "constructor");
        j.b(list, "arguments");
        if (object.a() && list.isEmpty() && !bl2 && an2.d() != null) {
            object = an2.d();
            if (object == null) {
                j.a();
            }
            j.a(object, "constructor.declarationDescriptor!!");
            object = object.i_();
            j.a(object, "constructor.declarationDescriptor!!.defaultType");
            return object;
        }
        return x.a((h)object, an2, list, bl2, a.a(an2, list));
    }

    public static final ad a(h h2, an object, List<? extends ap> list, boolean bl2, kotlin.reflect.jvm.internal.impl.h.e.h h3) {
        j.b(h2, "annotations");
        j.b(object, "constructor");
        j.b(list, "arguments");
        j.b(h3, "memberScope");
        object = new ae((an)object, list, bl2, h3);
        if (h2.a()) {
            return (ad)object;
        }
        return new d((ad)object, h2);
    }

    public static final az a(ad ad2, ad ad3) {
        j.b(ad2, "lowerBound");
        j.b(ad3, "upperBound");
        if (j.a((Object)ad2, (Object)ad3)) {
            return ad2;
        }
        return new r(ad2, ad3);
    }
}

