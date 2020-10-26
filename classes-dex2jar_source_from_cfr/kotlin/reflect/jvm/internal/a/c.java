/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.util.Set;
import kotlin.Metadata;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.a.d;
import kotlin.reflect.jvm.internal.c.j;
import kotlin.reflect.jvm.internal.c.u;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.t;
import kotlin.reflect.jvm.internal.impl.c.a.i;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.e.b;

@Metadata(bv={1, 0, 2}, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lkotlin/reflect/jvm/internal/components/ReflectJavaClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/java/JavaClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findPackage", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "knownClassNamesInPackage", "", "", "packageFqName", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class c
implements i {
    private final ClassLoader a;

    public c(ClassLoader classLoader) {
        kotlin.e.b.j.b(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override
    public g a(a object) {
        kotlin.e.b.j.b(object, "classId");
        b b2 = ((a)object).a();
        object = ((a)object).b().a();
        kotlin.e.b.j.a(object, "classId.relativeClassName.asString()");
        object = n.a((String)object, '.', '$', false, 4, null);
        kotlin.e.b.j.a((Object)b2, "packageFqName");
        if (!b2.c()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b2.a());
            stringBuilder.append(".");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        object = d.a(this.a, (String)object);
        if (object != null) {
            return new j((Class<?>)object);
        }
        return null;
    }

    @Override
    public t a(b b2) {
        kotlin.e.b.j.b(b2, "fqName");
        return new u(b2);
    }

    @Override
    public Set<String> b(b b2) {
        kotlin.e.b.j.b(b2, "packageFqName");
        return null;
    }
}

