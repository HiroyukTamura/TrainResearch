package p078g.p079a.p080A.p085e.p089d;

import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1706l;
import p078g.p079a.C1707m;
import p078g.p079a.C1708n;
import p078g.p079a.C1710p;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.d.b */
public final class C1623b<T> extends C1706l<T> {

    /* renamed from: a */
    final C1708n<T> f1895a;

    /* renamed from: g.a.A.e.d.b$a */
    static final class C1624a<T> extends AtomicReference<C1727b> implements C1707m<T>, C1727b {

        /* renamed from: a */
        final C1710p<? super T> f1896a;

        C1624a(C1710p<? super T> pVar) {
            this.f1896a = pVar;
        }

        /* renamed from: a */
        public void mo27372a(C1727b bVar) {
            C1588b.m2222b(this, bVar);
        }

        /* renamed from: a */
        public void mo27373a(T t) {
            if (t == null) {
                mo27374a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!mo27340a()) {
                this.f1896a.mo27337a(t);
            }
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public void mo27374a(Throwable th) {
            boolean z;
            Throwable nullPointerException = th == null ? new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.") : th;
            if (!mo27340a()) {
                try {
                    this.f1896a.onError(nullPointerException);
                    C1588b.m2220a((AtomicReference<C1727b>) this);
                    z = true;
                } catch (Throwable th2) {
                    C1588b.m2220a((AtomicReference<C1727b>) this);
                    throw th2;
                }
            } else {
                z = false;
            }
            if (!z) {
                C1682a.m2372a(th);
            }
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a((AtomicReference<C1727b>) this);
        }

        public void onComplete() {
            if (!mo27340a()) {
                try {
                    this.f1896a.onComplete();
                } finally {
                    C1588b.m2220a((AtomicReference<C1727b>) this);
                }
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{C1624a.class.getSimpleName(), super.toString()});
        }
    }

    public C1623b(C1708n<T> nVar) {
        this.f1895a = nVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super T> pVar) {
        C1624a aVar = new C1624a(pVar);
        pVar.mo27336a((C1727b) aVar);
        try {
            this.f1895a.subscribe(aVar);
        } catch (Throwable th) {
            C1532a.m2139a(th);
            aVar.mo27374a(th);
        }
    }
}
