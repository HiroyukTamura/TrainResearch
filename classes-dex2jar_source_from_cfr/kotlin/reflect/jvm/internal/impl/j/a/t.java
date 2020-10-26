/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.h.a.a.c;
import kotlin.reflect.jvm.internal.impl.j.a.n;
import kotlin.reflect.jvm.internal.impl.j.a.r;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public final class t {
    private static final String a(an object) {
        final StringBuilder stringBuilder = new StringBuilder();
        b<String, StringBuilder> b2 = new b<String, StringBuilder>(){

            @Override
            public final StringBuilder a(String string2) {
                j.b(string2, "$receiver");
                StringBuilder stringBuilder2 = stringBuilder;
                stringBuilder2.append(string2);
                j.a((Object)stringBuilder2, "append(value)");
                return kotlin.i.n.a(stringBuilder2);
            }
        };
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("type: ");
        stringBuilder2.append(object);
        b2.a(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("hashCode: ");
        stringBuilder2.append(object.hashCode());
        b2.a(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("javaClass: ");
        stringBuilder2.append(object.getClass().getCanonicalName());
        b2.a(stringBuilder2.toString());
        for (object = (m)object.d(); object != null; object = object.b()) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("fqName: ");
            stringBuilder2.append(kotlin.reflect.jvm.internal.impl.g.c.f.a((m)object));
            b2.a(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("javaClass: ");
            stringBuilder2.append(object.getClass().getCanonicalName());
            b2.a(stringBuilder2.toString());
        }
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    private static final w a(w w2) {
        return kotlin.reflect.jvm.internal.impl.j.d.b.a(w2).b();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final w a(w var0, w var1_1, r var2_2) {
        j.b(var0, "subtype");
        j.b(var1_1, "supertype");
        j.b(var2_2, "typeCheckingProcedureCallbacks");
        var6_3 = new ArrayDeque<n>();
        var6_3.add(new n((w)var0, null));
        var5_4 = var1_1.g();
        block0 : do {
            if (var6_3.isEmpty() != false) return null;
            var1_1 = (n)var6_3.poll();
            var0 = var1_1.a();
            var7_6 = var0.g();
            if (var2_2.a(var7_6, var5_4)) {
                var4_12 = var0.c();
                break;
            }
            var0 = var7_6.k_().iterator();
            do {
                if (!var0.hasNext()) continue block0;
                var7_11 = var0.next();
                j.a((Object)var7_11, "immediateSupertype");
                var6_3.add(new n(var7_11, (n)var1_1));
            } while (true);
            break;
        } while (true);
        do {
            block10 : {
                block13 : {
                    block12 : {
                        block11 : {
                            if ((var1_1 = var1_1.b()) == null) break block11;
                            var6_3 = var1_1.a();
                            var7_8 = var6_3.a();
                            if (var7_8 instanceof Collection && ((Collection)var7_8).isEmpty()) break block12;
                            var7_10 = var7_8.iterator();
                            break block13;
                        }
                        var1_1 = var0.g();
                        if (var2_2.a((an)var1_1, var5_4)) {
                            return av.a(var0, var4_12);
                        }
                        var0 = new StringBuilder();
                        var0.append("Type constructors should be equals!\n");
                        var0.append("substitutedSuperType: ");
                        var0.append(t.a((an)var1_1));
                        var0.append(", \n\n");
                        var0.append("supertype: ");
                        var0.append(t.a(var5_4));
                        var0.append(" \n");
                        var0.append(var2_2.a((an)var1_1, var5_4));
                        throw (Throwable)new AssertionError((Object)var0.toString());
                    }
                    do {
                        var3_13 = false;
                        break block10;
                        break;
                    } while (true);
                }
                do {
                    if (!var7_10.hasNext()) ** continue;
                } while (!(var3_13 = ((ap)var7_10.next()).b() != ba.a));
                var3_13 = true;
            }
            if (var3_13) {
                var0 = c.a(ao.b.a((w)var6_3), false, 1, null).f().a((w)var0, ba.a);
                j.a(var0, "TypeConstructorSubstitut\u2026uted, Variance.INVARIANT)");
                var0 = t.a((w)var0);
            } else {
                var0 = ao.b.a((w)var6_3).f().a((w)var0, ba.a);
                j.a(var0, "TypeConstructorSubstitut\u2026uted, Variance.INVARIANT)");
            }
            if (!var4_12 && !var6_3.c()) {
                var4_12 = false;
                continue;
            }
            var4_12 = true;
        } while (true);
    }

}

