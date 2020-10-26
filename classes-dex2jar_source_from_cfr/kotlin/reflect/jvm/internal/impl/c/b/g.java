/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;

public final class g
implements q {
    public static final g a = new g();

    private g() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public w a(a.ac object, String string2, ad ad2, ad ad3) {
        j.b(object, "proto");
        j.b(string2, "flexibleId");
        j.b(ad2, "lowerBound");
        j.b(ad3, "upperBound");
        if (j.a((Object)string2, (Object)"kotlin.jvm.PlatformType") ^ true) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Error java flexible type with id: ");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(". (");
            ((StringBuilder)object).append(ad2);
            ((StringBuilder)object).append("..");
            ((StringBuilder)object).append(ad3);
            ((StringBuilder)object).append(')');
            object = p.c(((StringBuilder)object).toString());
            j.a(object, "ErrorUtils.createErrorTy\u2026owerBound..$upperBound)\")");
            do {
                return (w)object;
                break;
            } while (true);
        }
        if (((i.c)object).a(b.g)) {
            object = new kotlin.reflect.jvm.internal.impl.c.a.c.b.g(ad2, ad3);
            return (w)object;
        }
        object = x.a(ad2, ad3);
        return (w)object;
    }
}

