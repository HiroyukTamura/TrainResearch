/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package f;

import c.ac;
import c.ad;
import c.e;
import c.f;
import c.v;
import d.c;
import d.h;
import d.l;
import d.t;
import f.d;
import f.m;
import f.o;
import f.p;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class i<T>
implements f.b<T> {
    private final o<T, ?> a;
    @Nullable
    private final Object[] b;
    private volatile boolean c;
    @Nullable
    @GuardedBy(value="this")
    private e d;
    @Nullable
    @GuardedBy(value="this")
    private Throwable e;
    @GuardedBy(value="this")
    private boolean f;

    i(o<T, ?> o2, @Nullable Object[] arrobject) {
        this.a = o2;
        this.b = arrobject;
    }

    private e f() {
        e e2 = this.a.a(this.b);
        if (e2 != null) {
            return e2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public m<T> a() {
        e e2;
        // MONITORENTER : this
        if (this.f) throw new IllegalStateException("Already executed.");
        this.f = true;
        if (this.e != null) {
            if (this.e instanceof IOException) throw (IOException)this.e;
            if (!(this.e instanceof RuntimeException)) throw (Error)this.e;
            throw (RuntimeException)this.e;
        }
        e e3 = e2 = this.d;
        if (e2 == null) {
            try {
                this.d = e3 = this.f();
            }
            catch (IOException | Error | RuntimeException throwable2) {
                p.a(throwable2);
                this.e = throwable2;
                throw throwable2;
            }
        }
        // MONITOREXIT : this
        if (!this.c) return this.a(e3.a());
        e3.b();
        return this.a(e3.a());
    }

    m<T> a(ac object) {
        Object object2 = ((ac)object).g();
        ac ac2 = ((ac)object).h().a(new b(((ad)object2).a(), ((ad)object2).b())).a();
        int n2 = ac2.b();
        if (n2 >= 200 && n2 < 300) {
            if (n2 != 204 && n2 != 205) {
                object = new a((ad)object2);
                try {
                    object2 = m.a(this.a.a((ad)object), ac2);
                    return object2;
                }
                catch (RuntimeException runtimeException) {
                    ((a)object).f();
                    throw runtimeException;
                }
            }
            ((ad)object2).close();
            return m.a(null, ac2);
        }
        try {
            object = m.a(p.a((ad)object2), ac2);
            return object;
        }
        finally {
            ((ad)object2).close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void a(final d<T> d2) {
        p.a(d2, "callback == null");
        // MONITORENTER : this
        if (this.f) throw new IllegalStateException("Already executed.");
        this.f = true;
        e e2 = this.d;
        Throwable throwable = this.e;
        e e3 = e2;
        Throwable throwable2 = throwable;
        if (e2 == null) {
            e3 = e2;
            throwable2 = throwable;
            if (throwable == null) {
                try {
                    this.d = e3 = this.f();
                    throwable2 = throwable;
                }
                catch (Throwable throwable3) {
                    p.a(throwable3);
                    this.e = throwable3;
                    e3 = e2;
                }
            }
        }
        // MONITOREXIT : this
        if (throwable2 != null) {
            d2.a(this, throwable2);
            return;
        }
        if (this.c) {
            e3.b();
        }
        e3.a(new f(){

            private void a(Throwable throwable) {
                try {
                    d2.a(i.this, throwable);
                    return;
                }
                catch (Throwable throwable2) {
                    throwable2.printStackTrace();
                    return;
                }
            }

            @Override
            public void a(e object, ac ac2) {
                try {
                    object = i.this.a(ac2);
                }
                catch (Throwable throwable) {
                    this.a(throwable);
                    return;
                }
                try {
                    d2.a(i.this, object);
                    return;
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                    return;
                }
            }

            @Override
            public void a(e e2, IOException iOException) {
                this.a(iOException);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void b() {
        this.c = true;
        // MONITORENTER : this
        e e2 = this.d;
        // MONITOREXIT : this
        if (e2 == null) return;
        e2.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean c() {
        boolean bl2 = this.c;
        boolean bl3 = true;
        if (bl2) {
            return true;
        }
        synchronized (this) {
            if (this.d == null) return false;
            if (this.d.c()) return bl3;
            return false;
        }
    }

    public /* synthetic */ Object clone() {
        return this.e();
    }

    @Override
    public /* synthetic */ f.b d() {
        return this.e();
    }

    public i<T> e() {
        return new i<T>(this.a, this.b);
    }

    static final class a
    extends ad {
        IOException a;
        private final ad b;

        a(ad ad2) {
            this.b = ad2;
        }

        @Override
        public v a() {
            return this.b.a();
        }

        @Override
        public long b() {
            return this.b.b();
        }

        @Override
        public void close() {
            this.b.close();
        }

        @Override
        public d.e d() {
            return l.a(new h(this.b.d()){

                @Override
                public long a(c c2, long l2) {
                    try {
                        l2 = super.a(c2, l2);
                        return l2;
                    }
                    catch (IOException iOException) {
                        a.this.a = iOException;
                        throw iOException;
                    }
                }
            });
        }

        void f() {
            if (this.a == null) {
                return;
            }
            throw this.a;
        }

    }

    static final class b
    extends ad {
        private final v a;
        private final long b;

        b(v v2, long l2) {
            this.a = v2;
            this.b = l2;
        }

        @Override
        public v a() {
            return this.a;
        }

        @Override
        public long b() {
            return this.b;
        }

        @Override
        public d.e d() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

}

