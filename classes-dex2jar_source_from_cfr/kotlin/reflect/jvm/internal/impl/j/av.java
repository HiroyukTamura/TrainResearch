/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.j.a.k;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ah;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.g;
import kotlin.reflect.jvm.internal.impl.j.i;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.v;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public class av {
    public static final ad a;
    public static final ad b;
    public static final ad c;
    public static final ad d;
    static final /* synthetic */ boolean e;

    static {
        e = av.class.desiredAssertionStatus() ^ true;
        a = p.d("DONT_CARE");
        b = p.c("Cannot be inferred");
        c = new a("NO_EXPECTED_TYPE");
        d = new a("UNIT_EXPECTED_TYPE");
    }

    public static List<ap> a(List<as> object) {
        ArrayList<ar> arrayList = new ArrayList<ar>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(new ar(((as)object.next()).i_()));
        }
        return m.k(arrayList);
    }

    public static ad a(kotlin.reflect.jvm.internal.impl.a.h object, kotlin.reflect.jvm.internal.impl.h.e.h object2) {
        if (p.a((kotlin.reflect.jvm.internal.impl.a.m)object)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unsubstituted type for ");
            ((StringBuilder)object2).append(object);
            return p.c(((StringBuilder)object2).toString());
        }
        object = object.e();
        List<ap> list = av.a(object.b());
        return x.a(h.a.a(), (an)object, list, false, (kotlin.reflect.jvm.internal.impl.h.e.h)object2);
    }

    public static ap a(as as2) {
        return new ah(as2);
    }

    public static w a(w w2, w w3, au au2) {
        if ((w3 = au2.b(w3, ba.a)) != null) {
            return av.b(w3, w2.c());
        }
        return null;
    }

    public static w a(w w2, boolean bl2) {
        return w2.l().b(bl2);
    }

    public static boolean a(w w2) {
        return w2 == c || w2 == d;
        {
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static boolean a(w iterator, b<az, Boolean> b2) {
        void var3_6;
        if (iterator == null) {
            return false;
        }
        az az2 = ((w)((Object)iterator)).l();
        if (b2.a(az2).booleanValue()) {
            return true;
        }
        if (az2 instanceof q) {
            q object2 = (q)az2;
        } else {
            Object var3_5 = null;
        }
        if (var3_6 != null && (av.a((w)var3_6.f(), b2) || av.a((w)var3_6.h(), b2))) {
            return true;
        }
        if (az2 instanceof g && av.a((w)((g)az2).e(), b2)) {
            return true;
        }
        an an2 = ((w)((Object)iterator)).g();
        if (an2 instanceof v) {
            iterator = ((v)an2).k_().iterator();
            while (iterator.hasNext()) {
                if (!av.a((w)iterator.next(), b2)) continue;
                return true;
            }
            return false;
        }
        for (ap ap2 : ((w)((Object)iterator)).a()) {
            if (ap2.a()) continue;
            w w2 = ap2.c();
            boolean bl2 = av.a(w2, b2);
            if (!bl2) continue;
            return true;
        }
        return false;
        catch (Throwable throwable) {
            throw throwable;
        }
    }

    public static w b(w w2, boolean bl2) {
        w w3 = w2;
        if (bl2) {
            w3 = av.c(w2);
        }
        return w3;
    }

    public static boolean b(w w2) {
        return w2 != null && w2.g() == a.g();
    }

    public static w c(w w2) {
        return av.a(w2, true);
    }

    public static w d(w w2) {
        return av.a(w2, false);
    }

    public static List<w> e(w w2) {
        au au2 = au.a(w2);
        Object object = w2.g().k_();
        ArrayList<w> arrayList = new ArrayList<w>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            w w3 = av.a(w2, (w)object.next(), au2);
            if (w3 == null) continue;
            arrayList.add(w3);
        }
        return arrayList;
    }

    public static boolean f(w iterator) {
        if (((w)((Object)iterator)).c()) {
            return true;
        }
        if (t.a((w)((Object)iterator)) && av.f(t.b((w)((Object)iterator)).h())) {
            return true;
        }
        if (av.j((w)((Object)iterator))) {
            return av.h((w)((Object)iterator));
        }
        if ((iterator = ((w)((Object)iterator)).g()) instanceof v) {
            iterator = iterator.k_().iterator();
            while (iterator.hasNext()) {
                if (!av.f(iterator.next())) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean g(w w2) {
        if (w2.c()) {
            return true;
        }
        return t.a(w2) && av.g(t.b(w2).h());
    }

    public static boolean h(w object) {
        if (((w)object).g().d() instanceof e) {
            return false;
        }
        object = av.e((w)object).iterator();
        while (object.hasNext()) {
            if (!av.f((w)object.next())) continue;
            return true;
        }
        return false;
    }

    public static e i(w a2) {
        if ((a2 = a2.g().d()) instanceof e) {
            return (e)a2;
        }
        return null;
    }

    public static boolean j(w w2) {
        return av.k(w2) != null || w2.g() instanceof k;
        {
        }
    }

    public static as k(w w2) {
        if (w2.g().d() instanceof as) {
            return (as)w2.g().d();
        }
        return null;
    }

    public static class a
    extends i {
        private final String a;

        public a(String string2) {
            this.a = string2;
        }

        @Override
        public ad a(boolean bl2) {
            throw new IllegalStateException(this.a);
        }

        @Override
        public /* synthetic */ az b(h h2) {
            return this.c(h2);
        }

        @Override
        public /* synthetic */ az b(boolean bl2) {
            return this.a(bl2);
        }

        @Override
        public ad c(h h2) {
            throw new IllegalStateException(this.a);
        }

        @Override
        protected ad d() {
            throw new IllegalStateException(this.a);
        }

        @Override
        public String toString() {
            return this.a;
        }
    }

}

