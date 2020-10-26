/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.g;

import b.a.e.g.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class i {
    public static final boolean a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c;
    static final Map<ScheduledThreadPoolExecutor, Object> d;

    static {
        c = new AtomicReference();
        d = new ConcurrentHashMap<ScheduledThreadPoolExecutor, Object>();
        Properties properties = System.getProperties();
        boolean bl2 = properties.containsKey("rx2.purge-enabled");
        int n2 = 1;
        bl2 = bl2 ? Boolean.getBoolean("rx2.purge-enabled") : true;
        int n3 = n2;
        if (bl2) {
            n3 = n2;
            if (properties.containsKey("rx2.purge-period-seconds")) {
                n3 = Integer.getInteger("rx2.purge-period-seconds", 1);
            }
        }
        a = bl2;
        b = n3;
        i.a();
    }

    public static ScheduledExecutorService a(ThreadFactory object) {
        object = Executors.newScheduledThreadPool(1, (ThreadFactory)object);
        if (a && object instanceof ScheduledThreadPoolExecutor) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)object;
            d.put(scheduledThreadPoolExecutor, object);
        }
        return object;
    }

    public static void a() {
        if (!a) {
            return;
        }
        ScheduledExecutorService scheduledExecutorService;
        while ((scheduledExecutorService = c.get()) == null || scheduledExecutorService.isShutdown()) {
            ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1, new f("RxSchedulerPurge"));
            if (c.compareAndSet(scheduledExecutorService, scheduledExecutorService2)) {
                scheduledExecutorService2.scheduleAtFixedRate(new a(), b, b, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorService2.shutdownNow();
        }
        return;
    }

    static final class a
    implements Runnable {
        a() {
        }

        @Override
        public void run() {
            try {
                for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList<ScheduledThreadPoolExecutor>(i.d.keySet())) {
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        i.d.remove(scheduledThreadPoolExecutor);
                        continue;
                    }
                    scheduledThreadPoolExecutor.purge();
                }
            }
            catch (Throwable throwable) {
                b.a.f.a.a(throwable);
            }
        }
    }

}

