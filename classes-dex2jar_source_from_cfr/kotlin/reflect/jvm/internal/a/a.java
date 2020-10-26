/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.ao;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/components/ReflectAnnotationSource;", "Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;", "annotation", "", "(Ljava/lang/annotation/Annotation;)V", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "getContainingFile", "Lkotlin/reflect/jvm/internal/impl/descriptors/SourceFile;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class a
implements an {
    private final Annotation b;

    public a(Annotation annotation) {
        j.b(annotation, "annotation");
        this.b = annotation;
    }

    @Override
    public ao a() {
        ao ao2 = ao.a;
        j.a((Object)ao2, "SourceFile.NO_SOURCE_FILE");
        return ao2;
    }

    public final Annotation b() {
        return this.b;
    }
}

