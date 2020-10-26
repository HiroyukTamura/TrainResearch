/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.i;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;

public final class d
extends kotlin.reflect.jvm.internal.impl.a.c.f
implements c {
    private boolean d;
    private final a.e e;
    private final kotlin.reflect.jvm.internal.impl.d.b.c f;
    private final kotlin.reflect.jvm.internal.impl.d.b.h g;
    private final k h;
    private final f i;

    public d(e e2, l l2, h h2, boolean bl2, b.a a2, a.e e3, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h3, k k2, f f2, an an2) {
        j.b(e2, "containingDeclaration");
        j.b(h2, "annotations");
        j.b((Object)a2, "kind");
        j.b(e3, "proto");
        j.b(c2, "nameResolver");
        j.b(h3, "typeTable");
        j.b(k2, "versionRequirementTable");
        if (an2 == null) {
            an2 = an.a;
        }
        super(e2, l2, h2, bl2, a2, an2);
        this.e = e3;
        this.f = c2;
        this.g = h3;
        this.h = k2;
        this.i = f2;
    }

    public /* synthetic */ d(e e2, l l2, h h2, boolean bl2, b.a a2, a.e e3, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h3, k k2, f f2, an an2, int n2, g g2) {
        if ((n2 & 1024) != 0) {
            an2 = null;
        }
        this(e2, l2, h2, bl2, a2, e3, c2, h3, k2, f2, an2);
    }

    @Override
    public boolean D() {
        return false;
    }

    public boolean I() {
        return this.d;
    }

    public a.e J() {
        return this.e;
    }

    @Override
    public /* synthetic */ q K() {
        return this.J();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.c L() {
        return this.f;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.h M() {
        return this.g;
    }

    @Override
    public k N() {
        return this.h;
    }

    @Override
    public f O() {
        return this.i;
    }

    @Override
    public List<i> P() {
        return c.a.a(this);
    }

    @Override
    public /* synthetic */ o a(m m2, t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        return this.c(m2, t2, a2, f2, h2, an2);
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.c.f b(m m2, t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        return this.c(m2, t2, a2, f2, h2, an2);
    }

    protected d c(m m2, t t2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        j.b(m2, "newOwner");
        j.b((Object)a2, "kind");
        j.b(h2, "annotations");
        j.b(an2, "source");
        m2 = new d((e)m2, (l)t2, h2, this.a, a2, this.J(), this.L(), this.M(), this.N(), this.O(), an2);
        ((d)m2).k(this.I());
        return m2;
    }

    @Override
    public boolean c() {
        return false;
    }

    public void k(boolean bl2) {
        this.d = bl2;
    }

    @Override
    public boolean w() {
        return false;
    }
}

