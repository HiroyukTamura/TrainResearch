package p078g.p079a.p096w.p097b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1589c;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.w.b.b */
final class C1723b extends C1711q {

    /* renamed from: a */
    private final Handler f2063a;

    /* renamed from: b */
    private final boolean f2064b;

    /* renamed from: g.a.w.b.b$a */
    private static final class C1724a extends C1711q.C1713b {

        /* renamed from: a */
        private final Handler f2065a;

        /* renamed from: b */
        private final boolean f2066b;

        /* renamed from: c */
        private volatile boolean f2067c;

        C1724a(Handler handler, boolean z) {
            this.f2065a = handler;
            this.f2066b = z;
        }

        /* JADX WARNING: type inference failed for: r3v7, types: [g.a.A.a.c, g.a.x.b] */
        /* JADX WARNING: type inference failed for: r3v8, types: [g.a.A.a.c, g.a.x.b] */
        @SuppressLint({"NewApi"})
        /* renamed from: a */
        public C1727b mo27387a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.f2067c) {
                return C1589c.INSTANCE;
            } else {
                C1599b.m2241a(runnable, "run is null");
                C1725b bVar = new C1725b(this.f2065a, runnable);
                Message obtain = Message.obtain(this.f2065a, bVar);
                obtain.obj = this;
                if (this.f2066b) {
                    obtain.setAsynchronous(true);
                }
                this.f2065a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.f2067c) {
                    return bVar;
                }
                this.f2065a.removeCallbacks(bVar);
                return C1589c.INSTANCE;
            }
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f2067c;
        }

        /* renamed from: b */
        public void mo27341b() {
            this.f2067c = true;
            this.f2065a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: g.a.w.b.b$b */
    private static final class C1725b implements Runnable, C1727b {

        /* renamed from: a */
        private final Handler f2068a;

        /* renamed from: b */
        private final Runnable f2069b;

        /* renamed from: c */
        private volatile boolean f2070c;

        C1725b(Handler handler, Runnable runnable) {
            this.f2068a = handler;
            this.f2069b = runnable;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f2070c;
        }

        /* renamed from: b */
        public void mo27341b() {
            this.f2068a.removeCallbacks(this);
            this.f2070c = true;
        }

        public void run() {
            try {
                this.f2069b.run();
            } catch (Throwable th) {
                C1682a.m2372a(th);
            }
        }
    }

    C1723b(Handler handler, boolean z) {
        this.f2063a = handler;
        this.f2064b = z;
    }

    /* renamed from: a */
    public C1711q.C1713b mo27385a() {
        return new C1724a(this.f2063a, this.f2064b);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public C1727b mo27386a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            C1599b.m2241a(runnable, "run is null");
            C1725b bVar = new C1725b(this.f2063a, runnable);
            Message obtain = Message.obtain(this.f2063a, bVar);
            if (this.f2064b) {
                obtain.setAsynchronous(true);
            }
            this.f2063a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return bVar;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
