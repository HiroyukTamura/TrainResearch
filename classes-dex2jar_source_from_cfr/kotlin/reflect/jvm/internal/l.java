/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.i.i;
import kotlin.i.k;
import kotlin.reflect.jvm.internal.a.j;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ab;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ag;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.h.e.j;
import kotlin.reflect.jvm.internal.m;
import kotlin.reflect.jvm.internal.n;
import kotlin.reflect.jvm.internal.o;
import kotlin.reflect.jvm.internal.p;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.t;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.jvm.internal.v;
import kotlin.w;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\b \u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J \u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u0012\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020)H&J\"\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0004J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u001a\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00103\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00104\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020)H\u0002J@\u00107\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J0\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\u0006\u0010;\u001a\u00020\u0013H\u0002JE\u0010<\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0=2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010;\u001a\u00020\u0013H\u0002\u00a2\u0006\u0002\u0010>R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006B"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "isPublic", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "returnType", "tryGetConstructor", "declared", "tryGetMethod", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public abstract class l
implements kotlin.e.b.d {
    private static final Class<?> a;
    public static final a b;
    private static final k c;

    static {
        b = new a(null);
        a = Class.forName("kotlin.e.b.g");
        c = new k("<v#(\\d+)>");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final Class<?> a(String var1_1, int var2_2, int var3_3) {
        switch (var1_1.charAt(var2_2)) {
            default: {
                var4_4 = new StringBuilder();
                var4_4.append("Unknown type prefix in the method signature: ");
                var4_4.append((String)var1_1);
                throw (Throwable)new aa(var4_4.toString());
            }
            case '[': {
                return kotlin.reflect.jvm.internal.c.b.g(this.a((String)var1_1, var2_2 + 1, var3_3));
            }
            case 'Z': {
                return Boolean.TYPE;
            }
            case 'V': {
                var1_1 = Void.TYPE;
                var4_5 = "Void.TYPE";
                ** GOTO lbl24
            }
            case 'S': {
                return Short.TYPE;
            }
            case 'L': {
                var4_5 = kotlin.reflect.jvm.internal.c.b.a(this.a());
                if (var1_1 == null) throw new kotlin.t("null cannot be cast to non-null type java.lang.String");
                var1_1 = var1_1.substring(var2_2 + 1, var3_3 - 1);
                kotlin.e.b.j.a((Object)var1_1, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                var1_1 = var4_5.loadClass(kotlin.i.n.a((String)var1_1, '/', '.', false, 4, null));
                var4_5 = "jClass.safeClassLoader.l\u2026d - 1).replace('/', '.'))";
lbl24: // 2 sources:
                kotlin.e.b.j.a(var1_1, (String)var4_5);
                return var1_1;
            }
            case 'J': {
                return Long.TYPE;
            }
            case 'I': {
                return Integer.TYPE;
            }
            case 'F': {
                return Float.TYPE;
            }
            case 'D': {
                return Double.TYPE;
            }
            case 'C': {
                return Character.TYPE;
            }
            case 'B': 
        }
        return Byte.TYPE;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private final Constructor<?> a(Class<?> var1_1, List<? extends Class<?>> var2_3, boolean var3_4) {
        if (!var3_4) ** GOTO lbl7
        try {
            if (var2_3 == null) throw new kotlin.t("null cannot be cast to non-null type java.util.Collection<T>");
            if ((var2_3 = var2_3.toArray(new Class[0])) == null) throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
            var2_3 = (Class[])var2_3;
            return var1_1.getDeclaredConstructor((Class[])Arrays.copyOf(var2_3, ((Collection<Class<Object>>)var2_3).length));
lbl7: // 1 sources:
            if (var2_3 == null) throw new kotlin.t("null cannot be cast to non-null type java.util.Collection<T>");
            if ((var2_3 = var2_3.toArray(new Class[0])) == null) throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
            var2_3 = (Class[])var2_3;
            return var1_1.getConstructor((Class[])Arrays.copyOf(var2_3, ((Collection<Class<Object>>)var2_3).length));
        }
        catch (NoSuchMethodException var1_2) {
            return null;
        }
    }

    private final Method a(Class<?> genericDeclaration, String string2, List<? extends Class<?>> object, Class<?> class_, boolean bl2) {
        Object object2 = (Class[])object;
        if (object2 != null) {
            if ((object2 = object2.toArray(new Class[0])) != null) {
                Class[] arrclass = object2;
                object2 = genericDeclaration;
                if (bl2) {
                    object2 = this.a((Class<?>)genericDeclaration, string2, arrclass, class_, false);
                    if (object2 != null) {
                        return object2;
                    }
                    object2 = genericDeclaration;
                    if (((Class)genericDeclaration).isInterface()) {
                        object = this.a((Class<?>)Object.class, string2, (List<? extends Class<?>>)object, class_, bl2);
                        object2 = genericDeclaration;
                        if (object != null) {
                            return object;
                        }
                    }
                }
                while (object2 != null) {
                    genericDeclaration = this.a((Class<?>)object2, string2, arrclass, class_, true);
                    if (genericDeclaration != null) {
                        return genericDeclaration;
                    }
                    object2 = ((Class)object2).getSuperclass();
                }
                return null;
            }
            throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new kotlin.t("null cannot be cast to non-null type java.util.Collection<T>");
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private final Method a(Class<?> var1_1, String var2_3, Class<?>[] var3_4, Class<?> var4_5, boolean var5_6) {
        if (!var5_6) ** GOTO lbl5
        try {
            block8 : {
                var9_7 = var1_1.getDeclaredMethod(var2_3, Arrays.copyOf(var3_4, var3_4.length));
                break block8;
lbl5: // 1 sources:
                var9_7 = var1_1.getMethod(var2_3, Arrays.copyOf(var3_4, var3_4.length));
            }
            kotlin.e.b.j.a((Object)var9_7, "result");
            if (kotlin.e.b.j.a(var9_7.getReturnType(), var4_5)) {
                return var9_7;
            }
            var1_1 = var5_6 != false ? var1_1.getDeclaredMethods() : var1_1.getMethods();
            kotlin.e.b.j.a((Object)var1_1, "allMethods");
            var8_8 = var1_1.length;
            var6_9 = 0;
            while (var6_9 < var8_8) {
                var9_7 = var1_1[var6_9];
                kotlin.e.b.j.a((Object)var9_7, "method");
                if (!kotlin.e.b.j.a((Object)var9_7.getName(), (Object)var2_3) || !kotlin.e.b.j.a(var9_7.getReturnType(), var4_5)) ** GOTO lbl-1000
                var10_11 = var9_7.getParameterTypes();
                if (var10_11 == null) {
                    kotlin.e.b.j.a();
                }
                if (var5_6 = Arrays.equals(var10_11, var3_4)) {
                    var7_10 = true;
                } else lbl-1000: // 2 sources:
                {
                    var7_10 = false;
                }
                if (var7_10) {
                    return var9_7;
                }
                ++var6_9;
            }
            return null;
        }
        catch (NoSuchMethodException var1_2) {
            return null;
        }
    }

    private final List<Class<?>> a(String string2) {
        Serializable serializable = new ArrayList();
        int n2 = 1;
        while (string2.charAt(n2) != ')') {
            block6 : {
                int n3;
                block5 : {
                    char c2;
                    block4 : {
                        n3 = n2;
                        while (string2.charAt(n3) == '[') {
                            ++n3;
                        }
                        c2 = string2.charAt(n3);
                        if (!kotlin.i.n.c((CharSequence)"VZCBSIFJD", c2, false, 2, null)) break block4;
                        ++n3;
                        break block5;
                    }
                    if (c2 != 'L') break block6;
                    n3 = kotlin.i.n.a((CharSequence)string2, ';', n2, false, 4, null) + 1;
                }
                ((ArrayList)serializable).add(this.a(string2, n2, n3));
                n2 = n3;
                continue;
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Unknown type prefix in the method signature: ");
            ((StringBuilder)serializable).append(string2);
            throw (Throwable)new aa(((StringBuilder)serializable).toString());
        }
        return (List)((Object)serializable);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final v<?> a(ai v2) {
        Object object;
        block13 : {
            void var1_3;
            int n2;
            block12 : {
                object = v2.e();
                int n3 = 0;
                n2 = object != null ? 1 : 0;
                if (v2.d() != null) {
                    n3 = 1;
                }
                n2 += n3;
                if (!v2.s()) break block12;
                switch (n2) {
                    default: {
                        break block13;
                    }
                    case 2: {
                        p p2 = new p(this, (ai)((Object)v2));
                    }
                    case 1: {
                        o o2 = new o(this, (ai)((Object)v2));
                        return (v)var1_3;
                    }
                    case 0: {
                        n n4 = new n(this, (ai)((Object)v2));
                        return (v)var1_3;
                    }
                }
                return (v)var1_3;
            }
            switch (n2) {
                default: {
                    break;
                }
                case 2: {
                    u u2 = new u(this, (ai)((Object)v2));
                    return (v)var1_3;
                }
                case 1: {
                    t t2 = new t(this, (ai)((Object)v2));
                    return (v)var1_3;
                }
                case 0: {
                    s s2 = new s(this, (ai)((Object)v2));
                    return (v)var1_3;
                }
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unsupported property: ");
        ((StringBuilder)object).append(v2);
        throw (Throwable)new aa(((StringBuilder)object).toString());
    }

    private final void a(List<Class<?>> list, String class_, boolean bl2) {
        class_ = this.a((String)((Object)class_));
        list.addAll((Collection)((Object)class_));
        int n2 = (class_.size() + 32 - 1) / 32;
        for (int i2 = 0; i2 < n2; ++i2) {
            class_ = Integer.TYPE;
            kotlin.e.b.j.a(class_, "Integer.TYPE");
            list.add(class_);
        }
        class_ = bl2 ? a : Object.class;
        kotlin.e.b.j.a(class_, "if (isConstructor) DEFAU\u2026RKER else Any::class.java");
        list.add(class_);
    }

    private final Class<?> b(String string2) {
        return this.a(string2, kotlin.i.n.a((CharSequence)string2, ')', 0, false, 6, null) + 1, string2.length());
    }

    public final Constructor<?> a(String string2, boolean bl2) {
        kotlin.e.b.j.b(string2, "desc");
        return this.a(this.a(), this.a(string2), bl2 ^ true);
    }

    public final Method a(String string2, String string3, boolean bl2) {
        kotlin.e.b.j.b(string2, "name");
        kotlin.e.b.j.b(string3, "desc");
        if (kotlin.e.b.j.a((Object)string2, (Object)"<init>")) {
            return null;
        }
        return this.a(this.l(), string2, this.a(string3), this.b(string3), bl2);
    }

    public final Method a(String string2, String string3, boolean bl2, boolean bl3) {
        kotlin.e.b.j.b(string2, "name");
        kotlin.e.b.j.b(string3, "desc");
        if (kotlin.e.b.j.a((Object)string2, (Object)"<init>")) {
            return null;
        }
        ArrayList<Class<?>> arrayList = new ArrayList();
        if (bl2) {
            arrayList.add(this.a());
        }
        arrayList = arrayList;
        this.a(arrayList, string3, false);
        Class<?> class_ = this.l();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("$default");
        return this.a(class_, stringBuilder.toString(), arrayList, this.b(string3), bl3);
    }

    public abstract Collection<ai> a(kotlin.reflect.jvm.internal.impl.e.f var1);

    protected final Collection<h<?>> a(kotlin.reflect.jvm.internal.impl.h.e.h object, c c2) {
        kotlin.e.b.j.b(object, "scope");
        kotlin.e.b.j.b((Object)((Object)c2), "belonginess");
        kotlin.reflect.jvm.internal.impl.a.c.l<h<?>, w> l2 = new kotlin.reflect.jvm.internal.impl.a.c.l<h<?>, w>(){

            @Override
            public h<?> a(ai ai2, w w2) {
                kotlin.e.b.j.b(ai2, "descriptor");
                kotlin.e.b.j.b(w2, "data");
                return this.a(ai2);
            }

            @Override
            public h<?> a(kotlin.reflect.jvm.internal.impl.a.l l2, w object) {
                kotlin.e.b.j.b(l2, "descriptor");
                kotlin.e.b.j.b(object, "data");
                object = new StringBuilder();
                ((StringBuilder)object).append("No constructors should appear in this scope: ");
                ((StringBuilder)object).append(l2);
                throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
            }

            @Override
            public h<?> a(kotlin.reflect.jvm.internal.impl.a.t t2, w w2) {
                kotlin.e.b.j.b(t2, "descriptor");
                kotlin.e.b.j.b(w2, "data");
                return new m(this, t2);
            }
        };
        object = j.a.a((kotlin.reflect.jvm.internal.impl.h.e.j)object, null, null, 3, null);
        Collection collection = new ArrayList<E>();
        Iterator<T> iterator = object.iterator();
        while (iterator.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.b b2;
            object = (kotlin.reflect.jvm.internal.impl.a.m)iterator.next();
            object = object instanceof kotlin.reflect.jvm.internal.impl.a.b && kotlin.e.b.j.a((Object)(b2 = (kotlin.reflect.jvm.internal.impl.a.b)object).p(), (Object)az.h) ^ true && c2.a(b2) ? (h)object.a(l2, w.a) : null;
            if (object == null) continue;
            collection.add(object);
        }
        return kotlin.a.m.k((List)collection);
    }

    public abstract ai a(int var1);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final ai a(String charSequence, String object) {
        Object object2;
        kotlin.e.b.j.b(charSequence, "name");
        kotlin.e.b.j.b(object, "signature");
        Object object3 = c.b((CharSequence)object);
        boolean bl2 = true;
        if (object3 != null) {
            charSequence = object3.b().a().a().get(1);
            object = this.a(Integer.parseInt((String)charSequence));
            if (object != null) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Local property #");
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(" not found in ");
            ((StringBuilder)object).append(this.a());
            throw (Throwable)new aa(((StringBuilder)object).toString());
        }
        object3 = kotlin.reflect.jvm.internal.impl.e.f.a((String)charSequence);
        kotlin.e.b.j.a(object3, "Name.identifier(name)");
        Object object4 = this.a((kotlin.reflect.jvm.internal.impl.e.f)object3);
        object3 = new ArrayList<E>();
        object4 = object4.iterator();
        while (object4.hasNext()) {
            E e2 = object4.next();
            object2 = (ai)e2;
            if (!kotlin.e.b.j.a((Object)ag.a.a((ai)object2).a(), object)) continue;
            object3.add(e2);
        }
        if (!(object3 = (List)object3).isEmpty()) {
            if (object3.size() != 1) {
                object3 = (Iterable)object3;
                Map map = new LinkedHashMap<K, V>();
                object2 = object3.iterator();
                while (object2.hasNext()) {
                    E e3 = object2.next();
                    ba ba2 = ((ai)e3).p();
                    object3 = object4 = map.get(ba2);
                    if (object4 == null) {
                        object3 = new ArrayList<E>();
                        map.put(ba2, object3);
                    }
                    ((List)object3).add(e3);
                }
                object3 = af.a(map, f.a).values();
                kotlin.e.b.j.a(object3, "properties\n             \u2026                }).values");
                object3 = (List)kotlin.a.m.d((Iterable)object3);
                if (object3.size() == 1) {
                    kotlin.e.b.j.a(object3, "mostVisibleProperties");
                    charSequence = kotlin.a.m.f(object3);
                    do {
                        return (ai)((Object)charSequence);
                        break;
                    } while (true);
                }
                object3 = kotlin.reflect.jvm.internal.impl.e.f.a((String)charSequence);
                kotlin.e.b.j.a(object3, "Name.identifier(name)");
                object4 = kotlin.a.m.a(this.a((kotlin.reflect.jvm.internal.impl.e.f)object3), "\n", null, null, 0, null, e.a, 30, null);
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Property '");
                ((StringBuilder)object3).append((String)charSequence);
                ((StringBuilder)object3).append("' (JVM signature: ");
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(") not resolved in ");
                ((StringBuilder)object3).append(this);
                ((StringBuilder)object3).append(':');
                if (((CharSequence)object4).length() != 0) {
                    bl2 = false;
                }
                if (bl2) {
                    charSequence = " no members found";
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append('\n');
                    ((StringBuilder)charSequence).append((String)object4);
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                ((StringBuilder)object3).append((String)charSequence);
                throw (Throwable)new aa(((StringBuilder)object3).toString());
            }
            charSequence = kotlin.a.m.j(object3);
            return (ai)((Object)charSequence);
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Property '");
        ((StringBuilder)object3).append((String)charSequence);
        ((StringBuilder)object3).append("' (JVM signature: ");
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(") not resolved in ");
        ((StringBuilder)object3).append(this);
        throw (Throwable)new aa(((StringBuilder)object3).toString());
    }

    public final Constructor<?> b(String string2, boolean bl2) {
        kotlin.e.b.j.b(string2, "desc");
        List list = new ArrayList<E>();
        this.a(list, string2, true);
        return this.a(this.a(), list, bl2 ^ true);
    }

    public abstract Collection<kotlin.reflect.jvm.internal.impl.a.l> b();

    public abstract Collection<kotlin.reflect.jvm.internal.impl.a.t> b(kotlin.reflect.jvm.internal.impl.e.f var1);

    public final kotlin.reflect.jvm.internal.impl.a.t b(String charSequence, String string2) {
        Object object;
        kotlin.e.b.j.b(charSequence, "name");
        kotlin.e.b.j.b(string2, "signature");
        if (kotlin.e.b.j.a((Object)charSequence, (Object)"<init>")) {
            object = kotlin.a.m.k((Iterable)this.b());
        } else {
            object = kotlin.reflect.jvm.internal.impl.e.f.a((String)charSequence);
            kotlin.e.b.j.a(object, "Name.identifier(name)");
            object = this.b((kotlin.reflect.jvm.internal.impl.e.f)object);
        }
        object = (Iterable)object;
        Object object2 = new ArrayList<E>();
        Iterator<T> iterator = object.iterator();
        while (iterator.hasNext()) {
            T t2 = iterator.next();
            kotlin.reflect.jvm.internal.impl.a.t t3 = (kotlin.reflect.jvm.internal.impl.a.t)t2;
            if (!kotlin.e.b.j.a((Object)ag.a.a(t3).a(), (Object)string2)) continue;
            object2.add(t2);
        }
        object2 = (List)object2;
        int n2 = object2.size();
        boolean bl2 = true;
        if (n2 != 1) {
            object2 = kotlin.a.m.a(object, "\n", null, null, 0, null, d.a, 30, null);
            object = new StringBuilder();
            ((StringBuilder)object).append("Function '");
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append("' (JVM signature: ");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(") not resolved in ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(':');
            if (((CharSequence)object2).length() != 0) {
                bl2 = false;
            }
            if (bl2) {
                charSequence = " no members found";
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append('\n');
                ((StringBuilder)charSequence).append((String)object2);
                charSequence = ((StringBuilder)charSequence).toString();
            }
            ((StringBuilder)object).append((String)charSequence);
            throw (Throwable)new aa(((StringBuilder)object).toString());
        }
        return (kotlin.reflect.jvm.internal.impl.a.t)kotlin.a.m.j(object2);
    }

    protected Class<?> l() {
        Class<?> class_ = kotlin.reflect.jvm.internal.c.b.d(this.a());
        if (class_ != null) {
            return class_;
        }
        return this.a();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflect_api", "()Lkotlin/text/Regex;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        public final k a() {
            return c;
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00a6\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "getModuleData", "()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public abstract class b {
        static final /* synthetic */ kotlin.reflect.l[] c;
        private final ac.a a = ac.b((kotlin.e.a.a)new kotlin.e.a.a<j>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final j b() {
                return ab.a(l.this.a());
            }
        });

        static {
            c = new kotlin.reflect.l[]{kotlin.e.b.v.a(new kotlin.e.b.t(kotlin.e.b.v.a(b.class), "moduleData", "getModuleData()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;"))};
        }

        public final j i() {
            return (j)this.a.a(this, c[0]);
        }

    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    protected static final class c
    extends Enum<c> {
        public static final /* enum */ c a;
        public static final /* enum */ c b;
        private static final /* synthetic */ c[] c;

        static {
            c c2;
            c c3;
            a = c2 = new c();
            b = c3 = new c();
            c = new c[]{c2, c3};
        }

        public static c valueOf(String string2) {
            return Enum.valueOf(c.class, string2);
        }

        public static c[] values() {
            return (c[])c.clone();
        }

        public final boolean a(kotlin.reflect.jvm.internal.impl.a.b object) {
            kotlin.e.b.j.b(object, "member");
            object = object.n();
            kotlin.e.b.j.a(object, "member.kind");
            boolean bl2 = ((b.a)((Object)object)).a();
            object = this;
            c c2 = a;
            boolean bl3 = false;
            boolean bl4 = object == c2;
            if (bl2 == bl4) {
                bl3 = true;
            }
            return bl3;
        }
    }

}

