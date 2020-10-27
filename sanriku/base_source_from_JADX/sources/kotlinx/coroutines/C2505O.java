package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.C2554k;
import kotlinx.coroutines.internal.C2566u;
import kotlinx.coroutines.internal.C2567v;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0016\u00103\u001a\u00020\u00148T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, mo21739d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.O */
public abstract class C2505O extends C2508P {

    /* renamed from: d */
    private static final AtomicReferenceFieldUpdater f4119d;

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater f4120e;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;
    private volatile Object _queue = null;

    /* renamed from: kotlinx.coroutines.O$a */
    public static abstract class C2506a implements Runnable, Comparable<C2506a>, C1110L, C2567v {

        /* renamed from: a */
        private Object f4121a;

        /* renamed from: b */
        private int f4122b;
        @JvmField

        /* renamed from: c */
        public long f4123c;

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0048, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
            return r8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0040  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized int mo35516a(long r8, kotlinx.coroutines.C2505O.C2507b r10, kotlinx.coroutines.C2505O r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7.f4121a     // Catch:{ all -> 0x004d }
                kotlinx.coroutines.internal.r r1 = kotlinx.coroutines.C2509Q.f4125a     // Catch:{ all -> 0x004d }
                if (r0 != r1) goto L_0x000c
                r8 = 2
            L_0x000a:
                monitor-exit(r7)
                return r8
            L_0x000c:
                monitor-enter(r10)     // Catch:{ all -> 0x004d }
                kotlinx.coroutines.internal.v r0 = r10.mo35576a()     // Catch:{ all -> 0x004a }
                kotlinx.coroutines.O$a r0 = (kotlinx.coroutines.C2505O.C2506a) r0     // Catch:{ all -> 0x004a }
                boolean r11 = r11.m4343w()     // Catch:{ all -> 0x004a }
                if (r11 == 0) goto L_0x001d
                r8 = 1
                monitor-exit(r10)     // Catch:{ all -> 0x004d }
                monitor-exit(r7)
                return r8
            L_0x001d:
                r1 = 0
                if (r0 != 0) goto L_0x0024
            L_0x0021:
                r10.f4124b = r8     // Catch:{ all -> 0x004a }
                goto L_0x0037
            L_0x0024:
                long r3 = r0.f4123c     // Catch:{ all -> 0x004a }
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L_0x002d
                goto L_0x002e
            L_0x002d:
                r8 = r3
            L_0x002e:
                long r3 = r10.f4124b     // Catch:{ all -> 0x004a }
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L_0x0037
                goto L_0x0021
            L_0x0037:
                long r8 = r7.f4123c     // Catch:{ all -> 0x004a }
                long r3 = r10.f4124b     // Catch:{ all -> 0x004a }
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L_0x0044
                long r8 = r10.f4124b     // Catch:{ all -> 0x004a }
                r7.f4123c = r8     // Catch:{ all -> 0x004a }
            L_0x0044:
                r10.mo35578a(r7)     // Catch:{ all -> 0x004a }
                monitor-exit(r10)     // Catch:{ all -> 0x004d }
                r8 = 0
                goto L_0x000a
            L_0x004a:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x004d }
                throw r8     // Catch:{ all -> 0x004d }
            L_0x004d:
                r8 = move-exception
                monitor-exit(r7)
                goto L_0x0051
            L_0x0050:
                throw r8
            L_0x0051:
                goto L_0x0050
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2505O.C2506a.mo35516a(long, kotlinx.coroutines.O$b, kotlinx.coroutines.O):int");
        }

