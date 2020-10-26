/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.a.a;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.i.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.bb;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class z
extends bb {
    private final f<w> a;

    public z(i i2, a<? extends w> a2) {
        j.b(i2, "storageManager");
        j.b(a2, "computation");
        this.a = i2.a(a2);
    }

    @Override
    protected w d() {
        return (w)this.a.a();
    }

    @Override
    public boolean e() {
        return this.a.b();
    }
}

