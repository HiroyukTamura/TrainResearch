/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.b.d;
import kotlin.reflect.jvm.internal.impl.c.a.b.e;
import kotlin.reflect.jvm.internal.impl.c.a.c;
import kotlin.reflect.jvm.internal.impl.c.a.s;
import kotlin.reflect.jvm.internal.impl.c.b.j;
import kotlin.reflect.jvm.internal.impl.c.b.r;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.d;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class l
implements kotlin.reflect.jvm.internal.impl.h.d {
    public static final a a = new a(null);

    private final boolean b(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.e e2) {
        if (a2 instanceof b && object instanceof t) {
            if (KotlinBuiltIns.isBuiltIn((kotlin.reflect.jvm.internal.impl.a.m)object)) {
                return false;
            }
            Object object2 = kotlin.reflect.jvm.internal.impl.c.a.d.a;
            t t2 = (t)object;
            object = t2.h_();
            kotlin.e.b.j.a(object, "subDescriptor.name");
            if (!((kotlin.reflect.jvm.internal.impl.c.a.d)object2).a((f)object)) {
                object = c.a;
                object2 = t2.h_();
                kotlin.e.b.j.a(object2, "subDescriptor.name");
                if (!((c)object).a((f)object2)) {
                    return false;
                }
            }
            object2 = s.c((b)a2);
            boolean bl2 = t2.z();
            boolean bl3 = a2 instanceof t;
            object = !bl3 ? null : a2;
            boolean bl4 = (object = (t)object) == null || bl2 != object.z();
            if (bl4 && (object2 == null || !t2.z())) {
                return true;
            }
            if (e2 instanceof d) {
                if (t2.t() != null) {
                    return false;
                }
                if (object2 != null) {
                    if (s.a(e2, (kotlin.reflect.jvm.internal.impl.a.a)object2)) {
                        return false;
                    }
                    if (object2 instanceof t && bl3 && kotlin.reflect.jvm.internal.impl.c.a.d.a((t)object2) != null) {
                        object = r.a(t2, false, false, 2, null);
                        a2 = ((t)a2).s();
                        kotlin.e.b.j.a((Object)a2, "superDescriptor.original");
                        if (kotlin.e.b.j.a(object, (Object)r.a((t)a2, false, false, 2, null))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public d.a a() {
        return d.a.a;
    }

    @Override
    public d.b a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.a.a a3, kotlin.reflect.jvm.internal.impl.a.e e2) {
        kotlin.e.b.j.b(a2, "superDescriptor");
        kotlin.e.b.j.b(a3, "subDescriptor");
        if (this.b(a2, a3, e2)) {
            return d.b.c;
        }
        if (a.a(a2, a3)) {
            return d.b.c;
        }
        return d.b.d;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final j a(t a2, av av2) {
            if (!r.a(a2) && !this.a((t)a2)) {
                a2 = av2.r();
                kotlin.e.b.j.a((Object)a2, "valueParameterDescriptor.type");
            } else {
                a2 = av2.r();
                kotlin.e.b.j.a((Object)a2, "valueParameterDescriptor.type");
                a2 = kotlin.reflect.jvm.internal.impl.j.c.a.b((w)a2);
            }
            return r.a((w)a2);
        }

        private final boolean a(t object) {
            kotlin.reflect.jvm.internal.impl.a.m m2;
            if (object.i().size() != 1) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.a.m m3 = m2 = object.b();
            if (!(m2 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
                m3 = null;
            }
            if ((m2 = (kotlin.reflect.jvm.internal.impl.a.e)m3) != null) {
                object = object.i();
                kotlin.e.b.j.a(object, "f.valueParameters");
                object = m.j(object);
                kotlin.e.b.j.a(object, "f.valueParameters.single()");
                m3 = ((av)object).r().g().d();
                object = m3;
                if (!(m3 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
                    object = null;
                }
                if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object) != null) {
                    return KotlinBuiltIns.isPrimitiveClass((kotlin.reflect.jvm.internal.impl.a.e)m2) && kotlin.e.b.j.a((Object)kotlin.reflect.jvm.internal.impl.h.c.a.b(m2), (Object)kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.m)object));
                }
            }
            return false;
        }

        public final boolean a(kotlin.reflect.jvm.internal.impl.a.a a2, kotlin.reflect.jvm.internal.impl.a.a a3) {
            kotlin.e.b.j.b(a2, "superDescriptor");
            kotlin.e.b.j.b(a3, "subDescriptor");
            if (a3 instanceof e) {
                if (!(a2 instanceof t)) {
                    return false;
                }
                Object object = (e)a3;
                int n2 = ((kotlin.reflect.jvm.internal.impl.a.c.o)object).i().size();
                n2 = n2 == (a2 = (t)a2).i().size() ? 1 : 0;
                if (y.a && n2 == 0) {
                    throw (Throwable)((Object)new AssertionError((Object)"External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size"));
                }
                object = ((ac)object).o();
                kotlin.e.b.j.a(object, "subDescriptor.original");
                object = object.i();
                kotlin.e.b.j.a(object, "subDescriptor.original.valueParameters");
                object = (Iterable)object;
                Object object2 = a2.s();
                kotlin.e.b.j.a(object2, "superDescriptor.original");
                object2 = object2.i();
                kotlin.e.b.j.a(object2, "superDescriptor.original.valueParameters");
                for (o o2 : m.a(object, (Iterable)object2)) {
                    object2 = (av)o2.c();
                    av object3 = (av)o2.d();
                    a a4 = this;
                    t t2 = (t)a3;
                    kotlin.e.b.j.a(object2, "subParameter");
                    boolean bl2 = a4.a(t2, (av)object2) instanceof j.c;
                    kotlin.e.b.j.a((Object)object3, "superParameter");
                    if (bl2 == a4.a((t)a2, object3) instanceof j.c) continue;
                    return true;
                }
            }
            return false;
        }
    }

}

