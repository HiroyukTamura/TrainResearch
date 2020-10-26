/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaWildcardType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaWildcardType;", "reflectType", "Ljava/lang/reflect/WildcardType;", "(Ljava/lang/reflect/WildcardType;)V", "bound", "getBound", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "isExtends", "", "()Z", "getReflectType", "()Ljava/lang/reflect/WildcardType;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class z
extends w
implements kotlin.reflect.jvm.internal.impl.c.a.e.z {
    private final WildcardType b;

    public z(WildcardType wildcardType) {
        j.b(wildcardType, "reflectType");
        this.b = wildcardType;
    }

    @Override
    public /* synthetic */ v a() {
        return this.d();
    }

    @Override
    public boolean b() {
        Type[] arrtype = this.e().getUpperBounds();
        j.a((Object)arrtype, "reflectType.upperBounds");
        return j.a((Object)g.d(arrtype), Object.class) ^ true;
    }

    public w d() {
        Object object = this.e().getUpperBounds();
        Object object2 = this.e().getLowerBounds();
        if (((Type[])object).length <= 1 && ((Type[])object2).length <= 1) {
            int n2 = ((Type[])object2).length;
            w.a a2 = null;
            if (n2 == 1) {
                a2 = w.a;
                j.a(object2, "lowerBounds");
                object2 = g.f(object2);
                j.a(object2, "lowerBounds.single()");
                return a2.a((Type)object2);
            }
            object2 = a2;
            if (((Type[])object).length == 1) {
                j.a(object, "upperBounds");
                object = g.f(object);
                object2 = a2;
                if (j.a(object, Object.class) ^ true) {
                    object2 = w.a;
                    j.a(object, "ub");
                    object2 = ((w.a)object2).a((Type)object);
                }
            }
            return object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Wildcard types with many bounds are not yet supported: ");
        ((StringBuilder)object2).append(this.e());
        throw (Throwable)new UnsupportedOperationException(((StringBuilder)object2).toString());
    }

    protected WildcardType e() {
        return this.b;
    }

    @Override
    public /* synthetic */ Type r_() {
        return this.e();
    }
}

