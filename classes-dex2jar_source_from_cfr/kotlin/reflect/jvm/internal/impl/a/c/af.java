/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.List;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ap;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ae;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.g;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.y;

public final class af
extends o
implements ae {
    static final /* synthetic */ kotlin.reflect.l[] a;
    public static final a b;
    private final g d;
    private d e;
    private final kotlin.reflect.jvm.internal.impl.i.i f;
    private final ar g;

    static {
        a = new kotlin.reflect.l[]{v.a(new kotlin.e.b.t(v.a(af.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
        b = new a(null);
    }

    private af(kotlin.reflect.jvm.internal.impl.i.i i2, ar ar2, final d d2, ae ae2, h h2, b.a a2, an an2) {
        super(ar2, ae2, h2, f.c("<init>"), a2, an2);
        this.f = i2;
        this.g = ar2;
        this.g(this.J().v());
        this.d = this.f.b((kotlin.e.a.a)new kotlin.e.a.a<af>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final af b() {
                Object object = this.I();
                ap<i> ap2 = this.J();
                kotlin.reflect.jvm.internal.impl.a.a a2 = d2;
                ae ae2 = this;
                h h2 = d2.x();
                b.a a3 = d2.n();
                j.a((Object)a3, "underlyingConstructorDescriptor.kind");
                an an2 = this.J().y();
                j.a((Object)an2, "typeAliasDescriptor.source");
                ap2 = new af((kotlin.reflect.jvm.internal.impl.i.i)object, (ar)ap2, (d)a2, ae2, h2, a3, an2, null);
                object = af.b.a(this.J());
                if (object != null) {
                    a2 = d2.e();
                    object = a2 != null ? a2.a((au)object) : null;
                    ((o)ap2).a(null, (al)object, this.J().z(), this.i(), this.g(), w.a, this.J().p());
                    return ap2;
                }
                return null;
            }
        });
        this.e = d2;
    }

    public /* synthetic */ af(kotlin.reflect.jvm.internal.impl.i.i i2, ar ar2, d d2, ae ae2, h h2, b.a a2, an an2, kotlin.e.b.g g2) {
        this(i2, ar2, d2, ae2, h2, a2, an2);
    }

    private void a(d d2) {
        this.e = d2;
    }

    public ar F() {
        return this.J();
    }

    public ae G() {
        t t2 = super.s();
        if (t2 != null) {
            return (ae)t2;
        }
        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    public final kotlin.reflect.jvm.internal.impl.i.i I() {
        return this.f;
    }

    public ar J() {
        return this.g;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b a(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    public ae a(au object) {
        j.b(object, "substitutor");
        object = super.c((au)object);
        if (object != null) {
            object = (af)object;
            Object object2 = au.a(((af)object).g());
            d d2 = this.o().o();
            j.a(object2, "underlyingConstructorSubstitutor");
            object2 = d2.a((au)object2);
            if (object2 != null) {
                af.super.a((d)object2);
                return (ae)object;
            }
            return null;
        }
        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
    }

    @Override
    public /* synthetic */ o a(m m2, t t2, b.a a2, f f2, h h2, an an2) {
        return this.b(m2, t2, a2, f2, h2, an2);
    }

    public ae b(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        j.b(m2, "newOwner");
        j.b((Object)w2, "modality");
        j.b(ba2, "visibility");
        j.b((Object)a2, "kind");
        m2 = this.E().a(m2).a(w2).a(ba2).a(a2).a(bl2).f();
        if (m2 != null) {
            return (ae)m2;
        }
        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    protected af b(m object, t object2, b.a a2, f f2, h h2, an an2) {
        j.b(object, "newOwner");
        j.b((Object)a2, "kind");
        j.b(h2, "annotations");
        j.b(an2, "source");
        object2 = b.a.a;
        boolean bl2 = false;
        boolean bl3 = a2 == object2 || a2 == b.a.d;
        if (y.a && !bl3) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Creating a type alias constructor that is not a declaration: \ncopy from: ");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append("\nnewOwner: ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append("\nkind: ");
            ((StringBuilder)object2).append((Object)a2);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object2).toString()));
        }
        bl3 = bl2;
        if (f2 == null) {
            bl3 = true;
        }
        if (y.a && !bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Renaming type alias constructor: ");
            ((StringBuilder)object).append(this);
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        return new af(this.f, this.J(), this.o(), this, h2, b.a.a, an2);
    }

    @Override
    public /* synthetic */ l b(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ m b() {
        return this.F();
    }

    @Override
    public /* synthetic */ t c(m m2, w w2, ba ba2, b.a a2, boolean bl2) {
        return this.b(m2, w2, ba2, a2, bl2);
    }

    @Override
    public /* synthetic */ t c(au au2) {
        return this.a(au2);
    }

    @Override
    public /* synthetic */ n d(au au2) {
        return this.a(au2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.w g() {
        kotlin.reflect.jvm.internal.impl.j.w w2 = super.g();
        if (w2 == null) {
            j.a();
        }
        return w2;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a h() {
        return this.G();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.b l() {
        return this.G();
    }

    @Override
    public /* synthetic */ m m_() {
        return this.G();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.G();
    }

    @Override
    public d o() {
        return this.e;
    }

    @Override
    public /* synthetic */ i q() {
        return this.F();
    }

    @Override
    public boolean r() {
        return this.o().r();
    }

    @Override
    public /* synthetic */ t s() {
        return this.G();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        private final au a(ar ar2) {
            if (ar2.g() == null) {
                return null;
            }
            return au.a(ar2.c());
        }

        public final ae a(kotlin.reflect.jvm.internal.impl.i.i object, ar ar2, d a2) {
            kotlin.reflect.jvm.internal.impl.a.a.a a3;
            j.b(object, "storageManager");
            j.b(ar2, "typeAliasDescriptor");
            j.b(a2, "constructor");
            au au2 = this.a(ar2);
            Object var4_5 = null;
            if (au2 != null && (a3 = a2.a(au2)) != null) {
                Object object2 = a2.x();
                Object object3 = a2.n();
                j.a(object3, "constructor.kind");
                an an2 = ar2.y();
                j.a((Object)an2, "typeAliasDescriptor.source");
                object2 = new af((kotlin.reflect.jvm.internal.impl.i.i)object, ar2, (d)a3, null, (h)object2, (b.a)((Object)object3), an2, null);
                object3 = o.a((t)object2, a2.i(), au2);
                if (object3 != null) {
                    object = kotlin.reflect.jvm.internal.impl.j.t.c(a3.g().l());
                    a3 = ar2.i_();
                    j.a((Object)a3, "typeAliasDescriptor.defaultType");
                    a3 = ag.a((ad)object, (ad)a3);
                    a2 = a2.e();
                    object = var4_5;
                    if (a2 != null) {
                        j.a((Object)a2, "it");
                        object = au2.a(a2.r(), kotlin.reflect.jvm.internal.impl.j.ba.a);
                    }
                    ((o)object2).a((kotlin.reflect.jvm.internal.impl.j.w)object, null, ar2.z(), (List<av>)object3, (kotlin.reflect.jvm.internal.impl.j.w)a3, w.a, ar2.p());
                    return (ae)object2;
                }
            }
            return null;
        }
    }

}

