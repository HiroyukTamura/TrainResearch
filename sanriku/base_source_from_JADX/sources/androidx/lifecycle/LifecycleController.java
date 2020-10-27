package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C1111a0;
import p009e.p028d.p030b.p054b.C1532a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo21739d2 = {"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "finish", "", "handleDestroy", "lifecycle-runtime-ktx_release"}, mo21740k = 1, mo21741mv = {1, 1, 15})
@MainThread
public final class LifecycleController {
    /* access modifiers changed from: private */
    public final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    /* access modifiers changed from: private */
    public final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State state, DispatchQueue dispatchQueue2, C1111a0 a0Var) {
        Intrinsics.checkParameterIsNotNull(lifecycle2, "lifecycle");
        Intrinsics.checkParameterIsNotNull(state, "minState");
        Intrinsics.checkParameterIsNotNull(dispatchQueue2, "dispatchQueue");
        Intrinsics.checkParameterIsNotNull(a0Var, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        this.observer = new LifecycleController$observer$1(this, a0Var);
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            C1532a.m2142a(a0Var, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        this.lifecycle.addObserver(this.observer);
    }

    /* access modifiers changed from: private */
    public final void handleDestroy(C1111a0 a0Var) {
        C1532a.m2142a(a0Var, (CancellationException) null, 1, (Object) null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
