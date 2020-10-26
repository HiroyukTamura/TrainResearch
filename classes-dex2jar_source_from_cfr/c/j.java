/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a;
import c.a.b.d;
import c.a.b.g;
import c.a.c;
import c.a.g.f;
import c.ae;
import c.t;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class j {
    static final /* synthetic */ boolean c;
    private static final Executor d;
    final d a = new d();
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g = new Runnable(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Throwable throwable2;
            do {
                long l2;
                if ((l2 = j.this.a(System.nanoTime())) == -1L) {
                    return;
                }
                if (l2 <= 0L) continue;
                long l3 = l2 / 1000000L;
                j j2 = j.this;
                synchronized (j2) {
                    try {
                        try {
                            j.this.wait(l3, (int)(l2 - 1000000L * l3));
                        }
                        catch (InterruptedException interruptedException) {}
                        continue;
                    }
                    catch (Throwable throwable2) {}
                    break;
                }
            } while (true);
            {
                throw throwable2;
            }
        }
    };
    private final Deque<c.a.b.c> h = new ArrayDeque<c.a.b.c>();

    static {
        c = j.class.desiredAssertionStatus() ^ true;
        d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), c.a("OkHttp ConnectionPool", true));
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public j(int n2, long l2, TimeUnit object) {
        this.e = n2;
        this.f = ((TimeUnit)((Object)object)).toNanos(l2);
        if (l2 > 0L) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("keepAliveDuration <= 0: ");
        ((StringBuilder)object).append(l2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    private int a(c.a.b.c c2, long l2) {
        List<Reference<g>> list = c2.d;
        int n2 = 0;
        while (n2 < list.size()) {
            g.a a2 = list.get(n2);
            if (a2.get() != null) {
                ++n2;
                continue;
            }
            a2 = a2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("A connection to ");
            charSequence.append(c2.a().a().a());
            charSequence.append(" was leaked. Did you forget to close a response body?");
            charSequence = charSequence.toString();
            f.c().a((String)charSequence, a2.a);
            list.remove(n2);
            c2.a = true;
            if (!list.isEmpty()) continue;
            c2.e = l2 - this.f;
            return 0;
        }
        return list.size();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    long a(long l2) {
        c.a.b.c c2;
        synchronized (this) {
            Iterator<c.a.b.c> iterator = this.h.iterator();
            long l3 = Long.MIN_VALUE;
            c2 = null;
            int n2 = 0;
            int n3 = 0;
            while (iterator.hasNext()) {
                c.a.b.c c3 = iterator.next();
                if (this.a(c3, l2) > 0) {
                    ++n3;
                    continue;
                }
                int n4 = n2 + 1;
                long l4 = l2 - c3.e;
                n2 = n4;
                if (l4 <= l3) continue;
                c2 = c3;
                l3 = l4;
                n2 = n4;
            }
            if (l3 < this.f && n2 <= this.e) {
                if (n2 > 0) {
                    l2 = this.f;
                    return l2 - l3;
                }
                if (n3 > 0) {
                    return this.f;
                }
                this.b = false;
                return -1L;
            }
            this.h.remove(c2);
        }
        c.a(c2.c());
        return 0L;
    }

    @Nullable
    c.a.b.c a(a a2, g g2, ae ae2) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (c.a.b.c c2 : this.h) {
            if (!c2.a(a2, ae2)) continue;
            g2.a(c2, true);
            return c2;
        }
        return null;
    }

    @Nullable
    Socket a(a a2, g g2) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (c.a.b.c c2 : this.h) {
            if (!c2.a(a2, null) || !c2.e() || c2 == g2.c()) continue;
            return g2.a(c2);
        }
        return null;
    }

    void a(c.a.b.c c2) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            d.execute(this.g);
        }
        this.h.add(c2);
    }

    boolean b(c.a.b.c c2) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!c2.a && this.e != 0) {
            this.notifyAll();
            return false;
        }
        this.h.remove(c2);
        return true;
    }

}

