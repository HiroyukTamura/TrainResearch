package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* renamed from: kotlinx.coroutines.r0 */
public final class C2584r0 extends C1120x {

    /* renamed from: a */
    public static final C2584r0 f4224a = new C2584r0();

    private C2584r0() {
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (((C2588t0) coroutineContext.get(C2588t0.f4225a)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    public String toString() {
        return "Unconfined";
    }
}
