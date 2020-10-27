package p078g.p079a.p080A.p081a;

import java.util.concurrent.atomic.AtomicReference;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p093B.C1682a;
import p078g.p079a.p098x.C1727b;
import p078g.p079a.p099y.C1736c;

/* renamed from: g.a.A.a.b */
public enum C1588b implements C1727b {
    DISPOSED;

    static {
        DISPOSED = new C1588b("DISPOSED", 0);
    }

    /* renamed from: a */
    public static boolean m2218a(C1727b bVar) {
        return bVar == DISPOSED;
    }

    /* renamed from: a */
    public static boolean m2219a(C1727b bVar, C1727b bVar2) {
        if (bVar2 == null) {
            C1682a.m2372a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.mo27341b();
            C1682a.m2372a((Throwable) new C1736c("Disposable already set!"));
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2220a(AtomicReference<C1727b> atomicReference) {
        C1727b andSet;
        C1727b bVar = atomicReference.get();
        C1588b bVar2 = DISPOSED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.mo27341b();
        return true;
    }

    /* renamed from: a */
    public static boolean m2221a(AtomicReference<C1727b> atomicReference, C1727b bVar) {
        C1727b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.mo27341b();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    /* renamed from: b */
    public static boolean m2222b(AtomicReference<C1727b> atomicReference, C1727b bVar) {
        C1727b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.mo27341b();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.mo27341b();
        return true;
    }

    /* renamed from: c */
    public static boolean m2223c(AtomicReference<C1727b> atomicReference, C1727b bVar) {
        C1599b.m2241a(bVar, "d is null");
        if (atomicReference.compareAndSet((Object) null, bVar)) {
            return true;
        }
        bVar.mo27341b();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        C1682a.m2372a((Throwable) new C1736c("Disposable already set!"));
        return false;
    }

    /* renamed from: a */
    public boolean mo27340a() {
        return true;
    }

    /* renamed from: b */
    public void mo27341b() {
    }
}
