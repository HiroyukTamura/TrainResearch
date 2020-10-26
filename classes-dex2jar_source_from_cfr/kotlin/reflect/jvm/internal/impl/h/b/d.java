/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.m;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class d
extends m<Byte> {
    public d(byte by2) {
        super(by2);
    }

    @Override
    public /* synthetic */ w a(y y2) {
        return this.b(y2);
    }

    public ad b(y y2) {
        j.b(y2, "module");
        return y2.a().getByteType();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number)this.a()).byteValue());
        stringBuilder.append(".toByte()");
        return stringBuilder.toString();
    }
}

