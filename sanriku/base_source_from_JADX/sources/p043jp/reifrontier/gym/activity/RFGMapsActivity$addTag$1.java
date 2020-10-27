package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "run"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMapsActivity$addTag$1 */
final class RFGMapsActivity$addTag$1 implements Runnable {
    final /* synthetic */ int $startTime;
    final /* synthetic */ RFGMapsActivity this$0;

    RFGMapsActivity$addTag$1(RFGMapsActivity rFGMapsActivity, int i) {
        this.this$0 = rFGMapsActivity;
        this.$startTime = i;
    }

    public final void run() {
        this.this$0.loadDaily(this.$startTime);
    }
}
