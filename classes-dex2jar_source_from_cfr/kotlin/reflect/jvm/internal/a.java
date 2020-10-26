/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.d;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class a
extends d {
    private final List<Class<?>> b;
    private final List<Object> c;
    private final Class<?> d;
    private final List<String> e;
    private final a f;
    private final List<Method> g;

    public a(Class<?> object, List<String> iterator, a object2, b b2, List<Method> object3) {
        j.b(object, "jClass");
        j.b(iterator, "parameterNames");
        j.b(object2, "callMode");
        j.b((Object)b2, "origin");
        j.b(object3, "methods");
        Type type = (Type)object;
        Object object4 = (Iterable)object3;
        Type[] arrtype = (Type[])new ArrayList(m.a(object4, 10));
        object4 = object4.iterator();
        while (object4.hasNext()) {
            arrtype.add(((Method)object4.next()).getGenericReturnType());
        }
        if ((arrtype = ((Collection)((List)arrtype)).toArray(new Type[0])) != null) {
            super(null, type, null, arrtype);
            this.d = object;
            this.e = iterator;
            this.f = object2;
            this.g = object3;
            object = this.g;
            object2 = new ArrayList(m.a(object, 10));
            object3 = object.iterator();
            while (object3.hasNext()) {
                object = ((Method)object3.next()).getReturnType();
                j.a(object, "it");
                iterator = kotlin.reflect.jvm.internal.c.b.d(object);
                if (iterator != null) {
                    object = iterator;
                }
                object2.add(object);
            }
            this.b = (List)object2;
            iterator = this.g;
            object = new ArrayList(m.a(iterator, 10));
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                object.add(((Method)iterator.next()).getDefaultValue());
            }
            this.c = (List)object;
            if (this.f == a.b && b2 == b.a) {
                if (!(((Collection)m.c((Iterable)this.e, "value")).isEmpty() ^ true)) {
                    return;
                }
                throw (Throwable)new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
            return;
        }
        throw new t("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public /* synthetic */ a(Class class_, List list, a a2, b b2, List collection, int n2, g iterator) {
        if ((n2 & 16) != 0) {
            iterator = list;
            collection = new ArrayList(m.a(iterator, 10));
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                collection.add(class_.getDeclaredMethod((String)iterator.next(), new Class[0]));
            }
        }
        this(class_, list, a2, b2, (List<Method>)collection);
    }

    @Override
    public Object a(Object[] object) {
        j.b(object, "args");
        this.b((Object[])object);
        Collection collection = new ArrayList(((Object[])object).length);
        int n2 = ((Object[])object).length;
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            Object object2 = object[n3];
            object2 = object2 == null && this.f == a.a ? this.c.get(n4) : kotlin.reflect.jvm.internal.b.a(object2, this.b.get(n4));
            if (object2 != null) {
                collection.add(object2);
                ++n3;
                ++n4;
                continue;
            }
            kotlin.reflect.jvm.internal.b.a(n4, this.e.get(n4), this.b.get(n4));
            throw null;
        }
        object = (List)collection;
        return kotlin.reflect.jvm.internal.b.a(this.d, this.g, af.a(m.a((Iterable)this.e, (Iterable)object)));
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a;
        public static final /* enum */ a b;
        private static final /* synthetic */ a[] c;

        static {
            a a2;
            a a3;
            a = a2 = new a();
            b = a3 = new a();
            c = new a[]{a2, a3};
        }

        public static a valueOf(String string2) {
            return Enum.valueOf(a.class, string2);
        }

        public static a[] values() {
            return (a[])c.clone();
        }
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a;
        public static final /* enum */ b b;
        private static final /* synthetic */ b[] c;

        static {
            b b2;
            b b3;
            a = b2 = new b();
            b = b3 = new b();
            c = new b[]{b2, b3};
        }

        public static b valueOf(String string2) {
            return Enum.valueOf(b.class, string2);
        }

        public static b[] values() {
            return (b[])c.clone();
        }
    }

}

