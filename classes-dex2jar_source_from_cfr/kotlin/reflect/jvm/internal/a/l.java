/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.c.a.d.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimeSourceElementFactory;", "Lkotlin/reflect/jvm/internal/impl/load/java/sources/JavaSourceElementFactory;", "()V", "source", "Lkotlin/reflect/jvm/internal/impl/load/java/sources/JavaSourceElement;", "javaElement", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaElement;", "RuntimeSourceElement", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class l
implements b {
    public static final l a = new l();

    private l() {
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.c.a.d.a a(kotlin.reflect.jvm.internal.impl.c.a.e.l l2) {
        j.b(l2, "javaElement");
        return new a((n)l2);
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimeSourceElementFactory$RuntimeSourceElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/sources/JavaSourceElement;", "javaElement", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "(Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;)V", "getJavaElement", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "getContainingFile", "Lkotlin/reflect/jvm/internal/impl/descriptors/SourceFile;", "toString", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
    public static final class a
    implements kotlin.reflect.jvm.internal.impl.c.a.d.a {
        private final n b;

        public a(n n2) {
            j.b(n2, "javaElement");
            this.b = n2;
        }

        @Override
        public ao a() {
            ao ao2 = ao.a;
            j.a((Object)ao2, "SourceFile.NO_SOURCE_FILE");
            return ao2;
        }

        public n b() {
            return this.b;
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.e.l c() {
            return this.b();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(this.b().toString());
            return stringBuilder.toString();
        }
    }

}

