package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\b\u001a3\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u001a\b\u0004\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\t\u0012\u0004\u0012\u00020\u00070\u000fHHø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\t\"\u0004\b\u0000\u0010\u000e*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a]\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\t\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u000e*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u0002H\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a>\u0010\u0018\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u000e*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aW\u0010\u0018\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u000e*#\b\u0001\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014¢\u0006\u0002\b\u00152\u0006\u0010\u0016\u001a\u0002H\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u000e0\tH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u001b\u0010\u0000\u001a\u00020\u00018Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\t¨\u0006\u001b"}, mo21739d2 = {"coroutineContext", "Lkotlin/coroutines/experimental/CoroutineContext;", "coroutineContext$annotations", "()V", "getCoroutineContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "processBareContinuationResume", "", "completion", "Lkotlin/coroutines/experimental/Continuation;", "block", "Lkotlin/Function0;", "", "suspendCoroutine", "T", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "kotlin-stdlib-coroutines"}, mo21740k = 2, mo21741mv = {1, 1, 16})
@JvmName(name = "CoroutinesKt")
public final class CoroutinesKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void coroutineContext$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "$this$createCoroutine");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        return new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function1, continuation), IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED());
    }

    @SinceKotlin(version = "1.1")
    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "$this$createCoroutine");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        return new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function2, r, continuation), IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED());
    }

    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @InlineOnly
    private static final void processBareContinuationResume(Continuation<?> continuation, Function0<? extends Object> function0) {
        try {
            Object invoke = function0.invoke();
            if (invoke == IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED()) {
                return;
            }
            if (continuation != null) {
                continuation.resume(invoke);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    @SinceKotlin(version = "1.1")
    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "$this$startCoroutine");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function1, continuation).resume(Unit.INSTANCE);
    }

    @SinceKotlin(version = "1.1")
    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "$this$startCoroutine");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnchecked(function2, r, continuation).resume(Unit.INSTANCE);
    }

    @SinceKotlin(version = "1.1")
    public static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(continuation));
        function1.invoke(safeContinuation);
        return safeContinuation.getResult();
    }

    @SinceKotlin(version = "1.1")
    private static final Object suspendCoroutine$$forInline(Function1 function1, Continuation continuation) {
        InlineMarker.mark(0);
        SafeContinuation safeContinuation = new SafeContinuation(CoroutineIntrinsics.normalizeContinuation(continuation));
        function1.invoke(safeContinuation);
        Object result = safeContinuation.getResult();
        InlineMarker.mark(1);
        return result;
    }
}
