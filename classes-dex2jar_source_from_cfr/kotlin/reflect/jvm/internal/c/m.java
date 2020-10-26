/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.r;
import kotlin.reflect.jvm.internal.c.x;
import kotlin.reflect.jvm.internal.impl.c.a.e.k;
import kotlin.reflect.jvm.internal.impl.c.a.e.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaConstructor;", "member", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getMember", "()Ljava/lang/reflect/Constructor;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class m
extends r
implements k {
    private final Constructor<?> a;

    public m(Constructor<?> constructor) {
        j.b(constructor, "member");
        this.a = constructor;
    }

    @Override
    public List<y> c() {
        Object[] arrobject;
        Object[] arrobject2 = this.d().getGenericParameterTypes();
        j.a((Object)arrobject2, "types");
        boolean bl2 = arrobject2.length == 0;
        if (bl2) {
            return kotlin.a.m.a();
        }
        Annotation[][] arrannotation = this.d().getDeclaringClass();
        j.a(arrannotation, "klass");
        Object object = arrobject2;
        if (arrannotation.getDeclaringClass() != null) {
            object = arrobject2;
            if (!Modifier.isStatic(arrannotation.getModifiers())) {
                object = Arrays.copyOfRange(arrobject2, 1, arrobject2.length);
                j.a(object, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
            }
        }
        if ((arrobject = (Object[])(arrannotation = this.d().getParameterAnnotations())).length >= ((Type[])object).length) {
            arrobject2 = arrannotation;
            if (arrobject.length > ((Type[])object).length) {
                j.a((Object)arrannotation, "annotations");
                arrobject2 = Arrays.copyOfRange(arrobject, arrobject.length - ((Object)object).length, arrobject.length);
                j.a((Object)arrobject2, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
                arrobject2 = (Annotation[][])arrobject2;
            }
            j.a(object, "realTypes");
            j.a((Object)arrobject2, "realAnnotations");
            return this.a((Type[])object, (Annotation[][])arrobject2, this.d().isVarArgs());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Illegal generic signature: ");
        ((StringBuilder)object).append(this.d());
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
    }

    public Constructor<?> d() {
        return this.a;
    }

    public List<x> s() {
        TypeVariable<Constructor<?>>[] arrtypeVariable = this.d().getTypeParameters();
        j.a(arrtypeVariable, "member.typeParameters");
        Collection collection = new ArrayList(arrtypeVariable.length);
        int n2 = arrtypeVariable.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            collection.add(new x(arrtypeVariable[i2]));
        }
        return (List)collection;
    }

    @Override
    public /* synthetic */ Member s_() {
        return this.d();
    }
}

