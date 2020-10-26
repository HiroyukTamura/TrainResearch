/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.b.b;
import kotlin.reflect.jvm.internal.impl.h.b.g;
import kotlin.reflect.jvm.internal.impl.h.b.i;
import kotlin.reflect.jvm.internal.impl.h.b.j;
import kotlin.reflect.jvm.internal.impl.h.b.k;
import kotlin.reflect.jvm.internal.impl.h.b.l;
import kotlin.reflect.jvm.internal.impl.h.b.p;
import kotlin.reflect.jvm.internal.impl.h.b.r;
import kotlin.reflect.jvm.internal.impl.h.b.t;
import kotlin.reflect.jvm.internal.impl.h.b.v;
import kotlin.reflect.jvm.internal.impl.h.b.w;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.c.a;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.e;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;

public final class d {
    private final y a;
    private final aa b;

    public d(y y2, aa aa2) {
        kotlin.e.b.j.b(y2, "module");
        kotlin.e.b.j.b(aa2, "notFoundClasses");
        this.a = y2;
        this.b = aa2;
    }

    private final o<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> a(a.a.a i2, Map<f, ? extends av> object, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        kotlin.reflect.jvm.internal.impl.a.a.a a2 = object.get(u.b(c2, i2.e()));
        if (a2 != null) {
            object = u.b(c2, i2.e());
            a2 = a2.r();
            kotlin.e.b.j.a((Object)a2, "parameter.type");
            i2 = i2.g();
            kotlin.e.b.j.a((Object)i2, "proto.value");
            return new o(object, this.a((kotlin.reflect.jvm.internal.impl.j.w)a2, (a.a.a.b)i2, c2));
        }
        return null;
    }

    private final KotlinBuiltIns a() {
        return this.a.a();
    }

