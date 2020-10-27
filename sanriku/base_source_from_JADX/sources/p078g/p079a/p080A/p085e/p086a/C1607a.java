package p078g.p079a.p080A.p085e.p086a;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1698d;
import p078g.p079a.C1699e;
import p078g.p079a.p080A.p081a.C1588b;
import p078g.p079a.p098x.C1727b;

/* renamed from: g.a.A.e.a.a */
public final class C1607a extends C1696b {

    /* renamed from: a */
    final C1699e f1881a;

    /* renamed from: g.a.A.e.a.a$a */
    static final class C1608a extends AtomicReference<C1727b> implements C1697c, C1727b {

        /* renamed from: a */
        final C1698d f1882a;

        C1608a(C1698d dVar) {
            this.f1882a = dVar;
        }

        /* renamed from: a */
        public boolean mo27340a() {
            return C1588b.m2218a((C1727b) get());
        }

        /* renamed from: b */
        public void mo27341b() {
            C1588b.m2220a((AtomicReference<C1727b>) this);
        }

        public void onComplete() {
            C1727b bVar;
            Object obj = get();
            C1588b bVar2 = C1588b.DISPOSED;
            if (obj != bVar2 && (bVar = (C1727b) getAndSet(bVar2)) != C1588b.DISPOSED) {
                try {
                    this.f1882a.onComplete();
                } finally {
                    if (bVar != null) {
                        bVar.mo27341b();
                    }
                }
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{C1608a.class.getSimpleName(), super.toString()});
        }
    }

    public C1607a(C1699e eVar) {
        this.f1881a = eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27367b(C1698d dVar) {
        boolean z;
        C1727b bVar;
        C1608a aVar = new C1608a(dVar);
        dVar.mo27361a(aVar);
        try {
            this.f1881a.subscribe(aVar);
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.mo27341b();
            }
            throw th;
        }
    }
}
