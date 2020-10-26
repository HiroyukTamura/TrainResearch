/*
 * Decompiled with CFR 0.139.
 */
package c.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class d
implements Closeable,
Flushable {
    static final Pattern a;
    static final /* synthetic */ boolean j;
    final c.a.f.a b;
    final int c;
    d.d d;
    final LinkedHashMap<String, b> e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private long m;
    private final Executor n;
    private final Runnable o;

    static {
        j = d.class.desiredAssertionStatus() ^ true;
        a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    private void d() {
        synchronized (this) {
            block4 : {
                boolean bl2 = this.b();
                if (bl2) break block4;
                return;
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(a object, boolean bl2) {
        synchronized (this) {
            void var2_2;
            int n2;
            b b2 = ((a)object).a;
            if (b2.f != object) {
                throw new IllegalStateException();
            }
            int n3 = n2 = 0;
            if (var2_2 != false) {
                n3 = n2;
                if (!b2.e) {
                    int n4 = 0;
                    do {
                        n3 = n2;
                        if (n4 >= this.c) break;
                        if (!((a)object).b[n4]) {
                            ((a)object).b();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Newly created entry didn't create value for index ");
                            ((StringBuilder)object).append(n4);
                            throw new IllegalStateException(((StringBuilder)object).toString());
                        }
                        if (!this.b.b(b2.d[n4])) {
                            ((a)object).b();
                            return;
                        }
                        ++n4;
                    } while (true);
                }
            }
            do {
                long l2;
                if (n3 < this.c) {
                    object = b2.d[n3];
                    if (var2_2 != false) {
                        if (this.b.b((File)object)) {
                            long l3;
                            File file = b2.c[n3];
                            this.b.a((File)object, file);
                            l2 = b2.b[n3];
                            b2.b[n3] = l3 = this.b.c(file);
                            this.l = this.l - l2 + l3;
                        }
                    } else {
                        this.b.a((File)object);
                    }
                } else {
                    ++this.f;
                    b2.f = null;
                    if ((b2.e | var2_2) != 0) {
                        b2.e = true;
                        this.d.b("CLEAN").i(32);
                        this.d.b(b2.a);
                        b2.a(this.d);
                        this.d.i(10);
                        if (var2_2 != false) {
                            l2 = this.m;
                            this.m = 1L + l2;
                            b2.g = l2;
                        }
                    } else {
                        this.e.remove(b2.a);
                        this.d.b("REMOVE").i(32);
                        this.d.b(b2.a);
                        this.d.i(10);
                    }
                    this.d.flush();
                    if (this.l > this.k || this.a()) {
                        this.n.execute(this.o);
                    }
                    return;
                }
                ++n3;
            } while (true);
        }
    }

    boolean a() {
        return this.f >= 2000 && this.f >= this.e.size();
    }

    boolean a(b b2) {
        if (b2.f != null) {
            b2.f.a();
        }
        for (int i2 = 0; i2 < this.c; ++i2) {
            this.b.a(b2.c[i2]);
            this.l -= b2.b[i2];
            b2.b[i2] = 0L;
        }
        ++this.f;
        this.d.b("REMOVE").i(32).b(b2.a).i(10);
        this.e.remove(b2.a);
        if (this.a()) {
            this.n.execute(this.o);
        }
        return true;
    }

    public boolean b() {
        synchronized (this) {
            boolean bl2 = this.h;
            return bl2;
        }
    }

    void c() {
        while (this.l > this.k) {
            this.a(this.e.values().iterator().next());
        }
        this.i = false;
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void close() {
        synchronized (this) {
            if (!this.g || this.h) {
                this.h = true;
                return;
            }
            b[] arrb = this.e.values().toArray(new b[this.e.size()]);
            int n2 = arrb.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    this.c();
                    this.d.close();
                    this.d = null;
                    this.h = true;
                    return;
                }
                b b2 = arrb[n3];
                if (b2.f != null) {
                    b2.f.b();
                }
                ++n3;
            } while (true);
        }
    }

    @Override
    public void flush() {
        synchronized (this) {
            block4 : {
                boolean bl2 = this.g;
                if (bl2) break block4;
                return;
            }
            this.d();
            this.c();
            this.d.flush();
            return;
        }
    }

    public final class a {
        final b a;
        final boolean[] b;
        final /* synthetic */ d c;
        private boolean d;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        void a() {
            if (this.a.f != this) return;
            int n2 = 0;
            do {
                if (n2 >= this.c.c) {
                    this.a.f = null;
                    return;
                }
                try {
                    this.c.b.a(this.a.d[n2]);
                }
                catch (IOException iOException) {}
                ++n2;
            } while (true);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void b() {
            d d2 = this.c;
            synchronized (d2) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    this.c.a(this, false);
                }
                this.d = true;
                return;
            }
        }
    }

    private final class b {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        a f;
        long g;

        void a(d.d d2) {
            for (long l2 : this.b) {
                d2.i(32).m(l2);
            }
        }
    }

}

