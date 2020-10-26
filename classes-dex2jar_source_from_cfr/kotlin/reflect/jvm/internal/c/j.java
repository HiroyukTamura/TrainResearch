/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.i;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.reflect.jvm.internal.c.f;
import kotlin.reflect.jvm.internal.c.l;
import kotlin.reflect.jvm.internal.c.m;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.c.p;
import kotlin.reflect.jvm.internal.c.s;
import kotlin.reflect.jvm.internal.c.t;
import kotlin.reflect.jvm.internal.c.x;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.c.a.e.aa;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a2\u0006\u0002\u0010\u0007J\u0013\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010:H\u0096\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00002\u0006\u0010*\u001a\u00020\u0018H\u0016J\b\u0010<\u001a\u00020'H\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u000202018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010\f\u00a8\u0006B"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "constructors", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "getConstructors", "()Ljava/util/List;", "element", "getElement", "()Ljava/lang/Class;", "fields", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "getFields", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "innerClassNames", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getInnerClassNames", "isAnnotationType", "", "()Z", "isEnum", "isInterface", "lightClassOriginKind", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/LightClassOriginKind;", "getLightClassOriginKind", "()Lorg/jetbrains/kotlin/load/java/structure/LightClassOriginKind;", "methods", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "getMethods", "modifiers", "", "getModifiers", "()I", "name", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "outerClass", "getOuterClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "supertypes", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "getSupertypes", "()Ljava/util/Collection;", "typeParameters", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "equals", "other", "", "findInnerClass", "hashCode", "isEnumValuesOrValueOf", "method", "Ljava/lang/reflect/Method;", "toString", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class j
extends n
implements kotlin.reflect.jvm.internal.c.f,
t,
kotlin.reflect.jvm.internal.impl.c.a.e.g {
    private final Class<?> a;

    public j(Class<?> class_) {
        kotlin.e.b.j.b(class_, "klass");
        this.a = class_;
    }

    private final boolean a(Method arrclass) {
        boolean bl2;
        String string2 = arrclass.getName();
        boolean bl3 = false;
        if (string2 == null) {
            return false;
        }
        int n2 = string2.hashCode();
        if (n2 != -823812830) {
            if (n2 != 231605032) {
                return false;
            }
            bl2 = bl3;
            if (string2.equals("valueOf")) {
                return Arrays.equals(arrclass.getParameterTypes(), new Class[]{String.class});
            }
        } else {
            bl2 = bl3;
            if (string2.equals("values")) {
                arrclass = arrclass.getParameterTypes();
                kotlin.e.b.j.a(arrclass, "method.parameterTypes");
                bl2 = bl3;
                if (arrclass.length == 0) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public List<m> A() {
        Constructor<?>[] arrconstructor = this.a.getDeclaredConstructors();
        kotlin.e.b.j.a(arrconstructor, "klass.declaredConstructors");
        return kotlin.h.i.e(kotlin.h.i.e(kotlin.h.i.a(kotlin.a.g.l(arrconstructor), a.a), b.c));
    }

    public List<kotlin.reflect.jvm.internal.c.c> B() {
        return f.a.a(this);
    }

    public /* synthetic */ Collection a() {
        return this.B();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.e.a a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        return this.b(b2);
    }

    public kotlin.reflect.jvm.internal.c.c b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        kotlin.e.b.j.b(b2, "fqName");
        return f.a.a(this, b2);
    }

    @Override
    public boolean b() {
        return f.a.b(this);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.b c() {
        kotlin.reflect.jvm.internal.impl.e.b b2 = kotlin.reflect.jvm.internal.c.b.e(this.a).g();
        kotlin.e.b.j.a((Object)b2, "klass.classId.asSingleFqName()");
        return b2;
    }

    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.c.a.e.j> d() {
        if (kotlin.e.b.j.a(this.a, Object.class)) {
            return kotlin.a.m.a();
        }
        Iterator iterator = new kotlin.e.b.x(2);
        Object object = this.a.getGenericSuperclass();
        if (object == null) {
            object = (Type)((Object)Object.class);
        }
        ((kotlin.e.b.x)((Object)iterator)).b(object);
        object = this.a.getGenericInterfaces();
        kotlin.e.b.j.a(object, "klass.genericInterfaces");
        ((kotlin.e.b.x)((Object)iterator)).a(object);
        iterator = kotlin.a.m.b((Type[])((kotlin.e.b.x)((Object)iterator)).a(new Type[((kotlin.e.b.x)((Object)iterator)).a()]));
        object = new ArrayList(kotlin.a.m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object.add(new l((Type)iterator.next()));
        }
        return (List)object;
    }

    public /* synthetic */ Collection e() {
        return this.w();
    }

    public boolean equals(Object object) {
        return object instanceof j && kotlin.e.b.j.a(this.a, ((j)object).a);
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.e.g f() {
        return this.x();
    }

    @Override
    public boolean g() {
        return this.a.isInterface();
    }

    @Override
    public boolean h() {
        return this.a.isAnnotation();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public boolean i() {
        return this.a.isEnum();
    }

    @Override
    public aa j() {
        return null;
    }

    public /* synthetic */ Collection k() {
        return this.y();
    }

    public /* synthetic */ Collection l() {
        return this.z();
    }

    public /* synthetic */ Collection m() {
        return this.A();
    }

    @Override
    public boolean n() {
        return t.a.a(this);
    }

    @Override
    public boolean o() {
        return t.a.b(this);
    }

    @Override
    public boolean p() {
        return t.a.c(this);
    }

    @Override
    public ba q() {
        return t.a.d(this);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.f r() {
        kotlin.reflect.jvm.internal.impl.e.f f2 = kotlin.reflect.jvm.internal.impl.e.f.a(this.a.getSimpleName());
        kotlin.e.b.j.a((Object)f2, "Name.identifier(klass.simpleName)");
        return f2;
    }

    public List<x> s() {
        TypeVariable<Class<?>>[] arrtypeVariable = this.a.getTypeParameters();
        kotlin.e.b.j.a(arrtypeVariable, "klass.typeParameters");
        Collection collection = new ArrayList(arrtypeVariable.length);
        int n2 = arrtypeVariable.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            collection.add(new x(arrtypeVariable[i2]));
        }
        return (List)collection;
    }

    @Override
    public /* synthetic */ AnnotatedElement t() {
        return this.u();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }

    public Class<?> u() {
        return this.a;
    }

    @Override
    public int v() {
        return this.a.getModifiers();
    }

    public List<kotlin.reflect.jvm.internal.impl.e.f> w() {
        Class<?>[] arrclass = this.a.getDeclaredClasses();
        kotlin.e.b.j.a(arrclass, "klass.declaredClasses");
        return kotlin.h.i.e(kotlin.h.i.f(kotlin.h.i.b(kotlin.a.g.l(arrclass), e.a), f.a));
    }

    public j x() {
        Class<?> class_ = this.a.getDeclaringClass();
        if (class_ != null) {
            return new j(class_);
        }
        return null;
    }

    public List<s> y() {
        Method[] arrmethod = this.a.getDeclaredMethods();
        kotlin.e.b.j.a((Object)arrmethod, "klass.declaredMethods");
        return kotlin.h.i.e(kotlin.h.i.e(kotlin.h.i.a(kotlin.a.g.l(arrmethod), (kotlin.e.a.b)new kotlin.e.a.b<Method, Boolean>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.a((Method)object);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public final boolean a(Method method) {
                kotlin.e.b.j.a((Object)method, "method");
                return !method.isSynthetic() && (!this.i() || !this.a(method));
            }
        }), h.c));
    }

    public List<p> z() {
        Field[] arrfield = this.a.getDeclaredFields();
        kotlin.e.b.j.a((Object)arrfield, "klass.declaredFields");
        return kotlin.h.i.e(kotlin.h.i.e(kotlin.h.i.a(kotlin.a.g.l(arrfield), c.a), d.c));
    }

}

