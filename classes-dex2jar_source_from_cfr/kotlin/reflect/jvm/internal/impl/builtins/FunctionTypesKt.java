/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.a.i;
import kotlin.reflect.jvm.internal.impl.a.a.k;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.a.a;
import kotlin.reflect.jvm.internal.impl.builtins.a.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.s;
import kotlin.y;

public final class FunctionTypesKt {
    private static final b.b a(kotlin.reflect.jvm.internal.impl.e.c object) {
        if (((kotlin.reflect.jvm.internal.impl.e.c)object).b() && !((kotlin.reflect.jvm.internal.impl.e.c)object).d()) {
            a.a a2 = a.a;
            String string2 = ((kotlin.reflect.jvm.internal.impl.e.c)object).f().a();
            j.a((Object)string2, "shortName().asString()");
            object = ((kotlin.reflect.jvm.internal.impl.e.c)object).c().d();
            j.a(object, "toSafe().parent()");
            return a2.a(string2, (kotlin.reflect.jvm.internal.impl.e.b)object);
        }
        return null;
    }

    private static final boolean a(w object) {
        object = object.x();
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        j.a((Object)b2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        return object.a(b2) != null;
    }

    public static final ad createFunctionType(KotlinBuiltIns kotlinBuiltIns, h iterable, w object, List<? extends w> object2, List<f> iterable2, w object3, boolean bl2) {
        j.b(kotlinBuiltIns, "builtIns");
        j.b(iterable, "annotations");
        j.b(object2, "parameterTypes");
        j.b(object3, "returnType");
        object3 = FunctionTypesKt.getFunctionTypeArgumentProjections((w)object, object2, iterable2, (w)object3, kotlinBuiltIns);
        int n2 = object2.size();
        if (object != null) {
            ++n2;
        }
        object2 = bl2 ? kotlinBuiltIns.getSuspendFunction(n2) : kotlinBuiltIns.getFunction(n2);
        iterable2 = iterable;
        if (object != null) {
            object = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
            j.a(object, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (iterable.a((kotlin.reflect.jvm.internal.impl.e.b)object) != null) {
                iterable2 = iterable;
            } else {
                iterable = iterable;
                object = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
                j.a(object, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                iterable2 = new i(m.d(iterable, new k(kotlinBuiltIns, (kotlin.reflect.jvm.internal.impl.e.b)object, af.a())));
            }
        }
        j.a(object2, "classDescriptor");
        return x.a(iterable2, (e)object2, (List<? extends ap>)object3);
    }

    public static /* synthetic */ ad createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, h h2, w w2, List list, List list2, w w3, boolean bl2, int n2, Object object) {
        block0 : {
            if ((n2 & 64) == 0) break block0;
            bl2 = false;
        }
        return FunctionTypesKt.createFunctionType(kotlinBuiltIns, h2, w2, list, list2, w3, bl2);
    }

    public static final f extractParameterNameFromFunctionTypeArgument(w object) {
        j.b(object, "$receiver");
        object = object.x();
        kotlin.reflect.jvm.internal.impl.e.b b2 = KotlinBuiltIns.FQ_NAMES.parameterName;
        j.a((Object)b2, "KotlinBuiltIns.FQ_NAMES.parameterName");
        object = object.a(b2);
        if (object != null) {
            b2 = m.g((Iterable)object.c().values());
            object = b2;
            if (!(b2 instanceof kotlin.reflect.jvm.internal.impl.h.b.s)) {
                object = null;
            }
            if ((object = (kotlin.reflect.jvm.internal.impl.h.b.s)object) != null && (object = (String)((kotlin.reflect.jvm.internal.impl.h.b.f)object).a()) != null) {
                if (!f.b((String)object)) {
                    object = null;
                }
                if (object != null) {
                    return f.a((String)object);
                }
            }
        }
        return null;
    }

    public static final List<ap> getFunctionTypeArgumentProjections(w object, List<? extends w> object2, List<f> list, w w2, KotlinBuiltIns kotlinBuiltIns) {
        j.b(object2, "parameterTypes");
        j.b(w2, "returnType");
        j.b(kotlinBuiltIns, "builtIns");
        int n2 = object2.size();
        int n3 = 0;
        int n4 = object != null ? 1 : 0;
        ArrayList<ap> arrayList = new ArrayList<ap>(n2 + n4 + 1);
        Collection collection = arrayList;
        object = object != null ? kotlin.reflect.jvm.internal.impl.j.c.a.f((w)object) : null;
        kotlin.reflect.jvm.internal.impl.l.a.a(collection, object);
        Iterator iterator = ((Iterable)object2).iterator();
        n4 = n3;
        while (iterator.hasNext()) {
            w w3 = (w)iterator.next();
            if (list == null || (object = list.get(n4)) == null || ((f)object).c()) {
                object = null;
            }
            object2 = w3;
            if (object != null) {
                object2 = KotlinBuiltIns.FQ_NAMES.parameterName;
                j.a(object2, "KotlinBuiltIns.FQ_NAMES.parameterName");
                f f2 = f.a("name");
                object = ((f)object).a();
                j.a(object, "name.asString()");
                object = new k(kotlinBuiltIns, (kotlin.reflect.jvm.internal.impl.e.b)object2, af.a(s.a(f2, new kotlin.reflect.jvm.internal.impl.h.b.s((String)object))));
                object2 = kotlin.reflect.jvm.internal.impl.j.c.a.a(w3, new i(m.d((Iterable)w3.x(), object)));
            }
            collection.add(kotlin.reflect.jvm.internal.impl.j.c.a.f((w)object2));
            ++n4;
        }
        arrayList.add(kotlin.reflect.jvm.internal.impl.j.c.a.f(w2));
        return arrayList;
    }

    public static final b.b getFunctionalClassKind(kotlin.reflect.jvm.internal.impl.a.m m2) {
        j.b(m2, "$receiver");
        if (!(m2 instanceof e)) {
            return null;
        }
        if (!KotlinBuiltIns.isUnderKotlinPackage(m2)) {
            return null;
        }
        return FunctionTypesKt.a(kotlin.reflect.jvm.internal.impl.h.c.a.a(m2));
    }

    public static final w getReceiverTypeFromFunctionType(w w2) {
        j.b(w2, "$receiver");
        boolean bl2 = FunctionTypesKt.isBuiltinFunctionalType(w2);
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not a function type: ");
            stringBuilder.append(w2);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        if (FunctionTypesKt.a(w2)) {
            return m.f(w2.a()).c();
        }
        return null;
    }

    public static final w getReturnTypeFromFunctionType(w w2) {
        j.b(w2, "$receiver");
        boolean bl2 = FunctionTypesKt.isBuiltinFunctionalType(w2);
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not a function type: ");
            stringBuilder.append(w2);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        w2 = m.h(w2.a()).c();
        j.a((Object)w2, "arguments.last().type");
        return w2;
    }

    public static final List<ap> getValueParameterTypesFromFunctionType(w w2) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public static final boolean isBuiltinExtensionFunctionalType(w w2) {
        j.b(w2, "$receiver");
        return FunctionTypesKt.isBuiltinFunctionalType(w2) && FunctionTypesKt.a(w2);
    }

    public static final boolean isBuiltinFunctionalType(w object) {
        j.b(object, "$receiver");
        object = object.g().d();
        object = object != null ? FunctionTypesKt.getFunctionalClassKind((kotlin.reflect.jvm.internal.impl.a.m)object) : null;
        return object == b.b.a || object == b.b.b;
        {
        }
    }

    public static final boolean isFunctionType(w object) {
        j.b(object, "$receiver");
        object = object.g().d();
        object = object != null ? FunctionTypesKt.getFunctionalClassKind((kotlin.reflect.jvm.internal.impl.a.m)object) : null;
        return object == b.b.a;
    }

    public static final boolean isSuspendFunctionType(w object) {
        j.b(object, "$receiver");
        object = object.g().d();
        object = object != null ? FunctionTypesKt.getFunctionalClassKind((kotlin.reflect.jvm.internal.impl.a.m)object) : null;
        return object == b.b.b;
    }
}

