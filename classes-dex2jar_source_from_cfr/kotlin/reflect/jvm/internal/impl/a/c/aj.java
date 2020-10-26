/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.c.ai;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.g;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class aj
extends ai {
    static final /* synthetic */ boolean d;
    protected g<kotlin.reflect.jvm.internal.impl.h.b.f<?>> a;
    private final boolean e;

    static {
        d = aj.class.desiredAssertionStatus() ^ true;
    }

    public aj(m m2, h h2, f f2, w w2, boolean bl2, an an2) {
        super(m2, h2, f2, w2, an2);
        this.e = bl2;
    }

    public void a(g<kotlin.reflect.jvm.internal.impl.h.b.f<?>> object) {
        if (!d && this.s()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Constant value for variable initializer should be recorded only for final variables: ");
            ((StringBuilder)object).append(this.h_());
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        this.a = object;
    }

    @Override
    public boolean s() {
        return this.e;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.b.f<?> t() {
        if (this.a != null) {
            return (kotlin.reflect.jvm.internal.impl.h.b.f)this.a.a();
        }
        return null;
    }
}

