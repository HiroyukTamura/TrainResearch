package p040i.p103M.p106e;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0003\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001c\u001a\u00020\u0016J\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001fJ\u0006\u0010 \u001a\u00020\tJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo21739d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "backend", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "busyQueues", "", "Lokhttp3/internal/concurrent/TaskQueue;", "coordinatorWaiting", "", "coordinatorWakeUpAt", "", "nextQueueName", "", "readyQueues", "runnable", "Ljava/lang/Runnable;", "activeQueues", "", "afterRun", "", "task", "Lokhttp3/internal/concurrent/Task;", "delayNanos", "awaitTaskToRun", "beforeRun", "cancelAll", "kickCoordinator", "taskQueue", "kickCoordinator$okhttp", "newQueue", "runTask", "Backend", "Companion", "RealBackend", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.e.e */
public final class C1788e {
    @JvmField

    /* renamed from: h */
    public static final C1788e f2308h = new C1788e(new C1791c(C1764b.m2626a(C1764b.f2220h + " TaskRunner", true)));
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Logger f2309i;

    /* renamed from: j */
    public static final C1790b f2310j = new C1790b((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f2311a = 10000;

    /* renamed from: b */
    private boolean f2312b;

    /* renamed from: c */
    private long f2313c;

    /* renamed from: d */
    private final List<C1787d> f2314d = new ArrayList();

    /* renamed from: e */
    private final List<C1787d> f2315e = new ArrayList();

    /* renamed from: f */
    private final Runnable f2316f = new C1792d(this);

    /* renamed from: g */
    private final C1789a f2317g;

    /* renamed from: i.M.e.e$a */
    public interface C1789a {
        /* renamed from: a */
        void mo27676a(C1788e eVar);

        /* renamed from: a */
        void mo27677a(C1788e eVar, long j);

        void execute(Runnable runnable);

        long nanoTime();
    }

    /* renamed from: i.M.e.e$b */
    public static final class C1790b {
        public /* synthetic */ C1790b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* renamed from: i.M.e.e$c */
    public static final class C1791c implements C1789a {

        /* renamed from: a */
        private final ThreadPoolExecutor f2318a;

        public C1791c(ThreadFactory threadFactory) {
            Intrinsics.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.f2318a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        /* renamed from: a */
        public void mo27676a(C1788e eVar) {
            Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
            eVar.notify();
        }

        /* renamed from: a */
        public void mo27677a(C1788e eVar, long j) throws InterruptedException {
            Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                eVar.wait(j2, (int) j3);
            }
        }

        public void execute(Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "runnable");
            this.f2318a.execute(runnable);
        }

        public long nanoTime() {
            return System.nanoTime();
        }
    }

    /* renamed from: i.M.e.e$d */
    public static final class C1792d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1788e f2319a;

        C1792d(C1788e eVar) {
            this.f2319a = eVar;
        }

        public void run() {
            C1784a a;
            while (true) {
                synchronized (this.f2319a) {
                    a = this.f2319a.mo27671a();
                }
                if (a != null) {
                    C1787d d = a.mo27655d();
                    if (d == null) {
                        Intrinsics.throwNpe();
                    }
                    long j = -1;
                    C1790b bVar = C1788e.f2310j;
                    boolean isLoggable = C1788e.f2309i.isLoggable(Level.FINE);
                    if (isLoggable) {
                        j = d.mo27668h().mo27674c().nanoTime();
                        C1785b.m2720a(a, d, "starting");
                    }
                    try {
                        this.f2319a.m2736a(a);
                        Unit unit = Unit.INSTANCE;
                        if (isLoggable) {
                            long nanoTime = d.mo27668h().mo27674c().nanoTime() - j;
                            StringBuilder a2 = C0681a.m330a("finished run in ");
                            a2.append(C1785b.m2719a(nanoTime));
                            C1785b.m2720a(a, d, a2.toString());
                        }
                    } catch (Throwable th) {
                        if (isLoggable) {
                            long nanoTime2 = d.mo27668h().mo27674c().nanoTime() - j;
                            StringBuilder a3 = C0681a.m330a("failed a run in ");
                            a3.append(C1785b.m2719a(nanoTime2));
                            C1785b.m2720a(a, d, a3.toString());
                        }
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(C1788e.class.getName());
        Intrinsics.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f2309i = logger;
    }

    public C1788e(C1789a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "backend");
        this.f2317g = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m2736a(C1784a aVar) {
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName(aVar.mo27653b());
            try {
                long e = aVar.mo27646e();
                synchronized (this) {
                    m2737a(aVar, e);
                    Unit unit = Unit.INSTANCE;
                }
                currentThread.setName(name);
            } catch (Throwable th) {
                synchronized (this) {
                    m2737a(aVar, -1);
                    Unit unit2 = Unit.INSTANCE;
                    currentThread.setName(name);
                    throw th;
                }
            }
        } else {
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread2 = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread2, "Thread.currentThread()");
            a.append(currentThread2.getName());
            a.append(" MUST NOT hold lock on ");
            a.append(this);
            throw new AssertionError(a.toString());
        }
    }

    /* renamed from: a */
    private final void m2737a(C1784a aVar, long j) {
        if (!C1764b.f2219g || Thread.holdsLock(this)) {
            C1787d d = aVar.mo27655d();
            if (d == null) {
                Intrinsics.throwNpe();
            }
            if (d.mo27663c() == aVar) {
                boolean d2 = d.mo27664d();
                d.mo27660a(false);
                d.mo27658a((C1784a) null);
                this.f2314d.remove(d);
                if (j != -1 && !d2 && !d.mo27667g()) {
                    d.mo27661a(aVar, j, true);
                }
                if (!d.mo27665e().isEmpty()) {
                    this.f2315e.add(d);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:48|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        mo27673b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0115, code lost:
        r1.f2312b = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0118, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x010d */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p040i.p103M.p106e.C1784a mo27671a() {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = p040i.p103M.C1764b.f2219g
            java.lang.String r2 = " MUST hold lock on "
            java.lang.String r3 = "Thread.currentThread()"
            java.lang.String r4 = "Thread "
            if (r0 == 0) goto L_0x0035
            boolean r0 = java.lang.Thread.holdsLock(r16)
            if (r0 == 0) goto L_0x0013
            goto L_0x0035
        L_0x0013:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r4)
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r3)
            java.lang.String r3 = r5.getName()
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r2 = r4.toString()
            r0.<init>(r2)
            throw r0
        L_0x0035:
            java.util.List<i.M.e.d> r0 = r1.f2315e
            boolean r0 = r0.isEmpty()
            r5 = 0
            if (r0 == 0) goto L_0x003f
            return r5
        L_0x003f:
            i.M.e.e$a r0 = r1.f2317g
            long r6 = r0.nanoTime()
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.util.List<i.M.e.d> r0 = r1.f2315e
            java.util.Iterator r0 = r0.iterator()
        L_0x0050:
            boolean r10 = r0.hasNext()
            r12 = 0
            if (r10 == 0) goto L_0x0081
            java.lang.Object r10 = r0.next()
            i.M.e.d r10 = (p040i.p103M.p106e.C1787d) r10
            java.util.List r10 = r10.mo27665e()
            java.lang.Object r10 = r10.get(r12)
            i.M.e.a r10 = (p040i.p103M.p106e.C1784a) r10
            long r13 = r10.mo27654c()
            long r13 = r13 - r6
            r11 = 0
            long r13 = java.lang.Math.max(r11, r13)
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 <= 0) goto L_0x007b
            long r8 = java.lang.Math.min(r13, r8)
            goto L_0x0050
        L_0x007b:
            if (r5 == 0) goto L_0x007f
            r0 = 1
            goto L_0x0082
        L_0x007f:
            r5 = r10
            goto L_0x0050
        L_0x0081:
            r0 = 0
        L_0x0082:
            if (r5 == 0) goto L_0x00eb
            boolean r6 = p040i.p103M.C1764b.f2219g
            if (r6 == 0) goto L_0x00b1
            boolean r6 = java.lang.Thread.holdsLock(r16)
            if (r6 == 0) goto L_0x008f
            goto L_0x00b1
        L_0x008f:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r4)
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r3)
            java.lang.String r3 = r5.getName()
            r4.append(r3)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r2 = r4.toString()
            r0.<init>(r2)
            throw r0
        L_0x00b1:
            r2 = -1
            r5.mo27650a((long) r2)
            i.M.e.d r2 = r5.mo27655d()
            if (r2 != 0) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00bf:
            java.util.List r3 = r2.mo27665e()
            r3.remove(r5)
            java.util.List<i.M.e.d> r3 = r1.f2315e
            r3.remove(r2)
            r2.mo27658a((p040i.p103M.p106e.C1784a) r5)
            java.util.List<i.M.e.d> r3 = r1.f2314d
            r3.add(r2)
            if (r0 != 0) goto L_0x00e3
            boolean r0 = r1.f2312b
            if (r0 != 0) goto L_0x00ea
            java.util.List<i.M.e.d> r0 = r1.f2315e
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x00ea
        L_0x00e3:
            i.M.e.e$a r0 = r1.f2317g
            java.lang.Runnable r2 = r1.f2316f
            r0.execute(r2)
        L_0x00ea:
            return r5
        L_0x00eb:
            boolean r0 = r1.f2312b
            if (r0 == 0) goto L_0x00fd
            long r2 = r1.f2313c
            long r2 = r2 - r6
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00fb
            i.M.e.e$a r0 = r1.f2317g
            r0.mo27676a(r1)
        L_0x00fb:
            r0 = 0
            return r0
        L_0x00fd:
            r0 = 1
            r1.f2312b = r0
            long r6 = r6 + r8
            r1.f2313c = r6
            i.M.e.e$a r0 = r1.f2317g     // Catch:{ InterruptedException -> 0x010d }
            r0.mo27677a(r1, r8)     // Catch:{ InterruptedException -> 0x010d }
        L_0x0108:
            r5 = 0
            goto L_0x0111
        L_0x010a:
            r0 = move-exception
            r5 = 0
            goto L_0x0115
        L_0x010d:
            r16.mo27673b()     // Catch:{ all -> 0x010a }
            goto L_0x0108
        L_0x0111:
            r1.f2312b = r5
            goto L_0x0035
        L_0x0115:
            r1.f2312b = r5
            goto L_0x0119
        L_0x0118:
            throw r0
        L_0x0119:
            goto L_0x0118
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p106e.C1788e.mo27671a():i.M.e.a");
    }

    /* renamed from: b */
    public final void mo27673b() {
        for (int size = this.f2314d.size() - 1; size >= 0; size--) {
            this.f2314d.get(size).mo27662b();
        }
        for (int size2 = this.f2315e.size() - 1; size2 >= 0; size2--) {
            C1787d dVar = this.f2315e.get(size2);
            dVar.mo27662b();
            if (dVar.mo27665e().isEmpty()) {
                this.f2315e.remove(size2);
            }
        }
    }

    /* renamed from: c */
    public final C1789a mo27674c() {
        return this.f2317g;
    }

    /* renamed from: d */
    public final C1787d mo27675d() {
        int i;
        synchronized (this) {
            i = this.f2311a;
            this.f2311a = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new C1787d(this, sb.toString());
    }

    /* renamed from: a */
    public final void mo27672a(C1787d dVar) {
        Intrinsics.checkParameterIsNotNull(dVar, "taskQueue");
        if (!C1764b.f2219g || Thread.holdsLock(this)) {
            if (dVar.mo27663c() == null) {
                if (!dVar.mo27665e().isEmpty()) {
                    List<C1787d> list = this.f2315e;
                    Intrinsics.checkParameterIsNotNull(list, "$this$addIfAbsent");
                    if (!list.contains(dVar)) {
                        list.add(dVar);
                    }
                } else {
                    this.f2315e.remove(dVar);
                }
            }
            if (this.f2312b) {
                this.f2317g.mo27676a(this);
            } else {
                this.f2317g.execute(this.f2316f);
            }
        } else {
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST hold lock on ");
            a.append(this);
            throw new AssertionError(a.toString());
        }
    }
}
