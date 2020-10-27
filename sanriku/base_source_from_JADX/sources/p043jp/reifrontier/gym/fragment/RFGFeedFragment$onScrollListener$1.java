package p043jp.reifrontier.gym.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.fragment.RFGFeedFragment;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo21739d2 = {"jp/reifrontier/gym/fragment/RFGFeedFragment$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.RFGFeedFragment$onScrollListener$1 */
public final class RFGFeedFragment$onScrollListener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ RFGFeedFragment this$0;

    RFGFeedFragment$onScrollListener$1(RFGFeedFragment rFGFeedFragment) {
        this.this$0 = rFGFeedFragment;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (!this.this$0.isRequesting && this.this$0.shouldLoadMore) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int childCount = linearLayoutManager.getChildCount();
                if (linearLayoutManager.findFirstVisibleItemPosition() + childCount >= linearLayoutManager.getItemCount()) {
                    this.this$0.isRequesting = true;
                    RFGFeedFragment.OnFeedFragmentListener access$getMListener$p = this.this$0.mListener;
                    if (access$getMListener$p == null) {
                        Intrinsics.throwNpe();
                    }
                    access$getMListener$p.loadFeedsMore();
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }
}
