/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import f.b;
import f.n;
import f.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public interface c<R, T> {
    public T a(b<R> var1);

    public Type a();

    public static abstract class a {
        protected static Class<?> a(Type type) {
            return p.a(type);
        }

        protected static Type a(int n2, ParameterizedType parameterizedType) {
            return p.a(n2, parameterizedType);
        }

        @Nullable
        public abstract c<?, ?> a(Type var1, Annotation[] var2, n var3);
    }

}
