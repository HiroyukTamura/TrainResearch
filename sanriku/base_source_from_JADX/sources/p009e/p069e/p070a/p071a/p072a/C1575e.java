package p009e.p069e.p070a.p071a.p072a;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1706l;
import p078g.p079a.C1710p;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1730a;
import retrofit2.Response;

/* renamed from: e.e.a.a.a.e */
final class C1575e<T> extends C1706l<C1574d<T>> {

    /* renamed from: a */
    private final C1706l<Response<T>> f1839a;

    /* renamed from: e.e.a.a.a.e$a */
    private static class C1576a<R> implements C1710p<Response<R>> {

        /* renamed from: a */
        private final C1710p<? super C1574d<R>> f1840a;

        C1576a(C1710p<? super C1574d<R>> pVar) {
            this.f1840a = pVar;
        }

        /* renamed from: a */
        public void mo27336a(C1727b bVar) {
            this.f1840a.mo27336a(bVar);
        }

        /* renamed from: a */
        public void mo27337a(Object obj) {
            this.f1840a.mo27337a(C1574d.m2204a((Response) obj));
        }

        public void onComplete() {
            this.f1840a.onComplete();
        }

        public void onError(Throwable th) {
            try {
                this.f1840a.mo27337a(C1574d.m2203a(th));
                this.f1840a.onComplete();
            } catch (Throwable th2) {
                C1532a.m2139a(th2);
                C1682a.m2372a((Throwable) new C1730a(th, th2));
            }
        }
    }

    C1575e(C1706l<Response<T>> lVar) {
        this.f1839a = lVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super C1574d<T>> pVar) {
        this.f1839a.mo27427a(new C1576a(pVar));
    }
}
