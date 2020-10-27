package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C2561p;

/* renamed from: kotlinx.coroutines.I */
final class C2500I<T> extends C2561p<T> {

    /* renamed from: e */
    private static final AtomicIntegerFieldUpdater f4112e = AtomicIntegerFieldUpdater.newUpdater(C2500I.class, "_decision");
    private volatile int _decision = 0;

    public C2500I(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo21838a(Object obj) {
        mo35496e(obj);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo35496e(java.lang.Object r5) {
        /*
            r4 = this;
        L_0x0000:
            int r0 = r4._decision
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            if (r0 != r2) goto L_0x0009
            goto L_0x001f
        L_0x0009:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0015:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4112e
            r3 = 2
            boolean r0 = r0.compareAndSet(r4, r1, r3)
            if (r0 == 0) goto L_0x0000
            r1 = 1
        L_0x001f:
            if (r1 == 0) goto L_0x0022
            return
        L_0x0022:
            kotlin.coroutines.Continuation<T> r0 = r4.f4203d
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            kotlin.coroutines.Continuation<T> r1 = r4.f4203d
            java.lang.Object r5 = p009e.p028d.p030b.p054b.C1532a.m2126a((java.lang.Object) r5, r1)
            kotlinx.coroutines.C2499H.m4321a(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2500I.mo35496e(java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object mo35497m() {
        /*
            r3 = this;
        L_0x0000:
            int r0 = r3._decision
            r1 = 0
            if (r0 == 0) goto L_0x0015
            r2 = 2
            if (r0 != r2) goto L_0x0009
            goto L_0x001f
        L_0x0009:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Already suspended"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0015:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f4112e
            r2 = 1
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 == 0) goto L_0x0000
            r1 = 1
        L_0x001f:
            if (r1 == 0) goto L_0x0026
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            return r0
        L_0x0026:
            java.lang.Object r0 = r3.mo21851e()
            java.lang.Object r0 = kotlinx.coroutines.C2533g0.m4406b(r0)
            boolean r1 = r0 instanceof kotlinx.coroutines.C2579p
            if (r1 != 0) goto L_0x0033
            return r0
        L_0x0033:
            kotlinx.coroutines.p r0 = (kotlinx.coroutines.C2579p) r0
            java.lang.Throwable r0 = r0.f4218a
            goto L_0x0039
        L_0x0038:
            throw r0
        L_0x0039:
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2500I.mo35497m():java.lang.Object");
    }
}
