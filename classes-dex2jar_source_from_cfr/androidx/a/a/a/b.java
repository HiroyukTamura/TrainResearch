/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.a.a.a;

import android.os.Handler;
import android.os.Looper;
import androidx.a.a.a.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b
extends c {
    private final Object a = new Object();
    private final ExecutorService b = Executors.newFixedThreadPool(2, new ThreadFactory(){
        private final AtomicInteger b = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable runnable) {
            runnable = new Thread(runnable);
            ((Thread)runnable).setName(String.format("arch_disk_io_%d", this.b.getAndIncrement()));
            return runnable;
        }
    });
    private volatile Handler c;

    @Override
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void b(Runnable runnable) {
        if (this.c == null) {
            Object object = this.a;
            synchronized (object) {
                if (this.c == null) {
                    this.c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

}

