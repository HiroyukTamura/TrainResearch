/*
 * Decompiled with CFR 0.139.
 */
package f.a.a;

import b.a.b.b;
import b.a.g;
import f.a.a.e;
import f.m;

final class f<T>
extends b.a.e<e<T>> {
    private final b.a.e<m<T>> a;

    f(b.a.e<m<T>> e2) {
        this.a = e2;
    }

    @Override
    protected void b(g<? super e<T>> g2) {
        this.a.a(new a(g2));
    }

    private static class a<R>
    implements g<m<R>> {
        private final g<? super e<R>> a;

        a(g<? super e<R>> g2) {
            this.a = g2;
        }

        @Override
        public void a(b b2) {
            this.a.a(b2);
        }

        public void a(m<R> m2) {
            this.a.a_(e.a(m2));
        }

        @Override
        public void a(Throwable throwable) {
            try {
                this.a.a_(e.a(throwable));
                this.a.b_();
                return;
            }
            catch (Throwable throwable2) {
                try {
                    this.a.a(throwable2);
                    return;
                }
                catch (Throwable throwable3) {
                    b.a.c.b.b(throwable3);
                    b.a.f.a.a(new b.a.c.a(throwable2, throwable3));
                    return;
                }
            }
        }

        @Override
        public /* synthetic */ void a_(Object object) {
            this.a((m)object);
        }

        @Override
        public void b_() {
            this.a.b_();
        }
    }

}

