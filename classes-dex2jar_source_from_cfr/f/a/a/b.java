/*
 * Decompiled with CFR 0.139.
 */
package f.a.a;

import b.a.e;
import b.a.g;
import f.d;
import f.m;

final class b<T>
extends e<m<T>> {
    private final f.b<T> a;

    b(f.b<T> b2) {
        this.a = b2;
    }

    @Override
    protected void b(g<? super m<T>> g2) {
        f.b b2 = this.a.d();
        a a2 = new a(b2, g2);
        g2.a(a2);
        b2.a(a2);
    }

    private static final class a<T>
    implements b.a.b.b,
    d<T> {
        boolean a = false;
        private final f.b<?> b;
        private final g<? super m<T>> c;
        private volatile boolean d;

        a(f.b<?> b2, g<? super m<T>> g2) {
            this.b = b2;
            this.c = g2;
        }

        @Override
        public void a() {
            this.d = true;
            this.b.b();
        }

        @Override
        public void a(f.b<T> b2, m<T> m2) {
            block7 : {
                if (this.d) {
                    return;
                }
                try {
                    this.c.a_(m2);
                    if (!this.d) {
                        this.a = true;
                        this.c.b_();
                        return;
                    }
                }
                catch (Throwable throwable) {
                    if (this.a) {
                        b.a.f.a.a(throwable);
                        return;
                    }
                    if (this.d) break block7;
                    try {
                        this.c.a(throwable);
                        return;
                    }
                    catch (Throwable throwable2) {
                        b.a.c.b.b(throwable2);
                        b.a.f.a.a(new b.a.c.a(throwable, throwable2));
                    }
                }
            }
        }

        @Override
        public void a(f.b<T> b2, Throwable throwable) {
            if (b2.c()) {
                return;
            }
            try {
                this.c.a(throwable);
                return;
            }
            catch (Throwable throwable2) {
                b.a.c.b.b(throwable2);
                b.a.f.a.a(new b.a.c.a(throwable, throwable2));
                return;
            }
        }
    }

}

