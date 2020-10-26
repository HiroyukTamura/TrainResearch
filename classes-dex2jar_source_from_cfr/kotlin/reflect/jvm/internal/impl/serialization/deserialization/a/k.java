/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.List;
import java.util.Map;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.a;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.i;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;

public final class k
extends ac
implements c {
    private boolean a;
    private final a.o b;
    private final kotlin.reflect.jvm.internal.impl.d.b.c d;
    private final kotlin.reflect.jvm.internal.impl.d.b.h e;
    private final kotlin.reflect.jvm.internal.impl.d.b.k f;
    private final f g;

    public k(m m2, am am2, h h2, kotlin.reflect.jvm.internal.impl.e.f f2, b.a a2, a.o o2, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h3, kotlin.reflect.jvm.internal.impl.d.b.k k2, f f3, an an2) {
        j.b(m2, "containingDeclaration");
        j.b(h2, "annotations");
        j.b(f2, "name");
        j.b((Object)a2, "kind");
        j.b(o2, "proto");
        j.b(c2, "nameResolver");
        j.b(h3, "typeTable");
        j.b(k2, "versionRequirementTable");
        if (an2 == null) {
            an2 = an.a;
        }
        super(m2, am2, h2, f2, a2, an2);
        this.b = o2;
        this.d = c2;
        this.e = h3;
        this.f = k2;
        this.g = f3;
    }

    public /* synthetic */ k(m m2, am am2, h h2, kotlin.reflect.jvm.internal.impl.e.f f2, b.a a2, a.o o2, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h3, kotlin.reflect.jvm.internal.impl.d.b.k k2, f f3, an an2, int n2, g g2) {
        if ((n2 & 1024) != 0) {
            an2 = null;
        }
        this(m2, am2, h2, f2, a2, o2, c2, h3, k2, f3, an2);
    }

    private void k(boolean bl2) {
        this.a = bl2;
    }

    @Override
    public /* synthetic */ q K() {
        return this.q();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.c L() {
        return this.d;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.h M() {
        return this.e;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.k N() {
        return this.f;
    }

    @Override
    public f O() {
        return this.g;
    }

    @Override
    public List<i> P() {
        return c.a.a(this);
    }

    public final ac a(kotlin.reflect.jvm.internal.impl.j.w a2, al al2, List<? extends as> list, List<? extends av> list2, kotlin.reflect.jvm.internal.impl.j.w w2, w w3, ba ba2, Map<? extends t.b<?>, ?> map, boolean bl2) {
        j.b(list, "typeParameters");
        j.b(list2, "unsubstitutedValueParameters");
        j.b(ba2, "visibility");
        j.b(map, "userDataMap");
        a2 = super.a((kotlin.reflect.jvm.internal.impl.j.w)a2, al2, list, list2, w2, w3, ba2, map);
        this.k(bl2);
        j.a((Object)a2, "super.initialize(\n      \u2026easeEnvironment\n        }");
        return a2;
    }

    @Override
    protected o a(m m2, t object, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2, h h2, an an2) {
        j.b(m2, "newOwner");
        j.b((Object)a2, "kind");
        j.b(h2, "annotations");
        j.b(an2, "source");
        am am2 = (am)object;
        if (f2 != null) {
            object = f2;
        } else {
            object = this.h_();
            j.a(object, "name");
        }
        return new k(m2, am2, h2, (kotlin.reflect.jvm.internal.impl.e.f)object, a2, this.q(), this.L(), this.M(), this.N(), this.O(), an2);
    }

    public a.o q() {
        return this.b;
    }
}

