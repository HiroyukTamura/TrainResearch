package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.C2542c;
import kotlinx.coroutines.internal.C2561p;
import kotlinx.coroutines.internal.C2562q;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.d */
public final class C2527d {
    /* renamed from: a */
    public static /* synthetic */ C2577o m4381a(C1111a0 a0Var, int i) {
        if ((i & 1) != 0) {
            a0Var = null;
        }
        return new C2578o0(a0Var);
    }

    /* renamed from: a */
    public static final boolean m4384a(int i) {
        return i == 1;
    }

    /* renamed from: a */
    public static /* synthetic */ void m4382a(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C1111a0 a0Var = (C1111a0) coroutineContext.get(C1111a0.f916k);
        if (a0Var != null) {
            a0Var.mo21832a(cancellationException);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ C1111a0 m4380a(C2492B b, CoroutineContext coroutineContext, C2493C c, Function2 function2, int i, Object obj) {
        Object obj2;
        CoroutineContext context;
        Object b2;
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            c = C2493C.DEFAULT;
        }
        CoroutineContext a = C2606v.m4552a(b, coroutineContext);
        if (c != null) {
            C2519a h0Var = c == C2493C.LAZY ? new C2535h0(a, function2) : new C2576n0(a, true);
            h0Var.mo35529j();
            int ordinal = c.ordinal();
            if (ordinal == 0) {
                C1532a.m2141a(function2, h0Var, h0Var);
            } else if (ordinal != 1) {
                if (ordinal == 2) {
                    ContinuationKt.startCoroutine(function2, h0Var, h0Var);
                } else if (ordinal == 3) {
                    Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(h0Var);
                    try {
                        context = h0Var.getContext();
                        b2 = C2542c.m4423b(context, (Object) null);
                        if (function2 != null) {
                            obj2 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(h0Var, probeCoroutineCreated);
                            C2542c.m4422a(context, b2);
                            if (obj2 != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                Result.Companion companion = Result.Companion;
                                probeCoroutineCreated.resumeWith(Result.m4628constructorimpl(obj2));
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj2 = ResultKt.createFailure(th);
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return h0Var;
        }
        throw null;
    }

    /* renamed from: a */
    public static final <T> void m4383a(C2501J<? super T> j, Continuation<? super T> continuation, int i) {
        Object obj;
        Object b = j.mo35493b();
        Throwable th = null;
        C2579p pVar = (C2579p) (!(b instanceof C2579p) ? null : b);
        Throwable th2 = pVar != null ? pVar.f4218a : null;
        if (th2 != null) {
            if (C2496E.m4308d() && (continuation instanceof CoroutineStackFrame)) {
                th2 = C2562q.m4462a(th2, (CoroutineStackFrame) continuation);
            }
            th = th2;
        }
        if (th != null) {
            Result.Companion companion = Result.Companion;
            obj = ResultKt.createFailure(th);
        } else {
            Result.Companion companion2 = Result.Companion;
            obj = j.mo35498a(b);
        }
        Object r3 = Result.m4628constructorimpl(obj);
        if (i == 0) {
            continuation.resumeWith(r3);
        } else if (i == 1) {
            C2499H.m4321a(continuation, r3);
        } else if (i != 2) {
            throw new IllegalStateException(C0681a.m316a("Invalid mode ", i).toString());
        } else if (continuation != null) {
            C2498G g = (C2498G) continuation;
            CoroutineContext context = g.getContext();
            Object b2 = C2542c.m4423b(context, g.f4107f);
            try {
                g.f4109h.resumeWith(r3);
                Unit unit = Unit.INSTANCE;
            } finally {
                C2542c.m4422a(context, b2);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static final <T> Object m4379a(CoroutineContext coroutineContext, Function2<? super C2492B, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        C1111a0 a0Var = (C1111a0) plus.get(C1111a0.f916k);
        if (a0Var == null || a0Var.isActive()) {
            if (plus == context) {
                C2561p pVar = new C2561p(plus, continuation);
                obj = C1532a.m2127a(pVar, pVar, function2);
            } else if (Intrinsics.areEqual((Object) (ContinuationInterceptor) plus.get(ContinuationInterceptor.Key), (Object) (ContinuationInterceptor) context.get(ContinuationInterceptor.Key))) {
                C2586s0 s0Var = new C2586s0(plus, continuation);
                Object b = C2542c.m4423b(plus, (Object) null);
                try {
                    Object a = C1532a.m2127a(s0Var, s0Var, function2);
                    C2542c.m4422a(plus, b);
                    obj = a;
                } catch (Throwable th) {
                    C2542c.m4422a(plus, b);
                    throw th;
                }
            } else {
                C2500I i = new C2500I(plus, continuation);
                i.mo35529j();
                C1532a.m2141a(function2, i, i);
                obj = i.mo35497m();
            }
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return obj;
        }
        throw a0Var.mo21833h();
    }
}
