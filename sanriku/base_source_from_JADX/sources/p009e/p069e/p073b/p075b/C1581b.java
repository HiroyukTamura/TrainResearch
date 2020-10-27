package p009e.p069e.p073b.p075b;

import android.os.Looper;
import android.view.View;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p069e.p073b.p074a.C1579a;
import p078g.p079a.C1706l;
import p078g.p079a.C1710p;
import p078g.p079a.p096w.C1719a;
import p078g.p079a.p098x.C1727b;

/* renamed from: e.e.b.b.b */
final class C1581b extends C1706l<Object> {

    /* renamed from: a */
    private final View f1851a;

    /* renamed from: e.e.b.b.b$a */
    static final class C1582a extends C1719a implements View.OnClickListener {

        /* renamed from: b */
        private final View f1852b;

        /* renamed from: c */
        private final C1710p<? super Object> f1853c;

        C1582a(View view, C1710p<? super Object> pVar) {
            this.f1852b = view;
            this.f1853c = pVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo27345c() {
            this.f1852b.setOnClickListener((View.OnClickListener) null);
        }

        public void onClick(View view) {
            if (!mo27340a()) {
                this.f1853c.mo27337a(C1579a.INSTANCE);
            }
        }
    }

    C1581b(View view) {
        this.f1851a = view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27335b(C1710p<? super Object> pVar) {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            StringBuilder a = C0681a.m330a("Expected to be called on the main thread but was ");
            a.append(Thread.currentThread().getName());
            pVar.onError(new IllegalStateException(a.toString()));
            z = false;
        } else {
            z = true;
        }
        if (z) {
            C1582a aVar = new C1582a(this.f1851a, pVar);
            pVar.mo27336a((C1727b) aVar);
            this.f1851a.setOnClickListener(aVar);
        }
    }
}
