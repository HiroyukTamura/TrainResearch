/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.d;
import kotlin.reflect.jvm.internal.impl.j.i;

public abstract class j
extends i {
    private final ad a;

    public j(ad ad2) {
        kotlin.e.b.j.b(ad2, "delegate");
        this.a = ad2;
    }

    @Override
    public ad a(boolean bl2) {
        if (bl2 == this.c()) {
            return this;
        }
        return this.d().a(bl2).c(this.x());
    }

    public j a(h h2) {
        kotlin.e.b.j.b(h2, "newAnnotations");
        if (h2 != this.x()) {
            return new d(this, h2);
        }
        return this;
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.a(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public /* synthetic */ ad c(h h2) {
        return this.a(h2);
    }

    @Override
    protected ad d() {
        return this.a;
    }
}

