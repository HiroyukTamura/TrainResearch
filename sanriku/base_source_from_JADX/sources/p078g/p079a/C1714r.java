package p078g.p079a;

import java.util.concurrent.Callable;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.p080A.p082b.C1592a;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p084d.C1604c;
import p078g.p079a.p080A.p085e.p090e.C1637a;
import p078g.p079a.p080A.p085e.p090e.C1639b;
import p078g.p079a.p080A.p085e.p090e.C1642c;
import p078g.p079a.p080A.p085e.p090e.C1643d;
import p078g.p079a.p080A.p085e.p090e.C1644e;
import p078g.p079a.p080A.p085e.p090e.C1646f;
import p078g.p079a.p080A.p085e.p090e.C1648g;
import p078g.p079a.p080A.p085e.p090e.C1650h;
import p078g.p079a.p080A.p085e.p090e.C1652i;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p100z.C1739b;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.r */
public abstract class C1714r<T> implements C1718v<T> {
    /* renamed from: a */
    public static <T> C1714r<T> m2410a(C1717u<T> uVar) {
        C1599b.m2241a(uVar, "source is null");
        return new C1637a(uVar);
    }

    /* renamed from: a */
    public static <T1, T2, R> C1714r<R> m2411a(C1718v<? extends T1> vVar, C1718v<? extends T2> vVar2, C1739b<? super T1, ? super T2, ? extends R> bVar) {
        C1599b.m2241a(vVar, "source1 is null");
        C1599b.m2241a(vVar2, "source2 is null");
        C1742e<Object[], ? extends R> a = C1592a.m2236a(bVar);
        C1718v[] vVarArr = {vVar, vVar2};
        C1599b.m2241a(a, "zipper is null");
        C1599b.m2241a(vVarArr, "sources is null");
        return new C1652i(vVarArr, a);
    }

    /* renamed from: a */
    public static <T> C1714r<T> m2412a(T t) {
        C1599b.m2241a(t, "item is null");
        return new C1643d(t);
    }

    /* renamed from: a */
    public static <T> C1714r<T> m2413a(Callable<? extends T> callable) {
        C1599b.m2241a(callable, "callable is null");
        return new C1642c(callable);
    }

    /* renamed from: a */
    public final C1714r<T> mo27429a(C1711q qVar) {
        C1599b.m2241a(qVar, "scheduler is null");
        return new C1646f(this, qVar);
    }

    /* renamed from: a */
    public final <R> C1714r<R> mo27430a(C1742e<? super T, ? extends C1718v<? extends R>> eVar) {
        C1599b.m2241a(eVar, "mapper is null");
        return new C1639b(this, eVar);
    }

    /* renamed from: a */
    public final C1727b mo27431a() {
        return mo27432a(C1592a.m2235a(), C1592a.f1867e);
    }

    /* renamed from: a */
    public final C1727b mo27432a(C1741d<? super T> dVar, C1741d<? super Throwable> dVar2) {
        C1599b.m2241a(dVar, "onSuccess is null");
        C1599b.m2241a(dVar2, "onError is null");
        C1604c cVar = new C1604c(dVar, dVar2);
        mo27433a(cVar);
        return cVar;
    }

    /* renamed from: a */
    public final void mo27433a(C1716t<? super T> tVar) {
        C1599b.m2241a(tVar, "observer is null");
        C1599b.m2241a(tVar, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            mo27377b(tVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C1532a.m2139a(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* renamed from: b */
    public final C1714r<T> mo27434b(C1711q qVar) {
        C1599b.m2241a(qVar, "scheduler is null");
        return new C1650h(this, qVar);
    }

    /* renamed from: b */
    public final <R> C1714r<R> mo27435b(C1742e<? super T, ? extends R> eVar) {
        C1599b.m2241a(eVar, "mapper is null");
        return new C1644e(this, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo27377b(C1716t<? super T> tVar);

    /* renamed from: c */
    public final C1714r<T> mo27436c(C1742e<Throwable, ? extends T> eVar) {
        C1599b.m2241a(eVar, "resumeFunction is null");
        return new C1648g(this, eVar, null);
    }
}
