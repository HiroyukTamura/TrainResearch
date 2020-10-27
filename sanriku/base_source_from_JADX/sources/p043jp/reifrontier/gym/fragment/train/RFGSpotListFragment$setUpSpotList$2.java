package p043jp.reifrontier.gym.fragment.train;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo21739d2 = {"jp/reifrontier/gym/fragment/train/RFGSpotListFragment$setUpSpotList$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGSpotListFragment$setUpSpotList$2 */
public final class RFGSpotListFragment$setUpSpotList$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ RFGSpotListFragment this$0;

    RFGSpotListFragment$setUpSpotList$2(RFGSpotListFragment rFGSpotListFragment) {
        this.this$0 = rFGSpotListFragment;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (!this.this$0.isLoading() && this.this$0.canLoadMoreSpot) {
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C2092R.C2094id.spotListView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "spotListView");
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Integer num = null;
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.getChildCount() >= linearLayoutManager.getItemCount()) {
                    RecyclerView recyclerView3 = (RecyclerView) this.this$0._$_findCachedViewById(C2092R.C2094id.spotListView);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView3, "spotListView");
                    Object tag = recyclerView3.getTag();
                    if (tag instanceof Integer) {
                        num = tag;
                    }
                    Integer num2 = num;
                    int intValue = num2 != null ? num2.intValue() : 0;
                    RecyclerView recyclerView4 = (RecyclerView) this.this$0._$_findCachedViewById(C2092R.C2094id.spotListView);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView4, "spotListView");
                    recyclerView4.setTag(Integer.valueOf(intValue + 1));
                    this.this$0.requestSpotList();
                }
            }
        }
    }
}
