package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo21739d2 = {"<anonymous>", "", "run", "androidx/lifecycle/DispatchQueue$runOrEnqueue$1$1"}, mo21740k = 3, mo21741mv = {1, 1, 15})
final class DispatchQueue$runOrEnqueue$$inlined$with$lambda$1 implements Runnable {
    final /* synthetic */ Runnable $runnable$inlined;
    final /* synthetic */ DispatchQueue this$0;

    DispatchQueue$runOrEnqueue$$inlined$with$lambda$1(DispatchQueue dispatchQueue, Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$runnable$inlined = runnable;
    }

    public final void run() {
        this.this$0.enqueue(this.$runnable$inlined);
    }
}
