/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public final class at {
    public static final ad a(ad ad2, List<? extends ap> list, h h2) {
        j.b(ad2, "$receiver");
        j.b(list, "newArguments");
        j.b(h2, "newAnnotations");
        if (list.isEmpty() && h2 == ad2.x()) {
            return ad2;
        }
        if (list.isEmpty()) {
            return ad2.c(h2);
        }
        return x.a(h2, ad2.g(), list, ad2.c());
    }

    public static /* synthetic */ ad a(ad ad2, List list, h h2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = ad2.a();
        }
        if ((n2 & 2) != 0) {
            h2 = ad2.x();
        }
        return at.a(ad2, list, h2);
    }

    public static final ad a(w w2) {
        j.b(w2, "$receiver");
        az az2 = w2.l();
        Object object = az2;
        if (!(az2 instanceof ad)) {
            object = null;
        }
        if ((object = (ad)object) != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("This is should be simple type: ");
        ((StringBuilder)object).append(w2);
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final w a(w w2, List<? extends ap> list, h h2) {
        j.b(w2, "$receiver");
        j.b(list, "newArguments");
        j.b(h2, "newAnnotations");
        if ((list.isEmpty() || list == w2.a()) && h2 == w2.x()) {
            return w2;
        }
        if ((w2 = w2.l()) instanceof q) {
            w2 = (q)w2;
            return x.a(at.a(((q)w2).f(), list, h2), at.a(((q)w2).h(), list, h2));
        }
        if (!(w2 instanceof ad)) throw new m();
        return at.a((ad)w2, list, h2);
    }

    public static /* synthetic */ w a(w w2, List list, h h2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = w2.a();
        }
        if ((n2 & 2) != 0) {
            h2 = w2.x();
        }
        return at.a(w2, list, h2);
    }
}

