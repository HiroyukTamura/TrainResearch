/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e.a;

import kotlin.reflect.jvm.internal.impl.h.e.a.a;
import kotlin.reflect.jvm.internal.impl.h.e.a.e;
import kotlin.reflect.jvm.internal.impl.j.w;

public class h
extends a {
    public h(w w2) {
        this(w2, null);
    }

    private h(w w2, e e2) {
        super(w2, e2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Transient} : ");
        stringBuilder.append(this.a());
        return stringBuilder.toString();
    }
}

