package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.LongCompanionObject;

/* renamed from: kotlinx.coroutines.F */
public final class C2497F extends C2505O implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: f */
    private static final long f4102f;

    /* renamed from: g */
    public static final C2497F f4103g;

    static {
        Long l;
        C2497F f = new C2497F();
        f4103g = f;
        f.mo35505b(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f4102f = timeUnit.toNanos(l.longValue());
    }

    private C2497F() {
    }

    /* renamed from: w */
    private final synchronized void m4309w() {
        if (m4311y()) {
            debugStatus = 3;
            mo35515v();
            notifyAll();
        }
    }

    /* renamed from: x */
    private final synchronized Thread m4310x() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: y */
    private final boolean m4311y() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    /* renamed from: z */
    private final synchronized boolean m4312z() {
        if (m4311y()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public void run() {
        C2582q0 q0Var = C2582q0.f4221b;
        C2582q0.m4504a(this);
        try {
            if (m4312z()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long u = mo35514u();
                    if (u == LongCompanionObject.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j == LongCompanionObject.MAX_VALUE) {
                            j = f4102f + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            m4309w();
                            if (!mo35513t()) {
                                mo35488s();
                                return;
                            }
                            return;
                        }
                        u = RangesKt___RangesKt.coerceAtMost(u, j2);
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (u > 0) {
                        if (m4311y()) {
                            _thread = null;
                            m4309w();
                            if (!mo35513t()) {
                                mo35488s();
                                return;
                            }
                            return;
                        }
                        LockSupport.parkNanos(this, u);
                    }
                }
            }
        } finally {
            _thread = null;
            m4309w();
            if (!mo35513t()) {
                mo35488s();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public Thread mo35488s() {
        Thread thread = _thread;
        return thread != null ? thread : m4310x();
    }
}
