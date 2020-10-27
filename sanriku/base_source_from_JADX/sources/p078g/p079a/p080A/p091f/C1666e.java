package p078g.p079a.p080A.p091f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: g.a.A.f.e */
public final class C1666e extends AtomicLong implements ThreadFactory {

    /* renamed from: a */
    final String f1996a;

    /* renamed from: b */
    final int f1997b;

    /* renamed from: c */
    final boolean f1998c;

    /* renamed from: g.a.A.f.e$a */
    static final class C1667a extends Thread {
        C1667a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public C1666e(String str) {
        this.f1996a = str;
        this.f1997b = 5;
        this.f1998c = false;
    }

    public C1666e(String str, int i, boolean z) {
        this.f1996a = str;
        this.f1997b = i;
        this.f1998c = z;
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f1996a + '-' + incrementAndGet();
        Thread aVar = this.f1998c ? new C1667a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.f1997b);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        return C0681a.m324a(C0681a.m330a("RxThreadFactory["), this.f1996a, "]");
    }

    public C1666e(String str, int i) {
        this.f1996a = str;
        this.f1997b = i;
        this.f1998c = false;
    }
}
