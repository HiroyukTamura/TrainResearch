/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.impl.c.a.e.f;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "componentType", "getComponentType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReflectType", "()Ljava/lang/reflect/Type;", "descriptors.runtime"}, k=1, mv={1, 1, 11})
public final class i
extends w
implements f {
    private final w b;
    private final Type c;

    /*
     * Enabled aggressive block sorting
     */
    public i(Type object) {
        block4 : {
            void var2_4;
            block3 : {
                Class class_;
                Type type;
                block2 : {
                    j.b(object, "reflectType");
                    this.c = object;
                    type = this.r_();
                    if (!(type instanceof GenericArrayType)) break block2;
                    object = w.a;
                    Type type2 = ((GenericArrayType)type).getGenericComponentType();
                    j.a((Object)type2, "genericComponentType");
                    break block3;
                }
                if (!(type instanceof Class) || !(class_ = (Class)type).isArray()) break block4;
                object = w.a;
                Class<?> class_2 = class_.getComponentType();
                j.a(class_2, "getComponentType()");
                Type type3 = class_2;
            }
            object = ((w.a)object).a((Type)var2_4);
            this.b = object;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Not an array type (");
        ((StringBuilder)object).append(this.r_().getClass());
        ((StringBuilder)object).append("): ");
        ((StringBuilder)object).append(this.r_());
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @Override
    public /* synthetic */ v a() {
        return this.b();
    }

    public w b() {
        return this.b;
    }

    @Override
    protected Type r_() {
        return this.c;
    }
}

