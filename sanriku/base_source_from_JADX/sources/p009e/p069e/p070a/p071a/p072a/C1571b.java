package p009e.p069e.p070a.p071a.p072a;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1706l;
import p078g.p079a.C1710p;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1730a;
import retrofit2.Call;
import retrofit2.Response;

/* renamed from: e.e.a.a.a.b */
final class C1571b<T> extends C1706l<Response<T>> {

    /* renamed from: a */
    private final Call<T> f1837a;

    /* renamed from: e.e.a.a.a.b$a */
    private static final class C1572a implements C1727b {

        /* renamed from: a */
        private final Call<?> f1838a;

        C1572a(Call<?> call) {
            this.f1838a = call;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f1838a.isCanceled();
        }

        /* renamed from: b */
        public void mo27341b() {
            this.f1838a.cancel();
        }
    }

    C1571b(Call<T> call) {
        this.f1837a = call;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super Response<T>> pVar) {
        boolean z;
        Call<T> clone = this.f1837a.clone();
        pVar.mo27336a((C1727b) new C1572a(clone));
        try {
            Response<T> execute = clone.execute();
            if (!clone.isCanceled()) {
                pVar.mo27337a(execute);
            }
            if (!clone.isCanceled()) {
                try {
                    pVar.onComplete();
                } catch (Throwable th) {
                    th = th;
                    z = true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            C1532a.m2139a(th);
            if (z) {
                C1682a.m2372a(th);
            } else if (!clone.isCanceled()) {
                try {
                    pVar.onError(th);
                } catch (Throwable th3) {
                    C1532a.m2139a(th3);
                    C1682a.m2372a((Throwable) new C1730a(th, th3));
                }
            }
        }
    }
}
