/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;

public class ac {
    public static <T> a<T> a(T t2, kotlin.e.a.a<T> a2) {
        return new a<T>(t2, a2);
    }

    public static <T> b<T> a(kotlin.e.a.a<T> a2) {
        return new b<T>(a2);
    }

    public static <T> a<T> b(kotlin.e.a.a<T> a2) {
        return ac.a(null, a2);
    }

    public static class a<T>
    extends c<T> {
        private final kotlin.e.a.a<T> a;
        private SoftReference<Object> b = null;

        public a(T t2, kotlin.e.a.a<T> a2) {
            this.a = a2;
            if (t2 != null) {
                this.b = new SoftReference<Object>(this.a(t2));
            }
        }

        @Override
        public T a() {
            SoftReference<Object> softReference = this.b;
            if (softReference != null && (softReference = softReference.get()) != null) {
                return this.b(softReference);
            }
            softReference = this.a.a();
            this.b = new SoftReference<Object>(this.a(softReference));
            return (T)softReference;
        }
    }

    public static class b<T>
    extends c<T> {
        private final kotlin.e.a.a<T> a;
        private Object b = null;

        public b(kotlin.e.a.a<T> a2) {
            this.a = a2;
        }

        @Override
        public T a() {
            Object object = this.b;
            if (object != null) {
                return this.b(object);
            }
            object = this.a.a();
            this.b = this.a(object);
            return (T)object;
        }
    }

    public static abstract class c<T> {
        private static final Object a = new Object(){};

        public abstract T a();

        protected Object a(T t2) {
            Object object = t2;
            if (t2 == null) {
                object = a;
            }
            return object;
        }

        public final T a(Object object, Object object2) {
            return this.a();
        }

        protected T b(Object object) {
            Object object2 = object;
            if (object == a) {
                object2 = null;
            }
            return (T)object2;
        }

    }

}

