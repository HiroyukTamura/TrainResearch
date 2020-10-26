/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.c;
import kotlin.reflect.jvm.internal.c.f;
import kotlin.reflect.jvm.internal.c.l;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.impl.c.a.e.a;
import kotlin.reflect.jvm.internal.impl.c.a.e.w;
import kotlin.reflect.jvm.internal.impl.e.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "typeVariable", "Ljava/lang/reflect/TypeVariable;", "(Ljava/lang/reflect/TypeVariable;)V", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "getTypeVariable", "()Ljava/lang/reflect/TypeVariable;", "upperBounds", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "getUpperBounds", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class x
extends n
implements f,
w {
    private final TypeVariable<?> a;

    public x(TypeVariable<?> typeVariable) {
        j.b(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    public /* synthetic */ Collection a() {
        return this.e();
    }

    @Override
    public /* synthetic */ a a(b b2) {
        return this.b(b2);
    }

    public c b(b b2) {
        j.b(b2, "fqName");
        return f.a.a(this, b2);
    }

    @Override
    public boolean b() {
        return f.a.b(this);
    }

    public /* synthetic */ Collection c() {
        return this.d();
    }

    public List<l> d() {
        Object object = this.a.getBounds();
        j.a(object, "typeVariable.bounds");
        Collection collection = new ArrayList(((Type[])object).length);
        int n2 = ((Type[])object).length;
        for (int i2 = 0; i2 < n2; ++i2) {
            collection.add(new l(object[i2]));
        }
        object = (l)m.k(collection = (List)collection);
        object = object != null ? ((l)object).r_() : null;
        if (j.a(object, Object.class)) {
            return m.a();
        }
        return collection;
    }

    public List<c> e() {
        return f.a.a(this);
    }

    public boolean equals(Object object) {
        return object instanceof x && j.a(this.a, ((x)object).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.f r() {
        kotlin.reflect.jvm.internal.impl.e.f f2 = kotlin.reflect.jvm.internal.impl.e.f.a(this.a.getName());
        j.a((Object)f2, "Name.identifier(typeVariable.name)");
        return f2;
    }

    @Override
    public AnnotatedElement t() {
        TypeVariable<?> typeVariable;
        TypeVariable<?> typeVariable2 = typeVariable = this.a;
        if (!(typeVariable instanceof AnnotatedElement)) {
            typeVariable2 = null;
        }
        return typeVariable2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}

