package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.C2542c;
import kotlinx.coroutines.internal.C2562q;
import kotlinx.coroutines.p130u0.C2600h;
import kotlinx.coroutines.p130u0.C2601i;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.J */
public abstract class C2501J<T> extends C2600h {
    @JvmField

    /* renamed from: c */
    public int f4113c;

    public C2501J(int i) {
        this.f4113c = i;
    }

    /* renamed from: a */
    public <T> T mo35498a(Object obj) {
        return obj;
    }

    /* renamed from: a */
    public abstract Continuation<T> mo35490a();

    /* renamed from: a */
    public void mo35499a(Object obj, Throwable th) {
    }

    /* renamed from: a */
    public final void mo35500a(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            String str = "Fatal exception in coroutines machinery for " + this + ". " + "Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
            if (th == null) {
                Intrinsics.throwNpe();
            }
            C1532a.m2140a(mo35490a().getContext(), (Throwable) new C2495D(str, th));
        }
    }

    /* renamed from: b */
    public abstract Object mo35493b();

    public final void run() {
        Object obj;
        CoroutineContext context;
        Object b;
        Object a;
        Object obj2;
        C2601i iVar = this.f4266b;
        try {
            Continuation a2 = mo35490a();
            if (a2 != null) {
                C2498G g = (C2498G) a2;
                Continuation<T> continuation = g.f4109h;
                context = continuation.getContext();
                Object b2 = mo35493b();
                b = C2542c.m4423b(context, g.f4107f);
                C2579p pVar = (C2579p) (!(b2 instanceof C2579p) ? null : b2);
                Throwable th = pVar != null ? pVar.f4218a : null;
                C1111a0 a0Var = C2527d.m4384a(this.f4113c) ? (C1111a0) context.get(C1111a0.f916k) : null;
                if (th == null && a0Var != null && !a0Var.isActive()) {
                    Throwable h = a0Var.mo21833h();
                    mo35499a(b2, h);
                    Result.Companion companion = Result.Companion;
                    if (C2496E.m4308d()) {
                        if (continuation instanceof CoroutineStackFrame) {
                            h = C2562q.m4462a(h, (CoroutineStackFrame) continuation);
                        }
                    }
                    a = ResultKt.createFailure(h);
                } else if (th != null) {
                    Result.Companion companion2 = Result.Companion;
                    a = ResultKt.createFailure(th);
                } else {
                    a = mo35498a(b2);
                    Result.Companion companion3 = Result.Companion;
                }
                continuation.resumeWith(Result.m4628constructorimpl(a));
                Unit unit = Unit.INSTANCE;
                C2542c.m4422a(context, b);
                try {
                    Result.Companion companion4 = Result.Companion;
                    iVar.mo35622d();
                    obj2 = Result.m4628constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion5 = Result.Companion;
                    obj2 = Result.m4628constructorimpl(ResultKt.createFailure(th2));
                }
                mo35500a((Throwable) null, Result.m4631exceptionOrNullimpl(obj2));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        } catch (Throwable th3) {
            try {
                Result.Companion companion6 = Result.Companion;
                iVar.mo35622d();
                obj = Result.m4628constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion7 = Result.Companion;
                obj = Result.m4628constructorimpl(ResultKt.createFailure(th4));
            }
            mo35500a(th3, Result.m4631exceptionOrNullimpl(obj));
        }
    }
}
