package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.C2542c;
import kotlinx.coroutines.internal.C2563r;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.H */
public final class C2499H {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C2563r f4110a = new C2563r("UNDEFINED");
    @JvmField

    /* renamed from: b */
    public static final C2563r f4111b = new C2563r("REUSABLE_CLAIMED");

    /* renamed from: a */
    public static final <T> void m4321a(Continuation<? super T> continuation, Object obj) {
        boolean z;
        CoroutineContext context;
        Object b;
        if (continuation instanceof C2498G) {
            C2498G g = (C2498G) continuation;
            Object c = C1532a.m2148c(obj);
            if (g.f4108g.isDispatchNeeded(g.getContext())) {
                g.f4105d = c;
                g.f4113c = 1;
                g.f4108g.dispatch(g.getContext(), g);
                return;
            }
            C2582q0 q0Var = C2582q0.f4221b;
            C2504N a = C2582q0.m4503a();
            if (a.mo35507p()) {
                g.f4105d = c;
                g.f4113c = 1;
                a.mo35503a((C2501J<?>) g);
                return;
            }
            a.mo35505b(true);
            try {
                C1111a0 a0Var = (C1111a0) g.getContext().get(C1111a0.f916k);
                if (a0Var == null || a0Var.isActive()) {
                    z = false;
                } else {
                    CancellationException h = a0Var.mo21833h();
                    Result.Companion companion = Result.Companion;
                    g.resumeWith(Result.m4628constructorimpl(ResultKt.createFailure(h)));
                    z = true;
                }
                if (!z) {
                    context = g.getContext();
                    b = C2542c.m4423b(context, g.f4107f);
                    g.f4109h.resumeWith(obj);
                    Unit unit = Unit.INSTANCE;
                    C2542c.m4422a(context, b);
                }
                do {
                } while (a.mo35509r());
            } catch (Throwable th) {
                try {
                    g.mo35500a(th, (Throwable) null);
                } catch (Throwable th2) {
                    a.mo35504a(true);
                    throw th2;
                }
            }
            a.mo35504a(true);
            return;
        }
        continuation.resumeWith(obj);
    }
}
