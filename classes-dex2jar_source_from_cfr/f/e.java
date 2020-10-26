/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f;

import c.ab;
import c.ad;
import f.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public interface e<F, T> {
    public T a(F var1);

    public static abstract class a {
        @Nullable
        public e<ad, ?> a(Type type, Annotation[] arrannotation, n n2) {
            return null;
        }

        @Nullable
        public e<?, ab> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, n n2) {
            return null;
        }

        @Nullable
        public e<?, String> b(Type type, Annotation[] arrannotation, n n2) {
            return null;
        }
    }

}

