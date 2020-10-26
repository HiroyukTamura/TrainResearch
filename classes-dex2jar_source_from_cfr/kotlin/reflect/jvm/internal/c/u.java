/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.impl.c.a.e.a;
import kotlin.reflect.jvm.internal.impl.c.a.e.g;
import kotlin.reflect.jvm.internal.impl.c.a.e.t;
import kotlin.reflect.jvm.internal.impl.e.f;

@Metadata(bv={1, 0, 2}, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPackage;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "(Lorg/jetbrains/kotlin/name/FqName;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "isDeprecatedInJavaDoc", "", "()Z", "subPackages", "", "getSubPackages", "()Ljava/util/Collection;", "equals", "other", "", "findAnnotation", "", "getClasses", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "nameFilter", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "hashCode", "", "toString", "", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class u
extends n
implements t {
    private final kotlin.reflect.jvm.internal.impl.e.b a;

    public u(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        this.a = b2;
    }

    public /* synthetic */ Collection a() {
        return this.e();
    }

    @Override
    public Collection<g> a(b<? super f, Boolean> b2) {
        j.b(b2, "nameFilter");
        return m.a();
    }

    @Override
    public /* synthetic */ a a(kotlin.reflect.jvm.internal.impl.e.b b2) {
        return (a)((Object)this.b(b2));
    }

    public Void b(kotlin.reflect.jvm.internal.impl.e.b b2) {
        j.b(b2, "fqName");
        return null;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.b c() {
        return this.a;
    }

    @Override
    public Collection<t> d() {
        return m.a();
    }

    public List<a> e() {
        return m.a();
    }

    public boolean equals(Object object) {
        return object instanceof u && j.a((Object)this.c(), (Object)((u)object).c());
    }

    public int hashCode() {
        return this.c().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.c());
        return stringBuilder.toString();
    }
}

