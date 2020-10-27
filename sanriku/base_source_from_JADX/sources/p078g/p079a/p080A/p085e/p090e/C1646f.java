package p078g.p079a.p080A.p085e.p090e;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1711q;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.C1718v;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.e.f */
public final class C1646f<T> extends C1714r<T> {

    /* renamed from: a */
    final C1718v<T> f1934a;

    /* renamed from: b */
    final C1711q f1935b;

    /* renamed from: g.a.A.e.e.f$a */
    static final class C1647a<T> extends AtomicReference<C1727b> implements C1716t<T>, C1727b, Runnable {

        /* renamed from: a */
        final C1716t<? super T> f1936a;

        /* renamed from: b */
        final C1711q f1937b;

        /* renamed from: c */
        T f1938c;

        /* renamed from: d */
        Throwable f1939d;

        C1647a(C1716t<? super T> tVar, C1711q qVar) {
            this.f1936a = tVar;
            this.f1937b = qVar;
        }

        /* renamed from: a */
        public void mo27364a(C1727b bVar) {
            if (C1588b.m2223c(this, bVar)) {
                this.f1936a.mo27364a(this);
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

        public void onError(Throwable th) {
            this.f1939d = th;
            C1588b.m2221a((AtomicReference<C1727b>) this, this.f1937b.mo27406a(this));
        }

        public void onSuccess(T t) {
            this.f1938c = t;
            C1588b.m2221a((AtomicReference<C1727b>) this, this.f1937b.mo27406a(this));
        }

        public void run() {
            Throwable th = this.f1939d;
            if (th != null) {
                this.f1936a.onError(th);
            } else {
                this.f1936a.onSuccess(this.f1938c);
            }
        }
    }

    public C1646f(C1718v<T> vVar, C1711q qVar) {
        this.f1934a = vVar;
        this.f1935b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super T> tVar) {
        this.f1934a.mo27433a(new C1647a(tVar, this.f1935b));
    }
}
