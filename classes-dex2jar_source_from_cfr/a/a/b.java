/*
 * Decompiled with CFR 0.139.
 */
package a.a;

public interface b<T> {
    public void a(T var1);

    public static abstract class a<T>
    implements b<T> {
        public abstract b<T> a();

        @Override
        public final b<T> a(T t2) {
            this.b(t2);
            return this.a();
        }

        public abstract void b(T var1);
    }

    public static interface b<T> {
        public b<T> a(T var1);
    }

}

