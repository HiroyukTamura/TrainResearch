/*
 * Decompiled with CFR 0.139.
 */
package f;

import f.b;
import f.c;
import f.d;
import f.m;
import f.n;
import f.p;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

final class g
extends c.a {
    final Executor a;

    g(Executor executor) {
        this.a = executor;
    }

    @Override
    public c<?, ?> a(Type type, Annotation[] arrannotation, n n2) {
        if (g.a(type) != b.class) {
            return null;
        }
        return new c<Object, b<?>>(p.e(type)){
            final /* synthetic */ Type a;
            {
                this.a = type;
            }

            @Override
            public /* synthetic */ Object a(b b2) {
                return this.b(b2);
            }

            @Override
            public Type a() {
                return this.a;
            }

            public b<Object> b(b<Object> b2) {
                return new a<Object>(g.this.a, b2);
            }
        };
    }

    static final class a<T>
    implements b<T> {
        final Executor a;
        final b<T> b;

        a(Executor executor, b<T> b2) {
            this.a = executor;
            this.b = b2;
        }

        @Override
        public m<T> a() {
            return this.b.a();
        }

        @Override
        public void a(final d<T> d2) {
            p.a(d2, "callback == null");
            this.b.a(new d<T>(){

                @Override
                public void a(b<T> b2, final m<T> m2) {
                    a.this.a.execute(new Runnable(){

                        @Override
                        public void run() {
                            if (a.this.b.c()) {
                                d2.a(a.this, new IOException("Canceled"));
                                return;
                            }
                            d2.a(a.this, m2);
                        }
                    });
                }

                @Override
                public void a(b<T> b2, final Throwable throwable) {
                    a.this.a.execute(new Runnable(){

                        @Override
                        public void run() {
                            d2.a(a.this, throwable);
                        }
                    });
                }

            });
        }

        @Override
        public void b() {
            this.b.b();
        }

        @Override
        public boolean c() {
            return this.b.c();
        }

        public /* synthetic */ Object clone() {
            return this.d();
        }

        @Override
        public b<T> d() {
            return new a<T>(this.a, this.b.d());
        }

    }

}

