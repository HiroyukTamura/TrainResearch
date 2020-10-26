/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.a.a;
import kotlin.reflect.jvm.internal.a.h;
import kotlin.reflect.jvm.internal.a.m;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.c.b.n;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\u0019"}, d2={"Lkotlin/reflect/jvm/internal/components/ReflectClassStructure;", "", "()V", "loadClassAnnotations", "", "klass", "Ljava/lang/Class;", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "loadConstructorAnnotations", "memberVisitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "loadFieldAnnotations", "loadMethodAnnotations", "processAnnotation", "annotation", "", "processAnnotationArgumentValue", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationArgumentVisitor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "processAnnotationArguments", "annotationType", "visitMembers", "descriptors.runtime"}, k=1, mv={1, 1, 11})
final class b {
    public static final b a = new b();

    private b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void a(n.a a2, Annotation annotation, Class<?> arrmethod) {
        arrmethod = arrmethod.getDeclaredMethods();
        int n2 = arrmethod.length;
        int n3 = 0;
        do {
            Method method;
            Object object;
            block4 : {
                if (n3 >= n2) {
                    a2.a();
                    return;
                }
                method = arrmethod[n3];
                try {
                    object = method.invoke(annotation, new Object[0]);
                    if (object != null) break block4;
                    j.a();
                }
                catch (IllegalAccessException illegalAccessException) {}
            }
            j.a((Object)method, "method");
            f f2 = f.a(method.getName());
            j.a((Object)f2, "Name.identifier(method.name)");
            this.a(a2, f2, object);
            ++n3;
        } while (true);
    }

