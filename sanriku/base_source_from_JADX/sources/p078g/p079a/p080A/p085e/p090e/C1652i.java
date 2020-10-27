package p078g.p079a.p080A.p085e.p090e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.C1718v;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p085e.p090e.C1644e;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p100z.C1742e;

/* renamed from: g.a.A.e.e.i */
public final class C1652i<T, R> extends C1714r<R> {

    /* renamed from: a */
    final C1718v<? extends T>[] f1950a;

    /* renamed from: b */
    final C1742e<? super Object[], ? extends R> f1951b;

    /* renamed from: g.a.A.e.e.i$a */
    final class C1653a implements C1742e<T, R> {
        C1653a() {
        }

        public R apply(T t) throws Exception {
            R apply = C1652i.this.f1951b.apply(new Object[]{t});
            C1599b.m2241a(apply, "The zipper returned a null value");
            return apply;
        }
    }

    /* renamed from: g.a.A.e.e.i$b */
    static final class C1654b<T, R> extends AtomicInteger implements C1727b {

        /* renamed from: a */
        final C1716t<? super R> f1953a;

        /* renamed from: b */
        final C1742e<? super Object[], ? extends R> f1954b;

        /* renamed from: c */
        final C1655c<T>[] f1955c;

        /* renamed from: d */
        final Object[] f1956d;

        C1654b(C1716t<? super R> tVar, int i, C1742e<? super Object[], ? extends R> eVar) {
            super(i);
            this.f1953a = tVar;
            this.f1954b = eVar;
            C1655c<T>[] cVarArr = new C1655c[i];
            for (int i2 = 0; i2 < i; i2++) {
                cVarArr[i2] = new C1655c<>(this, i2);
            }
            this.f1955c = cVarArr;
            this.f1956d = new Object[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27384a(Throwable th, int i) {
            int i2 = 0;
            if (getAndSet(0) > 0) {
                C1655c<T>[] cVarArr = this.f1955c;
                int length = cVarArr.length;
                while (i2 < i) {
                    C1655c<T> cVar = cVarArr[i2];
                    if (cVar != null) {
                        C1588b.m2220a((AtomicReference<C1727b>) cVar);
                        i2++;
                    } else {
                        throw null;
                    }
                }
                while (true) {
                    i++;
                    if (i < length) {
                        C1655c<T> cVar2 = cVarArr[i];
                        if (cVar2 != null) {
                            C1588b.m2220a((AtomicReference<C1727b>) cVar2);
                        } else {
                            throw null;
                        }
                    } else {
                        this.f1953a.onError(th);
                        return;
                    }
                }
            } else {
                C1682a.m2372a(th);
            }
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return get() <= 0;
        }

        /* renamed from: b */
        public void mo27341b() {
            int i = 0;
            if (getAndSet(0) > 0) {
                C1655c<T>[] cVarArr = this.f1955c;
                int length = cVarArr.length;
                while (i < length) {
                    C1655c<T> cVar = cVarArr[i];
                    if (cVar != null) {
                        C1588b.m2220a((AtomicReference<C1727b>) cVar);
                        i++;
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    /* renamed from: g.a.A.e.e.i$c */
    static final class C1655c<T> extends AtomicReference<C1727b> implements C1716t<T> {

        /* renamed from: a */
        final C1654b<T, ?> f1957a;

        /* renamed from: b */
        final int f1958b;

        C1655c(C1654b<T, ?> bVar, int i) {
            this.f1957a = bVar;
            this.f1958b = i;
        }

        /* renamed from: a */
        public void mo27364a(C1727b bVar) {
            C1588b.m2223c(this, bVar);
        }

        public void onError(Throwable th) {
            this.f1957a.mo27384a(th, this.f1958b);
        }

        public void onSuccess(T t) {
            C1654b<T, ?> bVar = this.f1957a;
            bVar.f1956d[this.f1958b] = t;
            if (bVar.decrementAndGet() == 0) {
                try {
                    Object apply = bVar.f1954b.apply(bVar.f1956d);
                    C1599b.m2241a(apply, "The zipper returned a null value");
                    bVar.f1953a.onSuccess(apply);
                } catch (Throwable th) {
                    C1532a.m2139a(th);
                    bVar.f1953a.onError(th);
                }
            }
        }
    }

    public C1652i(C1718v<? extends T>[] vVarArr, C1742e<? super Object[], ? extends R> eVar) {
        this.f1950a = vVarArr;
        this.f1951b = eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27377b(C1716t<? super R> tVar) {
        C1718v<? extends T>[] vVarArr = this.f1950a;
        int length = vVarArr.length;
        int i = 0;
        if (length == 1) {
            vVarArr[0].mo27433a(new C1644e.C1645a(tVar, new C1653a()));
            return;
        }
        C1654b bVar = new C1654b(tVar, length, this.f1951b);
        tVar.mo27364a(bVar);
        while (i < length && !bVar.mo27340a()) {
            C1718v<? extends T> vVar = vVarArr[i];
            if (vVar == null) {
                bVar.mo27384a(new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                vVar.mo27433a(bVar.f1955c[i]);
                i++;
            }
        }
    }
}
