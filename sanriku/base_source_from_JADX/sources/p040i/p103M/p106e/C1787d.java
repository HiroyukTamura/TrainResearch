package p040i.p103M.p106e;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;

/* renamed from: i.M.e.d */
public final class C1787d {

    /* renamed from: a */
    private boolean f2302a;

    /* renamed from: b */
    private C1784a f2303b;

    /* renamed from: c */
    private final List<C1784a> f2304c = new ArrayList();

    /* renamed from: d */
    private boolean f2305d;

    /* renamed from: e */
    private final C1788e f2306e;

    /* renamed from: f */
    private final String f2307f;

    public C1787d(C1788e eVar, String str) {
        Intrinsics.checkParameterIsNotNull(eVar, "taskRunner");
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.f2306e = eVar;
        this.f2307f = str;
    }

    /* renamed from: a */
    public static /* synthetic */ void m2722a(C1787d dVar, C1784a aVar, long j, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        dVar.mo27659a(aVar, j);
    }

    /* renamed from: a */
    public final void mo27657a() {
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            synchronized (this.f2306e) {
                if (mo27662b()) {
                    this.f2306e.mo27672a(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    /* renamed from: a */
    public final void mo27658a(C1784a aVar) {
        this.f2303b = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27659a(p040i.p103M.p106e.C1784a r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            i.M.e.e r0 = r2.f2306e
            monitor-enter(r0)
            boolean r1 = r2.f2302a     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0047
            boolean r4 = r3.mo27652a()     // Catch:{ all -> 0x0057 }
            r5 = 0
            if (r4 == 0) goto L_0x002b
            i.M.e.e$b r4 = p040i.p103M.p106e.C1788e.f2310j     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x002a
            java.util.logging.Logger r4 = p040i.p103M.p106e.C1788e.f2309i     // Catch:{ all -> 0x0057 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0057 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0028
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            p040i.p103M.p106e.C1785b.m2720a(r3, r2, r4)     // Catch:{ all -> 0x0057 }
        L_0x0028:
            monitor-exit(r0)
            return
        L_0x002a:
            throw r5     // Catch:{ all -> 0x0057 }
        L_0x002b:
            i.M.e.e$b r4 = p040i.p103M.p106e.C1788e.f2310j     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0046
            java.util.logging.Logger r4 = p040i.p103M.p106e.C1788e.f2309i     // Catch:{ all -> 0x0057 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0057 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0040
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            p040i.p103M.p106e.C1785b.m2720a(r3, r2, r4)     // Catch:{ all -> 0x0057 }
        L_0x0040:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0046:
            throw r5     // Catch:{ all -> 0x0057 }
        L_0x0047:
            r1 = 0
            boolean r3 = r2.mo27661a(r3, r4, r1)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0053
            i.M.e.e r3 = r2.f2306e     // Catch:{ all -> 0x0057 }
            r3.mo27672a((p040i.p103M.p106e.C1787d) r2)     // Catch:{ all -> 0x0057 }
        L_0x0053:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0057 }
            monitor-exit(r0)
            return
        L_0x0057:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p106e.C1787d.mo27659a(i.M.e.a, long):void");
    }

    /* renamed from: a */
    public final void mo27660a(boolean z) {
        this.f2305d = z;
    }

    /* renamed from: b */
    public final boolean mo27662b() {
        C1784a aVar = this.f2303b;
        if (aVar != null) {
            if (aVar == null) {
                Intrinsics.throwNpe();
            }
            if (aVar.mo27652a()) {
                this.f2305d = true;
            }
        }
        boolean z = false;
        for (int size = this.f2304c.size() - 1; size >= 0; size--) {
            if (this.f2304c.get(size).mo27652a()) {
                C1784a aVar2 = this.f2304c.get(size);
                if (C1788e.f2310j != null) {
                    if (C1788e.f2309i.isLoggable(Level.FINE)) {
                        C1785b.m2720a(aVar2, this, "canceled");
                    }
                    this.f2304c.remove(size);
                    z = true;
                } else {
                    throw null;
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    public final C1784a mo27663c() {
        return this.f2303b;
    }

    /* renamed from: d */
    public final boolean mo27664d() {
        return this.f2305d;
    }

    /* renamed from: e */
    public final List<C1784a> mo27665e() {
        return this.f2304c;
    }

    /* renamed from: f */
    public final String mo27666f() {
        return this.f2307f;
    }

    /* renamed from: g */
    public final boolean mo27667g() {
        return this.f2302a;
    }

    /* renamed from: h */
    public final C1788e mo27668h() {
        return this.f2306e;
    }

    /* renamed from: i */
    public final void mo27669i() {
        if (!C1764b.f2219g || !Thread.holdsLock(this)) {
            synchronized (this.f2306e) {
                this.f2302a = true;
                if (mo27662b()) {
                    this.f2306e.mo27672a(this);
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        StringBuilder a = C0681a.m330a("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        a.append(currentThread.getName());
        a.append(" MUST NOT hold lock on ");
        a.append(this);
        throw new AssertionError(a.toString());
    }

    public String toString() {
        return this.f2307f;
    }

    /* renamed from: a */
    public final boolean mo27661a(C1784a aVar, long j, boolean z) {
        StringBuilder sb;
        String str;
        Intrinsics.checkParameterIsNotNull(aVar, "task");
        aVar.mo27651a(this);
        long nanoTime = this.f2306e.mo27674c().nanoTime();
        long j2 = nanoTime + j;
        int indexOf = this.f2304c.indexOf(aVar);
        if (indexOf != -1) {
            if (aVar.mo27654c() > j2) {
                this.f2304c.remove(indexOf);
            } else if (C1788e.f2310j != null) {
                if (C1788e.f2309i.isLoggable(Level.FINE)) {
                    C1785b.m2720a(aVar, this, "already scheduled");
                }
                return false;
            } else {
                throw null;
            }
        }
        aVar.mo27650a(j2);
        if (C1788e.f2310j != null) {
            if (C1788e.f2309i.isLoggable(Level.FINE)) {
                if (z) {
                    sb = new StringBuilder();
                    str = "run again after ";
                } else {
                    sb = new StringBuilder();
                    str = "scheduled after ";
                }
                sb.append(str);
                sb.append(C1785b.m2719a(j2 - nanoTime));
                C1785b.m2720a(aVar, this, sb.toString());
            }
            Iterator<C1784a> it = this.f2304c.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (it.next().mo27654c() - nanoTime > j) {
                    break;
                }
                i++;
            }
            if (i == -1) {
                i = this.f2304c.size();
            }
            this.f2304c.add(i, aVar);
            if (i == 0) {
                return true;
            }
            return false;
        }
        throw null;
    }
}
