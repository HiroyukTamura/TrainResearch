package p043jp.reifrontier.gym.fragment.train;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.fragment.train.RFGSpotListFragment;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$setUpSpotList$1 */
final class RFGSpotListFragment$setUpSpotList$1 extends Lambda implements Function1<RFGSpot, Unit> {
    final /* synthetic */ RFGSpotListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGSpotListFragment$setUpSpotList$1(RFGSpotListFragment rFGSpotListFragment) {
        super(1);
        this.this$0 = rFGSpotListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RFGSpot) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RFGSpot rFGSpot) {
        Intrinsics.checkParameterIsNotNull(rFGSpot, "it");
        RFGAnalyticsManager.INSTANCE.sendEvent("300", "300c", String.valueOf(rFGSpot.getId()));
        RFGSpotListFragment.OnSpotListFragmentListener access$getFragmentListener$p = this.this$0.fragmentListener;
        if (access$getFragmentListener$p != null) {
            access$getFragmentListener$p.onSelectedSpot(rFGSpot);
        }
    }
}
