package p009e.p069e.p070a.p071a.p072a;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1706l;
import p078g.p079a.C1710p;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1730a;
import retrofit2.Response;

/* renamed from: e.e.a.a.a.a */
final class C1569a<T> extends C1706l<T> {

    /* renamed from: a */
    private final C1706l<Response<T>> f1834a;

    /* renamed from: e.e.a.a.a.a$a */
    private static class C1570a<R> implements C1710p<Response<R>> {

        /* renamed from: a */
        private final C1710p<? super R> f1835a;

        /* renamed from: b */
        private boolean f1836b;

        C1570a(C1710p<? super R> pVar) {
            this.f1835a = pVar;
        }

        /* renamed from: a */
        public void mo27336a(C1727b bVar) {
            this.f1835a.mo27336a(bVar);
        }

        /* renamed from: a */
        public void mo27337a(Object obj) {
            Response response = (Response) obj;
            if (response.isSuccessful()) {
                this.f1835a.mo27337a(response.body());
                return;
            }
            this.f1836b = true;
            C1573c cVar = new C1573c(response);
            try {
                this.f1835a.onError(cVar);
            } catch (Throwable th) {
                C1532a.m2139a(th);
                C1682a.m2372a((Throwable) new C1730a(cVar, th));
            }
        }

        public void onComplete() {
            if (!this.f1836b) {
                this.f1835a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.f1836b) {
                this.f1835a.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            C1682a.m2372a((Throwable) assertionError);
        }
    }

    C1569a(C1706l<Response<T>> lVar) {
        this.f1834a = lVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super T> pVar) {
        this.f1834a.mo27427a(new C1570a(pVar));
    }
}
