/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.reflect.jvm.internal.c.b;
import kotlin.reflect.jvm.internal.c.j;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.c.x;
import kotlin.reflect.jvm.internal.impl.c.a.e.a;
import kotlin.reflect.jvm.internal.impl.c.a.e.i;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/Collection;", "classifier", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifier;", "getClassifier", "()Lorg/jetbrains/kotlin/load/java/structure/JavaClassifier;", "classifierQualifiedName", "", "getClassifierQualifiedName", "()Ljava/lang/String;", "isDeprecatedInJavaDoc", "", "()Z", "isRaw", "presentableText", "getPresentableText", "getReflectType", "()Ljava/lang/reflect/Type;", "typeArguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "getTypeArguments", "()Ljava/util/List;", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class l
extends w
implements kotlin.reflect.jvm.internal.impl.c.a.e.j {
    private final i b;
    private final Type c;

    /*
     * Enabled aggressive block sorting
     */
    public l(Type object) {
        kotlin.e.b.j.b(object, "reflectType");
        this.c = object;
        object = this.r_();
        if (object instanceof Class) {
            object = new j((Class)object);
        } else if (object instanceof TypeVariable) {
            object = new x((TypeVariable)object);
        } else {
            if (!(object instanceof ParameterizedType)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Not a classifier type (");
                stringBuilder.append(object.getClass());
                stringBuilder.append("): ");
                stringBuilder.append(object);
                throw (Throwable)new IllegalStateException(stringBuilder.toString());
            }
            if ((object = ((ParameterizedType)object).getRawType()) == null) {
                throw new t("null cannot be cast to non-null type java.lang.Class<*>");
            }
            object = new j((Class)object);
        }
        object = (i)object;
        this.b = object;
    }

    @Override
    public Collection<a> a() {
        return m.a();
    }

    @Override
    public a a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        kotlin.e.b.j.b(b2, "fqName");
        return null;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public i c() {
        return this.b;
    }

    @Override
    public List<v> d() {
        Object object = b.a(this.r_());
        w.a a2 = w.a;
        Collection collection = new ArrayList(m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(a2.a((Type)object.next()));
        }
        return (List)collection;
    }

    @Override
    public boolean e() {
        boolean bl2;
        TypeVariable<Class<T>>[] arrtypeVariable = this.r_();
        boolean bl3 = arrtypeVariable instanceof Class;
        boolean bl4 = bl2 = false;
        if (bl3) {
            arrtypeVariable = ((Class)arrtypeVariable).getTypeParameters();
            kotlin.e.b.j.a(arrtypeVariable, "getTypeParameters()");
            boolean bl5 = arrtypeVariable.length == 0;
            bl4 = bl2;
            if (bl5 ^ true) {
                bl4 = true;
            }
        }
        return bl4;
    }

    @Override
    public String f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type not found: ");
        stringBuilder.append(this.r_());
        throw (Throwable)new UnsupportedOperationException(stringBuilder.toString());
    }

    @Override
    public String g() {
        return this.r_().toString();
    }

    @Override
    public Type r_() {
        return this.c;
    }
}

