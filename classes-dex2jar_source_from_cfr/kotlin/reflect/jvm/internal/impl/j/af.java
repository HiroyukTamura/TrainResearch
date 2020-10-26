/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.aw;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.i;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;

public final class af
extends i
implements aw {
    private final ad a;
    private final w b;

    public af(ad ad2, w w2) {
        j.b(ad2, "delegate");
        j.b(w2, "enhancement");
        this.a = ad2;
        this.b = w2;
    }

    @Override
    public ad a(boolean bl2) {
        az az2 = ax.b(this.j().b(bl2), this.k().l().b(bl2));
        if (az2 != null) {
            return (ad)az2;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.c(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public ad c(h object) {
        j.b(object, "newAnnotations");
        object = ax.b(this.j().b((h)object), this.k());
        if (object != null) {
            return (ad)object;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    @Override
    protected ad d() {
        return this.a;
    }

    @Override
    public az j() {
        return this.d();
    }

    @Override
    public w k() {
        return this.b;
    }
}

