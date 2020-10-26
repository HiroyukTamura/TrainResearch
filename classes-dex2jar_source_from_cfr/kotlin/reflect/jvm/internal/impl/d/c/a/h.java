/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.af;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.g.d;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.d.b.c;
import kotlin.reflect.jvm.internal.impl.d.c.a.i;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.t;

public final class h
implements c {
    public static final a a = new a(null);
    private static final List<String> f = m.b("kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator");
    private static final Map<String, Integer> g;
    private final Set<Integer> b;
    private final List<b.g.b> c;
    private final b.g d;
    private final String[] e;

    static {
        Object object = m.n((Iterable)f);
        Map map = new LinkedHashMap(d.c(af.a(m.a(object, 10)), 16));
        object = object.iterator();
        while (object.hasNext()) {
            ab ab2 = (ab)object.next();
            map.put((String)ab2.b(), ab2.a());
        }
        g = map;
    }

    public h(b.g collection, String[] object) {
        j.b(collection, "types");
        j.b(object, "strings");
        this.d = collection;
        this.e = object;
        collection = this.d.e();
        collection = collection.isEmpty() ? al.a() : m.m((Iterable)collection);
        this.b = collection;
        collection = new ArrayList();
        object = this.d.d();
        ((ArrayList)collection).ensureCapacity(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            b.g.b b2 = (b.g.b)object.next();
            j.a((Object)b2, "record");
            int n2 = b2.e();
            for (int i2 = 0; i2 < n2; ++i2) {
                ((ArrayList)collection).add(b2);
            }
        }
        ((ArrayList)collection).trimToSize();
        this.c = (List)collection;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public String a(int var1_1) {
        block15 : {
            block14 : {
                var6_2 = this.c.get(var1_1);
                if (!var6_2.j()) break block14;
                var4_3 = var6_2.k();
                break block15;
            }
            if (!var6_2.f()) ** GOTO lbl-1000
            var2_4 = ((Collection)h.f).size();
            var3_5 = var6_2.g();
            if (var3_5 >= 0 && var2_4 > var3_5) {
                var4_3 = h.f.get(var6_2.g());
            } else lbl-1000: // 2 sources:
            {
                var4_3 = this.e[var1_1];
            }
        }
        var5_6 = var4_3;
        if (var6_2.s() >= 2) {
            var5_6 = var6_2.r();
            var7_7 = (Integer)var5_6.get(0);
            var8_8 = (Integer)var5_6.get(1);
            j.a(var7_7, "begin");
            var5_6 = var4_3;
            if (j.a(0, var7_7.intValue()) <= 0) {
                var1_1 = var7_7.intValue();
                j.a((Object)var8_8, "end");
                var5_6 = var4_3;
                if (j.a(var1_1, var8_8) <= 0) {
                    var5_6 = var4_3;
                    if (j.a(var8_8, var4_3.length()) <= 0) {
                        j.a(var4_3, "string");
                        var1_1 = var7_7.intValue();
                        var2_4 = var8_8;
                        if (var4_3 == null) throw new t("null cannot be cast to non-null type java.lang.String");
                        var5_6 = var4_3.substring(var1_1, var2_4);
                        j.a(var5_6, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    }
                }
            }
        }
        var4_3 = var5_6;
        if (var6_2.u() >= 2) {
            var7_7 = var6_2.t();
            var4_3 = (Integer)var7_7.get(0);
            var7_7 = (Integer)var7_7.get(1);
            j.a(var5_6, "string");
            var4_3 = n.a((String)var5_6, (char)var4_3.intValue(), (char)var7_7.intValue(), false, 4, null);
        }
        if ((var6_2 = var6_2.q()) == null) {
            var6_2 = b.g.b.b.a;
        }
        var5_6 = var4_3;
        switch (i.a[var6_2.ordinal()]) {
            default: {
                var5_6 = var4_3;
                break;
            }
            case 3: {
                var5_6 = var4_3;
                if (var4_3.length() >= 2) {
                    j.a(var4_3, "string");
                    var1_1 = var4_3.length();
                    if (var4_3 == null) throw new t("null cannot be cast to non-null type java.lang.String");
                    var5_6 = var4_3.substring(1, var1_1 - 1);
                    j.a(var5_6, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                }
                j.a(var5_6, "string");
                var5_6 = n.a((String)var5_6, '$', '.', false, 4, null);
                break;
            }
            case 2: {
                j.a(var4_3, "string");
                var5_6 = n.a((String)var4_3, '$', '.', false, 4, null);
            }
            case 1: 
        }
        j.a(var5_6, "string");
        return var5_6;
    }

    @Override
    public String b(int n2) {
        return this.a(n2);
    }

    @Override
    public boolean c(int n2) {
        return this.b.contains(n2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

