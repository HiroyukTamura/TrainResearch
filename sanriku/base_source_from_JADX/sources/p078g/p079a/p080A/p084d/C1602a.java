package p078g.p079a.p080A.p084d;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1710p;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p080A.p083c.C1601a;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.d.a */
public abstract class C1602a<T, R> implements C1710p<T>, C1601a<R> {

    /* renamed from: a */
    protected final C1710p<? super R> f1870a;

    /* renamed from: b */
    protected C1727b f1871b;

    /* renamed from: c */
    protected boolean f1872c;

    public C1602a(C1710p<? super R> pVar) {
        this.f1870a = pVar;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [g.a.A.d.a, g.a.x.b] */
    /* renamed from: a */
    public final void mo27336a(C1727b bVar) {
        if (C1588b.m2219a(this.f1871b, bVar)) {
            this.f1871b = bVar;
            if (bVar instanceof C1601a) {
                C1601a aVar = (C1601a) bVar;
            }
            this.f1870a.mo27336a((C1727b) this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo27358a(Throwable th) {
        C1532a.m2139a(th);
        this.f1871b.mo27341b();
        onError(th);
    }

    /* renamed from: a */
    public boolean mo27359a() {
        return this.f1871b.mo27340a();
    }

    /* renamed from: b */
    public void mo27360b() {
        this.f1871b.mo27341b();
    }

    public void onComplete() {
        if (!this.f1872c) {
            this.f1872c = true;
            this.f1870a.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.f1872c) {
            C1682a.m2372a(th);
            return;
        }
        this.f1872c = true;
        this.f1870a.onError(th);
    }
}