    private final void a(n.a object, f arrobject, Object arrobject2) {
        Object object22;
        block11 : {
            block12 : {
                block16 : {
                    block15 : {
                        block13 : {
                            block14 : {
                                object22 = arrobject2.getClass();
                                if (h.a().contains(object22)) {
                                    object.a((f)arrobject, arrobject2);
                                    return;
                                }
                                if (kotlin.reflect.jvm.internal.c.b.b(object22)) {
                                    if (!((Class)object22).isEnum()) {
                                        object22 = ((Class)object22).getEnclosingClass();
                                    }
                                    j.a(object22, "(if (clazz.isEnum) clazz\u2026lse clazz.enclosingClass)");
                                    object22 = kotlin.reflect.jvm.internal.c.b.e(object22);
                                    if (arrobject2 != null) {
                                        arrobject2 = f.a(((Enum)arrobject2).name());
                                        j.a((Object)arrobject2, "Name.identifier((value as Enum<*>).name)");
                                        object.a((f)arrobject, (kotlin.reflect.jvm.internal.impl.e.a)object22, (f)arrobject2);
                                        return;
                                    }
                                    throw new t("null cannot be cast to non-null type kotlin.Enum<*>");
                                }
                                if (Annotation.class.isAssignableFrom((Class<?>)object22)) {
                                    object22 = ((Class)object22).getInterfaces();
                                    j.a(object22, "clazz.interfaces");
                                    object22 = g.f(object22);
                                    j.a(object22, "annotationClass");
                                    object = object.a((f)arrobject, kotlin.reflect.jvm.internal.c.b.e(object22));
                                    if (object != null) {
                                        if (arrobject2 != null) {
                                            this.a((n.a)object, (Annotation)arrobject2, (Class<?>)object22);
                                            return;
                                        }
                                        throw new t("null cannot be cast to non-null type kotlin.Annotation");
                                    }
                                    return;
                                }
                                if (!((Class)object22).isArray()) break block11;
                                if ((object = object.a((f)arrobject)) == null) break block12;
                                arrobject = ((Class)object22).getComponentType();
                                j.a((Object)arrobject, "componentType");
                                boolean bl2 = arrobject.isEnum();
                                int n2 = 0;
                                if (!bl2) break block13;
                                arrobject = kotlin.reflect.jvm.internal.c.b.e(arrobject);
                                if (arrobject2 == null) break block14;
                                for (Object object22 : (Object[])arrobject2) {
                                    if (object22 != null) {
                                        object22 = f.a(((Enum)object22).name());
                                        j.a(object22, "Name.identifier((element as Enum<*>).name)");
                                        object.a((kotlin.reflect.jvm.internal.impl.e.a)arrobject, (f)object22);
                                        continue;
                                    }
                                    throw new t("null cannot be cast to non-null type kotlin.Enum<*>");
                                }
                                break block15;
                            }
                            throw new t("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                        if (arrobject2 != null) {
                            arrobject = arrobject2;
                            int n3 = arrobject.length;
                            for (int i2 = n2; i2 < n3; ++i2) {
                                object.a(arrobject[i2]);
                            }
                        }
                        break block16;
                    }
                    object.a();
                    return;
                }
                throw new t("null cannot be cast to non-null type kotlin.Array<*>");
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unsupported annotation argument value (");
        ((StringBuilder)object).append(object22);
        ((StringBuilder)object).append("): ");
        ((StringBuilder)object).append(arrobject2);
        throw (Throwable)new UnsupportedOperationException(((StringBuilder)object).toString());
    }

    private final void a(n.c object, Annotation annotation) {
        Class<Annotation> class_ = kotlin.e.a.a(kotlin.e.a.a(annotation));
        if ((object = object.a(kotlin.reflect.jvm.internal.c.b.e(class_), new a(annotation))) != null) {
            a.a((n.a)object, annotation, class_);
        }
    }

    private final void b(Class<?> arrmethod, n.d d2) {
        for (Method method : arrmethod.getDeclaredMethods()) {
            Object object;
            int n2;
            j.a((Object)method, "method");
            Object object2 = f.a(method.getName());
            j.a(object2, "Name.identifier(method.name)");
            object2 = d2.a((f)object2, m.a.a(method));
            if (object2 == null) continue;
            Annotation[] arrannotation = method.getDeclaredAnnotations();
            int n3 = arrannotation.length;
            for (n2 = 0; n2 < n3; ++n2) {
                Annotation annotation = arrannotation[n2];
                object = (n.c)object2;
                j.a((Object)annotation, "annotation");
                this.a((n.c)object, annotation);
            }
            Annotation[][] arrannotation2 = method.getParameterAnnotations();
            j.a((Object)arrannotation2, "method.parameterAnnotations");
            int n4 = arrannotation2.length;
            for (n2 = 0; n2 < n4; ++n2) {
                for (Annotation annotation : arrannotation2[n2]) {
                    object = kotlin.e.a.a(kotlin.e.a.a(annotation));
                    Object object3 = kotlin.reflect.jvm.internal.c.b.e(object);
                    j.a((Object)annotation, "annotation");
                    object3 = object2.a(n2, (kotlin.reflect.jvm.internal.impl.e.a)object3, new a(annotation));
                    if (object3 == null) continue;
                    a.a((n.a)object3, annotation, (Class<?>)object);
                }
            }
            object2.a();
        }
    }

    private final void c(Class<?> arrobject, n.d d2) {
        arrobject = arrobject.getDeclaredConstructors();
        int n2 = arrobject.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object;
            Object object2 = arrobject[i2];
            Object[] arrobject2 = f.c("<init>");
            j.a((Object)arrobject2, "Name.special(\"<init>\")");
            Object object4 = m.a;
            j.a(object2, "constructor");
            object4 = d2.a((f)arrobject2, ((m)object4).a((Constructor<?>)object2));
            if (object4 == null) continue;
            for (Annotation annotation : ((Constructor)object2).getDeclaredAnnotations()) {
                object = (Object[])object4;
                j.a((Object)annotation, "annotation");
                this.a((n.c)object, annotation);
            }
            Annotation[][] object5 = ((Constructor)object2).getParameterAnnotations();
            j.a((Object)object5, "parameterAnnotations");
            object = (Object[])object5;
            int n3 = ((Object[])object).length == 0 ? 1 : 0;
            arrobject2 = arrobject;
            int n4 = n2;
            if ((n3 ^ 1) != 0) {
                int n5 = ((Constructor)object2).getParameterTypes().length - ((Object[])object).length;
                int n6 = object5.length;
                n3 = 0;
                do {
                    arrobject2 = arrobject;
                    n4 = n2;
                    if (n3 >= n6) break;
                    for (Annotation annotation : object5[n3]) {
                        object = kotlin.e.a.a(kotlin.e.a.a(annotation));
                        Object object3 = kotlin.reflect.jvm.internal.c.b.e(object);
                        j.a((Object)annotation, "annotation");
                        object3 = object4.a(n3 + n5, (kotlin.reflect.jvm.internal.impl.e.a)object3, new a(annotation));
                        if (object3 == null) continue;
                        a.a((n.a)object3, annotation, (Class<?>)object);
                    }
                    ++n3;
                } while (true);
            }
            arrobject = arrobject2;
            n2 = n4;
            object4.a();
        }
    }

    private final void d(Class<?> arrfield, n.d d2) {
        for (Field field : arrfield.getDeclaredFields()) {
            j.a((Object)field, "field");
            Object object = f.a(field.getName());
            j.a(object, "Name.identifier(field.name)");
            object = d2.a((f)object, m.a.a(field), null);
            if (object == null) continue;
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                j.a((Object)annotation, "annotation");
                this.a((n.c)object, annotation);
            }
            object.a();
        }
    }

    public final void a(Class<?> arrannotation, n.c c2) {
        j.b(arrannotation, "klass");
        j.b(c2, "visitor");
        for (Annotation annotation : arrannotation.getDeclaredAnnotations()) {
            j.a((Object)annotation, "annotation");
            this.a(c2, annotation);
        }
        c2.a();
    }

    public final void a(Class<?> class_, n.d d2) {
        j.b(class_, "klass");
        j.b(d2, "memberVisitor");
        this.b(class_, d2);
        this.c(class_, d2);
        this.d(class_, d2);
    }
}

