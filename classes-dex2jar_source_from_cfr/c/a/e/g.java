/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.e.h;
import c.a.e.i;
import c.a.e.j;
import c.a.e.l;
import c.a.e.m;
import c.a.g.f;
import d.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g
implements Closeable {
    static final /* synthetic */ boolean r;
    private static final ExecutorService s;
    final boolean a;
    final b b;
    final Map<Integer, i> c = new LinkedHashMap<Integer, i>();
    final String d;
    int e;
    int f;
    boolean g;
    final l h;
    long i = 0L;
    long j;
    m k = new m();
    final m l = new m();
    boolean m = false;
    final Socket n;
    final j o;
    final d p;
    final Set<Integer> q = new LinkedHashSet<Integer>();
    private final ScheduledExecutorService t;
    private final ExecutorService u;
    private boolean v;

    static {
        r = g.class.desiredAssertionStatus() ^ true;
        s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), c.a.c.a("OkHttp Http2Connection", true));
    }

    g(a a2) {
        this.h = a2.f;
        this.a = a2.g;
        this.b = a2.e;
        int n2 = a2.g ? 1 : 2;
        this.f = n2;
        if (a2.g) {
            this.f += 2;
        }
        if (a2.g) {
            this.k.a(7, 16777216);
        }
        this.d = a2.b;
        this.t = new ScheduledThreadPoolExecutor(1, c.a.c.a(c.a.c.a("OkHttp %s Writer", new Object[]{this.d}), false));
        if (a2.h != 0) {
            this.t.scheduleAtFixedRate(new c(false, 0, 0), a2.h, a2.h, TimeUnit.MILLISECONDS);
        }
        this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), c.a.c.a(c.a.c.a("OkHttp %s Push Observer", new Object[]{this.d}), true));
        this.l.a(7, 65535);
        this.l.a(5, 16384);
        this.j = this.l.d();
        this.n = a2.a;
        this.o = new j(a2.d, this.a);
        this.p = new d(new h(a2.c, this.a));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private i b(int n2, List<c.a.e.c> list, boolean bl2) {
        boolean bl3 = bl2 ^ true;
        j j2 = this.o;
        // MONITORENTER : j2
        // MONITORENTER : this
        if (this.f > 1073741823) {
            this.a(c.a.e.b.e);
        }
        if (this.g) throw new c.a.e.a();
        int n3 = this.f;
        this.f += 2;
        i i2 = new i(n3, this, bl3, false, list);
        boolean bl4 = !bl2 || this.j == 0L || i2.b == 0L;
        if (i2.b()) {
            this.c.put(n3, i2);
        }
        // MONITOREXIT : this
        if (n2 == 0) {
            this.o.a(bl3, n3, n2, list);
        } else {
            if (this.a) throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            this.o.a(n2, n3, list);
        }
        // MONITOREXIT : j2
        if (!bl4) return i2;
        this.o.b();
        return i2;
    }

    private void f() {
        try {
            this.a(c.a.e.b.b, c.a.e.b.b);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public int a() {
        synchronized (this) {
            int n2 = this.l.c(Integer.MAX_VALUE);
            return n2;
        }
    }

    i a(int n2) {
        synchronized (this) {
            i i2 = this.c.get(n2);
            return i2;
        }
    }

    public i a(List<c.a.e.c> list, boolean bl2) {
        return this.b(0, list, bl2);
    }

    void a(final int n2, final long l2) {
        try {
            this.t.execute(new c.a.b("OkHttp Window Update %s stream %d", new Object[]{this.d, n2}){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void c() {
                    try {
                        g.this.o.a(n2, l2);
                        return;
                    }
                    catch (IOException iOException) {}
                    g.this.f();
                }
            });
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
    }

    void a(final int n2, final c.a.e.b b2) {
        try {
            this.t.execute(new c.a.b("OkHttp %s stream %d", new Object[]{this.d, n2}){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void c() {
                    try {
                        g.this.b(n2, b2);
                        return;
                    }
                    catch (IOException iOException) {}
                    g.this.f();
                }
            });
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
    }

    void a(final int n2, e object, final int n3, final boolean bl2) {
        final d.c c2 = new d.c();
        long l2 = n3;
        object.a(l2);
        object.a(c2, l2);
        if (c2.b() == l2) {
            this.u.execute(new c.a.b("OkHttp %s Push Data[%s]", new Object[]{this.d, n2}){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void c() {
                    try {
                        boolean bl22 = g.this.h.a(n2, c2, n3, bl2);
                        if (bl22) {
                            g.this.o.a(n2, c.a.e.b.f);
                        }
                        if (!bl22) {
                            if (!bl2) return;
                        }
                        g g2 = g.this;
                        // MONITORENTER : g2
                        g.this.q.remove(n2);
                    }
                    catch (IOException iOException) {
                        return;
                    }
                }
            });
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(c2.b());
        ((StringBuilder)object).append(" != ");
        ((StringBuilder)object).append(n3);
        throw new IOException(((StringBuilder)object).toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(final int n2, final List<c.a.e.c> list) {
        synchronized (this) {
            if (this.q.contains(n2)) {
                this.a(n2, c.a.e.b.b);
                return;
            }
            this.q.add(n2);
        }
        try {
            this.u.execute(new c.a.b("OkHttp %s Push Request[%s]", new Object[]{this.d, n2}){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void c() {
                    if (!g.this.h.a(n2, list)) return;
                    try {
                        g.this.o.a(n2, c.a.e.b.f);
                        g g2 = g.this;
                        // MONITORENTER : g2
                        g.this.q.remove(n2);
                    }
                    catch (IOException iOException) {
                        return;
                    }
                }
            });
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
    }

    void a(final int n2, final List<c.a.e.c> list, final boolean bl2) {
        try {
            this.u.execute(new c.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.d, n2}){

                /*
                 * Unable to fully structure code
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 * Converted monitor instructions to comments
                 * Lifted jumps to return sites
                 */
                @Override
                public void c() {
                    var1_1 = g.this.h.a(n2, list, bl2);
                    if (!var1_1) ** GOTO lbl5
                    try {
                        g.this.o.a(n2, c.a.e.b.f);
lbl5: // 2 sources:
                        if (!var1_1) {
                            if (bl2 == false) return;
                        }
                        var2_2 = g.this;
                        // MONITORENTER : var2_2
                        g.this.q.remove(n2);
                    }
                    catch (IOException var2_3) {
                        return;
                    }
                }
            });
            return;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(int n2, boolean bl2, d.c c2, long l2) {
        long l3 = l2;
        if (l2 == 0L) {
            this.o.a(bl2, n2, c2, 0);
            return;
        }
        while (l3 > 0L) {
            // MONITORENTER : this
            while (this.j <= 0L) {
                if (!this.c.containsKey(n2)) throw new IOException("stream closed");
                this.wait();
            }
            int n3 = Math.min((int)Math.min(l3, this.j), this.o.c());
            l2 = this.j;
            long l4 = n3;
            this.j = l2 - l4;
            // MONITOREXIT : this
            j j2 = this.o;
            boolean bl3 = bl2 && (l3 -= l4) == 0L;
            j2.a(bl3, n2, c2, n3);
        }
        return;
        {
            catch (InterruptedException interruptedException) {}
            throw new InterruptedIOException();
        }
        catch (Throwable throwable) {
            throw throwable;
        }
    }

    void a(long l2) {
        this.j += l2;
        if (l2 > 0L) {
            this.notifyAll();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(c.a.e.b b2) {
        j j2 = this.o;
        synchronized (j2) {
            int n2;
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                n2 = this.e;
            }
            this.o.a(n2, b2, c.a.c.a);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(c.a.e.b object, c.a.e.b b2) {
        block17 : {
            if (!r && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            i[] arri = null;
            try {
                this.a((c.a.e.b)((Object)object));
                object = null;
            }
            catch (IOException iOException) {
                // empty catch block
            }
            synchronized (this) {
                if (!this.c.isEmpty()) {
                    arri = this.c.values().toArray(new i[this.c.size()]);
                    this.c.clear();
                }
            }
            Object object2 = object;
            if (arri != null) {
                int n2 = arri.length;
                int n3 = 0;
                do {
                    block16 : {
                        object2 = object;
                        if (n3 >= n2) break;
                        object2 = arri[n3];
                        try {
                            ((i)object2).a(b2);
                            object2 = object;
                        }
                        catch (IOException iOException) {
                            object2 = object;
                            if (object == null) break block16;
                            object2 = iOException;
                        }
                    }
                    ++n3;
                    object = object2;
                } while (true);
            }
            try {
                this.o.close();
                object = object2;
            }
            catch (IOException iOException) {
                object = object2;
                if (object2 != null) break block17;
                object = iOException;
            }
        }
        try {
            this.n.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.t.shutdown();
        this.u.shutdown();
        if (object == null) {
            return;
        }
        throw object;
    }

    void a(boolean bl2) {
        if (bl2) {
            this.o.a();
            this.o.b(this.k);
            int n2 = this.k.d();
            if (n2 != 65535) {
                this.o.a(0, n2 - 65535);
            }
        }
        new Thread(this.p).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void a(boolean bl2, int n2, int n3) {
        if (!bl2) {
            // MONITORENTER : this
            boolean bl3 = this.v;
            this.v = true;
            // MONITOREXIT : this
            if (bl3) {
                this.f();
                return;
            }
        }
        try {
            this.o.a(bl2, n2, n3);
            return;
        }
        catch (IOException iOException) {}
        this.f();
    }

    i b(int n2) {
        synchronized (this) {
            i i2 = this.c.remove(n2);
            this.notifyAll();
            return i2;
        }
    }

    public void b() {
        this.o.b();
    }

    void b(int n2, c.a.e.b b2) {
        this.o.a(n2, b2);
    }

    public void c() {
        this.a(true);
    }

    void c(final int n2, final c.a.e.b b2) {
        this.u.execute(new c.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.d, n2}){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void c() {
                g.this.h.a(n2, b2);
                g g2 = g.this;
                synchronized (g2) {
                    g.this.q.remove(n2);
                    return;
                }
            }
        });
    }

    boolean c(int n2) {
        return n2 != 0 && (n2 & 1) == 0;
    }

    @Override
    public void close() {
        this.a(c.a.e.b.a, c.a.e.b.f);
    }

    public boolean d() {
        synchronized (this) {
            boolean bl2 = this.g;
            return bl2;
        }
    }

    public static class a {
        Socket a;
        String b;
        e c;
        d.d d;
        b e = b.f;
        l f = l.a;
        boolean g;
        int h;

        public a(boolean bl2) {
            this.g = bl2;
        }

        public a a(int n2) {
            this.h = n2;
            return this;
        }

        public a a(b b2) {
            this.e = b2;
            return this;
        }

        public a a(Socket socket, String string2, e e2, d.d d2) {
            this.a = socket;
            this.b = string2;
            this.c = e2;
            this.d = d2;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public static abstract class b {
        public static final b f = new b(){

            @Override
            public void a(i i2) {
                i2.a(c.a.e.b.e);
            }
        };

        public void a(g g2) {
        }

        public abstract void a(i var1);

    }

    final class c
    extends c.a.b {
        final boolean a;
        final int c;
        final int d;

        c(boolean bl2, int n2, int n3) {
            super("OkHttp %s ping %08x%08x", g.this.d, n2, n3);
            this.a = bl2;
            this.c = n2;
            this.d = n3;
        }

        @Override
        public void c() {
            g.this.a(this.a, this.c, this.d);
        }
    }

    class d
    extends c.a.b
    implements h.b {
        final h a;

        d(h h2) {
            super("OkHttp %s", g.this.d);
            this.a = h2;
        }

        private void a(final m m2) {
            try {
                g.this.t.execute(new c.a.b("OkHttp %s ACK Settings", new Object[]{g.this.d}){

                    /*
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     */
                    @Override
                    public void c() {
                        try {
                            g.this.o.a(m2);
                            return;
                        }
                        catch (IOException iOException) {}
                        g.this.f();
                    }
                });
                return;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                return;
            }
        }

        @Override
        public void a() {
        }

        @Override
        public void a(int n2, int n3, int n4, boolean bl2) {
        }

        @Override
        public void a(int n2, int n3, List<c.a.e.c> list) {
            g.this.a(n3, list);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, long l2) {
            if (n2 == 0) {
                g g2 = g.this;
                synchronized (g2) {
                    g g3 = g.this;
                    g3.j += l2;
                    g.this.notifyAll();
                    return;
                }
            }
            i i2 = g.this.a(n2);
            if (i2 != null) {
                synchronized (i2) {
                    i2.a(l2);
                    return;
                }
            }
        }

        @Override
        public void a(int n2, c.a.e.b b2) {
            if (g.this.c(n2)) {
                g.this.c(n2, b2);
                return;
            }
            i i2 = g.this.b(n2);
            if (i2 != null) {
                i2.c(b2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, c.a.e.b object, d.f arri) {
            arri.g();
            object = g.this;
            synchronized (object) {
                arri = g.this.c.values().toArray(new i[g.this.c.size()]);
                g.this.g = true;
            }
            int n3 = arri.length;
            int n4 = 0;
            while (n4 < n3) {
                object = arri[n4];
                if (((i)object).a() > n2 && ((i)object).c()) {
                    ((i)object).c(c.a.e.b.e);
                    g.this.b(((i)object).a());
                }
                ++n4;
            }
            return;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl2, int n2, int n3) {
            if (bl2) {
                g g2 = g.this;
                synchronized (g2) {
                    g.this.v = false;
                    g.this.notifyAll();
                    return;
                }
            }
            try {
                g.this.t.execute(new c(true, n2, n3));
                return;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl2, int n2, int n3, List<c.a.e.c> object) {
            i i2;
            if (g.this.c(n2)) {
                g.this.a(n2, (List<c.a.e.c>)object, bl2);
                return;
            }
            g g2 = g.this;
            synchronized (g2) {
                i2 = g.this.a(n2);
                if (i2 == null) {
                    if (g.this.g) {
                        return;
                    }
                    if (n2 <= g.this.e) {
                        return;
                    }
                    if (n2 % 2 == g.this.f % 2) {
                        return;
                    }
                    object = new i(n2, g.this, false, bl2, (List<c.a.e.c>)object);
                    g.this.e = n2;
                    g.this.c.put(n2, (i)object);
                    s.execute(new c.a.b("OkHttp %s stream %d", new Object[]{g.this.d, n2}, (i)object){
                        final /* synthetic */ i a;
                        {
                            this.a = i2;
                            super(string2, arrobject);
                        }

                        @Override
                        public void c() {
                            try {
                                g.this.b.a(this.a);
                                return;
                            }
                            catch (IOException iOException) {
                                f f2 = f.c();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Http2Connection.Listener failure for ");
                                stringBuilder.append(g.this.d);
                                f2.a(4, stringBuilder.toString(), iOException);
                                try {
                                    this.a.a(c.a.e.b.b);
                                    return;
                                }
                                catch (IOException iOException2) {
                                    return;
                                }
                            }
                        }
                    });
                    return;
                }
            }
            i2.a((List<c.a.e.c>)object);
            if (bl2) {
                i2.i();
            }
        }

        @Override
        public void a(boolean bl2, int n2, e e2, int n3) {
            if (g.this.c(n2)) {
                g.this.a(n2, e2, n3, bl2);
                return;
            }
            i i2 = g.this.a(n2);
            if (i2 == null) {
                g.this.a(n2, c.a.e.b.b);
                e2.i(n3);
                return;
            }
            i2.a(e2, n3);
            if (bl2) {
                i2.i();
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
        public void a(boolean bl2, m arri) {
            long l2;
            Object object = g.this;
            // MONITORENTER : object
            int n2 = g.this.l.d();
            if (bl2) {
                g.this.l.a();
            }
            g.this.l.a((m)arri);
            this.a((m)arri);
            int n3 = g.this.l.d();
            arri = null;
            if (n3 != -1 && n3 != n2) {
                long l3 = n3 - n2;
                if (!g.this.m) {
                    g.this.a(l3);
                    g.this.m = true;
                }
                l2 = l3;
                if (!g.this.c.isEmpty()) {
                    arri = g.this.c.values().toArray(new i[g.this.c.size()]);
                    l2 = l3;
                }
            } else {
                l2 = 0L;
            }
            ExecutorService executorService = s;
            String string2 = g.this.d;
            n2 = 0;
            executorService.execute(new c.a.b("OkHttp %s settings", new Object[]{string2}){

                @Override
                public void c() {
                    g.this.b.a(g.this);
                }
            });
            // MONITOREXIT : object
            if (arri == null) return;
            if (l2 == 0L) return;
            n3 = arri.length;
            while (n2 < n3) {
                object = arri[n2];
                // MONITORENTER : object
                ((i)object).a(l2);
                // MONITOREXIT : object
                ++n2;
            }
        }

        /*
         * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        protected void c() {
            block17 : {
                block16 : {
                    var3_1 = c.a.e.b.c;
                    var5_2 = c.a.e.b.c;
                    var2_3 /* !! */  = var3_1;
                    this.a.a(this);
                    do {
                        var2_3 /* !! */  = var3_1;
                    } while (this.a.a(false, this));
                    var2_3 /* !! */  = var3_1;
                    var2_3 /* !! */  = var1_6 = c.a.e.b.a;
                    var3_1 = c.a.e.b.f;
                    try {
                        var4_12 = g.this;
                        var2_3 /* !! */  = var3_1;
                        var3_1 = var4_12;
lbl17: // 2 sources:
                        do {
                            var3_1.a(var1_6, var2_3 /* !! */ );
                            break;
                        } while (true);
                    }
                    catch (IOException var1_11) {}
                    c.a.c.a(this.a);
                    return;
lbl24: // 1 sources:
                    do {
                        var2_3 /* !! */  = var1_6;
                        ** GOTO lbl-1000
                        break;
                    } while (true);
                    catch (Throwable var1_7) {
                        break block16;
                    }
                    catch (IOException var1_10) {
                        var2_3 /* !! */  = var3_1;
                    }
lbl-1000: // 2 sources:
                    {
                        var2_3 /* !! */  = var1_6 = c.a.e.b.b;
                    }
                    try {
                        var4_13 = c.a.e.b.b;
                        var3_1 = g.this;
                        var2_3 /* !! */  = var4_13;
                        ** continue;
                    }
                    catch (Throwable var1_8) {
                        // empty catch block
                    }
                }
                try {
                    g.this.a(var2_3 /* !! */ , var5_2);
                    break block17;
                }
                catch (IOException var2_5) {}
                catch (IOException var2_4) {
                    ** continue;
                }
            }
            c.a.c.a(this.a);
            throw var1_9;
        }

    }

}

