package p078g.p079a.p096w;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.w.a */
public abstract class C1719a implements C1727b {

    /* renamed from: a */
    private final AtomicBoolean f2059a = new AtomicBoolean();

    /* renamed from: g.a.w.a$a */
    class C1720a implements Runnable {
        C1720a() {
        }

        public void run() {
            C1719a.this.mo27345c();
        }
    }

    /* renamed from: a */
    public final boolean mo27340a() {
        return this.f2059a.get();
    }

    /* renamed from: b */
    public final void mo27341b() {
        if (!this.f2059a.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mo27345c();
        } else {
            C1721a.m2428a().mo27406a(new C1720a());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo27345c();
}
