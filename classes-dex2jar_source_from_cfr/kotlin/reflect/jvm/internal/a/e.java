/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.a;

import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.a.b;
import kotlin.reflect.jvm.internal.impl.c.b.n;

@Metadata(bv={1, 0, 2}, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001b\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u001a\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006#"}, d2={"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass;", "klass", "Ljava/lang/Class;", "classHeader", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/header/KotlinClassHeader;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader;)V", "getClassHeader", "()Lorg/jetbrains/kotlin/load/kotlin/header/KotlinClassHeader;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "getKlass", "()Ljava/lang/Class;", "location", "", "getLocation", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "loadClassAnnotations", "", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "cachedContents", "", "toString", "visitMembers", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "Factory", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class e
implements kotlin.reflect.jvm.internal.impl.c.b.n {
    public static final a a = new a(null);
    private final Class<?> b;
    private final kotlin.reflect.jvm.internal.impl.c.b.a.a c;

    private e(Class<?> class_, kotlin.reflect.jvm.internal.impl.c.b.a.a a2) {
        this.b = class_;
        this.c = a2;
    }

    public /* synthetic */ e(Class class_, kotlin.reflect.jvm.internal.impl.c.b.a.a a2, g g2) {
        this(class_, a2);
    }

    @Override
    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b.getName();
        j.a((Object)string2, "klass.name");
        stringBuilder.append(n.a(string2, '.', '/', false, 4, null));
        stringBuilder.append(".class");
        return stringBuilder.toString();
    }

    @Override
    public void a(n.c c2, byte[] arrby) {
        j.b(c2, "visitor");
        b.a.a(this.b, c2);
    }

    @Override
    public void a(n.d d2, byte[] arrby) {
        j.b(d2, "visitor");
        b.a.a(this.b, d2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.e.a b() {
        return kotlin.reflect.jvm.internal.c.b.e(this.b);
    }

    public final Class<?> c() {
        return this.b;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.c.b.a.a d() {
        return this.c;
    }

    public boolean equals(Object object) {
        return object instanceof e && j.a(this.b, ((e)object).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u00a8\u0006\u0007"}, d2={"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/components/ReflectKotlinClass;", "klass", "Ljava/lang/Class;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final e a(Class<?> class_) {
            j.b(class_, "klass");
            Object object = new kotlin.reflect.jvm.internal.impl.c.b.a.b();
            b.a.a(class_, (n.c)object);
            object = ((kotlin.reflect.jvm.internal.impl.c.b.a.b)object).b();
            if (object != null) {
                return new e(class_, (kotlin.reflect.jvm.internal.impl.c.b.a.a)object, null);
            }
            return null;
        }
    }

}

