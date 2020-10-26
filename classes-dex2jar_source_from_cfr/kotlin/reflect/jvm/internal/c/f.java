/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.c;
import kotlin.reflect.jvm.internal.c.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.d;
import kotlin.reflect.jvm.internal.impl.e.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationOwner;", "annotations", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "isDeprecatedInJavaDoc", "", "()Z", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public interface f
extends d {
    public AnnotatedElement t();

    @Metadata(bv={1, 0, 2}, k=3, mv={1, 1, 11})
    public static final class a {
        public static List<c> a(f object) {
            if ((object = object.t()) != null && (object = object.getDeclaredAnnotations()) != null && (object = g.a(object)) != null) {
                return object;
            }
            return m.a();
        }

        public static c a(f arrannotation, b b2) {
            j.b(b2, "fqName");
            arrannotation = arrannotation.t();
            if (arrannotation != null && (arrannotation = arrannotation.getDeclaredAnnotations()) != null) {
                return g.a(arrannotation, b2);
            }
            return null;
        }

        public static boolean b(f f2) {
            return false;
        }
    }

}

