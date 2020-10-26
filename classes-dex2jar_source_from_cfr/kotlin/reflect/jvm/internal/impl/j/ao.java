/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.u;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class ao
extends as {
    public static final a b = new a(null);

    public static final ao a(Map<an, ? extends ap> map) {
        return a.a(b, map, false, 2, null);
    }

    public static final as a(an an2, List<? extends ap> list) {
        return b.a(an2, list);
    }

    public abstract ap a(an var1);

    @Override
    public ap b(w w2) {
        j.b(w2, "key");
        return this.a(w2.g());
    }

    public static final class kotlin.reflect.jvm.internal.impl.j.ao$a {
        private kotlin.reflect.jvm.internal.impl.j.ao$a() {
        }

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.j.ao$a(g g2) {
            this();
        }

        public static /* bridge */ /* synthetic */ ao a(kotlin.reflect.jvm.internal.impl.j.ao$a a2, Map map, boolean bl2, int n2, Object object) {
            if ((n2 & 2) != 0) {
                bl2 = false;
            }
            return a2.a(map, bl2);
        }

        public final ao a(final Map<an, ? extends ap> map, final boolean bl2) {
            j.b(map, "map");
            return new ao(){

                @Override
                public ap a(an an2) {
                    j.b(an2, "key");
                    return (ap)map.get(an2);
                }

                @Override
                public boolean a() {
                    return map.isEmpty();
                }

                @Override
                public boolean c() {
                    return bl2;
                }
            };
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final as a(an object, List<? extends ap> list) {
            j.b(object, "typeConstructor");
            j.b(list, "arguments");
            Object object2 = object.b();
            j.a(object2, "parameters");
            Iterator iterator = m.i(object2);
            boolean bl2 = iterator != null ? iterator.a() : false;
            if (bl2) {
                object2 = this;
                object = object.b();
                j.a(object, "typeConstructor.parameters");
                iterator = (Iterable)object;
                object = new ArrayList(m.a(iterator, 10));
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    kotlin.reflect.jvm.internal.impl.a.as as2 = (kotlin.reflect.jvm.internal.impl.a.as)iterator.next();
                    j.a((Object)as2, "it");
                    object.add(as2.e());
                }
                object = kotlin.reflect.jvm.internal.impl.j.ao$a.a((kotlin.reflect.jvm.internal.impl.j.ao$a)object2, af.a(m.a((Iterable)((List)object), (Iterable)list)), false, 2, null);
                do {
                    return (as)object;
                    break;
                } while (true);
            }
            object = new u((List<? extends kotlin.reflect.jvm.internal.impl.a.as>)object2, list);
            return (as)object;
        }

        public final as a(w w2) {
            j.b(w2, "kotlinType");
            return this.a(w2.g(), w2.a());
        }

    }

}

