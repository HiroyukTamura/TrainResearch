/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.e.g;
import c.a.e.m;
import c.a.e.n;
import d.e;
import d.s;
import d.t;
import d.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class i {
    static final /* synthetic */ boolean i;
    long a = 0L;
    long b;
    final int c;
    final g d;
    final a e;
    final c f = new c();
    final c g = new c();
    c.a.e.b h = null;
    private final List<c.a.e.c> j;
    private List<c.a.e.c> k;
    private boolean l;
    private final b m;

    static {
        i = i.class.desiredAssertionStatus() ^ true;
    }

    i(int n2, g g2, boolean bl2, boolean bl3, List<c.a.e.c> list) {
        if (g2 != null) {
            if (list != null) {
                this.c = n2;
                this.d = g2;
                this.b = g2.l.d();
                this.m = new b(g2.k.d());
                this.e = new a();
                this.m.b = bl3;
                this.e.b = bl2;
                this.j = list;
                return;
            }
            throw new NullPointerException("requestHeaders == null");
        }
        throw new NullPointerException("connection == null");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean d(c.a.e.b b2) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.h != null) {
                return false;
            }
            if (this.m.b && this.e.b) {
                return false;
            }
            this.h = b2;
            this.notifyAll();
        }
        this.d.b(this.c);
        return true;
    }

    public int a() {
        return this.c;
    }

    void a(long l2) {
        this.b += l2;
        if (l2 > 0L) {
            this.notifyAll();
        }
    }

    public void a(c.a.e.b b2) {
        if (!this.d(b2)) {
            return;
        }
        this.d.b(this.c, b2);
    }

    void a(e e2, int n2) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.a(e2, (long)n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void a(List<c.a.e.c> list) {
        if (!i) {
            if (Thread.holdsLock(this)) throw new AssertionError();
        }
        // MONITORENTER : this
        boolean bl2 = true;
        this.l = true;
        if (this.k == null) {
            this.k = list;
            bl2 = this.b();
            this.notifyAll();
        } else {
            ArrayList<c.a.e.c> arrayList = new ArrayList<c.a.e.c>();
            arrayList.addAll(this.k);
            arrayList.add(null);
            arrayList.addAll(list);
            this.k = arrayList;
        }
        // MONITOREXIT : this
        if (bl2) return;
        this.d.b(this.c);
    }

    public void b(c.a.e.b b2) {
        if (!this.d(b2)) {
            return;
        }
        this.d.a(this.c, b2);
    }

    public boolean b() {
        synchronized (this) {
            block5 : {
                boolean bl2;
                block4 : {
                    c.a.e.b b2 = this.h;
                    if (b2 == null) break block4;
                    return false;
                }
                if (!this.m.b && !this.m.a || !this.e.b && !this.e.a || !(bl2 = this.l)) break block5;
                return false;
            }
            return true;
        }
    }

    void c(c.a.e.b b2) {
        synchronized (this) {
            if (this.h == null) {
                this.h = b2;
                this.notifyAll();
            }
            return;
        }
    }

    public boolean c() {
        boolean bl2 = (this.c & 1) == 1;
        return this.d.a == bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<c.a.e.c> d() {
        synchronized (this) {
            block8 : {
                if (!this.c()) {
                    throw new IllegalStateException("servers cannot read response headers");
                }
                this.f.c();
                while (this.k == null && this.h == null) {
                    this.l();
                }
                List<c.a.e.c> list = this.k;
                if (list == null) break block8;
                this.k = null;
                return list;
            }
            throw new n(this.h);
            finally {
                this.f.b();
            }
        }
    }

    public u e() {
        return this.f;
    }

    public u f() {
        return this.g;
    }

    public t g() {
        return this.m;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public s h() {
        synchronized (this) {
            if (!this.l && !this.c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.e;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void i() {
        if (!i) {
            if (Thread.holdsLock(this)) throw new AssertionError();
        }
        // MONITORENTER : this
        this.m.b = true;
        boolean bl2 = this.b();
        this.notifyAll();
        // MONITOREXIT : this
        if (bl2) return;
        this.d.b(this.c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void j() {
        if (!i) {
            if (Thread.holdsLock(this)) throw new AssertionError();
        }
        // MONITORENTER : this
        boolean bl2 = !this.m.b && this.m.a && (this.e.b || this.e.a);
        boolean bl3 = this.b();
        // MONITOREXIT : this
        if (bl2) {
            this.a(c.a.e.b.f);
            return;
        }
        if (bl3) return;
        this.d.b(this.c);
    }

    void k() {
        if (!this.e.a) {
            if (!this.e.b) {
                if (this.h == null) {
                    return;
                }
                throw new n(this.h);
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void l() {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException interruptedException) {
            throw new InterruptedIOException();
        }
    }

    final class a
    implements s {
        static final /* synthetic */ boolean c;
        boolean a;
        boolean b;
        private final d.c e = new d.c();

        static {
            c = i.class.desiredAssertionStatus() ^ true;
        }

        a() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void a(boolean bl2) {
            long l2;
            Object object = i.this;
            synchronized (object) {
                i.this.g.c();
                while (i.this.b <= 0L && !this.b && !this.a && i.this.h == null) {
                    i.this.l();
                }
                i.this.k();
                l2 = Math.min(i.this.b, this.e.b());
                i i2 = i.this;
                i2.b -= l2;
            }
            i.this.g.c();
            try {
                object = i.this.d;
                int n2 = i.this.c;
                bl2 = bl2 && l2 == this.e.b();
                ((g)object).a(n2, bl2, this.e, l2);
                i.this.g.b();
                return;
            }
            catch (Throwable throwable) {
                i.this.g.b();
                throw throwable;
            }
            {
                finally {
                    i.this.g.b();
                }
            }
        }

        @Override
        public u a() {
            return i.this.g;
        }

        @Override
        public void a_(d.c c2, long l2) {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.e.a_(c2, l2);
            while (this.e.b() >= 16384L) {
                this.a(false);
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
        public void close() {
            if (!c) {
                if (Thread.holdsLock(i.this)) throw new AssertionError();
            }
            i i2 = i.this;
            // MONITORENTER : i2
            if (this.a) {
                // MONITOREXIT : i2
                return;
            }
            // MONITOREXIT : i2
            if (!i.this.e.b) {
                if (this.e.b() > 0L) {
                    while (this.e.b() > 0L) {
                        this.a(true);
                    }
                } else {
                    i.this.d.a(i.this.c, true, null, 0L);
                }
            }
            i2 = i.this;
            // MONITORENTER : i2
            this.a = true;
            // MONITOREXIT : i2
            i.this.d.b();
            i.this.j();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void flush() {
            if (!c && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            i i2 = i.this;
            synchronized (i2) {
                i.this.k();
            }
            while (this.e.b() > 0L) {
                this.a(false);
                i.this.d.b();
            }
            return;
        }
    }

    private final class b
    implements t {
        static final /* synthetic */ boolean c;
        boolean a;
        boolean b;
        private final d.c e = new d.c();
        private final d.c f = new d.c();
        private final long g;

        static {
            c = i.class.desiredAssertionStatus() ^ true;
        }

        b(long l2) {
            this.g = l2;
        }

        private void b() {
            i.this.f.c();
            try {
                while (this.f.b() == 0L && !this.b && !this.a && i.this.h == null) {
                    i.this.l();
                }
                return;
            }
            finally {
                i.this.f.b();
            }
        }

        private void c() {
            if (!this.a) {
                if (i.this.h == null) {
                    return;
                }
                throw new n(i.this.h);
            }
            throw new IOException("stream closed");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public long a(d.c object, long l2) {
            if (l2 < 0L) {
                object = new StringBuilder();
                ((StringBuilder)object).append("byteCount < 0: ");
                ((StringBuilder)object).append(l2);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            Object object2 = i.this;
            synchronized (object2) {
                this.b();
                this.c();
                if (this.f.b() == 0L) {
                    return -1L;
                }
                l2 = this.f.a((d.c)object, Math.min(l2, this.f.b()));
                object = i.this;
                ((i)object).a += l2;
                if (i.this.a >= (long)(i.this.d.k.d() / 2)) {
                    i.this.d.a(i.this.c, i.this.a);
                    i.this.a = 0L;
                }
            }
            object = i.this.d;
            synchronized (object) {
                object2 = i.this.d;
                ((g)object2).i += l2;
                if (i.this.d.i >= (long)(i.this.d.k.d() / 2)) {
                    i.this.d.a(0, i.this.d.i);
                    i.this.d.i = 0L;
                }
                return l2;
            }
        }

        @Override
        public u a() {
            return i.this.f;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        void a(e e2, long l2) {
            long l3 = l2;
            if (!c) {
                if (Thread.holdsLock(i.this)) throw new AssertionError();
                l3 = l2;
            }
            while (l3 > 0L) {
                i i2 = i.this;
                // MONITORENTER : i2
                boolean bl2 = this.b;
                l2 = this.f.b();
                long l4 = this.g;
                boolean bl3 = false;
                boolean bl4 = l2 + l3 > l4;
                // MONITOREXIT : i2
                if (bl4) {
                    e2.i(l3);
                    i.this.b(c.a.e.b.d);
                    return;
                }
                if (bl2) {
                    e2.i(l3);
                    return;
                }
                l2 = e2.a(this.e, l3);
                if (l2 == -1L) throw new EOFException();
                l3 -= l2;
                i2 = i.this;
                // MONITORENTER : i2
                bl4 = bl3;
                if (this.f.b() == 0L) {
                    bl4 = true;
                }
                this.f.a(this.e);
                if (bl4) {
                    i.this.notifyAll();
                }
                // MONITOREXIT : i2
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void close() {
            i i2 = i.this;
            synchronized (i2) {
                this.a = true;
                this.f.s();
                i.this.notifyAll();
            }
            i.this.j();
        }
    }

    class c
    extends d.a {
        c() {
        }

        @Override
        protected IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override
        protected void a() {
            i.this.b(c.a.e.b.f);
        }

        public void b() {
            if (!this.t_()) {
                return;
            }
            throw this.a(null);
        }
    }

}

