/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.c.j;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.e.f;

public abstract class k
extends j
implements n {
    private final m a;
    private final an b;

    protected k(m m2, h h2, f f2, an an2) {
        super(h2, f2);
        this.a = m2;
        this.b = an2;
    }

    @Override
    public m b() {
        return this.a;
    }

    @Override
    public /* synthetic */ m m_() {
        return this.n_();
    }

    public p n_() {
        return (p)super.m_();
    }

    @Override
    public an y() {
        return this.b;
    }
}

