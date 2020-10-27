package p078g.p079a.p080A.p085e.p086a;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1696b;
import p078g.p079a.C1698d;
import p078g.p079a.C1711q;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.a.c */
public final class C1610c extends C1696b {

    /* renamed from: a */
    final C1696b f1884a;

    /* renamed from: b */
    final C1711q f1885b;

    /* renamed from: g.a.A.e.a.c$a */
    static final class C1611a extends AtomicReference<C1727b> implements C1698d, C1727b, Runnable {

        /* renamed from: a */
        final C1698d f1886a;

        /* renamed from: b */
        final C1711q f1887b;

        /* renamed from: c */
        Throwable f1888c;

        C1611a(C1698d dVar, C1711q qVar) {
            this.f1886a = dVar;
            this.f1887b = qVar;
        }

        /* renamed from: a */
        public void mo27361a(C1727b bVar) {
            if (C1588b.m2223c(this, bVar)) {
                this.f1886a.mo27361a(this);
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
            C1588b.m2221a((AtomicReference<C1727b>) this, this.f1887b.mo27406a(this));
        }

        public void onError(Throwable th) {
            this.f1888c = th;
            C1588b.m2221a((AtomicReference<C1727b>) this, this.f1887b.mo27406a(this));
        }

        public void run() {
            Throwable th = this.f1888c;
            if (th != null) {
                this.f1888c = null;
                this.f1886a.onError(th);
                return;
            }
            this.f1886a.onComplete();
        }
    }

    public C1610c(C1696b bVar, C1711q qVar) {
        this.f1884a = bVar;
        this.f1885b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27367b(C1698d dVar) {
        this.f1884a.mo27423a((C1698d) new C1611a(dVar, this.f1885b));
    }
}
