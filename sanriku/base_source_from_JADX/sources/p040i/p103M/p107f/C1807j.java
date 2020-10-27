package p040i.p103M.p107f;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1760K;
import p040i.C1912a;
import p040i.p103M.C1764b;
import p040i.p103M.p106e.C1784a;
import p040i.p103M.p106e.C1787d;
import p040i.p103M.p106e.C1788e;
import p040i.p103M.p107f.C1799e;
import p040i.p103M.p112k.C1890h;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, mo21739d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "callAcquirePooledConnection", "", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "routes", "", "Lokhttp3/Route;", "requireMultiplexed", "cleanup", "now", "connectionBecameIdle", "connection", "connectionCount", "evictAll", "", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.f.j */
public final class C1807j {

    /* renamed from: a */
    private final long f2397a;

    /* renamed from: b */
    private final C1787d f2398b;

    /* renamed from: c */
    private final C1808a f2399c = new C1808a(this, C0681a.m324a(new StringBuilder(), C1764b.f2220h, " ConnectionPool"));

    /* renamed from: d */
    private final ArrayDeque<C1806i> f2400d = new ArrayDeque<>();

    /* renamed from: e */
    private final int f2401e;

    /* renamed from: i.M.f.j$a */
    public static final class C1808a extends C1784a {

        /* renamed from: e */
        final /* synthetic */ C1807j f2402e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1808a(C1807j jVar, String str) {
            super(str, true);
            this.f2402e = jVar;
        }

        /* renamed from: e */
        public long mo27646e() {
            return this.f2402e.mo27765a(System.nanoTime());
        }
    }

    public C1807j(C1788e eVar, int i, long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.f2401e = i;
        this.f2397a = timeUnit.toNanos(j);
        this.f2398b = eVar.mo27675d();
        if (!(j > 0)) {
            throw new IllegalArgumentException(C0681a.m318a("keepAliveDuration <= 0: ", j).toString());
        }
    }

    /* renamed from: a */
    private final int m2839a(C1806i iVar, long j) {
        List<Reference<C1799e>> c = iVar.mo27753c();
        int i = 0;
        while (i < c.size()) {
            Reference reference = c.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder a = C0681a.m330a("A connection to ");
                a.append(iVar.mo27762l().mo27588a().mo28020k());
                a.append(" was leaked. ");
                a.append("Did you forget to close a response body?");
                String sb = a.toString();
                C1890h.C1891a aVar = C1890h.f2683c;
                C1890h.f2681a.mo27969a(sb, ((C1799e.C1801b) reference).mo27738a());
                c.remove(i);
                iVar.mo27752b(true);
                if (c.isEmpty()) {
                    iVar.mo27744a(j - this.f2397a);
                    return 0;
                }
            }
        }
        return c.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r3 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        kotlin.jvm.internal.Intrinsics.throwNpe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006d, code lost:
        p040i.p103M.C1764b.m2630a(r3.mo27763m());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0076, code lost:
        return 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo27765a(long r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.util.ArrayDeque<i.M.f.i> r0 = r10.f2400d     // Catch:{ all -> 0x0077 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0077 }
            r1 = 0
            r2 = 0
            r3 = -9223372036854775808
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x000e:
            boolean r6 = r0.hasNext()     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x0037
            java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x0077 }
            i.M.f.i r6 = (p040i.p103M.p107f.C1806i) r6     // Catch:{ all -> 0x0077 }
            java.lang.String r7 = "connection"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)     // Catch:{ all -> 0x0077 }
            int r7 = r10.m2839a(r6, r11)     // Catch:{ all -> 0x0077 }
            if (r7 <= 0) goto L_0x0028
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0028:
            int r1 = r1 + 1
            long r7 = r6.mo27754d()     // Catch:{ all -> 0x0077 }
            long r7 = r11 - r7
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x000e
            r3 = r6
            r4 = r7
            goto L_0x000e
        L_0x0037:
            long r11 = r10.f2397a     // Catch:{ all -> 0x0077 }
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x0053
            int r11 = r10.f2401e     // Catch:{ all -> 0x0077 }
            if (r1 <= r11) goto L_0x0042
            goto L_0x0053
        L_0x0042:
            if (r1 <= 0) goto L_0x0049
            long r11 = r10.f2397a     // Catch:{ all -> 0x0077 }
            long r11 = r11 - r4
            monitor-exit(r10)
            return r11
        L_0x0049:
            if (r2 <= 0) goto L_0x004f
            long r11 = r10.f2397a     // Catch:{ all -> 0x0077 }
            monitor-exit(r10)
            return r11
        L_0x004f:
            r11 = -1
            monitor-exit(r10)
            return r11
        L_0x0053:
            java.util.ArrayDeque<i.M.f.i> r11 = r10.f2400d     // Catch:{ all -> 0x0077 }
            r11.remove(r3)     // Catch:{ all -> 0x0077 }
            java.util.ArrayDeque<i.M.f.i> r11 = r10.f2400d     // Catch:{ all -> 0x0077 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x0077 }
            if (r11 == 0) goto L_0x0065
            i.M.e.d r11 = r10.f2398b     // Catch:{ all -> 0x0077 }
            r11.mo27657a()     // Catch:{ all -> 0x0077 }
        L_0x0065:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0077 }
            monitor-exit(r10)
            if (r3 != 0) goto L_0x006d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x006d:
            java.net.Socket r11 = r3.mo27763m()
            p040i.p103M.C1764b.m2630a((java.net.Socket) r11)
            r11 = 0
            return r11
        L_0x0077:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x007b
        L_0x007a:
            throw r11
        L_0x007b:
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p107f.C1807j.mo27765a(long):long");
    }

    /* renamed from: a */
    public final boolean mo27766a(C1806i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "connection");
        if (C1764b.f2219g && !Thread.holdsLock(this)) {
            StringBuilder a = C0681a.m330a("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            a.append(currentThread.getName());
            a.append(" MUST hold lock on ");
            a.append(this);
            throw new AssertionError(a.toString());
        } else if (iVar.mo27755e() || this.f2401e == 0) {
            this.f2400d.remove(iVar);
            if (this.f2400d.isEmpty()) {
                this.f2398b.mo27657a();
            }
            return true;
        } else {
            C1787d.m2722a(this.f2398b, this.f2399c, 0, 2);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo27767a(C1912a aVar, C1799e eVar, List<C1760K> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(aVar, "address");
        Intrinsics.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        if (!C1764b.f2219g || Thread.holdsLock(this)) {
            Iterator<C1806i> it = this.f2400d.iterator();
            while (it.hasNext()) {
                C1806i next = it.next();
                if ((!z || next.mo27759i()) && next.mo27749a(aVar, list)) {
                    Intrinsics.checkExpressionValueIsNotNull(next, "connection");
                    eVar.mo27714a(next);
                    return true;
                }
            }
            return false;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    /* renamed from: b */
    public final void mo27768b(C1806i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "connection");
        if (!C1764b.f2219g || Thread.holdsLock(this)) {
            this.f2400d.add(iVar);
            C1787d.m2722a(this.f2398b, this.f2399c, 0, 2);
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }
}
