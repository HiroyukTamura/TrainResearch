/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c;

import c.a.c;
import c.z;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class n {
    private int a = 64;
    private int b = 5;
    @Nullable
    private Runnable c;
    @Nullable
    private ExecutorService d;
    private final Deque<z.a> e = new ArrayDeque<z.a>();
    private final Deque<z.a> f = new ArrayDeque<z.a>();
    private final Deque<z> g = new ArrayDeque<z>();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private <T> void a(Deque<T> object, T t2, boolean bl2) {
        // MONITORENTER : this
        if (!object.remove(t2)) throw new AssertionError((Object)"Call wasn't in-flight!");
        if (bl2) {
            this.c();
        }
        int n2 = this.b();
        object = this.c;
        // MONITOREXIT : this
        if (n2 != 0) return;
        if (object == null) return;
        object.run();
    }

    private int c(z.a a2) {
        Iterator<z.a> iterator = this.f.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            z.a a3 = iterator.next();
            if (a3.b().d || !a3.a().equals(a2.a())) continue;
            ++n2;
        }
        return n2;
    }

    private void c() {
        if (this.f.size() >= this.a) {
            return;
        }
        if (this.e.isEmpty()) {
            return;
        }
        Iterator<z.a> iterator = this.e.iterator();
        while (iterator.hasNext()) {
            z.a a2 = iterator.next();
            if (this.c(a2) < this.b) {
                iterator.remove();
                this.f.add(a2);
                this.a().execute(a2);
            }
            if (this.f.size() < this.a) continue;
        }
    }

    public ExecutorService a() {
        synchronized (this) {
            if (this.d == null) {
                this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), c.a("OkHttp Dispatcher", false));
            }
            ExecutorService executorService = this.d;
            return executorService;
        }
    }

    void a(z.a a2) {
        synchronized (this) {
            if (this.f.size() < this.a && this.c(a2) < this.b) {
                this.f.add(a2);
                this.a().execute(a2);
            } else {
                this.e.add(a2);
            }
            return;
        }
    }

    void a(z z2) {
        synchronized (this) {
            this.g.add(z2);
            return;
        }
    }

    public int b() {
        synchronized (this) {
            int n2 = this.f.size();
            int n3 = this.g.size();
            return n2 + n3;
        }
    }

    void b(z.a a2) {
        this.a(this.f, a2, true);
    }

    void b(z z2) {
        this.a(this.g, z2, false);
    }
}

