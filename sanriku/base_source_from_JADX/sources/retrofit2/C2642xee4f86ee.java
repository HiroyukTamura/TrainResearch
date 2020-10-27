package retrofit2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo21739d2 = {"<anonymous>", "", "run", "retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, mo21740k = 3, mo21741mv = {1, 1, 15})
/* renamed from: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 */
final class C2642xee4f86ee implements Runnable {
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ Exception $this_suspendAndThrow$inlined;

    C2642xee4f86ee(Continuation continuation, Exception exc) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow$inlined = exc;
    }

    public final void run() {
        Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.$continuation);
        Exception exc = this.$this_suspendAndThrow$inlined;
        Result.Companion companion = Result.Companion;
        intercepted.resumeWith(Result.m4628constructorimpl(ResultKt.createFailure(exc)));
    }
}
