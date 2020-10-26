/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e.a;

import kotlin.reflect.jvm.internal.impl.h.e.a.e;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class a
implements e {
    protected final w a;
    private final e b;

    public a(w object, e e2) {
        this.a = object;
        object = e2 != null ? e2 : this;
        this.b = object;
    }

    @Override
    public w a() {
        return this.a;
    }
}

