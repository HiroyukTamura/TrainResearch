package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: kotlinx.coroutines.h0 */
final class C2535h0 extends C2576n0 {

    /* renamed from: d */
    private final Continuation<Unit> f4157d;

    public C2535h0(CoroutineContext coroutineContext, Function2<? super C2492B, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f4157d = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo35530k() {
        try {
            Continuation<Unit> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.f4157d);
            Result.Companion companion = Result.Companion;
            C2499H.m4321a(intercepted, Result.m4628constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            resumeWith(Result.m4628constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
