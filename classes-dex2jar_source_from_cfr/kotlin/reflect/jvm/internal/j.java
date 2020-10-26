/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.e.b.v;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.a.e;
import kotlin.reflect.jvm.internal.aa;
import kotlin.reflect.jvm.internal.ac;
import kotlin.reflect.jvm.internal.ag;
import kotlin.reflect.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.d;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.b.a.a;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.f.i;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.h.e.j;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.k;
import kotlin.reflect.jvm.internal.l;
import kotlin.reflect.jvm.internal.m;
import kotlin.reflect.jvm.internal.x;
import kotlin.reflect.jvm.internal.z;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001^B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\u0013\u0010M\u001a\u00020%2\b\u0010N\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u00132\u0006\u0010Q\u001a\u00020RH\u0016J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020VH\u0016J\u0016\u0010W\u001a\b\u0012\u0004\u0012\u00020T0\u00132\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010X\u001a\u00020VH\u0016J\u0012\u0010Y\u001a\u00020%2\b\u0010Z\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010[\u001a\u00020\\H\u0002J\b\u0010]\u001a\u00020<H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R3\u0010\u001a\u001a$\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010&R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0002008@X\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u0016R\u001e\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010\u0016R\u0016\u00108\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010?\u001a\u0004\u0018\u00010<8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010A\u001a\u0002008@X\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u00102R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010\rR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010\rR\u0016\u0010I\u001a\u0004\u0018\u00010J8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010L\u00a8\u0006_"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflect_api", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflect_api", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
public final class j<T>
extends l
implements kotlin.reflect.c<T> {
    private final ac.b<j<T>> a;
    private final Class<T> c;

    public j(Class<T> class_) {
        kotlin.e.b.j.b(class_, "jClass");
        this.c = class_;
        this.a = ac.a(new kotlin.e.a.a<j<T>>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final j<T> b() {
                return new a();
            }
        });
    }

    private final kotlin.reflect.jvm.internal.impl.e.a n() {
        return ag.a.a(this.a());
    }

    private final Void o() {
        Object object = kotlin.reflect.jvm.internal.a.e.a.a(this.a());
        object = object != null && (object = ((kotlin.reflect.jvm.internal.a.e)object).d()) != null ? ((kotlin.reflect.jvm.internal.impl.c.b.a.a)object).d() : null;
        if (object != null) {
            switch (k.a[((Enum)object).ordinal()]) {
                default: {
                    throw new kotlin.m();
                }
                case 5: {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown class: ");
                    stringBuilder.append(this.a());
                    stringBuilder.append(" (kind = ");
                    stringBuilder.append(object);
                    stringBuilder.append(')');
                    throw (Throwable)new aa(stringBuilder.toString());
                }
                case 4: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ");
                    ((StringBuilder)object).append("library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                    ((StringBuilder)object).append(this.a());
                    throw (Throwable)new UnsupportedOperationException(((StringBuilder)object).toString());
                }
                case 1: 
                case 2: 
                case 3: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Packages and file facades are not yet supported in Kotlin reflection. ");
                    ((StringBuilder)object).append("Meanwhile please use Java reflection to inspect this class: ");
                    ((StringBuilder)object).append(this.a());
                    throw (Throwable)new UnsupportedOperationException(((StringBuilder)object).toString());
                }
                case 6: 
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unresolved class: ");
        ((StringBuilder)object).append(this.a());
        throw (Throwable)new aa(((StringBuilder)object).toString());
    }

    public Class<T> a() {
        return this.c;
    }

    @Override
    public Collection<ai> a(f f2) {
        kotlin.e.b.j.b(f2, "name");
        return kotlin.a.m.b(this.h().a(f2, kotlin.reflect.jvm.internal.impl.b.a.d.h), (Iterable)this.i().a(f2, kotlin.reflect.jvm.internal.impl.b.a.d.h));
    }

    @Override
    public ai a(int n2) {
        Object object;
        if (kotlin.e.b.j.a((Object)this.a().getSimpleName(), (Object)"DefaultImpls") && (object = this.a().getDeclaringClass()) != null && ((Class)object).isInterface()) {
            if ((object = kotlin.e.a.a(object)) != null) {
                return ((j)object).a(n2);
            }
            throw new kotlin.t("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        }
        object = this.g();
        boolean bl2 = object instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e;
        Object var4_4 = null;
        if (!bl2) {
            object = null;
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e e2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.e)object;
        object = var4_4;
        if (e2 != null) {
            object = e2.H();
            Object object2 = kotlin.reflect.jvm.internal.impl.d.c.b.j;
            kotlin.e.b.j.a(object2, "JvmProtoBuf.classLocalVariable");
            object2 = kotlin.reflect.jvm.internal.impl.d.b.f.a(object, object2, n2);
            object = var4_4;
            if (object2 != null) {
                object = (ai)kotlin.reflect.jvm.internal.ai.a(this.a(), (q)object2, e2.a().e(), e2.a().g(), e2.I(), c.c);
            }
        }
        return object;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.l> b() {
        Object object = this.g();
        if (object.l() != kotlin.reflect.jvm.internal.impl.a.f.b && object.l() != kotlin.reflect.jvm.internal.impl.a.f.f) {
            object = object.k();
            kotlin.e.b.j.a(object, "descriptor.constructors");
            return object;
        }
        return kotlin.a.m.a();
    }

    @Override
    public Collection<t> b(f f2) {
        kotlin.e.b.j.b(f2, "name");
        return kotlin.a.m.b(this.h().b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.h), (Iterable)this.i().b(f2, kotlin.reflect.jvm.internal.impl.b.a.d.h));
    }

    @Override
    public T c() {
        return ((a)((Object)this.a.a())).e();
    }

    @Override
    public boolean d() {
        return this.g().m() == w.d;
    }

    @Override
    public boolean e() {
        return this.g().r();
    }

    @Override
    public String e_() {
        return ((a)((Object)this.a.a())).c();
    }

    public boolean equals(Object object) {
        return object instanceof j && kotlin.e.b.j.a(kotlin.e.a.c(this), kotlin.e.a.c((kotlin.reflect.c)object));
    }

    public final ac.b<j<T>> f() {
        return this.a;
    }

    public e g() {
        return ((a)((Object)this.a.a())).a();
    }

    public final kotlin.reflect.jvm.internal.impl.h.e.h h() {
        return this.g().i_().b();
    }

    public int hashCode() {
        return kotlin.e.a.c(this).hashCode();
    }

    public final kotlin.reflect.jvm.internal.impl.h.e.h i() {
        kotlin.reflect.jvm.internal.impl.h.e.h h2 = this.g().f_();
        kotlin.e.b.j.a((Object)h2, "descriptor.staticScope");
        return h2;
    }

    public Collection<kotlin.reflect.f<T>> j() {
        return ((a)((Object)this.a.a())).d();
    }

    @Override
    public List<Annotation> k() {
        return ((a)((Object)this.a.a())).b();
    }

    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("class ");
        Object object = this.n();
        Object object2 = ((kotlin.reflect.jvm.internal.impl.e.a)object).a();
        kotlin.e.b.j.a(object2, "packageFqName");
        if (((kotlin.reflect.jvm.internal.impl.e.b)object2).c()) {
            object2 = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((kotlin.reflect.jvm.internal.impl.e.b)object2).a());
            stringBuilder.append(".");
            object2 = stringBuilder.toString();
        }
        object = ((kotlin.reflect.jvm.internal.impl.e.a)object).b().a();
        kotlin.e.b.j.a(object, "classId.relativeClassName.asString()");
        object = n.a((String)object, '.', '$', false, 4, null);
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        stringBuilder.append((String)object);
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010K\u001a\u00020<2\n\u0010L\u001a\u0006\u0012\u0002\b\u00030MH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010>R!\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010\n\u001a\u0004\bE\u0010\u0015R!\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bI\u0010\u0015\u00a8\u0006N"}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflect-api"}, k=1, mv={1, 1, 11})
    public final class kotlin.reflect.jvm.internal.j$a
    extends l.b {
        static final /* synthetic */ kotlin.reflect.l[] a;
        private final ac.a e;
        private final ac.a f;
        private final ac.a g;
        private final ac.a h;
        private final ac.a i;
        private final ac.a j;
        private final ac.b k;
        private final ac.a l;
        private final ac.a m;
        private final ac.a n;
        private final ac.a o;
        private final ac.a p;
        private final ac.a q;
        private final ac.a r;
        private final ac.a s;
        private final ac.a t;
        private final ac.a u;

        static {
            a = new kotlin.reflect.l[]{v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "annotations", "getAnnotations()Ljava/util/List;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "constructors", "getConstructors()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "supertypes", "getSupertypes()Ljava/util/List;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), v.a(new kotlin.e.b.t(v.a(kotlin.reflect.jvm.internal.j$a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        }

        public kotlin.reflect.jvm.internal.j$a() {
            super((kotlin.reflect.jvm.internal.l)j.this);
            this.e = ac.b((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.a.e>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final kotlin.reflect.jvm.internal.impl.a.e b() {
                    Object object = j.this.n();
                    kotlin.reflect.jvm.internal.a.j j2 = ((kotlin.reflect.jvm.internal.j$a)((Object)j.this.f().a())).i();
                    if ((object = ((kotlin.reflect.jvm.internal.impl.e.a)object).d() ? j2.b().a((kotlin.reflect.jvm.internal.impl.e.a)object) : s.a(j2.a(), (kotlin.reflect.jvm.internal.impl.e.a)object)) != null) {
                        return object;
                    }
                    j.this.o();
                    throw null;
                }
            });
            this.f = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends Annotation>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<Annotation> b() {
                    return kotlin.reflect.jvm.internal.ai.a((kotlin.reflect.jvm.internal.impl.a.a.a)this.a());
                }
            });
            this.g = ac.b((kotlin.e.a.a)new kotlin.e.a.a<String>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final String b() {
                    if (j.this.a().isAnonymousClass()) {
                        return null;
                    }
                    Object object = j.this.n();
                    if (((kotlin.reflect.jvm.internal.impl.e.a)object).d()) {
                        return this.a(j.this.a());
                    }
                    object = ((kotlin.reflect.jvm.internal.impl.e.a)object).c().a();
                    kotlin.e.b.j.a(object, "classId.shortClassName.asString()");
                    return object;
                }
            });
            this.h = ac.b((kotlin.e.a.a)new kotlin.e.a.a<String>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final String b() {
                    if (j.this.a().isAnonymousClass()) {
                        return null;
                    }
                    kotlin.reflect.jvm.internal.impl.e.a a2 = j.this.n();
                    if (a2.d()) {
                        return null;
                    }
                    return a2.g().a();
                }
            });
            this.i = ac.b(new kotlin.e.a.a<List<? extends kotlin.reflect.f<? extends T>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.f<T>> b() {
                    Object object = j.this.b();
                    Collection collection = new ArrayList(kotlin.a.m.a(object, 10));
                    object = object.iterator();
                    while (object.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.a.l l2 = (kotlin.reflect.jvm.internal.impl.a.l)object.next();
                        collection.add((kotlin.reflect.f)new kotlin.reflect.jvm.internal.m(j.this, l2));
                    }
                    return (List)collection;
                }
            });
            this.j = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.j<? extends Object>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.j<? extends Object>> b() {
                    Object object;
                    Object object2 = j.a.a(this.a().C(), null, null, 3, null);
                    Object object3 = new ArrayList();
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        object = object2.next();
                        if (kotlin.reflect.jvm.internal.impl.h.c.l((kotlin.reflect.jvm.internal.impl.a.m)object)) continue;
                        object3.add(object);
                    }
                    object3 = (List)object3;
                    object2 = new ArrayList();
                    object = object3.iterator();
                    while (object.hasNext()) {
                        object3 = (kotlin.reflect.jvm.internal.impl.a.m)object.next();
                        if (object3 != null) {
                            if ((object3 = (object3 = kotlin.reflect.jvm.internal.ai.a((kotlin.reflect.jvm.internal.impl.a.e)object3)) != null ? new kotlin.reflect.jvm.internal.j((Class<?>)object3) : null) == null) continue;
                            object2.add(object3);
                            continue;
                        }
                        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    return (List)object2;
                }
            });
            this.k = ac.a(new kotlin.e.a.a<T>(){

                @Override
                public final T a() {
                    Object object = this.a();
                    if (object.l() != kotlin.reflect.jvm.internal.impl.a.f.f) {
                        return null;
                    }
                    object = object.q() && !CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject((kotlin.reflect.jvm.internal.impl.a.e)object) ? j.this.a().getEnclosingClass().getDeclaredField(object.h_().a()) : j.this.a().getDeclaredField("INSTANCE");
                    if ((object = ((Field)object).get(null)) != null) {
                        return (T)object;
                    }
                    throw new kotlin.t("null cannot be cast to non-null type T");
                }
            });
            this.l = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends z>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<z> b() {
                    Collection<as> collection = this.a().z();
                    kotlin.e.b.j.a(collection, "descriptor.declaredTypeParameters");
                    Object object = collection;
                    collection = new ArrayList(kotlin.a.m.a(object, 10));
                    object = object.iterator();
                    while (object.hasNext()) {
                        collection.add((as)((Object)new z((as)object.next())));
                    }
                    return collection;
                }
            });
            this.m = ac.b((kotlin.e.a.a)new kotlin.e.a.a<List<? extends x>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<x> b() {
                    Object object;
                    Object object2 = this.a().e();
                    kotlin.e.b.j.a(object2, "descriptor.typeConstructor");
                    Object object3 = object2.k_();
                    object2 = new ArrayList(object3.size());
                    kotlin.e.b.j.a(object3, "kotlinTypes");
                    for (final Object object4 : (Iterable)object3) {
                        object = (Collection)object2;
                        object4 = (kotlin.reflect.jvm.internal.impl.j.w)object4;
                        kotlin.e.b.j.a(object4, "kotlinType");
                        object.add((x)new x((kotlin.reflect.jvm.internal.impl.j.w)object4, (kotlin.e.a.a<? extends Type>)new kotlin.e.a.a<Type>(){

                            @Override
                            public /* synthetic */ Object a() {
                                return this.b();
                            }

                            /*
                             * Enabled aggressive block sorting
                             */
                            public final Type b() {
                                Object object = object4.g().d();
                                if (!(object instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Supertype not a class: ");
                                    stringBuilder.append(object);
                                    throw (Throwable)new aa(stringBuilder.toString());
                                }
                                Class<?> class_ = kotlin.reflect.jvm.internal.ai.a((kotlin.reflect.jvm.internal.impl.a.e)object);
                                if (class_ == null) {
                                    class_ = new StringBuilder();
                                    ((StringBuilder)((Object)class_)).append("Unsupported superclass of ");
                                    ((StringBuilder)((Object)class_)).append(this);
                                    ((StringBuilder)((Object)class_)).append(": ");
                                    ((StringBuilder)((Object)class_)).append(object);
                                    throw (Throwable)new aa(((StringBuilder)((Object)class_)).toString());
                                }
                                if (kotlin.e.b.j.a(j.this.a().getSuperclass(), (Object)class_)) {
                                    object = j.this.a().getGenericSuperclass();
                                    class_ = "jClass.genericSuperclass";
                                } else {
                                    Class<?>[] arrclass = j.this.a().getInterfaces();
                                    kotlin.e.b.j.a(arrclass, "jClass.interfaces");
                                    int n2 = kotlin.a.g.b(arrclass, class_);
                                    if (n2 < 0) {
                                        class_ = new StringBuilder();
                                        ((StringBuilder)((Object)class_)).append("No superclass of ");
                                        ((StringBuilder)((Object)class_)).append(this);
                                        ((StringBuilder)((Object)class_)).append(" in Java reflection for ");
                                        ((StringBuilder)((Object)class_)).append(object);
                                        throw (Throwable)new aa(((StringBuilder)((Object)class_)).toString());
                                    }
                                    object = j.this.a().getGenericInterfaces()[n2];
                                    class_ = "jClass.genericInterfaces[index]";
                                }
                                kotlin.e.b.j.a(object, (String)((Object)class_));
                                return object;
                            }
                        }));
                    }
                    object3 = (Collection)object2;
                    if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.a())) {
                        boolean bl2;
                        block7 : {
                            object = (Iterable)object2;
                            boolean bl3 = object instanceof Collection;
                            boolean bl4 = true;
                            if (bl3 && object.isEmpty()) {
                                bl2 = bl4;
                            } else {
                                object = object.iterator();
                                do {
                                    Object object4;
                                    bl2 = bl4;
                                    if (!object.hasNext()) break block7;
                                    object4 = kotlin.reflect.jvm.internal.impl.h.c.b(((x)object.next()).d());
                                    kotlin.e.b.j.a(object4, "DescriptorUtils.getClassDescriptorForType(it.type)");
                                    object4 = object4.l();
                                    if (object4 != kotlin.reflect.jvm.internal.impl.a.f.b && object4 != kotlin.reflect.jvm.internal.impl.a.f.e) {
                                        bl2 = false;
                                        continue;
                                    }
                                    bl2 = true;
                                } while (bl2);
                                bl2 = false;
                            }
                        }
                        if (bl2) {
                            object = kotlin.reflect.jvm.internal.impl.h.c.a.d(this.a()).getAnyType();
                            kotlin.e.b.j.a(object, "descriptor.builtIns.anyType");
                            object3.add(new x((kotlin.reflect.jvm.internal.impl.j.w)object, 1.a));
                        }
                    }
                    return kotlin.reflect.jvm.internal.impl.l.a.a(object2);
                }

            });
            this.n = ac.b(new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Collection<kotlin.reflect.jvm.internal.h<?>> b() {
                    return j.this.a(j.this.h(), l.c.a);
                }
            });
            this.o = ac.b(new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Collection<kotlin.reflect.jvm.internal.h<?>> b() {
                    return j.this.a(j.this.i(), l.c.a);
                }
            });
            this.p = ac.b(new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Collection<kotlin.reflect.jvm.internal.h<?>> b() {
                    return j.this.a(j.this.h(), l.c.b);
                }
            });
            this.q = ac.b(new kotlin.e.a.a<Collection<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final Collection<kotlin.reflect.jvm.internal.h<?>> b() {
                    return j.this.a(j.this.i(), l.c.b);
                }
            });
            this.r = ac.b(new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.h<?>> b() {
                    return kotlin.a.m.b(this.f(), this.k());
                }
            });
            this.s = ac.b(new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.h<?>> b() {
                    return kotlin.a.m.b(this.j(), this.l());
                }
            });
            this.t = ac.b(new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.h<?>> b() {
                    return kotlin.a.m.b(this.f(), this.j());
                }
            });
            this.u = ac.b(new kotlin.e.a.a<List<? extends kotlin.reflect.jvm.internal.h<?>>>(){

                @Override
                public /* synthetic */ Object a() {
                    return this.b();
                }

                public final List<kotlin.reflect.jvm.internal.h<?>> b() {
                    return kotlin.a.m.b(this.g(), (Iterable)this.h());
                }
            });
        }

        private final String a(Class<?> object) {
            String string2 = ((Class)object).getSimpleName();
            Object object2 = ((Class)object).getEnclosingMethod();
            if (object2 != null) {
                kotlin.e.b.j.a((Object)string2, "name");
                object = new StringBuilder();
                ((StringBuilder)object).append(((Method)object2).getName());
                ((StringBuilder)object).append("$");
                return kotlin.i.n.b(string2, ((StringBuilder)object).toString(), null, 2, null);
            }
            if ((object = ((Class)object).getEnclosingConstructor()) != null) {
                kotlin.e.b.j.a((Object)string2, "name");
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(((Constructor)object).getName());
                ((StringBuilder)object2).append("$");
                return kotlin.i.n.b(string2, ((StringBuilder)object2).toString(), null, 2, null);
            }
            kotlin.e.b.j.a((Object)string2, "name");
            return kotlin.i.n.b(string2, '$', null, 2, null);
        }

        private final Collection<kotlin.reflect.jvm.internal.h<?>> j() {
            return (Collection)this.o.a(this, a[10]);
        }

        private final Collection<kotlin.reflect.jvm.internal.h<?>> k() {
            return (Collection)this.p.a(this, a[11]);
        }

        private final Collection<kotlin.reflect.jvm.internal.h<?>> l() {
            return (Collection)this.q.a(this, a[12]);
        }

        public final kotlin.reflect.jvm.internal.impl.a.e a() {
            return (kotlin.reflect.jvm.internal.impl.a.e)this.e.a(this, a[0]);
        }

        public final List<Annotation> b() {
            return (List)this.f.a(this, a[1]);
        }

        public final String c() {
            return (String)this.h.a(this, a[3]);
        }

        public final Collection<kotlin.reflect.f<T>> d() {
            return (Collection)this.i.a(this, a[4]);
        }

        public final T e() {
            return this.k.a(this, a[6]);
        }

        public final Collection<kotlin.reflect.jvm.internal.h<?>> f() {
            return (Collection)this.n.a(this, a[9]);
        }

        public final Collection<kotlin.reflect.jvm.internal.h<?>> g() {
            return (Collection)this.r.a(this, a[13]);
        }

        public final Collection<kotlin.reflect.jvm.internal.h<?>> h() {
            return (Collection)this.s.a(this, a[14]);
        }

    }

}

