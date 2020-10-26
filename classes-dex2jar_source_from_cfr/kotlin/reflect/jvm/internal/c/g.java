/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.a;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.b;
import kotlin.reflect.jvm.internal.c.c;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2={"findAnnotation", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "", "", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "([Ljava/lang/annotation/Annotation;Lorg/jetbrains/kotlin/name/FqName;)Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "", "([Ljava/lang/annotation/Annotation;)Ljava/util/List;", "descriptors.runtime"}, k=2, mv={1, 1, 11})
public final class g {
    public static final List<c> a(Annotation[] arrannotation) {
        j.b(arrannotation, "$receiver");
        Collection collection = new ArrayList(arrannotation.length);
        int n2 = arrannotation.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            collection.add(new c(arrannotation[i2]));
        }
        return (List)collection;
    }

    public static final c a(Annotation[] object, kotlin.reflect.jvm.internal.impl.e.b object2) {
        Object var4_4;
        block3 : {
            j.b(object, "$receiver");
            j.b(object2, "fqName");
            int n2 = ((Annotation[])object).length;
            int n3 = 0;
            do {
                var4_4 = null;
                if (n3 >= n2) break;
                Annotation annotation = object[n3];
                if (j.a((Object)b.e(a.a(a.a(annotation))).g(), object2)) {
                    object = annotation;
                    break block3;
                }
                ++n3;
            } while (true);
            object = null;
        }
        object2 = var4_4;
        if (object != null) {
            object2 = new c((Annotation)object);
        }
        return object2;
    }
}

