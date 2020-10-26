/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.c.a;
import kotlin.reflect.jvm.internal.c.c;
import kotlin.reflect.jvm.internal.c.f;
import kotlin.reflect.jvm.internal.c.j;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.c.t;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.c.y;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.c.a.e.p;
import kotlin.reflect.jvm.internal.impl.e.b;
import kotlin.reflect.jvm.internal.impl.e.h;

@Metadata(bv={1, 0, 2}, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J=\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\"0\"2\u0006\u0010&\u001a\u00020\u001bH\u0004\u00a2\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006+"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMember;", "()V", "containingClass", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "getContainingClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "member", "Ljava/lang/reflect/Member;", "getMember", "()Ljava/lang/reflect/Member;", "modifiers", "", "getModifiers", "()I", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "equals", "", "other", "", "getValueParameters", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "isVararg", "([Ljava/lang/reflect/Type;[[Ljava/lang/annotation/Annotation;Z)Ljava/util/List;", "hashCode", "toString", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public abstract class r
extends n
implements f,
t,
p {
    public /* synthetic */ Collection a() {
        return this.j();
    }

    protected final List<kotlin.reflect.jvm.internal.impl.c.a.e.y> a(Type[] object, Annotation[][] arrannotation, boolean bl2) {
        kotlin.e.b.j.b(object, "parameterTypes");
        kotlin.e.b.j.b(arrannotation, "parameterAnnotations");
        ArrayList<y> arrayList = new ArrayList<y>(((Type[])object).length);
        List<String> list = a.a.b(this.s_());
        int n2 = list != null ? list.size() - ((Type[])object).length : 0;
        int n3 = ((Type[])object).length;
        for (int i2 = 0; i2 < n3; ++i2) {
            String string2;
            w w2 = w.a.a(object[i2]);
            if (list != null) {
                string2 = m.c(list, i2 + n2);
                if (string2 == null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("No parameter with index ");
                    ((StringBuilder)object).append(i2);
                    ((StringBuilder)object).append('+');
                    ((StringBuilder)object).append(n2);
                    ((StringBuilder)object).append(" (name=");
                    ((StringBuilder)object).append(this.r());
                    ((StringBuilder)object).append(" type=");
                    ((StringBuilder)object).append(w2);
                    ((StringBuilder)object).append(") in ");
                    ((StringBuilder)object).append(list);
                    ((StringBuilder)object).append("@ReflectJavaMember");
                    throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
                }
            } else {
                string2 = null;
            }
            boolean bl3 = bl2 && i2 == g.g(object);
            arrayList.add(new y(w2, arrannotation[i2], string2, bl3));
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.e.a a(b b2) {
        return this.b(b2);
    }

    public c b(b b2) {
        kotlin.e.b.j.b(b2, "fqName");
        return f.a.a(this, b2);
    }

    @Override
    public boolean b() {
        return f.a.b(this);
    }

    public boolean equals(Object object) {
        return object instanceof r && kotlin.e.b.j.a((Object)this.s_(), (Object)((r)object).s_());
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.e.g f() {
        return this.i();
    }

    public int hashCode() {
        return this.s_().hashCode();
    }

    public j i() {
        Class<?> class_ = this.s_().getDeclaringClass();
        kotlin.e.b.j.a(class_, "member.declaringClass");
        return new j(class_);
    }

    public List<c> j() {
        return f.a.a(this);
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
        Object object = this.s_().getName();
        if (object != null && (object = kotlin.reflect.jvm.internal.impl.e.f.a((String)object)) != null) {
            return object;
        }
        object = h.a;
        kotlin.e.b.j.a(object, "SpecialNames.NO_NAME_PROVIDED");
        return object;
    }

    public abstract Member s_();

    @Override
    public AnnotatedElement t() {
        Member member = this.s_();
        if (member != null) {
            return (AnnotatedElement)((Object)member);
        }
        throw new kotlin.t("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.s_());
        return stringBuilder.toString();
    }

    @Override
    public int v() {
        return this.s_().getModifiers();
    }
}

