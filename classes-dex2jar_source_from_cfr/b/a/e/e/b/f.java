/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.e.b;

import b.a.g;
import b.a.h;
import java.util.concurrent.atomic.AtomicReference;

public final class f<T>
extends b.a.e.e.b.a<T, T> {
    final h b;

    public f(b.a.f<T> f2, h h2) {
        super(f2);
        this.b = h2;
    }

    @Override
    public void b(g<? super T> g2) {
        a<T> a2 = new a<T>(g2);
        g2.a(a2);
        a2.b(this.b.a(new b(a2)));
    }

    static final class a<T>
    extends AtomicReference<b.a.b.b>
    implements b.a.b.b,
    g<T> {
        final g<? super T> a;
        final AtomicReference<b.a.b.b> b;

        a(g<? super T> g2) {
            this.a = g2;
            this.b = new AtomicReference();
        }

        @Override
        public void a() {
            b.a.e.a.b.a(this.b);
            b.a.e.a.b.a(this);
        }

        @Override
        public void a(b.a.b.b b2) {
            b.a.e.a.b.a(this.b, b2);
        }

        @Override
        public void a(Throwable throwable) {
            this.a.a(throwable);
        }

        @Override
        public void a_(T t2) {
            this.a.a_(t2);
        }

        void b(b.a.b.b b2) {
            b.a.e.a.b.a(this, b2);
        }

        @Override
        public void b_() {
            this.a.b_();
        }
    }

    final class b
    implements Runnable {
        private final a<T> b;

        b(a<T> a2) {
            this.b = a2;
        }

        @Override
        public void run() {
            f.this.a.a(this.b);
        }
    }

}

