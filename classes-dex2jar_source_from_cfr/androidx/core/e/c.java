/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package androidx.core.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c {
    private final Object a = new Object();
    private HandlerThread b;
    private Handler c;
    private int d;
    private Handler.Callback e = new Handler.Callback(){

        public boolean handleMessage(Message message) {
            switch (message.what) {
                default: {
                    return true;
                }
                case 1: {
                    c.this.a((Runnable)message.obj);
                    return true;
                }
                case 0: 
            }
            c.this.a();
            return true;
        }
    };
    private final int f;
    private final int g;
    private final String h;

    public c(String string2, int n2, int n3) {
        this.h = string2;
        this.g = n2;
        this.f = n3;
        this.d = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Runnable runnable) {
        Object object = this.a;
        synchronized (object) {
            if (this.b == null) {
                this.b = new HandlerThread(this.h, this.g);
                this.b.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                ++this.d;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, (Object)runnable));
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public <T> T a(final Callable<T> var1_1, int var2_4) {
        block7 : {
            var7_5 = new ReentrantLock();
            var8_6 = var7_5.newCondition();
            var9_7 = new AtomicReference<V>();
            var10_8 = new AtomicBoolean(true);
            this.b(new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                @Override
                public void run() {
                    try {
                        var9_7.set(var1_1.call());
                    }
                    catch (Exception exception) {}
                    var7_5.lock();
                    try {
                        var10_8.set(false);
                        var8_6.signal();
                        return;
                    }
                    finally {
                        var7_5.unlock();
                    }
                }
            });
            var7_5.lock();
            if (var10_8.get()) break block7;
            var1_1 /* !! */  = var9_7.get();
            var7_5.unlock();
            return (T)var1_1 /* !! */ ;
        }
        try {
            var3_9 = TimeUnit.MILLISECONDS.toNanos(var2_4);
            do lbl-1000: // 2 sources:
            {
                try {
                    var3_9 = var5_10 = var8_6.awaitNanos(var3_9);
                }
                catch (InterruptedException var1_3) {}
                if (var10_8.get()) continue;
                var1_1 /* !! */  = var9_7.get();
                var7_5.unlock();
                break;
            } while (true);
        }
        catch (Throwable var1_2) {
            var7_5.unlock();
            throw var1_2;
        }
        {
            return (T)var1_1 /* !! */ ;
            ** while (var3_9 > 0L)
        }
lbl30: // 2 sources:
        throw new InterruptedException("timeout");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a() {
        Object object = this.a;
        synchronized (object) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(Runnable object) {
        object.run();
        object = this.a;
        synchronized (object) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), (long)this.f);
            return;
        }
    }

    public <T> void a(final Callable<T> callable, a<T> a2) {
        this.b(new Runnable(new Handler(), a2){
            final /* synthetic */ Handler b;
            final /* synthetic */ a c;
            {
                this.b = handler;
                this.c = a2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                Object v2;
                block2 : {
                    try {
                        v2 = callable.call();
                        break block2;
                    }
                    catch (Exception exception) {}
                    v2 = null;
                }
                this.b.post(new Runnable(){

                    @Override
                    public void run() {
                        2.this.c.a(v2);
                    }
                });
            }

        });
    }

    public static interface a<T> {
        public void a(T var1);
    }

}

