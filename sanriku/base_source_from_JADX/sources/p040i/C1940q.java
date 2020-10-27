package p040i;

import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1799e;

/* renamed from: i.q */
public final class C1940q {

    /* renamed from: a */
    private int f2827a = 64;

    /* renamed from: b */
    private int f2828b = 5;

    /* renamed from: c */
    private ExecutorService f2829c;

    /* renamed from: d */
    private final ArrayDeque<C1799e.C1800a> f2830d = new ArrayDeque<>();

    /* renamed from: e */
    private final ArrayDeque<C1799e.C1800a> f2831e = new ArrayDeque<>();

    /* renamed from: f */
    private final ArrayDeque<C1799e> f2832f = new ArrayDeque<>();

    /* renamed from: a */
    private final <T> void m3347a(Deque<T> deque, T t) {
        synchronized (this) {
            if (deque.remove(t)) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        boolean c = m3348c();
    }

    /* renamed from: c */
    private final boolean m3348c() {
        int i;
        boolean z;
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<C1799e.C1800a> it = this.f2830d.iterator();
                Intrinsics.checkExpressionValueIsNotNull(it, "readyAsyncCalls.iterator()");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1799e.C1800a next = it.next();
                    if (this.f2831e.size() >= this.f2827a) {
                        break;
                    } else if (next.mo27735b().get() < this.f2828b) {
                        it.remove();
                        next.mo27735b().incrementAndGet();
                        Intrinsics.checkExpressionValueIsNotNull(next, "asyncCall");
                        arrayList.add(next);
                        this.f2831e.add(next);
                    }
                }
                z = mo28097b() > 0;
                Unit unit = Unit.INSTANCE;
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((C1799e.C1800a) arrayList.get(i)).mo27734a(mo28094a());
            }
            return z;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    @JvmName(name = "executorService")
    /* renamed from: a */
    public final synchronized ExecutorService mo28094a() {
        ExecutorService executorService;
        if (this.f2829c == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            this.f2829c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, timeUnit, synchronousQueue, C1764b.m2626a(C1764b.f2220h + " Dispatcher", false));
        }
        executorService = this.f2829c;
        if (executorService == null) {
            Intrinsics.throwNpe();
        }
        return executorService;
    }

    /* renamed from: a */
    public final void mo28095a(C1799e.C1800a aVar) {
        C1799e.C1800a aVar2;
        Intrinsics.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        synchronized (this) {
            this.f2830d.add(aVar);
            if (!aVar.mo27732a().mo27718c()) {
                String c = aVar.mo27736c();
                Iterator<C1799e.C1800a> it = this.f2831e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<C1799e.C1800a> it2 = this.f2830d.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                aVar2 = null;
                                break;
                            }
                            aVar2 = it2.next();
                            if (Intrinsics.areEqual((Object) aVar2.mo27736c(), (Object) c)) {
                                break;
                            }
                        }
                    } else {
                        aVar2 = it.next();
                        if (Intrinsics.areEqual((Object) aVar2.mo27736c(), (Object) c)) {
                            break;
                        }
                    }
                }
                if (aVar2 != null) {
                    aVar.mo27733a(aVar2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        m3348c();
    }

    /* renamed from: a */
    public final synchronized void mo28096a(C1799e eVar) {
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        this.f2832f.add(eVar);
    }

    /* renamed from: b */
    public final synchronized int mo28097b() {
        return this.f2831e.size() + this.f2832f.size();
    }

    /* renamed from: b */
    public final void mo28098b(C1799e.C1800a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        aVar.mo27735b().decrementAndGet();
        m3347a(this.f2831e, aVar);
    }

    /* renamed from: b */
    public final void mo28099b(C1799e eVar) {
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        m3347a(this.f2832f, eVar);
    }
}
