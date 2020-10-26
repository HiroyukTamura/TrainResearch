/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.b;
import kotlin.reflect.jvm.internal.c.e;
import kotlin.reflect.jvm.internal.c.h;
import kotlin.reflect.jvm.internal.c.k;
import kotlin.reflect.jvm.internal.c.o;
import kotlin.reflect.jvm.internal.c.q;
import kotlin.reflect.jvm.internal.impl.e.f;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "(Lorg/jetbrains/kotlin/name/Name;)V", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "Factory", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public abstract class d
implements kotlin.reflect.jvm.internal.impl.c.a.e.b {
    public static final a a = new a(null);
    private final f b;

    public d(f f2) {
        this.b = f2;
    }

    @Override
    public f a() {
        return this.b;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\b"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "value", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final d a(Object object, f f2) {
            j.b(object, "value");
            if (b.b(object.getClass())) {
                object = new o(f2, (Enum)object);
                do {
                    return (d)object;
                    break;
                } while (true);
            }
            if (object instanceof Annotation) {
                object = new e(f2, (Annotation)object);
                return (d)object;
            }
            if (object instanceof Object[]) {
                object = new h(f2, (Object[])object);
                return (d)object;
            }
            if (object instanceof Class) {
                object = new k(f2, (Class)object);
                return (d)object;
            }
            object = new q(f2, object);
            return (d)object;
        }
    }

}

