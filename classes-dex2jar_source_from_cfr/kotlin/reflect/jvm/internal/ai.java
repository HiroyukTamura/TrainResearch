/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.o;
import kotlin.reflect.jvm.internal.a.d;
import kotlin.reflect.jvm.internal.a.e;
import kotlin.reflect.jvm.internal.a.l;
import kotlin.reflect.jvm.internal.ab;
import kotlin.reflect.jvm.internal.aj;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.impl.a.a.c;
import kotlin.reflect.jvm.internal.impl.a.a.f;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.i;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.c.b.p;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.b.k;
import kotlin.reflect.jvm.internal.impl.d.c.a.g;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.aa;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.t;
import kotlin.reflect.jvm.internal.m;
import kotlin.reflect.jvm.internal.v;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u009a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001an\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000f*\u00020\u0010\"\b\b\u0001\u0010\u000e*\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u0002H\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u001d\u0010\u001b\u001a\u0019\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000e0\u001c\u00a2\u0006\u0002\b\u001eH\u0000\u00a2\u0006\u0002\u0010\u001f\u001a&\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0000\u001a\"\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(H\b\u00a2\u0006\u0002\u0010)\u001a\u0014\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010,H\u0000\u001a\u0010\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010,H\u0000\u001a\u0014\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u000100*\u0004\u0018\u00010,H\u0000\u001a\u0012\u00101\u001a\b\u0012\u0004\u0012\u00020302*\u000204H\u0000\u001a\u0012\u00105\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013*\u000206H\u0000\u001a\u000e\u00107\u001a\u0004\u0018\u000108*\u000209H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\"\u001a\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n8@X\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006:"}, d2={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "isPublicInBytecode", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Z", "packageModuleName", "", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "getPackageModuleName", "(Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;)Ljava/lang/String;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "className", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin-reflect-api"}, k=2, mv={1, 1, 11})
public final class ai {
    private static final b a = new b("kotlin.jvm.JvmStatic");

    public static final Class<?> a(ClassLoader classLoader, String string2, String string3) {
        kotlin.e.b.j.b(classLoader, "classLoader");
        kotlin.e.b.j.b(string2, "packageName");
        kotlin.e.b.j.b(string3, "className");
        if (kotlin.e.b.j.a((Object)string2, (Object)"kotlin")) {
            switch (string3.hashCode()) {
                default: {
                    break;
                }
                case 2104330525: {
                    if (!string3.equals("LongArray")) break;
                    return long[].class;
                }
                case 948852093: {
                    if (!string3.equals("FloatArray")) break;
                    return float[].class;
                }
                case 601811914: {
                    if (!string3.equals("IntArray")) break;
                    return int[].class;
                }
                case 63537721: {
                    if (!string3.equals("Array")) break;
                    return Object[].class;
                }
                case 22374632: {
                    if (!string3.equals("DoubleArray")) break;
                    return double[].class;
                }
                case -74930671: {
                    if (!string3.equals("ByteArray")) break;
                    return byte[].class;
                }
                case -755911549: {
                    if (!string3.equals("CharArray")) break;
                    return char[].class;
                }
                case -763279523: {
                    if (!string3.equals("ShortArray")) break;
                    return short[].class;
                }
                case -901856463: {
                    if (!string3.equals("BooleanArray")) break;
                    return boolean[].class;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append('.');
        stringBuilder.append(kotlin.i.n.a(string3, '.', '$', false, 4, null));
        return d.a(classLoader, stringBuilder.toString());
    }

    public static final Class<?> a(e object) {
        kotlin.e.b.j.b(object, "$receiver");
        Object object2 = object.y();
        if (object2 instanceof p) {
            object = ((p)object2).b();
            if (object != null) {
                return ((kotlin.reflect.jvm.internal.a.e)object).c();
            }
            throw new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.components.ReflectKotlinClass");
        }
        if (object2 instanceof l.a) {
            object = ((l.a)object2).b();
            if (object != null) {
                return ((kotlin.reflect.jvm.internal.c.j)object).u();
            }
            throw new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.structure.ReflectJavaClass");
        }
        object2 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
        Object object3 = kotlin.reflect.jvm.internal.impl.h.c.d((kotlin.reflect.jvm.internal.impl.a.m)object);
        kotlin.e.b.j.a(object3, "DescriptorUtils.getFqName(this)");
        object2 = ((kotlin.reflect.jvm.internal.impl.builtins.b.c)object2).a((kotlin.reflect.jvm.internal.impl.e.c)object3);
        if (object2 == null) {
            object2 = kotlin.reflect.jvm.internal.impl.h.c.a.a((i)object);
        }
        if (object2 != null) {
            object3 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).a().a();
            object2 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).b().a();
            object = kotlin.reflect.jvm.internal.c.b.a(object.getClass());
            kotlin.e.b.j.a(object3, "packageName");
            kotlin.e.b.j.a(object2, "className");
            return ai.a((ClassLoader)object, (String)object3, (String)object2);
        }
        return null;
    }

    public static final String a(kotlin.reflect.jvm.internal.a.e object) {
        kotlin.e.b.j.b(object, "$receiver");
        Object object2 = object.d();
        boolean bl2 = ((a)object2).e().a();
        Object object3 = null;
        if (!bl2) {
            return null;
        }
        Object object4 = ((a)object2).d();
        switch (aj.a[object4.ordinal()]) {
            default: {
                return null;
            }
            case 3: {
                object4 = kotlin.a.m.g(((a)object2).b());
                if (object4 != null) {
                    object2 = kotlin.reflect.jvm.internal.a.e.a;
                    object = object.c().getClassLoader().loadClass(kotlin.i.n.a((String)object4, '/', '.', false, 4, null));
                    kotlin.e.b.j.a(object, "klass.classLoader.loadCl\u2026rtName.replace('/', '.'))");
                    object2 = ((e.a)object2).a((Class<?>)object);
                    object = object3;
                    if (object2 == null) break;
                    return ai.a((kotlin.reflect.jvm.internal.a.e)object2);
                }
                return null;
            }
            case 1: 
            case 2: {
                object = ((a)object2).f();
                if (object == null) {
                    kotlin.e.b.j.a();
                }
                if ((object3 = ((a)object2).h()) == null) {
                    kotlin.e.b.j.a();
                }
                object3 = kotlin.reflect.jvm.internal.impl.d.c.a.j.b(object, (String[])object3);
                object = (kotlin.reflect.jvm.internal.impl.d.c.a.h)((o)object3).c();
                object3 = (a.s)((o)object3).d();
                object2 = kotlin.reflect.jvm.internal.impl.d.c.b.l;
                kotlin.e.b.j.a(object2, "JvmProtoBuf.packageModuleName");
                object3 = (Integer)kotlin.reflect.jvm.internal.impl.d.b.f.a(object3, object2);
                if (object3 != null && (object = object.a(((Number)object3).intValue())) != null) {
                    return object;
                }
                object = "main";
            }
        }
        return object;
    }

    public static final List<Annotation> a(kotlin.reflect.jvm.internal.impl.a.a.a object) {
        kotlin.e.b.j.b(object, "$receiver");
        object = object.x();
        Collection collection = new ArrayList();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            Object object2 = ((c)iterator.next()).d();
            boolean bl2 = object2 instanceof kotlin.reflect.jvm.internal.a.a;
            Object var2_4 = null;
            if (bl2) {
                object = ((kotlin.reflect.jvm.internal.a.a)object2).b();
            } else {
                object = var2_4;
                if (object2 instanceof l.a) {
                    object = object2 = ((l.a)object2).b();
                    if (!(object2 instanceof kotlin.reflect.jvm.internal.c.c)) {
                        object = null;
                    }
                    object2 = (kotlin.reflect.jvm.internal.c.c)object;
                    object = var2_4;
                    if (object2 != null) {
                        object = ((kotlin.reflect.jvm.internal.c.c)object2).e();
                    }
                }
            }
            if (object == null) continue;
            collection.add(object);
        }
        return (List)collection;
    }

    public static final <M extends q, D extends kotlin.reflect.jvm.internal.impl.a.a> D a(Class<?> object, M m2, kotlin.reflect.jvm.internal.impl.d.b.c c2, kotlin.reflect.jvm.internal.impl.d.b.h h2, kotlin.reflect.jvm.internal.impl.d.b.a a2, kotlin.e.a.m<? super t, ? super M, ? extends D> m3) {
        block4 : {
            Object object2;
            block3 : {
                block2 : {
                    kotlin.e.b.j.b(object, "moduleAnchor");
                    kotlin.e.b.j.b(m2, "proto");
                    kotlin.e.b.j.b(c2, "nameResolver");
                    kotlin.e.b.j.b(h2, "typeTable");
                    kotlin.e.b.j.b(a2, "metadataVersion");
                    kotlin.e.b.j.b(m3, "createDescriptor");
                    object2 = ab.a(object);
                    if (!(m2 instanceof a.o)) break block2;
                    object = ((a.o)m2).s();
                    break block3;
                }
                if (!(m2 instanceof a.w)) break block4;
                object = ((a.w)m2).s();
            }
            j j2 = ((kotlin.reflect.jvm.internal.a.j)object2).b();
            object2 = ((kotlin.reflect.jvm.internal.a.j)object2).a();
            k k2 = k.a.a();
            kotlin.e.b.j.a(object, "typeParameters");
            return (D)((kotlin.reflect.jvm.internal.impl.a.a)m3.a(new t(new l(j2, c2, (kotlin.reflect.jvm.internal.impl.a.m)object2, h2, k2, a2, null, null, (List<a.ag>)object)), m2));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unsupported message: ");
        ((StringBuilder)object).append(m2);
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
    }

    public static final b a() {
        return a;
    }

    public static final m a(Object b2) {
        kotlin.reflect.b b3 = !(b2 instanceof m) ? null : b2;
        if ((b3 = (m)b3) != null) {
            return b3;
        }
        b3 = b2;
        if (!(b2 instanceof kotlin.e.b.i)) {
            b3 = null;
        }
        b2 = (b2 = (kotlin.e.b.i)b3) != null ? ((kotlin.e.b.c)b2).d() : null;
        b3 = b2;
        if (!(b2 instanceof m)) {
            b3 = null;
        }
        return (m)b3;
    }

    public static final boolean a(kotlin.reflect.jvm.internal.impl.a.b b2) {
        kotlin.e.b.j.b(b2, "$receiver");
        ba ba2 = b2.p();
        return (kotlin.e.b.j.a((Object)ba2, (Object)az.e) || kotlin.e.b.j.a((Object)ba2, (Object)az.d)) && !f.b((kotlin.reflect.jvm.internal.impl.a.v)b2);
    }

    public static final v<?> b(Object b2) {
        kotlin.reflect.b b3 = !(b2 instanceof v) ? null : b2;
        if ((b3 = (v)b3) != null) {
            return b3;
        }
        b3 = b2;
        if (!(b2 instanceof kotlin.e.b.p)) {
            b3 = null;
        }
        b2 = (b2 = (kotlin.e.b.p)b3) != null ? ((kotlin.e.b.c)b2).d() : null;
        b3 = b2;
        if (!(b2 instanceof v)) {
            b3 = null;
        }
        return (v)b3;
    }

    public static final kotlin.reflect.jvm.internal.h<?> c(Object object) {
        Object object2 = !(object instanceof kotlin.reflect.jvm.internal.h) ? null : object;
        if ((object2 = (kotlin.reflect.jvm.internal.h)object2) == null) {
            object2 = ai.a(object);
        }
        if (object2 != null) {
            return object2;
        }
        return ai.b(object);
    }
}

