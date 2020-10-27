package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: kotlinx.coroutines.internal.j */
public class C2553j<E> {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f4188a = AtomicReferenceFieldUpdater.newUpdater(C2553j.class, Object.class, "_cur");
    private volatile Object _cur;

    public C2553j(boolean z) {
        this._cur = new C2554k(8, z);
    }

    /* renamed from: a */
    public final void mo35562a() {
        while (true) {
            C2554k kVar = (C2554k) this._cur;
            if (!kVar.mo35567a()) {
                f4188a.compareAndSet(this, kVar, kVar.mo35570d());
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo35563a(E e) {
        while (true) {
            C2554k kVar = (C2554k) this._cur;
            int a = kVar.mo35566a(e);
            if (a == 0) {
                return true;
            }
            if (a == 1) {
                f4188a.compareAndSet(this, kVar, kVar.mo35570d());
            } else if (a == 2) {
                return false;
            }
        }
    }

    /* renamed from: b */
    public final int mo35564b() {
        return ((C2554k) this._cur).mo35568b();
    }

    /* renamed from: c */
    public final E mo35565c() {
        while (true) {
            C2554k kVar = (C2554k) this._cur;
            E e = kVar.mo35571e();
            if (e != C2554k.f4191g) {
                return e;
            }
            f4188a.compareAndSet(this, kVar, kVar.mo35570d());
        }
    }
}
