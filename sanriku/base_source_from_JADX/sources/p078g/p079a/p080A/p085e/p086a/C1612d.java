package p078g.p079a.p080A.p085e.p086a;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1696b;
import p078g.p079a.C1698d;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p080A.p081a.C1591e;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.a.d */
public final class C1612d extends C1696b {

    /* renamed from: a */
    final C1696b f1889a;

    /* renamed from: b */
    final C1711q f1890b;

    /* renamed from: g.a.A.e.a.d$a */
    static final class C1613a extends AtomicReference<C1727b> implements C1698d, C1727b, Runnable {

        /* renamed from: a */
        final C1698d f1891a;

        /* renamed from: b */
        final C1591e f1892b = new C1591e();

        /* renamed from: c */
        final C1696b f1893c;

        C1613a(C1698d dVar, C1696b bVar) {
            this.f1891a = dVar;
            this.f1893c = bVar;
        }

        /* renamed from: a */
        public void mo27361a(C1727b bVar) {
            C1588b.m2223c(this, bVar);
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a((AtomicReference<C1727b>) this);
            this.f1892b.mo27341b();
        }

        public void onComplete() {
            this.f1891a.onComplete();
        }

        public void onError(Throwable th) {
            this.f1891a.onError(th);
        }

        public void run() {
            this.f1893c.mo27423a((C1698d) this);
        }
    }

    public C1612d(C1696b bVar, C1711q qVar) {
        this.f1889a = bVar;
        this.f1890b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27367b(C1698d dVar) {
        C1613a aVar = new C1613a(dVar, this.f1889a);
        dVar.mo27361a(aVar);
        C1727b a = this.f1890b.mo27406a(aVar);
        C1591e eVar = aVar.f1892b;
        if (eVar != null) {
            C1588b.m2221a((AtomicReference<C1727b>) eVar, a);
            return;
        }
        throw null;
    }
}
