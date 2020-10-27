package p078g.p079a.p080A.p085e.p090e;

import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1714r;
import p078g.p079a.C1715s;
import p078g.p079a.C1716t;
import p078g.p079a.C1717u;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.e.a */
public final class C1637a<T> extends C1714r<T> {

    /* renamed from: a */
    final C1717u<T> f1920a;

    /* renamed from: g.a.A.e.e.a$a */
    static final class C1638a<T> extends AtomicReference<C1727b> implements C1715s<T>, C1727b {

        /* renamed from: a */
        final C1716t<? super T> f1921a;

        C1638a(C1716t<? super T> tVar) {
            this.f1921a = tVar;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a((AtomicReference<C1727b>) this);
        }

        public void onError(Throwable th) {
            boolean z;
            C1727b bVar;
            Throwable nullPointerException = th == null ? new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.") : th;
            Object obj = get();
            C1588b bVar2 = C1588b.DISPOSED;
            if (obj == bVar2 || (bVar = (C1727b) getAndSet(bVar2)) == C1588b.DISPOSED) {
                z = false;
            } else {
                try {
                    this.f1921a.onError(nullPointerException);
                    z = true;
                } finally {
                    if (bVar != null) {
                        bVar.mo27341b();
                    }
                }
            }
            if (!z) {
                C1682a.m2372a(th);
            }
        }

        public void onSuccess(T t) {
            C1727b bVar;
            Object obj = get();
            C1588b bVar2 = C1588b.DISPOSED;
            if (obj != bVar2 && (bVar = (C1727b) getAndSet(bVar2)) != C1588b.DISPOSED) {
                if (t == null) {
                    try {
                        this.f1921a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                    } catch (Throwable th) {
                        if (bVar != null) {
                            bVar.mo27341b();
                        }
                        throw th;
                    }
                } else {
                    this.f1921a.onSuccess(t);
                }
                if (bVar != null) {
                    bVar.mo27341b();
                }
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{C1638a.class.getSimpleName(), super.toString()});
        }
    }

    public C1637a(C1717u<T> uVar) {
        this.f1920a = uVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super T> tVar) {
        C1638a aVar = new C1638a(tVar);
        tVar.mo27364a(aVar);
        try {
            this.f1920a.subscribe(aVar);
        } catch (Throwable th) {
            C1532a.m2139a(th);
            aVar.onError(th);
        }
    }
}
