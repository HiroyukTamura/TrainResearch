/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package b.a.a.b;

import android.os.Handler;
import android.os.Message;
import b.a.b.c;
import b.a.h;
import java.util.concurrent.TimeUnit;

final class b
extends h {
    private final Handler b;

    b(Handler handler) {
        this.b = handler;
    }

    @Override
    public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                runnable = b.a.f.a.a(runnable);
                runnable = new b(this.b, runnable);
                this.b.postDelayed(runnable, timeUnit.toMillis(l2));
                return runnable;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }

    @Override
    public h.b a() {
        return new a(this.b);
    }

    private static final class a
    extends h.b {
        private final Handler a;
        private volatile boolean b;

        a(Handler handler) {
            this.a = handler;
        }

        @Override
        public b.a.b.b a(Runnable runnable, long l2, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.b) {
                        return c.a();
                    }
                    runnable = b.a.f.a.a(runnable);
                    runnable = new b(this.a, runnable);
                    Message message = Message.obtain((Handler)this.a, (Runnable)runnable);
                    message.obj = this;
                    this.a.sendMessageDelayed(message, timeUnit.toMillis(l2));
                    if (this.b) {
                        this.a.removeCallbacks(runnable);
                        return c.a();
                    }
                    return runnable;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }

        @Override
        public void a() {
            this.b = true;
            this.a.removeCallbacksAndMessages((Object)this);
        }
    }

    private static final class b
    implements b.a.b.b,
    Runnable {
        private final Handler a;
        private final Runnable b;
        private volatile boolean c;

        b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override
        public void a() {
            this.c = true;
            this.a.removeCallbacks((Runnable)this);
        }

        @Override
        public void run() {
            try {
                this.b.run();
                return;
            }
            catch (Throwable throwable) {
                b.a.f.a.a(throwable);
                return;
            }
        }
    }

}

