/*
 * Decompiled with CFR 0.139.
 */
package androidx.core.g;

public final class d {

    public static interface a<T> {
        public T a();

        public boolean a(T var1);
    }

    public static class b<T>
    implements a<T> {
        private final Object[] a;
        private int b;

        public b(int n2) {
            if (n2 > 0) {
                this.a = new Object[n2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean b(T t2) {
            for (int i2 = 0; i2 < this.b; ++i2) {
                if (this.a[i2] != t2) continue;
                return true;
            }
            return false;
        }

        @Override
        public T a() {
            if (this.b > 0) {
                int n2 = this.b - 1;
                Object object = this.a[n2];
                this.a[n2] = null;
                --this.b;
                return (T)object;
            }
            return null;
        }

        @Override
        public boolean a(T t2) {
            if (!this.b(t2)) {
                if (this.b < this.a.length) {
                    this.a[this.b] = t2;
                    ++this.b;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class c<T>
    extends b<T> {
        private final Object a = new Object();

        public c(int n2) {
            super(n2);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T a() {
            Object object = this.a;
            synchronized (object) {
                Object t2 = super.a();
                return t2;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public boolean a(T t2) {
            Object object = this.a;
            synchronized (object) {
                return super.a(t2);
            }
        }
    }

}

