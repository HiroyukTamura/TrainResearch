/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.y;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.d.b.i;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.w;

public final class j
extends y
implements c {
    private boolean e;
    private final a.w f;
    private final kotlin.reflect.jvm.internal.impl.d.b.c g;
    private final kotlin.reflect.jvm.internal.impl.d.b.h h;
    private final k i;
    private final f j;

    public j(m m2, ai ai2, h h2, kotlin.reflect.jvm.internal.impl.a.w w2, ba ba2, boolean bl2, kotlin.reflect.jvm.internal.impl.e.f f2, b.a a2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, a.w w3, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h3, k k2, f f3) {
        kotlin.e.b.j.b(m2, "containingDeclaration");
        kotlin.e.b.j.b(h2, "annotations");
        kotlin.e.b.j.b((Object)w2, "modality");
        kotlin.e.b.j.b(ba2, "visibility");
        kotlin.e.b.j.b(f2, "name");
        kotlin.e.b.j.b((Object)a2, "kind");
        kotlin.e.b.j.b(w3, "proto");
        kotlin.e.b.j.b(c2, "nameResolver");
        kotlin.e.b.j.b(h3, "typeTable");
        kotlin.e.b.j.b(k2, "versionRequirementTable");
        super(m2, ai2, h2, w2, ba2, bl2, f2, a2, an.a, bl3, bl4, bl7, false, bl5, bl6);
        this.f = w3;
        this.g = c2;
        this.h = h3;
        this.i = k2;
        this.j = f3;
    }

    private void b(boolean bl2) {
        this.e = bl2;
    }

    public Boolean G() {
        return b.z.a(this.H().e());
    }

    public a.w H() {
        return this.f;
    }

    @Override
    public /* synthetic */ q K() {
        return this.H();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.c L() {
        return this.g;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.h M() {
        return this.h;
    }

    @Override
    public k N() {
        return this.i;
    }

    @Override
    public f O() {
        return this.j;
    }

    @Override
    public List<i> P() {
        return c.a.a(this);
    }

    @Override
    protected y a(m m2, kotlin.reflect.jvm.internal.impl.a.w w2, ba ba2, ai ai2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2) {
        kotlin.e.b.j.b(m2, "newOwner");
        kotlin.e.b.j.b((Object)w2, "newModality");
        kotlin.e.b.j.b(ba2, "newVisibility");
        kotlin.e.b.j.b((Object)a2, "kind");
        kotlin.e.b.j.b(f2, "newName");
        h h2 = this.x();
        boolean bl2 = this.s();
        boolean bl3 = this.A();
        boolean bl4 = this.z();
        Boolean bl5 = this.G();
        kotlin.e.b.j.a((Object)bl5, "isExternal");
        return new j(m2, ai2, h2, w2, ba2, bl2, f2, a2, bl3, bl4, bl5, this.B(), this.u(), this.H(), this.L(), this.M(), this.N(), this.O());
    }

    public final void a(z object, ak ak2, boolean bl2) {
        super.a((z)object, ak2);
        object = w.a;
        this.b(bl2);
    }

    @Override
    public /* synthetic */ boolean w() {
        return this.G();
    }
}

