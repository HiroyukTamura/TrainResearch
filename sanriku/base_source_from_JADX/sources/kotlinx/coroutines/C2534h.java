package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: kotlinx.coroutines.h */
public final class C2534h extends C2579p {

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f4156c = AtomicIntegerFieldUpdater.newUpdater(C2534h.class, "_resumed");
    private volatile int _resumed;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2534h(kotlin.coroutines.Continuation<?> r3, java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0003
            goto L_0x001e
        L_0x0003:
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L_0x001e:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2534h.<init>(kotlin.coroutines.Continuation, java.lang.Throwable, boolean):void");
    }

    /* renamed from: c */
    public final boolean mo35549c() {
        return f4156c.compareAndSet(this, 0, 1);
    }
}
