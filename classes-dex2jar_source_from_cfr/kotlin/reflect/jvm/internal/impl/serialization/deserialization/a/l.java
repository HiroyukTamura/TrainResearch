/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.a;

import java.util.Collection;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.at;
import kotlin.reflect.jvm.internal.impl.a.c.ae;
import kotlin.reflect.jvm.internal.impl.a.c.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.b.i;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.y;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.g;

public final class l
extends d
implements g {
    private Collection<? extends ae> a;
    private ad b;
    private ad c;
    private List<? extends as> d;
    private ad e;
    private boolean f;
    private final kotlin.reflect.jvm.internal.impl.i.i g;
    private final a.ad h;
    private final c i;
    private final kotlin.reflect.jvm.internal.impl.d.b.h j;
    private final k k;
    private final f l;

    public l(kotlin.reflect.jvm.internal.impl.i.i i2, m m2, h h2, kotlin.reflect.jvm.internal.impl.e.f f2, kotlin.reflect.jvm.internal.impl.a.ba ba2, a.ad ad2, c c2, kotlin.reflect.jvm.internal.impl.d.b.h h3, k k2, f f3) {
        j.b(i2, "storageManager");
        j.b(m2, "containingDeclaration");
        j.b(h2, "annotations");
        j.b(f2, "name");
        j.b(ba2, "visibility");
        j.b(ad2, "proto");
        j.b(c2, "nameResolver");
        j.b(h3, "typeTable");
        j.b(k2, "versionRequirementTable");
        an an2 = an.a;
        j.a((Object)an2, "SourceElement.NO_SOURCE");
        super(m2, h2, f2, an2, ba2);
        this.g = i2;
        this.h = ad2;
        this.i = c2;
        this.j = h3;
        this.k = k2;
        this.l = f3;
    }

    private void a(Collection<? extends ae> collection) {
        this.a = collection;
    }

    private void a(ad ad2) {
        this.b = ad2;
    }

    private void a(boolean bl2) {
        this.f = bl2;
    }

    private void b(ad ad2) {
        this.c = ad2;
    }

    @Override
    public /* synthetic */ q K() {
        return this.t();
    }

    @Override
    public c L() {
        return this.i;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.d.b.h M() {
        return this.j;
    }

    @Override
    public k N() {
        return this.k;
    }

    @Override
    public f O() {
        return this.l;
    }

    @Override
    public List<i> P() {
        return g.a.a(this);
    }

    public ar a(au object) {
        j.b(object, "substitutor");
        if (((au)object).a()) {
            return this;
        }
        Object object2 = this.j();
        Object object3 = this.b();
        j.a(object3, "containingDeclaration");
        Object object4 = this.x();
        j.a(object4, "annotations");
        kotlin.reflect.jvm.internal.impl.e.f f2 = this.h_();
        j.a((Object)f2, "name");
        object2 = new l((kotlin.reflect.jvm.internal.impl.i.i)object2, (m)object3, (h)object4, f2, this.p(), this.t(), this.L(), this.M(), this.N(), this.O());
        object3 = this.z();
        object4 = ((au)object).a(this.a(), ba.a);
        j.a(object4, "substitutor.safeSubstitu\u2026Type, Variance.INVARIANT)");
        object4 = kotlin.reflect.jvm.internal.impl.j.at.a((w)object4);
        object = ((au)object).a(this.c(), ba.a);
        j.a(object, "substitutor.safeSubstitu\u2026Type, Variance.INVARIANT)");
        ((l)object2).a((List<? extends as>)object3, (ad)object4, kotlin.reflect.jvm.internal.impl.j.at.a((w)object), this.s());
        return (ar)object2;
    }

    @Override
    public ad a() {
        ad ad2 = this.b;
        if (ad2 == null) {
            j.b("underlyingType");
        }
        return ad2;
    }

    public final void a(List<? extends as> list, ad ad2, ad ad3, boolean bl2) {
        j.b(list, "declaredTypeParameters");
        j.b(ad2, "underlyingType");
        j.b(ad3, "expandedType");
        this.a(list);
        this.a(ad2);
        this.b(ad3);
        this.d = at.a(this);
        this.e = this.q();
        this.a(this.k());
        this.a(bl2);
    }

    @Override
    public ad c() {
        ad ad2 = this.c;
        if (ad2 == null) {
            j.b("expandedType");
        }
        return ad2;
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public e g() {
        kotlin.reflect.jvm.internal.impl.a.h h2;
        if (y.a(this.c())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.a.h h3 = h2 = this.c().g().d();
        if (!(h2 instanceof e)) {
            h3 = null;
        }
        return (e)h3;
    }

    @Override
    public ad i_() {
        ad ad2 = this.e;
        if (ad2 == null) {
            j.b("defaultTypeImpl");
        }
        return ad2;
    }

    @Override
    protected kotlin.reflect.jvm.internal.impl.i.i j() {
        return this.g;
    }

    @Override
    protected List<as> o() {
        List<as> list = this.d;
        if (list == null) {
            j.b("typeConstructorParameters");
        }
        return list;
    }

    public boolean s() {
        return this.f;
    }

    public a.ad t() {
        return this.h;
    }
}

