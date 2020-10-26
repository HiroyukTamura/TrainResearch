/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.h.b.c;
import kotlin.reflect.jvm.internal.impl.h.b.d;
import kotlin.reflect.jvm.internal.impl.h.b.e;
import kotlin.reflect.jvm.internal.impl.h.b.f;
import kotlin.reflect.jvm.internal.impl.h.b.h;
import kotlin.reflect.jvm.internal.impl.h.b.k;
import kotlin.reflect.jvm.internal.impl.h.b.l;
import kotlin.reflect.jvm.internal.impl.h.b.p;
import kotlin.reflect.jvm.internal.impl.h.b.q;
import kotlin.reflect.jvm.internal.impl.h.b.r;
import kotlin.reflect.jvm.internal.impl.h.b.s;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class g {
    public static final g a = new g();

    private g() {
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.b a(List<?> collection, final PrimitiveType primitiveType) {
        Object object = m.k((Iterable)collection);
        collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            if ((object2 = this.a(object2)) == null) continue;
            collection.add(object2);
        }
        return new kotlin.reflect.jvm.internal.impl.h.b.b((List<? extends f<?>>)collection, (kotlin.e.a.b<? super y, ? extends w>)new kotlin.e.a.b<y, ad>(){

            @Override
            public final ad a(y a2) {
                j.b(a2, "module");
                a2 = a2.a().getPrimitiveArrayKotlinType(primitiveType);
                j.a((Object)a2, "module.builtIns.getPrimi\u2026KotlinType(componentType)");
                return a2;
            }
        });
    }

    public final kotlin.reflect.jvm.internal.impl.h.b.b a(List<? extends f<?>> list, final w w2) {
        j.b(list, "value");
        j.b(w2, "type");
        return new kotlin.reflect.jvm.internal.impl.h.b.b(list, (kotlin.e.a.b<? super y, ? extends w>)new kotlin.e.a.b<y, w>(){

            @Override
            public final w a(y y2) {
                j.b(y2, "it");
                return w2;
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public final f<?> a(Object object) {
        void var2_25;
        void var1_3;
        void var1_15;
        void var1_13;
        if (object instanceof Byte) {
            d d2 = new d(((Number)object).byteValue());
            return (f)var1_3;
        }
        if (object instanceof Short) {
            r r2 = new r(((Number)object).shortValue());
            return (f)var1_3;
        }
        if (object instanceof Integer) {
            l l2 = new l(((Number)object).intValue());
            return (f)var1_3;
        }
        if (object instanceof Long) {
            p p2 = new p(((Number)object).longValue());
            return (f)var1_3;
        }
        if (object instanceof Character) {
            e e2 = new e(((Character)object).charValue());
            return (f)var1_3;
        }
        if (object instanceof Float) {
            k k2 = new k(((Number)object).floatValue());
            return (f)var1_3;
        }
        if (object instanceof Double) {
            h h2 = new h(((Number)object).doubleValue());
            return (f)var1_3;
        }
        if (object instanceof Boolean) {
            c c2 = new c((Boolean)object);
            return (f)var1_3;
        }
        if (object instanceof String) {
            s s2 = new s((String)object);
            return (f)var1_3;
        }
        if (object instanceof byte[]) {
            List<Byte> list = kotlin.a.g.a((byte[])object);
            PrimitiveType primitiveType = PrimitiveType.BYTE;
        } else if (object instanceof short[]) {
            List<Short> list = kotlin.a.g.a((short[])object);
            PrimitiveType primitiveType = PrimitiveType.SHORT;
        } else if (object instanceof int[]) {
            List<Integer> list = kotlin.a.g.d((int[])object);
            PrimitiveType primitiveType = PrimitiveType.INT;
        } else if (object instanceof long[]) {
            List<Long> list = kotlin.a.g.a((long[])object);
            PrimitiveType primitiveType = PrimitiveType.LONG;
        } else if (object instanceof char[]) {
            List<Character> list = kotlin.a.g.b((char[])object);
            PrimitiveType primitiveType = PrimitiveType.CHAR;
        } else if (object instanceof float[]) {
            List<Float> list = kotlin.a.g.a((float[])object);
            PrimitiveType primitiveType = PrimitiveType.FLOAT;
        } else if (object instanceof double[]) {
            List<Double> list = kotlin.a.g.a((double[])object);
            PrimitiveType primitiveType = PrimitiveType.DOUBLE;
        } else {
            if (!(object instanceof boolean[])) {
                if (object != null) return null;
                q q2 = new q();
                return (f)var1_15;
            }
            List<Boolean> list = kotlin.a.g.a((boolean[])object);
            PrimitiveType primitiveType = PrimitiveType.BOOLEAN;
        }
        kotlin.reflect.jvm.internal.impl.h.b.b b2 = this.a((List<?>)var2_25, (PrimitiveType)var1_13);
        return (f)var1_15;
    }

}

