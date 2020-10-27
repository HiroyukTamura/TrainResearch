package p078g.p079a;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.p080A.p082b.C1592a;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p085e.p087b.C1616c;
import p078g.p079a.p080A.p085e.p087b.C1617d;
import p078g.p079a.p080A.p085e.p087b.C1618e;
import p078g.p079a.p080A.p085e.p087b.C1619f;
import p078g.p079a.p080A.p085e.p087b.C1620g;
import p078g.p079a.p080A.p085e.p089d.C1623b;
import p078g.p079a.p093B.C1682a;

/* renamed from: g.a.l */
public abstract class C1706l<T> implements C1709o<T> {
    /* renamed from: a */
    public static <T> C1706l<T> m2396a(C1708n<T> nVar) {
        C1599b.m2241a(nVar, "source is null");
        return new C1623b(nVar);
    }

    /* renamed from: a */
    public final C1701g<T> mo27426a(C1695a aVar) {
        C1616c cVar = new C1616c(this);
        int ordinal = aVar.ordinal();
        if (ordinal == 0) {
            return cVar;
        }
        if (ordinal == 1) {
            return new C1619f(cVar);
        }
        if (ordinal == 3) {
            return new C1618e(cVar);
        }
        if (ordinal == 4) {
            return new C1620g(cVar);
        }
        int i = C1701g.f2055a;
        C1599b.m2238a(i, "capacity");
        return new C1617d(cVar, i, true, false, C1592a.f1865c);
    }

    /* renamed from: a */
    public final void mo27427a(C1710p<? super T> pVar) {
        C1599b.m2241a(pVar, "observer is null");
        try {
            C1599b.m2241a(pVar, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo27335b(pVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C1532a.m2139a(th);
            C1682a.m2372a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo27335b(C1710p<? super T> pVar);
}
