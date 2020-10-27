package p078g.p079a.p080A.p085e.p090e;

import java.util.concurrent.Callable;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.p080A.p082b.C1592a;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p098x.C1728c;

/* renamed from: g.a.A.e.e.c */
public final class C1642c<T> extends C1714r<T> {

    /* renamed from: a */
    final Callable<? extends T> f1928a;

    public C1642c(Callable<? extends T> callable) {
        this.f1928a = callable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super T> tVar) {
        C1727b a = C1728c.m2443a(C1592a.f1864b);
        tVar.mo27364a(a);
        if (!a.mo27340a()) {
            try {
                Object call = this.f1928a.call();
                C1599b.m2241a(call, "The callable returned a null value");
                if (!a.mo27340a()) {
                    tVar.onSuccess(call);
                }
            } catch (Throwable th) {
                C1532a.m2139a(th);
                if (!a.mo27340a()) {
                    tVar.onError(th);
                } else {
                    C1682a.m2372a(th);
                }
            }
        }
    }
}
