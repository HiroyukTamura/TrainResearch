/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.a;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.b.x;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class t
extends x<Byte> {
    public t(byte by2) {
        super(by2);
    }

    @Override
    public w a(y a2) {
        j.b(a2, "module");
        kotlin.reflect.jvm.internal.impl.e.a a3 = KotlinBuiltIns.FQ_NAMES.uByte;
        j.a((Object)a3, "KotlinBuiltIns.FQ_NAMES.uByte");
        a2 = s.a(a2, a3);
        if (a2 == null || (a2 = a2.i_()) == null) {
            a2 = p.c("Unsigned type UByte not found");
            j.a((Object)a2, "ErrorUtils.createErrorTy\u2026ed type UByte not found\")");
        }
        return (w)a2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number)this.a()).byteValue());
        stringBuilder.append(".toUByte()");
        return stringBuilder.toString();
    }
}

