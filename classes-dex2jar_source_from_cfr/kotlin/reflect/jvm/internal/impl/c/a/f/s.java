/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.a.l;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.c.a.f.b;
import kotlin.reflect.jvm.internal.impl.c.a.f.c;
import kotlin.reflect.jvm.internal.impl.c.a.f.d;
import kotlin.reflect.jvm.internal.impl.c.a.f.e;
import kotlin.reflect.jvm.internal.impl.c.a.f.f;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;
import kotlin.reflect.jvm.internal.impl.c.a.f.k;
import kotlin.reflect.jvm.internal.impl.c.a.f.q;
import kotlin.reflect.jvm.internal.impl.c.a.f.t;
import kotlin.reflect.jvm.internal.impl.c.a.o;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.y;

public final class s {
    private static final b a;
    private static final b b;

    static {
        kotlin.reflect.jvm.internal.impl.e.b b2 = o.k;
        j.a((Object)b2, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        a = new b(b2);
        b2 = o.l;
        j.a((Object)b2, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        b = new b(b2);
    }

    private static final h a(List<? extends h> list) {
        switch (list.size()) {
            default: {
                return new l(kotlin.a.m.k((Iterable)list));
            }
            case 1: {
                return kotlin.a.m.j(list);
            }
            case 0: 
        }
        throw (Throwable)new IllegalStateException("At least one Annotations object expected".toString());
    }

    private static final <T> c<T> a(T t2) {
        return new c<T>(t2, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final c<kotlin.reflect.jvm.internal.impl.a.h> a(kotlin.reflect.jvm.internal.impl.a.h h2, d object, q q2) {
        if (!s.a(q2)) {
            return s.a(h2);
        }
        if (!(h2 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            return s.a(h2);
        }
        kotlin.reflect.jvm.internal.impl.builtins.b.c c2 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
        if ((object = ((d)object).b()) == null) return s.a(h2);
        switch (t.a[((Enum)object).ordinal()]) {
            default: {
                return s.a(h2);
            }
            case 2: {
                if (q2 != q.b || !c2.b((kotlin.reflect.jvm.internal.impl.a.e)(object = (kotlin.reflect.jvm.internal.impl.a.e)h2))) return s.a(h2);
                h2 = c2.d((kotlin.reflect.jvm.internal.impl.a.e)object);
                do {
                    return s.c(h2);
                    break;
                } while (true);
            }
            case 1: {
                if (q2 != q.a || !c2.a((kotlin.reflect.jvm.internal.impl.a.e)(object = (kotlin.reflect.jvm.internal.impl.a.e)h2))) return s.a(h2);
                h2 = c2.c((kotlin.reflect.jvm.internal.impl.a.e)object);
                return s.c(h2);
            }
        }
    }

    private static final c<Boolean> a(w w2, d object, q q2) {
        block6 : {
            if (!s.a(q2)) {
                return s.a(w2.c());
            }
            if ((object = ((d)object).a()) != null) {
                boolean bl2;
                switch (t.b[((Enum)object).ordinal()]) {
                    default: {
                        break block6;
                    }
                    case 2: {
                        bl2 = false;
                        break;
                    }
                    case 1: {
                        bl2 = true;
                    }
                }
                return s.b(bl2);
            }
        }
        return s.a(w2.c());
    }

    private static final k a(az object, kotlin.e.a.b<? super Integer, d> object2, int n2) {
        Object object3 = (w)object;
        boolean bl2 = kotlin.reflect.jvm.internal.impl.j.y.a((w)object3);
        boolean bl3 = false;
        if (bl2) {
            return new k((w)object3, 1, false);
        }
        if (object instanceof kotlin.reflect.jvm.internal.impl.j.q) {
            kotlin.reflect.jvm.internal.impl.j.q q2 = (kotlin.reflect.jvm.internal.impl.j.q)object;
            object3 = s.a(q2.f(), object2, n2, q.a);
            kotlin.reflect.jvm.internal.impl.c.a.f.o o2 = s.a(q2.h(), object2, n2, q.b);
            n2 = ((k)object3).c() == o2.c() ? 1 : 0;
            if (y.a && n2 == 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Different tree sizes of bounds: ");
                ((StringBuilder)object).append("lower = (");
                ((StringBuilder)object).append(q2.f());
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(((k)object3).c());
                ((StringBuilder)object).append("), ");
                ((StringBuilder)object).append("upper = (");
                ((StringBuilder)object).append(q2.h());
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(o2.c());
                ((StringBuilder)object).append(')');
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
            }
            if (((k)object3).d() || o2.d()) {
                bl3 = true;
            }
            if ((object2 = ax.a(((kotlin.reflect.jvm.internal.impl.c.a.f.o)object3).e())) == null) {
                object2 = ax.a(o2.e());
            }
            if (bl3) {
                object = object instanceof kotlin.reflect.jvm.internal.impl.c.a.c.b.g ? (az)new kotlin.reflect.jvm.internal.impl.c.a.c.b.g(((kotlin.reflect.jvm.internal.impl.c.a.f.o)object3).e(), o2.e()) : x.a(((kotlin.reflect.jvm.internal.impl.c.a.f.o)object3).e(), o2.e());
                object = ax.b((az)object, (w)object2);
            }
            return new k((w)object, ((k)object3).c(), bl3);
        }
        if (object instanceof ad) {
            return s.a((ad)object, object2, n2, q.c);
        }
        throw new m();
    }

    private static final kotlin.reflect.jvm.internal.impl.c.a.f.o a(ad az2, kotlin.e.a.b<? super Integer, d> object, int n2, q object2) {
        if (!s.a((q)((Object)object2)) && az2.a().isEmpty()) {
            return new kotlin.reflect.jvm.internal.impl.c.a.f.o((ad)az2, 1, false);
        }
        Object object3 = az2.g().d();
        if (object3 != null) {
            d d2 = object.a((Integer)n2);
            j.a(object3, "originalClass");
            object3 = s.a((kotlin.reflect.jvm.internal.impl.a.h)object3, d2, (q)((Object)object2));
            kotlin.reflect.jvm.internal.impl.a.h h2 = (kotlin.reflect.jvm.internal.impl.a.h)((c)object3).a();
            h h3 = ((c)object3).b();
            an an2 = h2.e();
            int n3 = h3 != null ? 1 : 0;
            object3 = az2.a();
            Collection collection = new ArrayList(kotlin.a.m.a(object3, 10));
            Iterator iterator = object3.iterator();
            int n4 = n2 + 1;
            int n5 = 0;
            int n6 = n3;
            while (iterator.hasNext()) {
                object3 = (ap)iterator.next();
                if (object3.a()) {
                    n3 = n4 + 1;
                    object3 = h2.e();
                    j.a(object3, "enhancedClassifier.typeConstructor");
                    object3 = av.a(object3.b().get(n5));
                } else {
                    Object object4 = s.a(object3.c().l(), (kotlin.e.a.b<? super Integer, d>)object, n4);
                    n6 = n6 == 0 && !((k)object4).d() ? 0 : 1;
                    n3 = n4 + ((k)object4).c();
                    object4 = ((k)object4).b();
                    object3 = object3.b();
                    j.a(object3, "arg.projectionKind");
                    j.a((Object)an2, "typeConstructor");
                    object3 = a.a((w)object4, (ba)((Object)object3), an2.b().get(n5));
                }
                collection.add(object3);
                ++n5;
                n4 = n3;
            }
            object = (List)collection;
            object2 = s.a((w)az2, d2, (q)((Object)object2));
            boolean bl2 = (Boolean)((c)object2).a();
            object3 = ((c)object2).b();
            n3 = n6 == 0 && object3 == null ? 0 : 1;
            n6 = n4 - n2;
            if (n3 == 0) {
                return new kotlin.reflect.jvm.internal.impl.c.a.f.o((ad)az2, n6, false);
            }
            object2 = s.a(kotlin.a.m.h((Iterable)kotlin.a.m.b(az2.x(), h3, object3)));
            j.a((Object)an2, "typeConstructor");
            object = object2 = x.a((h)object2, an2, (List<? extends ap>)object, bl2);
            if (d2.c()) {
                object = new f((ad)object2);
            }
            if ((az2 = (n2 = object3 != null && d2.d() ? 1 : 0) != 0 ? ax.b(az2, (w)object) : (az)object) != null) {
                return new kotlin.reflect.jvm.internal.impl.c.a.f.o((ad)az2, n6, true);
            }
            throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        }
        return new kotlin.reflect.jvm.internal.impl.c.a.f.o((ad)az2, 1, false);
    }

    public static final w a(w w2, kotlin.e.a.b<? super Integer, d> b2) {
        j.b(w2, "$receiver");
        j.b(b2, "qualifiers");
        return s.a(w2.l(), b2, 0).a();
    }

    private static final boolean a(q q2) {
        return q2 != q.c;
    }

    public static final boolean a(w object) {
        j.b(object, "$receiver");
        object = object.x();
        kotlin.reflect.jvm.internal.impl.e.b b2 = o.k;
        j.a((Object)b2, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        return object.a(b2) != null;
    }

    private static final <T> c<T> b(T t2) {
        return new c<T>(t2, a);
    }

    private static final <T> c<T> c(T t2) {
        return new c<T>(t2, b);
    }
}

