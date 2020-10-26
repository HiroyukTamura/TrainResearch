/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.aw;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class s
extends q
implements aw {
    private final q a;
    private final w b;

    public s(q q2, w w2) {
        j.b(q2, "origin");
        j.b(w2, "enhancement");
        super(q2.f(), q2.h());
        this.a = q2;
        this.b = w2;
    }

    @Override
    public String a(c c2, kotlin.reflect.jvm.internal.impl.g.h h2) {
        j.b(c2, "renderer");
        j.b(h2, "options");
        if (h2.k()) {
            return c2.a(this.k());
        }
        return this.i().a(c2, h2);
    }

    @Override
    public az b(h h2) {
        j.b(h2, "newAnnotations");
        return ax.b(this.i().b(h2), this.k());
    }

    @Override
    public az b(boolean bl2) {
        return ax.b(this.i().b(bl2), this.k().l().b(bl2));
    }

    public q i() {
        return this.a;
    }

    @Override
    public /* synthetic */ az j() {
        return this.i();
    }

    @Override
    public w k() {
        return this.b;
    }

    @Override
    public ad p_() {
        return this.i().p_();
    }
}

