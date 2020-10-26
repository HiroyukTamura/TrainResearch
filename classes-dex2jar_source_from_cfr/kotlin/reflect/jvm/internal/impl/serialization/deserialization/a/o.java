/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.List;
import kotlin.e.a.a;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.b;

public final class o
extends b {
    public o(i i2, a<? extends List<g>> a2) {
        j.b(i2, "storageManager");
        j.b(a2, "compute");
        super(i2, a2);
    }

    @Override
    public boolean a() {
        return false;
    }
}

