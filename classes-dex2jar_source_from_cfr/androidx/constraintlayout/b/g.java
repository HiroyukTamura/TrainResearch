/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b;

final class g {

    static interface a<T> {
        public T a();

        public void a(T[] var1, int var2);

        public boolean a(T var1);
    }

    static class b<T>
    implements a<T> {
        private final Object[] a;
        private int b;

        b(int n2) {
            if (n2 > 0) {
                this.a = new Object[n2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
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
        public void a(T[] arrT, int n2) {
            int n3 = n2;
            if (n2 > arrT.length) {
                n3 = arrT.length;
            }
            for (n2 = 0; n2 < n3; ++n2) {
                T t2 = arrT[n2];
                if (this.b >= this.a.length) continue;
                this.a[this.b] = t2;
                ++this.b;
            }
        }

        @Override
        public boolean a(T t2) {
            if (this.b < this.a.length) {
                this.a[this.b] = t2;
                ++this.b;
                return true;
            }
            return false;
        }
    }

}

