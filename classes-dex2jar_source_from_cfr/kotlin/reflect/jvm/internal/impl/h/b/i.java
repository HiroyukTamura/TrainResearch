/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import kotlin.e.b.j;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.s;

public final class i
extends f<o<? extends a, ? extends kotlin.reflect.jvm.internal.impl.e.f>> {
    private final a a;
    private final kotlin.reflect.jvm.internal.impl.e.f b;

    public i(a a2, kotlin.reflect.jvm.internal.impl.e.f f2) {
        j.b(a2, "enumClassId");
        j.b(f2, "enumEntryName");
        super(s.a(a2, f2));
        this.a = a2;
        this.b = f2;
    }

    @Override
    public w a(y object) {
        block5 : {
            block4 : {
                j.b(object, "module");
                object = kotlin.reflect.jvm.internal.impl.a.s.a((y)object, this.a);
                if (object == null) break block4;
                if (!c.m((m)object)) {
                    object = null;
                }
                if (object != null && (object = object.i_()) != null) break block5;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Containing class for error-class based enum entry ");
            ((StringBuilder)object).append(this.a);
            ((StringBuilder)object).append('.');
            ((StringBuilder)object).append(this.b);
            object = p.c(((StringBuilder)object).toString());
            j.a(object, "ErrorUtils.createErrorTy\u2026mClassId.$enumEntryName\")");
        }
        return (w)object;
    }

    public final kotlin.reflect.jvm.internal.impl.e.f b() {
        return this.b;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.c());
        stringBuilder.append('.');
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}

