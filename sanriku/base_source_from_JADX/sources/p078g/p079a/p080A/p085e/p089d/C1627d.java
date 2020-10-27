package p078g.p079a.p080A.p085e.p089d;

import p078g.p079a.C1696b;
import p078g.p079a.C1698d;
import p078g.p079a.C1706l;
import p078g.p079a.C1709o;
import p078g.p079a.C1710p;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.d.d */
public final class C1627d<T> extends C1696b {

    /* renamed from: a */
    final C1709o<T> f1903a;

    /* renamed from: g.a.A.e.d.d$a */
    static final class C1628a<T> implements C1710p<T>, C1727b {

        /* renamed from: a */
        final C1698d f1904a;

        /* renamed from: b */
        C1727b f1905b;

        C1628a(C1698d dVar) {
            this.f1904a = dVar;
        }

        /* renamed from: a */
        public void mo27336a(C1727b bVar) {
            this.f1905b = bVar;
            this.f1904a.mo27361a(this);
        }

        /* renamed from: a */
        public void mo27337a(T t) {
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f1905b.mo27340a();
        }

        /* renamed from: b */
        public void mo27341b() {
            this.f1905b.mo27341b();
        }

        public void onComplete() {
            this.f1904a.onComplete();
        }

        public void onError(Throwable th) {
            this.f1904a.onError(th);
        }
    }

    public C1627d(C1709o<T> oVar) {
        this.f1903a = oVar;
    }

    /* renamed from: b */
    public void mo27367b(C1698d dVar) {
        ((C1706l) this.f1903a).mo27427a(new C1628a(dVar));
    }
}
