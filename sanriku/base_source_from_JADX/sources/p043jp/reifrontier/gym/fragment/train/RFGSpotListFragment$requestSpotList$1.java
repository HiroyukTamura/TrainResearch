package p043jp.reifrontier.gym.fragment.train;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.p044ui.adapter.RFGSpotListAdapter;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, mo21739d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$requestSpotList$1 */
final class RFGSpotListFragment$requestSpotList$1<T> implements C1741d<Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<? extends RFGSpot>>> {
    final /* synthetic */ RFGSpotListFragment this$0;

    RFGSpotListFragment$requestSpotList$1(RFGSpotListFragment rFGSpotListFragment) {
        this.this$0 = rFGSpotListFragment;
    }

    public final void accept(Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<RFGSpot>> pair) {
        RFGRailroadClient.RailroadApiResult railroadApiResult = (RFGRailroadClient.RailroadApiResult) pair.component1();
        List list = (List) pair.component2();
        if (railroadApiResult == RFGRailroadClient.RailroadApiResult.SUCCESS) {
            this.this$0.canLoadMoreSpot = list.size() >= 10;
            this.this$0.spotList.addAll(list);
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C2092R.C2094id.spotListView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "spotListView");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (!(adapter instanceof RFGSpotListAdapter)) {
                adapter = null;
            }
            RFGSpotListAdapter rFGSpotListAdapter = (RFGSpotListAdapter) adapter;
            if (rFGSpotListAdapter != null) {
                rFGSpotListAdapter.addData(list);
            }
        }
        this.this$0.stopLoading();
    }
}
