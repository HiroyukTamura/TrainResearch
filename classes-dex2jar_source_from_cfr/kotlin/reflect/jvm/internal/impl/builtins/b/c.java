/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.a.b;
import kotlin.reflect.jvm.internal.impl.e.d;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.e.h;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.y;

public final class c {
    public static final c a;
    private static final String b;
    private static final String c;
    private static final kotlin.reflect.jvm.internal.impl.e.a d;
    private static final kotlin.reflect.jvm.internal.impl.e.b e;
    private static final kotlin.reflect.jvm.internal.impl.e.a f;
    private static final HashMap<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.a> g;
    private static final HashMap<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.a> h;
    private static final HashMap<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.b> i;
    private static final HashMap<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.b> j;
    private static final List<a> k;

    static {
        int n2;
        c c2;
        a = c2 = new c();
        Object object = new StringBuilder();
        ((StringBuilder)object).append(b.b.a.a().toString());
        ((StringBuilder)object).append(".");
        ((StringBuilder)object).append(b.b.a.b());
        b = ((StringBuilder)object).toString();
        object = new StringBuilder();
        ((StringBuilder)object).append(b.b.c.a().toString());
        ((StringBuilder)object).append(".");
        ((StringBuilder)object).append(b.b.c.b());
        c = ((StringBuilder)object).toString();
        d = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.jvm.functions.FunctionN"));
        e = d.g();
        f = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b("kotlin.reflect.KFunction"));
        g = new HashMap();
        h = new HashMap();
        i = new HashMap();
        j = new HashMap();
        object = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.iterable);
        j.a(object, "ClassId.topLevel(FQ_NAMES.iterable)");
        kotlin.reflect.jvm.internal.impl.e.b object22 = KotlinBuiltIns.FQ_NAMES.mutableIterable;
        j.a((Object)object22, "FQ_NAMES.mutableIterable");
        kotlin.reflect.jvm.internal.impl.e.b b2 = ((kotlin.reflect.jvm.internal.impl.e.a)object).a();
        Object object2 = ((kotlin.reflect.jvm.internal.impl.e.a)object).a();
        j.a(object2, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.e.b b3 = d.b(object22, (kotlin.reflect.jvm.internal.impl.e.b)object2);
        int n3 = 0;
        kotlin.reflect.jvm.internal.impl.e.a a2 = new kotlin.reflect.jvm.internal.impl.e.a(b2, b3, false);
        object = new a(c2.a(Iterable.class), (kotlin.reflect.jvm.internal.impl.e.a)object, a2);
        kotlin.reflect.jvm.internal.impl.e.a a3 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.iterator);
        j.a((Object)a3, "ClassId.topLevel(FQ_NAMES.iterator)");
        kotlin.reflect.jvm.internal.impl.e.b b4 = KotlinBuiltIns.FQ_NAMES.mutableIterator;
        j.a((Object)b4, "FQ_NAMES.mutableIterator");
        object2 = a3.a();
        Object object3 = a3.a();
        j.a(object3, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.e.a a4 = new kotlin.reflect.jvm.internal.impl.e.a((kotlin.reflect.jvm.internal.impl.e.b)object2, d.b(b4, (kotlin.reflect.jvm.internal.impl.e.b)object3), false);
        a a5 = new a(c2.a(Iterator.class), a3, a4);
        kotlin.reflect.jvm.internal.impl.e.a a6 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.collection);
        j.a((Object)a6, "ClassId.topLevel(FQ_NAMES.collection)");
        object2 = KotlinBuiltIns.FQ_NAMES.mutableCollection;
        j.a(object2, "FQ_NAMES.mutableCollection");
        object3 = a6.a();
        Object object4 = a6.a();
        j.a(object4, "kotlinReadOnly.packageFqName");
        object2 = new kotlin.reflect.jvm.internal.impl.e.a((kotlin.reflect.jvm.internal.impl.e.b)object3, d.b((kotlin.reflect.jvm.internal.impl.e.b)object2, (kotlin.reflect.jvm.internal.impl.e.b)object4), false);
        a a7 = new a(c2.a(Collection.class), a6, (kotlin.reflect.jvm.internal.impl.e.a)object2);
        object2 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.list);
        j.a(object2, "ClassId.topLevel(FQ_NAMES.list)");
        object3 = KotlinBuiltIns.FQ_NAMES.mutableList;
        j.a(object3, "FQ_NAMES.mutableList");
        object4 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).a();
        Object object5 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).a();
        j.a(object5, "kotlinReadOnly.packageFqName");
        object3 = new kotlin.reflect.jvm.internal.impl.e.a((kotlin.reflect.jvm.internal.impl.e.b)object4, d.b((kotlin.reflect.jvm.internal.impl.e.b)object3, (kotlin.reflect.jvm.internal.impl.e.b)object5), false);
        object2 = new a(c2.a(List.class), (kotlin.reflect.jvm.internal.impl.e.a)object2, (kotlin.reflect.jvm.internal.impl.e.a)object3);
        object3 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.set);
        j.a(object3, "ClassId.topLevel(FQ_NAMES.set)");
        object4 = KotlinBuiltIns.FQ_NAMES.mutableSet;
        j.a(object4, "FQ_NAMES.mutableSet");
        object5 = ((kotlin.reflect.jvm.internal.impl.e.a)object3).a();
        Object object6 = ((kotlin.reflect.jvm.internal.impl.e.a)object3).a();
        j.a(object6, "kotlinReadOnly.packageFqName");
        object4 = new kotlin.reflect.jvm.internal.impl.e.a((kotlin.reflect.jvm.internal.impl.e.b)object5, d.b((kotlin.reflect.jvm.internal.impl.e.b)object4, (kotlin.reflect.jvm.internal.impl.e.b)object6), false);
        object3 = new a(c2.a(Set.class), (kotlin.reflect.jvm.internal.impl.e.a)object3, (kotlin.reflect.jvm.internal.impl.e.a)object4);
        object4 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.listIterator);
        j.a(object4, "ClassId.topLevel(FQ_NAMES.listIterator)");
        object5 = KotlinBuiltIns.FQ_NAMES.mutableListIterator;
        j.a(object5, "FQ_NAMES.mutableListIterator");
        object6 = ((kotlin.reflect.jvm.internal.impl.e.a)object4).a();
        Object object7 = ((kotlin.reflect.jvm.internal.impl.e.a)object4).a();
        j.a(object7, "kotlinReadOnly.packageFqName");
        object5 = new kotlin.reflect.jvm.internal.impl.e.a((kotlin.reflect.jvm.internal.impl.e.b)object6, d.b((kotlin.reflect.jvm.internal.impl.e.b)object5, (kotlin.reflect.jvm.internal.impl.e.b)object7), false);
        object4 = new a(c2.a(ListIterator.class), (kotlin.reflect.jvm.internal.impl.e.a)object4, (kotlin.reflect.jvm.internal.impl.e.a)object5);
        object5 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.map);
        j.a(object5, "ClassId.topLevel(FQ_NAMES.map)");
        object6 = KotlinBuiltIns.FQ_NAMES.mutableMap;
        j.a(object6, "FQ_NAMES.mutableMap");
        object7 = ((kotlin.reflect.jvm.internal.impl.e.a)object5).a();
        kotlin.reflect.jvm.internal.impl.e.b b5 = ((kotlin.reflect.jvm.internal.impl.e.a)object5).a();
        j.a((Object)b5, "kotlinReadOnly.packageFqName");
        object6 = new kotlin.reflect.jvm.internal.impl.e.a((kotlin.reflect.jvm.internal.impl.e.b)object7, d.b((kotlin.reflect.jvm.internal.impl.e.b)object6, b5), false);
        object5 = new a(c2.a(Map.class), (kotlin.reflect.jvm.internal.impl.e.a)object5, (kotlin.reflect.jvm.internal.impl.e.a)object6);
        object6 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.map).a(KotlinBuiltIns.FQ_NAMES.mapEntry.e());
        j.a(object6, "ClassId.topLevel(FQ_NAME\u2026MES.mapEntry.shortName())");
        object7 = KotlinBuiltIns.FQ_NAMES.mutableMapEntry;
        j.a(object7, "FQ_NAMES.mutableMapEntry");
        b5 = ((kotlin.reflect.jvm.internal.impl.e.a)object6).a();
        kotlin.reflect.jvm.internal.impl.e.b b6 = ((kotlin.reflect.jvm.internal.impl.e.a)object6).a();
        j.a((Object)b6, "kotlinReadOnly.packageFqName");
        object7 = new kotlin.reflect.jvm.internal.impl.e.a(b5, d.b((kotlin.reflect.jvm.internal.impl.e.b)object7, b6), false);
        k = m.b(object, a5, a7, object2, object3, object4, object5, new a(c2.a(Map.Entry.class), (kotlin.reflect.jvm.internal.impl.e.a)object6, (kotlin.reflect.jvm.internal.impl.e.a)object7));
        object = KotlinBuiltIns.FQ_NAMES.any;
        j.a(object, "FQ_NAMES.any");
        c2.a(Object.class, (kotlin.reflect.jvm.internal.impl.e.c)object);
        object = KotlinBuiltIns.FQ_NAMES.string;
        j.a(object, "FQ_NAMES.string");
        c2.a(String.class, (kotlin.reflect.jvm.internal.impl.e.c)object);
        object = KotlinBuiltIns.FQ_NAMES.charSequence;
        j.a(object, "FQ_NAMES.charSequence");
        c2.a(CharSequence.class, (kotlin.reflect.jvm.internal.impl.e.c)object);
        object = KotlinBuiltIns.FQ_NAMES.throwable;
        j.a(object, "FQ_NAMES.throwable");
        c2.a(Throwable.class, (kotlin.reflect.jvm.internal.impl.e.b)object);
        object = KotlinBuiltIns.FQ_NAMES.cloneable;
        j.a(object, "FQ_NAMES.cloneable");
        c2.a(Cloneable.class, (kotlin.reflect.jvm.internal.impl.e.c)object);
        object = KotlinBuiltIns.FQ_NAMES.number;
        j.a(object, "FQ_NAMES.number");
        c2.a(Number.class, (kotlin.reflect.jvm.internal.impl.e.c)object);
        object = KotlinBuiltIns.FQ_NAMES.comparable;
        j.a(object, "FQ_NAMES.comparable");
        c2.a(Comparable.class, (kotlin.reflect.jvm.internal.impl.e.b)object);
        object = KotlinBuiltIns.FQ_NAMES._enum;
        j.a(object, "FQ_NAMES._enum");
        c2.a(Enum.class, (kotlin.reflect.jvm.internal.impl.e.c)object);
        object = KotlinBuiltIns.FQ_NAMES.annotation;
        j.a(object, "FQ_NAMES.annotation");
        c2.a(Annotation.class, (kotlin.reflect.jvm.internal.impl.e.b)object);
        object = k.iterator();
        while (object.hasNext()) {
            c2.a((a)object.next());
        }
        for (kotlin.reflect.jvm.internal.impl.h.d.c c3 : kotlin.reflect.jvm.internal.impl.h.d.c.values()) {
            kotlin.reflect.jvm.internal.impl.e.a a8 = kotlin.reflect.jvm.internal.impl.e.a.a(c3.d());
            j.a((Object)a8, "ClassId.topLevel(jvmType.wrapperFqName)");
            kotlin.reflect.jvm.internal.impl.e.a a9 = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.getPrimitiveFqName(c3.a()));
            j.a((Object)a9, "ClassId.topLevel(KotlinB\u2026e(jvmType.primitiveType))");
            c2.a(a8, a9);
        }
        for (kotlin.reflect.jvm.internal.impl.e.a a10 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.internal.");
            stringBuilder.append(a10.c().a());
            stringBuilder.append("CompanionObject");
            kotlin.reflect.jvm.internal.impl.e.a a11 = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b(stringBuilder.toString()));
            j.a((Object)a11, "ClassId.topLevel(FqName(\u2026g() + \"CompanionObject\"))");
            kotlin.reflect.jvm.internal.impl.e.a a12 = a10.a(h.c);
            j.a((Object)a12, "classId.createNestedClas\u2026AME_FOR_COMPANION_OBJECT)");
            c2.a(a11, a12);
        }
        for (n2 = 0; n2 < 23; ++n2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("kotlin.jvm.functions.Function");
            ((StringBuilder)object).append(n2);
            object = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b(((StringBuilder)object).toString()));
            j.a(object, "ClassId.topLevel(FqName(\u2026m.functions.Function$i\"))");
            kotlin.reflect.jvm.internal.impl.e.a a13 = KotlinBuiltIns.getFunctionClassId(n2);
            j.a((Object)a13, "KotlinBuiltIns.getFunctionClassId(i)");
            c2.a((kotlin.reflect.jvm.internal.impl.e.a)object, a13);
            object = new StringBuilder();
            ((StringBuilder)object).append(c);
            ((StringBuilder)object).append(n2);
            object = new kotlin.reflect.jvm.internal.impl.e.b(((StringBuilder)object).toString());
            kotlin.reflect.jvm.internal.impl.e.a a14 = f;
            j.a((Object)a14, "K_FUNCTION_CLASS_ID");
            c2.a((kotlin.reflect.jvm.internal.impl.e.b)object, a14);
        }
        for (n2 = n3; n2 < 22; ++n2) {
            object = b.b.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((b.b)((Object)object)).a().toString());
            stringBuilder.append(".");
            stringBuilder.append(((b.b)((Object)object)).b());
            object = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object);
            stringBuilder2.append(n2);
            object = new kotlin.reflect.jvm.internal.impl.e.b(stringBuilder2.toString());
            kotlin.reflect.jvm.internal.impl.e.a a15 = f;
            j.a((Object)a15, "K_FUNCTION_CLASS_ID");
            c2.a((kotlin.reflect.jvm.internal.impl.e.b)object, a15);
        }
        object = KotlinBuiltIns.FQ_NAMES.nothing.c();
        j.a(object, "FQ_NAMES.nothing.toSafe()");
        c2.a((kotlin.reflect.jvm.internal.impl.e.b)object, c2.a(Void.class));
    }

    private c() {
    }

    private final e a(e e2, Map<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.b> object, String string2) {
        kotlin.reflect.jvm.internal.impl.a.m m2 = e2;
        if ((object = object.get(kotlin.reflect.jvm.internal.impl.h.c.d(m2))) != null) {
            e2 = kotlin.reflect.jvm.internal.impl.h.c.a.d(m2).getBuiltInClassByFqName((kotlin.reflect.jvm.internal.impl.e.b)object);
            j.a((Object)e2, "descriptor.builtIns.getB\u2026Name(oppositeClassFqName)");
            return e2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Given class ");
        ((StringBuilder)object).append(e2);
        ((StringBuilder)object).append(" is not a ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" collection");
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public static /* bridge */ /* synthetic */ e a(c c2, kotlin.reflect.jvm.internal.impl.e.b b2, KotlinBuiltIns kotlinBuiltIns, Integer n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = null;
        }
        return c2.a(b2, kotlinBuiltIns, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final kotlin.reflect.jvm.internal.impl.e.a a(Class<?> object) {
        boolean bl2 = !((Class)object).isPrimitive() && !((Class)object).isArray();
        if (y.a && !bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid class: ");
            stringBuilder.append(object);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        Class<?> class_ = ((Class)object).getDeclaringClass();
        if (class_ == null) {
            class_ = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b(((Class)object).getCanonicalName()));
            object = "ClassId.topLevel(FqName(clazz.canonicalName))";
        } else {
            class_ = this.a(class_).a(f.a(((Class)object).getSimpleName()));
            object = "classId(outer).createNes\u2026tifier(clazz.simpleName))";
        }
        j.a((Object)class_, (String)object);
        return class_;
    }

    private final void a(Class<?> object, kotlin.reflect.jvm.internal.impl.e.b object2) {
        object = this.a((Class<?>)object);
        object2 = kotlin.reflect.jvm.internal.impl.e.a.a((kotlin.reflect.jvm.internal.impl.e.b)object2);
        j.a(object2, "ClassId.topLevel(kotlinFqName)");
        this.a((kotlin.reflect.jvm.internal.impl.e.a)object, (kotlin.reflect.jvm.internal.impl.e.a)object2);
    }

    private final void a(Class<?> class_, kotlin.reflect.jvm.internal.impl.e.c object) {
        object = ((kotlin.reflect.jvm.internal.impl.e.c)object).c();
        j.a(object, "kotlinFqName.toSafe()");
        this.a(class_, (kotlin.reflect.jvm.internal.impl.e.b)object);
    }

    private final void a(a object) {
        Object object2 = ((a)object).b();
        Object object3 = ((a)object).c();
        object = ((a)object).d();
        this.a((kotlin.reflect.jvm.internal.impl.e.a)object2, (kotlin.reflect.jvm.internal.impl.e.a)object3);
        kotlin.reflect.jvm.internal.impl.e.b b2 = ((kotlin.reflect.jvm.internal.impl.e.a)object).g();
        j.a((Object)b2, "mutableClassId.asSingleFqName()");
        this.a(b2, (kotlin.reflect.jvm.internal.impl.e.a)object2);
        object2 = ((kotlin.reflect.jvm.internal.impl.e.a)object3).g();
        object3 = ((kotlin.reflect.jvm.internal.impl.e.a)object).g();
        i.put(((kotlin.reflect.jvm.internal.impl.e.a)object).g().b(), (kotlin.reflect.jvm.internal.impl.e.b)object2);
        j.put(((kotlin.reflect.jvm.internal.impl.e.b)object2).b(), (kotlin.reflect.jvm.internal.impl.e.b)object3);
    }

    private final void a(kotlin.reflect.jvm.internal.impl.e.a a2, kotlin.reflect.jvm.internal.impl.e.a object) {
        this.b(a2, (kotlin.reflect.jvm.internal.impl.e.a)object);
        object = ((kotlin.reflect.jvm.internal.impl.e.a)object).g();
        j.a(object, "kotlinClassId.asSingleFqName()");
        this.a((kotlin.reflect.jvm.internal.impl.e.b)object, a2);
    }

    private final void a(kotlin.reflect.jvm.internal.impl.e.b b2, kotlin.reflect.jvm.internal.impl.e.a a2) {
        h.put(b2.b(), a2);
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.e.c object, String charSequence) {
        object = ((kotlin.reflect.jvm.internal.impl.e.c)object).a();
        j.a(object, "kotlinFqName.asString()");
        object = n.b((String)object, (String)charSequence, "");
        charSequence = (CharSequence)object;
        boolean bl2 = charSequence.length() > 0;
        if (bl2 && !n.a(charSequence, '0', false, 2, null)) {
            return (object = n.c((String)object)) != null && (Integer)object >= 23;
        }
        return false;
    }

    private final void b(kotlin.reflect.jvm.internal.impl.e.a a2, kotlin.reflect.jvm.internal.impl.e.a a3) {
        g.put(a2.g().b(), a3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Collection<e> a(kotlin.reflect.jvm.internal.impl.e.b collection, KotlinBuiltIns kotlinBuiltIns) {
        void var1_4;
        void var2_7;
        j.b(collection, "fqName");
        j.b(var2_7, "builtIns");
        e e2 = c.a(this, collection, (KotlinBuiltIns)var2_7, null, 4, null);
        if (e2 != null) {
            kotlin.reflect.jvm.internal.impl.e.b b2 = j.get(kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.m)e2));
            if (b2 != null) {
                List<e> list = Arrays.asList(e2, var2_7.getBuiltInClassByFqName(b2));
                j.a(list, "Arrays.asList(kotlinAnal\u2026tlinMutableAnalogFqName))");
                do {
                    return (Collection)var1_4;
                    break;
                } while (true);
            }
            Set<e> set = al.a(e2);
            return (Collection)var1_4;
        }
        Set set = al.a();
        return (Collection)var1_4;
    }

    public final List<a> a() {
        return k;
    }

    public final e a(kotlin.reflect.jvm.internal.impl.e.b object, KotlinBuiltIns kotlinBuiltIns, Integer n2) {
        j.b(object, "fqName");
        j.b(kotlinBuiltIns, "builtIns");
        object = n2 != null && j.a(object, (Object)e) ? KotlinBuiltIns.getFunctionClassId(n2) : this.a((kotlin.reflect.jvm.internal.impl.e.b)object);
        if (object != null) {
            return kotlinBuiltIns.getBuiltInClassByFqName(((kotlin.reflect.jvm.internal.impl.e.a)object).g());
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.e.a a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        return g.get(b2.b());
    }

    public final kotlin.reflect.jvm.internal.impl.e.a a(kotlin.reflect.jvm.internal.impl.e.c c2) {
        j.b(c2, "kotlinFqName");
        if (this.a(c2, b)) {
            return d;
        }
        if (this.a(c2, c)) {
            return f;
        }
        return h.get(c2);
    }

    public final boolean a(e e2) {
        j.b(e2, "mutable");
        return i.containsKey(kotlin.reflect.jvm.internal.impl.h.c.d(e2));
    }

    public final boolean a(w a2) {
        j.b(a2, "type");
        a2 = av.i(a2);
        return a2 != null && this.a((e)a2);
    }

    public final boolean b(e e2) {
        j.b(e2, "readOnly");
        return j.containsKey(kotlin.reflect.jvm.internal.impl.h.c.d(e2));
    }

    public final boolean b(w a2) {
        j.b(a2, "type");
        a2 = av.i(a2);
        return a2 != null && this.b((e)a2);
    }

    public final e c(e e2) {
        j.b(e2, "mutable");
        return this.a(e2, (Map<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.b>)i, "mutable");
    }

    public final e d(e e2) {
        j.b(e2, "readOnly");
        return this.a(e2, (Map<kotlin.reflect.jvm.internal.impl.e.c, kotlin.reflect.jvm.internal.impl.e.b>)j, "read-only");
    }

    public static final class a {
        private final kotlin.reflect.jvm.internal.impl.e.a a;
        private final kotlin.reflect.jvm.internal.impl.e.a b;
        private final kotlin.reflect.jvm.internal.impl.e.a c;

        public a(kotlin.reflect.jvm.internal.impl.e.a a2, kotlin.reflect.jvm.internal.impl.e.a a3, kotlin.reflect.jvm.internal.impl.e.a a4) {
            j.b(a2, "javaClass");
            j.b(a3, "kotlinReadOnly");
            j.b(a4, "kotlinMutable");
            this.a = a2;
            this.b = a3;
            this.c = a4;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a a() {
            return this.a;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a b() {
            return this.a;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a c() {
            return this.b;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a d() {
            return this.c;
        }

        public boolean equals(Object object) {
            block2 : {
                block3 : {
                    if (this == object) break block2;
                    if (!(object instanceof a)) break block3;
                    object = (a)object;
                    if (j.a((Object)this.a, (Object)((a)object).a) && j.a((Object)this.b, (Object)((a)object).b) && j.a((Object)this.c, (Object)((a)object).c)) break block2;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            kotlin.reflect.jvm.internal.impl.e.a a2 = this.a;
            int n2 = 0;
            int n3 = a2 != null ? ((Object)a2).hashCode() : 0;
            a2 = this.b;
            int n4 = a2 != null ? ((Object)a2).hashCode() : 0;
            a2 = this.c;
            if (a2 != null) {
                n2 = ((Object)a2).hashCode();
            }
            return (n3 * 31 + n4) * 31 + n2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PlatformMutabilityMapping(javaClass=");
            stringBuilder.append(this.a);
            stringBuilder.append(", kotlinReadOnly=");
            stringBuilder.append(this.b);
            stringBuilder.append(", kotlinMutable=");
            stringBuilder.append(this.c);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

}

