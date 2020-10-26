/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.c.a;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;

public abstract class g
extends a {
    private final m c;
    private final an d;
    private final boolean e;

    protected g(i i2, m m2, f f2, an an2, boolean bl2) {
        super(i2, f2);
        this.c = m2;
        this.d = an2;
        this.e = bl2;
    }

    @Override
    public m b() {
        return this.c;
    }

    @Override
    public boolean w() {
        return this.e;
    }

    @Override
    public an y() {
        return this.d;
    }
}

