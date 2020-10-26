/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.i;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public final class f
extends i
implements kotlin.reflect.jvm.internal.impl.j.f {
    private final ad a;

    public f(ad ad2) {
        j.b(ad2, "delegate");
        this.a = ad2;
    }

    private final ad a(ad ad2) {
        ad ad3 = ad2.a(false);
        if (!a.e(ad2)) {
            return ad3;
        }
        return new f(ad3);
    }

    public f a(h h2) {
        j.b(h2, "newAnnotations");
        return new f(this.d().c(h2));
    }

    @Override
    public ad a(boolean bl2) {
        if (bl2) {
            return this.d().a(true);
        }
        return this;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public w a_(w w2) {
        j.b(w2, "replacement");
        w2 = w2.l();
        Object object = w2;
        if (!av.f((w)object) && !a.e((w)object)) {
            return object;
        }
        if (w2 instanceof ad) {
            return this.a((ad)w2);
        }
        if (w2 instanceof q) {
            w2 = (q)w2;
            return ax.b(x.a(this.a(((q)w2).f()), this.a(((q)w2).h())), ax.a((w)object));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Incorrect type: ");
        ((StringBuilder)object).append(w2);
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
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
    public boolean c() {
        return false;
    }

    @Override
    protected ad d() {
        return this.a;
    }

    @Override
    public boolean q_() {
        return true;
    }
}

