/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.a.m;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.a.a.c;
import kotlin.reflect.jvm.internal.impl.j.ac;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.am;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.at;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.aw;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.l;
import kotlin.reflect.jvm.internal.impl.j.n;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.j.y;

public class au {
    public static final au a;
    static final /* synthetic */ boolean b;
    private final as c;

    static {
        b = au.class.desiredAssertionStatus() ^ true;
        a = au.a(as.d);
    }

    protected au(as as2) {
        this.c = as2;
    }

    private static String a(Object object) {
        try {
            object = object.toString();
            return object;
        }
        catch (Throwable throwable) {
            if (!kotlin.reflect.jvm.internal.impl.l.c.b(throwable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[Exception while computing toString(): ");
                stringBuilder.append(throwable);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            throw (RuntimeException)throwable;
        }
    }

    private List<ap> a(List<kotlin.reflect.jvm.internal.impl.a.as> list, List<ap> list2, int n2) {
        ArrayList<ap> arrayList = new ArrayList<ap>(list.size());
        boolean bl2 = false;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ap ap2;
            kotlin.reflect.jvm.internal.impl.a.as as2 = list.get(i2);
            ap ap3 = list2.get(i2);
            ap ap4 = this.a(ap3, n2 + 1);
            switch (2.a[au.b(as2.k(), ap4.b()).ordinal()]) {
                default: {
                    ap2 = ap4;
                    break;
                }
                case 3: {
                    ap2 = ap4;
                    if (as2.k() == ba.a) break;
                    ap2 = ap4;
                    if (ap4.a()) break;
                    ap2 = new ar(ba.a, ap4.c());
                    break;
                }
                case 1: 
                case 2: {
                    ap2 = av.a(as2);
                }
            }
            if (ap2 != ap3) {
                bl2 = true;
            }
            arrayList.add(ap2);
        }
        if (!bl2) {
            return list2;
        }
        return arrayList;
    }

    private static h a(h h2) {
        if (!h2.b(KotlinBuiltIns.FQ_NAMES.unsafeVariance)) {
            return h2;
        }
        return new m(h2, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.e.b, Boolean>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.b, Boolean>(){

            @Override
            public Boolean a(kotlin.reflect.jvm.internal.impl.e.b b2) {
                return b2.equals(KotlinBuiltIns.FQ_NAMES.unsafeVariance) ^ true;
            }
        });
    }

    private ap a(ap object, int n2) {
        au.a(n2, (ap)object, this.c);
        if (object.a()) {
            return object;
        }
        Object object2 = object.c();
        if (object2 instanceof aw) {
            Object object3 = (aw)object2;
            Object object4 = object3.j();
            object3 = object3.k();
            object4 = this.a(new ar(object.b(), (w)object4), n2 + 1);
            object = this.b((w)object3, object.b());
            object = ax.b(object4.c().l(), (w)object);
            return new ar(object4.b(), (w)object);
        }
        Object object5 = object;
        if (!n.a((w)object2)) {
            if (((w)object2).l() instanceof ac) {
                return object;
            }
            Object object6 = this.c.b((w)object2);
            ba ba2 = object.b();
            if (object6 == null && t.a((w)object2) && !am.a((w)object2)) {
                object5 = t.b((w)object2);
                object6 = new ar(ba2, ((q)object5).f());
                ap ap2 = this.a((ap)object6, ++n2);
                object2 = this.a(new ar(ba2, ((q)object5).h()), n2);
                object6 = ap2.b();
                if (!(b || object6 == object2.b() && ba2 == ba.a || ba2 == object6)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unexpected substituted projection kind: ");
                    ((StringBuilder)object).append(object6);
                    ((StringBuilder)object).append("; original: ");
                    ((StringBuilder)object).append((Object)ba2);
                    throw new AssertionError((Object)((StringBuilder)object).toString());
                }
                if (ap2.c() == ((q)object5).f() && object2.c() == ((q)object5).h()) {
                    return object;
                }
                return new ar((ba)((Object)object6), x.a(at.a(ap2.c()), at.a(object2.c())));
            }
            object5 = object;
            if (!KotlinBuiltIns.isNothing((w)object2)) {
                if (y.a((w)object2)) {
                    return object;
                }
                if (object6 != null) {
                    b b2 = au.b(ba2, object6.b());
                    if (!c.a((w)object2)) {
                        switch (b2) {
                            default: {
                                break;
                            }
                            case b: {
                                return new ar(ba.c, ((w)object2).g().e().getNullableAnyType());
                            }
                            case c: {
                                throw new a("Out-projection in in-position");
                            }
                        }
                    }
                    object = am.b((w)object2);
                    if (object6.a()) {
                        return object6;
                    }
                    object = object != null ? object.a_(object6.c()) : av.b(object6.c(), ((w)object2).c());
                    object5 = object;
                    if (!object2.x().a()) {
                        object5 = au.a(this.c.a(object2.x()));
                        object5 = kotlin.reflect.jvm.internal.impl.j.c.a.a((w)object, new kotlin.reflect.jvm.internal.impl.a.a.l(new h[]{object.x(), object5}));
                    }
                    object = ba2;
                    if (b2 == b.a) {
                        object = au.a(ba2, object6.b());
                    }
                    return new ar((ba)((Object)object), (w)object5);
                }
                object5 = this.b((ap)object, n2);
            }
        }
        return object5;
    }

    public static au a(as as2) {
        return new au(as2);
    }

    public static au a(as as2, as as3) {
        return au.a(l.a(as2, as3));
    }

    public static au a(w w2) {
        return au.a(ao.a(w2.g(), w2.a()));
    }

    public static ba a(ba ba2, ap ap2) {
        if (ap2.a()) {
            return ba.c;
        }
        return au.a(ba2, ap2.b());
    }

    public static ba a(ba ba2, ba ba3) {
        if (ba2 == ba.a) {
            return ba3;
        }
        if (ba3 == ba.a) {
            return ba2;
        }
        if (ba2 == ba3) {
            return ba3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variance conflict: type parameter variance '");
        stringBuilder.append((Object)ba2);
        stringBuilder.append("' and ");
        stringBuilder.append("projection kind '");
        stringBuilder.append((Object)ba3);
        stringBuilder.append("' cannot be combined");
        throw new AssertionError((Object)stringBuilder.toString());
    }

    private static void a(int n2, ap ap2, as as2) {
        if (n2 <= 100) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recursion too deep. Most likely infinite loop while substituting ");
        stringBuilder.append(au.a(ap2));
        stringBuilder.append("; substitution: ");
        stringBuilder.append(au.a((Object)as2));
        throw new IllegalStateException(stringBuilder.toString());
    }

    private ap b(ap object, int n2) {
        w w2 = object.c();
        ba ba2 = object.b();
        if (w2.g().d() instanceof kotlin.reflect.jvm.internal.impl.a.as) {
            return object;
        }
        object = null;
        w w3 = ag.b(w2);
        if (w3 != null) {
            object = this.b(w3, ba.a);
        }
        w3 = at.a(w2, this.a(w2.g().b(), w2.a(), n2), this.c.a(w2.x()));
        w2 = w3;
        if (w3 instanceof ad) {
            w2 = w3;
            if (object instanceof ad) {
                w2 = ag.a(w3, (ad)object);
            }
        }
        return new ar(ba2, w2);
    }

    private static b b(ba ba2, ba ba3) {
        if (ba2 == ba.b && ba3 == ba.c) {
            return b.c;
        }
        if (ba2 == ba.c && ba3 == ba.b) {
            return b.b;
        }
        return b.a;
    }

    public ap a(ap ap2) {
        ap2 = this.b(ap2);
        if (!this.c.c() && !this.c.b()) {
            return ap2;
        }
        return kotlin.reflect.jvm.internal.impl.j.d.b.a(ap2, this.c.b());
    }

    public w a(w w2, ba ba2) {
        if (this.a()) {
            return w2;
        }
        try {
            w2 = this.a(new ar(ba2, w2), 0).c();
            return w2;
        }
        catch (a a2) {
            return p.c(a2.getMessage());
        }
    }

    public boolean a() {
        return this.c.a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ap b(ap ap2) {
        if (this.a()) {
            return ap2;
        }
        try {
            return this.a(ap2, 0);
        }
        catch (a a2) {
            return null;
        }
    }

    public as b() {
        return this.c;
    }

    public w b(w object, ba ba2) {
        object = this.a(new ar(ba2, this.b().a((w)object, ba2)));
        if (object == null) {
            return null;
        }
        return object.c();
    }

    private static final class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }
    }

    private static enum b {
        a,
        b,
        c;
        
    }

}

