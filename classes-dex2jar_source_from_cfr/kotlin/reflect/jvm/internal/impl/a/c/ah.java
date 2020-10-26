/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.ax;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ai;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.t;

public class ah
extends ai
implements av {
    public static final a a = new a(null);
    private final av d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final w i;

    public ah(kotlin.reflect.jvm.internal.impl.a.a a2, av av2, int n2, h h2, f f2, w w2, boolean bl2, boolean bl3, boolean bl4, w w3, an an2) {
        j.b(a2, "containingDeclaration");
        j.b(h2, "annotations");
        j.b(f2, "name");
        j.b(w2, "outType");
        j.b(an2, "source");
        super(a2, h2, f2, w2, an2);
        this.e = n2;
        this.f = bl2;
        this.g = bl3;
        this.h = bl4;
        this.i = w3;
        if (av2 == null) {
            av2 = this;
        }
        this.d = av2;
    }

    @Override
    public boolean A() {
        return av.a.a(this);
    }

    @Override
    public /* synthetic */ ax F() {
        return this.n();
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        j.b(o2, "visitor");
        return o2.a(this, d2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.a a() {
        m m2 = super.b();
        if (m2 != null) {
            return (kotlin.reflect.jvm.internal.impl.a.a)m2;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
    }

    @Override
    public av a(kotlin.reflect.jvm.internal.impl.a.a a2, f f2, int n2) {
        j.b(a2, "newOwner");
        j.b(f2, "newName");
        h h2 = this.x();
        j.a((Object)h2, "annotations");
        w w2 = this.r();
        j.a((Object)w2, "type");
        boolean bl2 = this.l();
        boolean bl3 = this.o();
        boolean bl4 = this.q();
        w w3 = this.m();
        an an2 = an.a;
        j.a((Object)an2, "SourceElement.NO_SOURCE");
        return new ah(a2, null, n2, h2, f2, w2, bl2, bl3, bl4, w3, an2);
    }

    public av a(au au2) {
        j.b(au2, "substitutor");
        if (au2.a()) {
            return this;
        }
        throw (Throwable)new UnsupportedOperationException();
    }

    @Override
    public /* synthetic */ m b() {
        return this.a();
    }

    @Override
    public int c() {
        return this.e;
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a h() {
        return this.n();
    }

    @Override
    public Collection<av> k() {
        Collection collection = this.a().k();
        j.a(collection, "containingDeclaration.overriddenDescriptors");
        Object object = collection;
        collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.a a2 = (kotlin.reflect.jvm.internal.impl.a.a)object.next();
            j.a((Object)a2, "it");
            collection.add(a2.i().get(this.c()));
        }
        return (List)collection;
    }

    @Override
    public boolean l() {
        if (this.f) {
            Object object = this.a();
            if (object != null) {
                object = ((b)object).n();
                j.a(object, "(containingDeclaration a\u2026bleMemberDescriptor).kind");
                if (((b.a)((Object)object)).a()) {
                    return true;
                }
            } else {
                throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            }
        }
        return false;
    }

    @Override
    public w m() {
        return this.i;
    }

    @Override
    public /* synthetic */ m m_() {
        return this.n();
    }

    @Override
    public av n() {
        if (this.d == this) {
            return this;
        }
        return this.d.n();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.n();
    }

    @Override
    public boolean o() {
        return this.g;
    }

    @Override
    public ba p() {
        return az.f;
    }

    @Override
    public boolean q() {
        return this.h;
    }

    @Override
    public boolean s() {
        return false;
    }

    public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.b.f t() {
        return (kotlin.reflect.jvm.internal.impl.h.b.f)((Object)this.u());
    }

    public Void u() {
        return null;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

