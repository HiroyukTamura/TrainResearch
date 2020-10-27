package p043jp.reifrontier.gym.fragment.train;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "run"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$onCompletedRealtimeRequest$1 */
final class RFGScheduleMapFragment$onCompletedRealtimeRequest$1 implements Runnable {
    final /* synthetic */ RFGScheduleMapFragment this$0;

    RFGScheduleMapFragment$onCompletedRealtimeRequest$1(RFGScheduleMapFragment rFGScheduleMapFragment) {
        this.this$0 = rFGScheduleMapFragment;
    }

    public final void run() {
        this.this$0.startRequestRealtime();
    }
}
