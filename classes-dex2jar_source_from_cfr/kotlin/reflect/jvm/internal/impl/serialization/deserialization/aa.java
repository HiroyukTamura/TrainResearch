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
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.impl.a.a.g;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.ah;
import kotlin.reflect.jvm.internal.impl.j.al;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.m;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.s;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.z;

public final class aa {
    private final kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.a.e> a;
    private final kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.a.h> b;
    private final Map<Integer, as> c;
    private final l d;
    private final aa e;
    private final String f;
    private boolean g;

    public aa(l map, aa object, List<a.ag> object22, String string2, boolean bl2) {
        kotlin.e.b.j.b(map, "c");
        kotlin.e.b.j.b(object22, "typeParameterProtos");
        kotlin.e.b.j.b(string2, "debugName");
        this.d = map;
        this.e = object;
        this.f = string2;
        this.g = bl2;
        this.a = this.d.c().b((kotlin.e.a.b)new kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.a.e>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a(((Number)object).intValue());
            }

            @Override
            public final kotlin.reflect.jvm.internal.impl.a.e a(int n2) {
                return this.b(n2);
            }
        });
        this.b = this.d.c().b((kotlin.e.a.b)new kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.a.h>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a(((Number)object).intValue());
            }

            @Override
            public final kotlin.reflect.jvm.internal.impl.a.h a(int n2) {
                return this.d(n2);
            }
        });
        if (object22.isEmpty()) {
            map = af.a();
        } else {
            map = new LinkedHashMap<Integer, as>();
            int n2 = 0;
            for (Object object22 : (Iterable)object22) {
                ((Map)map).put(((a.ag)object22).e(), new m(this.d, (a.ag)object22, n2));
                ++n2;
            }
            map = map;
        }
        this.c = map;
    }

    public /* synthetic */ aa(l l2, aa aa2, List list, String string2, boolean bl2, int n2, kotlin.e.b.g g2) {
        if ((n2 & 16) != 0) {
            bl2 = false;
        }
        this(l2, aa2, list, string2, bl2);
    }

    private final ad a(h object, an an2, List<? extends ap> list, boolean bl2) {
        int n2 = an2.b().size();
        int n3 = list.size();
        Object object2 = null;
        switch (n2 - n3) {
            default: {
                break;
            }
            case 1: {
                n2 = list.size() - 1;
                if (n2 < 0) break;
                object2 = an2.e().getSuspendFunction(n2);
                kotlin.e.b.j.a(object2, "functionTypeConstructor.\u2026getSuspendFunction(arity)");
                object2 = object2.e();
                kotlin.e.b.j.a(object2, "functionTypeConstructor.\u2026on(arity).typeConstructor");
                object2 = kotlin.reflect.jvm.internal.impl.j.x.a((h)object, (an)object2, list, bl2);
                break;
            }
            case 0: {
                object2 = this.b((h)object, an2, list, bl2);
            }
        }
        if (object2 != null) {
            return object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Bad suspend function in metadata with constructor: ");
        ((StringBuilder)object).append(an2);
        object = p.a(((StringBuilder)object).toString(), list);
        kotlin.e.b.j.a(object, "ErrorUtils.createErrorTy\u2026      arguments\n        )");
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final ad a(w w2) {
        boolean bl2 = this.d.d().d().e();
        Object object = kotlin.a.m.i(FunctionTypesKt.getValueParameterTypesFromFunctionType(w2));
        Object var8_4 = null;
        if (object == null) return null;
        Object object2 = object.c();
        if (object2 == null) return null;
        object = ((w)object2).g().d();
        object = object != null ? kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.m)object) : null;
        int n2 = ((w)object2).a().size();
        boolean bl3 = true;
        if (n2 != 1) return (ad)w2;
        if (!SuspendFunctionTypesKt.isContinuation((kotlin.reflect.jvm.internal.impl.e.b)object, true) && !SuspendFunctionTypesKt.isContinuation((kotlin.reflect.jvm.internal.impl.e.b)object, false)) {
            return (ad)w2;
        }
        w w3 = kotlin.a.m.j(((w)object2).a()).c();
        kotlin.reflect.jvm.internal.impl.a.m m2 = this.d.f();
        object2 = m2;
        if (!(m2 instanceof kotlin.reflect.jvm.internal.impl.a.a)) {
            object2 = null;
        }
        m2 = (kotlin.reflect.jvm.internal.impl.a.a)object2;
        object2 = var8_4;
        if (m2 != null) {
            object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.a)m2);
        }
        if (!kotlin.e.b.j.a(object2, (Object)z.a)) {
            boolean bl4 = bl3;
            if (!this.g) {
                bl4 = bl2 && SuspendFunctionTypesKt.isContinuation((kotlin.reflect.jvm.internal.impl.e.b)object, bl2 ^ true) ? bl3 : false;
            }
            this.g = bl4;
        }
        kotlin.e.b.j.a((Object)w3, "suspendReturnType");
        return this.a(w2, w3);
    }

    private final ad a(w w2, w w3) {
        KotlinBuiltIns kotlinBuiltIns = kotlin.reflect.jvm.internal.impl.j.c.a.a(w2);
        h h2 = w2.x();
        w w4 = FunctionTypesKt.getReceiverTypeFromFunctionType(w2);
        Object object = kotlin.a.m.d(FunctionTypesKt.getValueParameterTypesFromFunctionType(w2), 1);
        Collection collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(((ap)object.next()).c());
        }
        return FunctionTypesKt.createFunctionType(kotlinBuiltIns, h2, w4, (List)collection, null, w3, true).a(w2.c());
    }

    private final an a(int n2) {
        Object object = this.c.get(n2);
        if (object != null && (object = object.e()) != null) {
            return object;
        }
        object = this.e;
        if (object != null) {
            return aa.super.a(n2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final an a(a.ac object4) {
        Object object2;
        Object object3 = new kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.a.e>((a.ac)object4){
            final /* synthetic */ a.ac b;
            {
                this.b = ac2;
                super(1);
            }

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a(((Number)object).intValue());
            }

            @Override
            public final kotlin.reflect.jvm.internal.impl.a.e a(int n2) {
                kotlin.reflect.jvm.internal.impl.e.a a2 = u.a(this.d.e(), n2);
                List<Integer> list = kotlin.h.i.f(kotlin.h.i.e(kotlin.h.i.a(this.b, (kotlin.e.a.b)new kotlin.e.a.b<a.ac, a.ac>(){

                    @Override
                    public final a.ac a(a.ac ac2) {
                        kotlin.e.b.j.b(ac2, "it");
                        return kotlin.reflect.jvm.internal.impl.d.b.g.b(ac2, this.d.g());
                    }
                }), c.a));
                n2 = kotlin.h.i.g(kotlin.h.i.a(a2, a.c));
                while (list.size() < n2) {
                    list.add(0);
                }
                return this.d.d().m().a(a2, list);
            }

        };
        if (((a.ac)object4).s()) {
            object2 = this.a.a(((a.ac)object4).t());
            object4 = object2 != null ? object2 : object3.a(((a.ac)object4).t());
            object2 = object4.e();
            object4 = "(classDescriptors(proto.\u2026assName)).typeConstructor";
        } else if (((a.ac)object4).u()) {
            object2 = this.a(((a.ac)object4).v());
            if (object2 != null) {
                return object2;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unknown type parameter ");
            ((StringBuilder)object2).append(((a.ac)object4).v());
            object2 = p.e(((StringBuilder)object2).toString());
            object4 = "ErrorUtils.createErrorTy\u2026 ${proto.typeParameter}\")";
        } else if (((a.ac)object4).w()) {
            block11 : {
                object2 = this.d.f();
                object3 = this.d.e().a(((a.ac)object4).x());
                for (Object object4 : (Iterable)this.a()) {
                    if (!kotlin.e.b.j.a((Object)((as)object4).h_().a(), object3)) continue;
                    break block11;
                }
                object4 = null;
            }
            object4 = (as)object4;
            if (object4 != null && (object4 = object4.e()) != null) {
                return object4;
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Deserialized type parameter ");
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append(" in ");
            ((StringBuilder)object4).append(object2);
            object2 = p.e(((StringBuilder)object4).toString());
            object4 = "ErrorUtils.createErrorTy\u2026ter $name in $container\")";
        } else if (((a.ac)object4).y()) {
            object2 = this.b.a(((a.ac)object4).z());
            object4 = object2 != null ? object2 : (kotlin.reflect.jvm.internal.impl.a.h)object3.a(((a.ac)object4).z());
            object2 = object4.e();
            object4 = "(typeAliasDescriptors(pr\u2026iasName)).typeConstructor";
        } else {
            object2 = p.e("Unknown type");
            object4 = "ErrorUtils.createErrorTy\u2026nstructor(\"Unknown type\")";
        }
        kotlin.e.b.j.a(object2, (String)object4);
        return object2;
    }

    private final ap a(as object, a.ac.a i2) {
        if (i2.e() == a.ac.a.b.d) {
            if (object == null) {
                object = this.d.d().c().a().getNullableAnyType();
                kotlin.e.b.j.a(object, "c.components.moduleDescr\u2026.builtIns.nullableAnyType");
                return new al((w)object);
            }
            return new ah((as)object);
        }
        object = x.a;
        a.ac.a.b b2 = i2.e();
        kotlin.e.b.j.a((Object)b2, "typeArgumentProto.projection");
        object = ((x)object).a(b2);
        i2 = kotlin.reflect.jvm.internal.impl.d.b.g.a(i2, this.d.g());
        if (i2 != null) {
            return new ar((ba)((Object)object), aa.a(this, (a.ac)i2, null, 2, null));
        }
        return new ar(p.c("No type recorded"));
    }

    public static /* bridge */ /* synthetic */ w a(aa aa2, a.ac ac2, h h2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            h2 = h.a.a();
        }
        return aa2.a(ac2, h2);
    }

    private final kotlin.reflect.jvm.internal.impl.a.e b(int n2) {
        kotlin.reflect.jvm.internal.impl.e.a a2 = u.a(this.d.e(), n2);
        if (a2.d()) {
            return this.d.d().a(a2);
        }
        return kotlin.reflect.jvm.internal.impl.a.s.a(this.d.d().c(), a2);
    }

    private final ad b(h object, an an2, List<? extends ap> list, boolean bl2) {
        if (!FunctionTypesKt.isFunctionType((w)(object = (w)kotlin.reflect.jvm.internal.impl.j.x.a((h)object, an2, list, bl2)))) {
            return null;
        }
        return this.a((w)object);
    }

    public static /* synthetic */ ad b(aa aa2, a.ac ac2, h h2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            h2 = h.a.a();
        }
        return aa2.b(ac2, h2);
    }

    private final ad c(int n2) {
        if (u.a(this.d.e(), n2).d()) {
            return this.d.d().h().a();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.a.h d(int n2) {
        kotlin.reflect.jvm.internal.impl.e.a a2 = u.a(this.d.e(), n2);
        if (a2.d()) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.a.s.b(this.d.d().c(), a2);
    }

    public final List<as> a() {
        return kotlin.a.m.k((Iterable)this.c.values());
    }

    public final w a(a.ac ac2, h object) {
        kotlin.e.b.j.b(ac2, "proto");
        kotlin.e.b.j.b(object, "additionalAnnotations");
        if (ac2.j()) {
            String string2 = this.d.e().a(ac2.k());
            ad ad2 = this.b(ac2, (h)object);
            a.ac ac3 = kotlin.reflect.jvm.internal.impl.d.b.g.a(ac2, this.d.g());
            if (ac3 == null) {
                kotlin.e.b.j.a();
            }
            object = this.b(ac3, (h)object);
            return this.d.d().k().a(ac2, string2, ad2, (ad)object);
        }
        return this.b(ac2, (h)object);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final ad b(a.ac var1_1, h var2_2) {
        block5 : {
            kotlin.e.b.j.b(var1_1, "proto");
            kotlin.e.b.j.b(var2_2, "additionalAnnotations");
            if (!var1_1.s()) break block5;
            var3_3 = var1_1.t();
            ** GOTO lbl9
        }
        if (var1_1.y()) {
            var3_3 = var1_1.z();
lbl9: // 2 sources:
            var4_4 = this.c(var3_3);
        } else {
            var4_4 = null;
        }
        if (var4_4 != null) {
            return var4_4;
        }
        var4_4 = this.a((a.ac)var1_1);
        if (p.a(var4_4.d())) {
            var1_1 = p.a(var4_4.toString(), (an)var4_4);
            kotlin.e.b.j.a(var1_1, "ErrorUtils.createErrorTy\u2026.toString(), constructor)");
            return var1_1;
        }
        var5_5 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.b(this.d.c(), (kotlin.e.a.a<? extends List<g>>)new kotlin.e.a.a<List<? extends g>>((a.ac)var1_1, var2_2){
            final /* synthetic */ a.ac b;
            final /* synthetic */ h c;
            {
                this.b = ac2;
                this.c = h2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final List<g> b() {
                Object object = this.d.d().f().a(this.b, this.d.e());
                Collection collection = new ArrayList(kotlin.a.m.a(object, 10));
                object = object.iterator();
                while (object.hasNext()) {
                    collection.add(new g((kotlin.reflect.jvm.internal.impl.a.a.c)object.next(), null));
                }
                return kotlin.a.m.k(kotlin.a.m.b((List)collection, (Iterable)this.c.c()));
            }
        });
        var7_6 = new kotlin.e.a.b<a.ac, List<? extends a.ac.a>>(){

            @Override
            public final List<a.ac.a> a(a.ac list) {
                kotlin.e.b.j.b(list, "$receiver");
                Collection<a.ac.a> collection = ((a.ac)((Object)list)).d();
                kotlin.e.b.j.a(collection, "argumentList");
                collection = collection;
                list = kotlin.reflect.jvm.internal.impl.d.b.g.b((a.ac)((Object)list), this.d.g());
                list = list != null ? this.a((a.ac)((Object)list)) : null;
                if (list == null) {
                    list = kotlin.a.m.a();
                }
                return kotlin.a.m.b(collection, (Iterable)list);
            }
        }.a((a.ac)var1_1);
        var6_7 = (List<T>)new ArrayList<E>(kotlin.a.m.a(var7_6, 10));
        var3_3 = 0;
        var7_6 = var7_6.iterator();
        while (var7_6.hasNext()) {
            var8_8 = (a.ac.a)var7_6.next();
            var9_9 = var4_4.b();
            kotlin.e.b.j.a(var9_9, "constructor.parameters");
            var6_7.add(this.a(kotlin.a.m.c(var9_9, var3_3), var8_8));
            ++var3_3;
        }
        var6_7 = kotlin.a.m.k((Iterable)var6_7);
        var7_6 = kotlin.reflect.jvm.internal.impl.d.b.b.a.a(var1_1.J());
        kotlin.e.b.j.a(var7_6, "Flags.SUSPEND_TYPE.get(proto.flags)");
        var4_4 = var7_6.booleanValue() != false ? this.a(var5_5, (an)var4_4, var6_7, var1_1.g()) : kotlin.reflect.jvm.internal.impl.j.x.a(var5_5, (an)var4_4, var6_7, var1_1.g());
        var1_1 = kotlin.reflect.jvm.internal.impl.d.b.g.c((a.ac)var1_1, this.d.g());
        if (var1_1 == null) return var4_4;
        return ag.a((ad)var4_4, this.b((a.ac)var1_1, var2_2));
    }

    public final boolean b() {
        return this.g;
    }

    public String toString() {
        CharSequence charSequence;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        if (this.e == null) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(". Child of ");
            ((StringBuilder)charSequence).append(this.e.f);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }

}

