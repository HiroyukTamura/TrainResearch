package kotlinx.coroutines.p130u0;

import android.support.p001v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.random.Random;
import kotlinx.coroutines.C2496E;
import kotlinx.coroutines.internal.C2563r;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 \\2\u00020`2\u00020a:\u0003\\]^B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001f\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b \u0010\u0011J\u0015\u0010\"\u001a\b\u0018\u00010!R\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0013H\b¢\u0006\u0004\b$\u0010\u0015J\u0010\u0010%\u001a\u00020\u0001H\b¢\u0006\u0004\b%\u0010\u0017J-\u0010'\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\u001b\u0010*\u001a\u00020\u00132\n\u0010)\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0004H\b¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0001H\b¢\u0006\u0004\b.\u0010\u0017J\u001b\u00100\u001a\u00020\u00012\n\u0010/\u001a\u00060!R\u00020\u0000H\u0002¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\b\u0018\u00010!R\u00020\u0000H\u0002¢\u0006\u0004\b2\u0010#J\u001b\u00105\u001a\u00020\f2\n\u0010/\u001a\u00060!R\u00020\u0000H\u0000¢\u0006\u0004\b3\u00104J+\u0010:\u001a\u00020\u00132\n\u0010/\u001a\u00060!R\u00020\u00002\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u0001H\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020\u0004H\b¢\u0006\u0004\b;\u0010-J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0004¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020\u0013H\u0000¢\u0006\u0004\bD\u0010\u0015J\u000f\u0010F\u001a\u00020\u0006H\u0016¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\fH\b¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\fH\u0002¢\u0006\u0004\bL\u0010IJ+\u0010M\u001a\u0004\u0018\u00010\n*\b\u0018\u00010!R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\bM\u0010NR\u0017\u0010\u0010\u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010PR\u0017\u0010 \u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0017R\u0016\u0010S\u001a\u00020R8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020R8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bU\u0010TR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010VR\u0013\u0010W\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010IR\u0016\u0010\u0003\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010PR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010XR\"\u0010Z\u001a\u000e\u0012\n\u0012\b\u0018\u00010!R\u00020\u00000Y8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006_"}, mo21739d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createTask", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "parkedWorkersStackPush", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate$kotlinx_coroutines_core", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "parkedWorkersStackTopUpdate", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork$kotlinx_coroutines_core", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.u0.a */
public final class C2591a implements Executor, Closeable {

    /* renamed from: h */
    private static final AtomicLongFieldUpdater f4226h = AtomicLongFieldUpdater.newUpdater(C2591a.class, "parkedWorkersStack");

    /* renamed from: i */
    static final AtomicLongFieldUpdater f4227i = AtomicLongFieldUpdater.newUpdater(C2591a.class, "controlState");

    /* renamed from: l */
    private static final AtomicIntegerFieldUpdater f4228l = AtomicIntegerFieldUpdater.newUpdater(C2591a.class, "_isTerminated");
    @JvmField

    /* renamed from: m */
    public static final C2563r f4229m = new C2563r("NOT_IN_STACK");
    private volatile int _isTerminated;
    @JvmField

    /* renamed from: a */
    public final C2596d f4230a;
    @JvmField

    /* renamed from: b */
    public final C2596d f4231b;
    @JvmField

    /* renamed from: c */
    public final AtomicReferenceArray<C2592a> f4232c;
    volatile long controlState;
    @JvmField

    /* renamed from: d */
    public final int f4233d;
    @JvmField

    /* renamed from: e */
    public final int f4234e;
    @JvmField

    /* renamed from: f */
    public final long f4235f;
    @JvmField

    /* renamed from: g */
    public final String f4236g;
    private volatile long parkedWorkersStack;

    /* renamed from: kotlinx.coroutines.u0.a$a */
    public final class C2592a extends Thread {

        /* renamed from: h */
        static final AtomicIntegerFieldUpdater f4237h = AtomicIntegerFieldUpdater.newUpdater(C2592a.class, "workerCtl");
        @JvmField

        /* renamed from: a */
        public final C2605m f4238a = new C2605m();
        @JvmField

        /* renamed from: b */
        public C2593b f4239b = C2593b.DORMANT;

        /* renamed from: c */
        private long f4240c;

        /* renamed from: d */
        private long f4241d;

        /* renamed from: e */
        private int f4242e = Random.Default.nextInt();
        @JvmField

        /* renamed from: f */
        public boolean f4243f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker = C2591a.f4229m;
        volatile int workerCtl = 0;

        public C2592a(int i) {
            setDaemon(true);
            mo35616b(i);
        }

        /* renamed from: b */
        private final C2600h m4522b(boolean z) {
            if (C2496E.m4305a()) {
                if (!(this.f4238a.mo35631b() == 0)) {
                    throw new AssertionError();
                }
            }
            int i = (int) (C2591a.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int a = mo35611a(i);
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                a++;
                if (a > i) {
                    a = 1;
                }
                C2592a aVar = C2591a.this.f4232c.get(a);
                if (!(aVar == null || aVar == this)) {
                    if (C2496E.m4305a()) {
                        if (!(this.f4238a.mo35631b() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    C2605m mVar = this.f4238a;
                    C2605m mVar2 = aVar.f4238a;
                    long a2 = z ? mVar.mo35628a(mVar2) : mVar.mo35632b(mVar2);
                    if (a2 == -1) {
                        return this.f4238a.mo35633c();
                    }
                    if (a2 > 0) {
                        j = Math.min(j, a2);
                    }
                }
            }
            if (j == LongCompanionObject.MAX_VALUE) {
                j = 0;
            }
            this.f4241d = j;
            return null;
        }

        /* renamed from: c */
        private final C2600h m4523c() {
            C2596d dVar;
            if (mo35611a(2) == 0) {
                C2600h hVar = (C2600h) C2591a.this.f4230a.mo35565c();
                if (hVar != null) {
                    return hVar;
                }
                dVar = C2591a.this.f4231b;
            } else {
                C2600h hVar2 = (C2600h) C2591a.this.f4231b.mo35565c();
                if (hVar2 != null) {
                    return hVar2;
                }
                dVar = C2591a.this.f4230a;
            }
            return (C2600h) dVar.mo35565c();
        }

        /* renamed from: d */
        private final void m4524d() {
            synchronized (C2591a.this.f4232c) {
                if (!C2591a.this.isTerminated()) {
                    if (((int) (C2591a.this.controlState & 2097151)) > C2591a.this.f4233d) {
                        if (f4237h.compareAndSet(this, -1, 1)) {
                            int i = this.indexInArray;
                            mo35616b(0);
                            C2591a.this.mo35601a(this, i, 0);
                            int andDecrement = (int) (2097151 & C2591a.f4227i.getAndDecrement(C2591a.this));
                            if (andDecrement != i) {
                                C2592a aVar = C2591a.this.f4232c.get(andDecrement);
                                if (aVar == null) {
                                    Intrinsics.throwNpe();
                                }
                                C2592a aVar2 = aVar;
                                C2591a.this.f4232c.set(i, aVar2);
                                aVar2.mo35616b(i);
                                C2591a.this.mo35601a(aVar2, andDecrement, i);
                            }
                            C2591a.this.f4232c.set(andDecrement, (Object) null);
                            Unit unit = Unit.INSTANCE;
                            this.f4239b = C2593b.TERMINATED;
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public final int mo35610a() {
            return this.indexInArray;
        }

        /* renamed from: a */
        public final int mo35611a(int i) {
            int i2 = this.f4242e;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f4242e = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[ADDED_TO_REGION] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlinx.coroutines.p130u0.C2600h mo35612a(boolean r11) {
            /*
                r10 = this;
                kotlinx.coroutines.u0.a$b r0 = r10.f4239b
                kotlinx.coroutines.u0.a$b r1 = kotlinx.coroutines.p130u0.C2591a.C2593b.CPU_ACQUIRED
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x0009
                goto L_0x0032
            L_0x0009:
                kotlinx.coroutines.u0.a r0 = kotlinx.coroutines.p130u0.C2591a.this
            L_0x000b:
                long r6 = r0.controlState
                r4 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
                long r4 = r4 & r6
                r1 = 42
                long r4 = r4 >> r1
                int r1 = (int) r4
                if (r1 != 0) goto L_0x001b
                r0 = 0
                goto L_0x002c
            L_0x001b:
                r4 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
                long r8 = r6 - r4
                java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.p130u0.C2591a.f4227i
                r5 = r0
                boolean r1 = r4.compareAndSet(r5, r6, r8)
                if (r1 == 0) goto L_0x000b
                r0 = 1
            L_0x002c:
                if (r0 == 0) goto L_0x0034
                kotlinx.coroutines.u0.a$b r0 = kotlinx.coroutines.p130u0.C2591a.C2593b.CPU_ACQUIRED
                r10.f4239b = r0
            L_0x0032:
                r0 = 1
                goto L_0x0035
            L_0x0034:
                r0 = 0
            L_0x0035:
                if (r0 == 0) goto L_0x006e
                if (r11 == 0) goto L_0x0062
                kotlinx.coroutines.u0.a r11 = kotlinx.coroutines.p130u0.C2591a.this
                int r11 = r11.f4233d
                int r11 = r11 * 2
                int r11 = r10.mo35611a((int) r11)
                if (r11 != 0) goto L_0x0046
                goto L_0x0047
            L_0x0046:
                r2 = 0
            L_0x0047:
                if (r2 == 0) goto L_0x0050
                kotlinx.coroutines.u0.h r11 = r10.m4523c()
                if (r11 == 0) goto L_0x0050
                goto L_0x006d
            L_0x0050:
                kotlinx.coroutines.u0.m r11 = r10.f4238a
                kotlinx.coroutines.u0.h r11 = r11.mo35633c()
                if (r11 == 0) goto L_0x0059
                goto L_0x006d
            L_0x0059:
                if (r2 != 0) goto L_0x0069
                kotlinx.coroutines.u0.h r11 = r10.m4523c()
                if (r11 == 0) goto L_0x0069
                goto L_0x006d
            L_0x0062:
                kotlinx.coroutines.u0.h r11 = r10.m4523c()
                if (r11 == 0) goto L_0x0069
                goto L_0x006d
            L_0x0069:
                kotlinx.coroutines.u0.h r11 = r10.m4522b((boolean) r3)
            L_0x006d:
                return r11
            L_0x006e:
                if (r11 == 0) goto L_0x0079
                kotlinx.coroutines.u0.m r11 = r10.f4238a
                kotlinx.coroutines.u0.h r11 = r11.mo35633c()
                if (r11 == 0) goto L_0x0079
                goto L_0x0083
            L_0x0079:
                kotlinx.coroutines.u0.a r11 = kotlinx.coroutines.p130u0.C2591a.this
                kotlinx.coroutines.u0.d r11 = r11.f4231b
                java.lang.Object r11 = r11.mo35565c()
                kotlinx.coroutines.u0.h r11 = (kotlinx.coroutines.p130u0.C2600h) r11
            L_0x0083:
                if (r11 == 0) goto L_0x0086
                goto L_0x008a
            L_0x0086:
                kotlinx.coroutines.u0.h r11 = r10.m4522b((boolean) r2)
            L_0x008a:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p130u0.C2591a.C2592a.mo35612a(boolean):kotlinx.coroutines.u0.h");
        }

        /* renamed from: a */
        public final void mo35613a(Object obj) {
            this.nextParkedWorker = obj;
        }

        /* renamed from: a */
        public final boolean mo35614a(C2593b bVar) {
            C2593b bVar2 = this.f4239b;
            boolean z = bVar2 == C2593b.CPU_ACQUIRED;
            if (z) {
                C2591a.f4227i.addAndGet(C2591a.this, 4398046511104L);
            }
            if (bVar2 != bVar) {
                this.f4239b = bVar;
            }
            return z;
        }

        /* renamed from: b */
        public final Object mo35615b() {
            return this.nextParkedWorker;
        }

        /* renamed from: b */
        public final void mo35616b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(C2591a.this.f4236g);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public void run() {
            loop0:
            while (true) {
                boolean z = true;
                boolean z2 = false;
                while (!C2591a.this.isTerminated() && this.f4239b != C2593b.TERMINATED) {
                    C2600h a = mo35612a(this.f4243f);
                    if (a == null) {
                        this.f4243f = false;
                        if (this.f4241d == 0) {
                            if (this.nextParkedWorker != C2591a.f4229m) {
                                if (C2496E.m4305a()) {
                                    if (!(this.f4238a.mo35631b() == 0)) {
                                        throw new AssertionError();
                                    }
                                }
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != C2591a.f4229m) || C2591a.this.isTerminated() || this.f4239b == C2593b.TERMINATED) {
                                        break;
                                    }
                                    mo35614a(C2593b.PARKING);
                                    Thread.interrupted();
                                    if (this.f4240c == 0) {
                                        this.f4240c = System.nanoTime() + C2591a.this.f4235f;
                                    }
                                    LockSupport.parkNanos(C2591a.this.f4235f);
                                    if (System.nanoTime() - this.f4240c >= 0) {
                                        this.f4240c = 0;
                                        m4524d();
                                    }
                                }
                            } else {
                                C2591a.this.mo35603a(this);
                            }
                        } else if (!z2) {
                            z2 = true;
                        } else {
                            mo35614a(C2593b.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f4241d);
                            this.f4241d = 0;
                        }
                    } else {
                        this.f4241d = 0;
                        int i = a.f4266b.mo35624i();
                        this.f4240c = 0;
                        if (this.f4239b == C2593b.PARKING) {
                            if (C2496E.m4305a()) {
                                if (!(i == 1)) {
                                    throw new AssertionError();
                                }
                            }
                            this.f4239b = C2593b.BLOCKING;
                        }
                        if (i != 0 && mo35614a(C2593b.BLOCKING)) {
                            C2591a.this.mo35605d();
                        }
                        C2591a.this.mo35602a(a);
                        if (i == 0) {
                            continue;
                        } else {
                            C2591a.f4227i.addAndGet(C2591a.this, -2097152);
                            C2593b bVar = this.f4239b;
                            if (bVar == C2593b.TERMINATED) {
                                continue;
                            } else {
                                if (C2496E.m4305a()) {
                                    if (bVar != C2593b.BLOCKING) {
                                        z = false;
                                    }
                                    if (!z) {
                                        throw new AssertionError();
                                    }
                                }
                                this.f4239b = C2593b.DORMANT;
                            }
                        }
                    }
                }
            }
            mo35614a(C2593b.TERMINATED);
        }
    }

    /* renamed from: kotlinx.coroutines.u0.a$b */
    public enum C2593b {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public C2591a(int i, int i2, long j, String str) {
        this.f4233d = i;
        this.f4234e = i2;
        this.f4235f = j;
        this.f4236g = str;
        if (i >= 1) {
            if (this.f4234e >= this.f4233d) {
                if (this.f4234e <= 2097150) {
                    if (this.f4235f > 0) {
                        this.f4230a = new C2596d();
                        this.f4231b = new C2596d();
                        this.parkedWorkersStack = 0;
                        this.f4232c = new AtomicReferenceArray<>(this.f4234e + 1);
                        this.controlState = ((long) this.f4233d) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    StringBuilder a = C0681a.m330a("Idle worker keep alive time ");
                    a.append(this.f4235f);
                    a.append(" must be positive");
                    throw new IllegalArgumentException(a.toString().toString());
                }
                throw new IllegalArgumentException(C0681a.m322a(C0681a.m330a("Max pool size "), this.f4234e, " should not exceed maximal supported number of threads 2097150").toString());
            }
            StringBuilder a2 = C0681a.m330a("Max pool size ");
            a2.append(this.f4234e);
            a2.append(" should be greater than or equals to core pool size ");
            a2.append(this.f4233d);
            throw new IllegalArgumentException(a2.toString().toString());
        }
        throw new IllegalArgumentException(C0681a.m322a(C0681a.m330a("Core pool size "), this.f4233d, " should be at least 1").toString());
    }

    /* renamed from: a */
    public static /* synthetic */ void m4509a(C2591a aVar, Runnable runnable, C2601i iVar, boolean z, int i) {
        if ((i & 2) != 0) {
            iVar = C2599g.f4264a;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        aVar.mo35600a(runnable, iVar, z);
    }

    /* renamed from: b */
    private final int m4510b(C2592a aVar) {
        int a;
        do {
            Object b = aVar.mo35615b();
            if (b == f4229m) {
                return -1;
            }
            if (b == null) {
                return 0;
            }
            aVar = (C2592a) b;
            a = aVar.mo35610a();
        } while (a == 0);
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        return r1;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int m4511h() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.u0.a$a> r0 = r10.f4232c
            monitor-enter(r0)
            boolean r1 = r10.isTerminated()     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x000c
            r1 = -1
        L_0x000a:
            monitor-exit(r0)
            return r1
        L_0x000c:
            long r1 = r10.controlState     // Catch:{ all -> 0x007a }
            r3 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r1 & r3
            int r6 = (int) r5     // Catch:{ all -> 0x007a }
            r7 = 4398044413952(0x3ffffe00000, double:2.1729226538177E-311)
            long r1 = r1 & r7
            r5 = 21
            long r1 = r1 >> r5
            int r2 = (int) r1     // Catch:{ all -> 0x007a }
            int r1 = r6 - r2
            r2 = 0
            int r1 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r1, (int) r2)     // Catch:{ all -> 0x007a }
            int r5 = r10.f4233d     // Catch:{ all -> 0x007a }
            if (r1 < r5) goto L_0x002b
            monitor-exit(r0)
            return r2
        L_0x002b:
            int r5 = r10.f4234e     // Catch:{ all -> 0x007a }
            if (r6 < r5) goto L_0x0031
            monitor-exit(r0)
            return r2
        L_0x0031:
            long r5 = r10.controlState     // Catch:{ all -> 0x007a }
            long r5 = r5 & r3
            int r6 = (int) r5     // Catch:{ all -> 0x007a }
            r5 = 1
            int r6 = r6 + r5
            if (r6 <= 0) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.u0.a$a> r7 = r10.f4232c     // Catch:{ all -> 0x007a }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ all -> 0x007a }
            if (r7 != 0) goto L_0x0043
            r7 = 1
            goto L_0x0044
        L_0x0043:
            r7 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x006e
            kotlinx.coroutines.u0.a$a r7 = new kotlinx.coroutines.u0.a$a     // Catch:{ all -> 0x007a }
            r7.<init>(r6)     // Catch:{ all -> 0x007a }
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.u0.a$a> r8 = r10.f4232c     // Catch:{ all -> 0x007a }
            r8.set(r6, r7)     // Catch:{ all -> 0x007a }
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = f4227i     // Catch:{ all -> 0x007a }
            long r8 = r8.incrementAndGet(r10)     // Catch:{ all -> 0x007a }
            long r3 = r3 & r8
            int r4 = (int) r3     // Catch:{ all -> 0x007a }
            if (r6 != r4) goto L_0x005b
            r2 = 1
        L_0x005b:
            if (r2 == 0) goto L_0x0062
            r7.start()     // Catch:{ all -> 0x007a }
            int r1 = r1 + r5
            goto L_0x000a
        L_0x0062:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007a }
            r2.<init>(r1)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x006e:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007a }
            r2.<init>(r1)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x007a:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x007e
        L_0x007d:
            throw r1
        L_0x007e:
            goto L_0x007d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p130u0.C2591a.m4511h():int");
    }

    /* renamed from: i */
    private final C2592a m4512i() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof C2592a)) {
            currentThread = null;
        }
        C2592a aVar = (C2592a) currentThread;
        if (aVar == null || !Intrinsics.areEqual((Object) C2591a.this, (Object) this)) {
            return null;
        }
        return aVar;
    }

    /* renamed from: i */
    private final boolean m4513i(long j) {
        if (RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f4233d) {
            int h = m4511h();
            if (h == 1 && this.f4233d > 1) {
                m4511h();
            }
            if (h > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    private final boolean m4514l() {
        while (true) {
            long j = this.parkedWorkersStack;
            C2592a aVar = this.f4232c.get((int) (2097151 & j));
            if (aVar != null) {
                long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
                int b = m4510b(aVar);
                if (b < 0) {
                    continue;
                } else {
                    if (f4226h.compareAndSet(this, j, ((long) b) | j2)) {
                        aVar.mo35613a((Object) f4229m);
                    } else {
                        continue;
                    }
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                return false;
            }
            if (C2592a.f4237h.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    /* renamed from: a */
    public final C2600h mo35599a(Runnable runnable, C2601i iVar) {
        if (((C2598f) C2603k.f4272e) != null) {
            long nanoTime = System.nanoTime();
            if (!(runnable instanceof C2600h)) {
                return new C2602j(runnable, nanoTime, iVar);
            }
            C2600h hVar = (C2600h) runnable;
            hVar.f4265a = nanoTime;
            hVar.f4266b = iVar;
            return hVar;
        }
        throw null;
    }

    /* renamed from: a */
    public final void mo35601a(C2592a aVar, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            if (i3 == i) {
                i3 = i2 == 0 ? m4510b(aVar) : i2;
            }
            if (i3 >= 0) {
                if (f4226h.compareAndSet(this, j, j2 | ((long) i3))) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo35602a(C2600h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    /* renamed from: a */
    public final boolean mo35603a(C2592a aVar) {
        long j;
        long j2;
        int a;
        if (aVar.mo35615b() != f4229m) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            a = aVar.mo35610a();
            if (C2496E.m4305a()) {
                if (!(a != 0)) {
                    throw new AssertionError();
                }
            }
            aVar.mo35613a((Object) this.f4232c.get(i));
        } while (!f4226h.compareAndSet(this, j, ((long) a) | j2));
        return true;
    }

    public void close() {
        mo35607h(10000);
    }

    /* renamed from: d */
    public final void mo35605d() {
        if (!m4514l() && !m4513i(this.controlState)) {
            m4514l();
        }
    }

    public void execute(Runnable runnable) {
        m4509a(this, runnable, (C2601i) null, false, 6);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        if (r9 != null) goto L_0x0078;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo35607h(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4228l
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            kotlinx.coroutines.u0.a$a r0 = r8.m4512i()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.u0.a$a> r3 = r8.f4232c
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch:{ all -> 0x00b7 }
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L_0x005d
            r3 = 1
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.u0.a$a> r4 = r8.f4232c
            java.lang.Object r4 = r4.get(r3)
            if (r4 != 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0028:
            kotlinx.coroutines.u0.a$a r4 = (kotlinx.coroutines.p130u0.C2591a.C2592a) r4
            if (r4 == r0) goto L_0x0058
        L_0x002c:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L_0x0039
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L_0x002c
        L_0x0039:
            kotlinx.coroutines.u0.a$b r6 = r4.f4239b
            boolean r7 = kotlinx.coroutines.C2496E.m4305a()
            if (r7 == 0) goto L_0x0051
            kotlinx.coroutines.u0.a$b r7 = kotlinx.coroutines.p130u0.C2591a.C2593b.TERMINATED
            if (r6 != r7) goto L_0x0047
            r6 = 1
            goto L_0x0048
        L_0x0047:
            r6 = 0
        L_0x0048:
            if (r6 == 0) goto L_0x004b
            goto L_0x0051
        L_0x004b:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x0051:
            kotlinx.coroutines.u0.m r4 = r4.f4238a
            kotlinx.coroutines.u0.d r6 = r8.f4231b
            r4.mo35630a((kotlinx.coroutines.p130u0.C2596d) r6)
        L_0x0058:
            if (r3 == r5) goto L_0x005d
            int r3 = r3 + 1
            goto L_0x001d
        L_0x005d:
            kotlinx.coroutines.u0.d r9 = r8.f4231b
            r9.mo35562a()
            kotlinx.coroutines.u0.d r9 = r8.f4230a
            r9.mo35562a()
        L_0x0067:
            if (r0 == 0) goto L_0x0070
            kotlinx.coroutines.u0.h r9 = r0.mo35612a((boolean) r2)
            if (r9 == 0) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            kotlinx.coroutines.u0.d r9 = r8.f4230a
            java.lang.Object r9 = r9.mo35565c()
            kotlinx.coroutines.u0.h r9 = (kotlinx.coroutines.p130u0.C2600h) r9
        L_0x0078:
            if (r9 == 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            kotlinx.coroutines.u0.d r9 = r8.f4231b
            java.lang.Object r9 = r9.mo35565c()
            kotlinx.coroutines.u0.h r9 = (kotlinx.coroutines.p130u0.C2600h) r9
        L_0x0083:
            if (r9 == 0) goto L_0x0089
            r8.mo35602a((kotlinx.coroutines.p130u0.C2600h) r9)
            goto L_0x0067
        L_0x0089:
            if (r0 == 0) goto L_0x0090
            kotlinx.coroutines.u0.a$b r9 = kotlinx.coroutines.p130u0.C2591a.C2593b.TERMINATED
            r0.mo35614a((kotlinx.coroutines.p130u0.C2591a.C2593b) r9)
        L_0x0090:
            boolean r9 = kotlinx.coroutines.C2496E.m4305a()
            if (r9 == 0) goto L_0x00b0
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.f4233d
            if (r10 != r9) goto L_0x00a7
            r1 = 1
        L_0x00a7:
            if (r1 == 0) goto L_0x00aa
            goto L_0x00b0
        L_0x00aa:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x00b0:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        L_0x00b7:
            r9 = move-exception
            monitor-exit(r3)
            goto L_0x00bb
        L_0x00ba:
            throw r9
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p130u0.C2591a.mo35607h(long):void");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        int length = this.f4232c.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            C2592a aVar = this.f4232c.get(i6);
            if (aVar != null) {
                int b = aVar.f4238a.mo35631b();
                int ordinal = aVar.f4239b.ordinal();
                if (ordinal == 0) {
                    i++;
                    sb = new StringBuilder();
                    sb.append(String.valueOf(b));
                    str = "c";
                } else if (ordinal == 1) {
                    i2++;
                    sb = new StringBuilder();
                    sb.append(String.valueOf(b));
                    str = "b";
                } else if (ordinal == 2) {
                    i3++;
                } else if (ordinal == 3) {
                    i4++;
                    if (b > 0) {
                        sb = new StringBuilder();
                        sb.append(String.valueOf(b));
                        str = "d";
                    }
                } else if (ordinal == 4) {
                    i5++;
                }
                sb.append(str);
                arrayList.add(sb.toString());
            }
        }
        long j = this.controlState;
        return this.f4236g + '@' + C1532a.m2147b(this) + '[' + "Pool Size {" + "core = " + this.f4233d + ", " + "max = " + this.f4234e + "}, " + "Worker States {" + "CPU = " + i + ", " + "blocking = " + i2 + ", " + "parked = " + i3 + ", " + "dormant = " + i4 + ", " + "terminated = " + i5 + "}, " + "running workers queues = " + arrayList + ", " + "global CPU queue size = " + this.f4230a.mo35564b() + ", " + "global blocking queue size = " + this.f4231b.mo35564b() + ", " + "Control State {" + "created workers= " + ((int) (2097151 & j)) + ", " + "blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", " + "CPUs acquired = " + (this.f4233d - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* renamed from: a */
    public final void mo35600a(Runnable runnable, C2601i iVar, boolean z) {
        C2600h hVar;
        C2600h a = mo35599a(runnable, iVar);
        C2592a i = m4512i();
        boolean z2 = true;
        if (i == null || i.f4239b == C2593b.TERMINATED || (a.f4266b.mo35624i() == 0 && i.f4239b == C2593b.BLOCKING)) {
            hVar = a;
        } else {
            i.f4243f = true;
            hVar = i.f4238a.mo35629a(a, z);
        }
        if (hVar != null) {
            if (!(hVar.f4266b.mo35624i() == 1 ? this.f4231b : this.f4230a).mo35563a(hVar)) {
                throw new RejectedExecutionException(C0681a.m324a(new StringBuilder(), this.f4236g, " was terminated"));
            }
        }
        if (!z || i == null) {
            z2 = false;
        }
        if (a.f4266b.mo35624i() != 0) {
            long addAndGet = f4227i.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
            if (!z2 && !m4514l() && !m4513i(addAndGet)) {
                m4514l();
            }
        } else if (!z2) {
            mo35605d();
        }
    }
}
