package p078g.p079a;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p084d.C1603b;
import p078g.p079a.p080A.p084d.C1605d;
import p078g.p079a.p080A.p085e.p086a.C1607a;
import p078g.p079a.p080A.p085e.p086a.C1612d;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p100z.C1738a;

/* renamed from: g.a.b */
public abstract class C1696b {
    /* renamed from: a */
    public static C1696b m2386a(C1699e eVar) {
        C1599b.m2241a(eVar, "source is null");
        return new C1607a(eVar);
    }

    /* renamed from: a */
    public final C1696b mo27420a(C1711q qVar) {
        C1599b.m2241a(qVar, "scheduler is null");
        return new C1612d(this, qVar);
    }

    /* renamed from: a */
    public final C1727b mo27421a() {
        C1605d dVar = new C1605d();
        mo27423a((C1698d) dVar);
        return dVar;
    }

    /* renamed from: a */
    public final C1727b mo27422a(C1738a aVar) {
        C1599b.m2241a(aVar, "onComplete is null");
        C1603b bVar = new C1603b(aVar);
        mo27423a((C1698d) bVar);
        return bVar;
    }

    /* renamed from: a */
    public final void mo27423a(C1698d dVar) {
        C1599b.m2241a(dVar, "observer is null");
        try {
            C1599b.m2241a(dVar, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo27367b(dVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C1532a.m2139a(th);
            C1682a.m2372a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo27367b(C1698d dVar);
}
