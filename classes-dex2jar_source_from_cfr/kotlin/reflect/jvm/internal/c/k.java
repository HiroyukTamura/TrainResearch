/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.d;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.impl.c.a.e.h;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.reflect.jvm.internal.impl.e.f;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassObjectAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassObjectAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "klass", "Ljava/lang/Class;", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/Class;)V", "getReferencedType", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class k
extends d
implements h {
    private final Class<?> b;

    public k(f f2, Class<?> class_) {
        j.b(class_, "klass");
        super(f2);
        this.b = class_;
    }

    @Override
    public v b() {
        return w.a.a(this.b);
    }
}

