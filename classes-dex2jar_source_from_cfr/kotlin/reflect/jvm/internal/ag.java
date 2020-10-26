/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.c.m;
import kotlin.reflect.jvm.internal.c.p;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.jvm.internal.g;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.c.a.b.e;
import kotlin.reflect.jvm.internal.impl.c.a.e.l;
import kotlin.reflect.jvm.internal.impl.c.a.n;
import kotlin.reflect.jvm.internal.impl.c.a.s;
import kotlin.reflect.jvm.internal.impl.c.b.r;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.h;
import kotlin.reflect.jvm.internal.impl.d.c.a.f;
import kotlin.reflect.jvm.internal.impl.d.c.a.j;
import kotlin.reflect.jvm.internal.impl.d.c.b;
import kotlin.reflect.jvm.internal.impl.e.a;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.q;

@Metadata(bv={1, 0, 2}, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class ag {
    public static final ag a = new ag();
    private static final a b = a.a(new b("java.lang.Void"));

    private ag() {
    }

    private final String a(kotlin.reflect.jvm.internal.impl.a.b object) {
        String string2 = s.d((kotlin.reflect.jvm.internal.impl.a.b)object);
        if (string2 != null) {
            return string2;
        }
        object = object instanceof aj ? n.c(kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.b)object).h_().a()) : (object instanceof ak ? n.d(kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.b)object).h_().a()) : object.h_().a());
        kotlin.e.b.j.a(object, "when (descriptor) {\n    \u2026name.asString()\n        }");
        return object;
    }

    private final f.e b(t t2) {
        return new f.e(new f.b(this.a((kotlin.reflect.jvm.internal.impl.a.b)t2), r.a(t2, false, false, 1, null)));
    }

    private final PrimitiveType b(Class<?> object) {
        if (((Class)object).isPrimitive()) {
            object = kotlin.reflect.jvm.internal.impl.h.d.c.a(((Class)object).getSimpleName());
            kotlin.e.b.j.a(object, "JvmPrimitiveType.get(simpleName)");
            return ((kotlin.reflect.jvm.internal.impl.h.d.c)((Object)object)).a();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final kotlin.reflect.jvm.internal.f a(t object) {
        kotlin.e.b.j.b(object, "possiblySubstitutedFunction");
        object = kotlin.reflect.jvm.internal.impl.h.c.a((kotlin.reflect.jvm.internal.impl.a.b)object);
        kotlin.e.b.j.a(object, "DescriptorUtils.unwrapFa\u2026siblySubstitutedFunction)");
        t t2 = ((t)object).s();
        if (t2 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c) {
            f.b b2;
            object = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.c)((Object)t2);
            q q2 = object.K();
            if (q2 instanceof a.o && (b2 = j.a.a((a.o)q2, object.L(), object.M())) != null) {
                object = new f.e(b2);
                return (kotlin.reflect.jvm.internal.f)object;
            }
            if (q2 instanceof a.e && (object = j.a.a((a.e)q2, object.L(), object.M())) != null) {
                object = new f.d((f.b)object);
                return (kotlin.reflect.jvm.internal.f)object;
            }
        } else {
            boolean bl2 = t2 instanceof e;
            Object object2 = null;
            if (bl2) {
                kotlin.e.b.j.a((Object)t2, "function");
                object = object2 = ((e)t2).y();
                if (!(object2 instanceof kotlin.reflect.jvm.internal.impl.c.a.d.a)) {
                    object = null;
                }
                object = (object = (kotlin.reflect.jvm.internal.impl.c.a.d.a)object) != null ? object.c() : null;
                object2 = object;
                if (!(object instanceof kotlin.reflect.jvm.internal.c.s)) {
                    object2 = null;
                }
                if ((object = (kotlin.reflect.jvm.internal.c.s)object2) != null && (object = ((kotlin.reflect.jvm.internal.c.s)object).h()) != null) {
                    object = new f.c((Method)object);
                    return (kotlin.reflect.jvm.internal.f)object;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Incorrect resolution sequence for Java method ");
                ((StringBuilder)object).append(t2);
                throw (Throwable)new aa(((StringBuilder)object).toString());
            }
            if (t2 instanceof kotlin.reflect.jvm.internal.impl.c.a.b.c) {
                kotlin.e.b.j.a((Object)t2, "function");
                an an2 = ((kotlin.reflect.jvm.internal.impl.c.a.b.c)t2).y();
                object = an2;
                if (!(an2 instanceof kotlin.reflect.jvm.internal.impl.c.a.d.a)) {
                    object = null;
                }
                an2 = (kotlin.reflect.jvm.internal.impl.c.a.d.a)object;
                object = object2;
                if (an2 != null) {
                    object = an2.c();
                }
                if (object instanceof m) {
                    object = new f.b(((m)object).d());
                    return (kotlin.reflect.jvm.internal.f)object;
                }
                if (object instanceof kotlin.reflect.jvm.internal.c.j && ((kotlin.reflect.jvm.internal.c.j)(object2 = (kotlin.reflect.jvm.internal.c.j)object)).h()) {
                    object = new f.a(((kotlin.reflect.jvm.internal.c.j)object2).u());
                    return (kotlin.reflect.jvm.internal.f)object;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Incorrect resolution sequence for Java constructor ");
                ((StringBuilder)object2).append(t2);
                ((StringBuilder)object2).append(" (");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(')');
                throw (Throwable)new aa(((StringBuilder)object2).toString());
            }
            if (!kotlin.reflect.jvm.internal.impl.h.b.b(t2) && !kotlin.reflect.jvm.internal.impl.h.b.a(t2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown origin of ");
                ((StringBuilder)object).append(t2);
                ((StringBuilder)object).append(" (");
                ((StringBuilder)object).append(t2.getClass());
                ((StringBuilder)object).append(')');
                throw (Throwable)new aa(((StringBuilder)object).toString());
            }
        }
        kotlin.e.b.j.a((Object)t2, "function");
        object = this.b(t2);
        return (kotlin.reflect.jvm.internal.f)object;
    }

    public final g a(ai object) {
        Object object2;
        kotlin.e.b.j.b(object, "possiblyOverriddenProperty");
        object = kotlin.reflect.jvm.internal.impl.h.c.a((kotlin.reflect.jvm.internal.impl.a.b)object);
        kotlin.e.b.j.a(object, "DescriptorUtils.unwrapFa\u2026ssiblyOverriddenProperty)");
        kotlin.reflect.jvm.internal.impl.a.b b2 = object.q();
        boolean bl2 = b2 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j;
        object = null;
        Object object3 = null;
        if (bl2) {
            object2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)b2;
            object3 = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)object2).H();
            i i2 = (i.c)object3;
            i.f<a.w, b.e> f2 = kotlin.reflect.jvm.internal.impl.d.c.b.d;
            kotlin.e.b.j.a(f2, "JvmProtoBuf.propertySignature");
            i2 = kotlin.reflect.jvm.internal.impl.d.b.f.a(i2, f2);
            if (i2 != null) {
                kotlin.e.b.j.a((Object)b2, "property");
                return new g.c((ai)b2, (a.w)object3, (b.e)i2, ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)object2).L(), ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.j)object2).M());
            }
        } else if (b2 instanceof kotlin.reflect.jvm.internal.impl.c.a.b.f) {
            Object object4;
            kotlin.e.b.j.a((Object)b2, "property");
            object = object4 = ((kotlin.reflect.jvm.internal.impl.c.a.b.f)b2).y();
            if (!(object4 instanceof kotlin.reflect.jvm.internal.impl.c.a.d.a)) {
                object = null;
            }
            if ((object = (object = (kotlin.reflect.jvm.internal.impl.c.a.d.a)object) != null ? object.c() : null) instanceof p) {
                return new g.a(((p)object).h());
            }
            if (object instanceof kotlin.reflect.jvm.internal.c.s) {
                Method method = ((kotlin.reflect.jvm.internal.c.s)object).h();
                object = b2.c();
                object = object != null ? object.y() : null;
                object4 = object;
                if (!(object instanceof kotlin.reflect.jvm.internal.impl.c.a.d.a)) {
                    object4 = null;
                }
                object = (object = (kotlin.reflect.jvm.internal.impl.c.a.d.a)object4) != null ? object.c() : null;
                object4 = object;
                if (!(object instanceof kotlin.reflect.jvm.internal.c.s)) {
                    object4 = null;
                }
                object4 = (kotlin.reflect.jvm.internal.c.s)object4;
                object = object3;
                if (object4 != null) {
                    object = ((kotlin.reflect.jvm.internal.c.s)object4).h();
                }
                return new g.b(method, (Method)object);
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Incorrect resolution sequence for Java field ");
            ((StringBuilder)object4).append(b2);
            ((StringBuilder)object4).append(" (source = ");
            ((StringBuilder)object4).append(object);
            ((StringBuilder)object4).append(')');
            throw (Throwable)new aa(((StringBuilder)object4).toString());
        }
        if ((object2 = b2.a()) == null) {
            kotlin.e.b.j.a();
        }
        object3 = (t)object2;
        object2 = this;
        object3 = ag.super.b((t)object3);
        if ((b2 = b2.c()) != null) {
            object = ag.super.b((t)b2);
        }
        return new g.d((f.e)object3, (f.e)object);
    }

    public final a a(Class<?> object) {
        kotlin.e.b.j.b(object, "klass");
        if (((Class)object).isArray()) {
            object = ((Class)object).getComponentType();
            kotlin.e.b.j.a(object, "klass.componentType");
            object = this.b((Class<?>)object);
            if (object != null) {
                return new a(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, ((PrimitiveType)((Object)object)).getArrayTypeName());
            }
            object = a.a(KotlinBuiltIns.FQ_NAMES.array.c());
            kotlin.e.b.j.a(object, "ClassId.topLevel(KotlinB\u2026.FQ_NAMES.array.toSafe())");
            return object;
        }
        if (kotlin.e.b.j.a(object, Void.TYPE)) {
            object = b;
            kotlin.e.b.j.a(object, "JAVA_LANG_VOID");
            return object;
        }
        Object object2 = this.b((Class<?>)object);
        if (object2 != null) {
            return new a(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, object2.getTypeName());
        }
        if (!((a)(object = kotlin.reflect.jvm.internal.c.b.e(object))).d()) {
            object2 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
            b b2 = ((a)object).g();
            kotlin.e.b.j.a((Object)b2, "classId.asSingleFqName()");
            object2 = ((kotlin.reflect.jvm.internal.impl.builtins.b.c)object2).a(b2);
            if (object2 != null) {
                return object2;
            }
        }
        return object;
    }
}

