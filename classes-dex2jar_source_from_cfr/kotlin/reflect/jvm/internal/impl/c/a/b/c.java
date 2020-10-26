/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.b;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.f;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.c.a.b.b;
import kotlin.reflect.jvm.internal.impl.c.a.b.i;
import kotlin.reflect.jvm.internal.impl.c.a.b.j;

public class c
extends f
implements b {
    static final /* synthetic */ boolean d;
    private Boolean e = null;
    private Boolean f = null;

    static {
        d = c.class.desiredAssertionStatus() ^ true;
    }

    protected c(e e2, c c2, h h2, boolean bl2, b.a a2, an an2) {
        super(e2, c2, h2, bl2, a2, an2);
    }

    public static c b(e e2, h h2, boolean bl2, an an2) {
        return new c(e2, null, h2, bl2, b.a.a, an2);
    }

    @Override
    public boolean H() {
        if (!d && this.e == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hasStableParameterNames was not set: ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        return this.e;
    }

    @Override
    protected /* synthetic */ o a(m m2, t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        return this.c(m2, t2, a2, f2, h2, an2);
    }

    public /* synthetic */ b a(kotlin.reflect.jvm.internal.impl.j.w w2, List list, kotlin.reflect.jvm.internal.impl.j.w w3) {
        return this.b(w2, list, w3);
    }

    protected c a(e e2, c c2, b.a a2, an an2, h h2) {
        return new c(e2, c2, h2, this.a, a2, an2);
    }

    @Override
    protected /* synthetic */ f b(m m2, t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        return this.c(m2, t2, a2, f2, h2, an2);
    }

    public c b(kotlin.reflect.jvm.internal.impl.j.w w2, List<j> list, kotlin.reflect.jvm.internal.impl.j.w w3) {
        c c2 = this.c(this.G(), null, this.n(), null, this.x(), this.y());
        c2.a(w2, this.e(), this.f(), i.a(list, this.i(), c2), w3, this.m(), this.p());
        return c2;
    }

    protected c c(m object, t object2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        if (a2 != b.a.a && a2 != b.a.d) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append("\n");
            ((StringBuilder)object2).append("newOwner: ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append("\n");
            ((StringBuilder)object2).append("kind: ");
            ((StringBuilder)object2).append((Object)a2);
            throw new IllegalStateException(((StringBuilder)object2).toString());
        }
        if (!d && f2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Attempt to rename constructor: ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        object = this.a((e)object, (c)object2, a2, an2, h2);
        ((c)object).i(this.H());
        ((c)object).j(this.j());
        return object;
    }

    @Override
    public void i(boolean bl2) {
        this.e = bl2;
    }

    @Override
    public void j(boolean bl2) {
        this.f = bl2;
    }

    @Override
    public boolean j() {
        if (!d && this.f == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hasSynthesizedParameterNames was not set: ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        return this.f;
    }
}

