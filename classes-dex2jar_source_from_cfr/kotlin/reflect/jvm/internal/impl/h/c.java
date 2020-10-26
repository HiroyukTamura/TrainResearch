/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.a.ax;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.q;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.e.h;
import kotlin.reflect.jvm.internal.impl.h.c.a;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.p;

public class c {
    public static final f a;
    public static final f b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    static final /* synthetic */ boolean j;
    private static final b k;
    private static final b l;

    static {
        j = c.class.desiredAssertionStatus() ^ true;
        a = f.a("values");
        b = f.a("valueOf");
        c = new b("kotlin.jvm.JvmName");
        k = new b("kotlin.jvm.Volatile");
        l = new b("kotlin.jvm.Synchronized");
        d = new b("kotlin.coroutines");
        e = d.a(f.a("experimental"));
        f = e.a(f.a("intrinsics"));
        g = e.a(f.a("Continuation"));
        h = d.a(f.a("Continuation"));
        i = new b("kotlin.SuccessOrFailure");
    }

    private c() {
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.a.a> Set<D> a(D d2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c.a(d2.h(), linkedHashSet);
        return linkedHashSet;
    }

    public static al a(m m2) {
        if (m2 instanceof e) {
            return ((e)m2).D();
        }
        return null;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.a.b> D a(D object) {
        while (object.n() == b.a.b) {
            Collection<? extends kotlin.reflect.jvm.internal.impl.a.b> collection = object.k();
            if (!collection.isEmpty()) {
                object = collection.iterator().next();
                continue;
            }
            collection = new StringBuilder();
            ((StringBuilder)((Object)collection)).append("Fake override should have at least one overridden descriptor: ");
            ((StringBuilder)((Object)collection)).append(object);
            throw new IllegalStateException(((StringBuilder)((Object)collection)).toString());
        }
        return object;
    }

    public static e a(e object) {
        object = object.e().k_().iterator();
        while (object.hasNext()) {
            e e2 = c.b((kotlin.reflect.jvm.internal.impl.j.w)object.next());
            if (e2.l() == kotlin.reflect.jvm.internal.impl.a.f.b) continue;
            return e2;
        }
        return null;
    }

    public static e a(kotlin.reflect.jvm.internal.impl.j.an an2) {
        Object object = an2.d();
        if (!j && !(object instanceof e)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Classifier descriptor of a type should be of type ClassDescriptor: ");
            ((StringBuilder)object).append(an2);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return (e)object;
    }

    public static <D extends m> D a(m m2, Class<D> class_) {
        return c.a(m2, class_, true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static <D extends m> D a(m var0, Class<D> var1_1, boolean var2_2) {
        if (var0 == null) {
            return null;
        }
        var3_3 = var0;
        if (!var2_2) ** GOTO lbl7
        do {
            var3_3 = var0.b();
lbl7: // 2 sources:
            if (var3_3 == null) return null;
            var0 = var3_3;
        } while (!var1_1.isInstance(var3_3));
        return (D)var3_3;
    }

    public static <D extends q> D a(D d2) {
        Object object = d2;
        if (d2 instanceof kotlin.reflect.jvm.internal.impl.a.b) {
            object = c.a((kotlin.reflect.jvm.internal.impl.a.b)d2);
        }
        return object;
    }

    public static y a(kotlin.reflect.jvm.internal.impl.j.w a2) {
        if ((a2 = a2.g().d()) == null) {
            return null;
        }
        return c.h((m)a2);
    }

    private static <D extends kotlin.reflect.jvm.internal.impl.a.a> void a(D object, Set<D> set) {
        if (set.contains(object)) {
            return;
        }
        object = object.h().k().iterator();
        while (object.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.a a2 = ((kotlin.reflect.jvm.internal.impl.a.a)object.next()).h();
            c.a(a2, set);
            set.add(a2);
        }
    }

    public static boolean a(ax object, kotlin.reflect.jvm.internal.impl.j.w w2) {
        boolean bl2;
        block5 : {
            block6 : {
                boolean bl3;
                boolean bl4 = object.s();
                bl2 = bl3 = false;
                if (bl4) break block5;
                if (kotlin.reflect.jvm.internal.impl.j.y.a(w2)) {
                    return false;
                }
                if (av.g(w2)) {
                    return true;
                }
                object = a.d((m)object);
                if (KotlinBuiltIns.isPrimitiveType(w2) || kotlin.reflect.jvm.internal.impl.j.a.c.a.b(((KotlinBuiltIns)object).getStringType(), w2) || kotlin.reflect.jvm.internal.impl.j.a.c.a.b(((KotlinBuiltIns)object).getNumber().i_(), w2) || kotlin.reflect.jvm.internal.impl.j.a.c.a.b(((KotlinBuiltIns)object).getAnyType(), w2)) break block6;
                bl2 = bl3;
                if (!UnsignedTypes.INSTANCE.isUnsignedType(w2)) break block5;
            }
            bl2 = true;
        }
        return bl2;
    }

    public static boolean a(e object, e e2) {
        object = object.e().k_().iterator();
        while (object.hasNext()) {
            if (!c.b((kotlin.reflect.jvm.internal.impl.j.w)object.next(), (m)e2.E())) continue;
            return true;
        }
        return false;
    }

    private static boolean a(m m2, kotlin.reflect.jvm.internal.impl.a.f f2) {
        return m2 instanceof e && ((e)m2).l() == f2;
    }

    public static boolean a(m m2, m m3) {
        return c.g(m2).equals(c.g(m3));
    }

    public static boolean a(kotlin.reflect.jvm.internal.impl.j.w object, m m2) {
        if (c.b((kotlin.reflect.jvm.internal.impl.j.w)object, m2)) {
            return true;
        }
        object = ((kotlin.reflect.jvm.internal.impl.j.w)object).g().k_().iterator();
        while (object.hasNext()) {
            if (!c.a((kotlin.reflect.jvm.internal.impl.j.w)object.next(), m2)) continue;
            return true;
        }
        return false;
    }

    public static kotlin.reflect.jvm.internal.impl.a.b b(kotlin.reflect.jvm.internal.impl.a.b b2) {
        kotlin.reflect.jvm.internal.impl.a.b b3 = b2;
        if (b2 instanceof ah) {
            b3 = ((ah)b2).q();
        }
        return b3;
    }

    public static ba b(e e2) {
        kotlin.reflect.jvm.internal.impl.a.f f2 = e2.l();
        if (f2 != kotlin.reflect.jvm.internal.impl.a.f.c && !f2.a() && !c.j(e2)) {
            if (c.k(e2)) {
                return az.k;
            }
            if (!j && f2 != kotlin.reflect.jvm.internal.impl.a.f.a && f2 != kotlin.reflect.jvm.internal.impl.a.f.b && f2 != kotlin.reflect.jvm.internal.impl.a.f.e) {
                throw new AssertionError();
            }
            return az.e;
        }
        return az.a;
    }

    public static e b(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return c.a(w2.g());
    }

    public static boolean b(e e2, e e3) {
        return c.a(e2.i_(), (m)e3.E());
    }

    public static boolean b(m m2) {
        while (m2 != null) {
            if (!c.k(m2) && !c.c(m2)) {
                m2 = m2.b();
                continue;
            }
            return true;
        }
        return false;
    }

    private static boolean b(kotlin.reflect.jvm.internal.impl.j.w a2, m m2) {
        return (a2 = ((kotlin.reflect.jvm.internal.impl.j.w)a2).g().d()) != null && (a2 = a2.m_()) instanceof kotlin.reflect.jvm.internal.impl.a.h && m2 instanceof kotlin.reflect.jvm.internal.impl.a.h && ((kotlin.reflect.jvm.internal.impl.a.h)m2).e().equals(((kotlin.reflect.jvm.internal.impl.a.h)a2).e());
    }

    public static boolean c(m m2) {
        return m2 instanceof q && ((q)m2).p() == az.f;
    }

    public static kotlin.reflect.jvm.internal.impl.e.c d(m m2) {
        b b2 = c.s(m2);
        if (b2 != null) {
            return b2.b();
        }
        return c.t(m2);
    }

    public static b e(m m2) {
        b b2 = c.s(m2);
        if (b2 != null) {
            return b2;
        }
        return c.t(m2).c();
    }

    public static boolean f(m m2) {
        return m2 != null && m2.b() instanceof ab;
    }

    public static y g(m m2) {
        Object object = c.h(m2);
        if (!j) {
            if (object != null) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Descriptor without a containing module: ");
            ((StringBuilder)object).append(m2);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return object;
    }

    public static y h(m m2) {
        while (m2 != null) {
            if (m2 instanceof y) {
                return (y)m2;
            }
            if (m2 instanceof ae) {
                return ((ae)m2).e();
            }
            m2 = m2.b();
        }
        return null;
    }

    public static boolean i(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.f) && ((e)m2).q();
    }

    public static boolean j(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.a) && ((e)m2).m() == w.b;
    }

    public static boolean k(m m2) {
        return c.p(m2) && m2.h_().equals(h.a);
    }

    public static boolean l(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.d);
    }

    public static boolean m(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.c);
    }

    public static boolean n(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.e);
    }

    public static boolean o(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.b);
    }

    public static boolean p(m m2) {
        return c.a(m2, kotlin.reflect.jvm.internal.impl.a.f.a);
    }

    public static boolean q(m m2) {
        return c.p(m2) || c.m(m2);
        {
        }
    }

    public static ao r(m m2) {
        m m3 = m2;
        if (m2 instanceof ak) {
            m3 = ((ak)m2).q();
        }
        if (m3 instanceof kotlin.reflect.jvm.internal.impl.a.p) {
            return ((kotlin.reflect.jvm.internal.impl.a.p)m3).y().a();
        }
        return ao.a;
    }

    private static b s(m m2) {
        if (!(m2 instanceof y) && !p.a(m2)) {
            if (m2 instanceof ae) {
                return ((ae)m2).a();
            }
            if (m2 instanceof ab) {
                return ((ab)m2).f();
            }
            return null;
        }
        return b.a;
    }

    private static kotlin.reflect.jvm.internal.impl.e.c t(m m2) {
        Object object = m2.b();
        if (!j && object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Not package/module descriptor doesn't have containing declaration: ");
            ((StringBuilder)object).append(m2);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return c.d((m)object).a(m2.h_());
    }
}

