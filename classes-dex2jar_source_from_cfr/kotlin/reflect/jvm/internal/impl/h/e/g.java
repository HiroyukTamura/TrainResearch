/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.e;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.h.e.a;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.f;

public final class g
extends a {
    private final f<h> a;

    public g(f<? extends h> f2) {
        j.b(f2, "scope");
        this.a = f2;
    }

    @Override
    protected h c() {
        return (h)this.a.a();
    }
}

