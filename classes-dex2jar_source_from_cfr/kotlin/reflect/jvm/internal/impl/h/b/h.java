/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class h
extends f<Double> {
    public h(double d2) {
        super(d2);
    }

    @Override
    public /* synthetic */ w a(y y2) {
        return this.b(y2);
    }

    public ad b(y y2) {
        j.b(y2, "module");
        return y2.a().getDoubleType();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number)this.a()).doubleValue());
        stringBuilder.append(".toDouble()");
        return stringBuilder.toString();
    }
}

