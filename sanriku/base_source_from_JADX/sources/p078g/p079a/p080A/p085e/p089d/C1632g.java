package p078g.p079a.p080A.p085e.p089d;

import java.util.NoSuchElementException;
import p078g.p079a.C1706l;
import p078g.p079a.C1709o;
import p078g.p079a.C1710p;
import p078g.p079a.C1714r;
import p078g.p079a.C1716t;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.d.g */
public final class C1632g<T> extends C1714r<T> {

    /* renamed from: a */
    final C1709o<? extends T> f1908a;

    /* renamed from: b */
    final T f1909b;

    /* renamed from: g.a.A.e.d.g$a */
    static final class C1633a<T> implements C1710p<T>, C1727b {

        /* renamed from: a */
        final C1716t<? super T> f1910a;

        /* renamed from: b */
        final T f1911b;

        /* renamed from: c */
        C1727b f1912c;

        /* renamed from: d */
        T f1913d;

        /* renamed from: e */
        boolean f1914e;

        C1633a(C1716t<? super T> tVar, T t) {
            this.f1910a = tVar;
            this.f1911b = t;
        }

        /* renamed from: a */
        public void mo27336a(C1727b bVar) {
            if (C1588b.m2219a(this.f1912c, bVar)) {
                this.f1912c = bVar;
                this.f1910a.mo27364a(this);
            }
        }

        /* renamed from: a */
        public void mo27337a(T t) {
            if (!this.f1914e) {
                if (this.f1913d != null) {
                    this.f1914e = true;
                    this.f1912c.mo27341b();
                    this.f1910a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f1913d = t;
            }
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return this.f1912c.mo27340a();
        }

        /* renamed from: b */
        public void mo27341b() {
            this.f1912c.mo27341b();
        }

        public void onComplete() {
            if (!this.f1914e) {
                this.f1914e = true;
                T t = this.f1913d;
                this.f1913d = null;
                if (t == null) {
                    t = this.f1911b;
                }
                if (t != null) {
                    this.f1910a.onSuccess(t);
                } else {
                    this.f1910a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f1914e) {
                C1682a.m2372a(th);
                return;
            }
            this.f1914e = true;
            this.f1910a.onError(th);
        }
    }

    public C1632g(C1709o<? extends T> oVar, T t) {
        this.f1908a = oVar;
        this.f1909b = t;
    }

    /* renamed from: b */
    public void mo27377b(C1716t<? super T> tVar) {
        ((C1706l) this.f1908a).mo27427a(new C1633a(tVar, this.f1909b));
    }
}