    private final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.e.a object) {
        object = this.b((kotlin.reflect.jvm.internal.impl.e.a)object).i_();
        kotlin.e.b.j.a(object, "resolveClass(classId).defaultType");
        object = a.g((kotlin.reflect.jvm.internal.impl.j.w)object);
        Object object2 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.kClass.c());
        kotlin.e.b.j.a(object2, "ClassId.topLevel(KotlinB\u2026FQ_NAMES.kClass.toSafe())");
        object2 = this.b((kotlin.reflect.jvm.internal.impl.e.a)object2);
        return new kotlin.reflect.jvm.internal.impl.h.b.o(x.a(h.a.a(), (kotlin.reflect.jvm.internal.impl.a.e)object2, m.a(new ar((kotlin.reflect.jvm.internal.impl.j.w)object))));
    }

    private final ad a(a.a.a.b object, kotlin.reflect.jvm.internal.impl.d.b.c object2) {
        block16 : {
            KotlinBuiltIns kotlinBuiltIns = this.a();
            a.a.a.b.b b2 = ((a.a.a.b)object).e();
            if (b2 != null) {
                switch (e.b[b2.ordinal()]) {
                    default: {
                        break block16;
                    }
                    case 13: {
                        throw (Throwable)new IllegalStateException("Array of arrays is impossible".toString());
                    }
                    case 12: {
                        object = ((a.a.a.b)object).x();
                        kotlin.e.b.j.a(object, "value.annotation");
                        object = this.b(u.a((kotlin.reflect.jvm.internal.impl.d.b.c)object2, ((a.a)object).e())).i_();
                        object2 = "resolveClass(nameResolve\u2026notation.id)).defaultType";
                        break;
                    }
                    case 11: {
                        object = this.b(u.a((kotlin.reflect.jvm.internal.impl.d.b.c)object2, ((a.a.a.b)object).t())).i_();
                        object2 = "resolveClass(nameResolve\u2026lue.classId)).defaultType";
                        break;
                    }
                    case 10: {
                        throw (Throwable)new IllegalStateException("Arrays of class literals are not supported yet".toString());
                    }
                    case 9: {
                        object = kotlinBuiltIns.getStringType();
                        object2 = "stringType";
                        break;
                    }
                    case 8: {
                        object = kotlinBuiltIns.getBooleanType();
                        object2 = "booleanType";
                        break;
                    }
                    case 7: {
                        object = kotlinBuiltIns.getDoubleType();
                        object2 = "doubleType";
                        break;
                    }
                    case 6: {
                        object = kotlinBuiltIns.getFloatType();
                        object2 = "floatType";
                        break;
                    }
                    case 5: {
                        object = kotlinBuiltIns.getLongType();
                        object2 = "longType";
                        break;
                    }
                    case 4: {
                        object = kotlinBuiltIns.getIntType();
                        object2 = "intType";
                        break;
                    }
                    case 3: {
                        object = kotlinBuiltIns.getShortType();
                        object2 = "shortType";
                        break;
                    }
                    case 2: {
                        object = kotlinBuiltIns.getCharType();
                        object2 = "charType";
                        break;
                    }
                    case 1: {
                        object = kotlinBuiltIns.getByteType();
                        object2 = "byteType";
                    }
                }
                kotlin.e.b.j.a(object, (String)object2);
                return object;
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unknown type: ");
        ((StringBuilder)object2).append(((a.a.a.b)object).e());
        throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString().toString());
    }

    private final kotlin.reflect.jvm.internal.impl.a.e b(kotlin.reflect.jvm.internal.impl.e.a a2) {
        return s.a(this.a, a2, this.b);
    }

    public final c a(a.a object, kotlin.reflect.jvm.internal.impl.d.b.c c2) {
        kotlin.e.b.j.b(object, "proto");
        kotlin.e.b.j.b(c2, "nameResolver");
        kotlin.reflect.jvm.internal.impl.a.e e2 = this.b(u.a(c2, ((a.a)object).e()));
        Iterator iterator = af.a();
        Map<f, kotlin.reflect.jvm.internal.impl.a.m> map = iterator;
        if (((a.a)object).g() != 0) {
            o<f, kotlin.reflect.jvm.internal.impl.h.b.f<?>> o2 = e2;
            map = iterator;
            if (!kotlin.reflect.jvm.internal.impl.j.p.a((kotlin.reflect.jvm.internal.impl.a.m)((Object)o2))) {
                map = iterator;
                if (kotlin.reflect.jvm.internal.impl.h.c.n((kotlin.reflect.jvm.internal.impl.a.m)((Object)o2))) {
                    map = e2.k();
                    kotlin.e.b.j.a((Object)map, "annotationClass.constructors");
                    o2 = (kotlin.reflect.jvm.internal.impl.a.d)m.g((Iterable)((Object)map));
                    map = iterator;
                    if (o2 != null) {
                        map = o2.i();
                        kotlin.e.b.j.a((Object)map, "constructor.valueParameters");
                        iterator = (Iterable)((Object)map);
                        map = new LinkedHashMap(kotlin.g.d.c(af.a(m.a(iterator, 10)), 16));
                        iterator = iterator.iterator();
                        while (iterator.hasNext()) {
                            o2 = iterator.next();
                            av av2 = (av)((Object)o2);
                            kotlin.e.b.j.a((Object)av2, "it");
                            map.put(av2.h_(), (kotlin.reflect.jvm.internal.impl.a.m)((Object)o2));
                        }
                        object = ((a.a)object).f();
                        kotlin.e.b.j.a(object, "proto.argumentList");
                        iterator = (Iterable)object;
                        object = new ArrayList();
                        iterator = iterator.iterator();
                        while (iterator.hasNext()) {
                            o2 = (a.a.a)iterator.next();
                            kotlin.e.b.j.a((Object)o2, "it");
                            if ((o2 = this.a((a.a.a)((Object)o2), map, c2)) == null) continue;
                            object.add(o2);
                        }
                        map = af.a((List)object);
                    }
                }
            }
        }
        return new kotlin.reflect.jvm.internal.impl.a.a.d(e2.i_(), map, an.a);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final kotlin.reflect.jvm.internal.impl.h.b.f<?> a(kotlin.reflect.jvm.internal.impl.j.w var1_1, a.a.a.b var2_2, kotlin.reflect.jvm.internal.impl.d.b.c var3_3) {
        block20 : {
            block21 : {
                block22 : {
                    kotlin.e.b.j.b(var1_1, "expectedType");
                    kotlin.e.b.j.b(var2_2, "value");
                    kotlin.e.b.j.b(var3_3, "nameResolver");
                    var11_4 = kotlin.reflect.jvm.internal.impl.d.b.b.K.a(var2_2.B());
                    var12_5 = var2_2.e();
                    if (var12_5 == null) break block20;
                    var7_6 = e.a[var12_5.ordinal()];
                    var8_7 = false;
                    var6_8 = 0;
                    switch (var7_6) {
                        default: {
                            break block20;
                        }
                        case 13: {
                            if (KotlinBuiltIns.isArray(var1_1) || KotlinBuiltIns.isPrimitiveArray(var1_1)) {
                                var6_8 = 1;
                            }
                            var12_5 = var2_2.y();
                            kotlin.e.b.j.a(var12_5, "arrayElements");
                            if (!(((Collection)var12_5).isEmpty() ^ true)) ** GOTO lbl31
                            var2_2 = m.f(var12_5);
                            kotlin.e.b.j.a(var2_2, "arrayElements.first()");
                            var11_4 = this.a((a.a.a.b)var2_2, (kotlin.reflect.jvm.internal.impl.d.b.c)var3_3);
                            var2_2 = this.a();
                            var11_4 = (kotlin.reflect.jvm.internal.impl.j.w)var11_4;
                            var2_2 = var2_2.getPrimitiveArrayKotlinTypeByPrimitiveKotlinType((kotlin.reflect.jvm.internal.impl.j.w)var11_4);
                            if (var2_2 == null) ** GOTO lbl28
                            var2_2 = (kotlin.reflect.jvm.internal.impl.j.w)var2_2;
                            ** GOTO lbl38
lbl28: // 1 sources:
                            var2_2 = this.a().getArrayType(ba.a, (kotlin.reflect.jvm.internal.impl.j.w)var11_4);
                            var11_4 = "builtIns.getArrayType(Va\u2026RIANT, actualElementType)";
                            ** GOTO lbl36
lbl31: // 1 sources:
                            if (var6_8 != 0) {
                                var2_2 = var1_1;
                            } else {
                                var2_2 = this.a().getArrayType(ba.a, this.a().getAnyType());
                                var11_4 = "builtIns.getArrayType(Va\u2026ARIANT, builtIns.anyType)";
lbl36: // 2 sources:
                                kotlin.e.b.j.a(var2_2, (String)var11_4);
                                var2_2 = (kotlin.reflect.jvm.internal.impl.j.w)var2_2;
                            }
lbl38: // 3 sources:
                            var13_9 = this.a();
                            var11_4 = var6_8 != 0 ? var1_1 : var2_2;
                            var11_4 = var13_9.getArrayElementType((kotlin.reflect.jvm.internal.impl.j.w)var11_4);
                            var13_9 = g.a;
                            var14_10 = (Iterable)var12_5;
                            var12_5 = new ArrayList<E>(m.a(var14_10, 10));
                            var14_10 = var14_10.iterator();
                            while (var14_10.hasNext()) {
                                var15_11 = (a.a.a.b)var14_10.next();
                                kotlin.e.b.j.a(var11_4, "expectedElementType");
                                kotlin.e.b.j.a((Object)var15_11, "it");
                                var12_5.add(this.a((kotlin.reflect.jvm.internal.impl.j.w)var11_4, var15_11, (kotlin.reflect.jvm.internal.impl.d.b.c)var3_3));
                            }
                            var2_2 = var13_9.a((List)var12_5, (kotlin.reflect.jvm.internal.impl.j.w)var2_2);
                            break block21;
                        }
                        case 12: {
                            var2_2 = var2_2.x();
                            kotlin.e.b.j.a(var2_2, "value.annotation");
                            var2_2 = new kotlin.reflect.jvm.internal.impl.h.b.a(this.a((a.a)var2_2, (kotlin.reflect.jvm.internal.impl.d.b.c)var3_3));
                            ** GOTO lbl82
                        }
                        case 11: {
                            var2_2 = new i(u.a((kotlin.reflect.jvm.internal.impl.d.b.c)var3_3, var2_2.t()), u.b((kotlin.reflect.jvm.internal.impl.d.b.c)var3_3, var2_2.v()));
                            ** GOTO lbl82
                        }
                        case 10: {
                            var2_2 = this.a(u.a((kotlin.reflect.jvm.internal.impl.d.b.c)var3_3, var2_2.t()));
                            break block21;
                        }
                        case 9: {
                            var2_2 = new kotlin.reflect.jvm.internal.impl.h.b.s(var3_3.a(var2_2.r()));
                            ** GOTO lbl82
                        }
                        case 8: {
                            if (var2_2.g() != 0L) {
                                var8_7 = true;
                            }
                            var2_2 = new kotlin.reflect.jvm.internal.impl.h.b.c(var8_7);
                            break block22;
                        }
                        case 7: {
                            var2_2 = new kotlin.reflect.jvm.internal.impl.h.b.h(var2_2.p());
                            break block22;
                        }
                        case 6: {
                            var2_2 = new k(var2_2.k());
                            break block22;
                        }
                        case 5: {
                            var9_12 = var2_2.g();
                            kotlin.e.b.j.a(var11_4, "isUnsigned");
                            var2_2 = var11_4.booleanValue() != false ? new v(var9_12) : new p(var9_12);
lbl82: // 4 sources:
                            var2_2 = (kotlin.reflect.jvm.internal.impl.h.b.f)var2_2;
                            break block21;
                        }
                        case 4: {
                            var6_8 = (int)var2_2.g();
                            kotlin.e.b.j.a(var11_4, "isUnsigned");
                            var2_2 = var11_4.booleanValue() ? new kotlin.reflect.jvm.internal.impl.h.b.u(var6_8) : new l(var6_8);
                            break block22;
                        }
                        case 3: {
                            var5_13 = (short)var2_2.g();
                            kotlin.e.b.j.a(var11_4, "isUnsigned");
                            var2_2 = var11_4.booleanValue() ? new w(var5_13) : new r(var5_13);
                            break block22;
                        }
                        case 2: {
                            var2_2 = new kotlin.reflect.jvm.internal.impl.h.b.e((char)var2_2.g());
                            break block22;
                        }
                        case 1: 
                    }
                    var4_14 = (byte)var2_2.g();
                    kotlin.e.b.j.a(var11_4, "isUnsigned");
                    var2_2 = var11_4.booleanValue() != false ? new t(var4_14) : new kotlin.reflect.jvm.internal.impl.h.b.d(var4_14);
                }
                var2_2 = (kotlin.reflect.jvm.internal.impl.h.b.f)var2_2;
            }
            if (a.a(var2_2.a(this.a), var1_1) == false) return j.a.a("Unexpected argument value");
            return var2_2;
        }
        var3_3 = new StringBuilder();
        var3_3.append("Unsupported annotation argument type: ");
        var3_3.append(var2_2.e());
        var3_3.append(" (expected ");
        var3_3.append(var1_1);
        var3_3.append(')');
        throw (Throwable)new IllegalStateException(var3_3.toString().toString());
    }
}

