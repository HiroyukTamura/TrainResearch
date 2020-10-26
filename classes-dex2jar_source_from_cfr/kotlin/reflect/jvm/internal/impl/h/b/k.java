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

public final class k
extends f<Float> {
    public k(float f2) {
        super(Float.valueOf(f2));
    }

    @Override
    public /* synthetic */ w a(y y2) {
        return this.b(y2);
    }

    public ad b(y y2) {
        j.b(y2, "module");
        return y2.a().getFloatType();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number)this.a()).floatValue());
        stringBuilder.append(".toFloat()");
        return stringBuilder.toString();
    }
}

