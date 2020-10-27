package p078g.p079a.p095D;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1710p;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.D.a */
public final class C1692a<T> extends C1694b<T> {

    /* renamed from: c */
    static final C1693a[] f2043c = new C1693a[0];

    /* renamed from: d */
    static final C1693a[] f2044d = new C1693a[0];

    /* renamed from: a */
    final AtomicReference<C1693a<T>[]> f2045a = new AtomicReference<>(f2044d);

    /* renamed from: b */
    Throwable f2046b;

    /* renamed from: g.a.D.a$a */
    static final class C1693a<T> extends AtomicBoolean implements C1727b {

        /* renamed from: a */
        final C1710p<? super T> f2047a;

        /* renamed from: b */
        final C1692a<T> f2048b;

        C1693a(C1710p<? super T> pVar, C1692a<T> aVar) {
            this.f2047a = pVar;
            this.f2048b = aVar;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return get();
        }

        /* renamed from: b */
        public void mo27341b() {
            if (compareAndSet(false, true)) {
                this.f2048b.mo27419a(this);
            }
        }
    }

    C1692a() {
    }

    /* renamed from: a */
    public static <T> C1692a<T> m2379a() {
        return new C1692a<>();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27419a(C1693a<T> aVar) {
        C1693a<T>[] aVarArr;
        C1693a[] aVarArr2;
        do {
            aVarArr = (C1693a[]) this.f2045a.get();
            if (aVarArr != f2043c && aVarArr != f2044d) {
                int length = aVarArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        aVarArr2 = f2044d;
                    } else {
                        C1693a[] aVarArr3 = new C1693a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f2045a.compareAndSet(aVarArr, aVarArr2));
    }

    /* renamed from: a */
    public void mo27336a(C1727b bVar) {
        if (this.f2045a.get() == f2043c) {
            bVar.mo27341b();
        }
    }

    /* renamed from: a */
    public void mo27337a(T t) {
        C1599b.m2241a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (C1693a aVar : (C1693a[]) this.f2045a.get()) {
            if (!aVar.get()) {
                aVar.f2047a.mo27337a(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super T> pVar) {
        boolean z;
        C1693a aVar = new C1693a(pVar, this);
        pVar.mo27336a((C1727b) aVar);
        while (true) {
            C1693a[] aVarArr = (C1693a[]) this.f2045a.get();
            z = false;
            if (aVarArr != f2043c) {
                int length = aVarArr.length;
                C1693a[] aVarArr2 = new C1693a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.f2045a.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Throwable th = this.f2046b;
            if (th != null) {
                pVar.onError(th);
            } else {
                pVar.onComplete();
            }
        } else if (aVar.get()) {
            mo27419a(aVar);
        }
    }

    public void onComplete() {
        C1693a<T>[] aVarArr = this.f2045a.get();
        C1693a<T>[] aVarArr2 = f2043c;
        if (aVarArr != aVarArr2) {
            for (C1693a aVar : (C1693a[]) this.f2045a.getAndSet(aVarArr2)) {
                if (!aVar.get()) {
                    aVar.f2047a.onComplete();
                }
            }
        }
    }

    public void onError(Throwable th) {
        C1599b.m2241a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        C1693a<T>[] aVarArr = this.f2045a.get();
        C1693a<T>[] aVarArr2 = f2043c;
        if (aVarArr == aVarArr2) {
            C1682a.m2372a(th);
            return;
        }
        this.f2046b = th;
        for (C1693a aVar : (C1693a[]) this.f2045a.getAndSet(aVarArr2)) {
            if (aVar.get()) {
                C1682a.m2372a(th);
            } else {
                aVar.f2047a.onError(th);
            }
        }
    }
}
