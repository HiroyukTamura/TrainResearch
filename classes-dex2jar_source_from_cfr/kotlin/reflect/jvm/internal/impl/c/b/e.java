/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.b;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.c.b.d;
import kotlin.reflect.jvm.internal.impl.c.b.i;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.c.b.p;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.r;

public final class e {
    public static final a b = new a(null);
    private static final Set<a.a> c = al.a(a.a.b);
    private static final Set<a.a> d = al.a(new a.a[]{a.a.c, a.a.f});
    private static final g e = new g(1, 1, 2);
    public j a;

    private final boolean b() {
        j j2 = this.a;
        if (j2 == null) {
            kotlin.e.b.j.b("components");
        }
        return j2.d().a();
    }

    private final r<g> c(n n2) {
        if (!this.b() && !n2.d().e().a()) {
            return new r<kotlin.reflect.jvm.internal.impl.d.b.a>(n2.d().e(), g.a, n2.a(), n2.b());
        }
        return null;
    }

    private final boolean d(n n2) {
        j j2 = this.a;
        if (j2 == null) {
            kotlin.e.b.j.b("components");
        }
        return j2.d().b() && (n2.d().c() || kotlin.e.b.j.a((Object)n2.d().e(), (Object)e));
    }

    public final kotlin.reflect.jvm.internal.impl.a.e a(n n2) {
        kotlin.e.b.j.b(n2, "kotlinClass");
        f f2 = this.b(n2);
        if (f2 != null) {
            j j2 = this.a;
            if (j2 == null) {
                kotlin.e.b.j.b("components");
            }
            return j2.a().a(n2.b(), f2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final kotlin.reflect.jvm.internal.impl.h.e.h a(ab ab2, n object) {
        Object object2;
        Object object3;
        block5 : {
            kotlin.e.b.j.b(ab2, "descriptor");
            kotlin.e.b.j.b(object, "kotlinClass");
            object3 = this.a((n)object, d);
            if (object3 == null) return null;
            object2 = object.d().h();
            if (object2 == null) return null;
            try {
                try {
                    object3 = kotlin.reflect.jvm.internal.impl.d.c.a.j.b((String[])object3, (String[])object2);
                    break block5;
                }
                catch (kotlin.reflect.jvm.internal.impl.f.k k2) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Could not read data from ");
                    ((StringBuilder)object2).append(object.a());
                    throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString(), k2);
                }
            }
            catch (Throwable throwable2) {}
            if (this.b()) throw throwable2;
            if (object.d().e().a()) throw throwable2;
            return null;
        }
        if (object3 == null) {
            return null;
        }
        object2 = (kotlin.reflect.jvm.internal.impl.d.c.a.h)((o)object3).c();
        object3 = (a.s)((o)object3).d();
        object2 = (c)object2;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f f2 = new i((n)object, (a.s)object3, (c)object2, this.c((n)object), this.d((n)object));
        object = object.d().e();
        f2 = f2;
        j j2 = this.a;
        if (j2 != null) return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.i(ab2, (a.s)object3, (c)object2, (kotlin.reflect.jvm.internal.impl.d.b.a)object, f2, j2, b.a);
        kotlin.e.b.j.b("components");
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.i(ab2, (a.s)object3, (c)object2, (kotlin.reflect.jvm.internal.impl.d.b.a)object, f2, j2, b.a);
    }

    public final j a() {
        j j2 = this.a;
        if (j2 == null) {
            kotlin.e.b.j.b("components");
        }
        return j2;
    }

    public final void a(d d2) {
        kotlin.e.b.j.b(d2, "components");
        this.a = d2.a();
    }

    public final String[] a(n arrstring, Set<? extends a.a> set) {
        String[] arrstring2;
        kotlin.e.b.j.b(arrstring, "kotlinClass");
        kotlin.e.b.j.b(set, "expectedKinds");
        kotlin.reflect.jvm.internal.impl.c.b.a.a a2 = arrstring.d();
        arrstring = a2.f();
        if (arrstring == null) {
            arrstring = a2.g();
        }
        String[] arrstring3 = arrstring2 = null;
        if (arrstring != null) {
            arrstring3 = arrstring2;
            if (set.contains((Object)a2.d())) {
                arrstring3 = arrstring;
            }
        }
        return arrstring3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final f b(n n2) {
        Object object2;
        Object object;
        block4 : {
            kotlin.e.b.j.b(n2, "kotlinClass");
            object2 = this.a(n2, c);
            if (object2 == null) return null;
            object = n2.d().h();
            if (object == null) return null;
            try {
                try {
                    object2 = kotlin.reflect.jvm.internal.impl.d.c.a.j.a((String[])object2, (String[])object);
                    break block4;
                }
                catch (kotlin.reflect.jvm.internal.impl.f.k k2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Could not read data from ");
                    ((StringBuilder)object).append(n2.a());
                    throw (Throwable)new IllegalStateException(((StringBuilder)object).toString(), k2);
                }
            }
            catch (Throwable throwable2) {}
            if (this.b()) throw throwable2;
            if (n2.d().e().a()) throw throwable2;
            return null;
        }
        if (object2 == null) return null;
        object = (kotlin.reflect.jvm.internal.impl.d.c.a.h)((o)object2).c();
        object2 = (a.c)((o)object2).d();
        p p2 = new p(n2, this.c(n2), this.d(n2));
        return new f((c)object, (a.c)object2, n2.d().e(), p2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

