/*
 * Decompiled with CFR 0.139.
 */
package f.a.a;

import b.a.b.b;
import b.a.e;
import b.a.g;
import f.a.a.d;
import f.m;

final class a<T>
extends e<T> {
    private final e<m<T>> a;

    a(e<m<T>> e2) {
        this.a = e2;
    }

    @Override
    protected void b(g<? super T> g2) {
        this.a.a(new a<T>(g2));
    }

    private static class a<R>
    implements g<m<R>> {
        private final g<? super R> a;
        private boolean b;

        a(g<? super R> g2) {
            this.a = g2;
        }

        @Override
        public void a(b b2) {
            this.a.a(b2);
        }

        public void a(m<R> object) {
            if (((m)object).c()) {
                this.a.a_(((m)object).d());
                return;
            }
            this.b = true;
            object = new d((m<?>)object);
            try {
                this.a.a((Throwable)object);
                return;
            }
            catch (Throwable throwable) {
                b.a.c.b.b(throwable);
                b.a.f.a.a(new b.a.c.a(new Throwable[]{object, throwable}));
                return;
            }
        }

        @Override
        public void a(Throwable throwable) {
            if (!this.b) {
                this.a.a(throwable);
                return;
            }
            AssertionError assertionError = new AssertionError((Object)"This should never happen! Report as a bug with the full stacktrace.");
            ((Throwable)((Object)assertionError)).initCause(throwable);
            b.a.f.a.a((Throwable)((Object)assertionError));
        }

        @Override
        public /* synthetic */ void a_(Object object) {
            this.a((m)object);
        }

        @Override
        public void b_() {
            if (!this.b) {
                this.a.b_();
            }
        }
    }

}

