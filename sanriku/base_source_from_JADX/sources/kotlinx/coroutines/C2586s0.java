package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C2542c;
import kotlinx.coroutines.internal.C2561p;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.s0 */
final class C2586s0<T> extends C2561p<T> {
    public C2586s0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo35496e(Object obj) {
        Object a = C1532a.m2126a(obj, this.f4203d);
        CoroutineContext context = this.f4203d.getContext();
        Object b = C2542c.m4423b(context, (Object) null);
        try {
            this.f4203d.resumeWith(a);
            Unit unit = Unit.INSTANCE;
        } finally {
            C2542c.m4422a(context, b);
        }
    }
}
