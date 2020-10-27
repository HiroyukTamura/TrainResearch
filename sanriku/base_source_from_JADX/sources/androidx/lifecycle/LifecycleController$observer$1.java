package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C1111a0;
import p009e.p028d.p030b.p054b.C1532a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "<anonymous parameter 1>", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged"}, mo21740k = 3, mo21741mv = {1, 1, 15})
final class LifecycleController$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ C1111a0 $parentJob;
    final /* synthetic */ LifecycleController this$0;

    LifecycleController$observer$1(LifecycleController lifecycleController, C1111a0 a0Var) {
        this.this$0 = lifecycleController;
        this.$parentJob = a0Var;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, FirebaseAnalytics.Param.SOURCE);
        Intrinsics.checkParameterIsNotNull(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle, "source.lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            LifecycleController lifecycleController = this.this$0;
            C1532a.m2142a(this.$parentJob, (CancellationException) null, 1, (Object) null);
            lifecycleController.finish();
            return;
        }
        Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
        Intrinsics.checkExpressionValueIsNotNull(lifecycle2, "source.lifecycle");
        if (lifecycle2.getCurrentState().compareTo(this.this$0.minState) < 0) {
            this.this$0.dispatchQueue.pause();
        } else {
            this.this$0.dispatchQueue.resume();
        }
    }
}
