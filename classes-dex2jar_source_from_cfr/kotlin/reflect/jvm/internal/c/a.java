/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.c;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.c.b;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2={"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader;", "", "()V", "cache", "Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "getCache", "()Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "setCache", "(Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;)V", "buildCache", "member", "Ljava/lang/reflect/Member;", "loadParameterNames", "", "", "Cache", "descriptors.runtime"}, k=1, mv={1, 1, 11})
final class a {
    public static final a a = new a();
    private static a b;

    private a() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final a a(Member class_) {
        j.b(class_, "member");
        class_ = class_.getClass();
        try {
            Method method = class_.getMethod("getParameters", new Class[0]);
            return new a(method, b.a(class_).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return new a(null, null);
        }
    }

    public final List<String> b(Member arrobject) {
        Object object;
        j.b(arrobject, "member");
        Object object2 = object = b;
        if (object == null) {
            object2 = this.a((Member)arrobject);
            b = object2;
        }
        if ((object = ((a)object2).a()) != null && (object2 = ((a)object2).b()) != null) {
            if ((arrobject = ((Method)object).invoke(arrobject, new Object[0])) != null) {
                arrobject = arrobject;
                object = new ArrayList(arrobject.length);
                int n2 = arrobject.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Object object3 = ((Method)object2).invoke(arrobject[i2], new Object[0]);
                    if (object3 != null) {
                        object.add((String)object3);
                        continue;
                    }
                    throw new t("null cannot be cast to non-null type kotlin.String");
                }
                return (List)object;
            }
            throw new t("null cannot be cast to non-null type kotlin.Array<*>");
        }
        return null;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2={"Lkotlin/reflect/jvm/internal/structure/Java8ParameterNamesLoader$Cache;", "", "getParameters", "Ljava/lang/reflect/Method;", "getName", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetName", "()Ljava/lang/reflect/Method;", "getGetParameters", "descriptors.runtime"}, k=1, mv={1, 1, 11})
    public static final class a {
        private final Method a;
        private final Method b;

        public a(Method method, Method method2) {
            this.a = method;
            this.b = method2;
        }

        public final Method a() {
            return this.a;
        }

        public final Method b() {
            return this.b;
        }
    }

}