        /* renamed from: a */
        public int compareTo(C2506a aVar) {
            long j = this.f4123c - aVar.f4123c;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        /* renamed from: a */
        public C2566u<?> mo35518a() {
            Object obj = this.f4121a;
            if (!(obj instanceof C2566u)) {
                obj = null;
            }
            return (C2566u) obj;
        }

        /* renamed from: a */
        public void mo35519a(C2566u<?> uVar) {
            if (this.f4121a != C2509Q.f4125a) {
                this.f4121a = uVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* renamed from: a */
        public final boolean mo35520a(long j) {
            return j - this.f4123c >= 0;
        }

        /* renamed from: b */
        public final synchronized void mo21829b() {
            Object obj = this.f4121a;
            if (obj != C2509Q.f4125a) {
                if (!(obj instanceof C2507b)) {
                    obj = null;
                }
                C2507b bVar = (C2507b) obj;
                if (bVar != null) {
                    bVar.mo35580b(this);
                }
                this.f4121a = C2509Q.f4125a;
            }
        }

        public int getIndex() {
            return this.f4122b;
        }

        public void setIndex(int i) {
            this.f4122b = i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("Delayed[nanos=");
            a.append(this.f4123c);
            a.append(']');
            return a.toString();
        }
    }

    /* renamed from: kotlinx.coroutines.O$b */
    public static final class C2507b extends C2566u<C2506a> {
        @JvmField

        /* renamed from: b */
        public long f4124b;

        public C2507b(long j) {
            this.f4124b = j;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<C2505O> cls2 = C2505O.class;
        f4119d = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        f4120e = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    /* renamed from: b */
    private final boolean m4342b(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (m4343w()) {
                return false;
            }
            if (obj == null) {
                if (f4119d.compareAndSet(this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C2554k) {
                C2554k kVar = (C2554k) obj;
                int a = kVar.mo35566a(runnable);
                if (a == 0) {
                    return true;
                }
                if (a == 1) {
                    f4119d.compareAndSet(this, obj, kVar.mo35570d());
                } else if (a == 2) {
                    return false;
                }
            } else if (obj == C2509Q.f4126b) {
                return false;
            } else {
                C2554k kVar2 = new C2554k(8, true);
                kVar2.mo35566a((Runnable) obj);
                kVar2.mo35566a(runnable);
                if (f4119d.compareAndSet(this, obj, kVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    /* access modifiers changed from: private */
    /* renamed from: w */
    public final boolean m4343w() {
        return this._isCompleted;
    }

    /* renamed from: a */
    public final void mo35511a(Runnable runnable) {
        if (m4342b(runnable)) {
            Thread s = mo35488s();
            if (Thread.currentThread() != s) {
                LockSupport.unpark(s);
                return;
            }
            return;
        }
        C2497F.f4103g.mo35511a(runnable);
    }

    /* JADX WARNING: type inference failed for: r5v4, types: [kotlinx.coroutines.internal.v] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo35512b(long r5, kotlinx.coroutines.C2505O.C2506a r7) {
        /*
            r4 = this;
            boolean r0 = r4.m4343w()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x0028
        L_0x000a:
            java.lang.Object r0 = r4._delayed
            kotlinx.coroutines.O$b r0 = (kotlinx.coroutines.C2505O.C2507b) r0
            if (r0 == 0) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f4120e
            kotlinx.coroutines.O$b r3 = new kotlinx.coroutines.O$b
            r3.<init>(r5)
            r0.compareAndSet(r4, r2, r3)
            java.lang.Object r0 = r4._delayed
            if (r0 != 0) goto L_0x0022
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0022:
            kotlinx.coroutines.O$b r0 = (kotlinx.coroutines.C2505O.C2507b) r0
        L_0x0024:
            int r0 = r7.mo35516a(r5, r0, r4)
        L_0x0028:
            if (r0 == 0) goto L_0x0040
            if (r0 == r1) goto L_0x003c
            r5 = 2
            if (r0 != r5) goto L_0x0030
            goto L_0x0060
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "unexpected result"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x003c:
            r4.mo35525a(r5, r7)
            goto L_0x0060
        L_0x0040:
            java.lang.Object r5 = r4._delayed
            kotlinx.coroutines.O$b r5 = (kotlinx.coroutines.C2505O.C2507b) r5
            if (r5 == 0) goto L_0x004d
            kotlinx.coroutines.internal.v r5 = r5.mo35581c()
            r2 = r5
            kotlinx.coroutines.O$a r2 = (kotlinx.coroutines.C2505O.C2506a) r2
        L_0x004d:
            if (r2 != r7) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            if (r1 == 0) goto L_0x0060
            java.lang.Thread r5 = r4.mo35488s()
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r6 == r5) goto L_0x0060
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2505O.mo35512b(long, kotlinx.coroutines.O$a):void");
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        mo35511a(runnable);
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        C2506a aVar;
        C2582q0 q0Var = C2582q0.f4221b;
        C2582q0.m4505b();
        this._isCompleted = 1;
        if (!C2496E.m4305a() || m4343w()) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (f4119d.compareAndSet(this, (Object) null, C2509Q.f4126b)) {
                        break;
                    }
                } else if (obj instanceof C2554k) {
                    ((C2554k) obj).mo35567a();
                    break;
                } else if (obj == C2509Q.f4126b) {
                    break;
                } else {
                    C2554k kVar = new C2554k(8, true);
                    kVar.mo35566a((Runnable) obj);
                    if (f4119d.compareAndSet(this, obj, kVar)) {
                        break;
                    }
                }
            }
            do {
            } while (mo35514u() <= 0);
            long nanoTime = System.nanoTime();
            while (true) {
                C2507b bVar = (C2507b) this._delayed;
                if (bVar != null && (aVar = (C2506a) bVar.mo35582d()) != null) {
                    mo35525a(nanoTime, aVar);
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public boolean mo35513t() {
        if (!mo35508q()) {
            return false;
        }
        C2507b bVar = (C2507b) this._delayed;
        if (bVar != null && !bVar.mo35579b()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            return obj instanceof C2554k ? ((C2554k) obj).mo35569c() : obj == C2509Q.f4126b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0078 A[EDGE_INSN: B:63:0x0078->B:40:0x0078 ?: BREAK  , SYNTHETIC] */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo35514u() {
        /*
            r9 = this;
            boolean r0 = r9.mo35509r()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.O$b r0 = (kotlinx.coroutines.C2505O.C2507b) r0
            r3 = 0
            if (r0 == 0) goto L_0x0044
            boolean r4 = r0.mo35579b()
            if (r4 != 0) goto L_0x0044
            long r4 = java.lang.System.nanoTime()
        L_0x001a:
            monitor-enter(r0)
            kotlinx.coroutines.internal.v r6 = r0.mo35576a()     // Catch:{ all -> 0x0041 }
            if (r6 == 0) goto L_0x003a
            kotlinx.coroutines.O$a r6 = (kotlinx.coroutines.C2505O.C2506a) r6     // Catch:{ all -> 0x0041 }
            boolean r7 = r6.mo35520a((long) r4)     // Catch:{ all -> 0x0041 }
            r8 = 0
            if (r7 == 0) goto L_0x002f
            boolean r6 = r9.m4342b(r6)     // Catch:{ all -> 0x0041 }
            goto L_0x0030
        L_0x002f:
            r6 = 0
        L_0x0030:
            if (r6 == 0) goto L_0x0037
            kotlinx.coroutines.internal.v r6 = r0.mo35577a((int) r8)     // Catch:{ all -> 0x0041 }
            goto L_0x0038
        L_0x0037:
            r6 = r3
        L_0x0038:
            monitor-exit(r0)
            goto L_0x003c
        L_0x003a:
            monitor-exit(r0)
            r6 = r3
        L_0x003c:
            kotlinx.coroutines.O$a r6 = (kotlinx.coroutines.C2505O.C2506a) r6
            if (r6 == 0) goto L_0x0044
            goto L_0x001a
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0044:
            java.lang.Object r0 = r9._queue
            if (r0 != 0) goto L_0x0049
            goto L_0x0078
        L_0x0049:
            boolean r4 = r0 instanceof kotlinx.coroutines.internal.C2554k
            if (r4 == 0) goto L_0x0066
            r4 = r0
            kotlinx.coroutines.internal.k r4 = (kotlinx.coroutines.internal.C2554k) r4
            java.lang.Object r5 = r4.mo35571e()
            kotlinx.coroutines.internal.r r6 = kotlinx.coroutines.internal.C2554k.f4191g
            if (r5 == r6) goto L_0x005c
            r3 = r5
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            goto L_0x0078
        L_0x005c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f4119d
            kotlinx.coroutines.internal.k r4 = r4.mo35570d()
            r5.compareAndSet(r9, r0, r4)
            goto L_0x0044
        L_0x0066:
            kotlinx.coroutines.internal.r r4 = kotlinx.coroutines.C2509Q.f4126b
            if (r0 != r4) goto L_0x006d
            goto L_0x0078
        L_0x006d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f4119d
            boolean r4 = r4.compareAndSet(r9, r0, r3)
            if (r4 == 0) goto L_0x0044
            r3 = r0
            java.lang.Runnable r3 = (java.lang.Runnable) r3
        L_0x0078:
            if (r3 == 0) goto L_0x007e
            r3.run()
            return r1
        L_0x007e:
            long r3 = super.mo35506o()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0087
            goto L_0x00bf
        L_0x0087:
            java.lang.Object r0 = r9._queue
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto L_0x0091
            goto L_0x009e
        L_0x0091:
            boolean r5 = r0 instanceof kotlinx.coroutines.internal.C2554k
            if (r5 == 0) goto L_0x00b8
            kotlinx.coroutines.internal.k r0 = (kotlinx.coroutines.internal.C2554k) r0
            boolean r0 = r0.mo35569c()
            if (r0 != 0) goto L_0x009e
            goto L_0x00bf
        L_0x009e:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.O$b r0 = (kotlinx.coroutines.C2505O.C2507b) r0
            if (r0 == 0) goto L_0x00be
            kotlinx.coroutines.internal.v r0 = r0.mo35581c()
            kotlinx.coroutines.O$a r0 = (kotlinx.coroutines.C2505O.C2506a) r0
            if (r0 == 0) goto L_0x00be
            long r3 = r0.f4123c
            long r5 = java.lang.System.nanoTime()
            long r3 = r3 - r5
            long r1 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((long) r3, (long) r1)
            goto L_0x00bf
        L_0x00b8:
            kotlinx.coroutines.internal.r r5 = kotlinx.coroutines.C2509Q.f4126b
            if (r0 != r5) goto L_0x00bf
        L_0x00be:
            r1 = r3
        L_0x00bf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2505O.mo35514u():long");
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public final void mo35515v() {
        this._queue = null;
        this._delayed = null;
    }
}
