package p042j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\"\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\b¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo21739d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: j.b */
public class C2062b extends C2057A {
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final long f2879h = TimeUnit.SECONDS.toMillis(60);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final long f2880i = TimeUnit.MILLISECONDS.toNanos(f2879h);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static C2062b f2881j;

    /* renamed from: k */
    public static final C2063a f2882k = new C2063a((DefaultConstructorMarker) null);

    /* renamed from: e */
    private boolean f2883e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2062b f2884f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f2885g;

    /* renamed from: j.b$a */
    public static final class C2063a {
        public /* synthetic */ C2063a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r10 != null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
            kotlin.jvm.internal.Intrinsics.throwNpe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
            if (p042j.C2062b.m3461a(r10) == null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
            r3 = p042j.C2062b.m3461a(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
            if (r3 != null) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
            kotlin.jvm.internal.Intrinsics.throwNpe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
            if (r8 >= p042j.C2062b.m3460a(r3, r1)) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
            r10 = p042j.C2062b.m3461a(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
            if (r10 != null) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
            p042j.C2062b.m3462a(r7, p042j.C2062b.m3461a(r10));
            p042j.C2062b.m3462a(r10, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x007b, code lost:
            if (r10 != p042j.C2062b.m3465j()) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007d, code lost:
            r0.notify();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
            r7 = kotlin.Unit.INSTANCE;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m3473a(p042j.C2062b r7, long r8, boolean r10) {
            /*
                r6 = this;
                java.lang.Class<j.b> r0 = p042j.C2062b.class
                monitor-enter(r0)
                j.b r1 = p042j.C2062b.f2881j     // Catch:{ all -> 0x008a }
                if (r1 != 0) goto L_0x0019
                j.b r1 = new j.b     // Catch:{ all -> 0x008a }
                r1.<init>()     // Catch:{ all -> 0x008a }
                p042j.C2062b.f2881j = r1     // Catch:{ all -> 0x008a }
                j.b$b r1 = new j.b$b     // Catch:{ all -> 0x008a }
                r1.<init>()     // Catch:{ all -> 0x008a }
                r1.start()     // Catch:{ all -> 0x008a }
            L_0x0019:
                long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x008a }
                r3 = 0
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0033
                if (r10 == 0) goto L_0x0033
                long r3 = r7.mo29122c()     // Catch:{ all -> 0x008a }
                long r3 = r3 - r1
                long r8 = java.lang.Math.min(r8, r3)     // Catch:{ all -> 0x008a }
            L_0x002e:
                long r8 = r8 + r1
                r7.f2885g = r8     // Catch:{ all -> 0x008a }
                goto L_0x0041
            L_0x0033:
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0038
                goto L_0x002e
            L_0x0038:
                if (r10 == 0) goto L_0x0084
                long r8 = r7.mo29122c()     // Catch:{ all -> 0x008a }
                r7.f2885g = r8     // Catch:{ all -> 0x008a }
            L_0x0041:
                long r8 = p042j.C2062b.m3460a((p042j.C2062b) r7, (long) r1)     // Catch:{ all -> 0x008a }
                j.b r10 = p042j.C2062b.f2881j     // Catch:{ all -> 0x008a }
                if (r10 != 0) goto L_0x004e
            L_0x004b:
                kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x008a }
            L_0x004e:
                j.b r3 = r10.f2884f     // Catch:{ all -> 0x008a }
                if (r3 == 0) goto L_0x006d
                j.b r3 = r10.f2884f     // Catch:{ all -> 0x008a }
                if (r3 != 0) goto L_0x005d
                kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x008a }
            L_0x005d:
                long r3 = p042j.C2062b.m3460a((p042j.C2062b) r3, (long) r1)     // Catch:{ all -> 0x008a }
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 >= 0) goto L_0x0066
                goto L_0x006d
            L_0x0066:
                j.b r10 = r10.f2884f     // Catch:{ all -> 0x008a }
                if (r10 != 0) goto L_0x004e
                goto L_0x004b
            L_0x006d:
                j.b r8 = r10.f2884f     // Catch:{ all -> 0x008a }
                r7.f2884f = r8     // Catch:{ all -> 0x008a }
                r10.f2884f = r7     // Catch:{ all -> 0x008a }
                j.b r7 = p042j.C2062b.f2881j     // Catch:{ all -> 0x008a }
                if (r10 != r7) goto L_0x0080
                r0.notify()     // Catch:{ all -> 0x008a }
            L_0x0080:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008a }
                monitor-exit(r0)
                return
            L_0x0084:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x008a }
                r7.<init>()     // Catch:{ all -> 0x008a }
                throw r7     // Catch:{ all -> 0x008a }
            L_0x008a:
                r7 = move-exception
                monitor-exit(r0)
                goto L_0x008e
            L_0x008d:
                throw r7
            L_0x008e:
                goto L_0x008d
            */
            throw new UnsupportedOperationException("Method not decompiled: p042j.C2062b.C2063a.m3473a(j.b, long, boolean):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final boolean m3475a(C2062b bVar) {
            boolean z;
            synchronized (C2062b.class) {
                C2062b j = C2062b.f2881j;
                while (true) {
                    if (j == null) {
                        z = true;
                        break;
                    } else if (j.f2884f == bVar) {
                        j.f2884f = bVar.f2884f;
                        bVar.f2884f = null;
                        z = false;
                        break;
                    } else {
                        j = j.f2884f;
                    }
                }
            }
            return z;
        }

        /* renamed from: a */
        public final C2062b mo29128a() throws InterruptedException {
            Class<C2062b> cls = C2062b.class;
            C2062b j = C2062b.f2881j;
            if (j == null) {
                Intrinsics.throwNpe();
            }
            C2062b a = j.f2884f;
            long nanoTime = System.nanoTime();
            if (a == null) {
                cls.wait(C2062b.f2879h);
                C2062b j2 = C2062b.f2881j;
                if (j2 == null) {
                    Intrinsics.throwNpe();
                }
                if (j2.f2884f != null || System.nanoTime() - nanoTime < C2062b.f2880i) {
                    return null;
                }
                return C2062b.f2881j;
            }
            long a2 = C2062b.m3460a(a, nanoTime);
            if (a2 > 0) {
                long j3 = a2 / 1000000;
                cls.wait(j3, (int) (a2 - (1000000 * j3)));
                return null;
            }
            C2062b j4 = C2062b.f2881j;
            if (j4 == null) {
                Intrinsics.throwNpe();
            }
            j4.f2884f = a.f2884f;
            a.f2884f = null;
            return a;
        }
    }

    /* renamed from: j.b$b */
    private static final class C2064b extends Thread {
        public C2064b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
            if (r1 == null) goto L_0x0000;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
            r1.mo27739i();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<j.b> r0 = p042j.C2062b.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                j.b$a r1 = p042j.C2062b.f2882k     // Catch:{ all -> 0x001e }
                j.b r1 = r1.mo29128a()     // Catch:{ all -> 0x001e }
                j.b r2 = p042j.C2062b.f2881j     // Catch:{ all -> 0x001e }
                if (r1 != r2) goto L_0x0015
                r1 = 0
                p042j.C2062b.f2881j = r1     // Catch:{ all -> 0x001e }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x0015:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001e }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                if (r1 == 0) goto L_0x0000
                r1.mo27739i()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x001e:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0022
            L_0x0021:
                throw r1
            L_0x0022:
                goto L_0x0021
            */
            throw new UnsupportedOperationException("Method not decompiled: p042j.C2062b.C2064b.run():void");
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ long m3460a(C2062b bVar, long j) {
        return bVar.f2885g - j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public IOException mo27919a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: g */
    public final void mo29126g() {
        if (!this.f2883e) {
            long f = mo29125f();
            boolean d = mo29123d();
            if (f != 0 || d) {
                this.f2883e = true;
                f2882k.m3473a(this, f, d);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    /* renamed from: h */
    public final boolean mo29127h() {
        if (!this.f2883e) {
            return false;
        }
        this.f2883e = false;
        return f2882k.m3475a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo27739i() {
    }
}
