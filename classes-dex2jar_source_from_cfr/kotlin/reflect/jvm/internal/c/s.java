/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.r;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.c.x;
import kotlin.reflect.jvm.internal.impl.c.a.e.q;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.reflect.jvm.internal.impl.c.a.e.y;

@Metadata(bv={1, 0, 2}, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u0018"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMethod;", "member", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "hasAnnotationParameterDefaultValue", "", "getHasAnnotationParameterDefaultValue", "()Z", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReturnType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class s
extends r
implements q {
    private final Method a;

    public s(Method method) {
        j.b(method, "member");
        this.a = method;
    }

    @Override
    public List<y> c() {
        Type[] arrtype = this.h().getGenericParameterTypes();
        j.a((Object)arrtype, "member.genericParameterTypes");
        Annotation[][] arrannotation = this.h().getParameterAnnotations();
        j.a((Object)arrannotation, "member.parameterAnnotations");
        return this.a(arrtype, arrannotation, this.h().isVarArgs());
    }

    @Override
    public /* synthetic */ v d() {
        return this.g();
    }

    @Override
    public boolean e() {
        return this.h().getDefaultValue() != null;
    }

    public w g() {
        w.a a2 = w.a;
        Type type = this.h().getGenericReturnType();
        j.a((Object)type, "member.genericReturnType");
        return a2.a(type);
    }

    public Method h() {
        return this.a;
    }

    public List<x> s() {
        TypeVariable<Method>[] arrtypeVariable = this.h().getTypeParameters();
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
        return this.h();
    }
}

