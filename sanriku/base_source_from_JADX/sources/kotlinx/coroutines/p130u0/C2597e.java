package kotlinx.coroutines.p130u0;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C2511T;

/* renamed from: kotlinx.coroutines.u0.e */
final class C2597e extends C2511T implements C2601i, Executor {

    /* renamed from: e */
    private static final AtomicIntegerFieldUpdater f4258e = AtomicIntegerFieldUpdater.newUpdater(C2597e.class, "inFlightTasks");

    /* renamed from: a */
    private final ConcurrentLinkedQueue<Runnable> f4259a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private final C2595c f4260b;

    /* renamed from: c */
    private final int f4261c;

    /* renamed from: d */
    private final int f4262d;
    private volatile int inFlightTasks = 0;

    public C2597e(C2595c cVar, int i, int i2) {
        this.f4260b = cVar;
        this.f4261c = i;
        this.f4262d = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m4534a(java.lang.Runnable r3, boolean r4) {
        /*
            r2 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4258e
            int r0 = r0.incrementAndGet(r2)
            int r1 = r2.f4261c
            if (r0 > r1) goto L_0x0010
            kotlinx.coroutines.u0.c r0 = r2.f4260b
            r0.mo35620a(r3, r2, r4)
            return
        L_0x0010:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r2.f4259a
            r0.add(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = f4258e
            int r3 = r3.decrementAndGet(r2)
            int r0 = r2.f4261c
            if (r3 < r0) goto L_0x0020
            return
        L_0x0020:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r3 = r2.f4259a
            java.lang.Object r3 = r3.poll()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            if (r3 == 0) goto L_0x002b
            goto L_0x0000
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p130u0.C2597e.m4534a(java.lang.Runnable, boolean):void");
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    /* renamed from: d */
    public void mo35622d() {
        Runnable poll = this.f4259a.poll();
        if (poll != null) {
            this.f4260b.mo35620a(poll, this, true);
            return;
        }
        f4258e.decrementAndGet(this);
        Runnable poll2 = this.f4259a.poll();
        if (poll2 != null) {
            m4534a(poll2, true);
        }
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m4534a(runnable, false);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        m4534a(runnable, true);
    }

    public void execute(Runnable runnable) {
        m4534a(runnable, false);
    }

    /* renamed from: i */
    public int mo35624i() {
        return this.f4262d;
    }

    public String toString() {
        return super.toString() + "[dispatcher = " + this.f4260b + ']';
    }
}
