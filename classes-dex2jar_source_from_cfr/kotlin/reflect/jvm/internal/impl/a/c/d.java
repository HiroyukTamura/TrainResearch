/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ae;
import kotlin.reflect.jvm.internal.impl.a.c.af;
import kotlin.reflect.jvm.internal.impl.a.c.k;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.l;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.o;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.y;
import kotlin.t;

public abstract class d
extends k
implements ar {
    private List<? extends as> a;
    private final b b;
    private final ba c;

    public d(m m2, kotlin.reflect.jvm.internal.impl.a.a.h h2, f f2, an an2, ba ba2) {
        j.b(m2, "containingDeclaration");
        j.b(h2, "annotations");
        j.b(f2, "name");
        j.b(an2, "sourceElement");
        j.b(ba2, "visibilityImpl");
        super(m2, h2, f2, an2);
        this.c = ba2;
        this.b = new kotlin.reflect.jvm.internal.impl.j.an(){

            public ar a() {
                return this;
            }

            @Override
            public List<as> b() {
                return this.o();
            }

            @Override
            public /* synthetic */ h d() {
                return this.a();
            }

            @Override
            public KotlinBuiltIns e() {
                return kotlin.reflect.jvm.internal.impl.h.c.a.d(this.a());
            }

            @Override
            public boolean f() {
                return true;
            }

            @Override
            public Collection<kotlin.reflect.jvm.internal.impl.j.w> k_() {
                Collection<kotlin.reflect.jvm.internal.impl.j.w> collection = this.a().a().g().k_();
                j.a(collection, "declarationDescriptor.un\u2026pe.constructor.supertypes");
                return collection;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[typealias ");
                stringBuilder.append(this.a().h_().a());
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
        };
    }

    @Override
    public <R, D> R a(o<R, D> o2, D d2) {
        j.b(o2, "visitor");
        return o2.a(this, d2);
    }

    public final void a(List<? extends as> list) {
        j.b(list, "declaredTypeParameters");
        this.a = list;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.b;
    }

    @Override
    public /* synthetic */ h f() {
        return this.l();
    }

    protected abstract i j();

    public final Collection<ae> k() {
        Object object = this.g();
        if (object != null) {
            object = object.k();
            j.a(object, "classDescriptor.constructors");
            Object object2 = (Iterable)object;
            object = new ArrayList<E>();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                l l2 = (kotlin.reflect.jvm.internal.impl.a.d)object2.next();
                af.a a2 = af.b;
                i i2 = this.j();
                ar ar2 = this;
                j.a((Object)l2, "it");
                if ((l2 = a2.a(i2, ar2, (kotlin.reflect.jvm.internal.impl.a.d)l2)) == null) continue;
                object.add(l2);
            }
            return (List)object;
        }
        return kotlin.a.m.a();
    }

    public ar l() {
        p p2 = super.n_();
        if (p2 != null) {
            return (ar)p2;
        }
        throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }

    @Override
    public w m() {
        return w.a;
    }

    @Override
    public /* synthetic */ m m_() {
        return this.l();
    }

    @Override
    public /* synthetic */ p n_() {
        return this.l();
    }

    protected abstract List<as> o();

    @Override
    public ba p() {
        return this.c;
    }

    protected final ad q() {
        h h2 = this;
        Object object = this.g();
        if (object == null || (object = object.g()) == null) {
            object = h.c.a;
        }
        object = av.a(h2, (kotlin.reflect.jvm.internal.impl.h.e.h)object);
        j.a(object, "TypeUtils.makeUnsubstitu\u2026ope ?: MemberScope.Empty)");
        return object;
    }

    @Override
    public boolean r() {
        return av.a((kotlin.reflect.jvm.internal.impl.j.w)this.a(), new kotlin.e.a.b<az, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a((az)object);
            }

            @Override
            public final boolean a(az a2) {
                boolean bl2;
                j.a((Object)a2, "type");
                boolean bl3 = y.a(a2);
                boolean bl4 = bl2 = false;
                if (!bl3) {
                    d d2 = this;
                    boolean bl5 = (a2 = a2.g().d()) instanceof as && j.a((Object)((as)a2).b(), (Object)this) ^ true;
                    bl4 = bl2;
                    if (bl5) {
                        bl4 = true;
                    }
                }
                return bl4;
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("typealias ");
        stringBuilder.append(this.h_().a());
        return stringBuilder.toString();
    }

    @Override
    public boolean u() {
        return false;
    }

    @Override
    public boolean v() {
        return false;
    }

    @Override
    public boolean w() {
        return false;
    }

    @Override
    public List<as> z() {
        List<as> list = this.a;
        if (list == null) {
            j.b("declaredTypeParametersImpl");
        }
        return list;
    }

}

