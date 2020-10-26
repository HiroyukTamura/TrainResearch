/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import java.util.Map;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.a.c;
import kotlin.reflect.jvm.internal.a.f;
import kotlin.reflect.jvm.internal.a.i;
import kotlin.reflect.jvm.internal.a.k;
import kotlin.reflect.jvm.internal.a.l;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.c.u;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.c;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.c.a.a.f;
import kotlin.reflect.jvm.internal.impl.c.a.a.g;
import kotlin.reflect.jvm.internal.impl.c.a.a.j;
import kotlin.reflect.jvm.internal.impl.c.a.c.b;
import kotlin.reflect.jvm.internal.impl.c.a.c.c;
import kotlin.reflect.jvm.internal.impl.c.a.j;
import kotlin.reflect.jvm.internal.impl.c.b.d;
import kotlin.reflect.jvm.internal.impl.c.b.e;
import kotlin.reflect.jvm.internal.impl.c.b.m;
import kotlin.reflect.jvm.internal.impl.c.b.t;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "", "deserialization", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationComponents;", "packagePartProvider", "Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "(Lorg/jetbrains/kotlin/serialization/deserialization/DeserializationComponents;Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;)V", "getDeserialization", "()Lorg/jetbrains/kotlin/serialization/deserialization/DeserializationComponents;", "module", "Lkotlin/reflect/jvm/internal/impl/descriptors/ModuleDescriptor;", "getModule", "()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;", "getPackagePartProvider", "()Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Companion", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class j {
    public static final a a = new a(null);
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.j b;
    private final k c;

    private j(kotlin.reflect.jvm.internal.impl.serialization.deserialization.j j2, k k2) {
        this.b = j2;
        this.c = k2;
    }

    public /* synthetic */ j(kotlin.reflect.jvm.internal.impl.serialization.deserialization.j j2, k k2, kotlin.e.b.g g2) {
        this(j2, k2);
    }

    public final y a() {
        return this.b.c();
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.j b() {
        return this.b;
    }

    public final k c() {
        return this.c;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/components/RuntimeModuleData$Companion;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "classLoader", "Ljava/lang/ClassLoader;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        public final j a(ClassLoader object) {
            kotlin.e.b.j.b(object, "classLoader");
            kotlin.reflect.jvm.internal.impl.i.i i2 = new kotlin.reflect.jvm.internal.impl.i.b();
            Object object2 = new kotlin.reflect.jvm.internal.impl.builtins.b.e(i2, false, 2, null);
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("<runtime module for ");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append('>');
            object3 = kotlin.reflect.jvm.internal.impl.e.f.c(((StringBuilder)object3).toString());
            kotlin.e.b.j.a(object3, "Name.special(\"<runtime module for $classLoader>\")");
            object3 = new u((kotlin.reflect.jvm.internal.impl.e.f)object3, i2, (KotlinBuiltIns)object2, null, null, null, 56, null);
            Object object4 = new f((ClassLoader)object);
            e e2 = new e();
            kotlin.reflect.jvm.internal.impl.c.a.c.l l2 = new kotlin.reflect.jvm.internal.impl.c.a.c.l();
            k k2 = new k((ClassLoader)object);
            Object object5 = g.a;
            y y2 = (y)object3;
            aa aa2 = new aa(i2, y2);
            Object object6 = new kotlin.reflect.jvm.internal.impl.c.a.a(i2, kotlin.reflect.jvm.internal.impl.l.e.c);
            Object object7 = new c((ClassLoader)object);
            object = (m)object4;
            object4 = kotlin.reflect.jvm.internal.impl.c.a.a.k.a;
            kotlin.e.b.j.a(object4, "SignaturePropagator.DO_NOTHING");
            p p2 = i.a;
            kotlin.e.b.j.a(object5, "javaResolverCache");
            object6 = new kotlin.reflect.jvm.internal.impl.c.a.c.g(new b(i2, (kotlin.reflect.jvm.internal.impl.c.a.i)object7, (m)object, e2, (kotlin.reflect.jvm.internal.impl.c.a.a.k)object4, p2, (g)object5, f.a.a, j.a.a, l.a, l2, k2, aq.a.a, c.a.a, y2, new ReflectionTypes(y2, aa2), (kotlin.reflect.jvm.internal.impl.c.a.a)object6, new kotlin.reflect.jvm.internal.impl.c.a.f.l((kotlin.reflect.jvm.internal.impl.c.a.a)object6, kotlin.reflect.jvm.internal.impl.l.e.c), j.a.a, c.b.b));
            ((kotlin.reflect.jvm.internal.impl.builtins.b.e)object2).a(y2, true);
            object5 = new kotlin.reflect.jvm.internal.impl.h.d.a((kotlin.reflect.jvm.internal.impl.c.a.c.g)object6, (g)object5);
            object7 = new kotlin.reflect.jvm.internal.impl.c.b.f((m)object, e2);
            object = new kotlin.reflect.jvm.internal.impl.c.b.c(y2, aa2, i2, (m)object);
            object = new d(i2, y2, k.a.a, (kotlin.reflect.jvm.internal.impl.c.b.f)object7, (kotlin.reflect.jvm.internal.impl.c.b.c)object, (kotlin.reflect.jvm.internal.impl.c.a.c.g)object6, aa2, i.a, c.a.a, kotlin.reflect.jvm.internal.impl.serialization.deserialization.i.a.a());
            l2.a((kotlin.reflect.jvm.internal.impl.h.d.a)object5);
            e2.a((d)object);
            object2 = ((KotlinBuiltIns)object2).getBuiltInsModule();
            kotlin.e.b.j.a(object2, "builtIns.builtInsModule");
            ((u)object3).a(new u[]{object3, object2});
            ((u)object3).a(((kotlin.reflect.jvm.internal.impl.h.d.a)object5).a());
            return new j(((d)object).a(), k2, null);
        }
    }

}

