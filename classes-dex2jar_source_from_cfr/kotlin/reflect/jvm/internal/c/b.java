/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.d;
import kotlin.e.a.e;
import kotlin.e.a.l;
import kotlin.e.a.o;
import kotlin.e.a.p;
import kotlin.e.a.q;
import kotlin.e.a.r;
import kotlin.e.a.u;
import kotlin.e.a.w;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.h.h;
import kotlin.h.i;
import kotlin.i.n;
import kotlin.reflect.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.s;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000J\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010#\u001a\u0006\u0012\u0002\b\u00030\u0002*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010$\u001a\u00020%*\u0006\u0012\u0002\b\u00030\u0002\"&\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\",\u0010\t\u001a \u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\",\u0010\n\u001a \u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0002\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0019\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006*\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u001f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0019\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001c\u00a8\u0006&"}, d2={"FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "PRIMITIVE_CLASSES", "", "Lkotlin/reflect/KClass;", "", "PRIMITIVE_TO_WRAPPER", "WRAPPER_TO_PRIMITIVE", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/name/ClassId;", "desc", "", "getDesc", "(Ljava/lang/Class;)Ljava/lang/String;", "functionClassArity", "getFunctionClassArity", "(Ljava/lang/Class;)Ljava/lang/Integer;", "parameterizedTypeArguments", "Ljava/lang/reflect/Type;", "getParameterizedTypeArguments", "(Ljava/lang/reflect/Type;)Ljava/util/List;", "primitiveByWrapper", "getPrimitiveByWrapper", "(Ljava/lang/Class;)Ljava/lang/Class;", "safeClassLoader", "Ljava/lang/ClassLoader;", "getSafeClassLoader", "(Ljava/lang/Class;)Ljava/lang/ClassLoader;", "wrapperByPrimitive", "getWrapperByPrimitive", "createArrayType", "isEnumClassOrSpecializedEnumEntryClass", "", "descriptors.runtime"}, k=2, mv={1, 1, 11})
public final class b {
    private static final List<c<? extends Object>> a;
    private static final Map<Class<? extends Object>, Class<? extends Object>> b;
    private static final Map<Class<? extends Object>, Class<? extends Object>> c;
    private static final Map<Class<? extends d<?>>, Integer> d;

    static {
        c c2;
        Object object = v.a(Boolean.TYPE);
        int n2 = 0;
        a = m.b(object, v.a(Byte.TYPE), v.a(Character.TYPE), v.a(Double.TYPE), v.a(Float.TYPE), v.a(Integer.TYPE), v.a(Long.TYPE), v.a(Short.TYPE));
        Iterator iterator = a;
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            c2 = (c)iterator.next();
            object.add(s.a(kotlin.e.a.c(c2), kotlin.e.a.b(c2)));
        }
        b = af.a((List)object);
        iterator = a;
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            c2 = (c)iterator.next();
            object.add(s.a(kotlin.e.a.b(c2), kotlin.e.a.c(c2)));
        }
        c = af.a((List)object);
        iterator = m.b(kotlin.e.a.a.class, kotlin.e.a.b.class, kotlin.e.a.m.class, q.class, r.class, kotlin.e.a.s.class, kotlin.e.a.t.class, u.class, kotlin.e.a.v.class, w.class, kotlin.e.a.c.class, kotlin.e.a.d.class, e.class, kotlin.e.a.f.class, kotlin.e.a.g.class, kotlin.e.a.h.class, kotlin.e.a.i.class, kotlin.e.a.j.class, kotlin.e.a.k.class, l.class, kotlin.e.a.n.class, o.class, p.class);
        object = new ArrayList(m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object.add(s.a((Class)iterator.next(), n2));
            ++n2;
        }
        d = af.a((List)object);
    }

    public static final ClassLoader a(Class<?> object) {
        j.b(object, "$receiver");
        object = ((Class)object).getClassLoader();
        if (object != null) {
            return object;
        }
        object = ClassLoader.getSystemClassLoader();
        j.a(object, "ClassLoader.getSystemClassLoader()");
        return object;
    }

    public static final List<Type> a(Type arrtype) {
        j.b(arrtype, "$receiver");
        if (!(arrtype instanceof ParameterizedType)) {
            return m.a();
        }
        ParameterizedType parameterizedType = (ParameterizedType)arrtype;
        if (parameterizedType.getOwnerType() == null) {
            arrtype = parameterizedType.getActualTypeArguments();
            j.a((Object)arrtype, "actualTypeArguments");
            return g.h(arrtype);
        }
        return i.e(i.d(i.a(arrtype, a.a), b.a));
    }

    public static final boolean b(Class<?> class_) {
        j.b(class_, "$receiver");
        return Enum.class.isAssignableFrom(class_);
    }

    public static final Class<?> c(Class<?> class_) {
        j.b(class_, "$receiver");
        return b.get(class_);
    }

    public static final Class<?> d(Class<?> class_) {
        j.b(class_, "$receiver");
        return c.get(class_);
    }

    public static final kotlin.reflect.jvm.internal.impl.e.a e(Class<?> object) {
        j.b(object, "$receiver");
        if (!((Class)object).isPrimitive()) {
            if (!((Class)object).isArray()) {
                if (((Class)object).getEnclosingMethod() == null && ((Class)object).getEnclosingConstructor() == null) {
                    Class<?> class_ = ((Class)object).getSimpleName();
                    j.a((Object)class_, "simpleName");
                    boolean bl2 = ((CharSequence)((Object)class_)).length() == 0;
                    if (!bl2) {
                        class_ = ((Class)object).getDeclaringClass();
                        if (class_ != null && (class_ = b.e(class_)) != null && (class_ = ((kotlin.reflect.jvm.internal.impl.e.a)((Object)class_)).a(f.a(((Class)object).getSimpleName()))) != null) {
                            return class_;
                        }
                        object = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b(((Class)object).getName()));
                        j.a(object, "ClassId.topLevel(FqName(name))");
                        return object;
                    }
                }
                object = new kotlin.reflect.jvm.internal.impl.e.b(((Class)object).getName());
                return new kotlin.reflect.jvm.internal.impl.e.a(((kotlin.reflect.jvm.internal.impl.e.b)object).d(), kotlin.reflect.jvm.internal.impl.e.b.c(((kotlin.reflect.jvm.internal.impl.e.b)object).e()), true);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't compute ClassId for array type: ");
            stringBuilder.append(object);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't compute ClassId for primitive type: ");
        stringBuilder.append(object);
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public static final String f(Class<?> object) {
        j.b(object, "$receiver");
        if (j.a(object, Void.TYPE)) {
            return "V";
        }
        object = b.g(object).getName();
        j.a(object, "createArrayType().name");
        if (object != null) {
            object = ((String)object).substring(1);
            j.a(object, "(this as java.lang.String).substring(startIndex)");
            return n.a((String)object, '.', '/', false, 4, null);
        }
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    public static final Class<?> g(Class<?> class_) {
        j.b(class_, "$receiver");
        return Array.newInstance(class_, 0).getClass();
    }

}

