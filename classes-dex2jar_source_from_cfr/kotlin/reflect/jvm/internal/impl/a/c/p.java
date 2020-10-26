/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.c.c;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;

public class p
extends c {
    private final e a;
    private final kotlin.reflect.jvm.internal.impl.h.e.a.c b;

    public p(e e2) {
        this.a = e2;
        this.b = new kotlin.reflect.jvm.internal.impl.h.e.a.c(e2, null);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.a.e a() {
        return this.b;
    }

    @Override
    public m b() {
        return this.a;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ");
        stringBuilder.append(this.a.h_());
        stringBuilder.append("::this");
        return stringBuilder.toString();
    }
}

