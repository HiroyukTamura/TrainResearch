/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.i.n;
import kotlin.l;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.j.ah;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;

public final class ReflectionTypes {
    public static final Companion Companion;
    static final /* synthetic */ kotlin.reflect.l[] a;
    private final g b;
    private final a c;
    private final a d;
    private final a e;
    private final a f;
    private final a g;
    private final a h;
    private final a i;
    private final aa j;

    static {
        a = new kotlin.reflect.l[]{v.a(new t(v.a(ReflectionTypes.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), v.a(new t(v.a(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.a(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.a(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.a(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.a(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.a(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new t(v.a(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
        Companion = new Companion(null);
    }

    public ReflectionTypes(final y y2, aa aa2) {
        j.b(y2, "module");
        j.b(aa2, "notFoundClasses");
        this.j = aa2;
        this.b = h.a(l.b, (kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.h.e.h>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.h.e.h b() {
                return y2.a(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME()).c();
            }
        });
        this.c = new a(1);
        this.d = new a(1);
        this.e = new a(2);
        this.f = new a(3);
        this.g = new a(1);
        this.h = new a(2);
        this.i = new a(3);
    }

    private final kotlin.reflect.jvm.internal.impl.a.e a(String object, int n2) {
        f f2 = f.a((String)object);
        object = this.a();
        j.a((Object)f2, "name");
        kotlin.reflect.jvm.internal.impl.a.h h2 = object.c(f2, d.h);
        object = h2;
        if (!(h2 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            object = null;
        }
        if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object) != null) {
            return object;
        }
        return this.j.a(new kotlin.reflect.jvm.internal.impl.e.a(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), f2), m.a(n2));
    }

    private final kotlin.reflect.jvm.internal.impl.h.e.h a() {
        g g2 = this.b;
        kotlin.reflect.l l2 = a[0];
        return (kotlin.reflect.jvm.internal.impl.h.e.h)g2.a();
    }

    public final kotlin.reflect.jvm.internal.impl.a.e getKClass() {
        return this.c.a(this, a[1]);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.e.b.g g2) {
            this();
        }

        public final w createKPropertyStarType(y m2) {
            j.b(m2, "module");
            Object object = KotlinBuiltIns.FQ_NAMES.kProperty;
            j.a(object, "KotlinBuiltIns.FQ_NAMES.kProperty");
            m2 = s.a((y)m2, (kotlin.reflect.jvm.internal.impl.e.a)object);
            if (m2 != null) {
                object = kotlin.reflect.jvm.internal.impl.a.a.h.a.a();
                Object object2 = m2.e();
                j.a(object2, "kPropertyClass.typeConstructor");
                object2 = object2.b();
                j.a(object2, "kPropertyClass.typeConstructor.parameters");
                object2 = m.j(object2);
                j.a(object2, "kPropertyClass.typeConstructor.parameters.single()");
                return x.a((kotlin.reflect.jvm.internal.impl.a.a.h)object, (kotlin.reflect.jvm.internal.impl.a.e)m2, m.a(new ah((as)object2)));
            }
            return null;
        }
    }

    private static final class a {
        private final int a;

        public a(int n2) {
            this.a = n2;
        }

        public final kotlin.reflect.jvm.internal.impl.a.e a(ReflectionTypes reflectionTypes, kotlin.reflect.l<?> l2) {
            j.b(reflectionTypes, "types");
            j.b(l2, "property");
            return reflectionTypes.a(n.d(l2.g()), this.a);
        }
    }

}

