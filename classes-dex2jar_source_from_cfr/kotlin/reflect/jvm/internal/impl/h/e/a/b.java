/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e.a;

import kotlin.reflect.jvm.internal.impl.h.e.a.a;
import kotlin.reflect.jvm.internal.impl.h.e.a.d;
import kotlin.reflect.jvm.internal.impl.h.e.a.e;
import kotlin.reflect.jvm.internal.impl.j.w;

public class b
extends a
implements d {
    private final kotlin.reflect.jvm.internal.impl.a.a b;

    public b(kotlin.reflect.jvm.internal.impl.a.a a2, w w2, e e2) {
        super(w2, e2);
        this.b = a2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a());
        stringBuilder.append(": Ext {");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

