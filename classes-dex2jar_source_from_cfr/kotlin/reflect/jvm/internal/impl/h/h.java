/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.h.i;

public abstract class h
extends i {
    protected abstract void a(b var1, b var2);

    @Override
    public void b(b b2, b b3) {
        j.b(b2, "fromSuper");
        j.b(b3, "fromCurrent");
        this.a(b2, b3);
    }

    @Override
    public void c(b b2, b b3) {
        j.b(b2, "first");
        j.b(b3, "second");
        this.a(b2, b3);
    }
}

