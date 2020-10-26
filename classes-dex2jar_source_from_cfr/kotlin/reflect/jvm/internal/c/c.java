/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.a;
import kotlin.reflect.jvm.internal.c.b;
import kotlin.reflect.jvm.internal.c.d;
import kotlin.reflect.jvm.internal.c.j;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.e.f;

@Metadata(bv={1, 0, 2}, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "annotation", "", "(Ljava/lang/annotation/Annotation;)V", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "arguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "getArguments", "()Ljava/util/Collection;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "equals", "", "other", "", "hashCode", "", "resolve", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "toString", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class c
extends n
implements kotlin.reflect.jvm.internal.impl.c.a.e.a {
    private final Annotation a;

    public c(Annotation annotation) {
        kotlin.e.b.j.b(annotation, "annotation");
        this.a = annotation;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.c.a.e.b> a() {
        Method[] arrmethod = a.a(a.a(this.a)).getDeclaredMethods();
        kotlin.e.b.j.a((Object)arrmethod, "annotation.annotationClass.java.declaredMethods");
        Collection collection = new ArrayList(arrmethod.length);
        for (Method method : arrmethod) {
            d.a a2 = d.a;
            Object object = method.invoke(this.a, new Object[0]);
            kotlin.e.b.j.a(object, "method.invoke(annotation)");
            kotlin.e.b.j.a((Object)method, "method");
            collection.add(a2.a(object, f.a(method.getName())));
        }
        return (List)collection;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.a b() {
        return b.e(a.a(a.a(this.a)));
    }

    @Override
    public /* synthetic */ g c() {
        return this.d();
    }

    public j d() {
        return new j(a.a(a.a(this.a)));
    }

    public final Annotation e() {
        return this.a;
    }

    public boolean equals(Object object) {
        return object instanceof c && kotlin.e.b.j.a((Object)this.a, (Object)((c)object).a);
    }

    public int hashCode() {
        return ((Object)this.a).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}

