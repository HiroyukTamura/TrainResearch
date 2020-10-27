package p078g.p079a.p080A.p085e.p086a;

import p009e.p028d.p030b.p054b.C1532a;
import p078g.p079a.C1696b;
import p078g.p079a.C1698d;
import p078g.p079a.p080A.p082b.C1592a;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p098x.C1728c;

/* renamed from: g.a.A.e.a.b */
public final class C1609b extends C1696b {

    /* renamed from: a */
    final Runnable f1883a;

    public C1609b(Runnable runnable) {
        this.f1883a = runnable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27367b(C1698d dVar) {
        C1727b a = C1728c.m2443a(C1592a.f1864b);
        dVar.mo27361a(a);
        try {
            this.f1883a.run();
            if (!a.mo27340a()) {
                dVar.onComplete();
            }
        } catch (Throwable th) {
            C1532a.m2139a(th);
            if (!a.mo27340a()) {
                dVar.onError(th);
            } else {
                C1682a.m2372a(th);
            }
        }
    }
}
