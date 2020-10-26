/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.a.h;
import kotlin.reflect.jvm.internal.impl.j.a.l;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.v;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.y;

public final class s {
    public static final s a = new s();

    private s() {
    }

    private final ad a(Set<? extends ad> iterable) {
        boolean bl2;
        if (iterable.size() == 1) {
            return (ad)m.f((Iterable)iterable);
        }
        List list = (List)iterable;
        Object object = new ArrayList(list);
        Object object2 = ((ArrayList)object).iterator();
        do {
            boolean bl3;
            block9 : {
                bl2 = object2.hasNext();
                boolean bl4 = false;
                if (!bl2) break;
                ad ad2 = (ad)object2.next();
                Object object3 = (Iterable)object;
                if (object3 instanceof Collection && ((Collection)object3).isEmpty()) {
                    bl3 = bl4;
                } else {
                    object3 = object3.iterator();
                    do {
                        bl3 = bl4;
                        if (!object3.hasNext()) break block9;
                        w w2 = (ad)object3.next();
                        if (w2 != ad2) {
                            s s2 = a;
                            j.a((Object)w2, "lower");
                            w2 = w2;
                            j.a((Object)ad2, "upper");
                            w w3 = ad2;
                            if (s2.a(w2, w3) || h.b.b(w2, w3)) {
                                bl3 = true;
                                continue;
                            }
                        }
                        bl3 = false;
                    } while (!bl3);
                    bl3 = true;
                }
            }
            if (!bl3) continue;
            object2.remove();
        } while (true);
        bl2 = ((Collection)object).isEmpty();
        if (y.a && !(true ^ bl2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("This collections cannot be empty! input types: ");
            ((StringBuilder)object).append(m.a(iterable, null, null, null, 0, null, null, 63, null));
            throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
        }
        if (((ArrayList)object).size() < 2) {
            iterable = m.j((List)object);
            j.a(iterable, "filteredSuperAndEqualTypes.single()");
            return (ad)((Object)iterable);
        }
        object2 = new v(list);
        iterable = kotlin.reflect.jvm.internal.impl.a.a.h.a.a();
        object = (an)object2;
        list = m.a();
        object2 = ((v)object2).a();
        j.a(object2, "constructor.createScopeForKotlinType()");
        return x.a(iterable, (an)object, list, false, (kotlin.reflect.jvm.internal.impl.h.e.h)object2);
    }

    private final boolean a(w w2, w w3) {
        h h2 = h.b;
        return h2.a(w2, w3) && !h2.a(w3, w2);
    }

    public final ad a(List<? extends ad> object) {
        Object object2;
        Object object3;
        j.b(object, "types");
        boolean bl2 = object.size() > 1;
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Size should be at least 2, but it is ");
            stringBuilder.append(object.size());
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        Object object4 = new ArrayList();
        Object object5 = object.iterator();
        while (object5.hasNext()) {
            object2 = object5.next();
            if (((w)object2).g() instanceof v) {
                object = ((w)object2).g().k_();
                j.a(object, "type.constructor.supertypes");
                object = (Iterable)object;
                Collection collection = new ArrayList(m.a(object, 10));
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    object = (w)iterator.next();
                    j.a(object, "it");
                    object = object3 = t.d((w)object);
                    if (((w)object2).c()) {
                        object = ((ad)object3).a(true);
                    }
                    collection.add(object);
                }
                ((ArrayList)object4).addAll((List)collection);
                continue;
            }
            ((ArrayList)object4).add(object2);
        }
        object3 = (Iterable)object4;
        object = a.a;
        object4 = object3.iterator();
        while (object4.hasNext()) {
            object = ((a)((Object)object)).a((az)object4.next());
        }
        object5 = new LinkedHashSet();
        object2 = object3.iterator();
        while (object2.hasNext()) {
            object3 = object4 = (ad)object2.next();
            if (object == a.d) {
                object3 = ag.a((ad)object4);
            }
            object5.add(object3);
        }
        return this.a((LinkedHashSet)object5);
    }

    private static final abstract class kotlin.reflect.jvm.internal.impl.j.a.s$a
    extends Enum<kotlin.reflect.jvm.internal.impl.j.a.s$a> {
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.j.a.s$a a;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.j.a.s$a b;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.j.a.s$a c;
        public static final /* enum */ kotlin.reflect.jvm.internal.impl.j.a.s$a d;
        private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.j.a.s$a[] e;

        static {
            c c2 = new c("START", 0);
            a = c2;
            a a2 = new a("ACCEPT_NULL", 1);
            b = a2;
            d d2 = new d("UNKNOWN", 2);
            c = d2;
            b b2 = new b("NOT_NULL", 3);
            d = b2;
            e = new kotlin.reflect.jvm.internal.impl.j.a.s$a[]{c2, a2, d2, b2};
        }

        public static kotlin.reflect.jvm.internal.impl.j.a.s$a valueOf(String string2) {
            return Enum.valueOf(kotlin.reflect.jvm.internal.impl.j.a.s$a.class, string2);
        }

        public static kotlin.reflect.jvm.internal.impl.j.a.s$a[] values() {
            return (kotlin.reflect.jvm.internal.impl.j.a.s$a[])e.clone();
        }

        public abstract kotlin.reflect.jvm.internal.impl.j.a.s$a a(az var1);

        protected final kotlin.reflect.jvm.internal.impl.j.a.s$a b(az az2) {
            j.b(az2, "$receiver");
            if (az2.c()) {
                return b;
            }
            if (l.a.a(az2)) {
                return d;
            }
            return c;
        }

        public static final class a
        extends kotlin.reflect.jvm.internal.impl.j.a.s$a {
            a() {
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.j.a.s$a a(az az2) {
                j.b(az2, "nextType");
                return this.b(az2);
            }
        }

        public static final class b
        extends kotlin.reflect.jvm.internal.impl.j.a.s$a {
            b() {
            }

            @Override
            public /* synthetic */ kotlin.reflect.jvm.internal.impl.j.a.s$a a(az az2) {
                return this.c(az2);
            }

            public b c(az az2) {
                j.b(az2, "nextType");
                return this;
            }
        }

        public static final class c
        extends kotlin.reflect.jvm.internal.impl.j.a.s$a {
            c() {
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.j.a.s$a a(az az2) {
                j.b(az2, "nextType");
                return this.b(az2);
            }
        }

        public static final class d
        extends kotlin.reflect.jvm.internal.impl.j.a.s$a {
            d() {
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.j.a.s$a a(az object) {
                j.b(object, "nextType");
                kotlin.reflect.jvm.internal.impl.j.a.s$a a2 = this.b((az)object);
                object = a2;
                if (a2 == kotlin.reflect.jvm.internal.impl.j.a.s$a.b) {
                    object = this;
                }
                return object;
            }
        }

    }

}

