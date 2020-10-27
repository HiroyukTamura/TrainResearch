package p078g.p079a.p098x;

import p009e.p010a.p011a.p012a.C0681a;
import p078g.p079a.p080A.p082b.C1599b;

/* renamed from: g.a.x.d */
final class C1729d extends C1729d<Runnable> implements C1727b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1729d(Runnable runnable) {
        super(runnable);
        C1599b.m2241a(runnable, "value is null");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [g.a.x.d, java.util.concurrent.atomic.AtomicReference] */
    /* renamed from: a */
    public final boolean mo27340a() {
        return get() == null;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [g.a.x.d, java.util.concurrent.atomic.AtomicReference] */
    /* renamed from: b */
    public final void mo27341b() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            ((Runnable) andSet).run();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [g.a.x.d, java.util.concurrent.atomic.AtomicReference] */
    public String toString() {
        StringBuilder a = C0681a.m330a("RunnableDisposable(disposed=");
        a.append(mo27340a());
        a.append(", ");
        a.append(get());
        a.append(")");
        return a.toString();
    }
}
